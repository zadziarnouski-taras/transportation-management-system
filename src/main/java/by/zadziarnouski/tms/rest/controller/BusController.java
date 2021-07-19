package by.zadziarnouski.tms.rest.controller;

import by.zadziarnouski.tms.domain.service.BusService;
import by.zadziarnouski.tms.mapper.BusMapper;
import by.zadziarnouski.tms.rest.model.Bus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/tms/buses")
public class BusController {
    @Resource
    private BusService busService;
    @Resource
    private BusMapper busMapper;

    @GetMapping("/{id}")
    public by.zadziarnouski.tms.rest.model.Bus get(@PathVariable("id") Long id) {
        return busMapper.domainToView(busService.findById(id));
    }

    @GetMapping()
    public List<Bus> getAll() {
        return busService.findAll().stream().map(busMapper::domainToView).collect(toList());
    }

    @PostMapping()
    public void create(@RequestBody Bus bus) {
        busService.saveOrUpdate(busMapper.viewToDomain(bus));
    }

    @PutMapping()
    public Bus update(@RequestBody Bus bus) {
        by.zadziarnouski.tms.domain.model.Bus updatedBus = busService.saveOrUpdate(busMapper.viewToDomain(bus));
        return busMapper.domainToView(updatedBus);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        busService.delete(id);
    }

}
