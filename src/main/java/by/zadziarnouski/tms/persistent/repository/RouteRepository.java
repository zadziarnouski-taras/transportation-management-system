package by.zadziarnouski.tms.persistent.repository;

import by.zadziarnouski.tms.persistent.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
}
