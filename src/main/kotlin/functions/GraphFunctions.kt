package functions

import nodeAndEdges.Vertex

/**
 * Shows available methods for graphs
 */
interface GraphFunctions {

    /**
     * Check if two vertexes exist and are connected
     * @param firstVertex is the first vertex
     * @param secondVertex is the second vertex
     * @return true if and only if the two vertexes exist and are connected
     */
    fun adjacent(
        firstVertex: Vertex,
        secondVertex: Vertex,
    )

    /**
     * Add vertex to graph
     * @param vertex is vertex to add
     * @return true if operation was successful
     */
    fun addVertex (
        vertex: Vertex,
    )

    /**
     * Add vertex to remove
     * @param vertex is vertex to add
     * @return true if operation was successful
     */
    fun removeVertex (
        vertex: Vertex
    )

    fun addEdge (

    )

    fun removeEdge (

    )
}