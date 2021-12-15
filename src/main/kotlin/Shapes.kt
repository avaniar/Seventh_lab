import kotlinx.serialization.Serializable
import kotlin.math.pow
import kotlin.math.sqrt

interface Shape {
    fun calcArea(): Double
    fun calcPerimeter(): Double
}

// creating a circle with a given radius
@Serializable
class Circle(val radius: Double) : Shape {
    init {
        if (radius <= 0)
            throw IllegalArgumentException("radius must be greater than zero")
    }

    override fun calcArea(): Double = Math.PI * this.radius * this.radius
    override fun calcPerimeter(): Double = 2 * Math.PI * this.radius
}

// creating a square with the length of the side
@Serializable
class Square(val side: Double) : Shape {
    init {
        if (side <= 0)
            throw IllegalArgumentException("side must be greater than zero")
    }

    override fun calcArea(): Double = side.pow(2.0)
    override fun calcPerimeter(): Double = side * 4
}

// creating a rectangle with long sides
@Serializable
class Rectangle(val width: Double, val height: Double) : Shape {
    init {
        if ((width <= 0) || (height <= 0))
            throw IllegalArgumentException("side must be greater than zero")
    }

    override fun calcArea(): Double = width * height
    override fun calcPerimeter(): Double = (width + height) * 2
}

// creating a triangle with long sides
@Serializable
class Triangle(val sideA: Double, val sideB: Double, val sideC: Double) : Shape {
    // half perimeter for calculating the area of a triangle
    private val halfPerimeter: Double = calcPerimeter() / 2

    init {
        if ((sideA <= 0) || (sideB <= 0) || (sideC <= 0))
            throw IllegalArgumentException("side must be greater than zero")
        // the sum of any two sides must be greater than the length of the thirds
        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA)
            throw IllegalArgumentException("impossible to build a triangle")
    }

    override fun calcArea(): Double =
        sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC))

    override fun calcPerimeter(): Double = sideA + sideB + sideC
}