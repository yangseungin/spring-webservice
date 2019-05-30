package com.giantdwarf.webservice.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

// @MappedSuperclass: JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드에서도 컬럼으로 인식하도록함
// @EntityListeners(AuditingEntityListener.class): BaseTimeEntity클래스에 Auditing기능 포

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
	
	//@CreatedDate: entity가 생성되어 저장될때 시간이 자동저
    @CreatedDate
    private LocalDateTime createdDate;

    //조회된Entity 값 변경시 자동 저
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
