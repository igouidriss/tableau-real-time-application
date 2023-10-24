package com.sbm.tableaurealtime.service;

import com.sbm.tableaurealtime.service.dto.DmClientMdmAddrCntryDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.sbm.tableaurealtime.domain.DmClientMdmAddrCntry}.
 */
public interface DmClientMdmAddrCntryService {
    /**
     * Save a dmClientMdmAddrCntry.
     *
     * @param dmClientMdmAddrCntryDTO the entity to save.
     * @return the persisted entity.
     */
    DmClientMdmAddrCntryDTO save(DmClientMdmAddrCntryDTO dmClientMdmAddrCntryDTO);

    /**
     * Updates a dmClientMdmAddrCntry.
     *
     * @param dmClientMdmAddrCntryDTO the entity to update.
     * @return the persisted entity.
     */
    DmClientMdmAddrCntryDTO update(DmClientMdmAddrCntryDTO dmClientMdmAddrCntryDTO);

    /**
     * Partially updates a dmClientMdmAddrCntry.
     *
     * @param dmClientMdmAddrCntryDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<DmClientMdmAddrCntryDTO> partialUpdate(DmClientMdmAddrCntryDTO dmClientMdmAddrCntryDTO);

    /**
     * Get all the dmClientMdmAddrCntries.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<DmClientMdmAddrCntryDTO> findAll(Pageable pageable);

    /**
     * Get the "id" dmClientMdmAddrCntry.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DmClientMdmAddrCntryDTO> findOne(Long id);

    /**
     * Delete the "id" dmClientMdmAddrCntry.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
