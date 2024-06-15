package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

  /**
   * return i ^ n for positive Integer, None otherwise
   * alse return None in case of errors
   */
  public static Option<Integer> power(Integer i, Integer n) {

    if(i>=0 && n>=0)
    {
      try
      {
        Integer res = Integer.valueOf(1);
        for(int j =0; j<n;j++)
        {
          res*=i;
        }
        Option<Integer> ores = Option.of(res);
        return ores;
      }
      catch(Exception e)
      {
        Option<Integer> onull = Option.of(null);
        return onull;
      }
    }
    return Option.of(null);

  }
}
