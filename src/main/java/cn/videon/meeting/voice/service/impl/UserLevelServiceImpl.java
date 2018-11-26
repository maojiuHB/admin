package cn.videon.meeting.voice.service.impl;

import cn.videon.meeting.voice.service.UserLevelService;
import cn.videon.meeting.voice.domain.UserLevel;
import cn.videon.meeting.voice.repository.UserLevelRepository;
import cn.videon.meeting.voice.service.dto.UserLevelDTO;
import cn.videon.meeting.voice.service.mapper.UserLevelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing UserLevel.
 */
@Service
@Transactional
public class UserLevelServiceImpl implements UserLevelService {

    private final Logger log = LoggerFactory.getLogger(UserLevelServiceImpl.class);

    private UserLevelRepository userLevelRepository;

    private UserLevelMapper userLevelMapper;

    public UserLevelServiceImpl(UserLevelRepository userLevelRepository, UserLevelMapper userLevelMapper) {
        this.userLevelRepository = userLevelRepository;
        this.userLevelMapper = userLevelMapper;
    }

    /**
     * Save a userLevel.
     *
     * @param userLevelDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public UserLevelDTO save(UserLevelDTO userLevelDTO) {
        log.debug("Request to save UserLevel : {}", userLevelDTO);

        UserLevel userLevel = userLevelMapper.toEntity(userLevelDTO);
        userLevel = userLevelRepository.save(userLevel);
        return userLevelMapper.toDto(userLevel);
    }

    /**
     * Get all the userLevels.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<UserLevelDTO> findAll(Pageable pageable) {
        log.debug("Request to get all UserLevels");
        return userLevelRepository.findAll(pageable)
            .map(userLevelMapper::toDto);
    }

    /**
     * Get all the UserLevel with eager load of many-to-many relationships.
     *
     * @return the list of entities
     */
    public Page<UserLevelDTO> findAllWithEagerRelationships(Pageable pageable) {
        return userLevelRepository.findAllWithEagerRelationships(pageable).map(userLevelMapper::toDto);
    }
    

    /**
     * Get one userLevel by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<UserLevelDTO> findOne(Long id) {
        log.debug("Request to get UserLevel : {}", id);
        return userLevelRepository.findOneWithEagerRelationships(id)
            .map(userLevelMapper::toDto);
    }

    /**
     * Delete the userLevel by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete UserLevel : {}", id);
        userLevelRepository.deleteById(id);
    }
}
