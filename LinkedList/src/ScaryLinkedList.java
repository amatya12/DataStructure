import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ScaryLinkedList {
	public static void main(String[] args) {

		try {
			File file = new File("names.txt"); // We open our file using the File class, and pass in as an argument the
												// location of the file.
			FileReader fileReader = new FileReader(file); // We then pass the file variable we just created to the
															// FileReader class to allow us to read the specified file.
			BufferedReader bufferedReader = new BufferedReader(fileReader); // However, by using the BufferedReader
																			// class with the fileReader, we can be more
																			// efficient in our reads.
			StringBuffer stringBuffer = new StringBuffer(); // Then as we read the file we will use the StringBuffer
															// class to create a String from what is read in from the
															// file
															// no matter the type.
			String line; // We will use this as a holder for what we are reading in.
			while ((line = bufferedReader.readLine()) != null) { // As long as we do not have a null String (so we are
																	// still reading lines from the file), we will
					System.out.println(line);												// continue.
				//stringBuffer.append(line); // adds the newest line to our stringBuffer
			}
			bufferedReader.close(); // Close the bufferedReader we used since we are finished.
			fileReader.close(); // We close the fileReader as well.
			// Then we print out the contents of the file with a pre-face letting us know
			// and then using the toString() method from the stringBuffer class.
			//System.out.println("Contents of file:");
			//System.out.println(stringBuffer+"\n");
		} catch (IOException e) { // Here, if an IOException is thrown by any of the above statements we will
									// catch it, and then print off from the stack the last of what was happening
			// so that we can have some detail of what went wrong and where. Then we exit
			// the program.
			e.printStackTrace();
			System.exit(1);
		}
	}
}
