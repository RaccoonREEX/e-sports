package ec.edu.puce;

import ec.edu.puce.sport.model.JugadorBasico;
import ec.edu.puce.sport.model.JugadorEntrada;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Path("/sport")
public class SportControl {

    public static final List<JugadorBasico> jugadores = new ArrayList<>();
    private static int siguienteCodigo = 1;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public synchronized Response crearJugadorBasico(JugadorEntrada entrada) {
        int codigoNuevo = siguienteCodigo;
        siguienteCodigo++;

        JugadorBasico jugador = new JugadorBasico(codigoNuevo, entrada.nombre(), entrada.fecha());
        jugadores.add(jugador);

        System.out.println("El jugador es: %s".formatted(jugador.nombre()));
        System.out.println("Su codigo es: %s".formatted(jugador.codigo()));
        System.out.println("La lista contiene %s registros".formatted(jugadores.size()));

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
    public Response actualizarJugador(@PathParam("codigo") int codigo, JugadorBasico jugador) {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).codigo() == codigo) {
                JugadorBasico actualizado = new JugadorBasico(codigo, jugador.nombre(), jugador.fecha());
                jugadores.set(i, actualizado);

                System.out.println("Jugador actualizado: %s".formatted(actualizado.nombre()));

                return Response.ok(actualizado).build();
            }
        }

        return Response.status(Response.Status.NOT_FOUND).entity("Jugador no encontrado").build();
    }

    @DELETE
    @Path("/{codigo}")
    public Response eliminarJugador(@PathParam("codigo") int codigo) {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).codigo() == codigo) {
                jugadores.remove(i);

                System.out.println("Jugador eliminado con codigo: %s".formatted(codigo));

                return Response.noContent().build();
            }
        }

        return Response.status(Response.Status.NOT_FOUND).entity("Jugador no encontrado").build();
    }
}
