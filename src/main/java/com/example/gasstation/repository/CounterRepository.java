package com.example.gasstation.repository;

import com.example.gasstation.model.Counter;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CounterRepository extends CrudRepository<Counter, Long> {

    @Modifying
    @Query("UPDATE Counter c set c.number = c.number + 1 WHERE c.id = 1")
    void increment();

    @Query("SELECT c.number FROM Counter c WHERE c.id = 1")
    Long get();
}
