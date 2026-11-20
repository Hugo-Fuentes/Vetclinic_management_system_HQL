package bbdd;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientId")
    private int clientId;
    @Column(name = "name")
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "dni")
    private String dni;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @OneToMany(mappedBy = "Pet")
    List<Pet> petList;
}
