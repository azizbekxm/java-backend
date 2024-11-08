package com.epam.jmp.event.service.impl;

import com.epam.jmp.event.service.SpeakerService;
import com.epam.jmp.event.service.dto.Speaker;
import com.epam.jmp.event.service.impl.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class SpeakerServiceImpl implements SpeakerService {

    @Autowired
    private SpeakerRepository speakerMongoRepository;

    /**
     * Get all registered Speakers
     *
     * @return {@link List<Speaker>}
     */
    public List<Speaker> getAllSpeakers() {
        return (List<Speaker>) speakerMongoRepository.findAll();
    }

    /**
     * Get Speaker
     *
     * @param id {@link BigInteger} id
     * @return existing {@link Speaker} object or <i>null</i> if {@link Speaker} with specified id was not found
     */
    public Speaker getSpeaker(BigInteger id) {
        Optional<Speaker> event = speakerMongoRepository.findById(id);
        return event.orElse(null);
    }

    /**
     * Delete Speaker
     *
     * @param id {@link BigInteger} id
     * @return existing {@link Speaker} object or <i>null</i> if {@link Speaker} with specified id was not found
     */
    public Speaker deleteSpeaker(BigInteger id) {
        Optional<Speaker> existingSpeaker = speakerMongoRepository.findById(id);
        Speaker result = null;
        if (existingSpeaker.isPresent()) {
            result = existingSpeaker.get();
            speakerMongoRepository.deleteById(id);
        }
        return result;
    }

    /**
     * Delete all Speakers
     */
    public void deleteAllSpeakers() {
        speakerMongoRepository.deleteAll();
    }

    /**
     * Create Speaker
     *
     * @param event {@link Speaker}
     * @return created {@link Speaker} object
     */
    public Speaker createSpeaker(Speaker event) {
        return speakerMongoRepository.save(event);
    }

    /**
     * Update Speaker
     *
     * @param id    {@link Speaker} id
     * @param event {@link Speaker}
     * @return updated {@link Speaker} object or <i>null</i> if {@link Speaker} with specified id was not found
     */
    public Speaker updateSpeaker(BigInteger id, Speaker event) {
        Optional<Speaker> existingSpeaker = speakerMongoRepository.findById(id);
        Speaker result = null;
        if (existingSpeaker.isPresent()) {
            event.setId(existingSpeaker.get().getId());
            result = speakerMongoRepository.save(event);
        }
        return result;
    }
}