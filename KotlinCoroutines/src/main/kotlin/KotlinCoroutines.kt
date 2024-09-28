import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")
    val job = launch {// Thread: T1
        println("Fake work starts: ${Thread.currentThread().name}")
        delay(1000) // Coroutine is suspended but thread T1 is free (not blocked)
        println("Fake work ends:  ${Thread.currentThread().name}") //Either T1 or some other thread
    }

    job.join() // waits till the coroutine is complete

    println("Main program ends: ${Thread.currentThread().name}")
}