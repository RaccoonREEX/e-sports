package ec.edu.puce.sport.model;

import java.time.LocalDate;

public record JugadorEntrada(
    String nombre,
    LocalDate fecha
) {
}
