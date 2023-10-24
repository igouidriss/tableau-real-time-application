package com.sbm.tableaurealtime.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.sbm.tableaurealtime.IntegrationTest;
import com.sbm.tableaurealtime.domain.DmClientMdmNtnltyCntry;
import com.sbm.tableaurealtime.repository.DmClientMdmNtnltyCntryRepository;
import com.sbm.tableaurealtime.service.dto.DmClientMdmNtnltyCntryDTO;
import com.sbm.tableaurealtime.service.mapper.DmClientMdmNtnltyCntryMapper;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link DmClientMdmNtnltyCntryResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class DmClientMdmNtnltyCntryResourceIT {

    private static final String DEFAULT_PRTY_FK = "AAAAAAAAAA";
    private static final String UPDATED_PRTY_FK = "BBBBBBBBBB";

    private static final String DEFAULT_FRST_NTNLT_FRMT = "AAAAAAAAAA";
    private static final String UPDATED_FRST_NTNLT_FRMT = "BBBBBBBBBB";

    private static final String DEFAULT_FRST_CONTINENT = "AAAAAAAAAA";
    private static final String UPDATED_FRST_CONTINENT = "BBBBBBBBBB";

    private static final String DEFAULT_SCND_NTNLT_FRMT = "AAAAAAAAAA";
    private static final String UPDATED_SCND_NTNLT_FRMT = "BBBBBBBBBB";

    private static final String DEFAULT_SCND_CONTINENT = "AAAAAAAAAA";
    private static final String UPDATED_SCND_CONTINENT = "BBBBBBBBBB";

    private static final String DEFAULT_THRD_NTNLT_FRMT = "AAAAAAAAAA";
    private static final String UPDATED_THRD_NTNLT_FRMT = "BBBBBBBBBB";

    private static final String DEFAULT_THRD_CONTINENT = "AAAAAAAAAA";
    private static final String UPDATED_THRD_CONTINENT = "BBBBBBBBBB";

    private static final String DEFAULT_FRTH_NTNLT_FRMT = "AAAAAAAAAA";
    private static final String UPDATED_FRTH_NTNLT_FRMT = "BBBBBBBBBB";

    private static final String DEFAULT_FRTH_CONTINENT = "AAAAAAAAAA";
    private static final String UPDATED_FRTH_CONTINENT = "BBBBBBBBBB";

    private static final String DEFAULT_TECH_LINEAGE = "AAAAAAAAAA";
    private static final String UPDATED_TECH_LINEAGE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_TECH_CREATED_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TECH_CREATED_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_TECH_UPDATED_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TECH_UPDATED_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_TECH_MAPPING = "AAAAAAAAAA";
    private static final String UPDATED_TECH_MAPPING = "BBBBBBBBBB";

    private static final String DEFAULT_TECH_COMMENT = "AAAAAAAAAA";
    private static final String UPDATED_TECH_COMMENT = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/dm-client-mdm-ntnlty-cntries";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private DmClientMdmNtnltyCntryRepository dmClientMdmNtnltyCntryRepository;

    @Autowired
    private DmClientMdmNtnltyCntryMapper dmClientMdmNtnltyCntryMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDmClientMdmNtnltyCntryMockMvc;

    private DmClientMdmNtnltyCntry dmClientMdmNtnltyCntry;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DmClientMdmNtnltyCntry createEntity(EntityManager em) {
        DmClientMdmNtnltyCntry dmClientMdmNtnltyCntry = new DmClientMdmNtnltyCntry()
            .prtyFk(DEFAULT_PRTY_FK)
            .frstNtnltFrmt(DEFAULT_FRST_NTNLT_FRMT)
            .frstContinent(DEFAULT_FRST_CONTINENT)
            .scndNtnltFrmt(DEFAULT_SCND_NTNLT_FRMT)
            .scndContinent(DEFAULT_SCND_CONTINENT)
            .thrdNtnltFrmt(DEFAULT_THRD_NTNLT_FRMT)
            .thrdContinent(DEFAULT_THRD_CONTINENT)
            .frthNtnltFrmt(DEFAULT_FRTH_NTNLT_FRMT)
            .frthContinent(DEFAULT_FRTH_CONTINENT)
            .techLineage(DEFAULT_TECH_LINEAGE)
            .techCreatedDate(DEFAULT_TECH_CREATED_DATE)
            .techUpdatedDate(DEFAULT_TECH_UPDATED_DATE)
            .techMapping(DEFAULT_TECH_MAPPING)
            .techComment(DEFAULT_TECH_COMMENT);
        return dmClientMdmNtnltyCntry;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DmClientMdmNtnltyCntry createUpdatedEntity(EntityManager em) {
        DmClientMdmNtnltyCntry dmClientMdmNtnltyCntry = new DmClientMdmNtnltyCntry()
            .prtyFk(UPDATED_PRTY_FK)
            .frstNtnltFrmt(UPDATED_FRST_NTNLT_FRMT)
            .frstContinent(UPDATED_FRST_CONTINENT)
            .scndNtnltFrmt(UPDATED_SCND_NTNLT_FRMT)
            .scndContinent(UPDATED_SCND_CONTINENT)
            .thrdNtnltFrmt(UPDATED_THRD_NTNLT_FRMT)
            .thrdContinent(UPDATED_THRD_CONTINENT)
            .frthNtnltFrmt(UPDATED_FRTH_NTNLT_FRMT)
            .frthContinent(UPDATED_FRTH_CONTINENT)
            .techLineage(UPDATED_TECH_LINEAGE)
            .techCreatedDate(UPDATED_TECH_CREATED_DATE)
            .techUpdatedDate(UPDATED_TECH_UPDATED_DATE)
            .techMapping(UPDATED_TECH_MAPPING)
            .techComment(UPDATED_TECH_COMMENT);
        return dmClientMdmNtnltyCntry;
    }

    @BeforeEach
    public void initTest() {
        dmClientMdmNtnltyCntry = createEntity(em);
    }

    @Test
    @Transactional
    void createDmClientMdmNtnltyCntry() throws Exception {
        int databaseSizeBeforeCreate = dmClientMdmNtnltyCntryRepository.findAll().size();
        // Create the DmClientMdmNtnltyCntry
        DmClientMdmNtnltyCntryDTO dmClientMdmNtnltyCntryDTO = dmClientMdmNtnltyCntryMapper.toDto(dmClientMdmNtnltyCntry);
        restDmClientMdmNtnltyCntryMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(dmClientMdmNtnltyCntryDTO))
            )
            .andExpect(status().isCreated());

        // Validate the DmClientMdmNtnltyCntry in the database
        List<DmClientMdmNtnltyCntry> dmClientMdmNtnltyCntryList = dmClientMdmNtnltyCntryRepository.findAll();
        assertThat(dmClientMdmNtnltyCntryList).hasSize(databaseSizeBeforeCreate + 1);
        DmClientMdmNtnltyCntry testDmClientMdmNtnltyCntry = dmClientMdmNtnltyCntryList.get(dmClientMdmNtnltyCntryList.size() - 1);
        assertThat(testDmClientMdmNtnltyCntry.getPrtyFk()).isEqualTo(DEFAULT_PRTY_FK);
        assertThat(testDmClientMdmNtnltyCntry.getFrstNtnltFrmt()).isEqualTo(DEFAULT_FRST_NTNLT_FRMT);
        assertThat(testDmClientMdmNtnltyCntry.getFrstContinent()).isEqualTo(DEFAULT_FRST_CONTINENT);
        assertThat(testDmClientMdmNtnltyCntry.getScndNtnltFrmt()).isEqualTo(DEFAULT_SCND_NTNLT_FRMT);
        assertThat(testDmClientMdmNtnltyCntry.getScndContinent()).isEqualTo(DEFAULT_SCND_CONTINENT);
        assertThat(testDmClientMdmNtnltyCntry.getThrdNtnltFrmt()).isEqualTo(DEFAULT_THRD_NTNLT_FRMT);
        assertThat(testDmClientMdmNtnltyCntry.getThrdContinent()).isEqualTo(DEFAULT_THRD_CONTINENT);
        assertThat(testDmClientMdmNtnltyCntry.getFrthNtnltFrmt()).isEqualTo(DEFAULT_FRTH_NTNLT_FRMT);
        assertThat(testDmClientMdmNtnltyCntry.getFrthContinent()).isEqualTo(DEFAULT_FRTH_CONTINENT);
        assertThat(testDmClientMdmNtnltyCntry.getTechLineage()).isEqualTo(DEFAULT_TECH_LINEAGE);
        assertThat(testDmClientMdmNtnltyCntry.getTechCreatedDate()).isEqualTo(DEFAULT_TECH_CREATED_DATE);
        assertThat(testDmClientMdmNtnltyCntry.getTechUpdatedDate()).isEqualTo(DEFAULT_TECH_UPDATED_DATE);
        assertThat(testDmClientMdmNtnltyCntry.getTechMapping()).isEqualTo(DEFAULT_TECH_MAPPING);
        assertThat(testDmClientMdmNtnltyCntry.getTechComment()).isEqualTo(DEFAULT_TECH_COMMENT);
    }

    @Test
    @Transactional
    void createDmClientMdmNtnltyCntryWithExistingId() throws Exception {
        // Create the DmClientMdmNtnltyCntry with an existing ID
        dmClientMdmNtnltyCntry.setId(1L);
        DmClientMdmNtnltyCntryDTO dmClientMdmNtnltyCntryDTO = dmClientMdmNtnltyCntryMapper.toDto(dmClientMdmNtnltyCntry);

        int databaseSizeBeforeCreate = dmClientMdmNtnltyCntryRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restDmClientMdmNtnltyCntryMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(dmClientMdmNtnltyCntryDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DmClientMdmNtnltyCntry in the database
        List<DmClientMdmNtnltyCntry> dmClientMdmNtnltyCntryList = dmClientMdmNtnltyCntryRepository.findAll();
        assertThat(dmClientMdmNtnltyCntryList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkPrtyFkIsRequired() throws Exception {
        int databaseSizeBeforeTest = dmClientMdmNtnltyCntryRepository.findAll().size();
        // set the field null
        dmClientMdmNtnltyCntry.setPrtyFk(null);

        // Create the DmClientMdmNtnltyCntry, which fails.
        DmClientMdmNtnltyCntryDTO dmClientMdmNtnltyCntryDTO = dmClientMdmNtnltyCntryMapper.toDto(dmClientMdmNtnltyCntry);

        restDmClientMdmNtnltyCntryMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(dmClientMdmNtnltyCntryDTO))
            )
            .andExpect(status().isBadRequest());

        List<DmClientMdmNtnltyCntry> dmClientMdmNtnltyCntryList = dmClientMdmNtnltyCntryRepository.findAll();
        assertThat(dmClientMdmNtnltyCntryList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllDmClientMdmNtnltyCntries() throws Exception {
        // Initialize the database
        dmClientMdmNtnltyCntryRepository.saveAndFlush(dmClientMdmNtnltyCntry);

        // Get all the dmClientMdmNtnltyCntryList
        restDmClientMdmNtnltyCntryMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dmClientMdmNtnltyCntry.getId().intValue())))
            .andExpect(jsonPath("$.[*].prtyFk").value(hasItem(DEFAULT_PRTY_FK)))
            .andExpect(jsonPath("$.[*].frstNtnltFrmt").value(hasItem(DEFAULT_FRST_NTNLT_FRMT)))
            .andExpect(jsonPath("$.[*].frstContinent").value(hasItem(DEFAULT_FRST_CONTINENT)))
            .andExpect(jsonPath("$.[*].scndNtnltFrmt").value(hasItem(DEFAULT_SCND_NTNLT_FRMT)))
            .andExpect(jsonPath("$.[*].scndContinent").value(hasItem(DEFAULT_SCND_CONTINENT)))
            .andExpect(jsonPath("$.[*].thrdNtnltFrmt").value(hasItem(DEFAULT_THRD_NTNLT_FRMT)))
            .andExpect(jsonPath("$.[*].thrdContinent").value(hasItem(DEFAULT_THRD_CONTINENT)))
            .andExpect(jsonPath("$.[*].frthNtnltFrmt").value(hasItem(DEFAULT_FRTH_NTNLT_FRMT)))
            .andExpect(jsonPath("$.[*].frthContinent").value(hasItem(DEFAULT_FRTH_CONTINENT)))
            .andExpect(jsonPath("$.[*].techLineage").value(hasItem(DEFAULT_TECH_LINEAGE)))
            .andExpect(jsonPath("$.[*].techCreatedDate").value(hasItem(DEFAULT_TECH_CREATED_DATE.toString())))
            .andExpect(jsonPath("$.[*].techUpdatedDate").value(hasItem(DEFAULT_TECH_UPDATED_DATE.toString())))
            .andExpect(jsonPath("$.[*].techMapping").value(hasItem(DEFAULT_TECH_MAPPING)))
            .andExpect(jsonPath("$.[*].techComment").value(hasItem(DEFAULT_TECH_COMMENT)));
    }

    @Test
    @Transactional
    void getDmClientMdmNtnltyCntry() throws Exception {
        // Initialize the database
        dmClientMdmNtnltyCntryRepository.saveAndFlush(dmClientMdmNtnltyCntry);

        // Get the dmClientMdmNtnltyCntry
        restDmClientMdmNtnltyCntryMockMvc
            .perform(get(ENTITY_API_URL_ID, dmClientMdmNtnltyCntry.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(dmClientMdmNtnltyCntry.getId().intValue()))
            .andExpect(jsonPath("$.prtyFk").value(DEFAULT_PRTY_FK))
            .andExpect(jsonPath("$.frstNtnltFrmt").value(DEFAULT_FRST_NTNLT_FRMT))
            .andExpect(jsonPath("$.frstContinent").value(DEFAULT_FRST_CONTINENT))
            .andExpect(jsonPath("$.scndNtnltFrmt").value(DEFAULT_SCND_NTNLT_FRMT))
            .andExpect(jsonPath("$.scndContinent").value(DEFAULT_SCND_CONTINENT))
            .andExpect(jsonPath("$.thrdNtnltFrmt").value(DEFAULT_THRD_NTNLT_FRMT))
            .andExpect(jsonPath("$.thrdContinent").value(DEFAULT_THRD_CONTINENT))
            .andExpect(jsonPath("$.frthNtnltFrmt").value(DEFAULT_FRTH_NTNLT_FRMT))
            .andExpect(jsonPath("$.frthContinent").value(DEFAULT_FRTH_CONTINENT))
            .andExpect(jsonPath("$.techLineage").value(DEFAULT_TECH_LINEAGE))
            .andExpect(jsonPath("$.techCreatedDate").value(DEFAULT_TECH_CREATED_DATE.toString()))
            .andExpect(jsonPath("$.techUpdatedDate").value(DEFAULT_TECH_UPDATED_DATE.toString()))
            .andExpect(jsonPath("$.techMapping").value(DEFAULT_TECH_MAPPING))
            .andExpect(jsonPath("$.techComment").value(DEFAULT_TECH_COMMENT));
    }

    @Test
    @Transactional
    void getNonExistingDmClientMdmNtnltyCntry() throws Exception {
        // Get the dmClientMdmNtnltyCntry
        restDmClientMdmNtnltyCntryMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingDmClientMdmNtnltyCntry() throws Exception {
        // Initialize the database
        dmClientMdmNtnltyCntryRepository.saveAndFlush(dmClientMdmNtnltyCntry);

        int databaseSizeBeforeUpdate = dmClientMdmNtnltyCntryRepository.findAll().size();

        // Update the dmClientMdmNtnltyCntry
        DmClientMdmNtnltyCntry updatedDmClientMdmNtnltyCntry = dmClientMdmNtnltyCntryRepository
            .findById(dmClientMdmNtnltyCntry.getId())
            .orElseThrow();
        // Disconnect from session so that the updates on updatedDmClientMdmNtnltyCntry are not directly saved in db
        em.detach(updatedDmClientMdmNtnltyCntry);
        updatedDmClientMdmNtnltyCntry
            .prtyFk(UPDATED_PRTY_FK)
            .frstNtnltFrmt(UPDATED_FRST_NTNLT_FRMT)
            .frstContinent(UPDATED_FRST_CONTINENT)
            .scndNtnltFrmt(UPDATED_SCND_NTNLT_FRMT)
            .scndContinent(UPDATED_SCND_CONTINENT)
            .thrdNtnltFrmt(UPDATED_THRD_NTNLT_FRMT)
            .thrdContinent(UPDATED_THRD_CONTINENT)
            .frthNtnltFrmt(UPDATED_FRTH_NTNLT_FRMT)
            .frthContinent(UPDATED_FRTH_CONTINENT)
            .techLineage(UPDATED_TECH_LINEAGE)
            .techCreatedDate(UPDATED_TECH_CREATED_DATE)
            .techUpdatedDate(UPDATED_TECH_UPDATED_DATE)
            .techMapping(UPDATED_TECH_MAPPING)
            .techComment(UPDATED_TECH_COMMENT);
        DmClientMdmNtnltyCntryDTO dmClientMdmNtnltyCntryDTO = dmClientMdmNtnltyCntryMapper.toDto(updatedDmClientMdmNtnltyCntry);

        restDmClientMdmNtnltyCntryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, dmClientMdmNtnltyCntryDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(dmClientMdmNtnltyCntryDTO))
            )
            .andExpect(status().isOk());

        // Validate the DmClientMdmNtnltyCntry in the database
        List<DmClientMdmNtnltyCntry> dmClientMdmNtnltyCntryList = dmClientMdmNtnltyCntryRepository.findAll();
        assertThat(dmClientMdmNtnltyCntryList).hasSize(databaseSizeBeforeUpdate);
        DmClientMdmNtnltyCntry testDmClientMdmNtnltyCntry = dmClientMdmNtnltyCntryList.get(dmClientMdmNtnltyCntryList.size() - 1);
        assertThat(testDmClientMdmNtnltyCntry.getPrtyFk()).isEqualTo(UPDATED_PRTY_FK);
        assertThat(testDmClientMdmNtnltyCntry.getFrstNtnltFrmt()).isEqualTo(UPDATED_FRST_NTNLT_FRMT);
        assertThat(testDmClientMdmNtnltyCntry.getFrstContinent()).isEqualTo(UPDATED_FRST_CONTINENT);
        assertThat(testDmClientMdmNtnltyCntry.getScndNtnltFrmt()).isEqualTo(UPDATED_SCND_NTNLT_FRMT);
        assertThat(testDmClientMdmNtnltyCntry.getScndContinent()).isEqualTo(UPDATED_SCND_CONTINENT);
        assertThat(testDmClientMdmNtnltyCntry.getThrdNtnltFrmt()).isEqualTo(UPDATED_THRD_NTNLT_FRMT);
        assertThat(testDmClientMdmNtnltyCntry.getThrdContinent()).isEqualTo(UPDATED_THRD_CONTINENT);
        assertThat(testDmClientMdmNtnltyCntry.getFrthNtnltFrmt()).isEqualTo(UPDATED_FRTH_NTNLT_FRMT);
        assertThat(testDmClientMdmNtnltyCntry.getFrthContinent()).isEqualTo(UPDATED_FRTH_CONTINENT);
        assertThat(testDmClientMdmNtnltyCntry.getTechLineage()).isEqualTo(UPDATED_TECH_LINEAGE);
        assertThat(testDmClientMdmNtnltyCntry.getTechCreatedDate()).isEqualTo(UPDATED_TECH_CREATED_DATE);
        assertThat(testDmClientMdmNtnltyCntry.getTechUpdatedDate()).isEqualTo(UPDATED_TECH_UPDATED_DATE);
        assertThat(testDmClientMdmNtnltyCntry.getTechMapping()).isEqualTo(UPDATED_TECH_MAPPING);
        assertThat(testDmClientMdmNtnltyCntry.getTechComment()).isEqualTo(UPDATED_TECH_COMMENT);
    }

    @Test
    @Transactional
    void putNonExistingDmClientMdmNtnltyCntry() throws Exception {
        int databaseSizeBeforeUpdate = dmClientMdmNtnltyCntryRepository.findAll().size();
        dmClientMdmNtnltyCntry.setId(count.incrementAndGet());

        // Create the DmClientMdmNtnltyCntry
        DmClientMdmNtnltyCntryDTO dmClientMdmNtnltyCntryDTO = dmClientMdmNtnltyCntryMapper.toDto(dmClientMdmNtnltyCntry);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDmClientMdmNtnltyCntryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, dmClientMdmNtnltyCntryDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(dmClientMdmNtnltyCntryDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DmClientMdmNtnltyCntry in the database
        List<DmClientMdmNtnltyCntry> dmClientMdmNtnltyCntryList = dmClientMdmNtnltyCntryRepository.findAll();
        assertThat(dmClientMdmNtnltyCntryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchDmClientMdmNtnltyCntry() throws Exception {
        int databaseSizeBeforeUpdate = dmClientMdmNtnltyCntryRepository.findAll().size();
        dmClientMdmNtnltyCntry.setId(count.incrementAndGet());

        // Create the DmClientMdmNtnltyCntry
        DmClientMdmNtnltyCntryDTO dmClientMdmNtnltyCntryDTO = dmClientMdmNtnltyCntryMapper.toDto(dmClientMdmNtnltyCntry);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDmClientMdmNtnltyCntryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(dmClientMdmNtnltyCntryDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DmClientMdmNtnltyCntry in the database
        List<DmClientMdmNtnltyCntry> dmClientMdmNtnltyCntryList = dmClientMdmNtnltyCntryRepository.findAll();
        assertThat(dmClientMdmNtnltyCntryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamDmClientMdmNtnltyCntry() throws Exception {
        int databaseSizeBeforeUpdate = dmClientMdmNtnltyCntryRepository.findAll().size();
        dmClientMdmNtnltyCntry.setId(count.incrementAndGet());

        // Create the DmClientMdmNtnltyCntry
        DmClientMdmNtnltyCntryDTO dmClientMdmNtnltyCntryDTO = dmClientMdmNtnltyCntryMapper.toDto(dmClientMdmNtnltyCntry);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDmClientMdmNtnltyCntryMockMvc
            .perform(
                put(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(dmClientMdmNtnltyCntryDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the DmClientMdmNtnltyCntry in the database
        List<DmClientMdmNtnltyCntry> dmClientMdmNtnltyCntryList = dmClientMdmNtnltyCntryRepository.findAll();
        assertThat(dmClientMdmNtnltyCntryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateDmClientMdmNtnltyCntryWithPatch() throws Exception {
        // Initialize the database
        dmClientMdmNtnltyCntryRepository.saveAndFlush(dmClientMdmNtnltyCntry);

        int databaseSizeBeforeUpdate = dmClientMdmNtnltyCntryRepository.findAll().size();

        // Update the dmClientMdmNtnltyCntry using partial update
        DmClientMdmNtnltyCntry partialUpdatedDmClientMdmNtnltyCntry = new DmClientMdmNtnltyCntry();
        partialUpdatedDmClientMdmNtnltyCntry.setId(dmClientMdmNtnltyCntry.getId());

        partialUpdatedDmClientMdmNtnltyCntry
            .prtyFk(UPDATED_PRTY_FK)
            .frstContinent(UPDATED_FRST_CONTINENT)
            .thrdNtnltFrmt(UPDATED_THRD_NTNLT_FRMT)
            .thrdContinent(UPDATED_THRD_CONTINENT)
            .techMapping(UPDATED_TECH_MAPPING);

        restDmClientMdmNtnltyCntryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedDmClientMdmNtnltyCntry.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedDmClientMdmNtnltyCntry))
            )
            .andExpect(status().isOk());

        // Validate the DmClientMdmNtnltyCntry in the database
        List<DmClientMdmNtnltyCntry> dmClientMdmNtnltyCntryList = dmClientMdmNtnltyCntryRepository.findAll();
        assertThat(dmClientMdmNtnltyCntryList).hasSize(databaseSizeBeforeUpdate);
        DmClientMdmNtnltyCntry testDmClientMdmNtnltyCntry = dmClientMdmNtnltyCntryList.get(dmClientMdmNtnltyCntryList.size() - 1);
        assertThat(testDmClientMdmNtnltyCntry.getPrtyFk()).isEqualTo(UPDATED_PRTY_FK);
        assertThat(testDmClientMdmNtnltyCntry.getFrstNtnltFrmt()).isEqualTo(DEFAULT_FRST_NTNLT_FRMT);
        assertThat(testDmClientMdmNtnltyCntry.getFrstContinent()).isEqualTo(UPDATED_FRST_CONTINENT);
        assertThat(testDmClientMdmNtnltyCntry.getScndNtnltFrmt()).isEqualTo(DEFAULT_SCND_NTNLT_FRMT);
        assertThat(testDmClientMdmNtnltyCntry.getScndContinent()).isEqualTo(DEFAULT_SCND_CONTINENT);
        assertThat(testDmClientMdmNtnltyCntry.getThrdNtnltFrmt()).isEqualTo(UPDATED_THRD_NTNLT_FRMT);
        assertThat(testDmClientMdmNtnltyCntry.getThrdContinent()).isEqualTo(UPDATED_THRD_CONTINENT);
        assertThat(testDmClientMdmNtnltyCntry.getFrthNtnltFrmt()).isEqualTo(DEFAULT_FRTH_NTNLT_FRMT);
        assertThat(testDmClientMdmNtnltyCntry.getFrthContinent()).isEqualTo(DEFAULT_FRTH_CONTINENT);
        assertThat(testDmClientMdmNtnltyCntry.getTechLineage()).isEqualTo(DEFAULT_TECH_LINEAGE);
        assertThat(testDmClientMdmNtnltyCntry.getTechCreatedDate()).isEqualTo(DEFAULT_TECH_CREATED_DATE);
        assertThat(testDmClientMdmNtnltyCntry.getTechUpdatedDate()).isEqualTo(DEFAULT_TECH_UPDATED_DATE);
        assertThat(testDmClientMdmNtnltyCntry.getTechMapping()).isEqualTo(UPDATED_TECH_MAPPING);
        assertThat(testDmClientMdmNtnltyCntry.getTechComment()).isEqualTo(DEFAULT_TECH_COMMENT);
    }

    @Test
    @Transactional
    void fullUpdateDmClientMdmNtnltyCntryWithPatch() throws Exception {
        // Initialize the database
        dmClientMdmNtnltyCntryRepository.saveAndFlush(dmClientMdmNtnltyCntry);

        int databaseSizeBeforeUpdate = dmClientMdmNtnltyCntryRepository.findAll().size();

        // Update the dmClientMdmNtnltyCntry using partial update
        DmClientMdmNtnltyCntry partialUpdatedDmClientMdmNtnltyCntry = new DmClientMdmNtnltyCntry();
        partialUpdatedDmClientMdmNtnltyCntry.setId(dmClientMdmNtnltyCntry.getId());

        partialUpdatedDmClientMdmNtnltyCntry
            .prtyFk(UPDATED_PRTY_FK)
            .frstNtnltFrmt(UPDATED_FRST_NTNLT_FRMT)
            .frstContinent(UPDATED_FRST_CONTINENT)
            .scndNtnltFrmt(UPDATED_SCND_NTNLT_FRMT)
            .scndContinent(UPDATED_SCND_CONTINENT)
            .thrdNtnltFrmt(UPDATED_THRD_NTNLT_FRMT)
            .thrdContinent(UPDATED_THRD_CONTINENT)
            .frthNtnltFrmt(UPDATED_FRTH_NTNLT_FRMT)
            .frthContinent(UPDATED_FRTH_CONTINENT)
            .techLineage(UPDATED_TECH_LINEAGE)
            .techCreatedDate(UPDATED_TECH_CREATED_DATE)
            .techUpdatedDate(UPDATED_TECH_UPDATED_DATE)
            .techMapping(UPDATED_TECH_MAPPING)
            .techComment(UPDATED_TECH_COMMENT);

        restDmClientMdmNtnltyCntryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedDmClientMdmNtnltyCntry.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedDmClientMdmNtnltyCntry))
            )
            .andExpect(status().isOk());

        // Validate the DmClientMdmNtnltyCntry in the database
        List<DmClientMdmNtnltyCntry> dmClientMdmNtnltyCntryList = dmClientMdmNtnltyCntryRepository.findAll();
        assertThat(dmClientMdmNtnltyCntryList).hasSize(databaseSizeBeforeUpdate);
        DmClientMdmNtnltyCntry testDmClientMdmNtnltyCntry = dmClientMdmNtnltyCntryList.get(dmClientMdmNtnltyCntryList.size() - 1);
        assertThat(testDmClientMdmNtnltyCntry.getPrtyFk()).isEqualTo(UPDATED_PRTY_FK);
        assertThat(testDmClientMdmNtnltyCntry.getFrstNtnltFrmt()).isEqualTo(UPDATED_FRST_NTNLT_FRMT);
        assertThat(testDmClientMdmNtnltyCntry.getFrstContinent()).isEqualTo(UPDATED_FRST_CONTINENT);
        assertThat(testDmClientMdmNtnltyCntry.getScndNtnltFrmt()).isEqualTo(UPDATED_SCND_NTNLT_FRMT);
        assertThat(testDmClientMdmNtnltyCntry.getScndContinent()).isEqualTo(UPDATED_SCND_CONTINENT);
        assertThat(testDmClientMdmNtnltyCntry.getThrdNtnltFrmt()).isEqualTo(UPDATED_THRD_NTNLT_FRMT);
        assertThat(testDmClientMdmNtnltyCntry.getThrdContinent()).isEqualTo(UPDATED_THRD_CONTINENT);
        assertThat(testDmClientMdmNtnltyCntry.getFrthNtnltFrmt()).isEqualTo(UPDATED_FRTH_NTNLT_FRMT);
        assertThat(testDmClientMdmNtnltyCntry.getFrthContinent()).isEqualTo(UPDATED_FRTH_CONTINENT);
        assertThat(testDmClientMdmNtnltyCntry.getTechLineage()).isEqualTo(UPDATED_TECH_LINEAGE);
        assertThat(testDmClientMdmNtnltyCntry.getTechCreatedDate()).isEqualTo(UPDATED_TECH_CREATED_DATE);
        assertThat(testDmClientMdmNtnltyCntry.getTechUpdatedDate()).isEqualTo(UPDATED_TECH_UPDATED_DATE);
        assertThat(testDmClientMdmNtnltyCntry.getTechMapping()).isEqualTo(UPDATED_TECH_MAPPING);
        assertThat(testDmClientMdmNtnltyCntry.getTechComment()).isEqualTo(UPDATED_TECH_COMMENT);
    }

    @Test
    @Transactional
    void patchNonExistingDmClientMdmNtnltyCntry() throws Exception {
        int databaseSizeBeforeUpdate = dmClientMdmNtnltyCntryRepository.findAll().size();
        dmClientMdmNtnltyCntry.setId(count.incrementAndGet());

        // Create the DmClientMdmNtnltyCntry
        DmClientMdmNtnltyCntryDTO dmClientMdmNtnltyCntryDTO = dmClientMdmNtnltyCntryMapper.toDto(dmClientMdmNtnltyCntry);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDmClientMdmNtnltyCntryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, dmClientMdmNtnltyCntryDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(dmClientMdmNtnltyCntryDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DmClientMdmNtnltyCntry in the database
        List<DmClientMdmNtnltyCntry> dmClientMdmNtnltyCntryList = dmClientMdmNtnltyCntryRepository.findAll();
        assertThat(dmClientMdmNtnltyCntryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchDmClientMdmNtnltyCntry() throws Exception {
        int databaseSizeBeforeUpdate = dmClientMdmNtnltyCntryRepository.findAll().size();
        dmClientMdmNtnltyCntry.setId(count.incrementAndGet());

        // Create the DmClientMdmNtnltyCntry
        DmClientMdmNtnltyCntryDTO dmClientMdmNtnltyCntryDTO = dmClientMdmNtnltyCntryMapper.toDto(dmClientMdmNtnltyCntry);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDmClientMdmNtnltyCntryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(dmClientMdmNtnltyCntryDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DmClientMdmNtnltyCntry in the database
        List<DmClientMdmNtnltyCntry> dmClientMdmNtnltyCntryList = dmClientMdmNtnltyCntryRepository.findAll();
        assertThat(dmClientMdmNtnltyCntryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamDmClientMdmNtnltyCntry() throws Exception {
        int databaseSizeBeforeUpdate = dmClientMdmNtnltyCntryRepository.findAll().size();
        dmClientMdmNtnltyCntry.setId(count.incrementAndGet());

        // Create the DmClientMdmNtnltyCntry
        DmClientMdmNtnltyCntryDTO dmClientMdmNtnltyCntryDTO = dmClientMdmNtnltyCntryMapper.toDto(dmClientMdmNtnltyCntry);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDmClientMdmNtnltyCntryMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(dmClientMdmNtnltyCntryDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the DmClientMdmNtnltyCntry in the database
        List<DmClientMdmNtnltyCntry> dmClientMdmNtnltyCntryList = dmClientMdmNtnltyCntryRepository.findAll();
        assertThat(dmClientMdmNtnltyCntryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteDmClientMdmNtnltyCntry() throws Exception {
        // Initialize the database
        dmClientMdmNtnltyCntryRepository.saveAndFlush(dmClientMdmNtnltyCntry);

        int databaseSizeBeforeDelete = dmClientMdmNtnltyCntryRepository.findAll().size();

        // Delete the dmClientMdmNtnltyCntry
        restDmClientMdmNtnltyCntryMockMvc
            .perform(delete(ENTITY_API_URL_ID, dmClientMdmNtnltyCntry.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<DmClientMdmNtnltyCntry> dmClientMdmNtnltyCntryList = dmClientMdmNtnltyCntryRepository.findAll();
        assertThat(dmClientMdmNtnltyCntryList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
