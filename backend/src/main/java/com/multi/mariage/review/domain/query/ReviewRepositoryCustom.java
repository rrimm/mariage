package com.multi.mariage.review.domain.query;

import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.dto.MemberReviewsPagingCond;
import com.multi.mariage.review.dto.ReviewsPagingCond;

import java.util.List;

public interface ReviewRepositoryCustom {

    List<Review> findReviewsByProductId(ReviewsPagingCond cond);

    Long findReviewsCountByProductId(Long productId);

    List<Review> findRatedReviewsByMemberId(MemberReviewsPagingCond cond);

    Long findReviewsCountByRatings(Long memberId);

    List<Review> findLikedReviewsByMemberId(MemberReviewsPagingCond cond);

    Long findReviewsCountByLikes(Long memberId);
}
