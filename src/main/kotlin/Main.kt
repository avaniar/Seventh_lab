fun main() {
    val pathWrite = "C:\\Seventh_lab\\src\\main\\kotlin\\data.json"
    val serialize = SerializeShapes
    val shapeFactory = ShapeFactoryImpl()
    println("Data obtained")
    println(WorkWithFiles.read(pathWrite))
    val shapeList = serialize.decode(WorkWithFiles.read(pathWrite))
    shapeList.addAll(
        listOf(
            shapeFactory.createRandomShape(),
            shapeFactory.createRandomShape(),
            shapeFactory.createRandomShape()
        )
    )
    println("Modified data")
    println(serialize.encode(shapeList))
    WorkWithFiles.write(pathWrite, serialize.encode(shapeList))
}