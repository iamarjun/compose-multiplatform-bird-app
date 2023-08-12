package network

import model.Bird

interface BirdApi {
    suspend fun getBirdsList() : List<Bird>
}