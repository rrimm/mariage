package com.multi.mariage.review.dto;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ReviewsPagingCond {
    private Long productId;
    private int pageSize;
    private int pageNumber;

    /* TODO: 2023/05/22 추후 데이터 중복을 방지하기 위한 리뷰의 식별자 필요 */

    @Builder
    public ReviewsPagingCond(Long productId, int pageSize, int pageNumber) {
        this.productId = productId;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }
}
