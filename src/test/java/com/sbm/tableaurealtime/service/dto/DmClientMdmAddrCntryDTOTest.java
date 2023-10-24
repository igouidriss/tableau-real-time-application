package com.sbm.tableaurealtime.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.sbm.tableaurealtime.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class DmClientMdmAddrCntryDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DmClientMdmAddrCntryDTO.class);
        DmClientMdmAddrCntryDTO dmClientMdmAddrCntryDTO1 = new DmClientMdmAddrCntryDTO();
        dmClientMdmAddrCntryDTO1.setId(1L);
        DmClientMdmAddrCntryDTO dmClientMdmAddrCntryDTO2 = new DmClientMdmAddrCntryDTO();
        assertThat(dmClientMdmAddrCntryDTO1).isNotEqualTo(dmClientMdmAddrCntryDTO2);
        dmClientMdmAddrCntryDTO2.setId(dmClientMdmAddrCntryDTO1.getId());
        assertThat(dmClientMdmAddrCntryDTO1).isEqualTo(dmClientMdmAddrCntryDTO2);
        dmClientMdmAddrCntryDTO2.setId(2L);
        assertThat(dmClientMdmAddrCntryDTO1).isNotEqualTo(dmClientMdmAddrCntryDTO2);
        dmClientMdmAddrCntryDTO1.setId(null);
        assertThat(dmClientMdmAddrCntryDTO1).isNotEqualTo(dmClientMdmAddrCntryDTO2);
    }
}
