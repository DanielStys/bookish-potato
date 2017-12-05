import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;
public class FileHandlingWrokBook
{ 
   public static void main(String[] args) throws IOException
   {
       boolean choice = true;
       Scanner input = new Scanner(System.in);
       do {
           System.out.println("Select A program to run:");
           System.out.println("1 = First Task");
           System.out.println("2 = Second Task");
           System.out.println("3 = ");
           System.out.println("4 = ");
           System.out.println("5 = ");
           int selection = input.nextInt();
           switch (selection){
                case 1: option1();
                break;
                case 2: option2();
        }
        System.out.println("Would you like to continue? true/false");
        choice = input.nextBoolean();
        }while (choice == true);
   }
   
   public static void option1()throws IOException
   {
       Scanner input = new Scanner(System.in);
       FileReader fr = new FileReader("U:\\files\\theCode.txt");
       BufferedReader br = new BufferedReader(fr);
       String mytext = br.readLine();
       do {
           System.out.println(mytext);
       }while((mytext = br.readLine()) != null);
       br.close();
   }
   
   public static void option2() throws IOException
   {
       String students[][] ={{"Sophie","Stanfield","Class 5"},{"James","Kitson","Class 5"},
       {"Zoe","Gasgill","Class 1"},{"Paul","Johns","Class 2"},{"Freya","Moore","Class 5"}};
       FileWriter fw = new FileWriter("C:\\Users\\Daniel\\Desktop\\data.txt",true);
       BufferedWriter bw = new BufferedWriter(fw);
       for (int x = 0; x < 5; x++){
           for(int y = 0; y < 3; y++){
               bw.write(students[x][y] + "\t");
           }
           bw.write("\n");
       }
       bw.close();
   }
   
   public static void option3() throws IOException
   {   
       FileReader fr = new FileReader("C:\\Users\\Daniel\\Desktop\\products.txt");
       BufferedReader br = new BufferedReader(fr);
       String products[][] = new String [5][2];
       for(int x = 0; x < 5; x++){
           String line = br.readLine();
           products[x][0] = line.substring(0,5);//Assigns first 5 chars to first column
           System.out.println("PRODUCT CODE: "+products[x][0]); 
           products[x][1] = line.substring(5);//Assigns everything past 5th char to 2nd column
           System.out.println("        NAME: "+products[x][1]);
       }
   } 
   
   public static void option4() throws IOException
   {
       boolean lotteryNumbers[] = new boolean [50];
       int numberOfSelectedBalls = 0;
       do{
           int winningBall = (int) (Math.floor(Math.random() * 50)+1);
           if(lotteryNumbers[winningBall] == false){
               lotteryNumbers[winningBall] = true;
               numberOfSelectedBalls++;
           }
       }while(numberOfSelectedBalls != 6);
       FileWriter fw = new FileWriter("C:\\Users\\Daniel\\Desktop\\lottery.txt",true);
       BufferedWriter myFile = new BufferedWriter(fw);
       for (int i = 1; i < 50; i++){
           if(lotteryNumbers[i]==true){
               myFile.write(i + "\t");
           }
       }
       myFile.newLine();
       myFile.close();
   }
   
   public static void SearchDescriptionsForKeyword() throws IOException{
       Scanner input = new Scanner(System.in);
       System.out.println("Enter a keyword to search descriptions for");
       String keyword = input.nextLine();
       keyword.toLowerCase();
       System.out.println("Keyword is: " +keyword);
       FileReader fr = new FileReader("C:\\Users\\Daniel\\Desktop\\words.txt");
       BufferedReader br = new BufferedReader(fr);
       String line = br.readLine();
       String prevLine = "";
       int timesFound = 0;
       do{ 
           prevLine = line;
           line = br.readLine();
           if (line.contains(keyword)){
               System.out.println("FOUND for the word: "+ prevLine);
               System.out.println(line);
               timesFound++;
           }
       }while ((line = br.readLine()) != null);
       if (timesFound == 0){
           System.out.println("NO MATCHES FOUND");
       }
  
   }
   
   public static void SearchByTerm()throws IOException
   {   
       Scanner input = new Scanner(System.in);
       System.out.println("Enter a word to search for");
       String searchItem = input.nextLine();
       searchItem.toLowerCase();
       System.out.println("Your SearchItem is:" +searchItem);
       FileReader fr = new FileReader("C:\\Users\\Daniel\\Desktop\\words.txt");
       BufferedReader br = new BufferedReader(fr);
       String line = br.readLine();
       boolean found = false;
       do{ 
           if(line.equals(searchItem)){
               System.out.println("FOUND: "+searchItem);
               System.out.println(br.readLine());
               found = true;
               break;
           }
       }while ((line = br.readLine()) != null ||(found = false));
       if (found == false){
           System.out.println("NO MATCHES FOUND");
        }
   }
   public static void option5()throws IOException
   {
       Scanner input = new Scanner(System.in);
       String choice = "";
       do{
           System.out.println("1.Search for a term");
           System.out.println("2. Search for a keyword in the descriptions");
           System.out.println("3.Search for a term");
           System.out.println("Key in choice");
           choice = input.nextLine();
           switch (choice){
               case "1": SearchByTerm();
               break;
               case "2": SearchDescriptionsForKeyword();
               break;
           }
       }while (!choice.equals("3"));
   }
}
