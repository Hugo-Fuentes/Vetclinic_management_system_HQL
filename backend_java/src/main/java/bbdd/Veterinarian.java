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
    @OneToMany(mappedBy = "Appointment")
    List<Appointment> appointmentList;
}
