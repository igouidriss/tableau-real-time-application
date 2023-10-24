package com.sbm.tableaurealtime.service.mapper;

import com.sbm.tableaurealtime.domain.DmClientMdmNtnltyCntry;
import com.sbm.tableaurealtime.service.dto.DmClientMdmNtnltyCntryDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link DmClientMdmNtnltyCntry} and its DTO {@link DmClientMdmNtnltyCntryDTO}.
 */
@Mapper(componentModel = "spring")
public interface DmClientMdmNtnltyCntryMapper extends EntityMapper<DmClientMdmNtnltyCntryDTO, DmClientMdmNtnltyCntry> {}
