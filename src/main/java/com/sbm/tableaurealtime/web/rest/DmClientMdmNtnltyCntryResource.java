package com.sbm.tableaurealtime.web.rest;

import com.sbm.tableaurealtime.repository.DmClientMdmNtnltyCntryRepository;
import com.sbm.tableaurealtime.service.DmClientMdmNtnltyCntryService;
import com.sbm.tableaurealtime.service.dto.DmClientMdmNtnltyCntryDTO;
import com.sbm.tableaurealtime.web.rest.errors.BadRequestAlertException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
 * REST controller for managing {@link com.sbm.tableaurealtime.domain.DmClientMdmNtnltyCntry}.
 */
@RestController
@RequestMapping("/api")
public class DmClientMdmNtnltyCntryResource {

    private final Logger log = LoggerFactory.getLogger(DmClientMdmNtnltyCntryResource.class);

    private static final String ENTITY_NAME = "dmClientMdmNtnltyCntry";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DmClientMdmNtnltyCntryService dmClientMdmNtnltyCntryService;

    private final DmClientMdmNtnltyCntryRepository dmClientMdmNtnltyCntryRepository;

    public DmClientMdmNtnltyCntryResource(
        DmClientMdmNtnltyCntryService dmClientMdmNtnltyCntryService,
        DmClientMdmNtnltyCntryRepository dmClientMdmNtnltyCntryRepository
    ) {
        this.dmClientMdmNtnltyCntryService = dmClientMdmNtnltyCntryService;
        this.dmClientMdmNtnltyCntryRepository = dmClientMdmNtnltyCntryRepository;
    }

    /**
     * {@code POST  /dm-client-mdm-ntnlty-cntries} : Create a new dmClientMdmNtnltyCntry.
     *
     * @param dmClientMdmNtnltyCntryDTO the dmClientMdmNtnltyCntryDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new dmClientMdmNtnltyCntryDTO, or with status {@code 400 (Bad Request)} if the dmClientMdmNtnltyCntry has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/dm-client-mdm-ntnlty-cntries")
    public ResponseEntity<DmClientMdmNtnltyCntryDTO> createDmClientMdmNtnltyCntry(
        @Valid @RequestBody DmClientMdmNtnltyCntryDTO dmClientMdmNtnltyCntryDTO
    ) throws URISyntaxException {
        log.debug("REST request to save DmClientMdmNtnltyCntry : {}", dmClientMdmNtnltyCntryDTO);
        if (dmClientMdmNtnltyCntryDTO.getId() != null) {
            throw new BadRequestAlertException("A new dmClientMdmNtnltyCntry cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DmClientMdmNtnltyCntryDTO result = dmClientMdmNtnltyCntryService.save(dmClientMdmNtnltyCntryDTO);
        return ResponseEntity
            .created(new URI("/api/dm-client-mdm-ntnlty-cntries/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /dm-client-mdm-ntnlty-cntries/:id} : Updates an existing dmClientMdmNtnltyCntry.
     *
     * @param id the id of the dmClientMdmNtnltyCntryDTO to save.
     * @param dmClientMdmNtnltyCntryDTO the dmClientMdmNtnltyCntryDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dmClientMdmNtnltyCntryDTO,
     * or with status {@code 400 (Bad Request)} if the dmClientMdmNtnltyCntryDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the dmClientMdmNtnltyCntryDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/dm-client-mdm-ntnlty-cntries/{id}")
    public ResponseEntity<DmClientMdmNtnltyCntryDTO> updateDmClientMdmNtnltyCntry(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody DmClientMdmNtnltyCntryDTO dmClientMdmNtnltyCntryDTO
    ) throws URISyntaxException {
        log.debug("REST request to update DmClientMdmNtnltyCntry : {}, {}", id, dmClientMdmNtnltyCntryDTO);
        if (dmClientMdmNtnltyCntryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, dmClientMdmNtnltyCntryDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!dmClientMdmNtnltyCntryRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        DmClientMdmNtnltyCntryDTO result = dmClientMdmNtnltyCntryService.update(dmClientMdmNtnltyCntryDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, dmClientMdmNtnltyCntryDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /dm-client-mdm-ntnlty-cntries/:id} : Partial updates given fields of an existing dmClientMdmNtnltyCntry, field will ignore if it is null
     *
     * @param id the id of the dmClientMdmNtnltyCntryDTO to save.
     * @param dmClientMdmNtnltyCntryDTO the dmClientMdmNtnltyCntryDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dmClientMdmNtnltyCntryDTO,
     * or with status {@code 400 (Bad Request)} if the dmClientMdmNtnltyCntryDTO is not valid,
     * or with status {@code 404 (Not Found)} if the dmClientMdmNtnltyCntryDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the dmClientMdmNtnltyCntryDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/dm-client-mdm-ntnlty-cntries/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<DmClientMdmNtnltyCntryDTO> partialUpdateDmClientMdmNtnltyCntry(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody DmClientMdmNtnltyCntryDTO dmClientMdmNtnltyCntryDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update DmClientMdmNtnltyCntry partially : {}, {}", id, dmClientMdmNtnltyCntryDTO);
        if (dmClientMdmNtnltyCntryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, dmClientMdmNtnltyCntryDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!dmClientMdmNtnltyCntryRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<DmClientMdmNtnltyCntryDTO> result = dmClientMdmNtnltyCntryService.partialUpdate(dmClientMdmNtnltyCntryDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, dmClientMdmNtnltyCntryDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /dm-client-mdm-ntnlty-cntries} : get all the dmClientMdmNtnltyCntries.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dmClientMdmNtnltyCntries in body.
     */
    @GetMapping("/dm-client-mdm-ntnlty-cntries")
    public ResponseEntity<List<DmClientMdmNtnltyCntryDTO>> getAllDmClientMdmNtnltyCntries(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get a page of DmClientMdmNtnltyCntries");
        Page<DmClientMdmNtnltyCntryDTO> page = dmClientMdmNtnltyCntryService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /dm-client-mdm-ntnlty-cntries/:id} : get the "id" dmClientMdmNtnltyCntry.
     *
     * @param id the id of the dmClientMdmNtnltyCntryDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dmClientMdmNtnltyCntryDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/dm-client-mdm-ntnlty-cntries/{id}")
    public ResponseEntity<DmClientMdmNtnltyCntryDTO> getDmClientMdmNtnltyCntry(@PathVariable Long id) {
        log.debug("REST request to get DmClientMdmNtnltyCntry : {}", id);
        Optional<DmClientMdmNtnltyCntryDTO> dmClientMdmNtnltyCntryDTO = dmClientMdmNtnltyCntryService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dmClientMdmNtnltyCntryDTO);
    }

    /**
     * {@code DELETE  /dm-client-mdm-ntnlty-cntries/:id} : delete the "id" dmClientMdmNtnltyCntry.
     *
     * @param id the id of the dmClientMdmNtnltyCntryDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/dm-client-mdm-ntnlty-cntries/{id}")
    public ResponseEntity<Void> deleteDmClientMdmNtnltyCntry(@PathVariable Long id) {
        log.debug("REST request to delete DmClientMdmNtnltyCntry : {}", id);
        dmClientMdmNtnltyCntryService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
