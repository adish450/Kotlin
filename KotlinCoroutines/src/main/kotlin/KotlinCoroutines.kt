import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")

    try {
        withTimeout(2000) {
            for (i in 0..500) {
                print("$i ")
                delay(500)
            }
        }
    } catch (ex: TimeoutCancellationException) {
        println(ex.message)
    } finally {

    }


    println("Main program ends: ${Thread.currentThread().name}")
}