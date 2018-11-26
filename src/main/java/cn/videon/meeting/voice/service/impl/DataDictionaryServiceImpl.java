package cn.videon.meeting.voice.service.impl;

import cn.videon.meeting.voice.service.DataDictionaryService;
import cn.videon.meeting.voice.domain.DataDictionary;
import cn.videon.meeting.voice.repository.DataDictionaryRepository;
import cn.videon.meeting.voice.service.dto.DataDictionaryDTO;
import cn.videon.meeting.voice.service.mapper.DataDictionaryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing DataDictionary.
 */
@Service
@Transactional
public class DataDictionaryServiceImpl implements DataDictionaryService {

    private final Logger log = LoggerFactory.getLogger(DataDictionaryServiceImpl.class);

    private DataDictionaryRepository dataDictionaryRepository;

    private DataDictionaryMapper dataDictionaryMapper;

    public DataDictionaryServiceImpl(DataDictionaryRepository dataDictionaryRepository, DataDictionaryMapper dataDictionaryMapper) {
        this.dataDictionaryRepository = dataDictionaryRepository;
        this.dataDictionaryMapper = dataDictionaryMapper;
    }

    /**
     * Save a dataDictionary.
     *
     * @param dataDictionaryDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public DataDictionaryDTO save(DataDictionaryDTO dataDictionaryDTO) {
        log.debug("Request to save DataDictionary : {}", dataDictionaryDTO);

        DataDictionary dataDictionary = dataDictionaryMapper.toEntity(dataDictionaryDTO);
        dataDictionary = dataDictionaryRepository.save(dataDictionary);
        return dataDictionaryMapper.toDto(dataDictionary);
    }

    /**
     * Get all the dataDictionaries.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<DataDictionaryDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DataDictionaries");
        return dataDictionaryRepository.findAll(pageable)
            .map(dataDictionaryMapper::toDto);
    }


    /**
     * Get one dataDictionary by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<DataDictionaryDTO> findOne(Long id) {
        log.debug("Request to get DataDictionary : {}", id);
        return dataDictionaryRepository.findById(id)
            .map(dataDictionaryMapper::toDto);
    }

    /**
     * Delete the dataDictionary by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete DataDictionary : {}", id);
        dataDictionaryRepository.deleteById(id);
    }
}
