package com.sbm.tableaurealtime.service;

import com.sbm.tableaurealtime.service.dto.FtOResvDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.sbm.tableaurealtime.domain.FtOResv}.
 */
public interface FtOResvService {
    /**
     * Save a ftOResv.
     *
     * @param ftOResvDTO the entity to save.
     * @return the persisted entity.
     */
    FtOResvDTO save(FtOResvDTO ftOResvDTO);

    /**
     * Updates a ftOResv.
     *
     * @param ftOResvDTO the entity to update.
     * @return the persisted entity.
     */
    FtOResvDTO update(FtOResvDTO ftOResvDTO);

    /**
     * Partially updates a ftOResv.
     *
     * @param ftOResvDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<FtOResvDTO> partialUpdate(FtOResvDTO ftOResvDTO);

    /**
     * Get all the ftOResvs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<FtOResvDTO> findAll(Pageable pageable);

    /**
     * Get the "id" ftOResv.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<FtOResvDTO> findOne(Long id);

    /**
     * Delete the "id" ftOResv.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
