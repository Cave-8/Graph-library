package jsonWritersAndParsers

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import nodeAndEdges.Edge
import nodeAndEdges.Vertex

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
         * Return vertex with id and value if present, otherwise it returns null
         * @param idToFind is vertex id
         * @param valueToFind is vertex value
         * @return vertex with id and value if present, otherwise it returns null
         */
        fun searchVertex(idToFind: Int, valueToFind: Int) : Vertex {
            return allVertexes().first {vertex ->  vertex.id == idToFind && vertex.value == valueToFind }
        }

        /**
         * Return edge connecting starting and ending vertex (if exists)
         * @param startingVertexIdToFind is starting vertex
         * @param endingVertexIdToFind is ending vertex
         * @return edge connecting starting and ending vertex (if exists), otherwise it returns null
         */
        fun searchEdge(startingVertexIdToFind: Int, endingVertexIdToFind: Int) : Edge {
            return allEdges().first {edge ->  edge.startingVertexId == startingVertexIdToFind && edge.endingVertexId == endingVertexIdToFind}
        }
    }


}

