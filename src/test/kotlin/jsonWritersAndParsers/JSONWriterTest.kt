package jsonWritersAndParsers

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import nodeAndEdges.Vertex
import org.junit.jupiter.api.Test

internal class JSONWriterTest {

    @Test
    fun testWritingVertexes () {
        val vertexToAdd = Vertex(1)
        val jsonInput = this::class.java.classLoader.getResource("graph.json")?.readText()
        val jsonObject: JsonObject = JsonParser.parseString(jsonInput) as JsonObject
        val vertexesList: JsonArray = jsonObject.getAsJsonArray("vertexesList")

        val jsonVertex: JsonObject = (JsonParser.parseString(Gson().toJson(vertexToAdd))) as JsonObject

        val jsonVertexWithName: JsonObject = JsonObject()
        jsonVertexWithName.add("vertex2", jsonVertex)

        vertexesList.add(jsonVertexWithName)

        //val file= File(this::class.java.classLoader.getResource("graph.json"))
        //file.writeText(vertexesList.toString())
    }

    @Test
    fun testWritingEdges () {

    }



}