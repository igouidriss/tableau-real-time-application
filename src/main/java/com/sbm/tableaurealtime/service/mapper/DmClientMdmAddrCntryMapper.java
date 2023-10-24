package com.sbm.tableaurealtime.service.mapper;

import com.sbm.tableaurealtime.domain.DmClientMdmAddrCntry;
import com.sbm.tableaurealtime.service.dto.DmClientMdmAddrCntryDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link DmClientMdmAddrCntry} and its DTO {@link DmClientMdmAddrCntryDTO}.
 */
@Mapper(componentModel = "spring")
public interface DmClientMdmAddrCntryMapper extends EntityMapper<DmClientMdmAddrCntryDTO, DmClientMdmAddrCntry> {}
