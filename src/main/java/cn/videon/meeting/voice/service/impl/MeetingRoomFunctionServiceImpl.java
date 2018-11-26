package cn.videon.meeting.voice.service.impl;

import cn.videon.meeting.voice.service.MeetingRoomFunctionService;
import cn.videon.meeting.voice.domain.MeetingRoomFunction;
import cn.videon.meeting.voice.repository.MeetingRoomFunctionRepository;
import cn.videon.meeting.voice.service.dto.MeetingRoomFunctionDTO;
import cn.videon.meeting.voice.service.mapper.MeetingRoomFunctionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing MeetingRoomFunction.
 */
@Service
@Transactional
public class MeetingRoomFunctionServiceImpl implements MeetingRoomFunctionService {

    private final Logger log = LoggerFactory.getLogger(MeetingRoomFunctionServiceImpl.class);

    private MeetingRoomFunctionRepository meetingRoomFunctionRepository;

    private MeetingRoomFunctionMapper meetingRoomFunctionMapper;

    public MeetingRoomFunctionServiceImpl(MeetingRoomFunctionRepository meetingRoomFunctionRepository, MeetingRoomFunctionMapper meetingRoomFunctionMapper) {
        this.meetingRoomFunctionRepository = meetingRoomFunctionRepository;
        this.meetingRoomFunctionMapper = meetingRoomFunctionMapper;
    }

    /**
     * Save a meetingRoomFunction.
     *
     * @param meetingRoomFunctionDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public MeetingRoomFunctionDTO save(MeetingRoomFunctionDTO meetingRoomFunctionDTO) {
        log.debug("Request to save MeetingRoomFunction : {}", meetingRoomFunctionDTO);

        MeetingRoomFunction meetingRoomFunction = meetingRoomFunctionMapper.toEntity(meetingRoomFunctionDTO);
        meetingRoomFunction = meetingRoomFunctionRepository.save(meetingRoomFunction);
        return meetingRoomFunctionMapper.toDto(meetingRoomFunction);
    }

    /**
     * Get all the meetingRoomFunctions.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<MeetingRoomFunctionDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MeetingRoomFunctions");
        return meetingRoomFunctionRepository.findAll(pageable)
            .map(meetingRoomFunctionMapper::toDto);
    }


    /**
     * Get one meetingRoomFunction by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<MeetingRoomFunctionDTO> findOne(Long id) {
        log.debug("Request to get MeetingRoomFunction : {}", id);
        return meetingRoomFunctionRepository.findById(id)
            .map(meetingRoomFunctionMapper::toDto);
    }

    /**
     * Delete the meetingRoomFunction by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete MeetingRoomFunction : {}", id);
        meetingRoomFunctionRepository.deleteById(id);
    }
}
