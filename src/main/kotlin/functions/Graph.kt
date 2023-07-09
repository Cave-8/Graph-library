package functions

import jsonWritersAndParsers.JSONWriter
import nodeAndEdges.Edge
import nodeAndEdges.Vertex
import java.util.*

/**
 * Graph utilities
 */
class Graph(private val vertices: ArrayList<Vertex>, private val edges: ArrayList<Edge>, var adjMat: AdjacencyMatrix) : GraphFunctions {

    /**
     * Check if two vertices are connected
     * @param firstVertexId is the first vertex id
     * @param secondVertexId is the second vertex id
     * @return true if and only if the two vertices exists and are connected
     */
    override fun adjacent(firstVertexId: Int, secondVertexId: Int): Boolean {

        if (!vertices.map { e -> e.id }.contains(firstVertexId)) {
            println("First vertex doesn't exist")
            return false
        }
        if (!vertices.map { e -> e.id }.contains(secondVertexId)) {
            println("Second vertex doesn't exist")
            return false
        }

        var safeFirstVertexId = firstVertexId
        var safeSecondVertexId = secondVertexId

        if (firstVertexId == 0) {
            safeFirstVertexId = vertices.size }
        if (secondVertexId == 0) {
            safeSecondVertexId = vertices.size }


        return if (adjMat.matrix[safeFirstVertexId, safeSecondVertexId] != -1) {
            println("vertices are connected with weight ${adjMat.matrix[safeFirstVertexId, safeSecondVertexId]}")
            true
        } else {
            println("vertices are not connected")
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

            if (vertices.map{e -> e.id}.contains(id)) {
                println("Vertex already exists")
            }
            else
            {
                vertices.add(vertex)
                JSONWriter.addVertex(vertex, path)
                adjMat = AdjacencyMatrix(vertices, edges)
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

            if (!vertices.map{e -> e.id}.contains(idS)) {
                println("Vertex doesn't exists")
                return false
            }

            println("Insert id of endingVertex (must be a number)")
            println(">")
            idE = readln().toInt()

            if (!vertices.map{e -> e.id}.contains(idE)) {
                println("Vertex doesn't exists")
                return false
            }

            if (edges.firstOrNull { e -> e.startingVertexId == idS && e.endingVertexId == idE } != null) {
                println("These vertices are already connected")
                return false
            }

            println("Insert weight")
            println(">")
            weight = readln().toInt()

            val edge = Edge(idS, idE, weight)

            edges.add(edge)
            JSONWriter.addEdge(edge, path)
            adjMat = AdjacencyMatrix(vertices, edges)
            adjMat.fillMatrix()
            println("Insertion complete!")
        } catch (e: NumberFormatException)
        {
            println("Please insert a valid number")
            return false
        }
        return true
    }

    /**
     * Check if an eulerian path exists and eventually print it
     * @return true if eulerian path exists, otherwise it returns false
     */
    override fun eulerianPath(): Boolean {
        class VertexEnteringExiting(val id: Int, var ent: Int, var exit: Int) {
        }

        val list = Stack<VertexEnteringExiting>()

        for (v in vertices) {
            val newVEE = VertexEnteringExiting(v.id, 0, 0)
            list.push(newVEE)
        }

        var i = 1
        var j = 1

        while (i < vertices.size + 1)
        {
            while (j < vertices.size + 1) {
                if (adjMat.matrix[i, j] != -1) {
                    list.filter { e -> e.id == adjMat.matrix[i, 0]  }.first().exit++
                    list.filter { e -> e.id == adjMat.matrix[0, j]  }.first().ent++
                }
                j++
            }
            j = 1
            i++
        }

        if (list.count { e -> e.ent - e.exit == 0 } == vertices.size)
        {
            println("An eulerian path exists, I.E.")

            val tPath = Stack<Int>()
            val ePath = Stack<Int>()
            val allvertices = ArrayList<Int> ()
            val matrix = adjMat.matrix

            for (vee in list) {
                val outgoing = vee.exit
                var count = 0
                while (count < outgoing) {
                    allvertices.add(vee.id)
                    count++
                }
            }

            tPath.push(allvertices.removeAt(0))
            Hierholzer(tPath, ePath, matrix, allvertices)
        }
        else if (list.count { e -> e.ent - e.exit == 1 } == 1 && list.count { e -> e.ent - e.exit == -1 } == 1)
        {
            println("An eulerian path exists, I.E.")

            val tPath = Stack<Int>()
            val ePath = Stack<Int>()
            val allvertices = ArrayList<Int> ()
            val matrix = adjMat.matrix

            for (vee in list) {
                val outgoing = vee.exit
                var count = 0
                while (count < outgoing) {
                    allvertices.add(vee.id)
                    count++
                }
            }
            tPath.push(allvertices.removeAt(allvertices.indexOf(list.filter{e -> e.ent - e.exit == -1}.map { e -> e.id }.first())))
            Hierholzer(tPath, ePath, matrix, allvertices)
        }
        else
            println("An eulerian path doesn't exist")

        return true
    }

    /**
     * Hierholzer's algorithm
     * @param tPath
     * @param ePath
     * @param matrix is adjacency matrix
     * @param allvertices contains id of vertices
     */
    fun Hierholzer (tPath: Stack<Int>, ePath: Stack<Int>, matrix: Matrix, allvertices: ArrayList<Int>) {
        while (tPath.isNotEmpty()) {
            val curr = tPath.peek()
            var row = 1
            var col = 1

            while (row < vertices.size + 1) {
                if (matrix[row, 0] == curr)
                    break
                row++
            }

            while (col < vertices.size + 1) {
                if (matrix[row, col] != -1) {
                    matrix[row, col] = -1
                    tPath.push(matrix[0, col])
                    try {allvertices.removeAt(allvertices.indexOf(matrix[0, col]))} catch (_: IndexOutOfBoundsException) {}
                    break
                }
                if (col == vertices.size) {
                    ePath.push(tPath.pop())
                }
                col++
            }
        }

        print("${ePath.peek()} -> ")
        ePath.pop()
        while (ePath.isNotEmpty()) {
            print("${ePath.peek()}")
            ePath.pop()
            if (ePath.isNotEmpty()) {
                print(" -> ")
            }
            else
                println()
        }
    }

    /**
     * Print shortest path between two vertices
     * @param startingVertexId is id of starting vertex
     * @param endingVertexId is id of ending vertex
     */
    override fun shortestPath(startingVertexId: Int, endingVertexId: Int) {
        TODO("Not yet implemented")
    }
}