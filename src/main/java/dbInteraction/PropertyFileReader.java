package dbInteraction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

public class PropertyFileReader {
    static HashMap<String,String> result;
   public static HashMap<String, String> getPropValues() throws IOException {
        InputStream inputStream = null;
       try {
            Properties prop = new Properties();
            String propFileName = "config.properties";
            inputStream = PropertyFileReader.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            Date time = new Date(System.currentTimeMillis());

            result = new HashMap<>();
            result.put("JAVA_APP_URI",      prop.getProperty("JAVA_APP_URI"));
            result.put("JAVA_APP_USERNAME", prop.getProperty("JAVA_APP_USERNAME"));
            result.put("JAVA_APP_PASSWORD", prop.getProperty("JAVA_APP_PASSWORD"));

            System.out.println("Properties Successfully Loaded On " + time);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            inputStream.close();
        }
        return result;
    }
}
