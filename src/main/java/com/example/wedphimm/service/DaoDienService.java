package com.example.wedphimm.service;

import com.example.wedphimm.entity.DaoDien;
import com.example.wedphimm.repository.IDaoDienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DaoDienService {
    @Autowired
    private IDaoDienRepository daoDienRepository;

    public List<DaoDien> getAllDaoDien(){
        return daoDienRepository.findAll();
    }
    public DaoDien getDaoDienyId(Long id){
        Optional<DaoDien> optional = daoDienRepository.findById(id);
        return optional.orElse(null);
    }
    public void addDaoDien(DaoDien daoDien){
        daoDienRepository.save(daoDien);
    }
    public void updateDaoDien(DaoDien daoDien){
        daoDienRepository.save(daoDien);
    }
    public void deleteDaoDien(Long id){
        daoDienRepository.deleteById(id);
    }
}
