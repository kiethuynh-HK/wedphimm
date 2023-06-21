package com.example.wedphimm.service;

import com.example.wedphimm.entity.Phong;
import com.example.wedphimm.entity.Ve;
import com.example.wedphimm.repository.IPhongRepository;
import com.example.wedphimm.repository.IVeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeService {
    @Autowired
    private IVeRepository iveRepository;

    public List<Ve> getAllVe(){
        return iveRepository.findAll();
    }
    public Ve getVeById(Long id){
        Optional<Ve> optional = iveRepository.findById(id);
        return optional.orElse(null);
    }
    public void addVe(Ve ve){
        iveRepository.save(ve);
    }
    public void updateVe(Ve ve){
        iveRepository.save(ve);
    }
    public void deleteVe(Long id){
        iveRepository.deleteById(id);
    }
}
