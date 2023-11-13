public class Candidate implements Comparable<Candidate>{
   private String name;
   private int voteCount;
   private int rank;
   
   public Candidate(String name, int theRank) {
      this.name = name;
      this.voteCount = 0;
      this.rank = theRank;
   }
   
   public Candidate(String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }
   
   public int getRank() {
      return this.rank;
   }
   
   public void lowerRank() {
      this.rank--;
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
