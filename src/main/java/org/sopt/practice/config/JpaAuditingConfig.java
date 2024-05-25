package org.sopt.practice.config;

import jakarta.persistence.Entity;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
Auditing 기능을 통해, 엔티티 생성되고 변경되는 시점 감지해서
생성시각/수정시각/생성한 사람/수정한 사람 기록 가능
 */
@Configuration
@EnableJpaAuditing //JPA가 엔티티를 감시할 수 있게 해줌
public class JpaAuditingConfig {
}