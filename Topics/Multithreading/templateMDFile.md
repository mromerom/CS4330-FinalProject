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

## Swift's Threads
### "Primitive" Value Types

### Value Types

### Reference Types

## Conclusion



