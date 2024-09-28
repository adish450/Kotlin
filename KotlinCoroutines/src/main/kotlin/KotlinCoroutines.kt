import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")

    val job = launch(Dispatchers.Default) {
        for (i in 0..500) {
            if (!isActive) {
                break
            }
            print("$i ")
            Thread.sleep(10)
        }
    }

    delay(10)
    job.cancelAndJoin()

    println("Main program ends: ${Thread.currentThread().name}")
}