package com.brokflok.demomicro.repository;

import com.brokflok.demomicro.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Task,Long>{
}
