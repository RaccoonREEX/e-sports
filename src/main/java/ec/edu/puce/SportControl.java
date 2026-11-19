package ec.edu.puce;

import ec.edu.puce.sport.model.JugadorBasico;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/sport")
public class SportControl {

    List<JugadorBasico> jugadores = new ArrayList<>();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response crearJugadorBasico(JugadorBasico jugador) {
        System.out.println("El jugador es: %s".formatted(jugador.nombre()));

        jugadores.add(jugador);
        System.out.println("La lista contiene %s registros".formatted(jugadores.size()));

        return Response.status(Response.Status.CREATED).entity(jugador).build();
    }
}
