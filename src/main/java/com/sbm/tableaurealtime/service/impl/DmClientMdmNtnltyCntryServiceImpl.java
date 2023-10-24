package com.sbm.tableaurealtime.service.impl;

import com.sbm.tableaurealtime.domain.DmClientMdmNtnltyCntry;
import com.sbm.tableaurealtime.repository.DmClientMdmNtnltyCntryRepository;
import com.sbm.tableaurealtime.service.DmClientMdmNtnltyCntryService;
import com.sbm.tableaurealtime.service.dto.DmClientMdmNtnltyCntryDTO;
import com.sbm.tableaurealtime.service.mapper.DmClientMdmNtnltyCntryMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.sbm.tableaurealtime.domain.DmClientMdmNtnltyCntry}.
 */
@Service
@Transactional
public class DmClientMdmNtnltyCntryServiceImpl implements DmClientMdmNtnltyCntryService {

    private final Logger log = LoggerFactory.getLogger(DmClientMdmNtnltyCntryServiceImpl.class);

    private final DmClientMdmNtnltyCntryRepository dmClientMdmNtnltyCntryRepository;

    private final DmClientMdmNtnltyCntryMapper dmClientMdmNtnltyCntryMapper;

    public DmClientMdmNtnltyCntryServiceImpl(
        DmClientMdmNtnltyCntryRepository dmClientMdmNtnltyCntryRepository,
        DmClientMdmNtnltyCntryMapper dmClientMdmNtnltyCntryMapper
    ) {
        this.dmClientMdmNtnltyCntryRepository = dmClientMdmNtnltyCntryRepository;
        this.dmClientMdmNtnltyCntryMapper = dmClientMdmNtnltyCntryMapper;
    }

    @Override
    public DmClientMdmNtnltyCntryDTO save(DmClientMdmNtnltyCntryDTO dmClientMdmNtnltyCntryDTO) {
        log.debug("Request to save DmClientMdmNtnltyCntry : {}", dmClientMdmNtnltyCntryDTO);
        DmClientMdmNtnltyCntry dmClientMdmNtnltyCntry = dmClientMdmNtnltyCntryMapper.toEntity(dmClientMdmNtnltyCntryDTO);
        dmClientMdmNtnltyCntry = dmClientMdmNtnltyCntryRepository.save(dmClientMdmNtnltyCntry);
        return dmClientMdmNtnltyCntryMapper.toDto(dmClientMdmNtnltyCntry);
    }

    @Override
    public DmClientMdmNtnltyCntryDTO update(DmClientMdmNtnltyCntryDTO dmClientMdmNtnltyCntryDTO) {
        log.debug("Request to update DmClientMdmNtnltyCntry : {}", dmClientMdmNtnltyCntryDTO);
        DmClientMdmNtnltyCntry dmClientMdmNtnltyCntry = dmClientMdmNtnltyCntryMapper.toEntity(dmClientMdmNtnltyCntryDTO);
        dmClientMdmNtnltyCntry = dmClientMdmNtnltyCntryRepository.save(dmClientMdmNtnltyCntry);
        return dmClientMdmNtnltyCntryMapper.toDto(dmClientMdmNtnltyCntry);
    }

    @Override
    public Optional<DmClientMdmNtnltyCntryDTO> partialUpdate(DmClientMdmNtnltyCntryDTO dmClientMdmNtnltyCntryDTO) {
        log.debug("Request to partially update DmClientMdmNtnltyCntry : {}", dmClientMdmNtnltyCntryDTO);

        return dmClientMdmNtnltyCntryRepository
            .findById(dmClientMdmNtnltyCntryDTO.getId())
            .map(existingDmClientMdmNtnltyCntry -> {
                dmClientMdmNtnltyCntryMapper.partialUpdate(existingDmClientMdmNtnltyCntry, dmClientMdmNtnltyCntryDTO);

                return existingDmClientMdmNtnltyCntry;
            })
            .map(dmClientMdmNtnltyCntryRepository::save)
            .map(dmClientMdmNtnltyCntryMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DmClientMdmNtnltyCntryDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DmClientMdmNtnltyCntries");
        return dmClientMdmNtnltyCntryRepository.findAll(pageable).map(dmClientMdmNtnltyCntryMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DmClientMdmNtnltyCntryDTO> findOne(Long id) {
        log.debug("Request to get DmClientMdmNtnltyCntry : {}", id);
        return dmClientMdmNtnltyCntryRepository.findById(id).map(dmClientMdmNtnltyCntryMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete DmClientMdmNtnltyCntry : {}", id);
        dmClientMdmNtnltyCntryRepository.deleteById(id);
    }
}
