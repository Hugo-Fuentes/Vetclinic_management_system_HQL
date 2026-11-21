package Main;

import bbdd.Client;
import bbdd.Pet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;


public class JDBC {
    private static Session sesion;
    static Scanner entrada=new Scanner(System.in);

    public static void connect() {
        Configuration configuracion = new Configuration();
        configuracion.configure();
        SessionFactory factoria = configuracion.buildSessionFactory();
        sesion = factoria.openSession();
    }

    public static void disconnect(){sesion.close();}

    public static Pet addPet(String petName,int clientId) {
        connect();
        Client clientSearched=sesion.get(Client.class,clientId);
        Pet newPet=new Pet(petName,clientSearched);
        sesion.beginTransaction();
        sesion.save(newPet);
        sesion.getTransaction().commit();
        disconnect();
        return newPet;
    }

    public static Pet modifyPet(int petId, String newName) {
        connect();
        sesion.beginTransaction();
        Pet petSearched=sesion.get(Pet.class,petId);
        petSearched.setName(newName);
        sesion.getTransaction().commit();
        disconnect();
        return petSearched;
    }

    public static Pet modifyPet2(int petId, int newClientId) {
        connect();
        sesion.beginTransaction();
        Pet petSearched=sesion.get(Pet.class,petId);
        Client clientSearched=sesion.get(Client.class,newClientId);
        petSearched.setClient(clientSearched);
        sesion.getTransaction().commit();
        disconnect();
        return petSearched;
    }

    public static Pet deletePetByName(String petName) {
        connect();
        Query consult=sesion.createQuery("SELECT pet.petId FROM Pet pet WHERE pet.name=?1");
        consult.setParameter(1,petName);
        int petId=(int) consult.getSingleResult();
        Pet petSearched=sesion.get(Pet.class,petId);
        sesion.beginTransaction();
        sesion.remove(petSearched);
        sesion.getTransaction().commit();
        return petSearched;
    }

    public static Pet deletePetById(int petId) {
        connect();
        Pet petSearched=sesion.get(Pet.class,petId);
        sesion.beginTransaction();
        sesion.remove(petSearched);
        sesion.getTransaction().commit();
        disconnect();
        return petSearched;

    }

    public static void viewPets(){
        connect();
        Query consult=sesion.createQuery("FROM Pet pet");
        List<Pet> petList=consult.list();
        if(petList.isEmpty()) System.out.println("No pets allowed");
        else for(Pet pet: petList) System.out.println(pet);
        disconnect();
    }

    public static void viewPetsByClient(){
        connect();
        System.out.println("Tell me client id: ");
        int clientId=entrada.nextInt();entrada.nextLine();
        Query consult=sesion.createQuery("FROM Pet pet WHERE pet.client.clientId=?1 ");
        consult.setParameter(1,clientId);
        List<Pet> petList=consult.list();
        if(petList.isEmpty()) System.out.println("No pets allowed");
        else for(Pet pet: petList) System.out.println(pet);
        disconnect();
    }
}
