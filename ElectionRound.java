
import java.util.*;

public class ElectionRound {
    private Queue<Ballot> ballots;
    private String eliminatedCandidate;
    private int totalValidBallots;

    public ElectionRound(Queue<Ballot> theBallots) {
        this.ballots = theBallots;
        this.eliminatedCandidate = null;
        this.totalValidBallots = 0;
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
    
    
    public String toString() {
      String temp = "";
      for(Ballot b : ballots) {
         temp += b.toString() + "\n";
      }
      
      return temp;
    }
}

