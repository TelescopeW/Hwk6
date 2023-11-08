package Hwk6;

import java.util.List;

public class RCVProcessor {
    private List<Candidate> candidates;
    private List<Ballot> ballots;

    public RCVProcessor(List<Candidate> candidates, List<Ballot> ballots) {
        this.candidates = candidates;
        this.ballots = ballots;
    }

    public void runElection() {
        int round = 1;
        Candidate winner = null;

        while (winner == null) {
            ElectionRound electionRound = new ElectionRound(candidates, ballots);
            electionRound.runRound();
            
            // Check if there's a winner
            winner = electionRound.findWinner();
            
            // If there's no winner, proceed to the next round
            if (winner == null) {
                Candidate eliminatedCandidate = electionRound.findEliminatedCandidates().get(0);
                System.out.println("Round " + round + ": " + eliminatedCandidate.getName() + " eliminated.");
                round++;
            }
        }
        
        // Declare the overall winner
        System.out.println("Winner: " + winner.getName());
    }
}
