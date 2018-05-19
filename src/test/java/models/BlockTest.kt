package models

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BlockTest {
    @Test
    fun `it should have a constructor which accepts index, previousHash, timestamp, data and hash`() {
        // Given
        val index = 1
        val previousHash = "test"
        val timestamp = 1L
        val data = 1

        // When
        val block = Block(index, previousHash, timestamp, data)

        // Then
        Assertions.assertEquals(index, block.index)
        Assertions.assertEquals(previousHash, block.previousHash)
        Assertions.assertEquals(timestamp, block.timestamp)
        Assertions.assertEquals(data, block.data)
    }

    @Test
    fun `it should have a constructor which accepts index, previousHash, timestamp and data`() {
        // Given
        val index = 1
        val previousHash = "test"
        val timestamp = 1L
        val data = 1

        // When
        val block = Block(index, previousHash, timestamp, data)

        // Then
        Assertions.assertEquals(index, block.index)
        Assertions.assertEquals(previousHash, block.previousHash)
        Assertions.assertEquals(timestamp, block.timestamp)
        Assertions.assertEquals(data, block.data)
    }

    @Test
    fun `it should have a function isValid which returns true if the block is valid`() {
        // Given
        val previousBlock = Block(1, "test", 1L, 1)
        val currentBlock = Block(2, previousBlock.hash, 1L, 1)

        // When
        val result = currentBlock.isValid(previousBlock)

        // Then
        Assertions.assertTrue(result)
    }

    @Test
    fun `it should have a function isValid which returns false if the block has an invalid index`() {
        // Given
        val previousBlock = Block(1, "test", 1L, 1)
        val currentBlock = Block(1, previousBlock.hash, 1L, 1)

        // When
        val result = currentBlock.isValid(previousBlock)

        // Then
        Assertions.assertFalse(result)
    }

    @Test
    fun `it should have a function isValid which returns false if the block has an invalid previous hash`() {
        // Given
        val previousBlock = Block(1, "test", 1L, 1)
        val currentBlock = Block(2, "invalid", 1L, 1)

        // When
        val result = currentBlock.isValid(previousBlock)

        // Then
        Assertions.assertFalse(result)
    }
}