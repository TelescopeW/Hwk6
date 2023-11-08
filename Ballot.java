package Hwk6;

import java.util.PriorityQueue;

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

}
