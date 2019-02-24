package com.shpc.schoolapp.repository;

import com.shpc.schoolapp.model.Xinwen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XinwenRepository extends JpaRepository<Xinwen,String> {
    Xinwen findByNewid(String newid);
}
