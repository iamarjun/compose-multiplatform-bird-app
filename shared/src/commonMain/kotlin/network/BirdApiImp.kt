package network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import model.Bird

class BirdApiImp(private val httpClient: HttpClient) : BirdApi {
    override suspend fun getBirdsList(): List<Bird> {
        return httpClient
            .get("https://sebi.io/demo-image-api/pictures.json")
            .body<List<Bird>>()
    }
}