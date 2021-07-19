package by.zadziarnouski.tms.persistent.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "stations")
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
