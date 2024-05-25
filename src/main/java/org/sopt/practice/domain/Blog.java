package org.sopt.practice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.practice.service.dto.BlogCreateRequest;
import org.sopt.practice.service.dto.BlogTitleUpdateRequest;

@Entity
@Getter
@NoArgsConstructor
public class Blog extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(length = 200)
    private String title;

    private String description;

//    private Blog(Member member, String title, String description) {
//        this.member = member;
//        this.title = title;
//        this.description = description;
//    }
//
//    public static Blog create(Member member, BlogCreateRequest blogCreateRequest) {
//        return new Blog(member, blogCreateRequest.title(), blogCreateRequest.description());
//    }

    private String imageUrl;

    private Blog(Member member, String title, String imageUrl, String description) {
        this.member = member;
        this.title = title;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public static Blog create(
            Member member,
            String title,
            String description,
            String imageUrl
    ) {
        return new Blog(member, title, imageUrl, description);
    }

    public void updateTitle(BlogTitleUpdateRequest blogTitleUpdateRequest) {
        this.title = blogTitleUpdateRequest.title();
    }


}