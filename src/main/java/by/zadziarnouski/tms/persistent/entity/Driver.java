package by.zadziarnouski.tms.persistent.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "drivers")
@Data
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private LocalDateTime expiryDateOfDrivingLicense;
}
