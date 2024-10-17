package com.example.supabase.Models.DAO;

import com.example.supabase.Models.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RUser extends JpaRepository<User, Long> {

}
