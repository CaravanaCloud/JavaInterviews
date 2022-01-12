package cloud.caravana.rs.algo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import cloud.caravana.algo.Algos;

@Path("/algo/{name}")
public class AlgoResource {
    @GET
    public String getAlgo(
        @PathParam("name") String name) throws Exception {
            return Algos.byName(name).call();
    }
}
