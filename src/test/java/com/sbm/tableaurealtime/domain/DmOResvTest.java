package com.sbm.tableaurealtime.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.sbm.tableaurealtime.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class DmOResvTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DmOResv.class);
        DmOResv dmOResv1 = new DmOResv();
        dmOResv1.setId(1L);
        DmOResv dmOResv2 = new DmOResv();
        dmOResv2.setId(dmOResv1.getId());
        assertThat(dmOResv1).isEqualTo(dmOResv2);
        dmOResv2.setId(2L);
        assertThat(dmOResv1).isNotEqualTo(dmOResv2);
        dmOResv1.setId(null);
        assertThat(dmOResv1).isNotEqualTo(dmOResv2);
    }
}
