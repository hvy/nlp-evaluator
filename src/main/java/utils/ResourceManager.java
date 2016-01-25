package utils;


import java.io.File;
import java.net.URL;
import java.nio.file.Files;

/**
 * Created by hiroyuki on 25/01/2016.
 */
public class ResourceManager {

  public static File[] getResourceFiles(String dirPath) {
    ClassLoader classLoader = ResourceManager.class.getClassLoader();
    URL resourceUrl = classLoader.getResource(dirPath);
    if (resourceUrl != null) {
      File dir = new File(resourceUrl.getFile());
      if (dir.isDirectory()) {
        return dir.listFiles();
      }
    }
    return null;
  }

  public static File getResourceFile(String filePath) {
    ClassLoader classLoader = ResourceManager.class.getClassLoader();
    URL resourceUrl = classLoader.getResource(filePath);
    if (resourceUrl != null) {
      return new File(resourceUrl.getFile());
    }
    return null;
  }
}
