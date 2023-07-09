package jsonWritersAndParsers

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser.parseString
import nodeAndEdges.Edge
import nodeAndEdges.Vertex
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class JSONParserTest {

    @Test
    fun testParsingvertices () {
        val jsonInput = this::class.java.classLoader.getResource("graph.json")?.readText()
        Assertions.assertNotNull(jsonInput)

        val jsonObject: JsonObject = parseString(jsonInput) as JsonObject
        Assertions.assertNotNull(jsonObject)
        println(jsonObject)

        val verticesList: JsonArray = jsonObject.getAsJsonArray("verticesList")

        for (vl in verticesList) {
            val vertex: Vertex = Gson().fromJson(vl, Vertex::class.java)
            Assertions.assertNotNull(vertex.id)
        }

        println(verticesList)
    }

    @Test
    fun testParsingEdges () {
        val jsonInput = this::class.java.classLoader.getResource("graph.json")?.readText()
        val jsonObject: JsonObject = parseString(jsonInput) as JsonObject
        val edgesList: JsonArray = jsonObject.getAsJsonArray("edgesList")

        for (e in edgesList) {
            val edge: Edge = Gson().fromJson(e, Edge::class.java)
            Assertions.assertNotNull(edge.startingVertexId)
            Assertions.assertNotNull(edge.endingVertexId)
            Assertions.assertNotNull(edge.weight)
        }

        println(edgesList)
    }
}
