package com.example.wedphimm.service;

import com.example.wedphimm.entity.Phong;
import com.example.wedphimm.repository.IPhongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PhongService {
    @Autowired
    private IPhongRepository iPhongRepository;

    public List<Phong> getAllPhong(){
        return iPhongRepository.findAll();
    }
    public Phong getPhongById(Long id){
        Optional<Phong> optional = iPhongRepository.findById(id);
        return optional.orElse(null);
    }

    public void addPhong(Phong phong){
        iPhongRepository.save(phong);
    }
    public void updatePhong(Phong phong){
        iPhongRepository.save(phong);
    }
    public void deletePhong(Long id){
        iPhongRepository.deleteById(id);
    }
}
