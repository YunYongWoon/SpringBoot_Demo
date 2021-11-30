package com.example.demo.persistence;

import com.example.demo.model.TodoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// JpaRepository<T,ID>
// T : 테이블에 매핑될 엔티티 클래스
// ID : 엔티티의 기본 키의 타입
@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
    List<TodoEntity> findByUserId(String id);
}
