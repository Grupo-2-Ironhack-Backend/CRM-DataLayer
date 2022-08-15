package dbInteraction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class PropertyFileReader {
    static String[] result;
   public static String[] getPropValues() throws IOException {
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

            // get the property value
            String prop1 = prop.getProperty("JAVA_APP_URI");
            String prop2 = prop.getProperty("JAVA_APP_USERNAME");
            String prop3 = prop.getProperty("JAVA_APP_PASSWORD");

            //after values are loaded you can do anything with them
            //here I will set them as System properties
            //System.setProperty("JAVA_APP_URI",prop1);
            //System.setProperty("JAVA_APP_USERNAME",prop2);
            //System.setProperty("JAVA_APP_PASSWORD",prop3);

            result = new String[]{prop1, prop2, prop3};
            System.out.println("Properties Successfully Loaded On " + time);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            inputStream.close();
        }
        return result;
    }
}
