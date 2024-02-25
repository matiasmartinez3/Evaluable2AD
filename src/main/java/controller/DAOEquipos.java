package controller;

import database.HibernateUtil;
import model.Equipos;
import model.Ligas;
import model.Partidos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class DAOEquipos {

    private static SessionFactory _sessionFactory;

    public DAOEquipos() {
        this._sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void insertarEquipo(Equipos equipo) {
        Session session = _sessionFactory.openSession();
        session.beginTransaction();

        session.persist(equipo);
        session.getTransaction().commit();
        session.close();
    }

    public void asignarLigaAEquipo(int idEquipo, int idLiga) {
        Session session = _sessionFactory.openSession();
        session.beginTransaction();

        String hql = "UPDATE Equipos SET liga = :liga WHERE id_equipo = :idEquipo";
        Query query = session.createQuery(hql);
        query.setParameter("liga", session.load(Ligas.class, idLiga)); // Cargamos la liga por su ID
        query.setParameter("idEquipo", idEquipo);

        int filasActualizadas = query.executeUpdate();

        session.getTransaction().commit();
        session.close();

        if (filasActualizadas > 0) {
            System.out.println("Se ha asignado la liga al equipo correctamente.");
        } else {
            System.out.println("No se pudo asignar la liga al equipo.");
        }
    }


    public void modificarEquipo(Equipos equipoModificado) {
        try (Session session = _sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(equipoModificado);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarEquipo(Equipos equipo) {
        try (Session session = _sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(equipo);
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Equipos selectEquipo(int id_equipo) {
        Session session = _sessionFactory.openSession();
        Equipos equipoSeleccionado = null;

        String hql = "FROM Equipos WHERE id_equipo = :id";
        Query<Equipos> query = session.createQuery(hql, Equipos.class);
        query.setParameter("id", id_equipo);
        equipoSeleccionado = query.uniqueResult();

        return equipoSeleccionado;
    }
}
