package com.example.planetsapptraining.repositories

import com.example.planetsapptraining.domain.Planet
import com.example.planetsapptraining.repositories.database.PlanetDao
import com.example.planetsapptraining.repositories.database.PlanetEntity
import com.example.planetsapptraining.repositories.dto.PlanetDetailResponse
import com.example.planetsapptraining.repositories.dto.PlanetResponse
import com.example.planetsapptraining.repositories.retrofit.PlanetService
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import kotlin.random.Random

@ExperimentalCoroutinesApi
class PlanetRepositoryImplTest {

    private lateinit var repository: PlanetRepositoryImpl
    private lateinit var service: PlanetService
    private lateinit var dao: PlanetDao
    private val testDispatcher = TestCoroutineDispatcher()
    private val planetAmount = 3
    private val incompleteInfoPlanet = Planet("name", "short desc", "imageURL.com", 1, 1.0)
    private val completeInfoPlanet =
        Planet("name", "short desc", "imageURL.com", 3, 1.0, "description", "planet type", 1.0)

    @Before
    fun setUp() {
        service = mockk {
            coEvery { getPlanetList() } returns (1..planetAmount).map { mockkClass(PlanetResponse::class) }
            coEvery { getPlanetDetail(1) } returns mockkClass(PlanetDetailResponse::class) {
                every { mapToDomain() } returns completeInfoPlanet
            }
            coEvery { getPlanetDetail(2) } returns mockkClass(PlanetDetailResponse::class) {
                every { mapToDomain() } returns completeInfoPlanet.copy(id = 2)
            }
            coEvery { getPlanetDetail(3) } throws Exception("Planet not found")
        }
        dao = mockk(relaxed = true) {
            coEvery { getAll() } returns (1..planetAmount).map {
                mockkClass(PlanetEntity::class) {
                    val randomId = Random(99).nextInt()
                    every { mapToDomain() } returns incompleteInfoPlanet.copy(id = randomId)
                }
            }
            coEvery { findById(1) } returns mockkClass(PlanetEntity::class) {
                every { mapToDomain() } returns incompleteInfoPlanet
            }
            coEvery { findById(2) } returns null
            coEvery { findById(3) } returns mockkClass(PlanetEntity::class) {
                every { mapToDomain() } returns completeInfoPlanet
            }
        }
        repository = PlanetRepositoryImpl(service, dao, testDispatcher)
    }

    @Test
    fun retrievePlanetListFromRepository() = testDispatcher.runBlockingTest {
        val planets = repository.getPlanetList()
        assertEquals(planetAmount, planets.size)
    }

    @Test
    fun retrievePlanetDetailFromRepositoryWithIncompleteItemInDb() =
        testDispatcher.runBlockingTest {
            repository.getPlanetDetail(1)!!
            coVerify { service.getPlanetDetail(1) }
        }

    @Test
    fun retrievePlanetDetailFromRepositoryWithMissingItemInDb() = testDispatcher.runBlockingTest {
        repository.getPlanetDetail(2)!!
        coVerify { service.getPlanetDetail(2) }
    }

    @Test
    fun retrievePlanetDetailFromRepositoryWithItemInDb() = testDispatcher.runBlockingTest {
        repository.getPlanetDetail(3)!!
        coVerify { dao.findById(3) }
        coVerify(exactly = 0) { service.getPlanetDetail(3) }
    }
}