package cloud.caravana.rest.pairsum;

import static cloud.caravana.algo.pairsum.PairSum.*;
import static cloud.caravana.Util.*;
import java.util.Arrays;

import javax.ws.rs.*;

@Path("/pairsum")
public class PairSumResource {
    @Path("iter")
    @GET
    public String getIterPairSum(@QueryParam("xs") String xs,
                                @QueryParam("target") String target){
        var _xs = commasToInts(xs);
        var _target = Integer.valueOf(target);
        return Arrays.toString(iterTwoNumberSum(_xs, _target));
    }

    @Path("memo")
    @GET
    public String getMemoPairSum(@QueryParam("xs") String xs,
                                 @QueryParam("target") String target){
        var _xs = commasToInts(xs);
        var _target = Integer.valueOf(target);
        return Arrays.toString(iterTwoNumberSum(_xs, _target));
    }

    @Path("tunnel")
    @GET
    public String getTunnelPairSum(@QueryParam("xs") String xs,
                                 @QueryParam("target") String target){
        var _xs = commasToInts(xs);
        var _target = Integer.valueOf(target);
        return Arrays.toString(iterTwoNumberSum(_xs, _target));
    }
}
