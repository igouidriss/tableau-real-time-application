package com.sbm.tableaurealtime.service.impl;

import com.sbm.tableaurealtime.domain.FtOResv;
import com.sbm.tableaurealtime.repository.FtOResvRepository;
import com.sbm.tableaurealtime.service.FtOResvService;
import com.sbm.tableaurealtime.service.dto.FtOResvDTO;
import com.sbm.tableaurealtime.service.mapper.FtOResvMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.sbm.tableaurealtime.domain.FtOResv}.
 */
@Service
@Transactional
public class FtOResvServiceImpl implements FtOResvService {

    private final Logger log = LoggerFactory.getLogger(FtOResvServiceImpl.class);

    private final FtOResvRepository ftOResvRepository;

    private final FtOResvMapper ftOResvMapper;

    public FtOResvServiceImpl(FtOResvRepository ftOResvRepository, FtOResvMapper ftOResvMapper) {
        this.ftOResvRepository = ftOResvRepository;
        this.ftOResvMapper = ftOResvMapper;
    }

    @Override
    public FtOResvDTO save(FtOResvDTO ftOResvDTO) {
        log.debug("Request to save FtOResv : {}", ftOResvDTO);
        FtOResv ftOResv = ftOResvMapper.toEntity(ftOResvDTO);
        ftOResv = ftOResvRepository.save(ftOResv);
        return ftOResvMapper.toDto(ftOResv);
    }

    @Override
    public FtOResvDTO update(FtOResvDTO ftOResvDTO) {
        log.debug("Request to update FtOResv : {}", ftOResvDTO);
        FtOResv ftOResv = ftOResvMapper.toEntity(ftOResvDTO);
        ftOResv = ftOResvRepository.save(ftOResv);
        return ftOResvMapper.toDto(ftOResv);
    }

    @Override
    public Optional<FtOResvDTO> partialUpdate(FtOResvDTO ftOResvDTO) {
        log.debug("Request to partially update FtOResv : {}", ftOResvDTO);

        return ftOResvRepository
            .findById(ftOResvDTO.getId())
            .map(existingFtOResv -> {
                ftOResvMapper.partialUpdate(existingFtOResv, ftOResvDTO);

                return existingFtOResv;
            })
            .map(ftOResvRepository::save)
            .map(ftOResvMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<FtOResvDTO> findAll(Pageable pageable) {
        log.debug("Request to get all FtOResvs");
        return ftOResvRepository.findAll(pageable).map(ftOResvMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<FtOResvDTO> findOne(Long id) {
        log.debug("Request to get FtOResv : {}", id);
        return ftOResvRepository.findById(id).map(ftOResvMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete FtOResv : {}", id);
        ftOResvRepository.deleteById(id);
    }
}
