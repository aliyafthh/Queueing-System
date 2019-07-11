# Queueing-System
<b>Problem Statement</b> <br>
You work as a programmer in Company X. Company X is an entertainment company who has setup several cinemas in different 
location to provide entertainment service. However, ticket sales has been not doing well recently. 
It was found out that a lot of customers are fed up with the queue waiting time to buy the tickets. 
As a result, your manager have ask you to write a program to simulate a queueing system in the cinema. <br>
<br>
<b>Requirement</b><br>
You are required to write a program to simulate queueing system in the cinema with the following requirements:<br>
<ol>
<li>There are two type of customers to be served which are: VIP member and non-member customers.</li>
<li>The number of tickets wanted to be bought by the customer are vary in a range of 1 to 10 tickets.</li>
<li>There must be at least 2 queue (you can have more than 2 queues) in the queueing system. Of all the queues, there must be one priority queue which only allow VIP member to queue up.</li>
<li>There are 4 service counters in the queueing system. The service rate of the sales worker are as below:</li>
<ul>
<li>Counter 01: Required 10 seconds to sell 1 ticket.</li>
<li>Counter 02: Required 15 seconds to sell 1 ticket</li>
<li>Counter 03: Required 30 seconds to sell 1 ticket.</li>
<li>Counter 04: Required 15 seconds to sell 1 ticket.</li>
</ul>
</ol>

When a customer arrive at the cinema, he/she will go to the queue. If the customer is a VIP member, he/she will go to the priority queue, 
or else if he/she is a non-member, he/she will go to the normal queue. VIP member customer must be served before any non-member customer. 
Whenever there are customers waiting in the queue, the available service counters has to call the next customer and serve them. 
There should not be any idle service counter except there is no more customer to serve.
