package com.jovicruz.points_of_interest.dtos;

import com.jovicruz.points_of_interest.domain.PointOfInterest;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
@AllArgsConstructor
public class pointOfInterestRequest {
    @NotEmpty
    private String name;
    @NotEmpty
    @PositiveOrZero
    private int x;
    @NotEmpty
    @PositiveOrZero
    private int y;


    public static PointOfInterest to(pointOfInterestRequest request){
        return new PointOfInterest(request.getName(), request.getX(), request.getY());
    }
}
