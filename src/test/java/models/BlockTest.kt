package models

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BlockTest {
    @Test
    fun `it should be a data class`() {
        // Given
        val index = 1
        val previousHash = 1
        val timestamp = 1
        val data = 1
        val hash = 1

        // When
        val block = Block(index, previousHash, timestamp, data, hash)

        // Then
        Assertions.assertEquals(index, block.index)
        Assertions.assertEquals(previousHash, block.previousHash)
        Assertions.assertEquals(timestamp, block.timestamp)
        Assertions.assertEquals(data, block.data)
        Assertions.assertEquals(hash, block.hash)
    }
}