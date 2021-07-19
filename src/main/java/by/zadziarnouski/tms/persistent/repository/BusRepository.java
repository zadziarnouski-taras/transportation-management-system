package by.zadziarnouski.tms.persistent.repository;

import by.zadziarnouski.tms.persistent.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus,Long> {
    Bus findByRegistrationPlate(String registrationPlate);

}
