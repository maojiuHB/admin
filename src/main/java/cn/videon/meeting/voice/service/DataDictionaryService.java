package cn.videon.meeting.voice.service;

import cn.videon.meeting.voice.service.dto.DataDictionaryDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing DataDictionary.
 */
public interface DataDictionaryService {

    /**
     * Save a dataDictionary.
     *
     * @param dataDictionaryDTO the entity to save
     * @return the persisted entity
     */
    DataDictionaryDTO save(DataDictionaryDTO dataDictionaryDTO);

    /**
     * Get all the dataDictionaries.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<DataDictionaryDTO> findAll(Pageable pageable);


    /**
     * Get the "id" dataDictionary.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<DataDictionaryDTO> findOne(Long id);

    /**
     * Delete the "id" dataDictionary.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
