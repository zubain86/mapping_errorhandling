package com.example.demo.dao;

import com.example.demo.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepo extends JpaRepository<BillEntity,Long> {
}
