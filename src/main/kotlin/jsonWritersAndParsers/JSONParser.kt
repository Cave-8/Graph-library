package jsonWritersAndParsers

import com.google.gson.*
import nodeAndEdges.Edge
import nodeAndEdges.Vertex
import java.io.File

class JSONParser {

    companion object {

        /**
         * Return an ArrayList containing all vertexes
         * @return ArrayList containing all vertexes
         */
        fun allVertexes() : ArrayList<Vertex> {
            val jsonInput = this::class.java.classLoader.getResource("graph.json")?.readText()
            val jsonObject: JsonObject = JsonParser.parseString(jsonInput) as JsonObject
            val vertexesList: JsonArray = jsonObject.getAsJsonArray("vertexesList")
            val vertexesListToReturn: ArrayList<Vertex> = arrayListOf()

            for (vl in vertexesList) {
                val vertex: Vertex = Gson().fromJson(vl, Vertex::class.java)
                vertexesListToReturn.add(vertex)
            }

            return vertexesListToReturn
        }

        /**
         * Return an ArrayList containing all vertexes (from path)
         * @return ArrayList containing all vertexes
         */
        fun allVertexes(path: String) : ArrayList<Vertex> {
            val jsonInput = File(path).readText()
            val jsonObject: JsonObject = JsonParser.parseString(jsonInput) as JsonObject
            val vertexesList: JsonArray = jsonObject.getAsJsonArray("vertexesList")
            val vertexesListToReturn: ArrayList<Vertex> = arrayListOf()

            for (vl in vertexesList) {
                val gson = GsonBuilder().setLenient().create()
                val vertex: Vertex = gson.fromJson(vl, Vertex::class.java)
                vertexesListToReturn.add(vertex)
            }

            return vertexesListToReturn
        }

        /**
         * Return an ArrayList containing all edges
         * @return ArrayList containing all edges
         */
        fun allEdges() : ArrayList<Edge> {
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
        fun allEdges(path: String) : ArrayList<Edge> {
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
        }
    }
}

