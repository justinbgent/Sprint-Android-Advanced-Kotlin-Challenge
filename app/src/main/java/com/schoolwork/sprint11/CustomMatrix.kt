package com.schoolwork.sprint11

// TODO: Refactor

class CustomMatrix(width: Int, height: Int) {
    var initialMatrix = Array(width){IntArray(height)}
}

operator fun MatrixCustom.times(matrixC: MatrixCustom): IntArray{
    val columnSize = matrix.size
    val rowSize = matrix[0].size

    val matrix1 = matrixC.matrix

    var results = arrayListOf<Int>()

    for (i in 0 until columnSize){
        for (j in 0 until rowSize){
            val product = matrix[i][j] * matrix1[i][j]
            results.add(product)
        }
    }


    var info = IntArray(4)
    for (i in 0 until results.size){
        info[i] = results[i]
    }

    return info

//    return MatrixCustom(arrayOf(intArrayOf(results[0], results[1]),
//        intArrayOf(results[2], results[3])))

    //return Array<IntArray>
}

data class MatrixCustom(var matrix: Array<IntArray>) {

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