package com.sbm.tableaurealtime.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.sbm.tableaurealtime.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class DmClientMdmNtnltyCntryTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DmClientMdmNtnltyCntry.class);
        DmClientMdmNtnltyCntry dmClientMdmNtnltyCntry1 = new DmClientMdmNtnltyCntry();
        dmClientMdmNtnltyCntry1.setId(1L);
        DmClientMdmNtnltyCntry dmClientMdmNtnltyCntry2 = new DmClientMdmNtnltyCntry();
        dmClientMdmNtnltyCntry2.setId(dmClientMdmNtnltyCntry1.getId());
        assertThat(dmClientMdmNtnltyCntry1).isEqualTo(dmClientMdmNtnltyCntry2);
        dmClientMdmNtnltyCntry2.setId(2L);
        assertThat(dmClientMdmNtnltyCntry1).isNotEqualTo(dmClientMdmNtnltyCntry2);
        dmClientMdmNtnltyCntry1.setId(null);
        assertThat(dmClientMdmNtnltyCntry1).isNotEqualTo(dmClientMdmNtnltyCntry2);
    }
}
