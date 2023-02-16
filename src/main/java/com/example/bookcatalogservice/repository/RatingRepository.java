package com.example.bookcatalogservice.repository;

import com.example.bookcatalogservice.model.Rating;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface RatingRepository extends R2dbcRepository<Rating, Long> {
    Mono<Rating> findByBookId(Long bookId);
}
