package Hwk6;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * User interface for the program.
 * @author Alex W, Timothy T, Miles M
 * @version 1.1.0
 */
public class UserInterface{
   
   /**
    * Main method for the program
    * @param args command line arguments
    */
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
         
         while(look.hasNextLine()){
            PriorityQueue<Candidate> rankings = new PriorityQueue<>();//maybe remove

            Ballot aBallot = new Ballot();
            int count = 0;
            String line = look.nextLine();
            line = line.replaceAll("#", "");//remove all special characters
            String[] ranks = line.split(",");
            System.out.println(Arrays.toString(ranks));
            for(String s : ranks) {
               Scanner word = new Scanner(s);
               if(word.next().equals("Ranked")) {
                  Candidate c = new Candidate(theCandidates[count], word.nextInt());
                  //aBallot.addRanking(c);
                  rankings.offer(c);
               }
               count++;
               

            }
            //System.out.print(aBallot.toString());            
            ballots.offer(aBallot);
            //System.out.println(ballots.toString());
            /*
            Scanner line = new Scanner(look.nextLine());
            if(line.next().equals("Ranked")){
               System.out.println(line.nextInt());
               int rank = line.nextInt();
               Candidate c = new Candidate(theCandidates[count], rank);
               aBallot.addRanking(c);
            }
            count++;
            */
         }
         ElectionRound election = new ElectionRound(ballots);
         
      }catch(FileNotFoundException e){
         System.out.println("File not found: " + e);
      }
      
   }
}