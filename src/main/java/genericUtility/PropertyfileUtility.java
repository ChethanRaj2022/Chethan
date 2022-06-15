package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyfileUtility {
	/**
	 *   its used return the value from the property file based on key
	 * @param key
	 * @return value
	 * @throws Throwable
	 */

	public String getPropertyKeyvalue(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./data/Pr.properties");
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
		
	}

}
