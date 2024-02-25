package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "equipos")
public class Equipos {
    @Id
    private int id_equipo;
    @Column
    private String nombre_equipo;
    @Column
    private String ciudad;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id_liga", name = "id_liga")
    private Ligas liga;

    public Equipos(String nombre_equipo, String ciudad) {
        this.nombre_equipo = nombre_equipo;
        this.ciudad = ciudad;
    }

    public Equipos(int id_equipo, Ligas liga) {
        this.id_equipo = id_equipo;
        this.liga = liga;
    }

    public Equipos(String nombre_equipo, String ciudad, Ligas liga) {
        this.nombre_equipo = nombre_equipo;
        this.ciudad = ciudad;
        this.liga = liga;
    }
}
