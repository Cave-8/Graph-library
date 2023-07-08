
import functions.AdjacencyMatrix
import functions.Graph
import jsonWritersAndParsers.JSONParser
import nodeAndEdges.Edge
import nodeAndEdges.Vertex
import kotlin.system.exitProcess

/**
 * Main function
 */
fun main() {

    /**
     * Main graph
     */
    val appGraph: Graph

    println("Welcome to graph lib!")
    println("Insert path of file or leave empty to read from example")

    val path: String = readln()
    if (path == "")
    {
        val vertexes: ArrayList<Vertex> = JSONParser.allVertexes()
        val edges: ArrayList<Edge> = JSONParser.allEdges()
        val adjMat = AdjacencyMatrix(vertexes, edges)
        adjMat.fillMatrix()

        appGraph = Graph(vertexes, edges, adjMat)
    }
    else {
        val vertexes: ArrayList<Vertex> = JSONParser.allVertexes(path)
        val edges: ArrayList<Edge> = JSONParser.allEdges(path)
        val adjMat = AdjacencyMatrix(vertexes, edges)
        adjMat.fillMatrix()

        appGraph = Graph(vertexes, edges, adjMat)
    }

    while (true) {
        println("Available options: ")
        println("1: Print graph")
        println("2: Add vertex")
        println("3: Add edge")
        println("4: Find shortest path between two vertexes")
        println("5: Exit")

        val choice: Int = Integer.valueOf(readln())
        when (choice) {
            1 -> {
                appGraph.adjMat.printMatrix()
            }
            2 -> {
                appGraph.addVertex(path)
            }
            3 -> {
                appGraph.addEdge(path)
            }
            4 -> {

            }
            5 -> {
                println("Goodbye!")
                exitProcess(0)
            }
            else -> println("Choose an available option!")
        }
    }
}