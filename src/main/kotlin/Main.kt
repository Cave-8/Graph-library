
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
        val vertices: ArrayList<Vertex> = JSONParser.allVertices()
        val edges: ArrayList<Edge> = JSONParser.allEdges()
        val adjMat = AdjacencyMatrix(vertices, edges)
        adjMat.fillMatrix()

        appGraph = Graph(vertices, edges, adjMat)
    }
    else {
        val vertices: ArrayList<Vertex> = JSONParser.allVertices(path)
        val edges: ArrayList<Edge> = JSONParser.allEdges(path)
        val adjMat = AdjacencyMatrix(vertices, edges)
        adjMat.fillMatrix()

        appGraph = Graph(vertices, edges, adjMat)
    }

    while (true) {
        println("Available options: ")
        println("1: Print graph in matrix form")
        println("2: Print graph in list form")
        println("3: Add vertex")
        println("4: Add edge")
        println("5: Find if two vertices are connected")
        println("6: Find shortest path between two vertices")
        println("7: Find if an eulerian path exists and eventually print it")
        println("8: Exit")

        when (Integer.valueOf(readln())) {
            1 -> {
                appGraph.adjMat.printGraph(1)
            }
            2 -> {
                appGraph.adjMat.printGraph(2)
            }
            3 -> {
                appGraph.addVertex(path)
            }
            4 -> {
                appGraph.addEdge(path)
            }
            5 -> {
                try {
                    println("Insert id of starting vertex")
                    println(">")
                    val firstId = Integer.valueOf(readln())
                    println("Insert id of ending vertex")
                    println(">")
                    val secondId = Integer.valueOf(readln())

                    appGraph.adjacent(firstId, secondId)
                }
                catch (e: NumberFormatException)
                {
                    println("Please insert a valid number")
                }
            }
            6 -> {

            }
            7 -> {
                appGraph.eulerianPath()
            }
            8 -> {
                println("Goodbye!")
                exitProcess(0)
            }
            else -> println("Choose an available option!")
        }
    }
}