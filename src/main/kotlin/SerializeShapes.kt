import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

object SerializeShapes {
    private val json = Json {
        prettyPrint = true
        serializersModule = SerializersModule {
            polymorphic(Shape::class) {
                subclass(Circle::class)
                subclass(Square::class)
                subclass(Rectangle::class)
                subclass(Triangle::class)
            }
        }
    }

    fun encode(shapes: List<Shape>): String {
        return json.encodeToString(shapes)
    }

    fun decode(encodedShapes: String): List<Shape> {
        return json.decodeFromString(encodedShapes)
    }
}