import controller.DAOEquipos;
import controller.DAOLigas;
import controller.DAOPartidos;
import model.Equipos;
import model.Ligas;
import model.Partidos;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Entrada {
    public static void main(String[] args) {
        // asignar equipos a las ligas -> que una liga tenga varios equipos --> (liga ---- equipos) --> @OneToMany (1-N)

        DAOLigas operacionesLigas = new DAOLigas();
        // tabla origen: ligas
        DAOEquipos operacionesEquipos = new DAOEquipos();

        DAOPartidos operacionesPartidos = new DAOPartidos();

        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        String fechaInicioStr = "20/08/2023";
        String fechaFinStr = "20/07/2024";
        String fechaPartidoStr = "12/02/2025";

        Date fechaInicio = null;
        Date fechaFin = null;
        Date fechaPartido = null;

        try {
            fechaInicio = formatoFecha.parse(fechaInicioStr);
            fechaFin = formatoFecha.parse(fechaFinStr);
            fechaPartido = formatoFecha.parse(fechaPartidoStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        // INSERTAR LIGA
        //operacionesLigas.insertarLiga(new Ligas("Ejemplo", fechaInicio, fechaFin));
        //operacionesLigas.insertarLiga(new Ligas("LaLiga EA Sports", fechaInicio, fechaFin));

        //operacionesEquipos.insertarEquipo(new Equipos("Real Madrid", "Madrid"));

        //operacionesLigas.actualizarLiga(premierLeague);

        //operacionesLigas.insertarLiga(new Ligas("LaLiga EA Sports", "2/9/23", "4/6/24", "Real Madrid FC"));

        //operacionesEquipos.insertarEquipo(new Equipos("FC Barcelona", "Barcelona"));
        //int idLiga = 7;
        //int idEquipo = 2;
        //operacionesEquipos.asignarLigaAEquipo(idEquipo, idLiga);


        // MODIFICAR LIGA
        //Ligas nuevaEjemploLeague = (new Ligas(9,"EjemploMod", fechaInicio, fechaFin));
        //operacionesLigas.modificarLiga(nuevaEjemploLeague);


        // BORRAR LIGA
        /*Ligas ligaParaBorrar = (new Ligas());
        ligaParaBorrar.setId_liga(9);
        operacionesLigas.borrarLiga(ligaParaBorrar);*/



        // GETINFO LIGA
        //Ligas ligaConsultada = operacionesLigas.getLigaInfo(3);
        //Ligas ligaConsultada2 = operacionesLigas.getLigaInfo(6);

        // CREAR PARTIDO
        //operacionesPartidos.insertarPartido(new Partidos(fechaPartido,operacionesEquipos.selectEquipo(1), operacionesEquipos.selectEquipo(2)));

        // ASIGNAR UNA LIGA A UN PARTIDO
        //operacionesLigas.asignarLigaAPartido(1, 7);

        // CONSULTAR INFO DE PARTIDOS
        // partidoConsultado = operacionesPartidos.getPartidoInfo(1);

        // ELIMINAR EQUIPO
        /*Equipos equiposParaBorrar = (new Equipos());
        equiposParaBorrar.setId_equipo(2);
        operacionesEquipos.eliminarEquipo(equiposParaBorrar);*/


        //  - Crea 1 liga

        //  - Crea 8 equipos
        //  - Crea 6 partidos
        //  - Muestra datos de todos los equipos
        //  - Elimina 2 equipos
        //  - Muestra todos los partidos de una liga concreta

    }
}
