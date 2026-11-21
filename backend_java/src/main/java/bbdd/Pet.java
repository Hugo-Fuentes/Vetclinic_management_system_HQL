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
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointmentList;
    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    public Pet() {
    }

    public Pet(int petId, String name, Client client) {
        this.petId = petId;
        this.name = name;
        this.client = client;
    }

    public Pet(String name, Client client) {
        this.name = name;
        this.client = client;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", name='" + name + '\'' +
                ", client=" + client.getClientId() +
                '}';
    }
}
