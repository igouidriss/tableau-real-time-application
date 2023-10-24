package com.sbm.tableaurealtime.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.sbm.tableaurealtime.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class FtOResvTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FtOResv.class);
        FtOResv ftOResv1 = new FtOResv();
        ftOResv1.setId(1L);
        FtOResv ftOResv2 = new FtOResv();
        ftOResv2.setId(ftOResv1.getId());
        assertThat(ftOResv1).isEqualTo(ftOResv2);
        ftOResv2.setId(2L);
        assertThat(ftOResv1).isNotEqualTo(ftOResv2);
        ftOResv1.setId(null);
        assertThat(ftOResv1).isNotEqualTo(ftOResv2);
    }
}
