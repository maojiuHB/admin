package cn.videon.meeting.voice.web.rest;

import com.codahale.metrics.annotation.Timed;
import cn.videon.meeting.voice.service.DataDictionaryService;
import cn.videon.meeting.voice.web.rest.errors.BadRequestAlertException;
import cn.videon.meeting.voice.web.rest.util.HeaderUtil;
import cn.videon.meeting.voice.web.rest.util.PaginationUtil;
import cn.videon.meeting.voice.service.dto.DataDictionaryDTO;
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
 * REST controller for managing DataDictionary.
 */
@RestController
@RequestMapping("/api")
public class DataDictionaryResource {

    private final Logger log = LoggerFactory.getLogger(DataDictionaryResource.class);

    private static final String ENTITY_NAME = "dataDictionary";

    private DataDictionaryService dataDictionaryService;

    public DataDictionaryResource(DataDictionaryService dataDictionaryService) {
        this.dataDictionaryService = dataDictionaryService;
    }

    /**
     * POST  /data-dictionaries : Create a new dataDictionary.
     *
     * @param dataDictionaryDTO the dataDictionaryDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new dataDictionaryDTO, or with status 400 (Bad Request) if the dataDictionary has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/data-dictionaries")
    @Timed
    public ResponseEntity<DataDictionaryDTO> createDataDictionary(@RequestBody DataDictionaryDTO dataDictionaryDTO) throws URISyntaxException {
        log.debug("REST request to save DataDictionary : {}", dataDictionaryDTO);
        if (dataDictionaryDTO.getId() != null) {
            throw new BadRequestAlertException("A new dataDictionary cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DataDictionaryDTO result = dataDictionaryService.save(dataDictionaryDTO);
        return ResponseEntity.created(new URI("/api/data-dictionaries/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /data-dictionaries : Updates an existing dataDictionary.
     *
     * @param dataDictionaryDTO the dataDictionaryDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated dataDictionaryDTO,
     * or with status 400 (Bad Request) if the dataDictionaryDTO is not valid,
     * or with status 500 (Internal Server Error) if the dataDictionaryDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/data-dictionaries")
    @Timed
    public ResponseEntity<DataDictionaryDTO> updateDataDictionary(@RequestBody DataDictionaryDTO dataDictionaryDTO) throws URISyntaxException {
        log.debug("REST request to update DataDictionary : {}", dataDictionaryDTO);
        if (dataDictionaryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DataDictionaryDTO result = dataDictionaryService.save(dataDictionaryDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, dataDictionaryDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /data-dictionaries : get all the dataDictionaries.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of dataDictionaries in body
     */
    @GetMapping("/data-dictionaries")
    @Timed
    public ResponseEntity<List<DataDictionaryDTO>> getAllDataDictionaries(Pageable pageable) {
        log.debug("REST request to get a page of DataDictionaries");
        Page<DataDictionaryDTO> page = dataDictionaryService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/data-dictionaries");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /data-dictionaries/:id : get the "id" dataDictionary.
     *
     * @param id the id of the dataDictionaryDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the dataDictionaryDTO, or with status 404 (Not Found)
     */
    @GetMapping("/data-dictionaries/{id}")
    @Timed
    public ResponseEntity<DataDictionaryDTO> getDataDictionary(@PathVariable Long id) {
        log.debug("REST request to get DataDictionary : {}", id);
        Optional<DataDictionaryDTO> dataDictionaryDTO = dataDictionaryService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dataDictionaryDTO);
    }

    /**
     * DELETE  /data-dictionaries/:id : delete the "id" dataDictionary.
     *
     * @param id the id of the dataDictionaryDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/data-dictionaries/{id}")
    @Timed
    public ResponseEntity<Void> deleteDataDictionary(@PathVariable Long id) {
        log.debug("REST request to delete DataDictionary : {}", id);
        dataDictionaryService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
