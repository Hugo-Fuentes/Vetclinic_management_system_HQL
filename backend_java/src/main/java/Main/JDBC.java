package Main;

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
}
