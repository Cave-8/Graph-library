package functions

/**
 * Shows available methods for graphs
 */
interface GraphFunctions {

    /**
     * Check if two vertexes are connected
     * @param firstVertexId is the first vertex id
     * @param secondVertexId is the second vertex id
     * @return true if and only if the two vertexes exists and are connected
     */
    fun adjacent(
        firstVertexId: Int,
        secondVertexId: Int,
    ): Boolean

    /**
     * Add vertex to graph
     * @param path is file path
     * @return true if operation was successful
     */
    fun addVertex (
        path: String
    ): Boolean

    /**
     * Add edge to graph
     * @param path is file path
     * @return true if operation was successful
     */
    fun addEdge (
        path: String
    ): Boolean

    /**
     * Check if an eulerian path exists and eventually print it
     * @return true if eulerian path exists, otherwise it returns false
     */
    fun eulerianPath (): Boolean

    /**
     * Print shortest path between two vertexes
     * @param startingVertexId is id of starting vertex
     * @param endingVertexId is id of ending vertex
     */
    fun shortestPath(
        startingVertexId: Int,
        endingVertexId: Int
    )
}