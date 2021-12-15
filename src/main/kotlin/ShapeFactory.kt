import kotlin.math.abs
import kotlin.random.Random
import kotlin.random.nextInt

interface ShapeFactory {
    fun createCircle(radius: Double): Circle
    fun createSquare(side: Double): Square
    fun createRectangle(width: Double, height: Double): Rectangle
    fun createTriangle(sideA: Double, sideB: Double, sideC: Double): Triangle

    fun createRandomCircle(): Circle
    fun createRandomSquare(): Square
    fun createRandomRectangle(): Rectangle
    fun createRandomTriangle(): Triangle

    fun createRandomShape(): Shape
}

class ShapeFactoryImpl : ShapeFactory {
    // create circle
    override fun createCircle(radius: Double): Circle {
        return Circle(radius)
    }

    override fun createRandomCircle(): Circle {
        return createCircle(Random.nextDouble(1.0, 1000.0))
    }

    // create square
    override fun createSquare(side: Double): Square {
        return Square(side)
    }

    override fun createRandomSquare(): Square {
        return createSquare(Random.nextDouble(1.0, 1000.0))
    }

    // create rectangle
    override fun createRectangle(width: Double, height: Double): Rectangle {
        return Rectangle(width, height)
    }

    override fun createRandomRectangle(): Rectangle {
        return createRectangle(Random.nextDouble(1.0, 1000.0), Random.nextDouble(1.0, 1000.0))
    }

    // create triangle
    override fun createTriangle(sideA: Double, sideB: Double, sideC: Double): Triangle {
        return Triangle(sideA, sideB, sideC)
    }

    override fun createRandomTriangle(): Triangle { // get two random side lengths and one cos-value
        val sideA = Random.nextDouble(1.0, 1000.0)
        val sideB = Random.nextDouble(1.0, 1000.0)
        val sideC = Random.nextDouble(abs(sideA - sideB), sideA + sideB)
        // the sum of any two sides must be greater than the length of the thirds
        // A + B > C
        // A + C > B => C > B - A
        // B + C > A => C > A - B
        return (createTriangle(sideA, sideB, sideC))
    }

    override fun createRandomShape(): Shape {

        return when (Random.nextInt(0..3)) {
            0 -> createRandomCircle()
            1 -> createRandomSquare()
            2 -> createRandomRectangle()
            3 -> createRandomTriangle()
            else -> throw Exception("random error")
        }
    }
}
