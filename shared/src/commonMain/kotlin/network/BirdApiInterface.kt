package network

import model.Bird

interface BirdApiInterface {
    suspend fun getBirdsList() : List<Bird>
}