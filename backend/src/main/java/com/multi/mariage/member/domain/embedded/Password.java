package com.multi.mariage.member.domain.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Password {
    @Column(name = "password", nullable = false)
    private String value;
}