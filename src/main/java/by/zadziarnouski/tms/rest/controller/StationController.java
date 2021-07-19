package by.zadziarnouski.tms.rest.controller;

import by.zadziarnouski.tms.domain.service.StationService;
import by.zadziarnouski.tms.mapper.StationMapper;
import by.zadziarnouski.tms.rest.model.Bus;
import by.zadziarnouski.tms.rest.model.Station;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/tms/stations")
public class StationController {
    @Resource
    private StationService stationService;
    @Resource
    private StationMapper stationMapper;

    @GetMapping("/{id}")
    public Station get(@PathVariable("id") Long id) {
        return stationMapper.domainToView(stationService.findById(id));
    }

    @GetMapping()
    public List<Station> getAll() {
        return stationService.findAll().stream().map(stationMapper::domainToView).collect(toList());
    }

    @PostMapping()
    public void create(@RequestBody Station station) {
        stationService.saveOrUpdate(stationMapper.viewToDomain(station));
    }

    @PutMapping()
    public Station update(@RequestBody Station station) {
        by.zadziarnouski.tms.domain.model.Station updatedStation = stationService.saveOrUpdate(stationMapper.viewToDomain(station));
        return stationMapper.domainToView(updatedStation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        stationService.delete(id);
    }

}
