import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class UserInterface{
   
   public static void main(String[] args){
   
      Scanner scan = new Scanner(System.in);
      System.out.print("Please input file: ");
      File file = new File(scan.nextLine());
      while(!file.exists()) {//loop until user enters a valid file
         System.out.print("File not found\nPlease input file: ");
         file = new File(scan.nextLine());
      }
      
      
      try{
         Scanner look = new Scanner(file);
         String candidates = look.nextLine();
         String[] theCandidates = candidates.split(",");
         System.out.println(candidates);
         
         
         
         Queue<Ballot> ballots = new LinkedList<>();
         System.out.println("===============================");
         System.out.println("Ranked-Choice Vote Ballot Counter");
         System.out.println("===============================");
         
         int ballotCount = 0;
         while(look.hasNextLine()){ // loop through each ballot line
            ballotCount++;
            Ballot aBallot = new Ballot();
            int count = 0;
            String line = look.nextLine(); //get teh next line
            line = line.replaceAll("#", ""); //remove all special characters
            String[] ranks = line.split(","); //separate the rankings
            //System.out.println(Arrays.toString(ranks));
            for(String s : ranks) {
               Scanner word = new Scanner(s);
               if(word.next().equals("Ranked")) {
                  Candidate c = new Candidate(theCandidates[count], word.nextInt());
                  aBallot.addRanking(c);
               }
               count++;
               
            
            }
            if(aBallot.check()){
               ballots.offer(aBallot);
            }
         }
         
         ElectionRound election = new ElectionRound(ballots);
         
         System.out.println(ballotCount + " ballots received");
         
         String winner = null;
         int round = 1;
         while(!election.isWinner()) {
            System.out.println();
            System.out.println("--------------------------------Round " + round + 
                               "--------------------------------");
            winner = election.run();// The loser of each round, or winner if majority vote

            System.out.println();
            System.out.println(winner + " eliminated.");
            System.out.println();
            round++;
         }
         System.out.println("--------------------------------RESULTS--------------------------------");
         System.out.println("WINNER BY MAJORITY: [" + ballots.peek().peek().getName() + "]");
         System.out.println("-----------------------------------------------------------------------");
         election.run();      
         
      }catch(FileNotFoundException e){
         System.out.println("File not found: " + e);
      }
      
   }
}