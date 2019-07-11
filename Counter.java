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
public class Counter {
    private  int timePerTicket;
    private Customer cus;
    private final String counterName;
    private int cusServed;

    public Counter(int tpt, String cn){
        this.cus = null;
        timePerTicket = tpt;
        counterName = cn;
        cusServed = 0;
    }

    public void setTimePerTicket(int ticket){
        this.timePerTicket = ticket;
    }
    public int getTimePerTicket() {
        return timePerTicket;
    }

    public Customer getCus() {
        return cus;
    }

    public int getCusServed() {
        return cusServed;
    }

    public void setCus(Customer cus) {
        this.cus = cus;
    }

    public void setCusServed(int cusServed) {
        this.cusServed = cusServed;
    }
    
    public boolean isEmpty(){
        if(cus == null)
            return true;
        return false;
    }
    
    public String toString(){
        return counterName;
    }
    
}
