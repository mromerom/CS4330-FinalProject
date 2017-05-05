# Comparison of Multithreading Abilities
## This document will discuss threading or threading-like abilities for Java and Swift.
Both of these languages support multithreading. The main difference here is how these threads are handled.

## Java's Threads
Java supports the use of multiple threads at one time. These threads can either complete one purpose and be sent to the garabge collector. They can also be put to sleep(wait) for a period and run their method again. There are multiple ways going about creating and starting a thread. One method can be to extend the thread class. Another method is to impliment the interface Runnable. Code examples will be given for both below. 

### Thread Extended Class
```
class ThreadTest extends Thread {
	public void run(){
		for(i=0;i<10;i++){
			System.out.println(i);
		}
	}
}

public static void main(String args[]){  
	ThreadTest t1 = new ThreadTest();  
	t1.start();  
 } 
```
Output would be:
```
123456789
```

### Runnable Implemented Class
```
class ThreadInterface implements Runnable{  
    public void run(){  
    	System.out.println("thread is running...");  
    }  
 }
 
public static void main(String args[]){  
    ThreadInterface ti1 = new ThreadInterface();  
    Thread t1 = new Thread(ti1);  
    t1.start();  
}    
```
Output would be:
```
thread is running...
```

### Is there a difference?
Functional wise I have not major difference between either of these implementations. Both will complete tasks they are given. On an Object-Oriented level the main differece would be if you extend the thread class you are using IS-A relationship. The counter part would mean that implementing the Runnable interface means you are using composition (HAS-A) relationship.

### How is multitasking accomplished in Java?
Multiple threads can be dispatched at one time in Java to complete various jobs. It is important to note that these are not thread safe. You can make a whole thread's run thread safe by using the *synchronized* keyword. This keyword can be implemented in the following ways: before class methods, instance methods or any block of code within a method. This is only one method to making your code thread safe. In Java you can also set the priority of threads also which will help make sure the most important threads are completed before less important ones. There are three easy levels to thread priority. These are *MIN_PRIORITY*, *NORM_PRIORITY* and *MAX_PRIORITY*. These are 1, 5 and 10 respectively.

## Swift's Threads
Before Swift 3 threading was done through NSThread which would implement Objective-C method. With the implementation of Swift 3 it is now recommended to use Grand Centeral Dispatch (GCD). The GCD support multiple methods to running tasks in different orders and number to be completed at a given time. Each work item can be executed either synchronously or asynchronously. When a task is executed using the sync method, the program will wait until the work is completed before returning. Using async will return immediately and will not wait for the work to be completed. GCD also supports serial and concurent queues. Serial means that all tasks will be completed in a FIFO order one at a time. Concurent tasks will be dequeued in order and will start as FIFO but can complete in any order. Lastly, there is also a system-provided queue in which all task sent to this queue will be complete serially and on the main thread. So be careful of sending to much work to this queue as you would not want to lock out your main thread.

### GCD Synchronous Task
```
let background = DispatchQueue.global()
//Using the global dispatch queue will give default QoS to all tasks sent to it.

func doWork() { 
 background.sync { for _ in 1...3 { print(“Hello”) } 
}

for _ in 1...3 { print("Bye") 
```
Output would be:
```
Hello
Hello
Hello
Bye
Bye
Bye
```

### GCD Asynchronous Task
```
let background = DispatchQueue.global()
//Using the global dispatch queue will give default QoS to all tasks sent to it.

func doWork() { 
 background.async { for _ in 1...3 { print(“Hello”) } 
}

for _ in 1...3 { print("Bye") 
```
Output would be:
```
Hello
Bye
Bye
Hello
Hello
Bye
```

### How is multitasking accomplished in Swift?
While Swift does support use of threading it is now preferred that programmers use GCD which helps them manage their tasks. This allows the GCD to manage the threads more efficiently. GCD seems to make life easier when trying to complete multiple jobs at the same time. With the GCD you can set your own queues and priority levels for each of the jobs. To make user created queues see above. Although I am only running one thing at a time you can run concurent tasks at the same time. For example for the async example you can copy the background.async code multiple times and each of those would be ran at the same time. For priority levels there are six in total. They are from highest to lowest: userInteractive, userInitiated, default, utility, background, unspecified. There are three different DispatchQueues that you can access. They are main, background and user created queues using the QoS priorities as seen above. As a reminder you can lock out your UI if you have too heavy a task on the DispatchQueue.main.

## Conclusion



