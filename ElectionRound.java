
import java.util.*;

public class ElectionRound {
   private Queue<Ballot> ballots;
   private String eliminatedCandidate;
   private int totalValidBallots;
   
   
   private HashMap<String,Integer> candCount;
   
   private boolean winner;

   public ElectionRound(Queue<Ballot> theBallots) {
      this.ballots = theBallots;
      this.eliminatedCandidate = null;
      this.totalValidBallots = 0;
      
      this.candCount = new HashMap<String,Integer>();
      this.winner = false;
   }

   public String getEliminatedCandidate() {
      return eliminatedCandidate;
   }

   public void setEliminatedCandidate(String eliminatedCandidate) {
      this.eliminatedCandidate = eliminatedCandidate;
   }

   public int getTotalValidBallots() {
      return totalValidBallots;
   }

   public void incrementTotalValidBallots() {
      totalValidBallots++;
   }
    
   public Ballot peek() {
      return ballots.peek();
   }
   
   public void removeCandidates(String theCandidate) {
      candCount.clear();
      
      for(Ballot b : ballots) {
         b.removeCandidate(theCandidate);
      }
   }
   
   
   // before running this, remove invalid ballots
   public String run() {
   
      int validVotes = 0;
      
      int size = ballots.size();
      for(int i = 0; i < size; i++) {
         Ballot b = ballots.poll();
         // increase count in hashmap
         if(b.check()){
            candCount.put(b.peek().getName(), candCount.getOrDefault(b.peek().getName(), 0) + 1);
            validVotes++;
         } else {
            ballots.remove(b);
            i--;
            size--;
            continue;
         }
         ballots.offer(b);
         
      }
      
      // By this point all the ballots have top vote counted
      // Now just calculate % of vote and eliminate lowest or return winner
      
      double lowest = 0.0;
      String cand = null; //the candidate with over 50% or lowest %
      
      //one time use
      boolean start = true;
      
      
      //loop through and find smallest or winner
      int candCnt = 0;
      for (Map.Entry<String,Integer> mapElement : candCount.entrySet()){
         candCnt++;
      
         double perc = Math.round(((mapElement.getValue()*1.0)/validVotes)*1000.0)/1000.0;
         
         System.out.println(mapElement.getKey() + ":	 " + mapElement.getValue() + " votes	(" + 
                            perc + ")");
         /*
         if(perc >= 0.5) {
         
            this.winner = true;
            return mapElement.getKey();
            
         } 
         */
         if(start) {//set initial values
         
            lowest = perc;         
            cand = mapElement.getKey();
            start = false;
            
         } else if (perc < lowest){//grab lowest value
         
            lowest = perc;
            cand = mapElement.getKey();
         }
         
         
      }
      
      System.out.println("Total nonempty ballots: " + validVotes);
      
      this.removeCandidates(cand);
      if(candCnt == 2) {
         this.winner = true;
      }         
      return cand;       
   }
   
   public boolean isWinner() {
      return this.winner;
   } 
   
   public String toString() {
      String temp = "";
      for(Ballot b : ballots) {
         temp += b.toString();// + "\n";
      }
      
      return temp;
   }
}

