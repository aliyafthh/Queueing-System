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
public class Customer {
    private int arrivalTime;
    private String type;
    private int numOfTicket;
    
    private int startTime;
    private int endTime;
    private int processingTime;
    private int waitingTime;
    
    private Counter counter;
    private String queue;
        
    public Customer(int at, String t, int nt){
        arrivalTime = at;
        numOfTicket = nt;
        counter  = null;
        
        switch(t){
            case "N":
                type = "N";
                queue = "normal";
                break;
            case "V":
                type = "VIP";
                queue = "VIP";
        }        
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public String getType() {
        return type;
    }

    public int getNumOfTicket() {
        return numOfTicket;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public Counter getCounter() {
        return counter;
    }

    public String getQueue() {
        return queue;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public void setCounter(Counter counter) {
        this.counter = counter;
    }
    
    public String toString(){
        return counter.toString();
    }
    
}
