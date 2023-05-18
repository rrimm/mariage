package com.multi.mariage.like.service;

import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.like.domain.Like;
import com.multi.mariage.like.domain.LikeRepository;
import com.multi.mariage.like.dto.request.LikeSaveRequest;
import com.multi.mariage.like.exception.LikeErrorCode;
import com.multi.mariage.like.exception.LikeException;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.service.MemberFindService;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.service.ReviewFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class LikeService {
    private final LikeRepository likeRepository;
    private final MemberFindService memberFindService;
    private final ReviewFindService reviewFindService;

    @Transactional
    public void save(AuthMember authMember, LikeSaveRequest request) {

        Member member = memberFindService.findById(authMember.getId());
        Review review = reviewFindService.findById(request.getReviewId());
        validateMemberAlreadyLiked(authMember.getId(), request.getReviewId());

        Like like = Like.builder()
                .member(member)
                .review(review)
                .build();

        likeRepository.save(like);
    }
    private void validateMemberAlreadyLiked(Long memberId, Long reviewId) {
        boolean isExist = likeRepository.existsByMemberIdAndReviewId(memberId, reviewId);
        if (isExist) {
            throw new LikeException(LikeErrorCode.REVIEW_ALREADY_LIKED);
        }
    }
}
