package functions

class Matrix (val row: Int, val col: Int) {

    /**
     * Get value for i row and j column
     */
    operator fun get(i: Int, j: Int): Int {
        return matrix[i][j]
    }

    /**
     * Set value (k) for i row and j column
     */
    operator fun set(i: Int, j: Int, k: Int) {
        matrix[i][j] = k
    }

    var matrix = Array(row) {IntArray(col)}
}