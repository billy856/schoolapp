package com.shpc.schoolapp.repository;

import com.shpc.schoolapp.model.Newlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewlistRepository extends JpaRepository<Newlist,String> {

}
