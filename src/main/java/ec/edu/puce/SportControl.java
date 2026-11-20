package ec.edu.puce;

import ec.edu.puce.sport.model.JugadorBasico;
import ec.edu.puce.sport.model.JugadorEntrada;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
@Path("/sport")
public class SportControl {

    public static final List<JugadorBasico> jugadores = new ArrayList<>();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public synchronized Response crearJugadorBasico(JugadorEntrada entrada) {
        String codigoNuevo = UUID.randomUUID().toString();

        JugadorBasico jugador = new JugadorBasico(codigoNuevo, entrada.nombre(), entrada.fecha());
        jugadores.add(jugador);

        System.out.println("El jugador es: %s".formatted(jugador.nombre()));

        return Response.status(Response.Status.CREATED).entity(jugador).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<JugadorBasico> listarJugadores() {
        return jugadores;
    }

    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public synchronized Response actualizarJugador(@PathParam("codigo") String codigo, JugadorEntrada entrada) {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).codigo().equals(codigo)) {
                JugadorBasico actualizado = new JugadorBasico(codigo, entrada.nombre(), entrada.fecha());
                jugadores.set(i, actualizado);

                System.out.println("Jugador actualizado: %s".formatted(actualizado.nombre()));

                return Response.ok(actualizado).build();
            }
        }

        return Response.status(Response.Status.NOT_FOUND).entity("Jugador no encontrado").build();
    }

    @DELETE
    @Path("/{codigo}")
    public synchronized Response eliminarJugador(@PathParam("codigo") String codigo) {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).codigo().equals(codigo)) {
                jugadores.remove(i);

                System.out.println("Jugador eliminado con codigo: %s".formatted(codigo));

                return Response.noContent().build();
            }
        }

        return Response.status(Response.Status.NOT_FOUND).entity("Jugador no encontrado").build();
    }
}
