import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")
    val jobDeferred = async {// Thread: T1
        println("Fake work starts: ${Thread.currentThread().name}")
        delay(1000) // Coroutine is suspended but thread T1 is free (not blocked)
        println("Fake work ends:  ${Thread.currentThread().name}") //Either T1 or some other thread
        15
    }

    //jobDeferred.join() // waits till the coroutine is complete
    println(jobDeferred.await())

    println("Main program ends: ${Thread.currentThread().name}")
}