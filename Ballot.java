
import java.util.PriorityQueue;

public class Ballot {
    private PriorityQueue<Candidate> rankings;

    public Ballot() {
        this.rankings = new PriorityQueue<>();
    }

    public void addRanking(Candidate candidate) {
        rankings.offer(candidate);
    }

    public Candidate getTopRankedCandidate() {
        return rankings.poll();
    }
    
    
    public String toString(){
      String temp = "";
      for(Candidate c : rankings) {
         temp+=(c.toString()+",");
      }
      return temp+"\n";
    }
}
