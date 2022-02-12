package cloud.caravana.rest.hello;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import cloud.caravana.algo.reverse.ReverseInplace;
import io.vertx.core.json.JsonObject;

@Path("/hello")
public class HelloResource {
    @GET
    public JsonObject hello(@QueryParam("name") @DefaultValue("fulano") String name) {
        var reverse = ReverseInplace.reverse(name);
        var json = new JsonObject();
        json.put("message", "Hello " + reverse);
        return json;
    }
}
