package cn.videon.meeting.voice.service;

import cn.videon.meeting.voice.service.dto.MeetingRoomFunctionDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing MeetingRoomFunction.
 */
public interface MeetingRoomFunctionService {

    /**
     * Save a meetingRoomFunction.
     *
     * @param meetingRoomFunctionDTO the entity to save
     * @return the persisted entity
     */
    MeetingRoomFunctionDTO save(MeetingRoomFunctionDTO meetingRoomFunctionDTO);

    /**
     * Get all the meetingRoomFunctions.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<MeetingRoomFunctionDTO> findAll(Pageable pageable);


    /**
     * Get the "id" meetingRoomFunction.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<MeetingRoomFunctionDTO> findOne(Long id);

    /**
     * Delete the "id" meetingRoomFunction.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
