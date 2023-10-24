package com.sbm.tableaurealtime.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.sbm.tableaurealtime.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class FtOResvDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(FtOResvDTO.class);
        FtOResvDTO ftOResvDTO1 = new FtOResvDTO();
        ftOResvDTO1.setId(1L);
        FtOResvDTO ftOResvDTO2 = new FtOResvDTO();
        assertThat(ftOResvDTO1).isNotEqualTo(ftOResvDTO2);
        ftOResvDTO2.setId(ftOResvDTO1.getId());
        assertThat(ftOResvDTO1).isEqualTo(ftOResvDTO2);
        ftOResvDTO2.setId(2L);
        assertThat(ftOResvDTO1).isNotEqualTo(ftOResvDTO2);
        ftOResvDTO1.setId(null);
        assertThat(ftOResvDTO1).isNotEqualTo(ftOResvDTO2);
    }
}
