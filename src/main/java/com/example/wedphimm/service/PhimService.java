package com.example.wedphimm.service;

import com.example.wedphimm.entity.Phim;
import com.example.wedphimm.repository.IDaoDienRepository;
import com.example.wedphimm.repository.IPhimRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhimService {
    @Autowired
    private IPhimRepository phimRepository;

    public List<Phim> getAllPhim(){
        return phimRepository.findAll();
    }
    public Phim getPhimById(Long id){
        Optional<Phim> optional = phimRepository.findById(id);
        return optional.orElse(null);
    }
    public void addPhim(Phim phim){
        phimRepository.save(phim);
    }
    public void updatePhim(Phim phim){
        phimRepository.save(phim);
    }
    public void deletePhim(Long id){
        phimRepository.deleteById(id);
    }

}
