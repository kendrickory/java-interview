package async;

import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;

import java.util.concurrent.CompletableFuture;

/**
 * You should complete the function in this class
 */
class AsyncTest {

  private static List<Enterprise> enterprises = List.of(
      new Enterprise("ent_1", "Google", "ceo_2"),
      new Enterprise("ent_2", "Facebook", "ceo_1")
  );

  private static List<Ceo> ceos = List.of(
      new Ceo("ceo_1", "Mark"),
      new Ceo("ceo_2", "Sundar"),
      new Ceo("ceo_3", "Bill")
  );
  public static Option<Ceo> getceo(String ceo_id)
  {
    for(int i =0; i<ceos.length();i++)
    {
      if(ceos.get(i).id.equals(ceo_id))
      {
        Option<Ceo> opceo = Option.of(ceos.get(i));
        return opceo;
      }
    }
    Option<Ceo> opnull = Option.none();
    return opnull;
  }
  public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id)
  {

    CompletableFuture<Option<Ceo>> res = CompletableFuture.supplyAsync(()->getceo(ceo_id));

    return res;

  }
  public static Option<Enterprise> getenterprise(String id)
  {
    for(int i = 0;i<enterprises.length();i++)
    {
      if(enterprises.get(i).ceo_id.equals(id))
      {
        Option<Enterprise> openter = Option.of(enterprises.get(i));
        return openter;
      }
    }
    Option<Enterprise> opnull = Option.none();
    return opnull;
  }
  public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id)
  {
    CompletableFuture<Option<Enterprise>> res = CompletableFuture.supplyAsync(()->getenterprise(ceo_id));
    return res;
  }

  public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id)
  {
    CompletableFuture<Tuple2<Option<Ceo>,Option<Enterprise>>> res = CompletableFuture.supplyAsync(()->new Tuple2<>(getceo(ceo_id),getenterprise(ceo_id)));
    return res;
  }

}
