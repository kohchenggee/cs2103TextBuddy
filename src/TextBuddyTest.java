import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

public class TextBuddyTest {
	public String[] msg = new String[1];
	public String completeMSG="";
	@Test
	public void testMain() throws IOException {
		 
	}

	@Test
	public void testCheckArgExistence() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		 System.setOut(new PrintStream(outContent));
		 
		 TextBuddy.checkArgExistence(new String[] {"123.txt"});
		String expected= "";
		
		
		assertEquals(expected,outContent.toString().trim());
	}

	@Test
	public void testInitPrinter() {

	}


	@Test
	public void overAllRun() throws IOException {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		 System.setOut(new PrintStream(outContent));
		 TextBuddy.checkArgExistence(new String[] {"123.txt"});
		
		//Test display when empty
		String expected= "123.txt is empty";
		TextBuddy.initPrinter("123.txt");
		String input="display\n";
		TextBuddy.checkInput(new Scanner(input));
		assertEquals(expected,outContent.toString().trim());
		
		//Test add message
		outContent.reset();
		input="add fire";
		TextBuddy.checkInput(new Scanner(input));
		expected="fire has been added";
		assertEquals(expected,outContent.toString().trim());
		outContent.reset();
		
		input="add water";
		TextBuddy.checkInput(new Scanner(input));
		expected = "water has been added";
		assertEquals(expected,outContent.toString().trim());
		outContent.reset();
		
		input="add ice";
		TextBuddy.checkInput(new Scanner(input));
		expected = "ice has been added";
		assertEquals(expected,outContent.toString().trim());
		outContent.reset();
		
		//Test display when add messages
		input ="display";
		TextBuddy.checkInput(new Scanner(input));
		expected = "1. fire\n2. water\n3. ice\n";
		msg=outContent.toString().split("\n");
		completeMSG="";
		for(int i=0;i<msg.length;i++){
			completeMSG+=msg[i].trim()+"\n";
		}
		assertEquals(expected,completeMSG);
		outContent.reset();
		
		//Test search add msg
		input ="search fir";
		TextBuddy.checkInput(new Scanner(input));
		expected = "fire";
		assertEquals(expected,outContent.toString().trim());
		outContent.reset();
		
		//Test sorting the message
		input ="sort";
		TextBuddy.checkInput(new Scanner(input));
		expected = "all contents sorted";
		assertEquals(expected,outContent.toString().trim());
		outContent.reset();
		
		input ="display";
		TextBuddy.checkInput(new Scanner(input));
		expected = "1. fire\n2. ice\n3. water\n";
		msg=outContent.toString().split("\n");
		completeMSG="";
		for(int i=0;i<msg.length;i++){
			completeMSG+=msg[i].trim()+"\n";
		}
		assertEquals(expected,completeMSG);
		outContent.reset();
		
		//Test clear added messages
		input ="clear";
		TextBuddy.checkInput(new Scanner(input));
		expected = "all content deleted from 123.txt";
		assertEquals(expected,outContent.toString().trim());
		outContent.reset();
		
		//Test search empty storage
		input ="search 123";
		TextBuddy.checkInput(new Scanner(input));
		expected = "Keyword not found";
		assertEquals(expected,outContent.toString().trim());
		outContent.reset();
		//
		
	}

}
