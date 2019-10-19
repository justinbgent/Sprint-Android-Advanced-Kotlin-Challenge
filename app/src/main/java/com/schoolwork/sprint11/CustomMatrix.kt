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

    val product = Array(2){IntArray(2)}
    for (i in 0 until columnSize){
        for (j in 0 until rowSize){
            for (k in 0 until columnSize){
                if (j == 0){
                    product[j][i] += matrix[k][i] * matrix1[i][k]
                }
                else{
                    product[j][i] += matrix[k][i] * matrix1[i][k]
                }
//                val product = matrix[k][i] * matrix1[i][k]
//                results.add(product)
            }
        }
    }

    var info = IntArray(4)

    info[0] = results[0] + results[1]
    info[1] = results[2] + results[3]
    info[2] = results[4] + results[5]
    info[3] = results[6] + results[7]

    return info
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