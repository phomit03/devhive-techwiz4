package com.example.devhive_backend.service.impl;

import com.example.devhive_backend.dto.NewDTO;
import com.example.devhive_backend.entity.New;
import com.example.devhive_backend.repository.NewRepository;
import com.example.devhive_backend.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.devhive_backend.mapper.NewMapper.mapToNew;
import static com.example.devhive_backend.mapper.NewMapper.mapToNewDTO;

@Service
public class NewServiceImpl implements NewService {
    @Autowired
    private NewRepository newRepository;

    @Override
    public List<NewDTO> getAllNews() {
        List<New> news = newRepository.findAll();
        return news.stream().map((anew) -> mapToNewDTO(anew)).collect(Collectors.toList());
    }
    @Override
    public NewDTO getNewById(Long id) {
        New anew =  newRepository.findById(id).get();
        return mapToNewDTO(anew);
    }

    @Override
    public New createNew(NewDTO newDTO) {
        New anew = mapToNew(newDTO);
        return newRepository.save(anew);
    }

    @Override
    public void updateNew(NewDTO newDTO) {
        New anew = mapToNew(newDTO);
        newRepository.save(anew);
    }

    @Override
    public void deleteNew(Long id) {
        newRepository.deleteById(id);
    }
}
