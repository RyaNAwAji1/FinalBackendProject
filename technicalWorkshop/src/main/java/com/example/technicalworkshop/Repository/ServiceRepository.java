package com.example.technicalworkshop.Repository;

import com.example.technicalworkshop.Model.ServiceEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository <ServiceEvaluation,Integer> {
}
