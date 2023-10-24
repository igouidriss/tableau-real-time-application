package com.sbm.tableaurealtime.service;

import com.sbm.tableaurealtime.service.dto.DmOResvDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.sbm.tableaurealtime.domain.DmOResv}.
 */
public interface DmOResvService {
    /**
     * Save a dmOResv.
     *
     * @param dmOResvDTO the entity to save.
     * @return the persisted entity.
     */
    DmOResvDTO save(DmOResvDTO dmOResvDTO);

    /**
     * Updates a dmOResv.
     *
     * @param dmOResvDTO the entity to update.
     * @return the persisted entity.
     */
    DmOResvDTO update(DmOResvDTO dmOResvDTO);

    /**
     * Partially updates a dmOResv.
     *
     * @param dmOResvDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<DmOResvDTO> partialUpdate(DmOResvDTO dmOResvDTO);

    /**
     * Get all the dmOResvs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<DmOResvDTO> findAll(Pageable pageable);

    /**
     * Get the "id" dmOResv.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DmOResvDTO> findOne(Long id);

    /**
     * Delete the "id" dmOResv.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
