package by.zadziarnouski.tms.persistent.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stations")
@Data
@EqualsAndHashCode(exclude = {"routes"})
@ToString(exclude = {"routes"})
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String location;
    private int numberOfPlatforms;
    @OneToMany(mappedBy = "station",fetch = FetchType.EAGER)
    private List<Route> routes;
}
