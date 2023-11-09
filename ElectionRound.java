package Hwk6;

import java.util.*;

/**
 * A round of an election.
 * 
 * @version 1.1.0
 */
public class ElectionRound {
    private Queue<Ballot> ballots;
    private String eliminatedCandidate;
    private int totalValidBallots;

    public ElectionRound(Queue<Ballot> theBallots) {
        this.ballots = theBallots;
        this.eliminatedCandidate = null;
        this.totalValidBallots = 0;
    }

    /**
     * Returns the next ballot in this round.
     * @return the next ballot in this round
     */
    public String getEliminatedCandidate() {
        return eliminatedCandidate;
    }

    /**
     * Returns the next ballot in this round.
     * @return the next ballot in this round
     */
    public void setEliminatedCandidate(String eliminatedCandidate) {
        this.eliminatedCandidate = eliminatedCandidate;
    }

    /**
     * Returns the next ballot in this round.
     * @return the next ballot in this round
     */
    public int getTotalValidBallots() {
        return totalValidBallots;
    }

    /**
     * Returns the next ballot in this round.
     * @return the next ballot in this round
     */
    public void incrementTotalValidBallots() {
        totalValidBallots++;
    }
    
    /**
     * Returns the number of ballots in this round.
     * @return the number of ballots in this round
     */
    public String toString() {
      String temp = "";
      for(Ballot b : ballots) {
         temp += b.toString() + "\n";
      }
      
      return temp;
    }
}

