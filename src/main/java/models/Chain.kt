package models

class Chain(val blocks: MutableList<Block> = mutableListOf()) {
    fun add(block: Block) {
        blocks.add(block)
    }

    fun add(blockData: Int) {
        val previousBlock = blocks.lastOrNull()
        val nextIndex = if(previousBlock == null) 1 else previousBlock.index + 1
        val nextTimestamp = System.currentTimeMillis() / 1000
        blocks.add(Block(nextIndex, previousBlock?.hash ?: "", nextTimestamp, blockData))
    }
}