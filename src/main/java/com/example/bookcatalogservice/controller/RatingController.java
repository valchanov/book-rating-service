package com.example.bookcatalogservice.controller;

import com.example.bookcatalogservice.model.Rating;
import com.example.bookcatalogservice.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    @GetMapping("/{bookId}")
    public Mono<ResponseEntity<Rating>> getRatingByBookId(@PathVariable("bookId") Long id) {
        return ratingService.findByBookId(id)
                            .map(ResponseEntity::ok)
                            .defaultIfEmpty(ResponseEntity.notFound()
                                                          .build());
    }

    @GetMapping
    public Flux<Rating> getAllRatings() {
        return ratingService.getAll();
    }
}
