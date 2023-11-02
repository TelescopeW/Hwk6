package Hwk6;

import java.util.List;

public class ElectionRound {
    private List<Candidate> candidates;
    private String eliminatedCandidate;
    private int totalValidBallots;

    public ElectionRound(List<Candidate> candidates) {
        this.candidates = candidates;
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
}

