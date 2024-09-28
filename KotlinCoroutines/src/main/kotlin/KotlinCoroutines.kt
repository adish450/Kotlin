import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() {
    println("Main program starts: ${Thread.currentThread().name}")

    GlobalScope.launch {// Thread: T1
        println("Fake work starts: ${Thread.currentThread().name}")
        delay(1000) // Coroutine is suspended but thread T1 is free (not blocked)
        println("Fake work ends:  ${Thread.currentThread().name}") //Either T1 or some other thread
    }
    runBlocking { // creates a coroutine which block the current thread (main thread)
        delay(2000)
    }

    println("Main program ends: ${Thread.currentThread().name}")
}