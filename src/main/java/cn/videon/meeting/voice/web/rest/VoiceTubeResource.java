package cn.videon.meeting.voice.web.rest;

import com.codahale.metrics.annotation.Timed;
import cn.videon.meeting.voice.service.VoiceTubeService;
import cn.videon.meeting.voice.web.rest.errors.BadRequestAlertException;
import cn.videon.meeting.voice.web.rest.util.HeaderUtil;
import cn.videon.meeting.voice.web.rest.util.PaginationUtil;
import cn.videon.meeting.voice.service.dto.VoiceTubeDTO;
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
 * REST controller for managing VoiceTube.
 */
@RestController
@RequestMapping("/api")
public class VoiceTubeResource {

    private final Logger log = LoggerFactory.getLogger(VoiceTubeResource.class);

    private static final String ENTITY_NAME = "voiceTube";

    private VoiceTubeService voiceTubeService;

    public VoiceTubeResource(VoiceTubeService voiceTubeService) {
        this.voiceTubeService = voiceTubeService;
    }

    /**
     * POST  /voice-tubes : Create a new voiceTube.
     *
     * @param voiceTubeDTO the voiceTubeDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new voiceTubeDTO, or with status 400 (Bad Request) if the voiceTube has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/voice-tubes")
    @Timed
    public ResponseEntity<VoiceTubeDTO> createVoiceTube(@RequestBody VoiceTubeDTO voiceTubeDTO) throws URISyntaxException {
        log.debug("REST request to save VoiceTube : {}", voiceTubeDTO);
        if (voiceTubeDTO.getId() != null) {
            throw new BadRequestAlertException("A new voiceTube cannot already have an ID", ENTITY_NAME, "idexists");
        }
        VoiceTubeDTO result = voiceTubeService.save(voiceTubeDTO);
        return ResponseEntity.created(new URI("/api/voice-tubes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /voice-tubes : Updates an existing voiceTube.
     *
     * @param voiceTubeDTO the voiceTubeDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated voiceTubeDTO,
     * or with status 400 (Bad Request) if the voiceTubeDTO is not valid,
     * or with status 500 (Internal Server Error) if the voiceTubeDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/voice-tubes")
    @Timed
    public ResponseEntity<VoiceTubeDTO> updateVoiceTube(@RequestBody VoiceTubeDTO voiceTubeDTO) throws URISyntaxException {
        log.debug("REST request to update VoiceTube : {}", voiceTubeDTO);
        if (voiceTubeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        VoiceTubeDTO result = voiceTubeService.save(voiceTubeDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, voiceTubeDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /voice-tubes : get all the voiceTubes.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of voiceTubes in body
     */
    @GetMapping("/voice-tubes")
    @Timed
    public ResponseEntity<List<VoiceTubeDTO>> getAllVoiceTubes(Pageable pageable) {
        log.debug("REST request to get a page of VoiceTubes");
        Page<VoiceTubeDTO> page = voiceTubeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/voice-tubes");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /voice-tubes/:id : get the "id" voiceTube.
     *
     * @param id the id of the voiceTubeDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the voiceTubeDTO, or with status 404 (Not Found)
     */
    @GetMapping("/voice-tubes/{id}")
    @Timed
    public ResponseEntity<VoiceTubeDTO> getVoiceTube(@PathVariable Long id) {
        log.debug("REST request to get VoiceTube : {}", id);
        Optional<VoiceTubeDTO> voiceTubeDTO = voiceTubeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(voiceTubeDTO);
    }

    /**
     * DELETE  /voice-tubes/:id : delete the "id" voiceTube.
     *
     * @param id the id of the voiceTubeDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/voice-tubes/{id}")
    @Timed
    public ResponseEntity<Void> deleteVoiceTube(@PathVariable Long id) {
        log.debug("REST request to delete VoiceTube : {}", id);
        voiceTubeService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
