package by.zadziarnouski.tms.rest.model;

import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Driver {
    private long id;
    @NotBlank(message = "First name is mandatory")
    private String firstName;
    @NotBlank(message = "Last name is mandatory")
    private String lastName;
    @Past
    private LocalDate birthday;
    @Future
    private LocalDateTime expiryDateOfDrivingLicense;
}
