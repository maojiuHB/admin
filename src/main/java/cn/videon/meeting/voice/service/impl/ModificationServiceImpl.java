package cn.videon.meeting.voice.service.impl;

import cn.videon.meeting.voice.service.ModificationService;
import cn.videon.meeting.voice.domain.Modification;
import cn.videon.meeting.voice.repository.ModificationRepository;
import cn.videon.meeting.voice.service.dto.ModificationDTO;
import cn.videon.meeting.voice.service.mapper.ModificationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing Modification.
 */
@Service
@Transactional
public class ModificationServiceImpl implements ModificationService {

    private final Logger log = LoggerFactory.getLogger(ModificationServiceImpl.class);

    private ModificationRepository modificationRepository;

    private ModificationMapper modificationMapper;

    public ModificationServiceImpl(ModificationRepository modificationRepository, ModificationMapper modificationMapper) {
        this.modificationRepository = modificationRepository;
        this.modificationMapper = modificationMapper;
    }

    /**
     * Save a modification.
     *
     * @param modificationDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ModificationDTO save(ModificationDTO modificationDTO) {
        log.debug("Request to save Modification : {}", modificationDTO);

        Modification modification = modificationMapper.toEntity(modificationDTO);
        modification = modificationRepository.save(modification);
        return modificationMapper.toDto(modification);
    }

    /**
     * Get all the modifications.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ModificationDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Modifications");
        return modificationRepository.findAll(pageable)
            .map(modificationMapper::toDto);
    }


    /**
     * Get one modification by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ModificationDTO> findOne(Long id) {
        log.debug("Request to get Modification : {}", id);
        return modificationRepository.findById(id)
            .map(modificationMapper::toDto);
    }

    /**
     * Delete the modification by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Modification : {}", id);
        modificationRepository.deleteById(id);
    }
}
