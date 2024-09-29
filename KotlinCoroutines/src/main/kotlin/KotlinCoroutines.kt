import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")

    val result = withTimeoutOrNull(2000) {
        for (i in 0..500) {
            print("$i ")
            delay(500)
        }
        5
    }

    println(result)


    println("Main program ends: ${Thread.currentThread().name}")
}