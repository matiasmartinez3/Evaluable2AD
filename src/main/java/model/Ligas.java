package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "Ligas")
public class Ligas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_liga;
    @Column
    private String nombre_liga;
    @Column
    private Date fecha_inicio;
    @Column
    private Date fecha_fin;


    public Ligas(String nombre_liga, Date fecha_inicio, Date fecha_fin) {
        this.nombre_liga = nombre_liga;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public Ligas(int id_liga) {
        this.id_liga = id_liga;
    }
}
