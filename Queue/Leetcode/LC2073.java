public class LC2073 {

    public int timeRequiredToBuy(int[] tickets, int k) {


        if(tickets.length == 1) return tickets[0]; // base case

        int time = 0; // time to return a the end for kth index to buy all tickets

          // Parse entire array in 1 parse
          // We need to keep track of all indices because our entry will depend on both people in front of us and back of us
         for(int i=0; i<tickets.length; i++){

            if(i <= k) {
                time = time + Math.min(tickets[i], tickets[k]); // people in front of you

            }else{
               time = time + Math.min(tickets[i], tickets[k] - 1); // people at back of you
            }
         }
       

        return time; // return the time
        
    }


    
}

/*
Problem: Time Required to Buy Tickets (LeetCode)

You are standing at index 'k' in a queue where each person wants a certain number of tickets.
Each person buys only one ticket at a time and goes to the end of the queue if they still want more.
We want to find how many seconds it takes for you (at index k) to finish buying all your tickets.

Intuition:
- Instead of simulating the entire queue rotation, we can calculate how many times each person slows you down.
- For each person in the queue, we calculate the minimum number of times they get a chance to buy a ticket.

Explanation:
1. People before or at index 'k':
   - These people buy tickets during the same rounds that you do.
   - So, each of them can buy up to Math.min(tickets[i], tickets[k]) tickets in those rounds.

   If the person is in front of you or is you (`i <= k`):
   - They will always get a chance to buy in every round you do.
   - But they can't buy more tickets than the number you need (`tickets[k]`).
   - So we add: Math.min(tickets[i], tickets[k])


2. People after index 'k':
   - Once you have your final ticket, the process ends.
   - Therefore, people behind you can only buy tickets in the first (tickets[k] - 1) rounds.
   - Each of them contributes Math.min(tickets[i], tickets[k] - 1) seconds.

   If the person is behind you (`i > k`):
   - They will get to buy in all the rounds except the last one (your final ticket).
   - So they get at most (tickets[k] - 1) chances to buy.
   - So we add: Math.min(tickets[i], tickets[k] - 1)

3. We loop through all people, and for each, add their contribution to the total time.

Why this works:
- This avoids simulation and gives a linear O(n) time solution.
- We focus only on how many times each person delays you getting your ticket.
- Math.min() ensures we never overcount — nobody can buy more than their required tickets,
  and those behind you can't affect you once you've finished.

Example:
Input: tickets = [2,3,2], k = 2
Output: 6 seconds
Person 0: 2 times
Person 1: min(3, 2) = 2 times
Person 2 (you): 2 times
Total = 2 + 2 + 2 = 6 seconds
*/




/*
 * There are n people in a line queuing to buy tickets, where the 0th person is at the front of the line and the (n - 1)th person is at the back of the line.

You are given a 0-indexed integer array tickets of length n where the number of tickets that the ith person would like to buy is tickets[i].

Each person takes exactly 1 second to buy a ticket. A person can only buy 1 ticket at a time and has to go back to the end of the line (which happens instantaneously) in order to buy more tickets. If a person does not have any tickets left to buy, the person will leave the line.

Return the time taken for the person initially at position k (0-indexed) to finish buying tickets.

 

Example 1:

Input: tickets = [2,3,2], k = 2

Output: 6

Explanation:

The queue starts as [2,3,2], where the kth person is underlined.
After the person at the front has bought a ticket, the queue becomes [3,2,1] at 1 second.
Continuing this process, the queue becomes [2,1,2] at 2 seconds.
Continuing this process, the queue becomes [1,2,1] at 3 seconds.
Continuing this process, the queue becomes [2,1] at 4 seconds. Note: the person at the front left the queue.
Continuing this process, the queue becomes [1,1] at 5 seconds.
Continuing this process, the queue becomes [1] at 6 seconds. The kth person has bought all their tickets, so return 6.
Example 2:

Input: tickets = [5,1,1,1], k = 0

Output: 8

Explanation:

The queue starts as [5,1,1,1], where the kth person is underlined.
After the person at the front has bought a ticket, the queue becomes [1,1,1,4] at 1 second.
Continuing this process for 3 seconds, the queue becomes [4] at 4 seconds.
Continuing this process for 4 seconds, the queue becomes [] at 8 seconds. The kth person has bought all their tickets, so return 8.
 

Constraints:

n == tickets.length
1 <= n <= 100
1 <= tickets[i] <= 100
0 <= k < n

 * 
 * 
 * 
 * 
 */