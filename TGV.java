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
import java.util.*;
import java.io.*;
public class TGV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        PriorityQueue<Integer> N = new PriorityQueue<Integer>();
        PriorityQueue<Integer> V = new PriorityQueue<Integer>();
        
        Queue queue = new Queue();
        
       int priceV = 5;
       int priceN = 7;
       
        
       
       
        
        Counter c1 = new Counter(10, "A");
        Counter c2 = new Counter(15, "B");
        Counter c3 = new Counter(30, "C");
        Counter c4 = new Counter(15, "D");
        
        Counter[] counter = {c1,c2,c3,c4};
        
        System.out.println("Welcome to TGV Cinemas. Let us take you to the movies. ");
        System.out.print("Please enter the number of customers : ");
        int total = input.nextInt();
        
        ArrayList<Integer> arrival = new ArrayList<Integer>(total);
        ArrayList<String> type = new ArrayList<String>(total);
        ArrayList<Integer> numberOfTickets = new ArrayList<Integer>();
        
        ArrayList<String> type2 = new ArrayList<String>();
        ArrayList<Integer> tickets = new ArrayList<Integer>();
        Integer[] priority = new Integer[total];
        
        Customer [] peep = new Customer [total];
        ArrayList<Customer> meow = new ArrayList<Customer>();
        //ArrayList<Customer> peepo = new ArrayList<Customer>();
        ArrayList<Integer> price = new ArrayList<Integer>(total);
        
        
        
         for(int i = 0; i < total; i++){
            System.out.println("Please enter the arrival time, customer type (N: Non-member, V: Member) and number of tickets(1-9) respectively : ");
           
             
            arrival.add(input.nextInt());
            String v = input.next();
            int q = input.nextInt();
            if(v.equals("V") || v.equals("N")){
                type.add(v);
           
           }
           else{
               System.out.println("Please re-enter the customer type (N/V) : ");
               type.add(input.next());
           }
            
            
            
           if(q>0 && q < 10){
           numberOfTickets.add(q);
           }
           else{
               System.out.println("The number of tickets is not valid. Please insert again within the range 1-9 : ");
               numberOfTickets.add(input.nextInt());
           }
            
           
            
            switch(type.get(i)){
                case"V":
                    V.add(arrival.get(i));
                    priority[i]=arrival.get(i);
                    break;
                case"N":
                   N.add(arrival.get(i));
                   priority[i]=arrival.get(i);
            }  
             
         }
         Arrays.sort(priority);
