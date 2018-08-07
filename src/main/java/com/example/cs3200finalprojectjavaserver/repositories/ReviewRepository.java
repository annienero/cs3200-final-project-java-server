package com.example.cs3200finalprojectjavaserver.repositories;

import com.example.cs3200finalprojectjavaserver.models.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer> {

}