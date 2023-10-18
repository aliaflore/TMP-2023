package com.mycompany.lab2;

import java.util.concurrent.Semaphore;

public class SharedObject {
    int x = 0;
    Semaphore lock = new Semaphore(1);
    
    public synchronized int get() {
	return x; 
    }
    
    public synchronized void set(int x) {
        
	this.x=x;
    }
    public void lock() throws InterruptedException
    {
        lock.acquire();
    }
    public void unlock()
    {
        lock.release();
    }
}
