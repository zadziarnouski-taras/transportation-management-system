package by.zadziarnouski.tms.rest.controller;

import by.zadziarnouski.tms.domain.service.DriverService;
import by.zadziarnouski.tms.mapper.DriverMapper;
import by.zadziarnouski.tms.rest.model.Bus;
import by.zadziarnouski.tms.rest.model.Driver;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/tms/drivers")
public class DriverController {
    @Resource
    private DriverService driverService;
    @Resource
    private DriverMapper driverMapper;

    @GetMapping("/{id}")
    public Driver get(@PathVariable("id") Long id) {
        return driverMapper.domainToView(driverService.findById(id));
    }

    @GetMapping()
    public List<Driver> getAll() {
        return driverService.findAll().stream().map(driverMapper::domainToView).collect(toList());
    }

    @PostMapping()
    public void create(@RequestBody Driver driver) {
        driverService.saveOrUpdate(driverMapper.viewToDomain(driver));
    }

    @PutMapping()
    public Driver update(@RequestBody Driver driver) {
        by.zadziarnouski.tms.domain.model.Driver updatedDriver = driverService.saveOrUpdate(driverMapper.viewToDomain(driver));
        return driverMapper.domainToView(updatedDriver);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        driverService.delete(id);
    }

}
