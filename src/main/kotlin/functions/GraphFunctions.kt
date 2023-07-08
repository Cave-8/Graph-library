package functions

import nodeAndEdges.Vertex

/**
 * Shows available methods for graphs
 */
interface GraphFunctions {

    /**
     * Check if two vertexes are connected
     * @param firstVertex is the first vertex
     * @param secondVertex is the second vertex
     * @return true if and only if the two vertexes exists and are connected
     */
    fun adjacent(
        firstVertex: Vertex,
        secondVertex: Vertex,
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
     * @param startingVertex is starting vertex
     * @param path is file path
     * @return true if operation was successful
     */
    fun addEdge (
        path: String
    ): Boolean
}