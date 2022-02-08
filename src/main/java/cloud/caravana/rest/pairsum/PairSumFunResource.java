package cloud.caravana.rest.pairsum;

import cloud.caravana.algo.pairsum.PairSum;

import static cloud.caravana.Util.*;
import java.util.Arrays;
import java.util.function.BiFunction;

import javax.ws.rs.*;

@Path("/pairsumfun")
public class PairSumFunResource {

    @Path("/{variant}")
    public String getPairSum(@PathParam("variant") @DefaultValue("iter") String variant,
                             String xs,
                             String target){
        var _xs = commasToIntegers(xs);
        var _target = Integer.valueOf(target);
        BiFunction<Integer[],Integer,Integer[]> fun  = switch (variant) {
            case "iter" -> PairSum::iterPairSum;
            case "memo" -> PairSum::memoPairSum;
            case "tunnel" -> PairSum::tunnelPairSum;
            default -> (ss, t) -> new Integer[]{};
        };
        return Arrays.toString(fun.apply(_xs, _target));
    }

}
