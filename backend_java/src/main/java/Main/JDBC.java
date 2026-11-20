package Main;

import bbdd.Client;
import bbdd.Pet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class JDBC {
    private static Session sesion;

    public static void conectar() {
        Configuration configuracion = new Configuration();
        configuracion.configure();
        SessionFactory factoria = configuracion.buildSessionFactory();
        sesion = factoria.openSession();
    }

    public static void desconectar(){sesion.close();}

    public static Pet addPet(String petName,int clientId) {
        conectar();
        Client clientSearched=sesion.get(Client.class,clientId);
        Pet newPet=new Pet(petName,clientSearched);
        sesion.beginTransaction();
        sesion.save(newPet);
        sesion.getTransaction().commit();
        desconectar();
        return newPet;
    }
}
