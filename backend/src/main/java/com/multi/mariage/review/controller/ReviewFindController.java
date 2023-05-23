package com.multi.mariage.review.controller;

import com.multi.mariage.review.domain.Sort;
import com.multi.mariage.review.dto.resonse.ProductReviewsResponse;
import com.multi.mariage.review.service.ReviewFindService;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class ReviewFindController {
    private final ReviewFindService reviewFindService;

    @GetMapping("/review/product/{productId}")
    public ResponseEntity<ProductReviewsResponse> findReviewsByProductId(@PathVariable("productId") Long productId,
                                                                         @Param("memberId") @Nullable Long memberId,
                                                                         @Param("pageNumber") int pageNumber,
                                                                         @Param("pageSize") int pageSize,
                                                                         @Param("sort") @Nullable String sort) {
        ProductReviewsResponse response = reviewFindService.findReviewsByProductId(productId, memberId,
                pageNumber, pageSize, sort);
        return ResponseEntity.ok(response);
    }
}