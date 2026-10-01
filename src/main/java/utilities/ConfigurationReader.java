package utilities;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public final class ConfigurationReader {
    private static final Properties properties = new Properties();

     static {
         try (InputStream inputStream = ConfigurationReader.class.getClassLoader()
                 .getResourceAsStream("config.properties")){
             if (inputStream == null){
                 throw new RuntimeException("config.properties file was not found");

             }
             properties.load(inputStream);
         } catch (IOException exception) {
             throw new RuntimeException("Unable to load config.properties",exception);
         }
     }
     private ConfigurationReader(){

     }
     public static String getProperty(String key){
         return properties.getProperty(key);
     }
}
