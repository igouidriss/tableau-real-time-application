package com.sbm.tableaurealtime.service;

import com.sbm.tableaurealtime.service.dto.DmClientMdmNtnltyCntryDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.sbm.tableaurealtime.domain.DmClientMdmNtnltyCntry}.
 */
public interface DmClientMdmNtnltyCntryService {
    /**
     * Save a dmClientMdmNtnltyCntry.
     *
     * @param dmClientMdmNtnltyCntryDTO the entity to save.
     * @return the persisted entity.
     */
    DmClientMdmNtnltyCntryDTO save(DmClientMdmNtnltyCntryDTO dmClientMdmNtnltyCntryDTO);

    /**
     * Updates a dmClientMdmNtnltyCntry.
     *
     * @param dmClientMdmNtnltyCntryDTO the entity to update.
     * @return the persisted entity.
     */
    DmClientMdmNtnltyCntryDTO update(DmClientMdmNtnltyCntryDTO dmClientMdmNtnltyCntryDTO);

    /**
     * Partially updates a dmClientMdmNtnltyCntry.
     *
     * @param dmClientMdmNtnltyCntryDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<DmClientMdmNtnltyCntryDTO> partialUpdate(DmClientMdmNtnltyCntryDTO dmClientMdmNtnltyCntryDTO);

    /**
     * Get all the dmClientMdmNtnltyCntries.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<DmClientMdmNtnltyCntryDTO> findAll(Pageable pageable);

    /**
     * Get the "id" dmClientMdmNtnltyCntry.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DmClientMdmNtnltyCntryDTO> findOne(Long id);

    /**
     * Delete the "id" dmClientMdmNtnltyCntry.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
