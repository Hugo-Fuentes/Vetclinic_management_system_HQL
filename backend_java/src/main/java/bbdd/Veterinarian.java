package bbdd;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "veterinarian")
public class Veterinarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "veterinarianId")
    private int veterinarianId;
    @Column(name = "name")
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "speciality")
    private String speciality;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @OneToMany(mappedBy = "veterinarian", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Appointment> appointmentList;

    public Veterinarian() {
    }

    public Veterinarian(int veterinarianId, String name, String lastName, String speciality, String phoneNumber) {
        this.veterinarianId = veterinarianId;
        this.name = name;
        this.lastName = lastName;
        this.speciality = speciality;
        this.phoneNumber = phoneNumber;
    }

    public int getVeterinarianId() {
        return veterinarianId;
    }

    public void setVeterinarianId(int veterinarianId) {
        this.veterinarianId = veterinarianId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "veterinarianId=" + veterinarianId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", speciality='" + speciality + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
