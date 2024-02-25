package controller;
import model.Ligas;
import database.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DAOLigas {
    private SessionFactory _sessionFactory;
    public DAOLigas() {_sessionFactory = HibernateUtil.getSessionFactory();}

    public void insertarLiga(Ligas liga) {
        Session session = _sessionFactory.openSession();
        session.beginTransaction();

        session.persist(liga);
        session.getTransaction().commit();
        session.close();
    }

   /* public void modificarLiga (Ligas ligaMod) {
        Session session = _sessionFactory.openSession();
        session.beginTransaction();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String hql = "UPDATE Ligas SET nombre_liga = :nombre, fecha_inicio = :fechaInicio, fecha_fin = :fechaFin WHERE id_liga = :id";
        Query<Ligas> query = session.createQuery(hql);
        query.setParameter("nombre", ligaMod.getNombre_liga());
        query.setParameter("fechaInicio", dateFormat.format(ligaMod.getFecha_inicio()));
        query.setParameter("fechaFin", dateFormat.format(ligaMod.getFecha_fin()));
        query.setParameter("id", ligaMod.getId_liga());

        int filasActualizadas = query.executeUpdate();

        if (filasActualizadas > 0) {
            session.getTransaction().commit();
        } else {
            System.out.println("La liga que quieres modificar no existe en la base de datos.");
        }
        session.close();
    }*/
   public void modificarLiga(Ligas liga) {
       try (Session session = _sessionFactory.openSession()) {
           session.beginTransaction();
           session.update(liga);
           session.getTransaction().commit();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }


/*
    public void borrarLiga(Ligas liga) {
        Session session = _sessionFactory.openSession();
        session.beginTransaction();

        Ligas ligaSeleccionada = selectLiga(liga.getId_liga());

        if (ligaSeleccionada != null) {
            String hql = "DELETE FROM Ligas WHERE id_liga = :id";
            Query<Ligas> query = session.createQuery(hql);
            query.setParameter("id", ligaSeleccionada.getId_liga());

            int filasBorradas = query.executeUpdate();

            if (filasBorradas > 0) {
                session.getTransaction().commit();
                System.out.println("Liga borrada con éxito.");
            } else {
                System.out.println("La liga que intentas borrar no existe en la base de datos.");
            }
        } else {
            System.out.println("La liga que intentas borrar no existe en la base de datos.");
        }

        session.close();
    }*/

    public void borrarLiga(Ligas liga) {
        try (Session session = _sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(liga);
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Ligas getLigaInfo(int idLiga) {
        Session session = _sessionFactory.openSession();
        Ligas ligaConsultada = selectLiga(idLiga);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (ligaConsultada != null) {
            System.out.println("Informacion de la liga: \n=======================");
            System.out.println("ID: " + ligaConsultada.getId_liga());
            System.out.println("Nombre: " + ligaConsultada.getNombre_liga());
            System.out.println("Fecha de inicio: " + dateFormat.format(ligaConsultada.getFecha_inicio()));
            System.out.println("Fecha de fin: " + dateFormat.format(ligaConsultada.getFecha_fin()));
        } else {
            System.out.println("La liga con ID: " + idLiga + " no existe en la base de datos.");
        }
        session.close();
        return ligaConsultada;
    }

    public Ligas selectLiga (int id_liga) {
        Session session = _sessionFactory.openSession();
        Ligas ligaSeleccionada = null;

        String hql = "FROM Ligas WHERE id_liga = :id";
        Query<Ligas> query = session.createQuery(hql, Ligas.class);
        query.setParameter("id", id_liga);
        ligaSeleccionada = query.uniqueResult();

        return ligaSeleccionada;
    }

    public void asignarLigaAPartido(int idPartido, int idLiga) {
        Session session = _sessionFactory.openSession();
        session.beginTransaction();

        String hql = "UPDATE Partidos SET ligaPartido = :liga WHERE id_partido = :idPartido";
        Query query = session.createQuery(hql);
        query.setParameter("liga", session.get(Ligas.class, idLiga)); // Cargamos la liga por su ID
        query.setParameter("idPartido", idPartido);

        int filasActualizadas = query.executeUpdate();

        session.getTransaction().commit();
        session.close();

        if (filasActualizadas > 0) {
            System.out.println("Se ha asignado la liga al partido correctamente.");
        } else {
            System.out.println("No se pudo asignar la liga al partido.");
        }
    }

}
