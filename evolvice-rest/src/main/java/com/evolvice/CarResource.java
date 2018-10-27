package com.evolvice;

import com.evolvice.common.model.CarModel;
import com.evolvice.service.CarSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("v1/cars")
public class CarResource {

    @Autowired
    private CarSerivce carSerivce;

    @GetMapping
    public ResponseEntity<List<CarModel>> retrieveAllCars(){
        List<CarModel> carModelsList = this.carSerivce.findAllCar();
        return ResponseEntity.ok(carModelsList);
    }

    @PostMapping
    public ResponseEntity<CarModel> addNewCar(@Valid @RequestBody CarModel carModel){
        carModel = this.carSerivce.createNewCar(carModel);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(carModel.getId()).toUri();
        return ResponseEntity.created(location).body(carModel);
    }

    @PutMapping("{id}")
    public ResponseEntity<CarModel> updateCar(@Valid @RequestBody CarModel carModel, @PathVariable Long id){
        carModel = this.carSerivce.updateCar(carModel, id);
        return ResponseEntity.ok(carModel);
    }

    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable Long id){
        this.carSerivce.deleteCar(id);
    }
}
