package com.dinesh.lumen_hackathon_1.repository;

import com.dinesh.lumen_hackathon_1.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
