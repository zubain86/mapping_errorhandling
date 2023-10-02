package com.example.demo.dao;

import com.example.demo.entity.BillEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Transactional
@Repository
public interface BillRepo extends JpaRepository<BillEntity,Long> {

    @Modifying
    @Query(value = "update device_entity set bill_fk = :value1 where device_id = :value2",nativeQuery = true)
     void addForeignKey(@Param("value1") Long value1,@Param("value2") Long value2);
}
