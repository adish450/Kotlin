import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")

    val job = launch {
        try {
            for (i in 0..500) {
                print("$i ")
                delay(1000)
            }
        } catch (ex: CancellationException) {
            println("\nException caught safely : ${ex.message}")
        } finally {
            withContext(NonCancellable) {//coroutine builder
                delay(1000) //Generally we don't use this
                println("\nClose resources in finally")
            }
        }
    }

    delay(10)
    job.cancel(CancellationException("My custom message"))
    job.join()

    println("Main program ends: ${Thread.currentThread().name}")
}