package by.zadziarnouski.tms.rest.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class Driver {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private LocalDateTime expiryDateOfDrivingLicense;
}
