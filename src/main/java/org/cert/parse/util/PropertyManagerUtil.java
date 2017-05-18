package org.cert.parse.util;

import java.util.ResourceBundle;
import java.io.*;

public class PropertyManagerUtil {
	
	public static String readCertFile() throws FileNotFoundException{
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		 String filename = bundle.getString("file.name");
		 return filename;
	}
}
