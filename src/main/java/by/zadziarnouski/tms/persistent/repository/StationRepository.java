package by.zadziarnouski.tms.persistent.repository;

import by.zadziarnouski.tms.persistent.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station,Long> {
    Station findByLocation(String location);
}
