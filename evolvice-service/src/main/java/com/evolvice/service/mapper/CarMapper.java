package com.evolvice.service.mapper;

import com.evolvice.common.model.CarModel;
import com.evolvice.repository.entity.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarModel toModel(Car car);
    Car toEntity(CarModel carModel);
}
