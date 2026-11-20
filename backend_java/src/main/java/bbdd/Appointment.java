package bbdd;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "time")
    private LocalTime time;
    @Column(name = "reason")
    private String reason;
    @ManyToOne
    @JoinColumn(name = "veterinarianId")
    private Veterinarian veterinarian;
    @ManyToOne
    @JoinColumn(name = "petId")
    private Pet pet;
}
