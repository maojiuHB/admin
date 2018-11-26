package cn.videon.meeting.voice.web.rest;

import com.codahale.metrics.annotation.Timed;
import cn.videon.meeting.voice.service.ModificationService;
import cn.videon.meeting.voice.web.rest.errors.BadRequestAlertException;
import cn.videon.meeting.voice.web.rest.util.HeaderUtil;
import cn.videon.meeting.voice.web.rest.util.PaginationUtil;
import cn.videon.meeting.voice.service.dto.ModificationDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Modification.
 */
@RestController
@RequestMapping("/api")
public class ModificationResource {

    private final Logger log = LoggerFactory.getLogger(ModificationResource.class);

    private static final String ENTITY_NAME = "modification";

    private ModificationService modificationService;

    public ModificationResource(ModificationService modificationService) {
        this.modificationService = modificationService;
    }

    /**
     * POST  /modifications : Create a new modification.
     *
     * @param modificationDTO the modificationDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new modificationDTO, or with status 400 (Bad Request) if the modification has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/modifications")
    @Timed
    public ResponseEntity<ModificationDTO> createModification(@RequestBody ModificationDTO modificationDTO) throws URISyntaxException {
        log.debug("REST request to save Modification : {}", modificationDTO);
        if (modificationDTO.getId() != null) {
            throw new BadRequestAlertException("A new modification cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ModificationDTO result = modificationService.save(modificationDTO);
        return ResponseEntity.created(new URI("/api/modifications/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /modifications : Updates an existing modification.
     *
     * @param modificationDTO the modificationDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated modificationDTO,
     * or with status 400 (Bad Request) if the modificationDTO is not valid,
     * or with status 500 (Internal Server Error) if the modificationDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/modifications")
    @Timed
    public ResponseEntity<ModificationDTO> updateModification(@RequestBody ModificationDTO modificationDTO) throws URISyntaxException {
        log.debug("REST request to update Modification : {}", modificationDTO);
        if (modificationDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ModificationDTO result = modificationService.save(modificationDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, modificationDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /modifications : get all the modifications.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of modifications in body
     */
    @GetMapping("/modifications")
    @Timed
    public ResponseEntity<List<ModificationDTO>> getAllModifications(Pageable pageable) {
        log.debug("REST request to get a page of Modifications");
        Page<ModificationDTO> page = modificationService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/modifications");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /modifications/:id : get the "id" modification.
     *
     * @param id the id of the modificationDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the modificationDTO, or with status 404 (Not Found)
     */
    @GetMapping("/modifications/{id}")
    @Timed
    public ResponseEntity<ModificationDTO> getModification(@PathVariable Long id) {
        log.debug("REST request to get Modification : {}", id);
        Optional<ModificationDTO> modificationDTO = modificationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(modificationDTO);
    }

    /**
     * DELETE  /modifications/:id : delete the "id" modification.
     *
     * @param id the id of the modificationDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/modifications/{id}")
    @Timed
    public ResponseEntity<Void> deleteModification(@PathVariable Long id) {
        log.debug("REST request to delete Modification : {}", id);
        modificationService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
