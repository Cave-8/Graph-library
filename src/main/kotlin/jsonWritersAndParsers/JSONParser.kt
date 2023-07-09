package jsonWritersAndParsers

import com.google.gson.*
import nodeAndEdges.Edge
import nodeAndEdges.Vertex
import java.io.File
import java.io.FileNotFoundException
import kotlin.system.exitProcess

class JSONParser {

    companion object {

        /**
         * Return an ArrayList containing all vertices
         * @return ArrayList containing all vertices
         */
        fun allVertices(): ArrayList<Vertex> {
            val jsonInput = this::class.java.classLoader.getResource("graph.json")?.readText()
            val jsonObject: JsonObject = JsonParser.parseString(jsonInput) as JsonObject
            val verticesList: JsonArray = jsonObject.getAsJsonArray("verticesList")
            val verticesListToReturn: ArrayList<Vertex> = arrayListOf()

            for (vl in verticesList) {
                val vertex: Vertex = Gson().fromJson(vl, Vertex::class.java)
                verticesListToReturn.add(vertex)
            }

            return verticesListToReturn
        }

        /**
         * Return an ArrayList containing all vertices (from path)
         * @return ArrayList containing all vertices
         */
        fun allVertices(path: String): ArrayList<Vertex> {
            try {
                val jsonInput = File(path).readText()
                val jsonObject: JsonObject = JsonParser.parseString(jsonInput) as JsonObject
                val verticesList: JsonArray = jsonObject.getAsJsonArray("verticesList")
                val verticesListToReturn: ArrayList<Vertex> = arrayListOf()

                for (vl in verticesList) {
                    val gson = GsonBuilder().setLenient().create()
                    val vertex: Vertex = gson.fromJson(vl, Vertex::class.java)
                    verticesListToReturn.add(vertex)
                }

                return verticesListToReturn
            } catch (e: FileNotFoundException) {
                println("File not found, relaunch and retry")
                exitProcess(-1)
            }
        }

        /**
         * Return an ArrayList containing all edges
         * @return ArrayList containing all edges
         */
        fun allEdges(): ArrayList<Edge> {
            val jsonInput = this::class.java.classLoader.getResource("graph.json")?.readText()
            val jsonObject: JsonObject = JsonParser.parseString(jsonInput) as JsonObject
            val edgesList: JsonArray = jsonObject.getAsJsonArray("edgesList")
            val edgesListToReturn: ArrayList<Edge> = arrayListOf()

            for (e in edgesList) {
                val edge: Edge = Gson().fromJson(e, Edge::class.java)
                edgesListToReturn.add(edge)
            }

            return edgesListToReturn
        }

        /**
         * Return an ArrayList containing all edges (from path)
         * @return ArrayList containing all edges
         */
        fun allEdges(path: String): ArrayList<Edge> {
            try {
                val jsonInput = File(path).readText()
                val jsonObject: JsonObject = JsonParser.parseString(jsonInput) as JsonObject
                val edgesList: JsonArray = jsonObject.getAsJsonArray("edgesList")
                val edgesListToReturn: ArrayList<Edge> = arrayListOf()

                for (e in edgesList) {
                    val gson = GsonBuilder().setLenient().create()
                    val edge: Edge = gson.fromJson(e, Edge::class.java)
                    edgesListToReturn.add(edge)
                }

                return edgesListToReturn
            } catch (e: FileNotFoundException) {
                println("File not found, relaunch and retry")
                exitProcess(-1)
            }
        }
    }
}

