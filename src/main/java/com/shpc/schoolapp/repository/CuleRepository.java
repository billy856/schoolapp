package com.shpc.schoolapp.repository;

import com.shpc.schoolapp.model.Cule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuleRepository extends JpaRepository<Cule,String> {
    Cule findByCuleid(String culeid);
    List<Cule> findByCuleuseridAndCuleclass(String culeuserid,String culeclass);
}
