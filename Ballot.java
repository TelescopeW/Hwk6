package Hwk6;

import java.util.PriorityQueue;

/**
 * A ballot in an election.
 * @author Alex W, Timothy T, Miles M
 * @version 1.1.0
 */
public class Ballot {
    private PriorityQueue<Candidate> rankings;

    public Ballot() {
        this.rankings = new PriorityQueue<>();
    }

    public void addRanking(Candidate candidate) {
        rankings.add(candidate);
    }

    public Candidate getTopRankedCandidate() {
        return rankings.poll();
    }

    /**
     * Removes the specified candidate from the ballot.
     * @param candidate the candidate to be removed
     */
    public void removeCandidate(Candidate candidate) {
        // Create a temporary list to store rankings without the specified candidate
        PriorityQueue<Candidate> updatedRankings = new PriorityQueue<>();
        
        // Remove the specified candidate from the rankings
        while (!rankings.isEmpty()) {
            Candidate currentCandidate = rankings.poll();
            if (!currentCandidate.equals(candidate)) {
                updatedRankings.add(currentCandidate);
            }
        }
        
        // Update the rankings with the removed candidate
        rankings = updatedRankings;
    }

    public String toString(){
        String temp = "";
        for(Candidate c : rankings) {
           temp+=(c.toString()+",");
        }
        return temp+"\n";
      }

}
