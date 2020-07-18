import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//storage class to save filename and value as a key value pair.
class Storage {
	String fileName;
	String Value;
}
public class AakashShell {
	
	//It prints the content in the single line.
	public static void pr(String message) {
		System.out.print(message);
	}
	//It prints the content and moves to next line.
	public static void prl(String message) {
		System.out.println(message);
	}

	public static void main(String[] args) throws IOException {
		
		String shellName = "$ AKAM > "; // shell name (derived from first two letter of firstname and lastname) Aakash Amatya.
		
		//Defined ArrayList to store text file.
		ArrayList<Storage> storage = new ArrayList<Storage>();
		
		//List of available commands.
		String[] commands = new String[] {"echo", "cat","exit","help","clear"};
		
		while(true) {
			
		 try {
			pr(shellName);
			Scanner input = new Scanner(System.in); //Scanner class to request user input..
			String line = input.nextLine();
			
			if(line=="") {
				continue;
			}
		
			//Logic to check if the input command is valid or not.
			int spaceIndex = line.indexOf(" ");
			String cmd ="";
			if(spaceIndex != -1) {
			 cmd = line.substring(0,spaceIndex).trim();
			}
			else {
				cmd = line;
			}
			boolean isCmdValid = false;
			for(int i = 0; i<commands.length; i++) {
				if(cmd.equals(commands[i])) {
					isCmdValid = true;
					break;
				}
			}
			if(isCmdValid == false) {
				prl("Invalid Command. Type help to get available commmands.");
				continue;
			}
		
			
			//Exit command
			if (line.equals("exit") || line.equals("quit")) {
                prl("Exiting AKAM shell");
                System.exit(0);
            }
			
			//echo command
			if(line.startsWith("echo") && !line.endsWith("txt")) {
				try {
					char[]  stringToArray = line.toCharArray();
					if(stringToArray[stringToArray.length-1] != 34) {
						prl("Invalid command Hint: put the text after echo in double inverted comma");
						continue;
					}
					String result="";
					int i = 0;
					while(stringToArray[i] != 34 && i<stringToArray.length-1) {
						i++;
					}
					
					for(int z = i+1;z<stringToArray.length-1;z++) {
						 result += stringToArray[z]+"";
					}
					prl(result);
					continue;
				}
				catch(Exception e) {
					prl("Invalid Command");
					continue;
				}
			}
			
		
			// echo pipeline to save into a txt file.
			if(line.endsWith("txt") && line.startsWith("echo")) {
				try {				
					int startingInvertedComma = 0;
					int endingInvertedComma = 0;
					char[] stringToArray = line.toCharArray();
					int i = 0;
					while(stringToArray[i] != 34) {
						i++;
					}
					i++;
					startingInvertedComma = i;
					while(stringToArray[i] != 34) {
						i++;
					}
					endingInvertedComma = i;
					String textToBeStored= line.substring(startingInvertedComma,endingInvertedComma);
				
					while(stringToArray[i] != 62) {
						i++;
					}
					i++;
					String fileName = line.substring(i,line.length());
					fileName = fileName.trim();
					
					Storage s = new Storage();
					s.fileName = fileName;
					s.Value = textToBeStored;
					int q = 0;
					boolean doesExist = false;
					while(q < storage.size()) {
						Storage existingFile = storage.get(q);
						if(existingFile.fileName.equals(fileName)) {
							doesExist = true;
							prl("Filename already exists. please write to different filename.");
							break;
						}
						q++;
						
					}
					if(!doesExist) {
						storage.add(s);
						prl("wrote to file "+ fileName);
					}
					continue;
				}
				catch(Exception e) {
					prl("Invalid Command");
					continue;
				}
			}
			
			//cat command - to print contents of the filename.
			if(line.startsWith("cat")) {
				int s = line.indexOf(" ");
				String fileName = line.substring(s+1,line.length());
				fileName = fileName.trim();
				boolean doesExist = false;
				for(int i = 0; i< storage.size(); i++) {
					Storage st = storage.get(i);
					if(st.fileName.equals(fileName)) {
						doesExist = true;
						prl(st.Value);
						break;
					}
				}
				if(!doesExist) {
					prl("Filename "+ fileName + " does not exist" );
		
				}
				continue;
				
			}
			
			// Help command to see available commands.
			if(line.startsWith("help")) {
				prl("Welcome to AKAM shell");
				prl("SUPPORTED COMMANDS");
				prl("echo -> prints the text written after echo command");
				prl("exit -> It exits the shell");
				prl("echo 'test' -> out.txt -> It copies the text to a filename out.txt");
				prl("cat filename -> It displays the text stored in the filename");
				prl("clear -> It clears the console");
				continue;
			}
			
			// Clear command to clear the screen.
			if(line.startsWith("clear")) {
				System. out. print("\033[H\033[2J");
				System. out. flush();
			}
		}
		catch(Exception e)
		{
			 prl("Invalid Command");
				continue;
		}
			
		
		}
		
	}
}
