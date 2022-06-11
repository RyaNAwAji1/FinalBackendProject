package com.example.technicalworkshop.Service;

import com.example.technicalworkshop.Model.ServiceEvaluation;
import com.example.technicalworkshop.Repository.ServiceRepository;
import com.example.technicalworkshop.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceEvaluationService {

    private final ServiceRepository serviceRepository;
    private final UserRepository userRepository;



    public List <ServiceEvaluation> getEvaluation(){
        return serviceRepository.findAll();
    }

    public void addEvaluation(ServiceEvaluation serviceEvaluation) {
        serviceRepository.save(serviceEvaluation);
    }
}
