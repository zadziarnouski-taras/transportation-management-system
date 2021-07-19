package by.zadziarnouski.tms.persistent.repository;

import by.zadziarnouski.tms.persistent.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
    Driver findDriverByFirstNameAndLastName(String firstName, String lastName);
}
