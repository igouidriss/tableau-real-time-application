package com.sbm.tableaurealtime.web.rest;

import com.sbm.tableaurealtime.repository.DmOResvRepository;
import com.sbm.tableaurealtime.service.DmOResvService;
import com.sbm.tableaurealtime.service.dto.DmOResvDTO;
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
 * REST controller for managing {@link com.sbm.tableaurealtime.domain.DmOResv}.
 */
@RestController
@RequestMapping("/api")
public class DmOResvResource {

    private final Logger log = LoggerFactory.getLogger(DmOResvResource.class);

    private static final String ENTITY_NAME = "dmOResv";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DmOResvService dmOResvService;

    private final DmOResvRepository dmOResvRepository;

    public DmOResvResource(DmOResvService dmOResvService, DmOResvRepository dmOResvRepository) {
        this.dmOResvService = dmOResvService;
        this.dmOResvRepository = dmOResvRepository;
    }

    /**
     * {@code POST  /dm-o-resvs} : Create a new dmOResv.
     *
     * @param dmOResvDTO the dmOResvDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new dmOResvDTO, or with status {@code 400 (Bad Request)} if the dmOResv has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/dm-o-resvs")
    public ResponseEntity<DmOResvDTO> createDmOResv(@RequestBody DmOResvDTO dmOResvDTO) throws URISyntaxException {
        log.debug("REST request to save DmOResv : {}", dmOResvDTO);
        if (dmOResvDTO.getId() != null) {
            throw new BadRequestAlertException("A new dmOResv cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DmOResvDTO result = dmOResvService.save(dmOResvDTO);
        return ResponseEntity
            .created(new URI("/api/dm-o-resvs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /dm-o-resvs/:id} : Updates an existing dmOResv.
     *
     * @param id the id of the dmOResvDTO to save.
     * @param dmOResvDTO the dmOResvDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dmOResvDTO,
     * or with status {@code 400 (Bad Request)} if the dmOResvDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the dmOResvDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/dm-o-resvs/{id}")
    public ResponseEntity<DmOResvDTO> updateDmOResv(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody DmOResvDTO dmOResvDTO
    ) throws URISyntaxException {
        log.debug("REST request to update DmOResv : {}, {}", id, dmOResvDTO);
        if (dmOResvDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, dmOResvDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!dmOResvRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        DmOResvDTO result = dmOResvService.update(dmOResvDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, dmOResvDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /dm-o-resvs/:id} : Partial updates given fields of an existing dmOResv, field will ignore if it is null
     *
     * @param id the id of the dmOResvDTO to save.
     * @param dmOResvDTO the dmOResvDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dmOResvDTO,
     * or with status {@code 400 (Bad Request)} if the dmOResvDTO is not valid,
     * or with status {@code 404 (Not Found)} if the dmOResvDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the dmOResvDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/dm-o-resvs/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<DmOResvDTO> partialUpdateDmOResv(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody DmOResvDTO dmOResvDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update DmOResv partially : {}, {}", id, dmOResvDTO);
        if (dmOResvDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, dmOResvDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!dmOResvRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<DmOResvDTO> result = dmOResvService.partialUpdate(dmOResvDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, dmOResvDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /dm-o-resvs} : get all the dmOResvs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dmOResvs in body.
     */
    @GetMapping("/dm-o-resvs")
    public ResponseEntity<List<DmOResvDTO>> getAllDmOResvs(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        log.debug("REST request to get a page of DmOResvs");
        Page<DmOResvDTO> page = dmOResvService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /dm-o-resvs/:id} : get the "id" dmOResv.
     *
     * @param id the id of the dmOResvDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dmOResvDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/dm-o-resvs/{id}")
    public ResponseEntity<DmOResvDTO> getDmOResv(@PathVariable Long id) {
        log.debug("REST request to get DmOResv : {}", id);
        Optional<DmOResvDTO> dmOResvDTO = dmOResvService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dmOResvDTO);
    }

    /**
     * {@code DELETE  /dm-o-resvs/:id} : delete the "id" dmOResv.
     *
     * @param id the id of the dmOResvDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/dm-o-resvs/{id}")
    public ResponseEntity<Void> deleteDmOResv(@PathVariable Long id) {
        log.debug("REST request to delete DmOResv : {}", id);
        dmOResvService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
