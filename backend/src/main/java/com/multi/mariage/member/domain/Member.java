package com.multi.mariage.member.domain;

import com.multi.mariage.like.domain.Like;
import com.multi.mariage.member.domain.embedded.Email;
import com.multi.mariage.member.domain.embedded.Name;
import com.multi.mariage.member.domain.embedded.Nickname;
import com.multi.mariage.member.domain.embedded.Password;
import com.multi.mariage.storage.domain.Image;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private LocalDate birth;

    @Embedded
    private Email email;

    @Embedded
    private Name name;

    @Embedded
    private Nickname nickname;

    @Embedded
    private Password password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private boolean deleted;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Like> likes = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image image;

    /* 연관관계 편의 메서드 */
    public void setImage(Image image) {
        this.image = image;
    }
}