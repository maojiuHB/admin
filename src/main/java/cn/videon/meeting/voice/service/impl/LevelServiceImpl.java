package cn.videon.meeting.voice.service.impl;

import cn.videon.meeting.voice.service.LevelService;
import cn.videon.meeting.voice.domain.Level;
import cn.videon.meeting.voice.repository.LevelRepository;
import cn.videon.meeting.voice.service.dto.LevelDTO;
import cn.videon.meeting.voice.service.mapper.LevelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing Level.
 */
@Service
@Transactional
public class LevelServiceImpl implements LevelService {

    private final Logger log = LoggerFactory.getLogger(LevelServiceImpl.class);

    private LevelRepository levelRepository;

    private LevelMapper levelMapper;

    public LevelServiceImpl(LevelRepository levelRepository, LevelMapper levelMapper) {
        this.levelRepository = levelRepository;
        this.levelMapper = levelMapper;
    }

    /**
     * Save a level.
     *
     * @param levelDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public LevelDTO save(LevelDTO levelDTO) {
        log.debug("Request to save Level : {}", levelDTO);

        Level level = levelMapper.toEntity(levelDTO);
        level = levelRepository.save(level);
        return levelMapper.toDto(level);
    }

    /**
     * Get all the levels.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<LevelDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Levels");
        return levelRepository.findAll(pageable)
            .map(levelMapper::toDto);
    }


    /**
     * Get one level by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<LevelDTO> findOne(Long id) {
        log.debug("Request to get Level : {}", id);
        return levelRepository.findById(id)
            .map(levelMapper::toDto);
    }

    /**
     * Delete the level by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Level : {}", id);
        levelRepository.deleteById(id);
    }
}
