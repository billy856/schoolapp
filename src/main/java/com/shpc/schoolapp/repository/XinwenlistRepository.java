package com.shpc.schoolapp.repository;

import com.shpc.schoolapp.model.Xinwenlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XinwenlistRepository extends JpaRepository<Xinwenlist,String> {

}
