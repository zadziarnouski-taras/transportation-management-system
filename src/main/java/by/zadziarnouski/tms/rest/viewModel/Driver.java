package by.zadziarnouski.tms.rest.viewModel;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class Driver {
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private LocalDateTime expiryDateOfDrivingLicense;
}
