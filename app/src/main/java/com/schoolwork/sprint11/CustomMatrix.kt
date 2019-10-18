package com.schoolwork.sprint11

class CustomMatrix(width: Int, height: Int) {
    var initialMatrix = Array(width){IntArray(height)}

    operator fun times(matrix: Array<IntArray>){
        val columnSize = matrix.size
        val rowSize = matrix[0].size

        for (i in 0 until columnSize){
            for (j in 0 until rowSize){
                matrix[i][j]
            }
        }

        arrayOf(intArrayOf(4, 4),
            intArrayOf(2, 4))

        //return Array<IntArray>
    }

    fun Array<IntArray>.multiply(matrix: Array<IntArray>){
        this
    }
}