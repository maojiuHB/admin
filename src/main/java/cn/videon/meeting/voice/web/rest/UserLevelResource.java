package cn.videon.meeting.voice.web.rest;

import com.codahale.metrics.annotation.Timed;
import cn.videon.meeting.voice.service.UserLevelService;
import cn.videon.meeting.voice.web.rest.errors.BadRequestAlertException;
import cn.videon.meeting.voice.web.rest.util.HeaderUtil;
import cn.videon.meeting.voice.web.rest.util.PaginationUtil;
import cn.videon.meeting.voice.service.dto.UserLevelDTO;
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
 * REST controller for managing UserLevel.
 */
@RestController
@RequestMapping("/api")
public class UserLevelResource {

    private final Logger log = LoggerFactory.getLogger(UserLevelResource.class);

    private static final String ENTITY_NAME = "userLevel";

    private UserLevelService userLevelService;

    public UserLevelResource(UserLevelService userLevelService) {
        this.userLevelService = userLevelService;
    }

    /**
     * POST  /user-levels : Create a new userLevel.
     *
     * @param userLevelDTO the userLevelDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new userLevelDTO, or with status 400 (Bad Request) if the userLevel has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/user-levels")
    @Timed
    public ResponseEntity<UserLevelDTO> createUserLevel(@RequestBody UserLevelDTO userLevelDTO) throws URISyntaxException {
        log.debug("REST request to save UserLevel : {}", userLevelDTO);
        if (userLevelDTO.getId() != null) {
            throw new BadRequestAlertException("A new userLevel cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UserLevelDTO result = userLevelService.save(userLevelDTO);
        return ResponseEntity.created(new URI("/api/user-levels/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /user-levels : Updates an existing userLevel.
     *
     * @param userLevelDTO the userLevelDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated userLevelDTO,
     * or with status 400 (Bad Request) if the userLevelDTO is not valid,
     * or with status 500 (Internal Server Error) if the userLevelDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/user-levels")
    @Timed
    public ResponseEntity<UserLevelDTO> updateUserLevel(@RequestBody UserLevelDTO userLevelDTO) throws URISyntaxException {
        log.debug("REST request to update UserLevel : {}", userLevelDTO);
        if (userLevelDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        UserLevelDTO result = userLevelService.save(userLevelDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, userLevelDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /user-levels : get all the userLevels.
     *
     * @param pageable the pagination information
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many)
     * @return the ResponseEntity with status 200 (OK) and the list of userLevels in body
     */
    @GetMapping("/user-levels")
    @Timed
    public ResponseEntity<List<UserLevelDTO>> getAllUserLevels(Pageable pageable, @RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get a page of UserLevels");
        Page<UserLevelDTO> page;
        if (eagerload) {
            page = userLevelService.findAllWithEagerRelationships(pageable);
        } else {
            page = userLevelService.findAll(pageable);
        }
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, String.format("/api/user-levels?eagerload=%b", eagerload));
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /user-levels/:id : get the "id" userLevel.
     *
     * @param id the id of the userLevelDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the userLevelDTO, or with status 404 (Not Found)
     */
    @GetMapping("/user-levels/{id}")
    @Timed
    public ResponseEntity<UserLevelDTO> getUserLevel(@PathVariable Long id) {
        log.debug("REST request to get UserLevel : {}", id);
        Optional<UserLevelDTO> userLevelDTO = userLevelService.findOne(id);
        return ResponseUtil.wrapOrNotFound(userLevelDTO);
    }

    /**
     * DELETE  /user-levels/:id : delete the "id" userLevel.
     *
     * @param id the id of the userLevelDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/user-levels/{id}")
    @Timed
    public ResponseEntity<Void> deleteUserLevel(@PathVariable Long id) {
        log.debug("REST request to delete UserLevel : {}", id);
        userLevelService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
