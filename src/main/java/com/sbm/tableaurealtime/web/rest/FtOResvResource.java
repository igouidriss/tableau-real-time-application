package com.sbm.tableaurealtime.web.rest;

import com.sbm.tableaurealtime.repository.FtOResvRepository;
import com.sbm.tableaurealtime.service.FtOResvService;
import com.sbm.tableaurealtime.service.dto.FtOResvDTO;
import com.sbm.tableaurealtime.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.sbm.tableaurealtime.domain.FtOResv}.
 */
@RestController
@RequestMapping("/api")
public class FtOResvResource {

    private final Logger log = LoggerFactory.getLogger(FtOResvResource.class);

    private static final String ENTITY_NAME = "ftOResv";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FtOResvService ftOResvService;

    private final FtOResvRepository ftOResvRepository;

    public FtOResvResource(FtOResvService ftOResvService, FtOResvRepository ftOResvRepository) {
        this.ftOResvService = ftOResvService;
        this.ftOResvRepository = ftOResvRepository;
    }

    /**
     * {@code POST  /ft-o-resvs} : Create a new ftOResv.
     *
     * @param ftOResvDTO the ftOResvDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new ftOResvDTO, or with status {@code 400 (Bad Request)} if the ftOResv has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ft-o-resvs")
    public ResponseEntity<FtOResvDTO> createFtOResv(@RequestBody FtOResvDTO ftOResvDTO) throws URISyntaxException {
        log.debug("REST request to save FtOResv : {}", ftOResvDTO);
        if (ftOResvDTO.getId() != null) {
            throw new BadRequestAlertException("A new ftOResv cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FtOResvDTO result = ftOResvService.save(ftOResvDTO);
        return ResponseEntity
            .created(new URI("/api/ft-o-resvs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /ft-o-resvs/:id} : Updates an existing ftOResv.
     *
     * @param id the id of the ftOResvDTO to save.
     * @param ftOResvDTO the ftOResvDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated ftOResvDTO,
     * or with status {@code 400 (Bad Request)} if the ftOResvDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the ftOResvDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ft-o-resvs/{id}")
    public ResponseEntity<FtOResvDTO> updateFtOResv(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody FtOResvDTO ftOResvDTO
    ) throws URISyntaxException {
        log.debug("REST request to update FtOResv : {}, {}", id, ftOResvDTO);
        if (ftOResvDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, ftOResvDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!ftOResvRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        FtOResvDTO result = ftOResvService.update(ftOResvDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, ftOResvDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /ft-o-resvs/:id} : Partial updates given fields of an existing ftOResv, field will ignore if it is null
     *
     * @param id the id of the ftOResvDTO to save.
     * @param ftOResvDTO the ftOResvDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated ftOResvDTO,
     * or with status {@code 400 (Bad Request)} if the ftOResvDTO is not valid,
     * or with status {@code 404 (Not Found)} if the ftOResvDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the ftOResvDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/ft-o-resvs/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<FtOResvDTO> partialUpdateFtOResv(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody FtOResvDTO ftOResvDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update FtOResv partially : {}, {}", id, ftOResvDTO);
        if (ftOResvDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, ftOResvDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!ftOResvRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<FtOResvDTO> result = ftOResvService.partialUpdate(ftOResvDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, ftOResvDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /ft-o-resvs} : get all the ftOResvs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of ftOResvs in body.
     */
    @GetMapping("/ft-o-resvs")
    public ResponseEntity<List<FtOResvDTO>> getAllFtOResvs(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        log.debug("REST request to get a page of FtOResvs");
        Page<FtOResvDTO> page = ftOResvService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ft-o-resvs/:id} : get the "id" ftOResv.
     *
     * @param id the id of the ftOResvDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the ftOResvDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ft-o-resvs/{id}")
    public ResponseEntity<FtOResvDTO> getFtOResv(@PathVariable Long id) {
        log.debug("REST request to get FtOResv : {}", id);
        Optional<FtOResvDTO> ftOResvDTO = ftOResvService.findOne(id);
        return ResponseUtil.wrapOrNotFound(ftOResvDTO);
    }

    /**
     * {@code DELETE  /ft-o-resvs/:id} : delete the "id" ftOResv.
     *
     * @param id the id of the ftOResvDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ft-o-resvs/{id}")
    public ResponseEntity<Void> deleteFtOResv(@PathVariable Long id) {
        log.debug("REST request to delete FtOResv : {}", id);
        ftOResvService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
