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
     * @param vertex is vertex to add
     * @return true if operation was successful
     */
    fun addVertex (
        vertex: Vertex,
    ): Boolean

    /**
     * Remove vertex from graph
     * @param vertex is vertex to add
     * @return true if operation was successful
     */
    fun removeVertex (
        vertex: Vertex
    ): Boolean

    /**
     * Add edge to graph
     * @param startingVertex is starting vertex
     * @param endingVertex is ending vertex
     * @param weight is edge's weight
     * @return true if operation was successful
     */
    fun addEdge (
        startingVertex: Vertex,
        endingVertex: Vertex,
        weight: Int,
    ): Boolean

    /**
     * Add edge to graph
     * @param startingVertex is starting vertex
     * @param endingVertex is ending vertex
     * @return true if operation was successful
     */
    fun removeEdge (
        startingVertex: Vertex,
        endingVertex: Vertex,
    ): Boolean
}