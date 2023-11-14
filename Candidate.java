
/**
 * The Candidate class represents a candidate in an election.
 * Each candidate has a name, a vote count, and a rank.
 * @authors Alex W, Timothy T, Miles M
 * @version 13/11/2023  
 */
public class Candidate implements Comparable<Candidate>{
   private String name;
   private int voteCount;
   private int rank;
   
   public Candidate(String name, int theRank) {
      this.name = name;
      this.voteCount = 0;
      this.rank = theRank;
   }
   
   /**
    * Constructs a candidate with the given name and a rank of 1.
    * @param name the name of the candidate
    */
   public Candidate(String name) {
      this.name = name;
   }

   /**
    * Returns the name of the candidate.
    * @return the name of the candidate
    */
   public String getName() {
      return this.name;
   }
   
   /**
    * Returns the rank of the candidate.
    * @return the rank of the candidate
    */
   public int getRank() {
      return this.rank;
   }
   
   /**
    * Lower the rank of the candidate by 1.
    */
   public void lowerRank() {
      this.rank--;
   }

   /**
    * Returns the vote count of the candidate.
    * @return the vote count of the candidate
    */
   public int getVoteCount() {
      return voteCount;
   }

   /**
    * Increments the vote count of the candidate by 1.
    */
   public void incrementVoteCount() {
      voteCount++;
   }
   
   /**
    * Compares two candidates based on their rank.
    * @param c the candidate to compare to
    * @return 0 if the candidates have the same rank, -1 if this candidate has a lower rank, 1 if this candidate has a higher rank
    */
   @Override
   public int compareTo(Candidate c) {
      

      if (this.rank == c.rank) {
         return 0;
      } else if (this.rank < c.rank) {
         return -1;
      } else {
         return 1;
      }    
   }
   
   /**
    * Returns a string representation of the candidate.
    * @return a string representation of the candidate
    */
   public String toString() {
      return(this.rank + " = " + this.name + " ");
   }
}
