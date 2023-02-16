package com.example.bookcatalogservice.service;

import com.example.bookcatalogservice.model.Rating;
import com.example.bookcatalogservice.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;

    public Mono<Rating> findByBookId(Long bookId) {
        return ratingRepository.findByBookId(bookId);
    }

    public Flux<Rating> getAll() {
        return ratingRepository.findAll();
    }

}
