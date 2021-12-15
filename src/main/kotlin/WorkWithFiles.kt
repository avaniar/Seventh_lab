import java.io.File

object WorkWithFiles {

    fun write(path: String, value: String) {
        File(path).writeText(value)
    }

    fun read(path: String): String {
        return File(path).readText()
    }
}