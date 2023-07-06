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
    fun testParsingVertexes () {
        val jsonInput = this::class.java.classLoader.getResource("graph.json")?.readText()
        val jsonObject: JsonObject = parseString(jsonInput) as JsonObject
        val vertexesList: JsonArray = jsonObject.getAsJsonArray("vertexesList")

        for (vl in vertexesList) {
            val vertex: Vertex = Gson().fromJson(vl, Vertex::class.java)
            Assertions.assertNotNull(vertex.id)
            Assertions.assertNotNull(vertex.value)
        }
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
    }
}
