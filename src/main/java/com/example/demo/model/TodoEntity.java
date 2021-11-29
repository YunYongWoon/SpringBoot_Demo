package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Builder            // Builder 패턴 사용
@NoArgsConstructor  // 매개변수가 없는 생성자
@AllArgsConstructor // 모든 매개변수를 담은 생성자
@Data               // Getter/Setter 메서드 구현
@Entity             // 엔티티 클래스는 클래스 그 자체가 테이블을 정의해야한다.
@Table(name = "Todo") // 테이블 이름을 지정. 데이터베이스의 해당 name 테이블로 정의됨.
public class TodoEntity {

    // @Id : 기본키
    // @GeneratedValue : ID를 자동 생성 // generator : 어떤 방식으로 ID를 생성할지
    // @GenericGenerator : Hibernate가 제공하는 기본 Generator가 아닌 나만의 Generator 사용시
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String userId;
    private String title;
    private boolean done;
}
