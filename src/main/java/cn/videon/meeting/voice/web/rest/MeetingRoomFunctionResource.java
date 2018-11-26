package cn.videon.meeting.voice.web.rest;

import com.codahale.metrics.annotation.Timed;
import cn.videon.meeting.voice.service.MeetingRoomFunctionService;
import cn.videon.meeting.voice.web.rest.errors.BadRequestAlertException;
import cn.videon.meeting.voice.web.rest.util.HeaderUtil;
import cn.videon.meeting.voice.web.rest.util.PaginationUtil;
import cn.videon.meeting.voice.service.dto.MeetingRoomFunctionDTO;
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
 * REST controller for managing MeetingRoomFunction.
 */
@RestController
@RequestMapping("/api")
public class MeetingRoomFunctionResource {

    private final Logger log = LoggerFactory.getLogger(MeetingRoomFunctionResource.class);

    private static final String ENTITY_NAME = "meetingRoomFunction";

    private MeetingRoomFunctionService meetingRoomFunctionService;

    public MeetingRoomFunctionResource(MeetingRoomFunctionService meetingRoomFunctionService) {
        this.meetingRoomFunctionService = meetingRoomFunctionService;
    }

    /**
     * POST  /meeting-room-functions : Create a new meetingRoomFunction.
     *
     * @param meetingRoomFunctionDTO the meetingRoomFunctionDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new meetingRoomFunctionDTO, or with status 400 (Bad Request) if the meetingRoomFunction has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/meeting-room-functions")
    @Timed
    public ResponseEntity<MeetingRoomFunctionDTO> createMeetingRoomFunction(@RequestBody MeetingRoomFunctionDTO meetingRoomFunctionDTO) throws URISyntaxException {
        log.debug("REST request to save MeetingRoomFunction : {}", meetingRoomFunctionDTO);
        if (meetingRoomFunctionDTO.getId() != null) {
            throw new BadRequestAlertException("A new meetingRoomFunction cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MeetingRoomFunctionDTO result = meetingRoomFunctionService.save(meetingRoomFunctionDTO);
        return ResponseEntity.created(new URI("/api/meeting-room-functions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /meeting-room-functions : Updates an existing meetingRoomFunction.
     *
     * @param meetingRoomFunctionDTO the meetingRoomFunctionDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated meetingRoomFunctionDTO,
     * or with status 400 (Bad Request) if the meetingRoomFunctionDTO is not valid,
     * or with status 500 (Internal Server Error) if the meetingRoomFunctionDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/meeting-room-functions")
    @Timed
    public ResponseEntity<MeetingRoomFunctionDTO> updateMeetingRoomFunction(@RequestBody MeetingRoomFunctionDTO meetingRoomFunctionDTO) throws URISyntaxException {
        log.debug("REST request to update MeetingRoomFunction : {}", meetingRoomFunctionDTO);
        if (meetingRoomFunctionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MeetingRoomFunctionDTO result = meetingRoomFunctionService.save(meetingRoomFunctionDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, meetingRoomFunctionDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /meeting-room-functions : get all the meetingRoomFunctions.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of meetingRoomFunctions in body
     */
    @GetMapping("/meeting-room-functions")
    @Timed
    public ResponseEntity<List<MeetingRoomFunctionDTO>> getAllMeetingRoomFunctions(Pageable pageable) {
        log.debug("REST request to get a page of MeetingRoomFunctions");
        Page<MeetingRoomFunctionDTO> page = meetingRoomFunctionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/meeting-room-functions");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /meeting-room-functions/:id : get the "id" meetingRoomFunction.
     *
     * @param id the id of the meetingRoomFunctionDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the meetingRoomFunctionDTO, or with status 404 (Not Found)
     */
    @GetMapping("/meeting-room-functions/{id}")
    @Timed
    public ResponseEntity<MeetingRoomFunctionDTO> getMeetingRoomFunction(@PathVariable Long id) {
        log.debug("REST request to get MeetingRoomFunction : {}", id);
        Optional<MeetingRoomFunctionDTO> meetingRoomFunctionDTO = meetingRoomFunctionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(meetingRoomFunctionDTO);
    }

    /**
     * DELETE  /meeting-room-functions/:id : delete the "id" meetingRoomFunction.
     *
     * @param id the id of the meetingRoomFunctionDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/meeting-room-functions/{id}")
    @Timed
    public ResponseEntity<Void> deleteMeetingRoomFunction(@PathVariable Long id) {
        log.debug("REST request to delete MeetingRoomFunction : {}", id);
        meetingRoomFunctionService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
