package cn.videon.meeting.voice.service.impl;

import cn.videon.meeting.voice.service.MeetingService;
import cn.videon.meeting.voice.domain.Meeting;
import cn.videon.meeting.voice.repository.MeetingRepository;
import cn.videon.meeting.voice.service.dto.MeetingDTO;
import cn.videon.meeting.voice.service.mapper.MeetingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing Meeting.
 */
@Service
@Transactional
public class MeetingServiceImpl implements MeetingService {

    private final Logger log = LoggerFactory.getLogger(MeetingServiceImpl.class);

    private MeetingRepository meetingRepository;

    private MeetingMapper meetingMapper;

    public MeetingServiceImpl(MeetingRepository meetingRepository, MeetingMapper meetingMapper) {
        this.meetingRepository = meetingRepository;
        this.meetingMapper = meetingMapper;
    }

    /**
     * Save a meeting.
     *
     * @param meetingDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public MeetingDTO save(MeetingDTO meetingDTO) {
        log.debug("Request to save Meeting : {}", meetingDTO);

        Meeting meeting = meetingMapper.toEntity(meetingDTO);
        meeting = meetingRepository.save(meeting);
        return meetingMapper.toDto(meeting);
    }

    /**
     * Get all the meetings.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<MeetingDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Meetings");
        return meetingRepository.findAll(pageable)
            .map(meetingMapper::toDto);
    }

    /**
     * Get all the Meeting with eager load of many-to-many relationships.
     *
     * @return the list of entities
     */
    public Page<MeetingDTO> findAllWithEagerRelationships(Pageable pageable) {
        return meetingRepository.findAllWithEagerRelationships(pageable).map(meetingMapper::toDto);
    }
    

    /**
     * Get one meeting by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<MeetingDTO> findOne(Long id) {
        log.debug("Request to get Meeting : {}", id);
        return meetingRepository.findOneWithEagerRelationships(id)
            .map(meetingMapper::toDto);
    }

    /**
     * Delete the meeting by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Meeting : {}", id);
        meetingRepository.deleteById(id);
    }
}
