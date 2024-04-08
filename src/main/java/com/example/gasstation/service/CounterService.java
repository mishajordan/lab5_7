package com.example.gasstation.service;

import com.example.gasstation.repository.CounterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CounterService {
    private final CounterRepository counterRepository;

    public CounterService(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    public Long init() {
        counterRepository.increment();
        return counterRepository.get();
    }
}
