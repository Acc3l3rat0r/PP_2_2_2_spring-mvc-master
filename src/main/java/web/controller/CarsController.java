package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImp;

import java.util.Optional;


@Controller
public class CarsController {

    private final CarServiceImp carServiceImp;

    public CarsController(CarServiceImp carServiceImp) {
        this.carServiceImp = carServiceImp;
    }

    @GetMapping("/cars")
    public String index(
            @RequestParam(required = false)Optional<Integer> count,
            Model model) {

        model.addAttribute("allCars", carServiceImp.getCars(count));
        return "cars";
    }
}
