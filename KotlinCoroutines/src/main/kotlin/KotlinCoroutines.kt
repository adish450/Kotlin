import kotlinx.coroutines.*
import kotlin.time.measureTime

fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")

    println("CoroutineScope: $this")

    launch { //No dispatcher passed, inherits the context of the parent coroutine (runBlocking)
        println("C1: ${Thread.currentThread().name}") //Thread: main
        delay(1000)
        println("C1 after delay: ${Thread.currentThread().name}") //Thread: main
    }

    launch(Dispatchers.Default) { //similar to GlobalScope.launch coroutine
        println("C2: ${Thread.currentThread().name}") //Thread: T1
        delay(1000)
        println("C2 after delay: ${Thread.currentThread().name}") //Thread: T1 or some other thread

        launch(coroutineContext) { //Inherits the parent coroutine (C2) behaves like confined
            println("C4: ${Thread.currentThread().name}") //Thread: T1
            delay(1000)
            println("C4 after delay: ${Thread.currentThread().name}") //Thread: T1
        }
    }

    launch(Dispatchers.Unconfined) { //Inherits the parent coroutine (runBlocking)
        println("C3: ${Thread.currentThread().name}") //Thread: main
        delay(1000)
        println("C3 after delay: ${Thread.currentThread().name}") //Thread: some other thread
    }

    println("Main program ends: ${Thread.currentThread().name}")
}