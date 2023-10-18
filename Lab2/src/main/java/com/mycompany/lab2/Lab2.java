package com.mycompany.lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab2 {

    public static void main(String[] args) {
        
        long startTime = System.currentTimeMillis();
        int n = 100 ;
        int m = 100 ;
        SharedObject myShared = new SharedObject();
        List<MyThread> listOne = new ArrayList<MyThread>();
        List<MyThreadv2> listTwo = new ArrayList<MyThreadv2>();
        for ( int i = 0 ; i < n ; i ++ ){
            MyThread t = new MyThread(myShared);
            t.start();
            listOne.add(t);
        }
        for ( int i = 0 ; i < m ; i ++ ){
            MyThreadv2 t = new MyThreadv2(myShared);
            t.start();
            listTwo.add(t);
        }
        
        try {
            for (int i = 0 ; i < n ; i ++ )
                listOne.get(i).join();
            for (int i = 0 ; i < m ; i ++ )
                listTwo.get(i).join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Lab2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        long stopTime = System.currentTimeMillis();
        System.out.println(stopTime-startTime + " milisecunde");  
        System.out.println(myShared.get());  
    }
}

/*
lab 3 ex 1
daca se vrea ca mai multe thread uri sa acceseze memoria in acelasi timp, atunci rezultatul 
va fi mereu o necunoscuta
*/

/*
lab 3 ex 2 a)
un sistem care este deadlock-free nu garantează automat și starvation-freedom  
    unele fire pot avea prioriatate si sa aiba acces la resurse mereu cu prioritate
un sistem care este starvation-free este și deadlock-free - firele care asteapteapa info vor avea info
lab 3 ex 2 b)
unlock se da doar in momentul cand al doilea flag este pus pe true (primul flag se pune pe false la unlock)
amandoua nu pot sa isi dea lock in cauza ca se specifica victima
practic totul tine de victima

chiar daca flag = [1 , 1] nu se pot bloca in primul while (la curs)
trebuie sa vede daca se pot bloca amandoua in while ul 2

sa zicem ca primul thread se afla in unlock
flag ul se seteaza pe fals si se asteapta in while cat timp flag ul 2 este true (asta se poate face instant)
sa zicem ca ambele thread uri se opresc simultan - tot unlock ul se termina 

*/
