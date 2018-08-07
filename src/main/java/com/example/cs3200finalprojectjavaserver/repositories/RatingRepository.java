package com.example.cs3200finalprojectjavaserver.repositories;

import com.example.cs3200finalprojectjavaserver.models.Rating;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Integer> {

}