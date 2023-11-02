package Hwk6;

import java.util.PriorityQueue;

public class Ballot {
    private PriorityQueue<Candidate> rankings;

    public Ballot() {
        this.rankings = new PriorityQueue<>((c1, c2) -> Integer.compare(c1.getVoteCount(), c2.getVoteCount()));
    }

    public void addRanking(Candidate candidate) {
        rankings.add(candidate);
    }

    public Candidate getTopRankedCandidate() {
        return rankings.poll();
    }
}
