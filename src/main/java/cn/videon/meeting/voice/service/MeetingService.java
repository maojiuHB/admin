package cn.videon.meeting.voice.service;

import cn.videon.meeting.voice.service.dto.MeetingDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Meeting.
 */
public interface MeetingService {

    /**
     * Save a meeting.
     *
     * @param meetingDTO the entity to save
     * @return the persisted entity
     */
    MeetingDTO save(MeetingDTO meetingDTO);

    /**
     * Get all the meetings.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<MeetingDTO> findAll(Pageable pageable);

    /**
     * Get all the Meeting with eager load of many-to-many relationships.
     *
     * @return the list of entities
     */
    Page<MeetingDTO> findAllWithEagerRelationships(Pageable pageable);
    
    /**
     * Get the "id" meeting.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<MeetingDTO> findOne(Long id);

    /**
     * Delete the "id" meeting.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
