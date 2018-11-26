package cn.videon.meeting.voice.service.impl;

import cn.videon.meeting.voice.service.MeetingRoomService;
import cn.videon.meeting.voice.domain.MeetingRoom;
import cn.videon.meeting.voice.repository.MeetingRoomRepository;
import cn.videon.meeting.voice.service.dto.MeetingRoomDTO;
import cn.videon.meeting.voice.service.mapper.MeetingRoomMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing MeetingRoom.
 */
@Service
@Transactional
public class MeetingRoomServiceImpl implements MeetingRoomService {

    private final Logger log = LoggerFactory.getLogger(MeetingRoomServiceImpl.class);

    private MeetingRoomRepository meetingRoomRepository;

    private MeetingRoomMapper meetingRoomMapper;

    public MeetingRoomServiceImpl(MeetingRoomRepository meetingRoomRepository, MeetingRoomMapper meetingRoomMapper) {
        this.meetingRoomRepository = meetingRoomRepository;
        this.meetingRoomMapper = meetingRoomMapper;
    }

    /**
     * Save a meetingRoom.
     *
     * @param meetingRoomDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public MeetingRoomDTO save(MeetingRoomDTO meetingRoomDTO) {
        log.debug("Request to save MeetingRoom : {}", meetingRoomDTO);

        MeetingRoom meetingRoom = meetingRoomMapper.toEntity(meetingRoomDTO);
        meetingRoom = meetingRoomRepository.save(meetingRoom);
        return meetingRoomMapper.toDto(meetingRoom);
    }

    /**
     * Get all the meetingRooms.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<MeetingRoomDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MeetingRooms");
        return meetingRoomRepository.findAll(pageable)
            .map(meetingRoomMapper::toDto);
    }

    /**
     * Get all the MeetingRoom with eager load of many-to-many relationships.
     *
     * @return the list of entities
     */
    public Page<MeetingRoomDTO> findAllWithEagerRelationships(Pageable pageable) {
        return meetingRoomRepository.findAllWithEagerRelationships(pageable).map(meetingRoomMapper::toDto);
    }
    

    /**
     * Get one meetingRoom by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<MeetingRoomDTO> findOne(Long id) {
        log.debug("Request to get MeetingRoom : {}", id);
        return meetingRoomRepository.findOneWithEagerRelationships(id)
            .map(meetingRoomMapper::toDto);
    }

    /**
     * Delete the meetingRoom by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete MeetingRoom : {}", id);
        meetingRoomRepository.deleteById(id);
    }
}
