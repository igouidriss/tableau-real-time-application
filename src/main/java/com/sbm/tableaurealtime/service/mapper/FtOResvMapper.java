package com.sbm.tableaurealtime.service.mapper;

import com.sbm.tableaurealtime.domain.FtOResv;
import com.sbm.tableaurealtime.service.dto.FtOResvDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link FtOResv} and its DTO {@link FtOResvDTO}.
 */
@Mapper(componentModel = "spring")
public interface FtOResvMapper extends EntityMapper<FtOResvDTO, FtOResv> {}
