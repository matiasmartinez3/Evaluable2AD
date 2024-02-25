package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "partido")
public class Partidos {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id_partido;
    @Column
    private Date fecha_partido;
    @Column
    private int goles_equipo_local;
    @Column
    private int goles_equipo_visitante;


    @ManyToOne
    @JoinColumn(referencedColumnName = "id_equipo", name = "id_equipo_local")
    private Equipos equipoLocal;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id_equipo", name = "id_equipo_visitante")
    private Equipos equipoVisitante;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id_liga", name = "id_liga")
    private Ligas ligaPartido;


    public Partidos(Date fecha_partido, Equipos equipoLocal, Equipos equipoVisitante) {
        this.fecha_partido = fecha_partido;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }
    public Partidos(Ligas ligaPartido) {
        this.ligaPartido = ligaPartido;
    }
}
