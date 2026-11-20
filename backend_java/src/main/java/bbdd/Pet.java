package bbdd;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "petId")
    private int petId;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "Appointment")
    private List<Appointment> appointmentList;
    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

}
