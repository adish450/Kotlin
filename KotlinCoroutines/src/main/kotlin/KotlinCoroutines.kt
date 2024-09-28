import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")

    val job = launch() {
        for (i in 0..500) {
            print("$i ")
            yield()
        }
    }

    delay(10)
    job.cancelAndJoin()

    println("Main program ends: ${Thread.currentThread().name}")
}