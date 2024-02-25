package controller;

import database.HibernateUtil;
import model.Equipos;
import model.Ligas;
import model.Partidos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.text.SimpleDateFormat;


public class DAOPartidos {
    private SessionFactory _sessionFactory;


    public DAOPartidos() {
        _sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void insertarPartido(Partidos partido) {
        Session session = _sessionFactory.openSession();
        session.beginTransaction();

        session.persist(partido);
        session.getTransaction().commit();
        session.close();
    }

    public Partidos getPartidoInfo(int idPartido) {
        Session session = _sessionFactory.openSession();
        Partidos partidoConsultado = session.get(Partidos.class, idPartido);

        if (partidoConsultado != null) {
            System.out.println("Informacion del partido: \n=======================");
            System.out.println("ID: " + partidoConsultado.getId_partido());
            System.out.println("Fecha del partido: " + partidoConsultado.getFecha_partido());
            System.out.println("Goles equipo local: " + partidoConsultado.getGoles_equipo_local());
            System.out.println("Goles equipo visitante: " + partidoConsultado.getGoles_equipo_visitante());
            System.out.println("Equipo local: " + partidoConsultado.getEquipoLocal().getNombre_equipo());
            System.out.println("Equipo visitante: " + partidoConsultado.getEquipoVisitante().getNombre_equipo());
            System.out.println("Liga del partido: " + partidoConsultado.getLigaPartido().getNombre_liga());
        } else {
            System.out.println("El partido con ID: " + idPartido + " no existe en la base de datos.");
        }
        session.close();
        return partidoConsultado;
    }

}
