package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder            // Builder 패턴 사용
@NoArgsConstructor  // 매개변수가 없는 생성자
@AllArgsConstructor // 모든 매개변수를 담은 생성자
@Data               // Getter/Setter 메서드 구현
public class TodoEntity {
    private String id;
    private String userId;
    private String title;
    private boolean done;
}
