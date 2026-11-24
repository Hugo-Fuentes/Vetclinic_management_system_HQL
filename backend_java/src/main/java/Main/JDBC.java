package Main;

import bbdd.Appointment;
import bbdd.Client;
import bbdd.Pet;
import bbdd.Veterinarian;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.time.LocalTime;
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
        Query consult=sesion.createQuery("SELECT pet.petId FROM Pet pet WHERE pet.name LIKE ?1");
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

    public static void viewPetByName(){
        connect();
        System.out.println("Tell me pet name: ");
        String petName=entrada.nextLine();
        Query consult=sesion.createQuery("FROM Pet pet WHERE pet.name like ?1");
        consult.setParameter(1,petName+"%");
        List<Pet> petList=consult.list();
        if(petList.isEmpty()) System.out.println("No pets allowed");
        else for(Pet pet: petList) System.out.println(pet);
        disconnect();
    }

    public static Client addClient(String clientName, String clientLastName, String dni, String phoneNumber) {
        connect();
        Client newClient=new Client(clientName,clientLastName,dni,phoneNumber);
        sesion.beginTransaction();
        sesion.save(newClient);
        sesion.getTransaction().commit();
        disconnect();
        return newClient;
    }

    public static Client modifyClientName(int clientId, String newName) {
        connect();
        sesion.beginTransaction();
        Client clientSearched=sesion.get(Client.class,clientId);
        clientSearched.setName(newName);
        sesion.getTransaction().commit();
        disconnect();
        return clientSearched;
    }

    public static Client modifyClientLastName(int clientId, String newLastName) {
        connect();
        sesion.beginTransaction();
        Client clientSearched=sesion.get(Client.class,clientId);
        clientSearched.setLastName(newLastName);
        sesion.getTransaction().commit();
        disconnect();
        return clientSearched;
    }

    public static Client modifyDni(int clientId, String newDni) {
        connect();
        sesion.beginTransaction();
        Client clientSearched=sesion.get(Client.class,clientId);
        clientSearched.setDni(newDni);
        sesion.getTransaction().commit();
        disconnect();
        return clientSearched;
    }

    public static Client modifyPhoneNumber(int clientId, String newPhoneNumber) {
        connect();
        sesion.beginTransaction();
        Client clientSearched=sesion.get(Client.class,clientId);
        clientSearched.setPhoneNumber(newPhoneNumber);
        sesion.getTransaction().commit();
        disconnect();
        return clientSearched;
    }

    public static Client deleteClientByName(String clientName) {
        connect();
        Query consult=sesion.createQuery("SELECT cli.clientId FROM Client cli WHERE cli.name LIKE ?1");
        consult.setParameter(1,clientName);
        int clientId=(int) consult.getSingleResult();
        Client clientSearched=sesion.get(Client.class,clientId);
        sesion.beginTransaction();
        sesion.remove(clientSearched);
        sesion.getTransaction().commit();
        return clientSearched;
    }

    public static Client deleteClientById(int clientId) {
        connect();
        Client clientSearched=sesion.get(Client.class,clientId);
        sesion.beginTransaction();
        sesion.remove(clientSearched);
        sesion.getTransaction().commit();
        disconnect();
        return clientSearched;

    }

    public static void viewClient(){
        connect();
        Query consult=sesion.createQuery("FROM Client cli");
        List<Client> clientList=consult.list();
        if(clientList.isEmpty()) System.out.println("No results for this query");
        else for (Client cli : clientList) System.out.println(cli);
        disconnect();
    }

    public static void viewClientByName(){
        connect();
        System.out.println("Tell me client`s name: ");
        String clientName=entrada.nextLine()+"%";
        Query consult= sesion.createQuery("FROM Client cli WHERE cli.name LIKE ?1");
        consult.setParameter(1,clientName);
        List<Client> clientList=consult.list();
        if(clientList.isEmpty()) System.out.println("no results for this query");
        else for(Client cli : clientList) System.out.println(cli);
        disconnect();
    }

    public static Veterinarian addVeterinarian(String veterinarianName, String speciality, String veterinarianLastName, String phoneNumber) {
        connect();
        Veterinarian newVeterinarian=new Veterinarian(veterinarianName,speciality,veterinarianLastName,phoneNumber);
        sesion.beginTransaction();
        sesion.save(newVeterinarian);
        sesion.getTransaction().commit();
        disconnect();
        return newVeterinarian;
    }

    public static Veterinarian modifyVeterinarianName(int veterinarianId, String newVeterinarianName) {
        connect();
        sesion.beginTransaction();
        Veterinarian veterinarianSearched=sesion.get(Veterinarian.class,veterinarianId);
        veterinarianSearched.setName(newVeterinarianName);
        sesion.getTransaction().commit();
        disconnect();
        return veterinarianSearched;
    }

    public static Veterinarian modifyVeterinarianSpeciality(int veterinarianId, String newVeterinarianSpeciality) {
        connect();
        sesion.beginTransaction();
        Veterinarian veterinarianSearched=sesion.get(Veterinarian.class,veterinarianId);
        veterinarianSearched.setSpeciality(newVeterinarianSpeciality);
        sesion.getTransaction().commit();
        disconnect();
        return veterinarianSearched;
    }

    public static Veterinarian modifyVeterinarianLastName(int veterinarianId, String newVeterianrianLastname) {
        connect();
        sesion.beginTransaction();
        Veterinarian veterinarianSearched=sesion.get(Veterinarian.class,veterinarianId);
        veterinarianSearched.setLastName(newVeterianrianLastname);
        sesion.getTransaction().commit();
        disconnect();
        return veterinarianSearched;
    }

    public static Veterinarian modifyVeterinarianPhoneNumber(int veterinarianId, String newVeterinarianPhoneNumber) {
        connect();
        sesion.beginTransaction();
        Veterinarian veterinarianSearched=sesion.get(Veterinarian.class,veterinarianId);
        veterinarianSearched.setPhoneNumber(newVeterinarianPhoneNumber);
        sesion.getTransaction().commit();
        disconnect();
        return veterinarianSearched;
    }

    public static Veterinarian deleteVeterinarianByName(String veterinarianName) {
        connect();
        Query consult=sesion.createQuery("SELECT vet.veterinarianId FROM Veterinarian vet WHERE vet.name LIKE ?1");
        consult.setParameter(1,veterinarianName);
        int veterinarianId=(int) consult.getSingleResult();
        Veterinarian veterinarianSearched=sesion.get(Veterinarian.class,veterinarianId);
        sesion.beginTransaction();
        sesion.remove(veterinarianSearched);
        sesion.getTransaction().commit();
        return veterinarianSearched;
    }

    public static Veterinarian deleteVeterinarianById(int veterinarianId) {
        connect();
        Veterinarian veterinarianSearched=sesion.get(Veterinarian.class,veterinarianId);
        sesion.beginTransaction();
        sesion.remove(veterinarianSearched);
        sesion.getTransaction().commit();
        disconnect();
        return veterinarianSearched;
    }

    public static void viewVeterinarians(){
        connect();
        Query consult= sesion.createQuery("FROM Veterinarian vet");
        List<Veterinarian> veterinarianList=consult.list();
        if(veterinarianList.isEmpty()) System.out.println("no results for this query");
        else for(Veterinarian vet: veterinarianList) System.out.println(vet);
        disconnect();
    }

    public static void viewVeterinariansBySpeciality(){
        connect();
        System.out.println("Tell me speciality: ");
        String speciality=entrada.nextLine();
        Query consult= sesion.createQuery("FROM Veterinarian vet WHERE vet.speciality like ?1");
        consult.setParameter(1,speciality+"%");
        List<Veterinarian> veterinarianList=consult.list();
        if(veterinarianList.isEmpty()) System.out.println("no results for this query");
        else for(Veterinarian vet : veterinarianList) System.out.println(vet);
        disconnect();
    }

    public static Appointment addAppointment(LocalDate date2, LocalTime time2, String reason, int petId, int veterinarianId) {
        connect();
        Pet petSearched=sesion.get(Pet.class,petId);
        Veterinarian veterinarianSearched=sesion.get(Veterinarian.class,veterinarianId);
        Appointment newAppointment=new Appointment(date2,time2,reason,veterinarianSearched,petSearched);
        sesion.beginTransaction();
        sesion.save(newAppointment);
        sesion.getTransaction().commit();
        disconnect();
        return newAppointment;
    }

    public static Appointment modifyAppointmentDateTime(int appointmentId, LocalDate newDate2, LocalTime newTime2) {
        connect();
        sesion.beginTransaction();
        Appointment appointmentSearched=sesion.get(Appointment.class,appointmentId);
        appointmentSearched.setDate(newDate2);
        appointmentSearched.setTime(newTime2);
        sesion.getTransaction().commit();
        disconnect();
        return appointmentSearched;
    }

    public static Appointment modifyAppointmenTime(int appointmentId, LocalTime newTime2) {
        connect();
        sesion.beginTransaction();
        Appointment appointmentSearched=sesion.get(Appointment.class,appointmentId);
        appointmentSearched.setTime(newTime2);
        sesion.getTransaction().commit();
        disconnect();
        return appointmentSearched;
    }

    public static Appointment modifyAppointmentReason(int appointmentId, String newReason) {
        connect();
        sesion.beginTransaction();
        Appointment appointmentSearched=sesion.get(Appointment.class,appointmentId);
        appointmentSearched.setReason(newReason);
        sesion.getTransaction().commit();
        disconnect();
        return appointmentSearched;
    }

    public static Appointment deleteAppointment(int appoitmentId) {
        connect();
        Appointment appointmentSearched=sesion.get(Appointment.class,appoitmentId);
        sesion.beginTransaction();
        sesion.remove(appointmentSearched);
        sesion.getTransaction().commit();
        disconnect();
        return appointmentSearched;
    }

    public static void viewAppointments(){
        connect();
        Query consult= sesion.createQuery("FROM Appointment apo");
        List<Appointment> appointmentList=consult.list();
        if(appointmentList.isEmpty()) System.out.println("There are no results for this query");
        else for(Appointment apo: appointmentList) System.out.println(apo);
        disconnect();
    }

    public static void viewAppointmentsByPetName(){
        connect();
        System.out.println("Tell me the pet name: ");
        String petName=entrada.nextLine();
        Query consult=sesion.createQuery("FROM Appointment apo WHERE apo.pet.name like ?1");
        consult.setParameter(1,petName+"%");
        List<Appointment> appointmentList=consult.list();
        if(appointmentList.isEmpty()) System.out.println("There are no appointments for this pet");
        else for(Appointment apo: appointmentList) System.out.println(apo);
        disconnect();
    }

    public static void viewAppointmentsByVeterinarianName(){
        connect();
        System.out.println("Tell me the veterinarian name: ");
        String veterinarianName=entrada.nextLine();
        Query consult=sesion.createQuery("FROM Appointment apo WHERE apo.veterinarian.name like ?1");
        consult.setParameter(1,veterinarianName+"%");
        List<Appointment> appointmentList=consult.list();
        if(appointmentList.isEmpty()) System.out.println("There are no appointments for this veterinarian");
        else for(Appointment apo: appointmentList) System.out.println(apo);
        disconnect();
    }
}
