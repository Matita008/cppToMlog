package utilities;

import java.util.*;
import java.io.*;

/**
 * 
 */
public final class jsonReader {
	private File file;
	@SuppressWarnings("unused")
	private HashMap<String, Object> content = new HashMap<String, Object>();

	/*public jsonReader(File file (String name)-> {File file = new File(name)}) {
		this(file);
	}*/

	public jsonReader(File file) throws FileNotFoundException {
		this.file = file;
		scanFile();
	}

	private void scanFile() throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		scanFile(scanner);
	}

	private void scanFile(Scanner scanner) {

	}
}
