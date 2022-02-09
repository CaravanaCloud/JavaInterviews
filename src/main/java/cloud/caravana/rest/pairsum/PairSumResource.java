package cloud.caravana.rest.pairsum;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.vertx.core.json.JsonObject;

import static cloud.caravana.algo.pairsum.PairSum.*;
import static cloud.caravana.Util.*;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/pairsum")
public class PairSumResource {
    @Path("iter")
    @GET
    @Consumes(APPLICATION_JSON)
    public String getIterPairSum(JsonObject body){
        var xs = body.getString("xs","");
        var _xs = commasToInts(xs);
        var target = body.getString("target","0");
        var _target = Integer.valueOf(target);
        var result = iterTwoNumberSum(_xs, _target);
        return Arrays.toString(result);
    }

    @Path("memo")
    @GET
    public String getMemoPairSum(JsonObject body){
        var xs = body.getString("xs","");
        var _xs = commasToInts(xs);
        var target = body.getString("target","0");
        var _target = Integer.valueOf(target);
        return Arrays.toString(iterTwoNumberSum(_xs, _target));
    }

    @Path("tunnel")
    @GET
    public String getTunnelPairSum(JsonObject body){
        var xs = body.getString("xs","");
        var _xs = commasToInts(xs);
        var target = body.getString("target","0");
        var _target = Integer.valueOf(target);
        return Arrays.toString(iterTwoNumberSum(_xs, _target));
    }

    @Path("random")
    @GET
    @Produces(APPLICATION_JSON)
    public JsonObject getRandoms(@QueryParam("n") @DefaultValue("10") Integer n){
        var xs = new StringBuilder();
        var rand = new Random();
        for (int i = 0; i < n; i++) {
            xs.append(rand.nextInt()).append(",");
        }
        xs.append("0");
        var result = new JsonObject();
        result.put("xs", xs.toString());
        result.put("target", rand.nextInt());
        return result;
    }
}
