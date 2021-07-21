package by.zadziarnouski.tms.rest.controller;

import by.zadziarnouski.tms.domain.service.RouteService;
import by.zadziarnouski.tms.mapper.RouteMapper;
import by.zadziarnouski.tms.rest.model.Route;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/tms/routes")
public class RouteController {
    @Resource
    private RouteService routeService;
    @Resource
    private RouteMapper routeMapper;

    @GetMapping("/{id}")
    public Route get(@PathVariable Long id) {
        return routeMapper.domainToView(routeService.findById(id));
    }

    @GetMapping()
    public List<Route> getAll() {
        return routeService.findAll().stream().map(routeMapper::domainToView).collect(toList());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody Route route) {
        routeService.saveOrUpdate(routeMapper.viewToDomain(route));
    }

    @PutMapping()
    public Route update(@Valid @RequestBody Route route) {
        by.zadziarnouski.tms.domain.model.Route updatedRoute = routeService.saveOrUpdate(routeMapper.viewToDomain(route));
        return routeMapper.domainToView(updatedRoute);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        routeService.delete(id);
    }

}
