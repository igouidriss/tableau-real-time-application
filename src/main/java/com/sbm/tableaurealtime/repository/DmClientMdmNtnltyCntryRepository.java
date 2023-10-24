package com.sbm.tableaurealtime.repository;

import com.sbm.tableaurealtime.domain.DmClientMdmNtnltyCntry;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the DmClientMdmNtnltyCntry entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DmClientMdmNtnltyCntryRepository extends JpaRepository<DmClientMdmNtnltyCntry, Long> {}
