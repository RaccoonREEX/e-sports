package ec.edu.puce.sport.model;

import java.time.LocalDate;

public record JugadorBasico(
    String codigo,
    String nombre,
    LocalDate fecha)
{
}
