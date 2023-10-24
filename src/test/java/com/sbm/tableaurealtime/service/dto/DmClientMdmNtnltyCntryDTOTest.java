package com.sbm.tableaurealtime.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.sbm.tableaurealtime.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class DmClientMdmNtnltyCntryDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DmClientMdmNtnltyCntryDTO.class);
        DmClientMdmNtnltyCntryDTO dmClientMdmNtnltyCntryDTO1 = new DmClientMdmNtnltyCntryDTO();
        dmClientMdmNtnltyCntryDTO1.setId(1L);
        DmClientMdmNtnltyCntryDTO dmClientMdmNtnltyCntryDTO2 = new DmClientMdmNtnltyCntryDTO();
        assertThat(dmClientMdmNtnltyCntryDTO1).isNotEqualTo(dmClientMdmNtnltyCntryDTO2);
        dmClientMdmNtnltyCntryDTO2.setId(dmClientMdmNtnltyCntryDTO1.getId());
        assertThat(dmClientMdmNtnltyCntryDTO1).isEqualTo(dmClientMdmNtnltyCntryDTO2);
        dmClientMdmNtnltyCntryDTO2.setId(2L);
        assertThat(dmClientMdmNtnltyCntryDTO1).isNotEqualTo(dmClientMdmNtnltyCntryDTO2);
        dmClientMdmNtnltyCntryDTO1.setId(null);
        assertThat(dmClientMdmNtnltyCntryDTO1).isNotEqualTo(dmClientMdmNtnltyCntryDTO2);
    }
}
