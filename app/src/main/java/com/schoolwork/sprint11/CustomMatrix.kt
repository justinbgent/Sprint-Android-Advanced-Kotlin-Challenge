package com.schoolwork.sprint11

// TODO: Refactor

data class MatrixCustom(var width: Int, var height: Int) {
    var matrix: Array<IntArray> = Array(width){IntArray(height)}
}

operator fun MatrixCustom.times(matrixC: MatrixCustom): IntArray{
    val columnSize = matrix.size
    val rowSize = matrix[0].size

    val matrix1 = matrixC.matrix

    val product = Array(2){IntArray(2)}
    for (i in 0 until columnSize){
        for (j in 0 until rowSize){
            for (k in 0 until columnSize){
                product[j][i] += matrix[k][i] * matrix1[j][k]
            }
        }
    }

    var info = IntArray(4)

    info[0] = product[0][0]
    info[1] = product[1][0]
    info[2] = product[0][1]
    info[3] = product[1][1]

    return info
}