package com.example.wedphimm.service;

import com.example.wedphimm.entity.ChiNhanh;
import com.example.wedphimm.repository.IChiNhanhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChiNhanhService {
    @Autowired
    private IChiNhanhRepository ichinhanhRepository;


    public List<ChiNhanh> getAllChiNhanhs(){ return ichinhanhRepository.findAll();}
    public ChiNhanh getChiNhanhById(Long id)
    {
        Optional<ChiNhanh> optionalChiNhanh = ichinhanhRepository.findById(id);
        if(optionalChiNhanh.isPresent()){
            return optionalChiNhanh.get();
        }else{
            throw new RuntimeException("ChiNhanh not found");
        }
    }

    public ChiNhanh saveChiNhanh(ChiNhanh chinhanh){ return ichinhanhRepository.save(chinhanh);}
    public ChiNhanh createChiNhanh(ChiNhanh chinhanh){ return ichinhanhRepository.save(chinhanh);}
    public  void  updateChiNhanh(ChiNhanh chinhanh) { ichinhanhRepository.save(chinhanh);}
    public void deleteChiNhanh(Long id) { ichinhanhRepository.deleteById(id);}

}
