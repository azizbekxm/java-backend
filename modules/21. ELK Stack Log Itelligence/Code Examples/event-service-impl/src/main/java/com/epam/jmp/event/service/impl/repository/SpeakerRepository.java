package com.epam.jmp.event.service.impl.repository;

import com.epam.jmp.event.service.dto.Speaker;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface SpeakerRepository extends CrudRepository<Speaker, BigInteger> {

}
