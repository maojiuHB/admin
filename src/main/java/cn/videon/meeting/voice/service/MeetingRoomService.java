package cn.videon.meeting.voice.service;

import cn.videon.meeting.voice.service.dto.MeetingRoomDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing MeetingRoom.
 */
public interface MeetingRoomService {

    /**
     * Save a meetingRoom.
     *
     * @param meetingRoomDTO the entity to save
     * @return the persisted entity
     */
    MeetingRoomDTO save(MeetingRoomDTO meetingRoomDTO);

    /**
     * Get all the meetingRooms.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<MeetingRoomDTO> findAll(Pageable pageable);

    /**
     * Get all the MeetingRoom with eager load of many-to-many relationships.
     *
     * @return the list of entities
     */
    Page<MeetingRoomDTO> findAllWithEagerRelationships(Pageable pageable);
    
    /**
     * Get the "id" meetingRoom.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<MeetingRoomDTO> findOne(Long id);

    /**
     * Delete the "id" meetingRoom.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
