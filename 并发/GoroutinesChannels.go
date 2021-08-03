package main

/**
	Go实现了两种并发形式，第一种是：多线程共享内存，其实就是类似java中的多线程开发；
	第二种：go语言特有的，也是GO推荐的，CSP， communicating sequential processes，并发模型；
    CSP，是以通信方式来共享内存，通过goroutine和channel来实现的；

	goroutine： 是go语言中的并发执行单位，协程；
	channel： 是go语言中各个并发之间的通信机制，就是各个goroutine之间通信的”管道“

*/
func main() {
	messages := make(chan string)
	go func() {
		messages <- "ping..." //传输数据到channel
	}()
	msg := <-messages
	println(msg)
}
