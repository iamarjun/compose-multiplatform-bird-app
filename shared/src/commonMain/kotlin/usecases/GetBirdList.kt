package usecases

import model.Bird
import network.BirdApiImp

class GetBirdList(
    private val birdApi: BirdApiImp
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