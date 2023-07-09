# Graph-library
Small utility for graph analysis.
Graphs are read from JSON file using following structures:
{
  vertexesList: [
    {
      id = 0
    }
  ]
  edgesList: [ 
    {
    startingVertexId = 0
    endingVertexId = 0
    weight = 0
    }
  ]
}
Some examples are available inside project (in exampleJSON folder).

# Functionalities
You can:
- Print graph's adjacency matrix or list
- Add vertex
- Add edge
- Find and print eulerian path
- Find shortest path between two vertices

# Usage
You can directly download jar in root folder and run it with 'java -jar GraphLibrary.jar', be sure to download the latest version of java.
