package com.sbm.tableaurealtime.service.impl;

import com.sbm.tableaurealtime.domain.DmClientMdmAddrCntry;
import com.sbm.tableaurealtime.repository.DmClientMdmAddrCntryRepository;
import com.sbm.tableaurealtime.service.DmClientMdmAddrCntryService;
import com.sbm.tableaurealtime.service.dto.DmClientMdmAddrCntryDTO;
import com.sbm.tableaurealtime.service.mapper.DmClientMdmAddrCntryMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.sbm.tableaurealtime.domain.DmClientMdmAddrCntry}.
 */
@Service
@Transactional
public class DmClientMdmAddrCntryServiceImpl implements DmClientMdmAddrCntryService {

    private final Logger log = LoggerFactory.getLogger(DmClientMdmAddrCntryServiceImpl.class);

    private final DmClientMdmAddrCntryRepository dmClientMdmAddrCntryRepository;

    private final DmClientMdmAddrCntryMapper dmClientMdmAddrCntryMapper;

    public DmClientMdmAddrCntryServiceImpl(
        DmClientMdmAddrCntryRepository dmClientMdmAddrCntryRepository,
        DmClientMdmAddrCntryMapper dmClientMdmAddrCntryMapper
    ) {
        this.dmClientMdmAddrCntryRepository = dmClientMdmAddrCntryRepository;
        this.dmClientMdmAddrCntryMapper = dmClientMdmAddrCntryMapper;
    }

    @Override
    public DmClientMdmAddrCntryDTO save(DmClientMdmAddrCntryDTO dmClientMdmAddrCntryDTO) {
        log.debug("Request to save DmClientMdmAddrCntry : {}", dmClientMdmAddrCntryDTO);
        DmClientMdmAddrCntry dmClientMdmAddrCntry = dmClientMdmAddrCntryMapper.toEntity(dmClientMdmAddrCntryDTO);
        dmClientMdmAddrCntry = dmClientMdmAddrCntryRepository.save(dmClientMdmAddrCntry);
        return dmClientMdmAddrCntryMapper.toDto(dmClientMdmAddrCntry);
    }

    @Override
    public DmClientMdmAddrCntryDTO update(DmClientMdmAddrCntryDTO dmClientMdmAddrCntryDTO) {
        log.debug("Request to update DmClientMdmAddrCntry : {}", dmClientMdmAddrCntryDTO);
        DmClientMdmAddrCntry dmClientMdmAddrCntry = dmClientMdmAddrCntryMapper.toEntity(dmClientMdmAddrCntryDTO);
        dmClientMdmAddrCntry = dmClientMdmAddrCntryRepository.save(dmClientMdmAddrCntry);
        return dmClientMdmAddrCntryMapper.toDto(dmClientMdmAddrCntry);
    }

    @Override
    public Optional<DmClientMdmAddrCntryDTO> partialUpdate(DmClientMdmAddrCntryDTO dmClientMdmAddrCntryDTO) {
        log.debug("Request to partially update DmClientMdmAddrCntry : {}", dmClientMdmAddrCntryDTO);

        return dmClientMdmAddrCntryRepository
            .findById(dmClientMdmAddrCntryDTO.getId())
            .map(existingDmClientMdmAddrCntry -> {
                dmClientMdmAddrCntryMapper.partialUpdate(existingDmClientMdmAddrCntry, dmClientMdmAddrCntryDTO);

                return existingDmClientMdmAddrCntry;
            })
            .map(dmClientMdmAddrCntryRepository::save)
            .map(dmClientMdmAddrCntryMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DmClientMdmAddrCntryDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DmClientMdmAddrCntries");
        return dmClientMdmAddrCntryRepository.findAll(pageable).map(dmClientMdmAddrCntryMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DmClientMdmAddrCntryDTO> findOne(Long id) {
        log.debug("Request to get DmClientMdmAddrCntry : {}", id);
        return dmClientMdmAddrCntryRepository.findById(id).map(dmClientMdmAddrCntryMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete DmClientMdmAddrCntry : {}", id);
        dmClientMdmAddrCntryRepository.deleteById(id);
    }
}
