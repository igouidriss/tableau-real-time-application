package com.sbm.tableaurealtime.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.sbm.tableaurealtime.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class DmOResvDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DmOResvDTO.class);
        DmOResvDTO dmOResvDTO1 = new DmOResvDTO();
        dmOResvDTO1.setId(1L);
        DmOResvDTO dmOResvDTO2 = new DmOResvDTO();
        assertThat(dmOResvDTO1).isNotEqualTo(dmOResvDTO2);
        dmOResvDTO2.setId(dmOResvDTO1.getId());
        assertThat(dmOResvDTO1).isEqualTo(dmOResvDTO2);
        dmOResvDTO2.setId(2L);
        assertThat(dmOResvDTO1).isNotEqualTo(dmOResvDTO2);
        dmOResvDTO1.setId(null);
        assertThat(dmOResvDTO1).isNotEqualTo(dmOResvDTO2);
    }
}
