
package ws.kk;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("restuni")
public class restolayi {
    static String name="yavuz";
    @GET
    public String getUniname()
    {
        return name;
    }
    @PUT
    public void postatmak(String geleName)
    {
        name =geleName;
    
    }
    
}
