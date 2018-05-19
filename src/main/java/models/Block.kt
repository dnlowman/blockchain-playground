package models

import java.security.MessageDigest

class Block(val index: Int, val previousHash: String, val timestamp: Long, val data: Int) {
    val hash = generateHash(this)

    fun isValid(previousBlock: Block): Boolean {
        return when {
            previousBlock.index + 1 != index -> false
            previousBlock.hash != previousHash -> false
            generateHash(this) != hash -> false
            else -> true
        }
    }

    private fun generateHash(block: Block): String {
        val HEX_CHARS = "0123456789ABCDEF"
        val input = (block.index.toString() +
                block.previousHash +
                block.timestamp.toString() +
                block.data.toString())
        val md = MessageDigest
            .getInstance("SHA-256")
            .digest(input.toByteArray())
        val result = StringBuilder(md.size * 2)
        md.forEach {
            val i = it.toInt()
            result.append(HEX_CHARS[i shr 4 and 0x0f])
            result.append(HEX_CHARS[i and 0x0f])
        }
        return result.toString()
    }
}
