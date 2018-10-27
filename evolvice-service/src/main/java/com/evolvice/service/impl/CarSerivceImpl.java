package com.evolvice.service.impl;

import com.evolvice.common.model.CarModel;
import com.evolvice.repository.CarRepository;
import com.evolvice.repository.entity.Car;
import com.evolvice.service.CarSerivce;
import com.evolvice.service.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarSerivceImpl implements CarSerivce {

    @Autowired private CarRepository carRepository;

    @Autowired private CarMapper carMapper;

    @Override
    public List<CarModel> findAllCar() {
        return this.carRepository.findAll().stream().map(model -> carMapper.toModel(model)).collect(Collectors.toList());
    }

    @Override
    public CarModel createNewCar(CarModel carModel) {
        Car car = this.carMapper.toEntity(carModel);
        car = this.carRepository.save(car);
        return this.carMapper.toModel(car);
    }

    @Override
    public CarModel updateCar(CarModel carModel, Long id) {
        Car car = this.carMapper.toEntity(carModel);
        car = this.carRepository.save(car);
        return this.carMapper.toModel(car);
    }

    @Override
    public void deleteCar(Long id) {
        this.carRepository.deleteById(id);
    }
}
