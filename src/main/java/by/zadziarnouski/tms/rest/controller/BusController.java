package by.zadziarnouski.tms.rest.controller;

import by.zadziarnouski.tms.domain.model.Bus;
import by.zadziarnouski.tms.domain.service.BusService;
import by.zadziarnouski.tms.mapper.BusMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/")
public class BusController {
    @Resource
    private BusService busService;
    @Resource
    private BusMapper busMapper;

    @GetMapping(path = "/bus")
    public by.zadziarnouski.tms.rest.viewModel.Bus getBusByRegistrationPlate(@RequestParam String registrationPlate) {
        return busMapper.domainToView(busService.findByRegistrationPlate(registrationPlate));
    }

}
