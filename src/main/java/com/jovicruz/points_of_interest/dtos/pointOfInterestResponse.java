package com.jovicruz.points_of_interest.dtos;

import com.jovicruz.points_of_interest.domain.poi.PointOfInterest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class pointOfInterestResponse {
    private String name;
    private int x;
    private int y;

    public static pointOfInterestResponse from(PointOfInterest poi){
        return new pointOfInterestResponse(poi.getName(), poi.getX(), poi.getY());
    }
}
