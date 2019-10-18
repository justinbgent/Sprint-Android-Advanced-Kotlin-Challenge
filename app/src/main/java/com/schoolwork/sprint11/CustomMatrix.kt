package com.schoolwork.sprint11

class CustomMatrix(width: Int, height: Int) {
    var initialMatrix = Array(width){IntArray(height)}
}

data class MatrixCustom(var matrix: Array<IntArray>) {
    operator fun times(matrix1: Array<IntArray>){
        val columnSize = matrix.size
        val rowSize = matrix[0].size

        val columnSize1 = matrix1.size
        val rowSize1 = matrix1[0].size

        var results = arrayListOf<Int>()

        for (i in 0 until columnSize){
            for (j in 0 until rowSize){
                val product = matrix[i][j] * matrix1[i][j]
                results.add(product)
            }
        }

        arrayOf(intArrayOf(4, 4),
            intArrayOf(2, 4))

        //return Array<IntArray>
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MatrixCustom

        if (!matrix.contentDeepEquals(other.matrix)) return false

        return true
    }

    override fun hashCode(): Int {
        return matrix.contentDeepHashCode()
    }
}