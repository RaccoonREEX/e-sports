package ec.edu.puce;

import ec.edu.puce.sport.model.Juador;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;

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
    @Path("/crear")
    public Response crearJugador (){
        Juador jugador = new Juador();
        jugador.setCodigo(1);
        jugador.setNombre("Eduardo");
        jugador.setFecha(LocalDate.of(1990, 10, 28));
        jugador.setEquipo("Desarrollo");

        IO.println("El equipo %s esta configurado por los siguientes jugadores %d - %s"
                .formatted(
                        jugador.getEquipo(),
                        jugador.getCodigo(),
                        jugador.getNombre()

                ));
        return Response.status(Response.Status.CREATED).entity(jugador).build();
    }

    @GET
    @Path("/miapi")
    public String personal() {
        return "Ya hice mi API jejeje";
    }

}
