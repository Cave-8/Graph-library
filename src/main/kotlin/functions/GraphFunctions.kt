package functions

import nodeAndEdges.Node

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
        firstVertex: Node,
        secondVertex: Node,
    )

    /**
     * Add vertex to graph
     * @param vertex is vertex to add
     * @return true if operation was successful
     */
    fun addVertex (
        vertex: Node,
    )

    /**
     * Add vertex to remove
     * @param vertex is vertex to add
     * @return true if operation was successful
     */
    fun removeVertex (
        vertex: Node
    )

    fun addEdge (

    )

    fun removeEdge (

    )
}