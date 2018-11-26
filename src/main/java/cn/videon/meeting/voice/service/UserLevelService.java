package cn.videon.meeting.voice.service;

import cn.videon.meeting.voice.service.dto.UserLevelDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing UserLevel.
 */
public interface UserLevelService {

    /**
     * Save a userLevel.
     *
     * @param userLevelDTO the entity to save
     * @return the persisted entity
     */
    UserLevelDTO save(UserLevelDTO userLevelDTO);

    /**
     * Get all the userLevels.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<UserLevelDTO> findAll(Pageable pageable);

    /**
     * Get all the UserLevel with eager load of many-to-many relationships.
     *
     * @return the list of entities
     */
    Page<UserLevelDTO> findAllWithEagerRelationships(Pageable pageable);
    
    /**
     * Get the "id" userLevel.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<UserLevelDTO> findOne(Long id);

    /**
     * Delete the "id" userLevel.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
