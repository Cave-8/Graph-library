package functions

import nodeAndEdges.Edge
import nodeAndEdges.Vertex

/**
 * Contains matrix, first row and column contain indices and every Matrix[i,j] contains weight of arch connecting i -> j, if it doesn't exist -1 is shown
 */
class AdjacencyMatrix(var Vertexes: ArrayList<Vertex>, var Edges: ArrayList<Edge>) {

    var matrix = Matrix(Vertexes.size + 1, Vertexes.size + 1)

    /**
     * Fill Matrix with Vertexes and Edges lists
     */
    fun fillMatrix () {
        var i: Int = 0
        var j: Int = 0

        //Filling first row
        while (j < Vertexes.size) {
            if (j != 0) {
                matrix[0, j] = Vertexes[j].id
            }
            j++
        }

        //Filling first column
        while (i < Vertexes.size) {
            if (i != 0) {
                matrix[i, 0] = Vertexes[i].id
            }
            i++
        }

        i = 0
        j = 0

        while (i < Vertexes.size + 1) {
            while (j < Vertexes.size + 1) {

                if (i != 0 && j != 0) {
                    val edge = Edges.firstOrNull { e -> e.startingVertexId == matrix[i, 0] && e.endingVertexId == matrix[0, j] }

                    if (edge != null)
                        matrix[i, j] = edge.weight
                    else
                        matrix[i, j] = -1

                }
                j++
            }
            j = 0
            i++
        }
    }

    /**
     * Print Matrix
     */
    fun printMatrix() {

        var i: Int = 0
        var j: Int = 0

        while (i < Vertexes.size + 1) {
            while (j < Vertexes.size + 1) {

                if (i == 0 && j == 0) {
                    print("X   ")
                }
                else
                {
                    if (matrix[i, j] != -1)
                        print("${matrix[i, j]}   ")
                    else
                        print("-   ")
                }
                j++
            }
            print("\n\n")
            j = 0
            i++
        }
    }

}