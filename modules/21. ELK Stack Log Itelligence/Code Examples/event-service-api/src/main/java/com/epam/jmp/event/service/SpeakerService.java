package com.epam.jmp.event.service;

import com.epam.jmp.event.service.dto.Speaker;

import java.math.BigInteger;
import java.util.List;

public interface SpeakerService {

    /**
     * Find all registered Speakers
     *
     * @return {@link List<Speaker>}
     */
    List<Speaker> getAllSpeakers();

    /**
     * Get Speaker
     *
     * @param id {@link Speaker} id
     * @return existing {@link Speaker} object or <i>null</i> if {@link Speaker} with specified id was not found
     */
    Speaker getSpeaker(BigInteger id);

    /**
     * Delete Speaker
     *
     * @param id {@link Speaker} id
     * @return existing {@link Speaker} object or <i>null</i> if {@link Speaker} with specified id was not found
     */
    Speaker deleteSpeaker(BigInteger id);

    /**
     * Delete all Speakers
     */
    void deleteAllSpeakers();

    /**
     * Create Speaker
     *
     * @param speaker {@link Speaker}
     * @return {@link Speaker} object
     */
    Speaker createSpeaker(Speaker speaker);

    /**
     * Update Speaker
     *
     * @param id      {@link Speaker} id
     * @param speaker {@link Speaker}
     * @return existing {@link Speaker} object or <i>null</i> if {@link Speaker} with specified id was not found
     */
    Speaker updateSpeaker(BigInteger id, Speaker speaker);

}