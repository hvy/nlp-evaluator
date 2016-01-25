package pos;

/**
 * A class that stores the evaluations results.
 *
 * @author hvy
 * @version 1.0
 */
public class PosEvaluation {

  private float mAccuracy;
  private float mRunningTimeMs;

  /**
   * Constructor.
   *
   * @param accuracy The accuracy in the range [0.0, 1.0].
   * @param runningTimeMs The running time measured in milliseconds.
   */
  public PosEvaluation(float accuracy, float runningTimeMs) {
    mAccuracy = accuracy;
    mRunningTimeMs = runningTimeMs;
  }

  /**
   * @return The accuracy.
   */
  public float getAccuracy() {
    return mAccuracy;
  }

  /**
   * @return The running time measured in milliseconds.
   */
  public float getRunningTimeMs() {
    return mRunningTimeMs;
  }

  /**
   * @return A formatted String.
   */
  @Override
  public String toString() {
    return "Accuracy: " + mAccuracy + "\nRunning time: " + (mRunningTimeMs / 1000) + "s";
  }
}

