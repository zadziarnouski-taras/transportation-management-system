package by.zadziarnouski.tms.domain.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class Driver {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private LocalDateTime expiryDateOfDrivingLicense;
}
