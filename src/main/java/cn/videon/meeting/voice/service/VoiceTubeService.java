package cn.videon.meeting.voice.service;

import cn.videon.meeting.voice.service.dto.VoiceTubeDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing VoiceTube.
 */
public interface VoiceTubeService {

    /**
     * Save a voiceTube.
     *
     * @param voiceTubeDTO the entity to save
     * @return the persisted entity
     */
    VoiceTubeDTO save(VoiceTubeDTO voiceTubeDTO);

    /**
     * Get all the voiceTubes.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<VoiceTubeDTO> findAll(Pageable pageable);


    /**
     * Get the "id" voiceTube.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<VoiceTubeDTO> findOne(Long id);

    /**
     * Delete the "id" voiceTube.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
