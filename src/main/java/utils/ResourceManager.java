package utils;

import java.io.File;
import java.net.URL;

/**
 * A class that is responsible for fetching resource files.
 *
 * @author hvy
 * @version 1.0
 */
public class ResourceManager {

  /**
   * Returns a list of files in the given directory path, or null if no such directory exsists.
   *
   * @param dirPath The path to the directory containing all the files.
   * @return A list of files, if the given directory is found, null otherwise.
   */
  public static File[] getResourceFiles(String dirPath) {

    ClassLoader classLoader = ResourceManager.class.getClassLoader();
    URL resourceUrl = classLoader.getResource(dirPath);

    if (resourceUrl != null) {
      File dir = new File(resourceUrl.getFile());
      if (dir.isDirectory()) {
        // Return all files in the given directory, since the directory was found
        return dir.listFiles();
      }
    }

    return null;
  }
}

