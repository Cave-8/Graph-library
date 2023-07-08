package jsonWritersAndParsers

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import nodeAndEdges.Edge
import nodeAndEdges.Vertex
import java.io.File
import java.io.PrintWriter

class JSONWriter {

    companion object {

        /**
         * Add vertex to JSON file
         */
        fun addVertex(vertexToAdd: Vertex, path: String) {
            val jsonInput = File(path).readText()
            val jsonObject: JsonObject = JsonParser.parseString(jsonInput) as JsonObject
            val vertexesList: JsonArray = jsonObject.getAsJsonArray("vertexesList")
            val edgesList: JsonArray = jsonObject.getAsJsonArray("edgesList")

            val vertexJSON = Vertex.VertexJSON(vertexToAdd.id.toString())
            val jsonVertex: JsonObject = (JsonParser.parseString(Gson().toJson(vertexJSON))) as JsonObject
            vertexesList.add(jsonVertex)

            PrintWriter(File(path)).close()
            File(path).writeText("{\"vertexesList\": $vertexesList,\"edgesList\":$edgesList}")
        }

        /**
         * Add edge to JSON file
         */
        fun addEdge(edgeToAdd: Edge, path: String) {
            val jsonInput = File(path).readText()
            val jsonObject: JsonObject = JsonParser.parseString(jsonInput) as JsonObject
            val vertexesList: JsonArray = jsonObject.getAsJsonArray("vertexesList")
            val edgesList: JsonArray = jsonObject.getAsJsonArray("edgesList")

            val edgeJSON = Edge.EdgeJSON(edgeToAdd.startingVertexId.toString(), edgeToAdd.endingVertexId.toString(), edgeToAdd.weight.toString())
            val jsonEdge: JsonObject = (JsonParser.parseString(Gson().toJson(edgeJSON))) as JsonObject
            edgesList.add(jsonEdge)

            PrintWriter(File(path)).close()
            File(path).writeText("{\"vertexesList\": $vertexesList,\"edgesList\":$edgesList}")
        }
    }
}