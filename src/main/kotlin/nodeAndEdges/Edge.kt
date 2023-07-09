package nodeAndEdges

class Edge (val startingVertexId: Int, val endingVertexId: Int, val weight: Int) {
    class EdgeJSON(val startingVertexId: String, val endingVertexId: String, val weight: String)
}