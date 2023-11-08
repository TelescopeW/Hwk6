package Hwk6;

/**
 * A candidate in an election.
 * @author Alex W, Timothy T, Miles M
 * @version 1.1.0
 */
public class Candidate implements Comparable<Candidate> {
    private String name;
    private int voteCount;
    private boolean eliminated;

    public Candidate(String name) {
        this.name = name;
        this.voteCount = 0;
    }

    /**
     * @return the name of the candidate
     */
    public String getName() {
        return name;
    }

    /**
     * @return the number of votes the candidate has
     */
    public int getVoteCount() {
        return voteCount;
    }

    /**
     * Increments the vote count of the candidate by 1.
     */
    public void incrementVoteCount() {
        voteCount++;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }

    /**
     * Compares this candidate to another candidate by their vote count.
     * @param other the candidate to compare to
     * @return a negative integer if this candidate has less votes than the other candidate,
     *         a positive integer if this candidate has more votes than the other candidate,
     *         and 0 if this candidate has the same number of votes as the other candidate
     */
    public int compareTo(Candidate other) {
        return Integer.compare(this.voteCount, other.voteCount);
    }
}
