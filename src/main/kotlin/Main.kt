
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
        println("2: Delete graph")
        println("3: Search value in graph")
        println("4: Exit")

        val choice: Int = Integer.valueOf(readln())
        when (choice) {
            1 -> {
                appGraph.adjMat.printMatrix()
            }
            2 -> {

            }
            3 -> {

            }
            4 -> {
                println("Goodbye!")
                exitProcess(0)
            }
            else -> println("Choose an available option!")
        }
    }
}
