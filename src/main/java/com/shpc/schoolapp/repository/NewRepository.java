package com.shpc.schoolapp.repository;

import com.shpc.schoolapp.model.New;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewRepository extends JpaRepository<New,String> {
    New findByNewid(String newid);
}
