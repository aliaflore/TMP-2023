package com.mycompany.lab2;

public class MyThread extends Thread {
    SharedObject shared;
    
    public MyThread (SharedObject shared)
    {
        this.shared = shared ;
    }
    public void run()
    {
        //shared.lock();	
        for ( int i = 0 ; i < 10000; i ++){
            int x = shared.get();
            x++;
            shared.set(x);
        }
        //shared.unlock();
    }
}
