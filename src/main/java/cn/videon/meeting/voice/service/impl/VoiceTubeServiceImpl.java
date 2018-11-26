package cn.videon.meeting.voice.service.impl;

import cn.videon.meeting.voice.service.VoiceTubeService;
import cn.videon.meeting.voice.domain.VoiceTube;
import cn.videon.meeting.voice.repository.VoiceTubeRepository;
import cn.videon.meeting.voice.service.dto.VoiceTubeDTO;
import cn.videon.meeting.voice.service.mapper.VoiceTubeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing VoiceTube.
 */
@Service
@Transactional
public class VoiceTubeServiceImpl implements VoiceTubeService {

    private final Logger log = LoggerFactory.getLogger(VoiceTubeServiceImpl.class);

    private VoiceTubeRepository voiceTubeRepository;

    private VoiceTubeMapper voiceTubeMapper;

    public VoiceTubeServiceImpl(VoiceTubeRepository voiceTubeRepository, VoiceTubeMapper voiceTubeMapper) {
        this.voiceTubeRepository = voiceTubeRepository;
        this.voiceTubeMapper = voiceTubeMapper;
    }

    /**
     * Save a voiceTube.
     *
     * @param voiceTubeDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public VoiceTubeDTO save(VoiceTubeDTO voiceTubeDTO) {
        log.debug("Request to save VoiceTube : {}", voiceTubeDTO);

        VoiceTube voiceTube = voiceTubeMapper.toEntity(voiceTubeDTO);
        voiceTube = voiceTubeRepository.save(voiceTube);
        return voiceTubeMapper.toDto(voiceTube);
    }

    /**
     * Get all the voiceTubes.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<VoiceTubeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all VoiceTubes");
        return voiceTubeRepository.findAll(pageable)
            .map(voiceTubeMapper::toDto);
    }


    /**
     * Get one voiceTube by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<VoiceTubeDTO> findOne(Long id) {
        log.debug("Request to get VoiceTube : {}", id);
        return voiceTubeRepository.findById(id)
            .map(voiceTubeMapper::toDto);
    }

    /**
     * Delete the voiceTube by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete VoiceTube : {}", id);
        voiceTubeRepository.deleteById(id);
    }
}
