package utils;

/**
 * A stop watch that measures time.
 *
 * @author hvy
 * @version 1.0
 */
public class StopWatch {

  private long startTimeMillis = 0;

  /**
   * Constructor.
   */
  public StopWatch() {
  }

  /**
   * Resets and starts the stop watch.
   */
  public void start() {
    startTimeMillis = System.currentTimeMillis();
  }

  /**
   * Stops the stop watch and returns the time interval since the last start in ms.
   *
   * @return The time interval in ms since the last start.
   */
  public float stop() {
    return System.currentTimeMillis() - startTimeMillis;
  }
}
