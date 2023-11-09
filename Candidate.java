package Hwk6;

/**
 * A candidate in an election.
 * @author Alex W, Timothy T, Miles M
 */
public class Candidate implements Comparable<Candidate> {
    private String name;
    private int voteCount;
    private int rank;

    public Candidate(String name, int theRank) {
        this.name = name;
        this.voteCount = 0;
        this.rank = theRank;
    }

    /**
     * Returns the name of this candidate.
     * @return the name of this candidate
     */
   public String getName() {
      return name;
   }

   /**
    * Returns the number of votes for this candidate.
    * @return the number of votes for this candidate
    */
   public int getVoteCount() {
      return voteCount;
   }

   /**
    * Increments the vote count for this candidate.
    */
   public void incrementVoteCount() {
      voteCount++;
   }
   
   /**
    * @return the rank of this candidate
    */
   @Override
   public int compareTo(Candidate c) {
      //return Integer.compare(this.rank, c.rank);

      if (this.rank == c.rank) {
         return 0;
      } else if (this.rank < c.rank) {
         return -1;
      } else {
         return 1;
      }    
   }
   
   public String toString() {
      return(this.rank + " = " + this.name + " ");
   }
}
