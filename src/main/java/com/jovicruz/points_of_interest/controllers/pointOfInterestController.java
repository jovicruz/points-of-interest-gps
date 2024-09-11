package com.jovicruz.points_of_interest.controllers;

import com.jovicruz.points_of_interest.domain.PointOfInterest;
import com.jovicruz.points_of_interest.dtos.pointOfInterestRequest;
import com.jovicruz.points_of_interest.dtos.pointOfInterestResponse;
import com.jovicruz.points_of_interest.dtos.pointOfReferenceRequest;
import com.jovicruz.points_of_interest.services.pointOfInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class pointOfInterestController {
    @Autowired
    pointOfInterestService service;


    @GetMapping("/")
    public ResponseEntity<List<pointOfInterestResponse>> getAllPointsOfInterest(){
        return ResponseEntity.ok().body(service.getAllPointsOfInterest());
    }

    @GetMapping("/getnearest/")
    public ResponseEntity<List<pointOfInterestResponse>> getNearestsPointsOfInterest(@RequestBody pointOfReferenceRequest request){
        return ResponseEntity.ok().body(service.getNearestsPointsOfInterest(request));
    }


    @PostMapping("/newpoi")
    public ResponseEntity<pointOfInterestResponse> createNewPointOfInterest(@RequestBody pointOfInterestRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createPointOfInterest(request));

    }


}
