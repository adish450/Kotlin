import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")

    val job = launch() {
        for (i in 0..500) {
            print("$i ")
            delay(1)
        }
    }

    delay(10)
    job.cancelAndJoin()

    println("Main program ends: ${Thread.currentThread().name}")
}