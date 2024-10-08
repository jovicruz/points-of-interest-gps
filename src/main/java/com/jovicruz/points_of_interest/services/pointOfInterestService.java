package com.jovicruz.points_of_interest.services;

import com.jovicruz.points_of_interest.dtos.poi.pointOfInterestRequest;
import com.jovicruz.points_of_interest.dtos.poi.pointOfInterestResponse;
import com.jovicruz.points_of_interest.dtos.poi.pointOfReferenceRequest;
import com.jovicruz.points_of_interest.repositories.pointOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class pointOfInterestService {

    @Autowired
    pointOfInterestRepository repo;

    public pointOfInterestResponse createPointOfInterest(pointOfInterestRequest request){
        return  pointOfInterestResponse.from(repo.save(pointOfInterestRequest.to(request)));
    }

    public List<pointOfInterestResponse> getAllPointsOfInterest(){
        return repo.findAll().stream()
                .map(pointOfInterestResponse::from)
                .collect(Collectors.toList());
    }

    public List<pointOfInterestResponse> getNearestsPointsOfInterest(pointOfReferenceRequest ref) {
        return repo.findNearestPOIs(ref.getX(), ref.getY(), ref.getDMax()).stream()
                .map(pointOfInterestResponse::from)
                .collect(Collectors.toList());
    }
}
