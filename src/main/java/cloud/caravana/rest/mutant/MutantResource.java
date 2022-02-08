package cloud.caravana.rest.mutant;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("mutant")
public class MutantResource {
    @GET
    @Path("random")
    public String getMutant(){
        return "UALA";
    }
}
