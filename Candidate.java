package Hwk6;

/**
 * A candidate in an election.
 * @author Alex W, Timothy T, Miles M
 */
public class Candidate implements Comparable<Candidate> {
    private String name;
    private int voteCount;
    private boolean eliminated;

    public Candidate(String name) {
        this.name = name;
        this.voteCount = 0;
    }

   public String getName() {
      return name;
   }

   public int getVoteCount() {
      return voteCount;
   }

   public void incrementVoteCount() {
      voteCount++;
   }
   
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
