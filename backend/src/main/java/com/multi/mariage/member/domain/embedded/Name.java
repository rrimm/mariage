package com.multi.mariage.member.domain.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Name {
    @Column(name = "name", nullable = false)
    private String name;
}