package com.sbm.tableaurealtime.repository;

import com.sbm.tableaurealtime.domain.FtOResv;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the FtOResv entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FtOResvRepository extends JpaRepository<FtOResv, Long> {}
