package com.shpc.schoolapp.repository;

import com.shpc.schoolapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
//    public User findByUsernameAndUserpassword(String username,String userpassword);
     User findByUsertelAndUserpassword(String usertel,String userpassword);
     List<User> findByUsertelOrUserid(String usertel,String userid);
     User findByUserid(String userid);
}
