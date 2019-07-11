/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgv;

/**
 *
 * @author MSI GL62
 */
public class Queue {
     private java.util.LinkedList<Integer> list = new java.util.LinkedList<Integer>();
   
    
    public void enqueue(Integer e){
        list.addLast(e);
    }
    
    public int dequeue(){
        return list.removeFirst();
    }
    
    public int getSize(){
        return list.size();
    }
    
    
    @Override
    public String toString(){
        return "Theoretical Queue : " + list.toString();
        
    }
    
    
   
    
    
    
}
