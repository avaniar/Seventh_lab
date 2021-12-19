fun main() {
    val pathWrite = "C:\\Users\\admin\\IdeaProjects\\Seventh_lab3\\src\\main\\kotlin\\data.json"
    val serialize = SerializeShapes
    val shapeFactory = ShapeFactoryImpl()
    println("Data obtained")
    println(FileUtils.read(pathWrite))
    val shapeList = serialize.decode(FileUtils.read(pathWrite)).toMutableList()
    shapeList.addAll(
        listOf(
            shapeFactory.createRandomShape(),
            shapeFactory.createRandomShape(),
            shapeFactory.createRandomShape()
        )
    )
    println("Modified data")
    println(serialize.encode(shapeList))
    FileUtils.write(pathWrite, serialize.encode(shapeList))
}