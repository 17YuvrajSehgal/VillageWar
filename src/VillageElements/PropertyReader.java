package VillageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

/**
 * This class helps to read the properties file in the resources' pkg.
 */
public class PropertyReader implements Serializable {

    /**
     * This methods reads the properties from the given file
     * @return properties object of the levels.properties file
     */
    public static Properties readPropertiesFile(){
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream("src/resources/levels.properties");
            prop = new Properties();
            prop.load(fis);
        } catch(IOException exception) {
            exception.printStackTrace();
        } finally {
            assert fis != null;
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop;
    }
}
