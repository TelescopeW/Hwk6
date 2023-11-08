package Hwk6;

import java.util.ArrayList;
import java.util.List;


/**
 * This class represents a single round of an election.
 * @author Alex W, Timothy T, Miles M
 * @version 1.1.0
 */
public class ElectionRound {
    private List<Candidate> candidates;
    private List<Ballot> ballots;
    
    public ElectionRound(List<Candidate> candidates, List<Ballot> ballots) {
        this.candidates = candidates;
        this.ballots = ballots;
    }

    public void runRound() {
        // Count votes for each candidate
        for (Candidate candidate : candidates) {
            candidate.setVoteCount(0);
        }

        for (Ballot ballot : ballots) {
            Candidate topRankedCandidate = ballot.getTopRankedCandidate();
            if (topRankedCandidate != null) {
                topRankedCandidate.incrementVoteCount();
            }
        }

        // Check for a winner
        Candidate winner = findWinner();
        if (winner != null) {
            // We have a winner! Print it out and exit
            System.out.println("Winner: " + winner.getName());
        } else {
            // Find and eliminate candidates with the fewest votes
            List<Candidate> eliminatedCandidates = findEliminatedCandidates();
            for (Candidate eliminatedCandidate : eliminatedCandidates) {
                eliminateCandidate(eliminatedCandidate);
            }
        }
    }

    /**
     * @return the candidate with the majority of votes (over 50%), or null if no candidate has a majority
     */
    public Candidate findWinner() {
        int totalVotes = 0;
        for (Candidate candidate : candidates) {
            totalVotes += candidate.getVoteCount();
            if (totalVotes > ballots.size() / 2) {
                return candidate;
            }
        }
        return null;
    }

    /**
     * @return a list of candidates with the fewest votes, considering ties
     */
    public List<Candidate> findEliminatedCandidates() {
        int minVotes = Integer.MAX_VALUE;
        List<Candidate> candidatesWithMinVotes = new ArrayList<>();

        for (Candidate candidate : candidates) {
            int votes = candidate.getVoteCount();
            if (votes < minVotes) {
                minVotes = votes;
                candidatesWithMinVotes.clear();
                candidatesWithMinVotes.add(candidate);
            } else if (votes == minVotes) {
                candidatesWithMinVotes.add(candidate);
            }
        }

        return candidatesWithMinVotes;
    }

    /**
     * Eliminates the specified candidate from the election.
     * @param eliminatedCandidate the candidate to eliminate
     */
    private void eliminateCandidate(Candidate eliminatedCandidate) {
        eliminatedCandidate.setEliminated(true);
        candidates.remove(eliminatedCandidate);

        // Remove the eliminated candidate from the ballots
        for (Ballot ballot : ballots) {
            ballot.removeCandidate(eliminatedCandidate);
        }
    }
}




