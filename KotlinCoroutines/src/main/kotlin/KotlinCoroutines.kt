import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

fun main() {
     println("Main program starts: ${Thread.currentThread().name}")

    thread { // create a bg thread
        println("Fake work starts: ${Thread.currentThread().name}")
        Thread.sleep(1000)
        println("Fake work ends:  ${Thread.currentThread().name}")
    }

    GlobalScope.launch {// launch a bg coroutine on a bg thread
        println("Fake work starts: ${Thread.currentThread().name}")
        Thread.sleep(1000)
        println("Fake work ends:  ${Thread.currentThread().name}")
    }

    println("Main program ends: ${Thread.currentThread().name}")
}