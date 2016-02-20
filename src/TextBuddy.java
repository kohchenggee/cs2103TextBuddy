import java.util.*;
import java.io.*;
/**
* This code is a Command Line Interface program used to manipulate text in a file.
* that input.
<<<<<<< HEAD
*test12345
=======
*
>>>>>>> parent of f891418... Second
* Commands:
* 1. add
* 2. display
* 3. delete
* 4. clear
* 5. exit
*
* @author Koh Cheng Gee A0126199W
*
*/
public class TextBuddy{
  private static ArrayList<String> list=new ArrayList<String>();
  private static String input;
  private static String dest;
  private static PrintWriter printWriter;
  
  /*************** Attributes **************/ 
  private static final String MESSAGE_WELCOME_FORMAT = "Welcome to TextBuddy. %1$s is ready for use"; 
  private static final String MESSAGE_ERROR = "Invalid Input!"; 
  private static final String MESSAGE_ERROR_FILENAME = "Error! Please Insert Filename!"; 
  private static final String MESSAGE_ADD_FORMAT = "%s has been added"; 
  private static final String MESSAGE_DELETE_FORMAT = "deleted from %1$s: \"%2$s\"";
  private static final String MESSAGE_EMPTY_FORMAT = "%1$s is empty";
  private static final String MESSAGE_CLEAR_FORMAT = "all content deleted from %1$s";
  private static final String MESSAGE_SORTED = "all contents sorted";
  private static final String MESSAGE_SEARCH_FAIL = "Keyword not found";
  private static final String MESSAGE_NOT_FOUND = "Data Not Exist";
  
  public static void main(String args[]) throws IOException {
    checkArgExistence(args);
    initPrinter(dest);
    run();

  }
  /**
  * This method checks the validity of filename.
  * 
  */ 
  public static void checkArgExistence(String args[]){
    if(args.length!=1){
      System.out.println(MESSAGE_ERROR_FILENAME);
      System.exit(0);
    }
    dest=args[0];
    
  }
  
  /**
   * This method initializes the PrintWriter to the file.
   * 
   */ 
  public static void initPrinter(String dest) throws IOException{

    printWriter = new PrintWriter (dest);
  }
  public static void run(){
	System.out.printf(MESSAGE_WELCOME_FORMAT,dest);
    Scanner sc = new Scanner(System.in);
    while(true){
      checkInput(sc);
    }
  }
  public static void checkInput(Scanner sc){
    input=sc.next();
      if(input.equalsIgnoreCase("add")){
        addLine(sc);

      }else if(input.equalsIgnoreCase("delete")){
        deleteLine(sc);
      }else if(input.equalsIgnoreCase("display")){
        displayList();
      }else if(input.equalsIgnoreCase("clear")){
        clearList();
      }else if(input.equalsIgnoreCase("exit")){
        for(int i=0;i<list.size();i++){
          printWriter.println(list.get(i));
        } printWriter.close();
        System.exit(0);
      }else if(input.equalsIgnoreCase("sort")){
    	  sortList();
      }else if(input.equalsIgnoreCase("search")){
    	  searchList(sc);
      }else{
      
        System.out.println(MESSAGE_ERROR);
      }
    
  }

  public static void addLine(Scanner sc){
        input=sc.nextLine();
        input=input.substring(1);
        list.add(input);
        System.out.printf(MESSAGE_ADD_FORMAT,input);
  }
  public static void deleteLine(Scanner sc){
    int i;
        i=sc.nextInt();
        if((i-1)<=list.size()){
          System.out.printf(MESSAGE_DELETE_FORMAT,dest,list.get(i-1));
          list.remove(i-1);
        }else{
          System.out.println(MESSAGE_NOT_FOUND);
        }
  }
  public static void displayList(){
	  
    if(list.size()==0){
    	System.out.printf(MESSAGE_EMPTY_FORMAT,dest);
        }else{
          for(int i=0;i<list.size();i++){
            int index=i+1;
            System.out.println(index+". "+list.get(i));
          }
        }
  }
  public static void searchList(Scanner sc){
	  boolean searchChecking=false;
	  input=sc.nextLine();
	  input=input.substring(1);
	  for(int i=0;i<list.size();i++){
		  if(list.get(i).contains(input)){
			  System.out.println(list.get(i));
			  searchChecking=true;
		  }
	  }
	  if(!searchChecking){
		  System.out.println(MESSAGE_SEARCH_FAIL );
	  }
  }
  public static void clearList(){
    list.clear();
    System.out.printf(MESSAGE_CLEAR_FORMAT,dest);
    
  }
  public static void sortList(){
	  Collections.sort(list);
	  System.out.println(MESSAGE_SORTED);
  
  }
    
}