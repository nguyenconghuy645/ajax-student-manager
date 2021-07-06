package com.huy.service.provinceBirth;

import com.huy.model.ProvinceBirth;
import com.huy.repository.IProvinceBirthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceBirthService implements IProvinceBirthService {
    @Autowired
    private IProvinceBirthRepository provinceBirthRepository;

    @Override
    public Iterable<ProvinceBirth> findAll() {
        return provinceBirthRepository.findAll();
    }

    @Override
    public Optional<ProvinceBirth> findById(Long id) {
        return provinceBirthRepository.findById(id);
    }

    @Override
    public ProvinceBirth save(ProvinceBirth provinceBirth) {
        return provinceBirthRepository.save(provinceBirth);
    }

    @Override
    public void remove(Long id) {
        provinceBirthRepository.deleteById(id);
    }
}
