package com.evolvice.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(of = {"id"})
@AllArgsConstructor
@NoArgsConstructor
public class CarModel {
    private Long id;
    @NotNull
    private String brand;
    @NotBlank
    private String model;
    @NotNull
    private String color;
    @NotNull
    @Size(min = 4, max = 4)
    private String yearOfProduction;
    @NotNull
    private String type;

}
