package cn.videon.meeting.voice.web.rest;

import com.codahale.metrics.annotation.Timed;
import cn.videon.meeting.voice.service.MeetingRoomService;
import cn.videon.meeting.voice.web.rest.errors.BadRequestAlertException;
import cn.videon.meeting.voice.web.rest.util.HeaderUtil;
import cn.videon.meeting.voice.web.rest.util.PaginationUtil;
import cn.videon.meeting.voice.service.dto.MeetingRoomDTO;
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
 * REST controller for managing MeetingRoom.
 */
@RestController
@RequestMapping("/api")
public class MeetingRoomResource {

    private final Logger log = LoggerFactory.getLogger(MeetingRoomResource.class);

    private static final String ENTITY_NAME = "meetingRoom";

    private MeetingRoomService meetingRoomService;

    public MeetingRoomResource(MeetingRoomService meetingRoomService) {
        this.meetingRoomService = meetingRoomService;
    }

    /**
     * POST  /meeting-rooms : Create a new meetingRoom.
     *
     * @param meetingRoomDTO the meetingRoomDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new meetingRoomDTO, or with status 400 (Bad Request) if the meetingRoom has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/meeting-rooms")
    @Timed
    public ResponseEntity<MeetingRoomDTO> createMeetingRoom(@RequestBody MeetingRoomDTO meetingRoomDTO) throws URISyntaxException {
        log.debug("REST request to save MeetingRoom : {}", meetingRoomDTO);
        if (meetingRoomDTO.getId() != null) {
            throw new BadRequestAlertException("A new meetingRoom cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MeetingRoomDTO result = meetingRoomService.save(meetingRoomDTO);
        return ResponseEntity.created(new URI("/api/meeting-rooms/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /meeting-rooms : Updates an existing meetingRoom.
     *
     * @param meetingRoomDTO the meetingRoomDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated meetingRoomDTO,
     * or with status 400 (Bad Request) if the meetingRoomDTO is not valid,
     * or with status 500 (Internal Server Error) if the meetingRoomDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/meeting-rooms")
    @Timed
    public ResponseEntity<MeetingRoomDTO> updateMeetingRoom(@RequestBody MeetingRoomDTO meetingRoomDTO) throws URISyntaxException {
        log.debug("REST request to update MeetingRoom : {}", meetingRoomDTO);
        if (meetingRoomDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MeetingRoomDTO result = meetingRoomService.save(meetingRoomDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, meetingRoomDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /meeting-rooms : get all the meetingRooms.
     *
     * @param pageable the pagination information
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many)
     * @return the ResponseEntity with status 200 (OK) and the list of meetingRooms in body
     */
    @GetMapping("/meeting-rooms")
    @Timed
    public ResponseEntity<List<MeetingRoomDTO>> getAllMeetingRooms(Pageable pageable, @RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get a page of MeetingRooms");
        Page<MeetingRoomDTO> page;
        if (eagerload) {
            page = meetingRoomService.findAllWithEagerRelationships(pageable);
        } else {
            page = meetingRoomService.findAll(pageable);
        }
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, String.format("/api/meeting-rooms?eagerload=%b", eagerload));
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /meeting-rooms/:id : get the "id" meetingRoom.
     *
     * @param id the id of the meetingRoomDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the meetingRoomDTO, or with status 404 (Not Found)
     */
    @GetMapping("/meeting-rooms/{id}")
    @Timed
    public ResponseEntity<MeetingRoomDTO> getMeetingRoom(@PathVariable Long id) {
        log.debug("REST request to get MeetingRoom : {}", id);
        Optional<MeetingRoomDTO> meetingRoomDTO = meetingRoomService.findOne(id);
        return ResponseUtil.wrapOrNotFound(meetingRoomDTO);
    }

    /**
     * DELETE  /meeting-rooms/:id : delete the "id" meetingRoom.
     *
     * @param id the id of the meetingRoomDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/meeting-rooms/{id}")
    @Timed
    public ResponseEntity<Void> deleteMeetingRoom(@PathVariable Long id) {
        log.debug("REST request to delete MeetingRoom : {}", id);
        meetingRoomService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
