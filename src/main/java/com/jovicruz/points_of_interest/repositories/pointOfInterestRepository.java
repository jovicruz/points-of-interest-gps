package com.jovicruz.points_of_interest.repositories;

import com.jovicruz.points_of_interest.domain.PointOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface pointOfInterestRepository extends JpaRepository<PointOfInterest, Long> {

    @Query(value = "SELECT * FROM point_of_interest WHERE ABS(x - :refX) + ABS(y - :refY) <= :maxDistance ORDER BY ABS(x - :refX) + ABS(y - :refY)", nativeQuery = true)
    List<PointOfInterest> findNearestPOIs(@Param("refX") int refX, @Param("refY") int refY, @Param("maxDistance") int maxDistance);
}
