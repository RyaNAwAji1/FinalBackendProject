package com.example.technicalworkshop.Repository;

import com.example.technicalworkshop.Model.Troubles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TroublesRepository extends JpaRepository <Troubles,Integer> {
}
