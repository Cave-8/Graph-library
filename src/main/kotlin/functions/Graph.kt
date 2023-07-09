package functions

import jsonWritersAndParsers.JSONWriter
import nodeAndEdges.Edge
import nodeAndEdges.Vertex

/**
 * Graph utilities
 */
class Graph(private val vertexes: ArrayList<Vertex>, private val edges: ArrayList<Edge>, var adjMat: AdjacencyMatrix) : GraphFunctions {

    /**
     * Check if two vertexes are connected
     * @param firstVertexId is the first vertex id
     * @param secondVertexId is the second vertex id
     * @return true if and only if the two vertexes exists and are connected
     */
    override fun adjacent(firstVertexId: Int, secondVertexId: Int): Boolean {

        if (vertexes.map { e -> e.id }.contains(firstVertexId)) {
            println("First vertex doesn't exist")
            return false
        }
        if (vertexes.map { e -> e.id }.contains(secondVertexId)) {
            println("Second vertex doesn't exist")
            return false
        }

        return if (adjMat.matrix[firstVertexId, secondVertexId] != -1) {
            println("Vertexes are connected with weight ${adjMat.matrix[firstVertexId, secondVertexId]}")
            true
        } else {
            println("Vertexes are not connected")
            false
        }
    }

    /**
     * Add vertex to graph and refresh adjacency matrix
     * @param path is file path
     * @return true if operation was successful, otherwise it returns false
     */
    override fun addVertex(path: String): Boolean {
        val id: Int
        try {
            println("Insert id for vertex (must be a number)")
            println(">")
            id = readln().toInt()
            val vertex = Vertex(id)

            if (vertexes.map{e -> e.id}.contains(id)) {
                println("Vertex already exists")
            }
            else
            {
                vertexes.add(vertex)
                JSONWriter.addVertex(vertex, path)
                adjMat = AdjacencyMatrix(vertexes, edges)
                adjMat.fillMatrix()
                println("Insertion complete!")
            }
        } catch (e: NumberFormatException)
        {
            println("Please insert a valid number")
            return false
        }
        return true
    }

    /**
     * Add edge to graph and refresh adjacency matrix
     * @param path is file path
     * @return true if operation was successful
     */
    override fun addEdge(path: String): Boolean {
        val idS: Int
        val idE: Int
        val weight: Int

        try {
            println("Insert id for startingVertex (must be a number)")
            println(">")
            idS = readln().toInt()

            if (!vertexes.map{e -> e.id}.contains(idS)) {
                println("Vertex doesn't exists")
                return false
            }

            println("Insert id of endingVertex (must be a number)")
            println(">")
            idE = readln().toInt()

            if (!vertexes.map{e -> e.id}.contains(idE)) {
                println("Vertex doesn't exists")
                return false
            }

            if (edges.firstOrNull { e -> e.startingVertexId == idS && e.endingVertexId == idE } != null) {
                println("These vertexes are already connected")
                return false
            }

            println("Insert weight")
            println(">")
            weight = readln().toInt()

            val edge = Edge(idS, idE, weight)

            edges.add(edge)
            JSONWriter.addEdge(edge, path)
            adjMat = AdjacencyMatrix(vertexes, edges)
            adjMat.fillMatrix()
            println("Insertion complete!")
        } catch (e: NumberFormatException)
        {
            println("Please insert a valid number")
            return false
        }
        return true
    }
}