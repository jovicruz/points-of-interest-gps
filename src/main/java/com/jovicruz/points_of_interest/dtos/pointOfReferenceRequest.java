package com.jovicruz.points_of_interest.dtos;

import com.jovicruz.points_of_interest.domain.PointOfInterest;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class pointOfReferenceRequest {
    @NotEmpty
    @PositiveOrZero
    private int x;
    @NotEmpty
    @PositiveOrZero
    private int y;
    @NotEmpty
    @Positive
    private int dMax;
}