//         for(int z =0;z<total;z++){
//          peepo.add(new Customer(arrival.get(z),type.get(z),numberOfTickets.get(z)));
//         }
         
           while(!N.isEmpty()||!V.isEmpty()){
            if(!N.isEmpty()&&!V.isEmpty()){
            if(N.peek()== V.peek()){
                int p = V.peek();
                
                if(type.get(arrival.indexOf(p)).equals("V")){
                 int w = arrival.indexOf(p);   
                type2.add(type.get(w));
                tickets.add(numberOfTickets.get(w));
                 price.add(numberOfTickets.get(w)*5);
                arrival.remove(w);
                type.remove(w);
                numberOfTickets.remove(w);
               
                
                queue.enqueue(V.poll());
                
                queue.enqueue(N.poll());
                int f = arrival.lastIndexOf(p);
                type2.add(type.get(f));
                tickets.add(numberOfTickets.get(f));
                 price.add(numberOfTickets.get(f)*7);
                arrival.remove(f);
                type.remove(f);
                numberOfTickets.remove(f);
               
            }
            else{
                
                queue.enqueue(V.poll());
                 int f = arrival.lastIndexOf(p);
                type2.add(type.get(f));
                tickets.add(numberOfTickets.get(f));
                 price.add(numberOfTickets.get(f)*5);
                arrival.remove(f);
                type.remove(f);
                numberOfTickets.remove(f);
                 
          
           queue.enqueue(N.poll());
            int w = arrival.indexOf(p);
               
                type2.add(type.get(w));
                tickets.add(numberOfTickets.get(w));
                 price.add(numberOfTickets.get(w)*7);
                arrival.remove(w);
                type.remove(w);
                numberOfTickets.remove(w);
            
            }
        
        } 
        else if(V.peek() >  N.peek()){
            int k = N.peek();
           queue.enqueue(N.poll());
                int w = arrival.indexOf(k);
                type2.add(type.get(w));
                tickets.add(numberOfTickets.get(w));
                price.add(numberOfTickets.get(w)*7);
                arrival.remove(w);
                type.remove(w);
                numberOfTickets.remove(w);
               
               } 
        
            
        else if(V.peek()< N.peek()){
            int k = V.peek();
           queue.enqueue(V.poll());
            int w = arrival.indexOf(k);
                type2.add(type.get(w));
                tickets.add(numberOfTickets.get(w));
                  price.add(numberOfTickets.get(w)*5);
                arrival.remove(w);
                type.remove(w);
                numberOfTickets.remove(w);
           
                             

        }
            }        
        else{
        if(V.isEmpty()){
            while(!N.isEmpty()){
                
                int k = N.peek();
               queue.enqueue(N.poll());
               int w = arrival.indexOf(k);
                type2.add(type.get(w));
                tickets.add(numberOfTickets.get(w));
                  price.add(numberOfTickets.get(w)*7);
                arrival.remove(w);
                type.remove(w);
                numberOfTickets.remove(w); }
            
        }   else{
            while(!V.isEmpty()){
                int k = V.peek();
               queue.enqueue(V.poll());
               int w = arrival.indexOf(k);
                type2.add(type.get(w));
                tickets.add(numberOfTickets.get(w));
                  price.add(numberOfTickets.get(w)*5);
                arrival.remove(w);
                type.remove(w);
                numberOfTickets.remove(w);
                
            }   
        }       
        
           }
           }
           
          
        System.out.println("VIP Queue : ");
        for(int g = 0; g<total;g++){
            if(type2.get(g).equals("V")){
                System.out.println(priority[g] + " " + type2.get(g) + " " + tickets.get(g));
            }
            
        }
        
        System.out.println("Normal Queue : ");
        for(int g = 0; g<total;g++){
             if(type2.get(g).equals("N")){
            System.out.println(priority[g] + " " + type2.get(g) + " " + tickets.get(g));
        }
    }
       
        for(int i = 0; i < peep.length;i++){
            peep[i] = new Customer(queue.dequeue(),type2.get(i),tickets.get(i));
            meow.add(peep[i]);
           
            
            
        }
        
       
                
            
        int realTime = 0; 
        while(true){
           
           
            for(int k = 0; k < meow.size(); k++){
                
                for( int i =0; i<counter.length; i++){
                    if(counter[i].isEmpty() && !meow.isEmpty() && meow.get(k).getArrivalTime() <= realTime){
                        counter[i].setCus(meow.get(k));
                        if(i==0){
                            counter[i].setTimePerTicket(10);
                        }
                        if(i==1){
                            counter[i].setTimePerTicket(15);
                        }
                        if(i==2){
                            counter[i].setTimePerTicket(30);
                        }
                        if(i==3){
                            counter[i].setTimePerTicket(15);
                        }
                        customerUpdate(meow.get(k),realTime,counter[i]);
                        meow.remove(k);
                         counter[i].setCusServed(counter[i].getCusServed() +1);
                    }
                }
                
                        
            }
             for(int i = 0; i < counter.length; i++){ 
                if(counter[i].getCus() != null && counter[i].getCus().getEndTime() == realTime)
                    counter[i].setCus(null);
             }
           
           
            if(c1.isEmpty() && c2.isEmpty() && c3.isEmpty() && c4.isEmpty()
                    &&  meow.isEmpty())
                break;
            
            realTime++;
        }
    
        display(peep,realTime,price);
        System.out.println("Number of customers served: " + priority.length);
        log(peep,realTime,counter);
    }
         
   
    
     public static void customerUpdate(Customer cus, int rt, Counter ct){
        cus.setStartTime(rt);
        cus.setProcessingTime(cus.getNumOfTicket() * ct.getTimePerTicket());
        cus.setEndTime(cus.getStartTime() + cus.getProcessingTime());
        cus.setWaitingTime(cus.getStartTime() - cus.getArrivalTime());
        cus.setCounter(ct);
    }
     
     public static void display(Customer[] cus, int totalTime, ArrayList price){
        System.out.println("Total completion time: "+totalTime+" seconds\n");
        System.out.println("Customer   Arrival   Start Processing   End Processing   Processing Time   Waiting Time   Queue      Counter   Price");
        
        for(int i = 0; i < cus.length; i++){
            System.out.printf("%d\t   %d\t     %d\t\t\t%d\t\t %d\t\t   %d\t\t  %-6s     %s\t\t %d\n",
                    (i+1),cus[i].getArrivalTime(),cus[i].getStartTime(),cus[i].getEndTime(),cus[i].getProcessingTime(),
                    cus[i].getWaitingTime(),cus[i].getQueue(),cus[i],price.get(i));
        }
    }
     
     public static void log(Customer[] cus, int rt, Counter[] ct){
        try{
            PrintWriter output = new PrintWriter(new FileOutputStream("log.txt"));
            
            output.println("Queuing Simulator");
            output.println();
            output.println("Customer information: ");
            
            for(int i = 0; i < cus.length; i++){
                output.println("Customer "+(i+1)+": ");
                output.println("Type: "+cus[i].getType());
                output.println("Number of ticket(s) purchased: "+cus[i].getNumOfTicket());
                output.println("Arrival time: "+cus[i].getArrivalTime());
                output.println("Assigned counter: "+cus[i]);
                output.println("Start processing time: "+cus[i].getStartTime());
                output.println("End processing time: "+cus[i].getEndTime());
                output.println("Total processing time: "+cus[i].getProcessingTime());
                output.println("Total waiting time: "+cus[i].getWaitingTime());
                output.println();
            }
            
            output.println("Total completion time: "+rt);
            output.println();
            
            output.println("Total customer(s) served for each counter: ");
            output.println("Counter A: "+ct[0].getCusServed());
            output.println("Counter B: "+ct[1].getCusServed());
            output.println("Counter C: "+ct[3].getCusServed());
            output.println("Counter D: "+ct[2].getCusServed());
            
            output.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
}

            
          
       
        