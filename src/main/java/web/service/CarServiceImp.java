package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CarServiceImp {

    private final List<Car> carList;

    {
        carList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            carList.add(new Car("someModel", "someType", 300));
        }
    }

    public List<Car> getCars(Optional<Integer> count) {
        return count.map(integer -> carList.stream().limit(integer).toList()).orElse(carList);
    }

}
