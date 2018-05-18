package models

data class Block(val index: Int, val previousHash: Int, val timestamp: Int, val data: Int, val hash: Int)