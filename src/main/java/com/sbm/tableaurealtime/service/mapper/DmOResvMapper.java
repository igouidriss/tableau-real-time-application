package com.sbm.tableaurealtime.service.mapper;

import com.sbm.tableaurealtime.domain.DmOResv;
import com.sbm.tableaurealtime.service.dto.DmOResvDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link DmOResv} and its DTO {@link DmOResvDTO}.
 */
@Mapper(componentModel = "spring")
public interface DmOResvMapper extends EntityMapper<DmOResvDTO, DmOResv> {}
