package com.multi.mariage.review.domain.query;

import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.dto.cond.MemberReviewsPagingCond;
import com.multi.mariage.review.dto.cond.ReviewsPagingCond;

import java.util.List;

public interface ReviewRepositoryCustom {

    List<Review> findReviewsByProductId(ReviewsPagingCond cond);

    Long findReviewsCountByProductId(Long productId, FoodCategory foodCategory);

    List<Review> findRatedReviewsByMemberId(MemberReviewsPagingCond cond);

    Long findReviewsCountByRatings(Long memberId);

    List<Review> findLikedReviewsByMemberId(MemberReviewsPagingCond cond);

    Long findReviewsCountByLikes(Long memberId);
}
