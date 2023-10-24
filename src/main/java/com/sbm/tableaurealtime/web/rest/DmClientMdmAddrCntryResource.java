package com.sbm.tableaurealtime.web.rest;

import com.sbm.tableaurealtime.repository.DmClientMdmAddrCntryRepository;
import com.sbm.tableaurealtime.service.DmClientMdmAddrCntryService;
import com.sbm.tableaurealtime.service.dto.DmClientMdmAddrCntryDTO;
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
 * REST controller for managing {@link com.sbm.tableaurealtime.domain.DmClientMdmAddrCntry}.
 */
@RestController
@RequestMapping("/api")
public class DmClientMdmAddrCntryResource {

    private final Logger log = LoggerFactory.getLogger(DmClientMdmAddrCntryResource.class);

    private static final String ENTITY_NAME = "dmClientMdmAddrCntry";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DmClientMdmAddrCntryService dmClientMdmAddrCntryService;

    private final DmClientMdmAddrCntryRepository dmClientMdmAddrCntryRepository;

    public DmClientMdmAddrCntryResource(
        DmClientMdmAddrCntryService dmClientMdmAddrCntryService,
        DmClientMdmAddrCntryRepository dmClientMdmAddrCntryRepository
    ) {
        this.dmClientMdmAddrCntryService = dmClientMdmAddrCntryService;
        this.dmClientMdmAddrCntryRepository = dmClientMdmAddrCntryRepository;
    }

    /**
     * {@code POST  /dm-client-mdm-addr-cntries} : Create a new dmClientMdmAddrCntry.
     *
     * @param dmClientMdmAddrCntryDTO the dmClientMdmAddrCntryDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new dmClientMdmAddrCntryDTO, or with status {@code 400 (Bad Request)} if the dmClientMdmAddrCntry has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/dm-client-mdm-addr-cntries")
    public ResponseEntity<DmClientMdmAddrCntryDTO> createDmClientMdmAddrCntry(
        @Valid @RequestBody DmClientMdmAddrCntryDTO dmClientMdmAddrCntryDTO
    ) throws URISyntaxException {
        log.debug("REST request to save DmClientMdmAddrCntry : {}", dmClientMdmAddrCntryDTO);
        if (dmClientMdmAddrCntryDTO.getId() != null) {
            throw new BadRequestAlertException("A new dmClientMdmAddrCntry cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DmClientMdmAddrCntryDTO result = dmClientMdmAddrCntryService.save(dmClientMdmAddrCntryDTO);
        return ResponseEntity
            .created(new URI("/api/dm-client-mdm-addr-cntries/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /dm-client-mdm-addr-cntries/:id} : Updates an existing dmClientMdmAddrCntry.
     *
     * @param id the id of the dmClientMdmAddrCntryDTO to save.
     * @param dmClientMdmAddrCntryDTO the dmClientMdmAddrCntryDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dmClientMdmAddrCntryDTO,
     * or with status {@code 400 (Bad Request)} if the dmClientMdmAddrCntryDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the dmClientMdmAddrCntryDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/dm-client-mdm-addr-cntries/{id}")
    public ResponseEntity<DmClientMdmAddrCntryDTO> updateDmClientMdmAddrCntry(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody DmClientMdmAddrCntryDTO dmClientMdmAddrCntryDTO
    ) throws URISyntaxException {
        log.debug("REST request to update DmClientMdmAddrCntry : {}, {}", id, dmClientMdmAddrCntryDTO);
        if (dmClientMdmAddrCntryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, dmClientMdmAddrCntryDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!dmClientMdmAddrCntryRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        DmClientMdmAddrCntryDTO result = dmClientMdmAddrCntryService.update(dmClientMdmAddrCntryDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, dmClientMdmAddrCntryDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /dm-client-mdm-addr-cntries/:id} : Partial updates given fields of an existing dmClientMdmAddrCntry, field will ignore if it is null
     *
     * @param id the id of the dmClientMdmAddrCntryDTO to save.
     * @param dmClientMdmAddrCntryDTO the dmClientMdmAddrCntryDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dmClientMdmAddrCntryDTO,
     * or with status {@code 400 (Bad Request)} if the dmClientMdmAddrCntryDTO is not valid,
     * or with status {@code 404 (Not Found)} if the dmClientMdmAddrCntryDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the dmClientMdmAddrCntryDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/dm-client-mdm-addr-cntries/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<DmClientMdmAddrCntryDTO> partialUpdateDmClientMdmAddrCntry(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody DmClientMdmAddrCntryDTO dmClientMdmAddrCntryDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update DmClientMdmAddrCntry partially : {}, {}", id, dmClientMdmAddrCntryDTO);
        if (dmClientMdmAddrCntryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, dmClientMdmAddrCntryDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!dmClientMdmAddrCntryRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<DmClientMdmAddrCntryDTO> result = dmClientMdmAddrCntryService.partialUpdate(dmClientMdmAddrCntryDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, dmClientMdmAddrCntryDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /dm-client-mdm-addr-cntries} : get all the dmClientMdmAddrCntries.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dmClientMdmAddrCntries in body.
     */
    @GetMapping("/dm-client-mdm-addr-cntries")
    public ResponseEntity<List<DmClientMdmAddrCntryDTO>> getAllDmClientMdmAddrCntries(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get a page of DmClientMdmAddrCntries");
        Page<DmClientMdmAddrCntryDTO> page = dmClientMdmAddrCntryService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /dm-client-mdm-addr-cntries/:id} : get the "id" dmClientMdmAddrCntry.
     *
     * @param id the id of the dmClientMdmAddrCntryDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dmClientMdmAddrCntryDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/dm-client-mdm-addr-cntries/{id}")
    public ResponseEntity<DmClientMdmAddrCntryDTO> getDmClientMdmAddrCntry(@PathVariable Long id) {
        log.debug("REST request to get DmClientMdmAddrCntry : {}", id);
        Optional<DmClientMdmAddrCntryDTO> dmClientMdmAddrCntryDTO = dmClientMdmAddrCntryService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dmClientMdmAddrCntryDTO);
    }

    /**
     * {@code DELETE  /dm-client-mdm-addr-cntries/:id} : delete the "id" dmClientMdmAddrCntry.
     *
     * @param id the id of the dmClientMdmAddrCntryDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/dm-client-mdm-addr-cntries/{id}")
    public ResponseEntity<Void> deleteDmClientMdmAddrCntry(@PathVariable Long id) {
        log.debug("REST request to delete DmClientMdmAddrCntry : {}", id);
        dmClientMdmAddrCntryService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
