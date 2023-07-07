package functions

import nodeAndEdges.Edge
import nodeAndEdges.Vertex

/**
 * Graph utilities
 */
class Graph(val vertexes: ArrayList<Vertex>, val edges: ArrayList<Edge>, val adjMat: AdjacencyMatrix) : GraphFunctions {

    /**
     * Check if two vertexes are connected
     * @param firstVertex is the first vertex
     * @param secondVertex is the second vertex
     * @return true if and only if the two vertexes exists and are connected
     */
    override fun adjacent(firstVertex: Vertex, secondVertex: Vertex): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * Add vertex to graph
     * @param vertex is vertex to add
     * @return true if operation was successful
     */
    override fun addVertex(vertex: Vertex): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * Remove vertex from graph
     * @param vertex is vertex to add
     * @return true if operation was successful
     */
    override fun removeVertex(vertex: Vertex): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * Add edge to graph
     * @param startingVertex is starting vertex
     * @param endingVertex is ending vertex
     * @param weight is edge's weight
     * @return true if operation was successful
     */
    override fun addEdge(startingVertex: Vertex, endingVertex: Vertex, weight: Int): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * Add edge to graph
     * @param startingVertex is starting vertex
     * @param endingVertex is ending vertex
     * @return true if operation was successful
     */
    override fun removeEdge(startingVertex: Vertex, endingVertex: Vertex): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * Build adjacency matrix
     */
    fun buildGraph() {

    }
}