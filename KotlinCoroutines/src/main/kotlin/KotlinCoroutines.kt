import kotlinx.coroutines.*
import kotlin.time.measureTime

fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")

    val time = measureTime {
        val msgOne = msgOne()
        val msgTwo =  msgTwo()

        println("$msgOne $msgTwo")
    }

    println(time)

    println("Main program ends: ${Thread.currentThread().name}")
}

suspend fun msgOne(): String {
    delay(1000L)
    return "Hello!, "
}

suspend fun msgTwo(): String {
    delay(1000L)
    return "World"
}