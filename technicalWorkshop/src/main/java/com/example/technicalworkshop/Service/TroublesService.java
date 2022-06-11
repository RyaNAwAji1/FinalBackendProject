package com.example.technicalworkshop.Service;

import com.example.technicalworkshop.Model.Troubles;
import com.example.technicalworkshop.Model.User;
import com.example.technicalworkshop.Repository.TroublesRepository;
import com.example.technicalworkshop.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TroublesService {

    private final TroublesRepository troublesRepository;
    private final UserRepository userRepository;


    public List<Troubles> getAllTroubles() {
        return troublesRepository.findAll();
    }

    public void addTroubles(Troubles troubles) {
        troublesRepository.save(troubles);
    }
    public void addTroublesToUser(Integer troubleID, Integer userId){

        Troubles troubles= troublesRepository.findById(troubleID).get();
        User user= userRepository.findById(userId).get();

        troubles.setTroubleID(userId);
        troublesRepository.save(troubles);

        user.getTroubles().add(troubles);
        userRepository.save(user);
    }
}
