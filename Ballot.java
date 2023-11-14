
import java.util.*;

/**
 * The Ballot class represents a single ballot.
 * It contains a priority queue of candidates.
 * @authors Alex W, Timothy T, Miles M
 * @version 13/11/2023
 */
public class Ballot {
   private PriorityQueue<Candidate> rankings;

   public Ballot() {
      this.rankings = new PriorityQueue<>();
   }

   public void addRanking(Candidate candidate) {
      rankings.offer(candidate);
   }

   public Candidate getTop() {
      return rankings.poll();
   }
    
   public Candidate peek() {
      return rankings.peek();
   }


   public void removeCandidate(String theCandidate) {
      Stack<Candidate> temp = new Stack<Candidate>();
      boolean changeRank = false;
      
      int size = rankings.size();
      for(int i = 0; i < size; i++) {
         Candidate c = rankings.poll();
         if(c.getName().equals(theCandidate)) {
            changeRank = true;
            continue;
         }
         
         if(changeRank) {
            c.lowerRank();
         }
         temp.push(c);
      }
      
      while(!temp.isEmpty()) {
         rankings.offer(temp.pop());
      }
   }
    
   // Terrible, should probably use another list or a stack with just a counter 
   // to check if number increases properly 
   public boolean check() {
      if(rankings.size() < 1) {
         return false;
      }
      Stack<Candidate> temp = new Stack<Candidate>();
      
      int size = rankings.size()+1;
      for (int i = 1; i<size; i++) {
         Candidate c = rankings.poll();

         if (c.getRank() != i) {
            return false;
         }
         temp.push(c);
      }
      
      while(!temp.isEmpty()) {
         rankings.offer(temp.pop());
      }
      
      return true;
   }
    
   public String toString(){
      String temp = "";
      for(Candidate c : rankings) {
         temp+=(c.toString()+",");
      }
      return temp;//+"\n"
   }
}
