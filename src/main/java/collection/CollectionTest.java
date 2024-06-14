package collection;

import java.util.List;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {


  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   */
  public static List<Double> compute1(List<Integer> input) {

    List<Double> lres = new ArrayList<Double>();
    for(int i = 0; i<input.size();i++)
    {
      Double d = Double.valueOf((input.get(i)*2)+3);
      for(int j=0; j<5;j++)
      {
        d *=d;
      }
      lres.add(d);
    }
    return lres;

  }

  /**
   * operation : abc -> AbcAbc
   */
  public static List<String> compute2(List<String> input) {

    List<String> lres = new ArrayList<String>();
    for(int i = 0; i<input.size();i++)
    {
      if(input.get(i).length()>0)
      {
        String firstp = input.get(i).substring(0,1).toUpperCase();
        if(input.get(i).length()>1)
        {
          String secondp = input.get(i).substring(1, input.size());
          lres.add(firstp+secondp+firstp+secondp);
        }
        else
        {
          lres.add(input.get(i).toUpperCase());
        }
      }
      else
      {
        lres.add("");
      }
    }
    return lres;


  }

}
