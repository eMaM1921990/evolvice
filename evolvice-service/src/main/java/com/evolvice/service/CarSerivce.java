package com.evolvice.service;

import com.evolvice.common.model.CarModel;

import java.util.List;

public interface CarSerivce {
    List<CarModel> findAllCar();
    CarModel createNewCar(CarModel carModel);
    CarModel updateCar(CarModel carModel, Long id);
    void deleteCar(Long id);
}
