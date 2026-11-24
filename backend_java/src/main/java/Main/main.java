package Main;

import bbdd.Appointment;
import bbdd.Client;
import bbdd.Pet;
import bbdd.Veterinarian;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class main {
    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        entrada = new Scanner(System.in);
        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);

        try {
            int option = 0;
            while (option != 5) {
                principalMenu();
                option = entrada.nextInt();
                entrada.nextLine();
                if (option >= 1 && option <= 6) {
                    switch (option) {
                        case 1:
                            int optionPet = 0;
                            while (optionPet != 7) {
                                petMenu();
                                optionPet = entrada.nextInt();
                                entrada.nextLine();
                                if (optionPet >= 1 && optionPet <= 7) {
                                    switch (optionPet) {
                                        case 1:
                                            addPet();
                                            break;
                                        case 2:
                                            modifyPet();
                                            break;
                                        case 3:
                                            deletePet();
                                            break;
                                        case 4:
                                            JDBC.viewPets();
                                            break;
                                        case 5:
                                            JDBC.viewPetsByClient();
                                            break;
                                        case 6:
                                            JDBC.viewPetByName();
                                            break;
                                    }
                                } else System.out.println("Choose a logical option");
                            }
                            break;
                        case 2:
                            int optionClient = 0;
                            while (optionClient != 6) {
                                clientMenu();
                                optionClient = entrada.nextInt();
                                entrada.nextLine();
                                if (optionClient >= 1 && optionClient <= 6) {
                                    switch (optionClient) {
                                        case 1:
                                            addClient();
                                            break;
                                        case 2:
                                            modifyClient();
                                            break;
                                        case 3:
                                            deleteClient();
                                            break;
                                        case 4:
                                            JDBC.viewClient();
                                            break;
                                        case 5:
                                            JDBC.viewClientByName();
                                            break;
                                    }
                                } else System.out.println("Choose a logical option");
                            }
                            break;
                        case 3:
                            int optionVeterinarian = 0;
                            while (optionVeterinarian != 6) {
                                veterinarianMenu();
                                optionVeterinarian = entrada.nextInt();
                                entrada.nextLine();
                                if (optionVeterinarian >= 1 && optionVeterinarian <= 6) {
                                    switch (optionVeterinarian) {
                                        case 1:
                                            addVeterinarian();
                                            break;
                                        case 2:
                                            modifyVeterinarian();
                                            break;
                                        case 3:
                                            deleteVeterinarian();
                                            break;
                                        case 4:
                                            JDBC.viewVeterinarians();
                                            break;
                                        case 5:
                                            JDBC.viewVeterinariansBySpeciality();
                                            break;


                                    }
                                } else System.out.println("Choose a logical option");
                            }
                            break;
                        case 4:
                            int optionAppointment = 0;
                            while (optionAppointment != 7) {
                                appointmentMenu();
                                optionAppointment = entrada.nextInt();
                                entrada.nextLine();
                                if (optionAppointment >= 1 && optionAppointment <= 7) {
                                    switch (optionAppointment) {
                                        case 1:
                                            addAppoiment();
                                            break;
                                        case 2:
                                            modifyAppointment();
                                            break;
                                        case 3:
                                            deleteAppointment();
                                            break;
                                        case 4:
                                            JDBC.viewAppointments();
                                            break;
                                        case 5:
                                            JDBC.viewAppointmentsByPetName();
                                            break;
                                        case 6:
                                            JDBC.viewAppointmentsByVeterinarianName();
                                            break;
                                    }
                                } else System.out.println("Choose a logical option");
                            }
                            break;
                        case 5:
                            System.out.println("END");
                            break;
                    }
                } else System.out.println("Choose a logical option.");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void principalMenu() {
        System.out.println("\t\t\t MAIN MENU");
        System.out.println("1.-Pet Menu");
        System.out.println("2.-Client Menu");
        System.out.println("3.-Veterinarian Menu");
        System.out.println("4.-Appointments Menu");
        System.out.println("5.-Exit\n");
        System.out.println("Choose option: ");

    }

    public static void petMenu() {
        System.out.println("\t\t\t PET MENU");
        System.out.println("1-Add pet");
        System.out.println("2-Modify pet");
        System.out.println("3-Delete pet");
        System.out.println("4-View pets");
        System.out.println("5-View pets by client");
        System.out.println("6-View pet by name");
        System.out.println("7-Exit\n");
        System.out.println("Choose option: ");
    }

    public static void clientMenu() {
        System.out.println("\t\t\t CLIENT MENU");
        System.out.println("1-Add client");
        System.out.println("2-Modify client");
        System.out.println("3-Delete client");
        System.out.println("4-View client");
        System.out.println("5-View client by name");
        System.out.println("6-Exit\n");
        System.out.println("Choose option: ");
    }

    public static void veterinarianMenu() {
        System.out.println("\t\t\t VETERINARIAN MENU");
        System.out.println("1-Add veterinarian");
        System.out.println("2-Modify veterinarian");
        System.out.println("3-Delete veterianarian");
        System.out.println("4-View veterinarian");
        System.out.println("5-View veterinarian by speciality");
        System.out.println("6-Exit\n");
        System.out.println("Choose option: ");
    }

    public static void appointmentMenu() {
        System.out.println("\t\t\t APPOINTMENT MENU");
        System.out.println("1-Add appointment");
        System.out.println("2-Modify appointment");
        System.out.println("3-Delete appointment");
        System.out.println("4-View appointment");
        System.out.println("5-View appointments by pet name");
        System.out.println("6-View appointments by veterinarian name");
        System.out.println("7-Exit\n");
        System.out.println("Choose option: ");
    }

    public static void addPet() {
        System.out.println("Tell me client`s id for new pet: ");
        int clientId = entrada.nextInt();
        entrada.nextLine();
        System.out.print("Tell me pet`s name: ");
        String petName = entrada.nextLine();
        Pet newPet = JDBC.addPet(petName, clientId);

    }

    public static void modifyPet() {
        String change = "";
        while (!change.equalsIgnoreCase("name") && !change.equalsIgnoreCase("clientId")) {
            System.out.println("Tell me what you want to change: ");
            change = entrada.nextLine();
            if (change.equalsIgnoreCase("name")) {
                System.out.println("Tell me pet´s id: ");
                int petId = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Tell me the new name: ");
                String newName = entrada.nextLine();
                Pet modifyPet = JDBC.modifyPet(petId, newName);
            } else if (change.equalsIgnoreCase("clientId")) {
                System.out.println("Tell me pet´s id: ");
                int petId = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Tell me the new clientId: ");
                int newClientId = entrada.nextInt();
                entrada.nextLine();
                Pet modifyPet = JDBC.modifyPet2(petId, newClientId);
            } else System.out.println("Choose a logical option");
        }

    }

    public static void deletePet() {
        int option = 0;
        while (option < 1 || option > 3) {
            System.out.println("1-Delete by name");
            System.out.println("2-Delete by pet Id");
            System.out.println("3-Exit\n");
            System.out.println("Choose option: ");
            option = entrada.nextInt();
            entrada.nextLine();
            if (option < 1 || option > 3) System.out.println("Choose a logical option");
        }
        switch (option) {
            case 1:
                System.out.println("Tell me pet´s name: ");
                String petName = entrada.nextLine() + "%";
                Pet deletePetByName = JDBC.deletePetByName(petName);
                break;

            case 2:
                System.out.println("Tell me pet´s id: ");
                int petId = entrada.nextInt();
                entrada.nextLine();
                Pet deletePetById = JDBC.deletePetById(petId);

            case 3:
                break;
        }

    }

    public static void addClient() {
        System.out.println("Tell me client`s name: ");
        String clientName = entrada.nextLine();
        System.out.print("Tell me client`s lastName: ");
        String clientLastName = entrada.nextLine();
        String dni = "";
        while (dni.length() != 9) {
            System.out.println("Tell me client`s dni: ");
            dni = entrada.nextLine();
            if (dni.length() != 9) System.out.println("The DNI must have exactly 9 characters");
        }
        String phoneNumber = "";
        while (phoneNumber.length() != 9) {
            System.out.println("Tell me client`s phoneNumber:  ");
            phoneNumber = entrada.nextLine();
            if (phoneNumber.length() != 9) System.out.println("The phone number must have exactly 9 characters");
        }
        Client newClient = JDBC.addClient(clientName, clientLastName, dni, phoneNumber);

    }

    public static void modifyClient() {
        String change = "";
        while (!change.equalsIgnoreCase("name") && !change.equalsIgnoreCase("lastName") && !change.equalsIgnoreCase("last Name") && !change.equalsIgnoreCase("dni") && !change.equalsIgnoreCase("phone number") && !change.equalsIgnoreCase("phonenumber")) {
            System.out.println("Tell me what you want to change: ");
            change = entrada.nextLine();
            if (change.equalsIgnoreCase("name")) {
                System.out.println("Tell me client`s id: ");
                int clientId = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Tell me the new name: ");
                String newName = entrada.nextLine();
                Client modifyClient = JDBC.modifyClientName(clientId, newName);
            } else if (change.equalsIgnoreCase("lastname") || change.equalsIgnoreCase("last name")) {
                System.out.println("Tell me client´s id: ");
                int clientId = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Tell me the new last name: ");
                String newLastName = entrada.nextLine();
                Client modifyClient = JDBC.modifyClientLastName(clientId, newLastName);
            } else if (change.equalsIgnoreCase("dni")) {
                System.out.println("Tell me client´s id: ");
                int clientId = entrada.nextInt();
                entrada.nextLine();
                String newDni = "";
                while (newDni.length() != 9) {
                    System.out.println("Tell me the new dni: ");
                    newDni = entrada.nextLine();
                    if (newDni.length() != 9) System.out.println("The DNI must have exactly 9 characters");
                }
                Client modifyClient = JDBC.modifyDni(clientId, newDni);
            } else if (change.equalsIgnoreCase("phone number") || change.equalsIgnoreCase("phonenumber")) {
                System.out.println("Tell me client´s id: ");
                int clientId = entrada.nextInt();
                entrada.nextLine();
                String newPhoneNumber = "";
                while (newPhoneNumber.length() != 9) {
                    System.out.println("Tell me the new phone number: ");
                    newPhoneNumber = entrada.nextLine();
                    if (newPhoneNumber.length() != 9)
                        System.out.println("The phone number must have exactly 9 characters");
                }
                Client modifyClient = JDBC.modifyPhoneNumber(clientId, newPhoneNumber);
            }


        }

    }

    public static void deleteClient() {
        int option = 0;
        while (option < 1 || option > 3) {
            System.out.println("1-Delete by name");
            System.out.println("2-Delete by client Id");
            System.out.println("3-Exit\n");
            System.out.println("Choose option: ");
            option = entrada.nextInt();
            entrada.nextLine();
            if (option < 1 || option > 3) System.out.println("Choose a logical option");
        }
        switch (option) {
            case 1:
                System.out.println("Tell me client´s name: ");
                String clientName = entrada.nextLine() + "%";
                Client deleteClientByName = JDBC.deleteClientByName(clientName);
                break;

            case 2:
                System.out.println("Tell me client´s id: ");
                int clientId = entrada.nextInt();
                entrada.nextLine();
                Client deleteClientById = JDBC.deleteClientById(clientId);

            case 3:
                break;
        }

    }

    public static void addVeterinarian() {
        System.out.println("Tell me veterinarian`s name: ");
        String veterinarianName = entrada.nextLine();
        System.out.println("Tell me veterinarian`s speciality: ");
        String speciality = entrada.nextLine();
        System.out.println("Tell me veterinarian`s last name: ");
        String veterinarianLastName = entrada.nextLine();
        String phoneNumber = "";
        while (phoneNumber.length() != 9) {
            System.out.println("Tell me veterinarian`s phoneNumber: ");
            phoneNumber = entrada.nextLine();
            if (phoneNumber.length() != 9) System.out.println("The phone number must have exactly 9 characters");
        }
        Veterinarian veterinarian = JDBC.addVeterinarian(veterinarianName, speciality, veterinarianLastName, phoneNumber);
    }

    public static void modifyVeterinarian() {
        String change = "";
        while (!change.equalsIgnoreCase("name") && !change.equalsIgnoreCase("speciality") && !change.equalsIgnoreCase("last name") && !change.equalsIgnoreCase("lastname") && !change.equalsIgnoreCase("phonenumber") && !change.equalsIgnoreCase("phone number")) {
            System.out.println("Tell me what you want to change: ");
            change = entrada.nextLine();
            if (change.equalsIgnoreCase("name")) {
                System.out.println("Tell me veterinarian id: ");
                int veterinarianId = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Tell me new veterinarian name: ");
                String newVeterinarianName = entrada.nextLine();
                Veterinarian modifyVeterinarian = JDBC.modifyVeterinarianName(veterinarianId, newVeterinarianName);
            } else if (change.equalsIgnoreCase("speciality")) {
                System.out.println("Tell me veterinarian id: ");
                int veterinarianId = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Tell me new veterinarian speciality: ");
                String newVeterinarianSpeciality = entrada.nextLine();
                Veterinarian veterinarianModify = JDBC.modifyVeterinarianSpeciality(veterinarianId, newVeterinarianSpeciality);
            } else if (change.equalsIgnoreCase("last name") || change.equalsIgnoreCase("lastname")) {
                System.out.println("Tell me veterinarian id: ");
                int veterinarianId = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Tell me new veterinarian last name: ");
                String newVeterinarianLastName = entrada.nextLine();
                Veterinarian veterinarianModify = JDBC.modifyVeterinarianLastName(veterinarianId, newVeterinarianLastName);
            } else if (change.equalsIgnoreCase("phone number") || change.equalsIgnoreCase("phonenumber")) {
                System.out.println("Tell me veterinarian id: ");
                int veterinarianId = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Tell me new veterinarian phone number: ");
                String newVeterinarianPhoneNumber = entrada.nextLine();
                Veterinarian veterinarianModify = JDBC.modifyVeterinarianPhoneNumber(veterinarianId, newVeterinarianPhoneNumber);
            } else System.out.println("Choose a logical option");
        }
    }

    public static void deleteVeterinarian() {
        int option = 0;
        while (option < 1 || option > 3) {
            System.out.println("1-Delete by name");
            System.out.println("2-Delete by client Id");
            System.out.println("3-Exit\n");
            System.out.println("Choose option: ");
            option = entrada.nextInt();
            entrada.nextLine();
            if (option < 1 || option > 3) System.out.println("Choose a logical option");
        }
        switch (option) {
            case 1:
                System.out.println("Tell me veterinarian name: ");
                String veterinarianName = entrada.nextLine() + "%";
                Veterinarian deleteVeterinarian = JDBC.deleteVeterinarianByName(veterinarianName);
                break;

            case 2:
                System.out.println("Tell me veterianarian id: ");
                int veterinarianId = entrada.nextInt();
                entrada.nextLine();
                Veterinarian deletedVeterinarian = JDBC.deleteVeterinarianById(veterinarianId);

            case 3:
                break;
        }
    }

    public static void addAppoiment() {
        System.out.println("Tell me the date for the appointment(dd/MM/yyyy): ");
        String date = entrada.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date2 = LocalDate.parse(date, formatter);
        System.out.println("Tell me the time for the appointment (HH:mm): ");
        String time = entrada.nextLine();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time2 = LocalTime.parse(time, timeFormatter);
        System.out.println("Tell me the reason: ");
        String reason = entrada.nextLine();
        System.out.println("Tell me the pet id: ");
        int petId = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Tell me veterinarian id: ");
        int veterinarianId = entrada.nextInt();
        Appointment newAppointment = JDBC.addAppointment(date2, time2, reason, petId, veterinarianId);
    }

    public static void modifyAppointment() {
        String change = "";
        while (!change.equalsIgnoreCase("date") && !change.equalsIgnoreCase("time") && !change.equalsIgnoreCase("reason")) {
            System.out.println("Tell me what you want to change: ");
            change = entrada.nextLine();
            if (change.equalsIgnoreCase("date")) {
                System.out.println("Tell me appointment id: ");
                int appointmentId = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Tell me the new date(dd/MM/yyyy): ");
                String newDate = entrada.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate newDate2 = LocalDate.parse(newDate, formatter);
                System.out.println("Tell me the new time for the appointment (HH:mm): ");
                String newTime = entrada.nextLine();
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime newTime2 = LocalTime.parse(newTime, timeFormatter);
                Appointment modifyAppointment = JDBC.modifyAppointmentDateTime(appointmentId, newDate2, newTime2);
            } else if (change.equalsIgnoreCase("time")) {
                System.out.println("Tell me appointment id: ");
                int appointmentId = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Tell me the new time for the appointment (HH:mm): ");
                String newTime = entrada.nextLine();
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime newTime2 = LocalTime.parse(newTime, timeFormatter);
                Appointment modifyAppointment = JDBC.modifyAppointmenTime(appointmentId, newTime2);
            } else if (change.equalsIgnoreCase("reason")) {
                System.out.println("Tell me appointment id: ");
                int appointmentId = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Tell me the new reason: ");
                String newReason = entrada.nextLine();
                Appointment modifyAppointment = JDBC.modifyAppointmentReason(appointmentId, newReason);
            }
        }
    }

    public static void deleteAppointment() {
        System.out.println("Tell me the id of the appointment you want to delete: ");
        int appoitmentId=entrada.nextInt();entrada.nextLine();
        Appointment deleteAppointment=JDBC.deleteAppointment(appoitmentId);

    }
}
