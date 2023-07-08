package functions

import jsonWritersAndParsers.JSONWriter
import nodeAndEdges.Edge
import nodeAndEdges.Vertex

/**
 * Graph utilities
 */
class Graph(val vertexes: ArrayList<Vertex>, val edges: ArrayList<Edge>, var adjMat: AdjacencyMatrix) : GraphFunctions {

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
     * Add edge to graph
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

            println("Insert weight")
            println(">")
            weight = readln().toInt()

            val edge = Edge(idS, idE, weight)

            edges.add(edge)
            JSONWriter.addEdge(edge, path)
            println("Insertion complete!")
        } catch (e: NumberFormatException)
        {
            println("Please insert a valid number")
            return false
        }
        return true
    }
}