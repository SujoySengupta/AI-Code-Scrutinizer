package com.sujoy.AI.Code.Scrutinizer.Commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

//import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties.Restclient;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import com.sujoy.AI.Code.Scrutinizer.AiClient;


@ShellComponent
public class HelloCmd {
	private final AiClient client;
	public HelloCmd(AiClient client) {
		this.client = client;
	}
	
	@ShellMethod(key = "scrut", value = "Roast your code. Usage: scrut <file> --level <1-3>")
	public String scrut( 
		@ShellOption(help = "Path to the file") String filePath, 
	    @ShellOption(help = "1=Soft, 2=Spicy, 3=Toxic", defaultValue = "3") int level
	    ) {
		String content;
//		int level;
		try {
//			Scanner inp = new Scanner(System.in);
//			System.out.println("Enter the level of scrutiny that you prefer:");
//			System.out.println("Level 1 (Soft): \"A gentle, constructive code review.\"\r\n"
//					+ "\r\n"
//					+ "Level 2 (Spicy): \"Sarcastic comments, but helpful.\"\r\n"
//					+ "\r\n"
//					+ "Level 3 (Emotional Damage): \"Ruthless roasting, pure toxicity.\"");
//			level = inp.nextInt();
			
			content = Files.readString(Path.of(filePath));
			System.out.println("\nCooking...");
			return client.TheMain(content, level);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "Bruh man (" + e.getMessage() +")";
		}
	}
	
//	@ShellMethod(key = "hello", value = "Say Hello.")
//    public String hello(){
//    	return "Hey there!";
//    }
//	
//	@ShellMethod(key = "bye", value = "Say Bye.")
//    public String bye() {
//		return "Goodbye";
//	}
}
