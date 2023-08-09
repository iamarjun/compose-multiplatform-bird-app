package usecases

import model.Bird
import network.BirdApi

class GetBirdList(
    private val birdApi: BirdApi
) {
    suspend operator fun invoke(): Result<List<Bird>> {
        return try {
            val list = birdApi.getBirdsList()
            Result.success(list)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}