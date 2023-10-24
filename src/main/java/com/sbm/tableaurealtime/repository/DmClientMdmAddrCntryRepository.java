package com.sbm.tableaurealtime.repository;

import com.sbm.tableaurealtime.domain.DmClientMdmAddrCntry;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the DmClientMdmAddrCntry entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DmClientMdmAddrCntryRepository extends JpaRepository<DmClientMdmAddrCntry, Long> {}
