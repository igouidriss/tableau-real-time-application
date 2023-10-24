package com.sbm.tableaurealtime.service.impl;

import com.sbm.tableaurealtime.domain.DmOResv;
import com.sbm.tableaurealtime.repository.DmOResvRepository;
import com.sbm.tableaurealtime.service.DmOResvService;
import com.sbm.tableaurealtime.service.dto.DmOResvDTO;
import com.sbm.tableaurealtime.service.mapper.DmOResvMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.sbm.tableaurealtime.domain.DmOResv}.
 */
@Service
@Transactional
public class DmOResvServiceImpl implements DmOResvService {

    private final Logger log = LoggerFactory.getLogger(DmOResvServiceImpl.class);

    private final DmOResvRepository dmOResvRepository;

    private final DmOResvMapper dmOResvMapper;

    public DmOResvServiceImpl(DmOResvRepository dmOResvRepository, DmOResvMapper dmOResvMapper) {
        this.dmOResvRepository = dmOResvRepository;
        this.dmOResvMapper = dmOResvMapper;
    }

    @Override
    public DmOResvDTO save(DmOResvDTO dmOResvDTO) {
        log.debug("Request to save DmOResv : {}", dmOResvDTO);
        DmOResv dmOResv = dmOResvMapper.toEntity(dmOResvDTO);
        dmOResv = dmOResvRepository.save(dmOResv);
        return dmOResvMapper.toDto(dmOResv);
    }

    @Override
    public DmOResvDTO update(DmOResvDTO dmOResvDTO) {
        log.debug("Request to update DmOResv : {}", dmOResvDTO);
        DmOResv dmOResv = dmOResvMapper.toEntity(dmOResvDTO);
        dmOResv = dmOResvRepository.save(dmOResv);
        return dmOResvMapper.toDto(dmOResv);
    }

    @Override
    public Optional<DmOResvDTO> partialUpdate(DmOResvDTO dmOResvDTO) {
        log.debug("Request to partially update DmOResv : {}", dmOResvDTO);

        return dmOResvRepository
            .findById(dmOResvDTO.getId())
            .map(existingDmOResv -> {
                dmOResvMapper.partialUpdate(existingDmOResv, dmOResvDTO);

                return existingDmOResv;
            })
            .map(dmOResvRepository::save)
            .map(dmOResvMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DmOResvDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DmOResvs");
        return dmOResvRepository.findAll(pageable).map(dmOResvMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DmOResvDTO> findOne(Long id) {
        log.debug("Request to get DmOResv : {}", id);
        return dmOResvRepository.findById(id).map(dmOResvMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete DmOResv : {}", id);
        dmOResvRepository.deleteById(id);
    }
}
