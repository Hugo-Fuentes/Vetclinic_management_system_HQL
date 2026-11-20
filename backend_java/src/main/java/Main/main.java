package Main;

import java.util.Scanner;

public class main {
    private static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        entrada = new Scanner(System.in);

        try {
            int option = 0;
            while (option != 5) {
                principalMenu();
                option = entrada.nextInt();
                entrada.nextLine();
                if (option >= 1 && option <= 5) {
                    switch (option) {
                        case 1:
                            int optionPet=0;
                            while (optionPet != 6) {
                                petMenu();
                                optionPet= entrada.nextInt();
                                entrada.nextLine();
                                if (optionPet >= 1 && optionPet <= 5) {
                                    switch (optionPet) {
                                        case 1:

                                            break;
                                        case 2:

                                            break;
                                        case 3:

                                            break;
                                        case 4:

                                            break;
                                        case 5:

                                            break;
                                    }
                                } else System.out.println("Choose a logical option");
                            }
                            break;
                        case 2:
                            int optionClient=0;
                            while (optionClient != 5) {
                                clientMenu();
                                optionClient = entrada.nextInt();
                                entrada.nextLine();
                                if (optionClient >= 1 && optionClient <= 5) {
                                    switch (optionClient) {
                                        case 1:

                                            break;
                                        case 2:

                                            break;
                                        case 3:

                                            break;
                                        case 4:

                                            break;
                                    }
                                } else System.out.println("Choose a logical option");
                            }
                            break;
                        case 3:
                            int optionVeterinarian=0;
                            while (optionVeterinarian != 6) {
                                veterinarianMenu();
                                optionVeterinarian = entrada.nextInt();
                                entrada.nextLine();
                                if (optionVeterinarian >= 1 && optionVeterinarian <= 6) {
                                    switch (optionVeterinarian) {
                                        case 1:

                                            break;
                                        case 2:

                                            break;
                                        case 3:

                                            break;
                                        case 4:

                                            break;
                                        case 5:

                                            break;


                                    }
                                } else System.out.println("Choose a logical option");
                            }
                            break;
                        case 4:
                            int optionAppointment=0;
                            while (optionAppointment != 5) {
                                appointmentMenu();
                                optionAppointment = entrada.nextInt();
                                entrada.nextLine();
                                if (optionAppointment >= 1 && optionAppointment <= 5) {
                                    switch (optionAppointment) {
                                        case 1:

                                            break;
                                        case 2:

                                            break;
                                        case 3:

                                            break;
                                        case 4:

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
    public static void petMenu(){
        System.out.println("\t\t\t PET MENU");
        System.out.println("1-Add pet");
        System.out.println("2-Modify pet");
        System.out.println("3-Delete pet");
        System.out.println("4-View pets");
        System.out.println("5-Pets by client");
        System.out.println("6-Exit\n");
        System.out.println("Choose option: ");
    }

    public static void clientMenu(){
        System.out.println("\t\t\t CLIENT MENU");
        System.out.println("1-Add client");
        System.out.println("2-Modify client");
        System.out.println("3-Delete client");
        System.out.println("4-View client");
        System.out.println("5-Exit\n");
        System.out.println("Choose option: ");
    }

    public static void veterinarianMenu(){
        System.out.println("\t\t\t VETERINARIAN MENU");
        System.out.println("1-Add veterinarian");
        System.out.println("2-Modify veterinarian");
        System.out.println("3-Delete veterianarian");
        System.out.println("4-View veterinarian");
        System.out.println("5-View veterinarian appointments");
        System.out.println("6-Exit\n");
        System.out.println("Choose option: ");
    }

    public static void appointmentMenu(){
        System.out.println("\t\t\t APPOINTMENT MENU");
        System.out.println("1-Add appointment");
        System.out.println("2-Modify appointment");
        System.out.println("3-Delete appointment");
        System.out.println("4-View appointment");
        System.out.println("5-Exit\n");
        System.out.println("Choose option: ");
    }
}
