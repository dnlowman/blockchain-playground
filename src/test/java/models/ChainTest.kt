package models

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ChainTest {
    @Test
    fun `it should have a constructor which accepts a MutableList of Blocks`() {
        // Given
        val index = 1
        val previousHash = "test"
        val timestamp = 1L
        val data = 1
        val block = Block(index, previousHash, timestamp, data)
        val blocks = mutableListOf(block)

        // When
        val chain = Chain(blocks)

        // Then
        Assertions.assertEquals(blocks, chain.blocks)
    }

    @Test
    fun `it should have an add function which adds a Block`() {
        // Given
        val chain = Chain()
        val index = 1
        val previousHash = "test"
        val timestamp = 1L
        val data = 1
        val block = Block(index, previousHash, timestamp, data)

        // When
        chain.add(block)

        // Then
        Assertions.assertEquals(1, chain.blocks.size)
        Assertions.assertEquals(index, chain.blocks.first().index)
        Assertions.assertEquals(previousHash, chain.blocks.first().previousHash)
        Assertions.assertEquals(timestamp, chain.blocks.first().timestamp)
        Assertions.assertEquals(data, chain.blocks.first().data)
    }

    @Test
    fun `it should have an add function which adds a new Block with the provided data`() {
        // Given
        val chain = Chain()
        chain.add(1)

        // When
        chain.add(1)

        // Then
        Assertions.assertEquals(2, chain.blocks.size)
        Assertions.assertEquals(chain.blocks.first().index + 1, chain.blocks.last().index)
        Assertions.assertEquals(chain.blocks.first().hash, chain.blocks.last().previousHash)
    }
}