package com.evolvice.service.test;

import com.evolvice.common.model.CarModel;
import com.evolvice.repository.CarRepository;
import com.evolvice.repository.entity.Car;
import com.evolvice.service.CarSerivce;
import com.evolvice.service.impl.CarSerivceImpl;
import com.evolvice.service.mapper.CarMapper;
import com.evolvice.service.mapper.CarMapperImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CarServiceTest {

    @Autowired
    private CarSerivce carSerivce;

    @MockBean
    private CarRepository carRepository;

    @Autowired
    private CarMapper carMapper;

    private Car car;


    @BeforeEach
    public void setup(){
        when(carRepository.save(any(Car.class))).then(invocationOnMock -> {
            car = invocationOnMock.getArgument(0);
            car.setId(1L);
            return car;
        });

        when(carRepository.findById(1L)).then(invocation -> Optional.of(car));
    }


    @Test
    public void createNewCar_ShouldAddIt(){
        CarModel carModel = new CarModel(1L, "BMW", "X6", "GRAY", "2018", "Sedan");
        carSerivce.createNewCar(carModel);
        verify(carRepository).save(car);
        assertThat(carModel.getId()).isEqualTo(car.getId());
    }

    @Test
    public void updateCar_ShouldUpdateIt(){
        CarModel carModel = new CarModel(1L, "BMW", "X6", "GRAY", "2018", "Sedan");
        carSerivce.updateCar(carModel, 1L);
        verify(carRepository).save(car);
        assertThat(carModel.getId()).isEqualTo(car.getId());
    }

    @TestConfiguration
    static class CarServiceTestContextConfiguration {

        @Bean
        public CarSerivce carSerivce(){
            return new CarSerivceImpl();
        }

        @Bean
        public CarMapper carMapper(){
            return new CarMapperImpl();
        }

    }
}
