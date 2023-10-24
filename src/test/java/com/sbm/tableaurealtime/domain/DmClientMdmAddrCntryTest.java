package com.sbm.tableaurealtime.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.sbm.tableaurealtime.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class DmClientMdmAddrCntryTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DmClientMdmAddrCntry.class);
        DmClientMdmAddrCntry dmClientMdmAddrCntry1 = new DmClientMdmAddrCntry();
        dmClientMdmAddrCntry1.setId(1L);
        DmClientMdmAddrCntry dmClientMdmAddrCntry2 = new DmClientMdmAddrCntry();
        dmClientMdmAddrCntry2.setId(dmClientMdmAddrCntry1.getId());
        assertThat(dmClientMdmAddrCntry1).isEqualTo(dmClientMdmAddrCntry2);
        dmClientMdmAddrCntry2.setId(2L);
        assertThat(dmClientMdmAddrCntry1).isNotEqualTo(dmClientMdmAddrCntry2);
        dmClientMdmAddrCntry1.setId(null);
        assertThat(dmClientMdmAddrCntry1).isNotEqualTo(dmClientMdmAddrCntry2);
    }
}
