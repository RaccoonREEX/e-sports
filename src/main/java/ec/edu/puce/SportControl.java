package ec.edu.puce;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/sport")
public class SportControl {
    @GET
    public void saludar() {
        System.out.println("Holi");
    }

    @GET
    @Path("/process")
    public String procesar() {
        return "Holi x2 jeej";
    }

    @GET
    @Path("/miapi")
    public String personal() {
        return "Ya hice mi API jejeje";
    }

}
