package com.sbm.tableaurealtime.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.sbm.tableaurealtime.IntegrationTest;
import com.sbm.tableaurealtime.domain.DmOResv;
import com.sbm.tableaurealtime.repository.DmOResvRepository;
import com.sbm.tableaurealtime.service.dto.DmOResvDTO;
import com.sbm.tableaurealtime.service.mapper.DmOResvMapper;
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
 * Integration tests for the {@link DmOResvResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class DmOResvResourceIT {

    private static final Integer DEFAULT_NUM_LIGNE = 1;
    private static final Integer UPDATED_NUM_LIGNE = 2;

    private static final String DEFAULT_RESORT = "AAAAAAAAAA";
    private static final String UPDATED_RESORT = "BBBBBBBBBB";

    private static final Integer DEFAULT_RESV_NAME_ID = 1;
    private static final Integer UPDATED_RESV_NAME_ID = 2;

    private static final String DEFAULT_CLIENT_O_ID = "AAAAAAAAAA";
    private static final String UPDATED_CLIENT_O_ID = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE_CHB = "AAAAAAAAAA";
    private static final String UPDATED_TYPE_CHB = "BBBBBBBBBB";

    private static final String DEFAULT_CONFIRMATION_NO = "AAAAAAAAAA";
    private static final String UPDATED_CONFIRMATION_NO = "BBBBBBBBBB";

    private static final String DEFAULT_CLIENT_MDM_ID = "AAAAAAAAAA";
    private static final String UPDATED_CLIENT_MDM_ID = "BBBBBBBBBB";

    private static final Integer DEFAULT_NAME_ID = 1;
    private static final Integer UPDATED_NAME_ID = 2;

    private static final Integer DEFAULT_PARENT_RESV_NAME_ID = 1;
    private static final Integer UPDATED_PARENT_RESV_NAME_ID = 2;

    private static final Integer DEFAULT_CONTACT_ID = 1;
    private static final Integer UPDATED_CONTACT_ID = 2;

    private static final Integer DEFAULT_AGENCE_ID = 1;
    private static final Integer UPDATED_AGENCE_ID = 2;

    private static final String DEFAULT_AGENCE_NOM = "AAAAAAAAAA";
    private static final String UPDATED_AGENCE_NOM = "BBBBBBBBBB";

    private static final Integer DEFAULT_SOCIETE_ID = 1;
    private static final Integer UPDATED_SOCIETE_ID = 2;

    private static final Integer DEFAULT_GROUPE_ID = 1;
    private static final Integer UPDATED_GROUPE_ID = 2;

    private static final Integer DEFAULT_NUM_BLOC = 1;
    private static final Integer UPDATED_NUM_BLOC = 2;

    private static final String DEFAULT_TYPE_RESV = "AAAAAAAAAA";
    private static final String UPDATED_TYPE_RESV = "BBBBBBBBBB";

    private static final String DEFAULT_STATUT_RESV = "AAAAAAAAAA";
    private static final String UPDATED_STATUT_RESV = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE_DEBUT_RESV = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_DEBUT_RESV = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_FIN_RESV = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_FIN_RESV = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_TRUNC_DATE_DEBUT_RESV = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TRUNC_DATE_DEBUT_RESV = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_TRUNC_DATE_FIN_RESV = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TRUNC_DATE_FIN_RESV = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_ANN_RESV = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_ANN_RESV = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_PSEUDO_ROOM_YN = "AAAAAAAAAA";
    private static final String UPDATED_PSEUDO_ROOM_YN = "BBBBBBBBBB";

    private static final Integer DEFAULT_CREATEUR_RESV = 1;
    private static final Integer UPDATED_CREATEUR_RESV = 2;

    private static final String DEFAULT_NOM_CREATEUR_RESV = "AAAAAAAAAA";
    private static final String UPDATED_NOM_CREATEUR_RESV = "BBBBBBBBBB";

    private static final String DEFAULT_CODE_GARANTIE = "AAAAAAAAAA";
    private static final String UPDATED_CODE_GARANTIE = "BBBBBBBBBB";

    private static final String DEFAULT_FLG_DED = "AAAAAAAAAA";
    private static final String UPDATED_FLG_DED = "BBBBBBBBBB";

    private static final String DEFAULT_CODE_PAYS = "AAAAAAAAAA";
    private static final String UPDATED_CODE_PAYS = "BBBBBBBBBB";

    private static final String DEFAULT_LIB_PAYS = "AAAAAAAAAA";
    private static final String UPDATED_LIB_PAYS = "BBBBBBBBBB";

    private static final String DEFAULT_CODE_NATIONALITE = "AAAAAAAAAA";
    private static final String UPDATED_CODE_NATIONALITE = "BBBBBBBBBB";

    private static final String DEFAULT_LIB_NATIONALITE = "AAAAAAAAAA";
    private static final String UPDATED_LIB_NATIONALITE = "BBBBBBBBBB";

    private static final String DEFAULT_CODE_SOURCE = "AAAAAAAAAA";
    private static final String UPDATED_CODE_SOURCE = "BBBBBBBBBB";

    private static final String DEFAULT_LIB_SOURCE = "AAAAAAAAAA";
    private static final String UPDATED_LIB_SOURCE = "BBBBBBBBBB";

    private static final String DEFAULT_CODE_GRAND_SOURCE = "AAAAAAAAAA";
    private static final String UPDATED_CODE_GRAND_SOURCE = "BBBBBBBBBB";

    private static final String DEFAULT_CODE_ORIGINE = "AAAAAAAAAA";
    private static final String UPDATED_CODE_ORIGINE = "BBBBBBBBBB";

    private static final String DEFAULT_LIB_ORIGINE = "AAAAAAAAAA";
    private static final String UPDATED_LIB_ORIGINE = "BBBBBBBBBB";

    private static final String DEFAULT_CODE_MARCHE = "AAAAAAAAAA";
    private static final String UPDATED_CODE_MARCHE = "BBBBBBBBBB";

    private static final String DEFAULT_LIB_MARCHE = "AAAAAAAAAA";
    private static final String UPDATED_LIB_MARCHE = "BBBBBBBBBB";

    private static final String DEFAULT_CODE_GRAND_MARCHE = "AAAAAAAAAA";
    private static final String UPDATED_CODE_GRAND_MARCHE = "BBBBBBBBBB";

    private static final String DEFAULT_LIB_GRAND_MARCHE = "AAAAAAAAAA";
    private static final String UPDATED_LIB_GRAND_MARCHE = "BBBBBBBBBB";

    private static final String DEFAULT_CODE_PRIX = "AAAAAAAAAA";
    private static final String UPDATED_CODE_PRIX = "BBBBBBBBBB";

    private static final String DEFAULT_CATEG_PRIX = "AAAAAAAAAA";
    private static final String UPDATED_CATEG_PRIX = "BBBBBBBBBB";

    private static final String DEFAULT_LIB_PRIX = "AAAAAAAAAA";
    private static final String UPDATED_LIB_PRIX = "BBBBBBBBBB";

    private static final String DEFAULT_NUM_CHB = "AAAAAAAAAA";
    private static final String UPDATED_NUM_CHB = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION_TYPE_CHB = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION_TYPE_CHB = "BBBBBBBBBB";

    private static final String DEFAULT_CODE_TYPE_CHB = "AAAAAAAAAA";
    private static final String UPDATED_CODE_TYPE_CHB = "BBBBBBBBBB";

    private static final String DEFAULT_CLASS_CHB = "AAAAAAAAAA";
    private static final String UPDATED_CLASS_CHB = "BBBBBBBBBB";

    private static final String DEFAULT_CARACT_CHB = "AAAAAAAAAA";
    private static final String UPDATED_CARACT_CHB = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE_CHB_DE_RESERVATION = "AAAAAAAAAA";
    private static final String UPDATED_TYPE_CHB_DE_RESERVATION = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION_TYPE_CHB_DE_RESV = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION_TYPE_CHB_DE_RESV = "BBBBBBBBBB";

    private static final String DEFAULT_CODE_TYPE_CHB_DE_RESV = "AAAAAAAAAA";
    private static final String UPDATED_CODE_TYPE_CHB_DE_RESV = "BBBBBBBBBB";

    private static final String DEFAULT_STATUT_DE_RESERVATION = "AAAAAAAAAA";
    private static final String UPDATED_STATUT_DE_RESERVATION = "BBBBBBBBBB";

    private static final String DEFAULT_CIRCUIT_DISTRIBUTION = "AAAAAAAAAA";
    private static final String UPDATED_CIRCUIT_DISTRIBUTION = "BBBBBBBBBB";

    private static final String DEFAULT_CIRCUIT_DISTRIB_USER_REGROUP = "AAAAAAAAAA";
    private static final String UPDATED_CIRCUIT_DISTRIB_USER_REGROUP = "BBBBBBBBBB";

    private static final String DEFAULT_NUM_CRS = "AAAAAAAAAA";
    private static final String UPDATED_NUM_CRS = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE_REF_CRS = "AAAAAAAAAA";
    private static final String UPDATED_TYPE_REF_CRS = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_CRS_INSERT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CRS_INSERT_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_CREA_RESV = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_CREA_RESV = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_PREMIER = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_PREMIER = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_STATUT_PREMIER = "AAAAAAAAAA";
    private static final String UPDATED_STATUT_PREMIER = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE_DERNIER = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_DERNIER = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_STATUT_DERNIER = "AAAAAAAAAA";
    private static final String UPDATED_STATUT_DERNIER = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE_DERNIER_PSEUDO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_DERNIER_PSEUDO = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_STATUT_DERNIER_PSEUDO = "AAAAAAAAAA";
    private static final String UPDATED_STATUT_DERNIER_PSEUDO = "BBBBBBBBBB";

    private static final Integer DEFAULT_DIFF_DT_CREA_ANN = 1;
    private static final Integer UPDATED_DIFF_DT_CREA_ANN = 2;

    private static final Integer DEFAULT_DIFF_DT_ARR_ANN = 1;
    private static final Integer UPDATED_DIFF_DT_ARR_ANN = 2;

    private static final Integer DEFAULT_LEADTIME = 1;
    private static final Integer UPDATED_LEADTIME = 2;

    private static final Integer DEFAULT_LOS = 1;
    private static final Integer UPDATED_LOS = 2;

    private static final String DEFAULT_OCCUPANTS_GROUPE = "AAAAAAAAAA";
    private static final String UPDATED_OCCUPANTS_GROUPE = "BBBBBBBBBB";

    private static final Integer DEFAULT_NB_NUITEE = 1;
    private static final Integer UPDATED_NB_NUITEE = 2;

    private static final Integer DEFAULT_NB_NUITEE_NN_DED = 1;
    private static final Integer UPDATED_NB_NUITEE_NN_DED = 2;

    private static final Integer DEFAULT_NB_RESV_ANN = 1;
    private static final Integer UPDATED_NB_RESV_ANN = 2;

    private static final Integer DEFAULT_NB_ADU = 1;
    private static final Integer UPDATED_NB_ADU = 2;

    private static final Integer DEFAULT_NB_ENF = 1;
    private static final Integer UPDATED_NB_ENF = 2;

    private static final Integer DEFAULT_NB_PERS_DAY_U = 1;
    private static final Integer UPDATED_NB_PERS_DAY_U = 2;

    private static final Integer DEFAULT_NB_PERS_ARR = 1;
    private static final Integer UPDATED_NB_PERS_ARR = 2;

    private static final Integer DEFAULT_NB_PERS_DEP = 1;
    private static final Integer UPDATED_NB_PERS_DEP = 2;

    private static final Integer DEFAULT_NB_PERS_ANN = 1;
    private static final Integer UPDATED_NB_PERS_ANN = 2;

    private static final Integer DEFAULT_NB_PERS_NOSHOW = 1;
    private static final Integer UPDATED_NB_PERS_NOSHOW = 2;

    private static final Integer DEFAULT_NB_CHB_DAY_U = 1;
    private static final Integer UPDATED_NB_CHB_DAY_U = 2;

    private static final Integer DEFAULT_NB_CHB_ARR = 1;
    private static final Integer UPDATED_NB_CHB_ARR = 2;

    private static final Integer DEFAULT_NB_CHB_DEP = 1;
    private static final Integer UPDATED_NB_CHB_DEP = 2;

    private static final Integer DEFAULT_NB_CHB_ANN = 1;
    private static final Integer UPDATED_NB_CHB_ANN = 2;

    private static final Integer DEFAULT_NB_CHB_NOSHOW = 1;
    private static final Integer UPDATED_NB_CHB_NOSHOW = 2;

    private static final Long DEFAULT_REVENU_NET_CHAMBRE = 1L;
    private static final Long UPDATED_REVENU_NET_CHAMBRE = 2L;

    private static final Long DEFAULT_REVENU_TAXE_CHAMBRE = 1L;
    private static final Long UPDATED_REVENU_TAXE_CHAMBRE = 2L;

    private static final Long DEFAULT_REVENU_NET_CHAMBRE_GLOBAL = 1L;
    private static final Long UPDATED_REVENU_NET_CHAMBRE_GLOBAL = 2L;

    private static final Long DEFAULT_REVENU_TAXE_CHAMBRE_GLOBAL = 1L;
    private static final Long UPDATED_REVENU_TAXE_CHAMBRE_GLOBAL = 2L;

    private static final Long DEFAULT_REVENU_NET_BQ = 1L;
    private static final Long UPDATED_REVENU_NET_BQ = 2L;

    private static final Long DEFAULT_REVENU_TAXE_BQ = 1L;
    private static final Long UPDATED_REVENU_TAXE_BQ = 2L;

    private static final Long DEFAULT_REVENU_NET_BQ_GLOBAL = 1L;
    private static final Long UPDATED_REVENU_NET_BQ_GLOBAL = 2L;

    private static final Long DEFAULT_REVENU_TAXE_BQ_GLOBAL = 1L;
    private static final Long UPDATED_REVENU_TAXE_BQ_GLOBAL = 2L;

    private static final Long DEFAULT_REVENU_NET_EXTRA = 1L;
    private static final Long UPDATED_REVENU_NET_EXTRA = 2L;

    private static final Long DEFAULT_REVENU_TAXE_EXTRA = 1L;
    private static final Long UPDATED_REVENU_TAXE_EXTRA = 2L;

    private static final Long DEFAULT_REVENU_NET_EXTRA_GLOBAL = 1L;
    private static final Long UPDATED_REVENU_NET_EXTRA_GLOBAL = 2L;

    private static final Long DEFAULT_REVENU_TAXE_EXTRA_GLOBAL = 1L;
    private static final Long UPDATED_REVENU_TAXE_EXTRA_GLOBAL = 2L;

    private static final Long DEFAULT_REVENU_NET_TOTAL = 1L;
    private static final Long UPDATED_REVENU_NET_TOTAL = 2L;

    private static final Long DEFAULT_REVENU_TAXE_TOTAL = 1L;
    private static final Long UPDATED_REVENU_TAXE_TOTAL = 2L;

    private static final Long DEFAULT_REVENU_NET_TOTAL_GLOBAL = 1L;
    private static final Long UPDATED_REVENU_NET_TOTAL_GLOBAL = 2L;

    private static final Long DEFAULT_REVENU_TAXE_TOTAL_GLOBAL = 1L;
    private static final Long UPDATED_REVENU_TAXE_TOTAL_GLOBAL = 2L;

    private static final Long DEFAULT_PROD_REVENU_CHAMBRE = 1L;
    private static final Long UPDATED_PROD_REVENU_CHAMBRE = 2L;

    private static final Long DEFAULT_PROD_REVENU_BQ = 1L;
    private static final Long UPDATED_PROD_REVENU_BQ = 2L;

    private static final Long DEFAULT_PROD_REVENU_EXTRA = 1L;
    private static final Long UPDATED_PROD_REVENU_EXTRA = 2L;

    private static final Long DEFAULT_PROD_REVENU_TOTAL = 1L;
    private static final Long UPDATED_PROD_REVENU_TOTAL = 2L;

    private static final Long DEFAULT_PROD_CHAMBRE_NB_NUITEES = 1L;
    private static final Long UPDATED_PROD_CHAMBRE_NB_NUITEES = 2L;

    private static final LocalDate DEFAULT_TECH_CREATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TECH_CREATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_TECH_UPDATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TECH_UPDATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String ENTITY_API_URL = "/api/dm-o-resvs";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private DmOResvRepository dmOResvRepository;

    @Autowired
    private DmOResvMapper dmOResvMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDmOResvMockMvc;

    private DmOResv dmOResv;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DmOResv createEntity(EntityManager em) {
        DmOResv dmOResv = new DmOResv()
            .numLigne(DEFAULT_NUM_LIGNE)
            .resort(DEFAULT_RESORT)
            .resvNameId(DEFAULT_RESV_NAME_ID)
            .clientOId(DEFAULT_CLIENT_O_ID)
            .typeChb(DEFAULT_TYPE_CHB)
            .confirmationNo(DEFAULT_CONFIRMATION_NO)
            .clientMdmId(DEFAULT_CLIENT_MDM_ID)
            .nameId(DEFAULT_NAME_ID)
            .parentResvNameId(DEFAULT_PARENT_RESV_NAME_ID)
            .contactId(DEFAULT_CONTACT_ID)
            .agenceId(DEFAULT_AGENCE_ID)
            .agenceNom(DEFAULT_AGENCE_NOM)
            .societeId(DEFAULT_SOCIETE_ID)
            .groupeId(DEFAULT_GROUPE_ID)
            .numBloc(DEFAULT_NUM_BLOC)
            .typeResv(DEFAULT_TYPE_RESV)
            .statutResv(DEFAULT_STATUT_RESV)
            .dateDebutResv(DEFAULT_DATE_DEBUT_RESV)
            .dateFinResv(DEFAULT_DATE_FIN_RESV)
            .truncDateDebutResv(DEFAULT_TRUNC_DATE_DEBUT_RESV)
            .truncDateFinResv(DEFAULT_TRUNC_DATE_FIN_RESV)
            .dateAnnResv(DEFAULT_DATE_ANN_RESV)
            .pseudoRoomYn(DEFAULT_PSEUDO_ROOM_YN)
            .createurResv(DEFAULT_CREATEUR_RESV)
            .nomCreateurResv(DEFAULT_NOM_CREATEUR_RESV)
            .codeGarantie(DEFAULT_CODE_GARANTIE)
            .flgDed(DEFAULT_FLG_DED)
            .codePays(DEFAULT_CODE_PAYS)
            .libPays(DEFAULT_LIB_PAYS)
            .codeNationalite(DEFAULT_CODE_NATIONALITE)
            .libNationalite(DEFAULT_LIB_NATIONALITE)
            .codeSource(DEFAULT_CODE_SOURCE)
            .libSource(DEFAULT_LIB_SOURCE)
            .codeGrandSource(DEFAULT_CODE_GRAND_SOURCE)
            .codeOrigine(DEFAULT_CODE_ORIGINE)
            .libOrigine(DEFAULT_LIB_ORIGINE)
            .codeMarche(DEFAULT_CODE_MARCHE)
            .libMarche(DEFAULT_LIB_MARCHE)
            .codeGrandMarche(DEFAULT_CODE_GRAND_MARCHE)
            .libGrandMarche(DEFAULT_LIB_GRAND_MARCHE)
            .codePrix(DEFAULT_CODE_PRIX)
            .categPrix(DEFAULT_CATEG_PRIX)
            .libPrix(DEFAULT_LIB_PRIX)
            .numChb(DEFAULT_NUM_CHB)
            .descriptionTypeChb(DEFAULT_DESCRIPTION_TYPE_CHB)
            .codeTypeChb(DEFAULT_CODE_TYPE_CHB)
            .classChb(DEFAULT_CLASS_CHB)
            .caractChb(DEFAULT_CARACT_CHB)
            .typeChbDeReservation(DEFAULT_TYPE_CHB_DE_RESERVATION)
            .descriptionTypeChbDeResv(DEFAULT_DESCRIPTION_TYPE_CHB_DE_RESV)
            .codeTypeChbDeResv(DEFAULT_CODE_TYPE_CHB_DE_RESV)
            .statutDeReservation(DEFAULT_STATUT_DE_RESERVATION)
            .circuitDistribution(DEFAULT_CIRCUIT_DISTRIBUTION)
            .circuitDistribUserRegroup(DEFAULT_CIRCUIT_DISTRIB_USER_REGROUP)
            .numCrs(DEFAULT_NUM_CRS)
            .typeRefCrs(DEFAULT_TYPE_REF_CRS)
            .crsInsertDate(DEFAULT_CRS_INSERT_DATE)
            .dateCreaResv(DEFAULT_DATE_CREA_RESV)
            .datePremier(DEFAULT_DATE_PREMIER)
            .statutPremier(DEFAULT_STATUT_PREMIER)
            .dateDernier(DEFAULT_DATE_DERNIER)
            .statutDernier(DEFAULT_STATUT_DERNIER)
            .dateDernierPseudo(DEFAULT_DATE_DERNIER_PSEUDO)
            .statutDernierPseudo(DEFAULT_STATUT_DERNIER_PSEUDO)
            .diffDtCreaAnn(DEFAULT_DIFF_DT_CREA_ANN)
            .diffDtArrAnn(DEFAULT_DIFF_DT_ARR_ANN)
            .leadtime(DEFAULT_LEADTIME)
            .los(DEFAULT_LOS)
            .occupantsGroupe(DEFAULT_OCCUPANTS_GROUPE)
            .nbNuitee(DEFAULT_NB_NUITEE)
            .nbNuiteeNnDed(DEFAULT_NB_NUITEE_NN_DED)
            .nbResvAnn(DEFAULT_NB_RESV_ANN)
            .nbAdu(DEFAULT_NB_ADU)
            .nbEnf(DEFAULT_NB_ENF)
            .nbPersDayU(DEFAULT_NB_PERS_DAY_U)
            .nbPersArr(DEFAULT_NB_PERS_ARR)
            .nbPersDep(DEFAULT_NB_PERS_DEP)
            .nbPersAnn(DEFAULT_NB_PERS_ANN)
            .nbPersNoshow(DEFAULT_NB_PERS_NOSHOW)
            .nbChbDayU(DEFAULT_NB_CHB_DAY_U)
            .nbChbArr(DEFAULT_NB_CHB_ARR)
            .nbChbDep(DEFAULT_NB_CHB_DEP)
            .nbChbAnn(DEFAULT_NB_CHB_ANN)
            .nbChbNoshow(DEFAULT_NB_CHB_NOSHOW)
            .revenuNetChambre(DEFAULT_REVENU_NET_CHAMBRE)
            .revenuTaxeChambre(DEFAULT_REVENU_TAXE_CHAMBRE)
            .revenuNetChambreGlobal(DEFAULT_REVENU_NET_CHAMBRE_GLOBAL)
            .revenuTaxeChambreGlobal(DEFAULT_REVENU_TAXE_CHAMBRE_GLOBAL)
            .revenuNetBq(DEFAULT_REVENU_NET_BQ)
            .revenuTaxeBq(DEFAULT_REVENU_TAXE_BQ)
            .revenuNetBqGlobal(DEFAULT_REVENU_NET_BQ_GLOBAL)
            .revenuTaxeBqGlobal(DEFAULT_REVENU_TAXE_BQ_GLOBAL)
            .revenuNetExtra(DEFAULT_REVENU_NET_EXTRA)
            .revenuTaxeExtra(DEFAULT_REVENU_TAXE_EXTRA)
            .revenuNetExtraGlobal(DEFAULT_REVENU_NET_EXTRA_GLOBAL)
            .revenuTaxeExtraGlobal(DEFAULT_REVENU_TAXE_EXTRA_GLOBAL)
            .revenuNetTotal(DEFAULT_REVENU_NET_TOTAL)
            .revenuTaxeTotal(DEFAULT_REVENU_TAXE_TOTAL)
            .revenuNetTotalGlobal(DEFAULT_REVENU_NET_TOTAL_GLOBAL)
            .revenuTaxeTotalGlobal(DEFAULT_REVENU_TAXE_TOTAL_GLOBAL)
            .prodRevenuChambre(DEFAULT_PROD_REVENU_CHAMBRE)
            .prodRevenuBq(DEFAULT_PROD_REVENU_BQ)
            .prodRevenuExtra(DEFAULT_PROD_REVENU_EXTRA)
            .prodRevenuTotal(DEFAULT_PROD_REVENU_TOTAL)
            .prodChambreNbNuitees(DEFAULT_PROD_CHAMBRE_NB_NUITEES)
            .techCreateDate(DEFAULT_TECH_CREATE_DATE)
            .techUpdateDate(DEFAULT_TECH_UPDATE_DATE);
        return dmOResv;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DmOResv createUpdatedEntity(EntityManager em) {
        DmOResv dmOResv = new DmOResv()
            .numLigne(UPDATED_NUM_LIGNE)
            .resort(UPDATED_RESORT)
            .resvNameId(UPDATED_RESV_NAME_ID)
            .clientOId(UPDATED_CLIENT_O_ID)
            .typeChb(UPDATED_TYPE_CHB)
            .confirmationNo(UPDATED_CONFIRMATION_NO)
            .clientMdmId(UPDATED_CLIENT_MDM_ID)
            .nameId(UPDATED_NAME_ID)
            .parentResvNameId(UPDATED_PARENT_RESV_NAME_ID)
            .contactId(UPDATED_CONTACT_ID)
            .agenceId(UPDATED_AGENCE_ID)
            .agenceNom(UPDATED_AGENCE_NOM)
            .societeId(UPDATED_SOCIETE_ID)
            .groupeId(UPDATED_GROUPE_ID)
            .numBloc(UPDATED_NUM_BLOC)
            .typeResv(UPDATED_TYPE_RESV)
            .statutResv(UPDATED_STATUT_RESV)
            .dateDebutResv(UPDATED_DATE_DEBUT_RESV)
            .dateFinResv(UPDATED_DATE_FIN_RESV)
            .truncDateDebutResv(UPDATED_TRUNC_DATE_DEBUT_RESV)
            .truncDateFinResv(UPDATED_TRUNC_DATE_FIN_RESV)
            .dateAnnResv(UPDATED_DATE_ANN_RESV)
            .pseudoRoomYn(UPDATED_PSEUDO_ROOM_YN)
            .createurResv(UPDATED_CREATEUR_RESV)
            .nomCreateurResv(UPDATED_NOM_CREATEUR_RESV)
            .codeGarantie(UPDATED_CODE_GARANTIE)
            .flgDed(UPDATED_FLG_DED)
            .codePays(UPDATED_CODE_PAYS)
            .libPays(UPDATED_LIB_PAYS)
            .codeNationalite(UPDATED_CODE_NATIONALITE)
            .libNationalite(UPDATED_LIB_NATIONALITE)
            .codeSource(UPDATED_CODE_SOURCE)
            .libSource(UPDATED_LIB_SOURCE)
            .codeGrandSource(UPDATED_CODE_GRAND_SOURCE)
            .codeOrigine(UPDATED_CODE_ORIGINE)
            .libOrigine(UPDATED_LIB_ORIGINE)
            .codeMarche(UPDATED_CODE_MARCHE)
            .libMarche(UPDATED_LIB_MARCHE)
            .codeGrandMarche(UPDATED_CODE_GRAND_MARCHE)
            .libGrandMarche(UPDATED_LIB_GRAND_MARCHE)
            .codePrix(UPDATED_CODE_PRIX)
            .categPrix(UPDATED_CATEG_PRIX)
            .libPrix(UPDATED_LIB_PRIX)
            .numChb(UPDATED_NUM_CHB)
            .descriptionTypeChb(UPDATED_DESCRIPTION_TYPE_CHB)
            .codeTypeChb(UPDATED_CODE_TYPE_CHB)
            .classChb(UPDATED_CLASS_CHB)
            .caractChb(UPDATED_CARACT_CHB)
            .typeChbDeReservation(UPDATED_TYPE_CHB_DE_RESERVATION)
            .descriptionTypeChbDeResv(UPDATED_DESCRIPTION_TYPE_CHB_DE_RESV)
            .codeTypeChbDeResv(UPDATED_CODE_TYPE_CHB_DE_RESV)
            .statutDeReservation(UPDATED_STATUT_DE_RESERVATION)
            .circuitDistribution(UPDATED_CIRCUIT_DISTRIBUTION)
            .circuitDistribUserRegroup(UPDATED_CIRCUIT_DISTRIB_USER_REGROUP)
            .numCrs(UPDATED_NUM_CRS)
            .typeRefCrs(UPDATED_TYPE_REF_CRS)
            .crsInsertDate(UPDATED_CRS_INSERT_DATE)
            .dateCreaResv(UPDATED_DATE_CREA_RESV)
            .datePremier(UPDATED_DATE_PREMIER)
            .statutPremier(UPDATED_STATUT_PREMIER)
            .dateDernier(UPDATED_DATE_DERNIER)
            .statutDernier(UPDATED_STATUT_DERNIER)
            .dateDernierPseudo(UPDATED_DATE_DERNIER_PSEUDO)
            .statutDernierPseudo(UPDATED_STATUT_DERNIER_PSEUDO)
            .diffDtCreaAnn(UPDATED_DIFF_DT_CREA_ANN)
            .diffDtArrAnn(UPDATED_DIFF_DT_ARR_ANN)
            .leadtime(UPDATED_LEADTIME)
            .los(UPDATED_LOS)
            .occupantsGroupe(UPDATED_OCCUPANTS_GROUPE)
            .nbNuitee(UPDATED_NB_NUITEE)
            .nbNuiteeNnDed(UPDATED_NB_NUITEE_NN_DED)
            .nbResvAnn(UPDATED_NB_RESV_ANN)
            .nbAdu(UPDATED_NB_ADU)
            .nbEnf(UPDATED_NB_ENF)
            .nbPersDayU(UPDATED_NB_PERS_DAY_U)
            .nbPersArr(UPDATED_NB_PERS_ARR)
            .nbPersDep(UPDATED_NB_PERS_DEP)
            .nbPersAnn(UPDATED_NB_PERS_ANN)
            .nbPersNoshow(UPDATED_NB_PERS_NOSHOW)
            .nbChbDayU(UPDATED_NB_CHB_DAY_U)
            .nbChbArr(UPDATED_NB_CHB_ARR)
            .nbChbDep(UPDATED_NB_CHB_DEP)
            .nbChbAnn(UPDATED_NB_CHB_ANN)
            .nbChbNoshow(UPDATED_NB_CHB_NOSHOW)
            .revenuNetChambre(UPDATED_REVENU_NET_CHAMBRE)
            .revenuTaxeChambre(UPDATED_REVENU_TAXE_CHAMBRE)
            .revenuNetChambreGlobal(UPDATED_REVENU_NET_CHAMBRE_GLOBAL)
            .revenuTaxeChambreGlobal(UPDATED_REVENU_TAXE_CHAMBRE_GLOBAL)
            .revenuNetBq(UPDATED_REVENU_NET_BQ)
            .revenuTaxeBq(UPDATED_REVENU_TAXE_BQ)
            .revenuNetBqGlobal(UPDATED_REVENU_NET_BQ_GLOBAL)
            .revenuTaxeBqGlobal(UPDATED_REVENU_TAXE_BQ_GLOBAL)
            .revenuNetExtra(UPDATED_REVENU_NET_EXTRA)
            .revenuTaxeExtra(UPDATED_REVENU_TAXE_EXTRA)
            .revenuNetExtraGlobal(UPDATED_REVENU_NET_EXTRA_GLOBAL)
            .revenuTaxeExtraGlobal(UPDATED_REVENU_TAXE_EXTRA_GLOBAL)
            .revenuNetTotal(UPDATED_REVENU_NET_TOTAL)
            .revenuTaxeTotal(UPDATED_REVENU_TAXE_TOTAL)
            .revenuNetTotalGlobal(UPDATED_REVENU_NET_TOTAL_GLOBAL)
            .revenuTaxeTotalGlobal(UPDATED_REVENU_TAXE_TOTAL_GLOBAL)
            .prodRevenuChambre(UPDATED_PROD_REVENU_CHAMBRE)
            .prodRevenuBq(UPDATED_PROD_REVENU_BQ)
            .prodRevenuExtra(UPDATED_PROD_REVENU_EXTRA)
            .prodRevenuTotal(UPDATED_PROD_REVENU_TOTAL)
            .prodChambreNbNuitees(UPDATED_PROD_CHAMBRE_NB_NUITEES)
            .techCreateDate(UPDATED_TECH_CREATE_DATE)
            .techUpdateDate(UPDATED_TECH_UPDATE_DATE);
        return dmOResv;
    }

    @BeforeEach
    public void initTest() {
        dmOResv = createEntity(em);
    }

    @Test
    @Transactional
    void createDmOResv() throws Exception {
        int databaseSizeBeforeCreate = dmOResvRepository.findAll().size();
        // Create the DmOResv
        DmOResvDTO dmOResvDTO = dmOResvMapper.toDto(dmOResv);
        restDmOResvMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(dmOResvDTO)))
            .andExpect(status().isCreated());

        // Validate the DmOResv in the database
        List<DmOResv> dmOResvList = dmOResvRepository.findAll();
        assertThat(dmOResvList).hasSize(databaseSizeBeforeCreate + 1);
        DmOResv testDmOResv = dmOResvList.get(dmOResvList.size() - 1);
        assertThat(testDmOResv.getNumLigne()).isEqualTo(DEFAULT_NUM_LIGNE);
        assertThat(testDmOResv.getResort()).isEqualTo(DEFAULT_RESORT);
        assertThat(testDmOResv.getResvNameId()).isEqualTo(DEFAULT_RESV_NAME_ID);
        assertThat(testDmOResv.getClientOId()).isEqualTo(DEFAULT_CLIENT_O_ID);
        assertThat(testDmOResv.getTypeChb()).isEqualTo(DEFAULT_TYPE_CHB);
        assertThat(testDmOResv.getConfirmationNo()).isEqualTo(DEFAULT_CONFIRMATION_NO);
        assertThat(testDmOResv.getClientMdmId()).isEqualTo(DEFAULT_CLIENT_MDM_ID);
        assertThat(testDmOResv.getNameId()).isEqualTo(DEFAULT_NAME_ID);
        assertThat(testDmOResv.getParentResvNameId()).isEqualTo(DEFAULT_PARENT_RESV_NAME_ID);
        assertThat(testDmOResv.getContactId()).isEqualTo(DEFAULT_CONTACT_ID);
        assertThat(testDmOResv.getAgenceId()).isEqualTo(DEFAULT_AGENCE_ID);
        assertThat(testDmOResv.getAgenceNom()).isEqualTo(DEFAULT_AGENCE_NOM);
        assertThat(testDmOResv.getSocieteId()).isEqualTo(DEFAULT_SOCIETE_ID);
        assertThat(testDmOResv.getGroupeId()).isEqualTo(DEFAULT_GROUPE_ID);
        assertThat(testDmOResv.getNumBloc()).isEqualTo(DEFAULT_NUM_BLOC);
        assertThat(testDmOResv.getTypeResv()).isEqualTo(DEFAULT_TYPE_RESV);
        assertThat(testDmOResv.getStatutResv()).isEqualTo(DEFAULT_STATUT_RESV);
        assertThat(testDmOResv.getDateDebutResv()).isEqualTo(DEFAULT_DATE_DEBUT_RESV);
        assertThat(testDmOResv.getDateFinResv()).isEqualTo(DEFAULT_DATE_FIN_RESV);
        assertThat(testDmOResv.getTruncDateDebutResv()).isEqualTo(DEFAULT_TRUNC_DATE_DEBUT_RESV);
        assertThat(testDmOResv.getTruncDateFinResv()).isEqualTo(DEFAULT_TRUNC_DATE_FIN_RESV);
        assertThat(testDmOResv.getDateAnnResv()).isEqualTo(DEFAULT_DATE_ANN_RESV);
        assertThat(testDmOResv.getPseudoRoomYn()).isEqualTo(DEFAULT_PSEUDO_ROOM_YN);
        assertThat(testDmOResv.getCreateurResv()).isEqualTo(DEFAULT_CREATEUR_RESV);
        assertThat(testDmOResv.getNomCreateurResv()).isEqualTo(DEFAULT_NOM_CREATEUR_RESV);
        assertThat(testDmOResv.getCodeGarantie()).isEqualTo(DEFAULT_CODE_GARANTIE);
        assertThat(testDmOResv.getFlgDed()).isEqualTo(DEFAULT_FLG_DED);
        assertThat(testDmOResv.getCodePays()).isEqualTo(DEFAULT_CODE_PAYS);
        assertThat(testDmOResv.getLibPays()).isEqualTo(DEFAULT_LIB_PAYS);
        assertThat(testDmOResv.getCodeNationalite()).isEqualTo(DEFAULT_CODE_NATIONALITE);
        assertThat(testDmOResv.getLibNationalite()).isEqualTo(DEFAULT_LIB_NATIONALITE);
        assertThat(testDmOResv.getCodeSource()).isEqualTo(DEFAULT_CODE_SOURCE);
        assertThat(testDmOResv.getLibSource()).isEqualTo(DEFAULT_LIB_SOURCE);
        assertThat(testDmOResv.getCodeGrandSource()).isEqualTo(DEFAULT_CODE_GRAND_SOURCE);
        assertThat(testDmOResv.getCodeOrigine()).isEqualTo(DEFAULT_CODE_ORIGINE);
        assertThat(testDmOResv.getLibOrigine()).isEqualTo(DEFAULT_LIB_ORIGINE);
        assertThat(testDmOResv.getCodeMarche()).isEqualTo(DEFAULT_CODE_MARCHE);
        assertThat(testDmOResv.getLibMarche()).isEqualTo(DEFAULT_LIB_MARCHE);
        assertThat(testDmOResv.getCodeGrandMarche()).isEqualTo(DEFAULT_CODE_GRAND_MARCHE);
        assertThat(testDmOResv.getLibGrandMarche()).isEqualTo(DEFAULT_LIB_GRAND_MARCHE);
        assertThat(testDmOResv.getCodePrix()).isEqualTo(DEFAULT_CODE_PRIX);
        assertThat(testDmOResv.getCategPrix()).isEqualTo(DEFAULT_CATEG_PRIX);
        assertThat(testDmOResv.getLibPrix()).isEqualTo(DEFAULT_LIB_PRIX);
        assertThat(testDmOResv.getNumChb()).isEqualTo(DEFAULT_NUM_CHB);
        assertThat(testDmOResv.getDescriptionTypeChb()).isEqualTo(DEFAULT_DESCRIPTION_TYPE_CHB);
        assertThat(testDmOResv.getCodeTypeChb()).isEqualTo(DEFAULT_CODE_TYPE_CHB);
        assertThat(testDmOResv.getClassChb()).isEqualTo(DEFAULT_CLASS_CHB);
        assertThat(testDmOResv.getCaractChb()).isEqualTo(DEFAULT_CARACT_CHB);
        assertThat(testDmOResv.getTypeChbDeReservation()).isEqualTo(DEFAULT_TYPE_CHB_DE_RESERVATION);
        assertThat(testDmOResv.getDescriptionTypeChbDeResv()).isEqualTo(DEFAULT_DESCRIPTION_TYPE_CHB_DE_RESV);
        assertThat(testDmOResv.getCodeTypeChbDeResv()).isEqualTo(DEFAULT_CODE_TYPE_CHB_DE_RESV);
        assertThat(testDmOResv.getStatutDeReservation()).isEqualTo(DEFAULT_STATUT_DE_RESERVATION);
        assertThat(testDmOResv.getCircuitDistribution()).isEqualTo(DEFAULT_CIRCUIT_DISTRIBUTION);
        assertThat(testDmOResv.getCircuitDistribUserRegroup()).isEqualTo(DEFAULT_CIRCUIT_DISTRIB_USER_REGROUP);
        assertThat(testDmOResv.getNumCrs()).isEqualTo(DEFAULT_NUM_CRS);
        assertThat(testDmOResv.getTypeRefCrs()).isEqualTo(DEFAULT_TYPE_REF_CRS);
        assertThat(testDmOResv.getCrsInsertDate()).isEqualTo(DEFAULT_CRS_INSERT_DATE);
        assertThat(testDmOResv.getDateCreaResv()).isEqualTo(DEFAULT_DATE_CREA_RESV);
        assertThat(testDmOResv.getDatePremier()).isEqualTo(DEFAULT_DATE_PREMIER);
        assertThat(testDmOResv.getStatutPremier()).isEqualTo(DEFAULT_STATUT_PREMIER);
        assertThat(testDmOResv.getDateDernier()).isEqualTo(DEFAULT_DATE_DERNIER);
        assertThat(testDmOResv.getStatutDernier()).isEqualTo(DEFAULT_STATUT_DERNIER);
        assertThat(testDmOResv.getDateDernierPseudo()).isEqualTo(DEFAULT_DATE_DERNIER_PSEUDO);
        assertThat(testDmOResv.getStatutDernierPseudo()).isEqualTo(DEFAULT_STATUT_DERNIER_PSEUDO);
        assertThat(testDmOResv.getDiffDtCreaAnn()).isEqualTo(DEFAULT_DIFF_DT_CREA_ANN);
        assertThat(testDmOResv.getDiffDtArrAnn()).isEqualTo(DEFAULT_DIFF_DT_ARR_ANN);
        assertThat(testDmOResv.getLeadtime()).isEqualTo(DEFAULT_LEADTIME);
        assertThat(testDmOResv.getLos()).isEqualTo(DEFAULT_LOS);
        assertThat(testDmOResv.getOccupantsGroupe()).isEqualTo(DEFAULT_OCCUPANTS_GROUPE);
        assertThat(testDmOResv.getNbNuitee()).isEqualTo(DEFAULT_NB_NUITEE);
        assertThat(testDmOResv.getNbNuiteeNnDed()).isEqualTo(DEFAULT_NB_NUITEE_NN_DED);
        assertThat(testDmOResv.getNbResvAnn()).isEqualTo(DEFAULT_NB_RESV_ANN);
        assertThat(testDmOResv.getNbAdu()).isEqualTo(DEFAULT_NB_ADU);
        assertThat(testDmOResv.getNbEnf()).isEqualTo(DEFAULT_NB_ENF);
        assertThat(testDmOResv.getNbPersDayU()).isEqualTo(DEFAULT_NB_PERS_DAY_U);
        assertThat(testDmOResv.getNbPersArr()).isEqualTo(DEFAULT_NB_PERS_ARR);
        assertThat(testDmOResv.getNbPersDep()).isEqualTo(DEFAULT_NB_PERS_DEP);
        assertThat(testDmOResv.getNbPersAnn()).isEqualTo(DEFAULT_NB_PERS_ANN);
        assertThat(testDmOResv.getNbPersNoshow()).isEqualTo(DEFAULT_NB_PERS_NOSHOW);
        assertThat(testDmOResv.getNbChbDayU()).isEqualTo(DEFAULT_NB_CHB_DAY_U);
        assertThat(testDmOResv.getNbChbArr()).isEqualTo(DEFAULT_NB_CHB_ARR);
        assertThat(testDmOResv.getNbChbDep()).isEqualTo(DEFAULT_NB_CHB_DEP);
        assertThat(testDmOResv.getNbChbAnn()).isEqualTo(DEFAULT_NB_CHB_ANN);
        assertThat(testDmOResv.getNbChbNoshow()).isEqualTo(DEFAULT_NB_CHB_NOSHOW);
        assertThat(testDmOResv.getRevenuNetChambre()).isEqualTo(DEFAULT_REVENU_NET_CHAMBRE);
        assertThat(testDmOResv.getRevenuTaxeChambre()).isEqualTo(DEFAULT_REVENU_TAXE_CHAMBRE);
        assertThat(testDmOResv.getRevenuNetChambreGlobal()).isEqualTo(DEFAULT_REVENU_NET_CHAMBRE_GLOBAL);
        assertThat(testDmOResv.getRevenuTaxeChambreGlobal()).isEqualTo(DEFAULT_REVENU_TAXE_CHAMBRE_GLOBAL);
        assertThat(testDmOResv.getRevenuNetBq()).isEqualTo(DEFAULT_REVENU_NET_BQ);
        assertThat(testDmOResv.getRevenuTaxeBq()).isEqualTo(DEFAULT_REVENU_TAXE_BQ);
        assertThat(testDmOResv.getRevenuNetBqGlobal()).isEqualTo(DEFAULT_REVENU_NET_BQ_GLOBAL);
        assertThat(testDmOResv.getRevenuTaxeBqGlobal()).isEqualTo(DEFAULT_REVENU_TAXE_BQ_GLOBAL);
        assertThat(testDmOResv.getRevenuNetExtra()).isEqualTo(DEFAULT_REVENU_NET_EXTRA);
        assertThat(testDmOResv.getRevenuTaxeExtra()).isEqualTo(DEFAULT_REVENU_TAXE_EXTRA);
        assertThat(testDmOResv.getRevenuNetExtraGlobal()).isEqualTo(DEFAULT_REVENU_NET_EXTRA_GLOBAL);
        assertThat(testDmOResv.getRevenuTaxeExtraGlobal()).isEqualTo(DEFAULT_REVENU_TAXE_EXTRA_GLOBAL);
        assertThat(testDmOResv.getRevenuNetTotal()).isEqualTo(DEFAULT_REVENU_NET_TOTAL);
        assertThat(testDmOResv.getRevenuTaxeTotal()).isEqualTo(DEFAULT_REVENU_TAXE_TOTAL);
        assertThat(testDmOResv.getRevenuNetTotalGlobal()).isEqualTo(DEFAULT_REVENU_NET_TOTAL_GLOBAL);
        assertThat(testDmOResv.getRevenuTaxeTotalGlobal()).isEqualTo(DEFAULT_REVENU_TAXE_TOTAL_GLOBAL);
        assertThat(testDmOResv.getProdRevenuChambre()).isEqualTo(DEFAULT_PROD_REVENU_CHAMBRE);
        assertThat(testDmOResv.getProdRevenuBq()).isEqualTo(DEFAULT_PROD_REVENU_BQ);
        assertThat(testDmOResv.getProdRevenuExtra()).isEqualTo(DEFAULT_PROD_REVENU_EXTRA);
        assertThat(testDmOResv.getProdRevenuTotal()).isEqualTo(DEFAULT_PROD_REVENU_TOTAL);
        assertThat(testDmOResv.getProdChambreNbNuitees()).isEqualTo(DEFAULT_PROD_CHAMBRE_NB_NUITEES);
        assertThat(testDmOResv.getTechCreateDate()).isEqualTo(DEFAULT_TECH_CREATE_DATE);
        assertThat(testDmOResv.getTechUpdateDate()).isEqualTo(DEFAULT_TECH_UPDATE_DATE);
    }

    @Test
    @Transactional
    void createDmOResvWithExistingId() throws Exception {
        // Create the DmOResv with an existing ID
        dmOResv.setId(1L);
        DmOResvDTO dmOResvDTO = dmOResvMapper.toDto(dmOResv);

        int databaseSizeBeforeCreate = dmOResvRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restDmOResvMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(dmOResvDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DmOResv in the database
        List<DmOResv> dmOResvList = dmOResvRepository.findAll();
        assertThat(dmOResvList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllDmOResvs() throws Exception {
        // Initialize the database
        dmOResvRepository.saveAndFlush(dmOResv);

        // Get all the dmOResvList
        restDmOResvMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dmOResv.getId().intValue())))
            .andExpect(jsonPath("$.[*].numLigne").value(hasItem(DEFAULT_NUM_LIGNE)))
            .andExpect(jsonPath("$.[*].resort").value(hasItem(DEFAULT_RESORT)))
            .andExpect(jsonPath("$.[*].resvNameId").value(hasItem(DEFAULT_RESV_NAME_ID)))
            .andExpect(jsonPath("$.[*].clientOId").value(hasItem(DEFAULT_CLIENT_O_ID)))
            .andExpect(jsonPath("$.[*].typeChb").value(hasItem(DEFAULT_TYPE_CHB)))
            .andExpect(jsonPath("$.[*].confirmationNo").value(hasItem(DEFAULT_CONFIRMATION_NO)))
            .andExpect(jsonPath("$.[*].clientMdmId").value(hasItem(DEFAULT_CLIENT_MDM_ID)))
            .andExpect(jsonPath("$.[*].nameId").value(hasItem(DEFAULT_NAME_ID)))
            .andExpect(jsonPath("$.[*].parentResvNameId").value(hasItem(DEFAULT_PARENT_RESV_NAME_ID)))
            .andExpect(jsonPath("$.[*].contactId").value(hasItem(DEFAULT_CONTACT_ID)))
            .andExpect(jsonPath("$.[*].agenceId").value(hasItem(DEFAULT_AGENCE_ID)))
            .andExpect(jsonPath("$.[*].agenceNom").value(hasItem(DEFAULT_AGENCE_NOM)))
            .andExpect(jsonPath("$.[*].societeId").value(hasItem(DEFAULT_SOCIETE_ID)))
            .andExpect(jsonPath("$.[*].groupeId").value(hasItem(DEFAULT_GROUPE_ID)))
            .andExpect(jsonPath("$.[*].numBloc").value(hasItem(DEFAULT_NUM_BLOC)))
            .andExpect(jsonPath("$.[*].typeResv").value(hasItem(DEFAULT_TYPE_RESV)))
            .andExpect(jsonPath("$.[*].statutResv").value(hasItem(DEFAULT_STATUT_RESV)))
            .andExpect(jsonPath("$.[*].dateDebutResv").value(hasItem(DEFAULT_DATE_DEBUT_RESV.toString())))
            .andExpect(jsonPath("$.[*].dateFinResv").value(hasItem(DEFAULT_DATE_FIN_RESV.toString())))
            .andExpect(jsonPath("$.[*].truncDateDebutResv").value(hasItem(DEFAULT_TRUNC_DATE_DEBUT_RESV.toString())))
            .andExpect(jsonPath("$.[*].truncDateFinResv").value(hasItem(DEFAULT_TRUNC_DATE_FIN_RESV.toString())))
            .andExpect(jsonPath("$.[*].dateAnnResv").value(hasItem(DEFAULT_DATE_ANN_RESV.toString())))
            .andExpect(jsonPath("$.[*].pseudoRoomYn").value(hasItem(DEFAULT_PSEUDO_ROOM_YN)))
            .andExpect(jsonPath("$.[*].createurResv").value(hasItem(DEFAULT_CREATEUR_RESV)))
            .andExpect(jsonPath("$.[*].nomCreateurResv").value(hasItem(DEFAULT_NOM_CREATEUR_RESV)))
            .andExpect(jsonPath("$.[*].codeGarantie").value(hasItem(DEFAULT_CODE_GARANTIE)))
            .andExpect(jsonPath("$.[*].flgDed").value(hasItem(DEFAULT_FLG_DED)))
            .andExpect(jsonPath("$.[*].codePays").value(hasItem(DEFAULT_CODE_PAYS)))
            .andExpect(jsonPath("$.[*].libPays").value(hasItem(DEFAULT_LIB_PAYS)))
            .andExpect(jsonPath("$.[*].codeNationalite").value(hasItem(DEFAULT_CODE_NATIONALITE)))
            .andExpect(jsonPath("$.[*].libNationalite").value(hasItem(DEFAULT_LIB_NATIONALITE)))
            .andExpect(jsonPath("$.[*].codeSource").value(hasItem(DEFAULT_CODE_SOURCE)))
            .andExpect(jsonPath("$.[*].libSource").value(hasItem(DEFAULT_LIB_SOURCE)))
            .andExpect(jsonPath("$.[*].codeGrandSource").value(hasItem(DEFAULT_CODE_GRAND_SOURCE)))
            .andExpect(jsonPath("$.[*].codeOrigine").value(hasItem(DEFAULT_CODE_ORIGINE)))
            .andExpect(jsonPath("$.[*].libOrigine").value(hasItem(DEFAULT_LIB_ORIGINE)))
            .andExpect(jsonPath("$.[*].codeMarche").value(hasItem(DEFAULT_CODE_MARCHE)))
            .andExpect(jsonPath("$.[*].libMarche").value(hasItem(DEFAULT_LIB_MARCHE)))
            .andExpect(jsonPath("$.[*].codeGrandMarche").value(hasItem(DEFAULT_CODE_GRAND_MARCHE)))
            .andExpect(jsonPath("$.[*].libGrandMarche").value(hasItem(DEFAULT_LIB_GRAND_MARCHE)))
            .andExpect(jsonPath("$.[*].codePrix").value(hasItem(DEFAULT_CODE_PRIX)))
            .andExpect(jsonPath("$.[*].categPrix").value(hasItem(DEFAULT_CATEG_PRIX)))
            .andExpect(jsonPath("$.[*].libPrix").value(hasItem(DEFAULT_LIB_PRIX)))
            .andExpect(jsonPath("$.[*].numChb").value(hasItem(DEFAULT_NUM_CHB)))
            .andExpect(jsonPath("$.[*].descriptionTypeChb").value(hasItem(DEFAULT_DESCRIPTION_TYPE_CHB)))
            .andExpect(jsonPath("$.[*].codeTypeChb").value(hasItem(DEFAULT_CODE_TYPE_CHB)))
            .andExpect(jsonPath("$.[*].classChb").value(hasItem(DEFAULT_CLASS_CHB)))
            .andExpect(jsonPath("$.[*].caractChb").value(hasItem(DEFAULT_CARACT_CHB)))
            .andExpect(jsonPath("$.[*].typeChbDeReservation").value(hasItem(DEFAULT_TYPE_CHB_DE_RESERVATION)))
            .andExpect(jsonPath("$.[*].descriptionTypeChbDeResv").value(hasItem(DEFAULT_DESCRIPTION_TYPE_CHB_DE_RESV)))
            .andExpect(jsonPath("$.[*].codeTypeChbDeResv").value(hasItem(DEFAULT_CODE_TYPE_CHB_DE_RESV)))
            .andExpect(jsonPath("$.[*].statutDeReservation").value(hasItem(DEFAULT_STATUT_DE_RESERVATION)))
            .andExpect(jsonPath("$.[*].circuitDistribution").value(hasItem(DEFAULT_CIRCUIT_DISTRIBUTION)))
            .andExpect(jsonPath("$.[*].circuitDistribUserRegroup").value(hasItem(DEFAULT_CIRCUIT_DISTRIB_USER_REGROUP)))
            .andExpect(jsonPath("$.[*].numCrs").value(hasItem(DEFAULT_NUM_CRS)))
            .andExpect(jsonPath("$.[*].typeRefCrs").value(hasItem(DEFAULT_TYPE_REF_CRS)))
            .andExpect(jsonPath("$.[*].crsInsertDate").value(hasItem(DEFAULT_CRS_INSERT_DATE.toString())))
            .andExpect(jsonPath("$.[*].dateCreaResv").value(hasItem(DEFAULT_DATE_CREA_RESV.toString())))
            .andExpect(jsonPath("$.[*].datePremier").value(hasItem(DEFAULT_DATE_PREMIER.toString())))
            .andExpect(jsonPath("$.[*].statutPremier").value(hasItem(DEFAULT_STATUT_PREMIER)))
            .andExpect(jsonPath("$.[*].dateDernier").value(hasItem(DEFAULT_DATE_DERNIER.toString())))
            .andExpect(jsonPath("$.[*].statutDernier").value(hasItem(DEFAULT_STATUT_DERNIER)))
            .andExpect(jsonPath("$.[*].dateDernierPseudo").value(hasItem(DEFAULT_DATE_DERNIER_PSEUDO.toString())))
            .andExpect(jsonPath("$.[*].statutDernierPseudo").value(hasItem(DEFAULT_STATUT_DERNIER_PSEUDO)))
            .andExpect(jsonPath("$.[*].diffDtCreaAnn").value(hasItem(DEFAULT_DIFF_DT_CREA_ANN)))
            .andExpect(jsonPath("$.[*].diffDtArrAnn").value(hasItem(DEFAULT_DIFF_DT_ARR_ANN)))
            .andExpect(jsonPath("$.[*].leadtime").value(hasItem(DEFAULT_LEADTIME)))
            .andExpect(jsonPath("$.[*].los").value(hasItem(DEFAULT_LOS)))
            .andExpect(jsonPath("$.[*].occupantsGroupe").value(hasItem(DEFAULT_OCCUPANTS_GROUPE)))
            .andExpect(jsonPath("$.[*].nbNuitee").value(hasItem(DEFAULT_NB_NUITEE)))
            .andExpect(jsonPath("$.[*].nbNuiteeNnDed").value(hasItem(DEFAULT_NB_NUITEE_NN_DED)))
            .andExpect(jsonPath("$.[*].nbResvAnn").value(hasItem(DEFAULT_NB_RESV_ANN)))
            .andExpect(jsonPath("$.[*].nbAdu").value(hasItem(DEFAULT_NB_ADU)))
            .andExpect(jsonPath("$.[*].nbEnf").value(hasItem(DEFAULT_NB_ENF)))
            .andExpect(jsonPath("$.[*].nbPersDayU").value(hasItem(DEFAULT_NB_PERS_DAY_U)))
            .andExpect(jsonPath("$.[*].nbPersArr").value(hasItem(DEFAULT_NB_PERS_ARR)))
            .andExpect(jsonPath("$.[*].nbPersDep").value(hasItem(DEFAULT_NB_PERS_DEP)))
            .andExpect(jsonPath("$.[*].nbPersAnn").value(hasItem(DEFAULT_NB_PERS_ANN)))
            .andExpect(jsonPath("$.[*].nbPersNoshow").value(hasItem(DEFAULT_NB_PERS_NOSHOW)))
            .andExpect(jsonPath("$.[*].nbChbDayU").value(hasItem(DEFAULT_NB_CHB_DAY_U)))
            .andExpect(jsonPath("$.[*].nbChbArr").value(hasItem(DEFAULT_NB_CHB_ARR)))
            .andExpect(jsonPath("$.[*].nbChbDep").value(hasItem(DEFAULT_NB_CHB_DEP)))
            .andExpect(jsonPath("$.[*].nbChbAnn").value(hasItem(DEFAULT_NB_CHB_ANN)))
            .andExpect(jsonPath("$.[*].nbChbNoshow").value(hasItem(DEFAULT_NB_CHB_NOSHOW)))
            .andExpect(jsonPath("$.[*].revenuNetChambre").value(hasItem(DEFAULT_REVENU_NET_CHAMBRE.intValue())))
            .andExpect(jsonPath("$.[*].revenuTaxeChambre").value(hasItem(DEFAULT_REVENU_TAXE_CHAMBRE.intValue())))
            .andExpect(jsonPath("$.[*].revenuNetChambreGlobal").value(hasItem(DEFAULT_REVENU_NET_CHAMBRE_GLOBAL.intValue())))
            .andExpect(jsonPath("$.[*].revenuTaxeChambreGlobal").value(hasItem(DEFAULT_REVENU_TAXE_CHAMBRE_GLOBAL.intValue())))
            .andExpect(jsonPath("$.[*].revenuNetBq").value(hasItem(DEFAULT_REVENU_NET_BQ.intValue())))
            .andExpect(jsonPath("$.[*].revenuTaxeBq").value(hasItem(DEFAULT_REVENU_TAXE_BQ.intValue())))
            .andExpect(jsonPath("$.[*].revenuNetBqGlobal").value(hasItem(DEFAULT_REVENU_NET_BQ_GLOBAL.intValue())))
            .andExpect(jsonPath("$.[*].revenuTaxeBqGlobal").value(hasItem(DEFAULT_REVENU_TAXE_BQ_GLOBAL.intValue())))
            .andExpect(jsonPath("$.[*].revenuNetExtra").value(hasItem(DEFAULT_REVENU_NET_EXTRA.intValue())))
            .andExpect(jsonPath("$.[*].revenuTaxeExtra").value(hasItem(DEFAULT_REVENU_TAXE_EXTRA.intValue())))
            .andExpect(jsonPath("$.[*].revenuNetExtraGlobal").value(hasItem(DEFAULT_REVENU_NET_EXTRA_GLOBAL.intValue())))
            .andExpect(jsonPath("$.[*].revenuTaxeExtraGlobal").value(hasItem(DEFAULT_REVENU_TAXE_EXTRA_GLOBAL.intValue())))
            .andExpect(jsonPath("$.[*].revenuNetTotal").value(hasItem(DEFAULT_REVENU_NET_TOTAL.intValue())))
            .andExpect(jsonPath("$.[*].revenuTaxeTotal").value(hasItem(DEFAULT_REVENU_TAXE_TOTAL.intValue())))
            .andExpect(jsonPath("$.[*].revenuNetTotalGlobal").value(hasItem(DEFAULT_REVENU_NET_TOTAL_GLOBAL.intValue())))
            .andExpect(jsonPath("$.[*].revenuTaxeTotalGlobal").value(hasItem(DEFAULT_REVENU_TAXE_TOTAL_GLOBAL.intValue())))
            .andExpect(jsonPath("$.[*].prodRevenuChambre").value(hasItem(DEFAULT_PROD_REVENU_CHAMBRE.intValue())))
            .andExpect(jsonPath("$.[*].prodRevenuBq").value(hasItem(DEFAULT_PROD_REVENU_BQ.intValue())))
            .andExpect(jsonPath("$.[*].prodRevenuExtra").value(hasItem(DEFAULT_PROD_REVENU_EXTRA.intValue())))
            .andExpect(jsonPath("$.[*].prodRevenuTotal").value(hasItem(DEFAULT_PROD_REVENU_TOTAL.intValue())))
            .andExpect(jsonPath("$.[*].prodChambreNbNuitees").value(hasItem(DEFAULT_PROD_CHAMBRE_NB_NUITEES.intValue())))
            .andExpect(jsonPath("$.[*].techCreateDate").value(hasItem(DEFAULT_TECH_CREATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].techUpdateDate").value(hasItem(DEFAULT_TECH_UPDATE_DATE.toString())));
    }

    @Test
    @Transactional
    void getDmOResv() throws Exception {
        // Initialize the database
        dmOResvRepository.saveAndFlush(dmOResv);

        // Get the dmOResv
        restDmOResvMockMvc
            .perform(get(ENTITY_API_URL_ID, dmOResv.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(dmOResv.getId().intValue()))
            .andExpect(jsonPath("$.numLigne").value(DEFAULT_NUM_LIGNE))
            .andExpect(jsonPath("$.resort").value(DEFAULT_RESORT))
            .andExpect(jsonPath("$.resvNameId").value(DEFAULT_RESV_NAME_ID))
            .andExpect(jsonPath("$.clientOId").value(DEFAULT_CLIENT_O_ID))
            .andExpect(jsonPath("$.typeChb").value(DEFAULT_TYPE_CHB))
            .andExpect(jsonPath("$.confirmationNo").value(DEFAULT_CONFIRMATION_NO))
            .andExpect(jsonPath("$.clientMdmId").value(DEFAULT_CLIENT_MDM_ID))
            .andExpect(jsonPath("$.nameId").value(DEFAULT_NAME_ID))
            .andExpect(jsonPath("$.parentResvNameId").value(DEFAULT_PARENT_RESV_NAME_ID))
            .andExpect(jsonPath("$.contactId").value(DEFAULT_CONTACT_ID))
            .andExpect(jsonPath("$.agenceId").value(DEFAULT_AGENCE_ID))
            .andExpect(jsonPath("$.agenceNom").value(DEFAULT_AGENCE_NOM))
            .andExpect(jsonPath("$.societeId").value(DEFAULT_SOCIETE_ID))
            .andExpect(jsonPath("$.groupeId").value(DEFAULT_GROUPE_ID))
            .andExpect(jsonPath("$.numBloc").value(DEFAULT_NUM_BLOC))
            .andExpect(jsonPath("$.typeResv").value(DEFAULT_TYPE_RESV))
            .andExpect(jsonPath("$.statutResv").value(DEFAULT_STATUT_RESV))
            .andExpect(jsonPath("$.dateDebutResv").value(DEFAULT_DATE_DEBUT_RESV.toString()))
            .andExpect(jsonPath("$.dateFinResv").value(DEFAULT_DATE_FIN_RESV.toString()))
            .andExpect(jsonPath("$.truncDateDebutResv").value(DEFAULT_TRUNC_DATE_DEBUT_RESV.toString()))
            .andExpect(jsonPath("$.truncDateFinResv").value(DEFAULT_TRUNC_DATE_FIN_RESV.toString()))
            .andExpect(jsonPath("$.dateAnnResv").value(DEFAULT_DATE_ANN_RESV.toString()))
            .andExpect(jsonPath("$.pseudoRoomYn").value(DEFAULT_PSEUDO_ROOM_YN))
            .andExpect(jsonPath("$.createurResv").value(DEFAULT_CREATEUR_RESV))
            .andExpect(jsonPath("$.nomCreateurResv").value(DEFAULT_NOM_CREATEUR_RESV))
            .andExpect(jsonPath("$.codeGarantie").value(DEFAULT_CODE_GARANTIE))
            .andExpect(jsonPath("$.flgDed").value(DEFAULT_FLG_DED))
            .andExpect(jsonPath("$.codePays").value(DEFAULT_CODE_PAYS))
            .andExpect(jsonPath("$.libPays").value(DEFAULT_LIB_PAYS))
            .andExpect(jsonPath("$.codeNationalite").value(DEFAULT_CODE_NATIONALITE))
            .andExpect(jsonPath("$.libNationalite").value(DEFAULT_LIB_NATIONALITE))
            .andExpect(jsonPath("$.codeSource").value(DEFAULT_CODE_SOURCE))
            .andExpect(jsonPath("$.libSource").value(DEFAULT_LIB_SOURCE))
            .andExpect(jsonPath("$.codeGrandSource").value(DEFAULT_CODE_GRAND_SOURCE))
            .andExpect(jsonPath("$.codeOrigine").value(DEFAULT_CODE_ORIGINE))
            .andExpect(jsonPath("$.libOrigine").value(DEFAULT_LIB_ORIGINE))
            .andExpect(jsonPath("$.codeMarche").value(DEFAULT_CODE_MARCHE))
            .andExpect(jsonPath("$.libMarche").value(DEFAULT_LIB_MARCHE))
            .andExpect(jsonPath("$.codeGrandMarche").value(DEFAULT_CODE_GRAND_MARCHE))
            .andExpect(jsonPath("$.libGrandMarche").value(DEFAULT_LIB_GRAND_MARCHE))
            .andExpect(jsonPath("$.codePrix").value(DEFAULT_CODE_PRIX))
            .andExpect(jsonPath("$.categPrix").value(DEFAULT_CATEG_PRIX))
            .andExpect(jsonPath("$.libPrix").value(DEFAULT_LIB_PRIX))
            .andExpect(jsonPath("$.numChb").value(DEFAULT_NUM_CHB))
            .andExpect(jsonPath("$.descriptionTypeChb").value(DEFAULT_DESCRIPTION_TYPE_CHB))
            .andExpect(jsonPath("$.codeTypeChb").value(DEFAULT_CODE_TYPE_CHB))
            .andExpect(jsonPath("$.classChb").value(DEFAULT_CLASS_CHB))
            .andExpect(jsonPath("$.caractChb").value(DEFAULT_CARACT_CHB))
            .andExpect(jsonPath("$.typeChbDeReservation").value(DEFAULT_TYPE_CHB_DE_RESERVATION))
            .andExpect(jsonPath("$.descriptionTypeChbDeResv").value(DEFAULT_DESCRIPTION_TYPE_CHB_DE_RESV))
            .andExpect(jsonPath("$.codeTypeChbDeResv").value(DEFAULT_CODE_TYPE_CHB_DE_RESV))
            .andExpect(jsonPath("$.statutDeReservation").value(DEFAULT_STATUT_DE_RESERVATION))
            .andExpect(jsonPath("$.circuitDistribution").value(DEFAULT_CIRCUIT_DISTRIBUTION))
            .andExpect(jsonPath("$.circuitDistribUserRegroup").value(DEFAULT_CIRCUIT_DISTRIB_USER_REGROUP))
            .andExpect(jsonPath("$.numCrs").value(DEFAULT_NUM_CRS))
            .andExpect(jsonPath("$.typeRefCrs").value(DEFAULT_TYPE_REF_CRS))
            .andExpect(jsonPath("$.crsInsertDate").value(DEFAULT_CRS_INSERT_DATE.toString()))
            .andExpect(jsonPath("$.dateCreaResv").value(DEFAULT_DATE_CREA_RESV.toString()))
            .andExpect(jsonPath("$.datePremier").value(DEFAULT_DATE_PREMIER.toString()))
            .andExpect(jsonPath("$.statutPremier").value(DEFAULT_STATUT_PREMIER))
            .andExpect(jsonPath("$.dateDernier").value(DEFAULT_DATE_DERNIER.toString()))
            .andExpect(jsonPath("$.statutDernier").value(DEFAULT_STATUT_DERNIER))
            .andExpect(jsonPath("$.dateDernierPseudo").value(DEFAULT_DATE_DERNIER_PSEUDO.toString()))
            .andExpect(jsonPath("$.statutDernierPseudo").value(DEFAULT_STATUT_DERNIER_PSEUDO))
            .andExpect(jsonPath("$.diffDtCreaAnn").value(DEFAULT_DIFF_DT_CREA_ANN))
            .andExpect(jsonPath("$.diffDtArrAnn").value(DEFAULT_DIFF_DT_ARR_ANN))
            .andExpect(jsonPath("$.leadtime").value(DEFAULT_LEADTIME))
            .andExpect(jsonPath("$.los").value(DEFAULT_LOS))
            .andExpect(jsonPath("$.occupantsGroupe").value(DEFAULT_OCCUPANTS_GROUPE))
            .andExpect(jsonPath("$.nbNuitee").value(DEFAULT_NB_NUITEE))
            .andExpect(jsonPath("$.nbNuiteeNnDed").value(DEFAULT_NB_NUITEE_NN_DED))
            .andExpect(jsonPath("$.nbResvAnn").value(DEFAULT_NB_RESV_ANN))
            .andExpect(jsonPath("$.nbAdu").value(DEFAULT_NB_ADU))
            .andExpect(jsonPath("$.nbEnf").value(DEFAULT_NB_ENF))
            .andExpect(jsonPath("$.nbPersDayU").value(DEFAULT_NB_PERS_DAY_U))
            .andExpect(jsonPath("$.nbPersArr").value(DEFAULT_NB_PERS_ARR))
            .andExpect(jsonPath("$.nbPersDep").value(DEFAULT_NB_PERS_DEP))
            .andExpect(jsonPath("$.nbPersAnn").value(DEFAULT_NB_PERS_ANN))
            .andExpect(jsonPath("$.nbPersNoshow").value(DEFAULT_NB_PERS_NOSHOW))
            .andExpect(jsonPath("$.nbChbDayU").value(DEFAULT_NB_CHB_DAY_U))
            .andExpect(jsonPath("$.nbChbArr").value(DEFAULT_NB_CHB_ARR))
            .andExpect(jsonPath("$.nbChbDep").value(DEFAULT_NB_CHB_DEP))
            .andExpect(jsonPath("$.nbChbAnn").value(DEFAULT_NB_CHB_ANN))
            .andExpect(jsonPath("$.nbChbNoshow").value(DEFAULT_NB_CHB_NOSHOW))
            .andExpect(jsonPath("$.revenuNetChambre").value(DEFAULT_REVENU_NET_CHAMBRE.intValue()))
            .andExpect(jsonPath("$.revenuTaxeChambre").value(DEFAULT_REVENU_TAXE_CHAMBRE.intValue()))
            .andExpect(jsonPath("$.revenuNetChambreGlobal").value(DEFAULT_REVENU_NET_CHAMBRE_GLOBAL.intValue()))
            .andExpect(jsonPath("$.revenuTaxeChambreGlobal").value(DEFAULT_REVENU_TAXE_CHAMBRE_GLOBAL.intValue()))
            .andExpect(jsonPath("$.revenuNetBq").value(DEFAULT_REVENU_NET_BQ.intValue()))
            .andExpect(jsonPath("$.revenuTaxeBq").value(DEFAULT_REVENU_TAXE_BQ.intValue()))
            .andExpect(jsonPath("$.revenuNetBqGlobal").value(DEFAULT_REVENU_NET_BQ_GLOBAL.intValue()))
            .andExpect(jsonPath("$.revenuTaxeBqGlobal").value(DEFAULT_REVENU_TAXE_BQ_GLOBAL.intValue()))
            .andExpect(jsonPath("$.revenuNetExtra").value(DEFAULT_REVENU_NET_EXTRA.intValue()))
            .andExpect(jsonPath("$.revenuTaxeExtra").value(DEFAULT_REVENU_TAXE_EXTRA.intValue()))
            .andExpect(jsonPath("$.revenuNetExtraGlobal").value(DEFAULT_REVENU_NET_EXTRA_GLOBAL.intValue()))
            .andExpect(jsonPath("$.revenuTaxeExtraGlobal").value(DEFAULT_REVENU_TAXE_EXTRA_GLOBAL.intValue()))
            .andExpect(jsonPath("$.revenuNetTotal").value(DEFAULT_REVENU_NET_TOTAL.intValue()))
            .andExpect(jsonPath("$.revenuTaxeTotal").value(DEFAULT_REVENU_TAXE_TOTAL.intValue()))
            .andExpect(jsonPath("$.revenuNetTotalGlobal").value(DEFAULT_REVENU_NET_TOTAL_GLOBAL.intValue()))
            .andExpect(jsonPath("$.revenuTaxeTotalGlobal").value(DEFAULT_REVENU_TAXE_TOTAL_GLOBAL.intValue()))
            .andExpect(jsonPath("$.prodRevenuChambre").value(DEFAULT_PROD_REVENU_CHAMBRE.intValue()))
            .andExpect(jsonPath("$.prodRevenuBq").value(DEFAULT_PROD_REVENU_BQ.intValue()))
            .andExpect(jsonPath("$.prodRevenuExtra").value(DEFAULT_PROD_REVENU_EXTRA.intValue()))
            .andExpect(jsonPath("$.prodRevenuTotal").value(DEFAULT_PROD_REVENU_TOTAL.intValue()))
            .andExpect(jsonPath("$.prodChambreNbNuitees").value(DEFAULT_PROD_CHAMBRE_NB_NUITEES.intValue()))
            .andExpect(jsonPath("$.techCreateDate").value(DEFAULT_TECH_CREATE_DATE.toString()))
            .andExpect(jsonPath("$.techUpdateDate").value(DEFAULT_TECH_UPDATE_DATE.toString()));
    }

    @Test
    @Transactional
    void getNonExistingDmOResv() throws Exception {
        // Get the dmOResv
        restDmOResvMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingDmOResv() throws Exception {
        // Initialize the database
        dmOResvRepository.saveAndFlush(dmOResv);

        int databaseSizeBeforeUpdate = dmOResvRepository.findAll().size();

        // Update the dmOResv
        DmOResv updatedDmOResv = dmOResvRepository.findById(dmOResv.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedDmOResv are not directly saved in db
        em.detach(updatedDmOResv);
        updatedDmOResv
            .numLigne(UPDATED_NUM_LIGNE)
            .resort(UPDATED_RESORT)
            .resvNameId(UPDATED_RESV_NAME_ID)
            .clientOId(UPDATED_CLIENT_O_ID)
            .typeChb(UPDATED_TYPE_CHB)
            .confirmationNo(UPDATED_CONFIRMATION_NO)
            .clientMdmId(UPDATED_CLIENT_MDM_ID)
            .nameId(UPDATED_NAME_ID)
            .parentResvNameId(UPDATED_PARENT_RESV_NAME_ID)
            .contactId(UPDATED_CONTACT_ID)
            .agenceId(UPDATED_AGENCE_ID)
            .agenceNom(UPDATED_AGENCE_NOM)
            .societeId(UPDATED_SOCIETE_ID)
            .groupeId(UPDATED_GROUPE_ID)
            .numBloc(UPDATED_NUM_BLOC)
            .typeResv(UPDATED_TYPE_RESV)
            .statutResv(UPDATED_STATUT_RESV)
            .dateDebutResv(UPDATED_DATE_DEBUT_RESV)
            .dateFinResv(UPDATED_DATE_FIN_RESV)
            .truncDateDebutResv(UPDATED_TRUNC_DATE_DEBUT_RESV)
            .truncDateFinResv(UPDATED_TRUNC_DATE_FIN_RESV)
            .dateAnnResv(UPDATED_DATE_ANN_RESV)
            .pseudoRoomYn(UPDATED_PSEUDO_ROOM_YN)
            .createurResv(UPDATED_CREATEUR_RESV)
            .nomCreateurResv(UPDATED_NOM_CREATEUR_RESV)
            .codeGarantie(UPDATED_CODE_GARANTIE)
            .flgDed(UPDATED_FLG_DED)
            .codePays(UPDATED_CODE_PAYS)
            .libPays(UPDATED_LIB_PAYS)
            .codeNationalite(UPDATED_CODE_NATIONALITE)
            .libNationalite(UPDATED_LIB_NATIONALITE)
            .codeSource(UPDATED_CODE_SOURCE)
            .libSource(UPDATED_LIB_SOURCE)
            .codeGrandSource(UPDATED_CODE_GRAND_SOURCE)
            .codeOrigine(UPDATED_CODE_ORIGINE)
            .libOrigine(UPDATED_LIB_ORIGINE)
            .codeMarche(UPDATED_CODE_MARCHE)
            .libMarche(UPDATED_LIB_MARCHE)
            .codeGrandMarche(UPDATED_CODE_GRAND_MARCHE)
            .libGrandMarche(UPDATED_LIB_GRAND_MARCHE)
            .codePrix(UPDATED_CODE_PRIX)
            .categPrix(UPDATED_CATEG_PRIX)
            .libPrix(UPDATED_LIB_PRIX)
            .numChb(UPDATED_NUM_CHB)
            .descriptionTypeChb(UPDATED_DESCRIPTION_TYPE_CHB)
            .codeTypeChb(UPDATED_CODE_TYPE_CHB)
            .classChb(UPDATED_CLASS_CHB)
            .caractChb(UPDATED_CARACT_CHB)
            .typeChbDeReservation(UPDATED_TYPE_CHB_DE_RESERVATION)
            .descriptionTypeChbDeResv(UPDATED_DESCRIPTION_TYPE_CHB_DE_RESV)
            .codeTypeChbDeResv(UPDATED_CODE_TYPE_CHB_DE_RESV)
            .statutDeReservation(UPDATED_STATUT_DE_RESERVATION)
            .circuitDistribution(UPDATED_CIRCUIT_DISTRIBUTION)
            .circuitDistribUserRegroup(UPDATED_CIRCUIT_DISTRIB_USER_REGROUP)
            .numCrs(UPDATED_NUM_CRS)
            .typeRefCrs(UPDATED_TYPE_REF_CRS)
            .crsInsertDate(UPDATED_CRS_INSERT_DATE)
            .dateCreaResv(UPDATED_DATE_CREA_RESV)
            .datePremier(UPDATED_DATE_PREMIER)
            .statutPremier(UPDATED_STATUT_PREMIER)
            .dateDernier(UPDATED_DATE_DERNIER)
            .statutDernier(UPDATED_STATUT_DERNIER)
            .dateDernierPseudo(UPDATED_DATE_DERNIER_PSEUDO)
            .statutDernierPseudo(UPDATED_STATUT_DERNIER_PSEUDO)
            .diffDtCreaAnn(UPDATED_DIFF_DT_CREA_ANN)
            .diffDtArrAnn(UPDATED_DIFF_DT_ARR_ANN)
            .leadtime(UPDATED_LEADTIME)
            .los(UPDATED_LOS)
            .occupantsGroupe(UPDATED_OCCUPANTS_GROUPE)
            .nbNuitee(UPDATED_NB_NUITEE)
            .nbNuiteeNnDed(UPDATED_NB_NUITEE_NN_DED)
            .nbResvAnn(UPDATED_NB_RESV_ANN)
            .nbAdu(UPDATED_NB_ADU)
            .nbEnf(UPDATED_NB_ENF)
            .nbPersDayU(UPDATED_NB_PERS_DAY_U)
            .nbPersArr(UPDATED_NB_PERS_ARR)
            .nbPersDep(UPDATED_NB_PERS_DEP)
            .nbPersAnn(UPDATED_NB_PERS_ANN)
            .nbPersNoshow(UPDATED_NB_PERS_NOSHOW)
            .nbChbDayU(UPDATED_NB_CHB_DAY_U)
            .nbChbArr(UPDATED_NB_CHB_ARR)
            .nbChbDep(UPDATED_NB_CHB_DEP)
            .nbChbAnn(UPDATED_NB_CHB_ANN)
            .nbChbNoshow(UPDATED_NB_CHB_NOSHOW)
            .revenuNetChambre(UPDATED_REVENU_NET_CHAMBRE)
            .revenuTaxeChambre(UPDATED_REVENU_TAXE_CHAMBRE)
            .revenuNetChambreGlobal(UPDATED_REVENU_NET_CHAMBRE_GLOBAL)
            .revenuTaxeChambreGlobal(UPDATED_REVENU_TAXE_CHAMBRE_GLOBAL)
            .revenuNetBq(UPDATED_REVENU_NET_BQ)
            .revenuTaxeBq(UPDATED_REVENU_TAXE_BQ)
            .revenuNetBqGlobal(UPDATED_REVENU_NET_BQ_GLOBAL)
            .revenuTaxeBqGlobal(UPDATED_REVENU_TAXE_BQ_GLOBAL)
            .revenuNetExtra(UPDATED_REVENU_NET_EXTRA)
            .revenuTaxeExtra(UPDATED_REVENU_TAXE_EXTRA)
            .revenuNetExtraGlobal(UPDATED_REVENU_NET_EXTRA_GLOBAL)
            .revenuTaxeExtraGlobal(UPDATED_REVENU_TAXE_EXTRA_GLOBAL)
            .revenuNetTotal(UPDATED_REVENU_NET_TOTAL)
            .revenuTaxeTotal(UPDATED_REVENU_TAXE_TOTAL)
            .revenuNetTotalGlobal(UPDATED_REVENU_NET_TOTAL_GLOBAL)
            .revenuTaxeTotalGlobal(UPDATED_REVENU_TAXE_TOTAL_GLOBAL)
            .prodRevenuChambre(UPDATED_PROD_REVENU_CHAMBRE)
            .prodRevenuBq(UPDATED_PROD_REVENU_BQ)
            .prodRevenuExtra(UPDATED_PROD_REVENU_EXTRA)
            .prodRevenuTotal(UPDATED_PROD_REVENU_TOTAL)
            .prodChambreNbNuitees(UPDATED_PROD_CHAMBRE_NB_NUITEES)
            .techCreateDate(UPDATED_TECH_CREATE_DATE)
            .techUpdateDate(UPDATED_TECH_UPDATE_DATE);
        DmOResvDTO dmOResvDTO = dmOResvMapper.toDto(updatedDmOResv);

        restDmOResvMockMvc
            .perform(
                put(ENTITY_API_URL_ID, dmOResvDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(dmOResvDTO))
            )
            .andExpect(status().isOk());

        // Validate the DmOResv in the database
        List<DmOResv> dmOResvList = dmOResvRepository.findAll();
        assertThat(dmOResvList).hasSize(databaseSizeBeforeUpdate);
        DmOResv testDmOResv = dmOResvList.get(dmOResvList.size() - 1);
        assertThat(testDmOResv.getNumLigne()).isEqualTo(UPDATED_NUM_LIGNE);
        assertThat(testDmOResv.getResort()).isEqualTo(UPDATED_RESORT);
        assertThat(testDmOResv.getResvNameId()).isEqualTo(UPDATED_RESV_NAME_ID);
        assertThat(testDmOResv.getClientOId()).isEqualTo(UPDATED_CLIENT_O_ID);
        assertThat(testDmOResv.getTypeChb()).isEqualTo(UPDATED_TYPE_CHB);
        assertThat(testDmOResv.getConfirmationNo()).isEqualTo(UPDATED_CONFIRMATION_NO);
        assertThat(testDmOResv.getClientMdmId()).isEqualTo(UPDATED_CLIENT_MDM_ID);
        assertThat(testDmOResv.getNameId()).isEqualTo(UPDATED_NAME_ID);
        assertThat(testDmOResv.getParentResvNameId()).isEqualTo(UPDATED_PARENT_RESV_NAME_ID);
        assertThat(testDmOResv.getContactId()).isEqualTo(UPDATED_CONTACT_ID);
        assertThat(testDmOResv.getAgenceId()).isEqualTo(UPDATED_AGENCE_ID);
        assertThat(testDmOResv.getAgenceNom()).isEqualTo(UPDATED_AGENCE_NOM);
        assertThat(testDmOResv.getSocieteId()).isEqualTo(UPDATED_SOCIETE_ID);
        assertThat(testDmOResv.getGroupeId()).isEqualTo(UPDATED_GROUPE_ID);
        assertThat(testDmOResv.getNumBloc()).isEqualTo(UPDATED_NUM_BLOC);
        assertThat(testDmOResv.getTypeResv()).isEqualTo(UPDATED_TYPE_RESV);
        assertThat(testDmOResv.getStatutResv()).isEqualTo(UPDATED_STATUT_RESV);
        assertThat(testDmOResv.getDateDebutResv()).isEqualTo(UPDATED_DATE_DEBUT_RESV);
        assertThat(testDmOResv.getDateFinResv()).isEqualTo(UPDATED_DATE_FIN_RESV);
        assertThat(testDmOResv.getTruncDateDebutResv()).isEqualTo(UPDATED_TRUNC_DATE_DEBUT_RESV);
        assertThat(testDmOResv.getTruncDateFinResv()).isEqualTo(UPDATED_TRUNC_DATE_FIN_RESV);
        assertThat(testDmOResv.getDateAnnResv()).isEqualTo(UPDATED_DATE_ANN_RESV);
        assertThat(testDmOResv.getPseudoRoomYn()).isEqualTo(UPDATED_PSEUDO_ROOM_YN);
        assertThat(testDmOResv.getCreateurResv()).isEqualTo(UPDATED_CREATEUR_RESV);
        assertThat(testDmOResv.getNomCreateurResv()).isEqualTo(UPDATED_NOM_CREATEUR_RESV);
        assertThat(testDmOResv.getCodeGarantie()).isEqualTo(UPDATED_CODE_GARANTIE);
        assertThat(testDmOResv.getFlgDed()).isEqualTo(UPDATED_FLG_DED);
        assertThat(testDmOResv.getCodePays()).isEqualTo(UPDATED_CODE_PAYS);
        assertThat(testDmOResv.getLibPays()).isEqualTo(UPDATED_LIB_PAYS);
        assertThat(testDmOResv.getCodeNationalite()).isEqualTo(UPDATED_CODE_NATIONALITE);
        assertThat(testDmOResv.getLibNationalite()).isEqualTo(UPDATED_LIB_NATIONALITE);
        assertThat(testDmOResv.getCodeSource()).isEqualTo(UPDATED_CODE_SOURCE);
        assertThat(testDmOResv.getLibSource()).isEqualTo(UPDATED_LIB_SOURCE);
        assertThat(testDmOResv.getCodeGrandSource()).isEqualTo(UPDATED_CODE_GRAND_SOURCE);
        assertThat(testDmOResv.getCodeOrigine()).isEqualTo(UPDATED_CODE_ORIGINE);
        assertThat(testDmOResv.getLibOrigine()).isEqualTo(UPDATED_LIB_ORIGINE);
        assertThat(testDmOResv.getCodeMarche()).isEqualTo(UPDATED_CODE_MARCHE);
        assertThat(testDmOResv.getLibMarche()).isEqualTo(UPDATED_LIB_MARCHE);
        assertThat(testDmOResv.getCodeGrandMarche()).isEqualTo(UPDATED_CODE_GRAND_MARCHE);
        assertThat(testDmOResv.getLibGrandMarche()).isEqualTo(UPDATED_LIB_GRAND_MARCHE);
        assertThat(testDmOResv.getCodePrix()).isEqualTo(UPDATED_CODE_PRIX);
        assertThat(testDmOResv.getCategPrix()).isEqualTo(UPDATED_CATEG_PRIX);
        assertThat(testDmOResv.getLibPrix()).isEqualTo(UPDATED_LIB_PRIX);
        assertThat(testDmOResv.getNumChb()).isEqualTo(UPDATED_NUM_CHB);
        assertThat(testDmOResv.getDescriptionTypeChb()).isEqualTo(UPDATED_DESCRIPTION_TYPE_CHB);
        assertThat(testDmOResv.getCodeTypeChb()).isEqualTo(UPDATED_CODE_TYPE_CHB);
        assertThat(testDmOResv.getClassChb()).isEqualTo(UPDATED_CLASS_CHB);
        assertThat(testDmOResv.getCaractChb()).isEqualTo(UPDATED_CARACT_CHB);
        assertThat(testDmOResv.getTypeChbDeReservation()).isEqualTo(UPDATED_TYPE_CHB_DE_RESERVATION);
        assertThat(testDmOResv.getDescriptionTypeChbDeResv()).isEqualTo(UPDATED_DESCRIPTION_TYPE_CHB_DE_RESV);
        assertThat(testDmOResv.getCodeTypeChbDeResv()).isEqualTo(UPDATED_CODE_TYPE_CHB_DE_RESV);
        assertThat(testDmOResv.getStatutDeReservation()).isEqualTo(UPDATED_STATUT_DE_RESERVATION);
        assertThat(testDmOResv.getCircuitDistribution()).isEqualTo(UPDATED_CIRCUIT_DISTRIBUTION);
        assertThat(testDmOResv.getCircuitDistribUserRegroup()).isEqualTo(UPDATED_CIRCUIT_DISTRIB_USER_REGROUP);
        assertThat(testDmOResv.getNumCrs()).isEqualTo(UPDATED_NUM_CRS);
        assertThat(testDmOResv.getTypeRefCrs()).isEqualTo(UPDATED_TYPE_REF_CRS);
        assertThat(testDmOResv.getCrsInsertDate()).isEqualTo(UPDATED_CRS_INSERT_DATE);
        assertThat(testDmOResv.getDateCreaResv()).isEqualTo(UPDATED_DATE_CREA_RESV);
        assertThat(testDmOResv.getDatePremier()).isEqualTo(UPDATED_DATE_PREMIER);
        assertThat(testDmOResv.getStatutPremier()).isEqualTo(UPDATED_STATUT_PREMIER);
        assertThat(testDmOResv.getDateDernier()).isEqualTo(UPDATED_DATE_DERNIER);
        assertThat(testDmOResv.getStatutDernier()).isEqualTo(UPDATED_STATUT_DERNIER);
        assertThat(testDmOResv.getDateDernierPseudo()).isEqualTo(UPDATED_DATE_DERNIER_PSEUDO);
        assertThat(testDmOResv.getStatutDernierPseudo()).isEqualTo(UPDATED_STATUT_DERNIER_PSEUDO);
        assertThat(testDmOResv.getDiffDtCreaAnn()).isEqualTo(UPDATED_DIFF_DT_CREA_ANN);
        assertThat(testDmOResv.getDiffDtArrAnn()).isEqualTo(UPDATED_DIFF_DT_ARR_ANN);
        assertThat(testDmOResv.getLeadtime()).isEqualTo(UPDATED_LEADTIME);
        assertThat(testDmOResv.getLos()).isEqualTo(UPDATED_LOS);
        assertThat(testDmOResv.getOccupantsGroupe()).isEqualTo(UPDATED_OCCUPANTS_GROUPE);
        assertThat(testDmOResv.getNbNuitee()).isEqualTo(UPDATED_NB_NUITEE);
        assertThat(testDmOResv.getNbNuiteeNnDed()).isEqualTo(UPDATED_NB_NUITEE_NN_DED);
        assertThat(testDmOResv.getNbResvAnn()).isEqualTo(UPDATED_NB_RESV_ANN);
        assertThat(testDmOResv.getNbAdu()).isEqualTo(UPDATED_NB_ADU);
        assertThat(testDmOResv.getNbEnf()).isEqualTo(UPDATED_NB_ENF);
        assertThat(testDmOResv.getNbPersDayU()).isEqualTo(UPDATED_NB_PERS_DAY_U);
        assertThat(testDmOResv.getNbPersArr()).isEqualTo(UPDATED_NB_PERS_ARR);
        assertThat(testDmOResv.getNbPersDep()).isEqualTo(UPDATED_NB_PERS_DEP);
        assertThat(testDmOResv.getNbPersAnn()).isEqualTo(UPDATED_NB_PERS_ANN);
        assertThat(testDmOResv.getNbPersNoshow()).isEqualTo(UPDATED_NB_PERS_NOSHOW);
        assertThat(testDmOResv.getNbChbDayU()).isEqualTo(UPDATED_NB_CHB_DAY_U);
        assertThat(testDmOResv.getNbChbArr()).isEqualTo(UPDATED_NB_CHB_ARR);
        assertThat(testDmOResv.getNbChbDep()).isEqualTo(UPDATED_NB_CHB_DEP);
        assertThat(testDmOResv.getNbChbAnn()).isEqualTo(UPDATED_NB_CHB_ANN);
        assertThat(testDmOResv.getNbChbNoshow()).isEqualTo(UPDATED_NB_CHB_NOSHOW);
        assertThat(testDmOResv.getRevenuNetChambre()).isEqualTo(UPDATED_REVENU_NET_CHAMBRE);
        assertThat(testDmOResv.getRevenuTaxeChambre()).isEqualTo(UPDATED_REVENU_TAXE_CHAMBRE);
        assertThat(testDmOResv.getRevenuNetChambreGlobal()).isEqualTo(UPDATED_REVENU_NET_CHAMBRE_GLOBAL);
        assertThat(testDmOResv.getRevenuTaxeChambreGlobal()).isEqualTo(UPDATED_REVENU_TAXE_CHAMBRE_GLOBAL);
        assertThat(testDmOResv.getRevenuNetBq()).isEqualTo(UPDATED_REVENU_NET_BQ);
        assertThat(testDmOResv.getRevenuTaxeBq()).isEqualTo(UPDATED_REVENU_TAXE_BQ);
        assertThat(testDmOResv.getRevenuNetBqGlobal()).isEqualTo(UPDATED_REVENU_NET_BQ_GLOBAL);
        assertThat(testDmOResv.getRevenuTaxeBqGlobal()).isEqualTo(UPDATED_REVENU_TAXE_BQ_GLOBAL);
        assertThat(testDmOResv.getRevenuNetExtra()).isEqualTo(UPDATED_REVENU_NET_EXTRA);
        assertThat(testDmOResv.getRevenuTaxeExtra()).isEqualTo(UPDATED_REVENU_TAXE_EXTRA);
        assertThat(testDmOResv.getRevenuNetExtraGlobal()).isEqualTo(UPDATED_REVENU_NET_EXTRA_GLOBAL);
        assertThat(testDmOResv.getRevenuTaxeExtraGlobal()).isEqualTo(UPDATED_REVENU_TAXE_EXTRA_GLOBAL);
        assertThat(testDmOResv.getRevenuNetTotal()).isEqualTo(UPDATED_REVENU_NET_TOTAL);
        assertThat(testDmOResv.getRevenuTaxeTotal()).isEqualTo(UPDATED_REVENU_TAXE_TOTAL);
        assertThat(testDmOResv.getRevenuNetTotalGlobal()).isEqualTo(UPDATED_REVENU_NET_TOTAL_GLOBAL);
        assertThat(testDmOResv.getRevenuTaxeTotalGlobal()).isEqualTo(UPDATED_REVENU_TAXE_TOTAL_GLOBAL);
        assertThat(testDmOResv.getProdRevenuChambre()).isEqualTo(UPDATED_PROD_REVENU_CHAMBRE);
        assertThat(testDmOResv.getProdRevenuBq()).isEqualTo(UPDATED_PROD_REVENU_BQ);
        assertThat(testDmOResv.getProdRevenuExtra()).isEqualTo(UPDATED_PROD_REVENU_EXTRA);
        assertThat(testDmOResv.getProdRevenuTotal()).isEqualTo(UPDATED_PROD_REVENU_TOTAL);
        assertThat(testDmOResv.getProdChambreNbNuitees()).isEqualTo(UPDATED_PROD_CHAMBRE_NB_NUITEES);
        assertThat(testDmOResv.getTechCreateDate()).isEqualTo(UPDATED_TECH_CREATE_DATE);
        assertThat(testDmOResv.getTechUpdateDate()).isEqualTo(UPDATED_TECH_UPDATE_DATE);
    }

    @Test
    @Transactional
    void putNonExistingDmOResv() throws Exception {
        int databaseSizeBeforeUpdate = dmOResvRepository.findAll().size();
        dmOResv.setId(count.incrementAndGet());

        // Create the DmOResv
        DmOResvDTO dmOResvDTO = dmOResvMapper.toDto(dmOResv);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDmOResvMockMvc
            .perform(
                put(ENTITY_API_URL_ID, dmOResvDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(dmOResvDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DmOResv in the database
        List<DmOResv> dmOResvList = dmOResvRepository.findAll();
        assertThat(dmOResvList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchDmOResv() throws Exception {
        int databaseSizeBeforeUpdate = dmOResvRepository.findAll().size();
        dmOResv.setId(count.incrementAndGet());

        // Create the DmOResv
        DmOResvDTO dmOResvDTO = dmOResvMapper.toDto(dmOResv);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDmOResvMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(dmOResvDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DmOResv in the database
        List<DmOResv> dmOResvList = dmOResvRepository.findAll();
        assertThat(dmOResvList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamDmOResv() throws Exception {
        int databaseSizeBeforeUpdate = dmOResvRepository.findAll().size();
        dmOResv.setId(count.incrementAndGet());

        // Create the DmOResv
        DmOResvDTO dmOResvDTO = dmOResvMapper.toDto(dmOResv);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDmOResvMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(dmOResvDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the DmOResv in the database
        List<DmOResv> dmOResvList = dmOResvRepository.findAll();
        assertThat(dmOResvList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateDmOResvWithPatch() throws Exception {
        // Initialize the database
        dmOResvRepository.saveAndFlush(dmOResv);

        int databaseSizeBeforeUpdate = dmOResvRepository.findAll().size();

        // Update the dmOResv using partial update
        DmOResv partialUpdatedDmOResv = new DmOResv();
        partialUpdatedDmOResv.setId(dmOResv.getId());

        partialUpdatedDmOResv
            .numLigne(UPDATED_NUM_LIGNE)
            .clientOId(UPDATED_CLIENT_O_ID)
            .clientMdmId(UPDATED_CLIENT_MDM_ID)
            .nameId(UPDATED_NAME_ID)
            .agenceNom(UPDATED_AGENCE_NOM)
            .groupeId(UPDATED_GROUPE_ID)
            .numBloc(UPDATED_NUM_BLOC)
            .typeResv(UPDATED_TYPE_RESV)
            .dateDebutResv(UPDATED_DATE_DEBUT_RESV)
            .dateFinResv(UPDATED_DATE_FIN_RESV)
            .dateAnnResv(UPDATED_DATE_ANN_RESV)
            .codeGarantie(UPDATED_CODE_GARANTIE)
            .flgDed(UPDATED_FLG_DED)
            .libPays(UPDATED_LIB_PAYS)
            .codeNationalite(UPDATED_CODE_NATIONALITE)
            .libNationalite(UPDATED_LIB_NATIONALITE)
            .codeSource(UPDATED_CODE_SOURCE)
            .libSource(UPDATED_LIB_SOURCE)
            .codeGrandSource(UPDATED_CODE_GRAND_SOURCE)
            .codeOrigine(UPDATED_CODE_ORIGINE)
            .codeMarche(UPDATED_CODE_MARCHE)
            .libMarche(UPDATED_LIB_MARCHE)
            .numChb(UPDATED_NUM_CHB)
            .descriptionTypeChb(UPDATED_DESCRIPTION_TYPE_CHB)
            .codeTypeChb(UPDATED_CODE_TYPE_CHB)
            .classChb(UPDATED_CLASS_CHB)
            .caractChb(UPDATED_CARACT_CHB)
            .typeChbDeReservation(UPDATED_TYPE_CHB_DE_RESERVATION)
            .codeTypeChbDeResv(UPDATED_CODE_TYPE_CHB_DE_RESV)
            .circuitDistribution(UPDATED_CIRCUIT_DISTRIBUTION)
            .crsInsertDate(UPDATED_CRS_INSERT_DATE)
            .datePremier(UPDATED_DATE_PREMIER)
            .statutPremier(UPDATED_STATUT_PREMIER)
            .statutDernier(UPDATED_STATUT_DERNIER)
            .occupantsGroupe(UPDATED_OCCUPANTS_GROUPE)
            .nbNuitee(UPDATED_NB_NUITEE)
            .nbAdu(UPDATED_NB_ADU)
            .nbEnf(UPDATED_NB_ENF)
            .nbPersDayU(UPDATED_NB_PERS_DAY_U)
            .nbPersDep(UPDATED_NB_PERS_DEP)
            .nbPersAnn(UPDATED_NB_PERS_ANN)
            .nbChbArr(UPDATED_NB_CHB_ARR)
            .nbChbAnn(UPDATED_NB_CHB_ANN)
            .nbChbNoshow(UPDATED_NB_CHB_NOSHOW)
            .revenuNetChambreGlobal(UPDATED_REVENU_NET_CHAMBRE_GLOBAL)
            .revenuTaxeChambreGlobal(UPDATED_REVENU_TAXE_CHAMBRE_GLOBAL)
            .revenuNetBq(UPDATED_REVENU_NET_BQ)
            .revenuTaxeBqGlobal(UPDATED_REVENU_TAXE_BQ_GLOBAL)
            .revenuTaxeExtraGlobal(UPDATED_REVENU_TAXE_EXTRA_GLOBAL)
            .revenuNetTotal(UPDATED_REVENU_NET_TOTAL)
            .revenuTaxeTotal(UPDATED_REVENU_TAXE_TOTAL)
            .revenuNetTotalGlobal(UPDATED_REVENU_NET_TOTAL_GLOBAL)
            .revenuTaxeTotalGlobal(UPDATED_REVENU_TAXE_TOTAL_GLOBAL)
            .prodRevenuChambre(UPDATED_PROD_REVENU_CHAMBRE)
            .prodRevenuBq(UPDATED_PROD_REVENU_BQ)
            .prodRevenuTotal(UPDATED_PROD_REVENU_TOTAL)
            .prodChambreNbNuitees(UPDATED_PROD_CHAMBRE_NB_NUITEES)
            .techCreateDate(UPDATED_TECH_CREATE_DATE)
            .techUpdateDate(UPDATED_TECH_UPDATE_DATE);

        restDmOResvMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedDmOResv.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedDmOResv))
            )
            .andExpect(status().isOk());

        // Validate the DmOResv in the database
        List<DmOResv> dmOResvList = dmOResvRepository.findAll();
        assertThat(dmOResvList).hasSize(databaseSizeBeforeUpdate);
        DmOResv testDmOResv = dmOResvList.get(dmOResvList.size() - 1);
        assertThat(testDmOResv.getNumLigne()).isEqualTo(UPDATED_NUM_LIGNE);
        assertThat(testDmOResv.getResort()).isEqualTo(DEFAULT_RESORT);
        assertThat(testDmOResv.getResvNameId()).isEqualTo(DEFAULT_RESV_NAME_ID);
        assertThat(testDmOResv.getClientOId()).isEqualTo(UPDATED_CLIENT_O_ID);
        assertThat(testDmOResv.getTypeChb()).isEqualTo(DEFAULT_TYPE_CHB);
        assertThat(testDmOResv.getConfirmationNo()).isEqualTo(DEFAULT_CONFIRMATION_NO);
        assertThat(testDmOResv.getClientMdmId()).isEqualTo(UPDATED_CLIENT_MDM_ID);
        assertThat(testDmOResv.getNameId()).isEqualTo(UPDATED_NAME_ID);
        assertThat(testDmOResv.getParentResvNameId()).isEqualTo(DEFAULT_PARENT_RESV_NAME_ID);
        assertThat(testDmOResv.getContactId()).isEqualTo(DEFAULT_CONTACT_ID);
        assertThat(testDmOResv.getAgenceId()).isEqualTo(DEFAULT_AGENCE_ID);
        assertThat(testDmOResv.getAgenceNom()).isEqualTo(UPDATED_AGENCE_NOM);
        assertThat(testDmOResv.getSocieteId()).isEqualTo(DEFAULT_SOCIETE_ID);
        assertThat(testDmOResv.getGroupeId()).isEqualTo(UPDATED_GROUPE_ID);
        assertThat(testDmOResv.getNumBloc()).isEqualTo(UPDATED_NUM_BLOC);
        assertThat(testDmOResv.getTypeResv()).isEqualTo(UPDATED_TYPE_RESV);
        assertThat(testDmOResv.getStatutResv()).isEqualTo(DEFAULT_STATUT_RESV);
        assertThat(testDmOResv.getDateDebutResv()).isEqualTo(UPDATED_DATE_DEBUT_RESV);
        assertThat(testDmOResv.getDateFinResv()).isEqualTo(UPDATED_DATE_FIN_RESV);
        assertThat(testDmOResv.getTruncDateDebutResv()).isEqualTo(DEFAULT_TRUNC_DATE_DEBUT_RESV);
        assertThat(testDmOResv.getTruncDateFinResv()).isEqualTo(DEFAULT_TRUNC_DATE_FIN_RESV);
        assertThat(testDmOResv.getDateAnnResv()).isEqualTo(UPDATED_DATE_ANN_RESV);
        assertThat(testDmOResv.getPseudoRoomYn()).isEqualTo(DEFAULT_PSEUDO_ROOM_YN);
        assertThat(testDmOResv.getCreateurResv()).isEqualTo(DEFAULT_CREATEUR_RESV);
        assertThat(testDmOResv.getNomCreateurResv()).isEqualTo(DEFAULT_NOM_CREATEUR_RESV);
        assertThat(testDmOResv.getCodeGarantie()).isEqualTo(UPDATED_CODE_GARANTIE);
        assertThat(testDmOResv.getFlgDed()).isEqualTo(UPDATED_FLG_DED);
        assertThat(testDmOResv.getCodePays()).isEqualTo(DEFAULT_CODE_PAYS);
        assertThat(testDmOResv.getLibPays()).isEqualTo(UPDATED_LIB_PAYS);
        assertThat(testDmOResv.getCodeNationalite()).isEqualTo(UPDATED_CODE_NATIONALITE);
        assertThat(testDmOResv.getLibNationalite()).isEqualTo(UPDATED_LIB_NATIONALITE);
        assertThat(testDmOResv.getCodeSource()).isEqualTo(UPDATED_CODE_SOURCE);
        assertThat(testDmOResv.getLibSource()).isEqualTo(UPDATED_LIB_SOURCE);
        assertThat(testDmOResv.getCodeGrandSource()).isEqualTo(UPDATED_CODE_GRAND_SOURCE);
        assertThat(testDmOResv.getCodeOrigine()).isEqualTo(UPDATED_CODE_ORIGINE);
        assertThat(testDmOResv.getLibOrigine()).isEqualTo(DEFAULT_LIB_ORIGINE);
        assertThat(testDmOResv.getCodeMarche()).isEqualTo(UPDATED_CODE_MARCHE);
        assertThat(testDmOResv.getLibMarche()).isEqualTo(UPDATED_LIB_MARCHE);
        assertThat(testDmOResv.getCodeGrandMarche()).isEqualTo(DEFAULT_CODE_GRAND_MARCHE);
        assertThat(testDmOResv.getLibGrandMarche()).isEqualTo(DEFAULT_LIB_GRAND_MARCHE);
        assertThat(testDmOResv.getCodePrix()).isEqualTo(DEFAULT_CODE_PRIX);
        assertThat(testDmOResv.getCategPrix()).isEqualTo(DEFAULT_CATEG_PRIX);
        assertThat(testDmOResv.getLibPrix()).isEqualTo(DEFAULT_LIB_PRIX);
        assertThat(testDmOResv.getNumChb()).isEqualTo(UPDATED_NUM_CHB);
        assertThat(testDmOResv.getDescriptionTypeChb()).isEqualTo(UPDATED_DESCRIPTION_TYPE_CHB);
        assertThat(testDmOResv.getCodeTypeChb()).isEqualTo(UPDATED_CODE_TYPE_CHB);
        assertThat(testDmOResv.getClassChb()).isEqualTo(UPDATED_CLASS_CHB);
        assertThat(testDmOResv.getCaractChb()).isEqualTo(UPDATED_CARACT_CHB);
        assertThat(testDmOResv.getTypeChbDeReservation()).isEqualTo(UPDATED_TYPE_CHB_DE_RESERVATION);
        assertThat(testDmOResv.getDescriptionTypeChbDeResv()).isEqualTo(DEFAULT_DESCRIPTION_TYPE_CHB_DE_RESV);
        assertThat(testDmOResv.getCodeTypeChbDeResv()).isEqualTo(UPDATED_CODE_TYPE_CHB_DE_RESV);
        assertThat(testDmOResv.getStatutDeReservation()).isEqualTo(DEFAULT_STATUT_DE_RESERVATION);
        assertThat(testDmOResv.getCircuitDistribution()).isEqualTo(UPDATED_CIRCUIT_DISTRIBUTION);
        assertThat(testDmOResv.getCircuitDistribUserRegroup()).isEqualTo(DEFAULT_CIRCUIT_DISTRIB_USER_REGROUP);
        assertThat(testDmOResv.getNumCrs()).isEqualTo(DEFAULT_NUM_CRS);
        assertThat(testDmOResv.getTypeRefCrs()).isEqualTo(DEFAULT_TYPE_REF_CRS);
        assertThat(testDmOResv.getCrsInsertDate()).isEqualTo(UPDATED_CRS_INSERT_DATE);
        assertThat(testDmOResv.getDateCreaResv()).isEqualTo(DEFAULT_DATE_CREA_RESV);
        assertThat(testDmOResv.getDatePremier()).isEqualTo(UPDATED_DATE_PREMIER);
        assertThat(testDmOResv.getStatutPremier()).isEqualTo(UPDATED_STATUT_PREMIER);
        assertThat(testDmOResv.getDateDernier()).isEqualTo(DEFAULT_DATE_DERNIER);
        assertThat(testDmOResv.getStatutDernier()).isEqualTo(UPDATED_STATUT_DERNIER);
        assertThat(testDmOResv.getDateDernierPseudo()).isEqualTo(DEFAULT_DATE_DERNIER_PSEUDO);
        assertThat(testDmOResv.getStatutDernierPseudo()).isEqualTo(DEFAULT_STATUT_DERNIER_PSEUDO);
        assertThat(testDmOResv.getDiffDtCreaAnn()).isEqualTo(DEFAULT_DIFF_DT_CREA_ANN);
        assertThat(testDmOResv.getDiffDtArrAnn()).isEqualTo(DEFAULT_DIFF_DT_ARR_ANN);
        assertThat(testDmOResv.getLeadtime()).isEqualTo(DEFAULT_LEADTIME);
        assertThat(testDmOResv.getLos()).isEqualTo(DEFAULT_LOS);
        assertThat(testDmOResv.getOccupantsGroupe()).isEqualTo(UPDATED_OCCUPANTS_GROUPE);
        assertThat(testDmOResv.getNbNuitee()).isEqualTo(UPDATED_NB_NUITEE);
        assertThat(testDmOResv.getNbNuiteeNnDed()).isEqualTo(DEFAULT_NB_NUITEE_NN_DED);
        assertThat(testDmOResv.getNbResvAnn()).isEqualTo(DEFAULT_NB_RESV_ANN);
        assertThat(testDmOResv.getNbAdu()).isEqualTo(UPDATED_NB_ADU);
        assertThat(testDmOResv.getNbEnf()).isEqualTo(UPDATED_NB_ENF);
        assertThat(testDmOResv.getNbPersDayU()).isEqualTo(UPDATED_NB_PERS_DAY_U);
        assertThat(testDmOResv.getNbPersArr()).isEqualTo(DEFAULT_NB_PERS_ARR);
        assertThat(testDmOResv.getNbPersDep()).isEqualTo(UPDATED_NB_PERS_DEP);
        assertThat(testDmOResv.getNbPersAnn()).isEqualTo(UPDATED_NB_PERS_ANN);
        assertThat(testDmOResv.getNbPersNoshow()).isEqualTo(DEFAULT_NB_PERS_NOSHOW);
        assertThat(testDmOResv.getNbChbDayU()).isEqualTo(DEFAULT_NB_CHB_DAY_U);
        assertThat(testDmOResv.getNbChbArr()).isEqualTo(UPDATED_NB_CHB_ARR);
        assertThat(testDmOResv.getNbChbDep()).isEqualTo(DEFAULT_NB_CHB_DEP);
        assertThat(testDmOResv.getNbChbAnn()).isEqualTo(UPDATED_NB_CHB_ANN);
        assertThat(testDmOResv.getNbChbNoshow()).isEqualTo(UPDATED_NB_CHB_NOSHOW);
        assertThat(testDmOResv.getRevenuNetChambre()).isEqualTo(DEFAULT_REVENU_NET_CHAMBRE);
        assertThat(testDmOResv.getRevenuTaxeChambre()).isEqualTo(DEFAULT_REVENU_TAXE_CHAMBRE);
        assertThat(testDmOResv.getRevenuNetChambreGlobal()).isEqualTo(UPDATED_REVENU_NET_CHAMBRE_GLOBAL);
        assertThat(testDmOResv.getRevenuTaxeChambreGlobal()).isEqualTo(UPDATED_REVENU_TAXE_CHAMBRE_GLOBAL);
        assertThat(testDmOResv.getRevenuNetBq()).isEqualTo(UPDATED_REVENU_NET_BQ);
        assertThat(testDmOResv.getRevenuTaxeBq()).isEqualTo(DEFAULT_REVENU_TAXE_BQ);
        assertThat(testDmOResv.getRevenuNetBqGlobal()).isEqualTo(DEFAULT_REVENU_NET_BQ_GLOBAL);
        assertThat(testDmOResv.getRevenuTaxeBqGlobal()).isEqualTo(UPDATED_REVENU_TAXE_BQ_GLOBAL);
        assertThat(testDmOResv.getRevenuNetExtra()).isEqualTo(DEFAULT_REVENU_NET_EXTRA);
        assertThat(testDmOResv.getRevenuTaxeExtra()).isEqualTo(DEFAULT_REVENU_TAXE_EXTRA);
        assertThat(testDmOResv.getRevenuNetExtraGlobal()).isEqualTo(DEFAULT_REVENU_NET_EXTRA_GLOBAL);
        assertThat(testDmOResv.getRevenuTaxeExtraGlobal()).isEqualTo(UPDATED_REVENU_TAXE_EXTRA_GLOBAL);
        assertThat(testDmOResv.getRevenuNetTotal()).isEqualTo(UPDATED_REVENU_NET_TOTAL);
        assertThat(testDmOResv.getRevenuTaxeTotal()).isEqualTo(UPDATED_REVENU_TAXE_TOTAL);
        assertThat(testDmOResv.getRevenuNetTotalGlobal()).isEqualTo(UPDATED_REVENU_NET_TOTAL_GLOBAL);
        assertThat(testDmOResv.getRevenuTaxeTotalGlobal()).isEqualTo(UPDATED_REVENU_TAXE_TOTAL_GLOBAL);
        assertThat(testDmOResv.getProdRevenuChambre()).isEqualTo(UPDATED_PROD_REVENU_CHAMBRE);
        assertThat(testDmOResv.getProdRevenuBq()).isEqualTo(UPDATED_PROD_REVENU_BQ);
        assertThat(testDmOResv.getProdRevenuExtra()).isEqualTo(DEFAULT_PROD_REVENU_EXTRA);
        assertThat(testDmOResv.getProdRevenuTotal()).isEqualTo(UPDATED_PROD_REVENU_TOTAL);
        assertThat(testDmOResv.getProdChambreNbNuitees()).isEqualTo(UPDATED_PROD_CHAMBRE_NB_NUITEES);
        assertThat(testDmOResv.getTechCreateDate()).isEqualTo(UPDATED_TECH_CREATE_DATE);
        assertThat(testDmOResv.getTechUpdateDate()).isEqualTo(UPDATED_TECH_UPDATE_DATE);
    }

    @Test
    @Transactional
    void fullUpdateDmOResvWithPatch() throws Exception {
        // Initialize the database
        dmOResvRepository.saveAndFlush(dmOResv);

        int databaseSizeBeforeUpdate = dmOResvRepository.findAll().size();

        // Update the dmOResv using partial update
        DmOResv partialUpdatedDmOResv = new DmOResv();
        partialUpdatedDmOResv.setId(dmOResv.getId());

        partialUpdatedDmOResv
            .numLigne(UPDATED_NUM_LIGNE)
            .resort(UPDATED_RESORT)
            .resvNameId(UPDATED_RESV_NAME_ID)
            .clientOId(UPDATED_CLIENT_O_ID)
            .typeChb(UPDATED_TYPE_CHB)
            .confirmationNo(UPDATED_CONFIRMATION_NO)
            .clientMdmId(UPDATED_CLIENT_MDM_ID)
            .nameId(UPDATED_NAME_ID)
            .parentResvNameId(UPDATED_PARENT_RESV_NAME_ID)
            .contactId(UPDATED_CONTACT_ID)
            .agenceId(UPDATED_AGENCE_ID)
            .agenceNom(UPDATED_AGENCE_NOM)
            .societeId(UPDATED_SOCIETE_ID)
            .groupeId(UPDATED_GROUPE_ID)
            .numBloc(UPDATED_NUM_BLOC)
            .typeResv(UPDATED_TYPE_RESV)
            .statutResv(UPDATED_STATUT_RESV)
            .dateDebutResv(UPDATED_DATE_DEBUT_RESV)
            .dateFinResv(UPDATED_DATE_FIN_RESV)
            .truncDateDebutResv(UPDATED_TRUNC_DATE_DEBUT_RESV)
            .truncDateFinResv(UPDATED_TRUNC_DATE_FIN_RESV)
            .dateAnnResv(UPDATED_DATE_ANN_RESV)
            .pseudoRoomYn(UPDATED_PSEUDO_ROOM_YN)
            .createurResv(UPDATED_CREATEUR_RESV)
            .nomCreateurResv(UPDATED_NOM_CREATEUR_RESV)
            .codeGarantie(UPDATED_CODE_GARANTIE)
            .flgDed(UPDATED_FLG_DED)
            .codePays(UPDATED_CODE_PAYS)
            .libPays(UPDATED_LIB_PAYS)
            .codeNationalite(UPDATED_CODE_NATIONALITE)
            .libNationalite(UPDATED_LIB_NATIONALITE)
            .codeSource(UPDATED_CODE_SOURCE)
            .libSource(UPDATED_LIB_SOURCE)
            .codeGrandSource(UPDATED_CODE_GRAND_SOURCE)
            .codeOrigine(UPDATED_CODE_ORIGINE)
            .libOrigine(UPDATED_LIB_ORIGINE)
            .codeMarche(UPDATED_CODE_MARCHE)
            .libMarche(UPDATED_LIB_MARCHE)
            .codeGrandMarche(UPDATED_CODE_GRAND_MARCHE)
            .libGrandMarche(UPDATED_LIB_GRAND_MARCHE)
            .codePrix(UPDATED_CODE_PRIX)
            .categPrix(UPDATED_CATEG_PRIX)
            .libPrix(UPDATED_LIB_PRIX)
            .numChb(UPDATED_NUM_CHB)
            .descriptionTypeChb(UPDATED_DESCRIPTION_TYPE_CHB)
            .codeTypeChb(UPDATED_CODE_TYPE_CHB)
            .classChb(UPDATED_CLASS_CHB)
            .caractChb(UPDATED_CARACT_CHB)
            .typeChbDeReservation(UPDATED_TYPE_CHB_DE_RESERVATION)
            .descriptionTypeChbDeResv(UPDATED_DESCRIPTION_TYPE_CHB_DE_RESV)
            .codeTypeChbDeResv(UPDATED_CODE_TYPE_CHB_DE_RESV)
            .statutDeReservation(UPDATED_STATUT_DE_RESERVATION)
            .circuitDistribution(UPDATED_CIRCUIT_DISTRIBUTION)
            .circuitDistribUserRegroup(UPDATED_CIRCUIT_DISTRIB_USER_REGROUP)
            .numCrs(UPDATED_NUM_CRS)
            .typeRefCrs(UPDATED_TYPE_REF_CRS)
            .crsInsertDate(UPDATED_CRS_INSERT_DATE)
            .dateCreaResv(UPDATED_DATE_CREA_RESV)
            .datePremier(UPDATED_DATE_PREMIER)
            .statutPremier(UPDATED_STATUT_PREMIER)
            .dateDernier(UPDATED_DATE_DERNIER)
            .statutDernier(UPDATED_STATUT_DERNIER)
            .dateDernierPseudo(UPDATED_DATE_DERNIER_PSEUDO)
            .statutDernierPseudo(UPDATED_STATUT_DERNIER_PSEUDO)
            .diffDtCreaAnn(UPDATED_DIFF_DT_CREA_ANN)
            .diffDtArrAnn(UPDATED_DIFF_DT_ARR_ANN)
            .leadtime(UPDATED_LEADTIME)
            .los(UPDATED_LOS)
            .occupantsGroupe(UPDATED_OCCUPANTS_GROUPE)
            .nbNuitee(UPDATED_NB_NUITEE)
            .nbNuiteeNnDed(UPDATED_NB_NUITEE_NN_DED)
            .nbResvAnn(UPDATED_NB_RESV_ANN)
            .nbAdu(UPDATED_NB_ADU)
            .nbEnf(UPDATED_NB_ENF)
            .nbPersDayU(UPDATED_NB_PERS_DAY_U)
            .nbPersArr(UPDATED_NB_PERS_ARR)
            .nbPersDep(UPDATED_NB_PERS_DEP)
            .nbPersAnn(UPDATED_NB_PERS_ANN)
            .nbPersNoshow(UPDATED_NB_PERS_NOSHOW)
            .nbChbDayU(UPDATED_NB_CHB_DAY_U)
            .nbChbArr(UPDATED_NB_CHB_ARR)
            .nbChbDep(UPDATED_NB_CHB_DEP)
            .nbChbAnn(UPDATED_NB_CHB_ANN)
            .nbChbNoshow(UPDATED_NB_CHB_NOSHOW)
            .revenuNetChambre(UPDATED_REVENU_NET_CHAMBRE)
            .revenuTaxeChambre(UPDATED_REVENU_TAXE_CHAMBRE)
            .revenuNetChambreGlobal(UPDATED_REVENU_NET_CHAMBRE_GLOBAL)
            .revenuTaxeChambreGlobal(UPDATED_REVENU_TAXE_CHAMBRE_GLOBAL)
            .revenuNetBq(UPDATED_REVENU_NET_BQ)
            .revenuTaxeBq(UPDATED_REVENU_TAXE_BQ)
            .revenuNetBqGlobal(UPDATED_REVENU_NET_BQ_GLOBAL)
            .revenuTaxeBqGlobal(UPDATED_REVENU_TAXE_BQ_GLOBAL)
            .revenuNetExtra(UPDATED_REVENU_NET_EXTRA)
            .revenuTaxeExtra(UPDATED_REVENU_TAXE_EXTRA)
            .revenuNetExtraGlobal(UPDATED_REVENU_NET_EXTRA_GLOBAL)
            .revenuTaxeExtraGlobal(UPDATED_REVENU_TAXE_EXTRA_GLOBAL)
            .revenuNetTotal(UPDATED_REVENU_NET_TOTAL)
            .revenuTaxeTotal(UPDATED_REVENU_TAXE_TOTAL)
            .revenuNetTotalGlobal(UPDATED_REVENU_NET_TOTAL_GLOBAL)
            .revenuTaxeTotalGlobal(UPDATED_REVENU_TAXE_TOTAL_GLOBAL)
            .prodRevenuChambre(UPDATED_PROD_REVENU_CHAMBRE)
            .prodRevenuBq(UPDATED_PROD_REVENU_BQ)
            .prodRevenuExtra(UPDATED_PROD_REVENU_EXTRA)
            .prodRevenuTotal(UPDATED_PROD_REVENU_TOTAL)
            .prodChambreNbNuitees(UPDATED_PROD_CHAMBRE_NB_NUITEES)
            .techCreateDate(UPDATED_TECH_CREATE_DATE)
            .techUpdateDate(UPDATED_TECH_UPDATE_DATE);

        restDmOResvMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedDmOResv.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedDmOResv))
            )
            .andExpect(status().isOk());

        // Validate the DmOResv in the database
        List<DmOResv> dmOResvList = dmOResvRepository.findAll();
        assertThat(dmOResvList).hasSize(databaseSizeBeforeUpdate);
        DmOResv testDmOResv = dmOResvList.get(dmOResvList.size() - 1);
        assertThat(testDmOResv.getNumLigne()).isEqualTo(UPDATED_NUM_LIGNE);
        assertThat(testDmOResv.getResort()).isEqualTo(UPDATED_RESORT);
        assertThat(testDmOResv.getResvNameId()).isEqualTo(UPDATED_RESV_NAME_ID);
        assertThat(testDmOResv.getClientOId()).isEqualTo(UPDATED_CLIENT_O_ID);
        assertThat(testDmOResv.getTypeChb()).isEqualTo(UPDATED_TYPE_CHB);
        assertThat(testDmOResv.getConfirmationNo()).isEqualTo(UPDATED_CONFIRMATION_NO);
        assertThat(testDmOResv.getClientMdmId()).isEqualTo(UPDATED_CLIENT_MDM_ID);
        assertThat(testDmOResv.getNameId()).isEqualTo(UPDATED_NAME_ID);
        assertThat(testDmOResv.getParentResvNameId()).isEqualTo(UPDATED_PARENT_RESV_NAME_ID);
        assertThat(testDmOResv.getContactId()).isEqualTo(UPDATED_CONTACT_ID);
        assertThat(testDmOResv.getAgenceId()).isEqualTo(UPDATED_AGENCE_ID);
        assertThat(testDmOResv.getAgenceNom()).isEqualTo(UPDATED_AGENCE_NOM);
        assertThat(testDmOResv.getSocieteId()).isEqualTo(UPDATED_SOCIETE_ID);
        assertThat(testDmOResv.getGroupeId()).isEqualTo(UPDATED_GROUPE_ID);
        assertThat(testDmOResv.getNumBloc()).isEqualTo(UPDATED_NUM_BLOC);
        assertThat(testDmOResv.getTypeResv()).isEqualTo(UPDATED_TYPE_RESV);
        assertThat(testDmOResv.getStatutResv()).isEqualTo(UPDATED_STATUT_RESV);
        assertThat(testDmOResv.getDateDebutResv()).isEqualTo(UPDATED_DATE_DEBUT_RESV);
        assertThat(testDmOResv.getDateFinResv()).isEqualTo(UPDATED_DATE_FIN_RESV);
        assertThat(testDmOResv.getTruncDateDebutResv()).isEqualTo(UPDATED_TRUNC_DATE_DEBUT_RESV);
        assertThat(testDmOResv.getTruncDateFinResv()).isEqualTo(UPDATED_TRUNC_DATE_FIN_RESV);
        assertThat(testDmOResv.getDateAnnResv()).isEqualTo(UPDATED_DATE_ANN_RESV);
        assertThat(testDmOResv.getPseudoRoomYn()).isEqualTo(UPDATED_PSEUDO_ROOM_YN);
        assertThat(testDmOResv.getCreateurResv()).isEqualTo(UPDATED_CREATEUR_RESV);
        assertThat(testDmOResv.getNomCreateurResv()).isEqualTo(UPDATED_NOM_CREATEUR_RESV);
        assertThat(testDmOResv.getCodeGarantie()).isEqualTo(UPDATED_CODE_GARANTIE);
        assertThat(testDmOResv.getFlgDed()).isEqualTo(UPDATED_FLG_DED);
        assertThat(testDmOResv.getCodePays()).isEqualTo(UPDATED_CODE_PAYS);
        assertThat(testDmOResv.getLibPays()).isEqualTo(UPDATED_LIB_PAYS);
        assertThat(testDmOResv.getCodeNationalite()).isEqualTo(UPDATED_CODE_NATIONALITE);
        assertThat(testDmOResv.getLibNationalite()).isEqualTo(UPDATED_LIB_NATIONALITE);
        assertThat(testDmOResv.getCodeSource()).isEqualTo(UPDATED_CODE_SOURCE);
        assertThat(testDmOResv.getLibSource()).isEqualTo(UPDATED_LIB_SOURCE);
        assertThat(testDmOResv.getCodeGrandSource()).isEqualTo(UPDATED_CODE_GRAND_SOURCE);
        assertThat(testDmOResv.getCodeOrigine()).isEqualTo(UPDATED_CODE_ORIGINE);
        assertThat(testDmOResv.getLibOrigine()).isEqualTo(UPDATED_LIB_ORIGINE);
        assertThat(testDmOResv.getCodeMarche()).isEqualTo(UPDATED_CODE_MARCHE);
        assertThat(testDmOResv.getLibMarche()).isEqualTo(UPDATED_LIB_MARCHE);
        assertThat(testDmOResv.getCodeGrandMarche()).isEqualTo(UPDATED_CODE_GRAND_MARCHE);
        assertThat(testDmOResv.getLibGrandMarche()).isEqualTo(UPDATED_LIB_GRAND_MARCHE);
        assertThat(testDmOResv.getCodePrix()).isEqualTo(UPDATED_CODE_PRIX);
        assertThat(testDmOResv.getCategPrix()).isEqualTo(UPDATED_CATEG_PRIX);
        assertThat(testDmOResv.getLibPrix()).isEqualTo(UPDATED_LIB_PRIX);
        assertThat(testDmOResv.getNumChb()).isEqualTo(UPDATED_NUM_CHB);
        assertThat(testDmOResv.getDescriptionTypeChb()).isEqualTo(UPDATED_DESCRIPTION_TYPE_CHB);
        assertThat(testDmOResv.getCodeTypeChb()).isEqualTo(UPDATED_CODE_TYPE_CHB);
        assertThat(testDmOResv.getClassChb()).isEqualTo(UPDATED_CLASS_CHB);
        assertThat(testDmOResv.getCaractChb()).isEqualTo(UPDATED_CARACT_CHB);
        assertThat(testDmOResv.getTypeChbDeReservation()).isEqualTo(UPDATED_TYPE_CHB_DE_RESERVATION);
        assertThat(testDmOResv.getDescriptionTypeChbDeResv()).isEqualTo(UPDATED_DESCRIPTION_TYPE_CHB_DE_RESV);
        assertThat(testDmOResv.getCodeTypeChbDeResv()).isEqualTo(UPDATED_CODE_TYPE_CHB_DE_RESV);
        assertThat(testDmOResv.getStatutDeReservation()).isEqualTo(UPDATED_STATUT_DE_RESERVATION);
        assertThat(testDmOResv.getCircuitDistribution()).isEqualTo(UPDATED_CIRCUIT_DISTRIBUTION);
        assertThat(testDmOResv.getCircuitDistribUserRegroup()).isEqualTo(UPDATED_CIRCUIT_DISTRIB_USER_REGROUP);
        assertThat(testDmOResv.getNumCrs()).isEqualTo(UPDATED_NUM_CRS);
        assertThat(testDmOResv.getTypeRefCrs()).isEqualTo(UPDATED_TYPE_REF_CRS);
        assertThat(testDmOResv.getCrsInsertDate()).isEqualTo(UPDATED_CRS_INSERT_DATE);
        assertThat(testDmOResv.getDateCreaResv()).isEqualTo(UPDATED_DATE_CREA_RESV);
        assertThat(testDmOResv.getDatePremier()).isEqualTo(UPDATED_DATE_PREMIER);
        assertThat(testDmOResv.getStatutPremier()).isEqualTo(UPDATED_STATUT_PREMIER);
        assertThat(testDmOResv.getDateDernier()).isEqualTo(UPDATED_DATE_DERNIER);
        assertThat(testDmOResv.getStatutDernier()).isEqualTo(UPDATED_STATUT_DERNIER);
        assertThat(testDmOResv.getDateDernierPseudo()).isEqualTo(UPDATED_DATE_DERNIER_PSEUDO);
        assertThat(testDmOResv.getStatutDernierPseudo()).isEqualTo(UPDATED_STATUT_DERNIER_PSEUDO);
        assertThat(testDmOResv.getDiffDtCreaAnn()).isEqualTo(UPDATED_DIFF_DT_CREA_ANN);
        assertThat(testDmOResv.getDiffDtArrAnn()).isEqualTo(UPDATED_DIFF_DT_ARR_ANN);
        assertThat(testDmOResv.getLeadtime()).isEqualTo(UPDATED_LEADTIME);
        assertThat(testDmOResv.getLos()).isEqualTo(UPDATED_LOS);
        assertThat(testDmOResv.getOccupantsGroupe()).isEqualTo(UPDATED_OCCUPANTS_GROUPE);
        assertThat(testDmOResv.getNbNuitee()).isEqualTo(UPDATED_NB_NUITEE);
        assertThat(testDmOResv.getNbNuiteeNnDed()).isEqualTo(UPDATED_NB_NUITEE_NN_DED);
        assertThat(testDmOResv.getNbResvAnn()).isEqualTo(UPDATED_NB_RESV_ANN);
        assertThat(testDmOResv.getNbAdu()).isEqualTo(UPDATED_NB_ADU);
        assertThat(testDmOResv.getNbEnf()).isEqualTo(UPDATED_NB_ENF);
        assertThat(testDmOResv.getNbPersDayU()).isEqualTo(UPDATED_NB_PERS_DAY_U);
        assertThat(testDmOResv.getNbPersArr()).isEqualTo(UPDATED_NB_PERS_ARR);
        assertThat(testDmOResv.getNbPersDep()).isEqualTo(UPDATED_NB_PERS_DEP);
        assertThat(testDmOResv.getNbPersAnn()).isEqualTo(UPDATED_NB_PERS_ANN);
        assertThat(testDmOResv.getNbPersNoshow()).isEqualTo(UPDATED_NB_PERS_NOSHOW);
        assertThat(testDmOResv.getNbChbDayU()).isEqualTo(UPDATED_NB_CHB_DAY_U);
        assertThat(testDmOResv.getNbChbArr()).isEqualTo(UPDATED_NB_CHB_ARR);
        assertThat(testDmOResv.getNbChbDep()).isEqualTo(UPDATED_NB_CHB_DEP);
        assertThat(testDmOResv.getNbChbAnn()).isEqualTo(UPDATED_NB_CHB_ANN);
        assertThat(testDmOResv.getNbChbNoshow()).isEqualTo(UPDATED_NB_CHB_NOSHOW);
        assertThat(testDmOResv.getRevenuNetChambre()).isEqualTo(UPDATED_REVENU_NET_CHAMBRE);
        assertThat(testDmOResv.getRevenuTaxeChambre()).isEqualTo(UPDATED_REVENU_TAXE_CHAMBRE);
        assertThat(testDmOResv.getRevenuNetChambreGlobal()).isEqualTo(UPDATED_REVENU_NET_CHAMBRE_GLOBAL);
        assertThat(testDmOResv.getRevenuTaxeChambreGlobal()).isEqualTo(UPDATED_REVENU_TAXE_CHAMBRE_GLOBAL);
        assertThat(testDmOResv.getRevenuNetBq()).isEqualTo(UPDATED_REVENU_NET_BQ);
        assertThat(testDmOResv.getRevenuTaxeBq()).isEqualTo(UPDATED_REVENU_TAXE_BQ);
        assertThat(testDmOResv.getRevenuNetBqGlobal()).isEqualTo(UPDATED_REVENU_NET_BQ_GLOBAL);
        assertThat(testDmOResv.getRevenuTaxeBqGlobal()).isEqualTo(UPDATED_REVENU_TAXE_BQ_GLOBAL);
        assertThat(testDmOResv.getRevenuNetExtra()).isEqualTo(UPDATED_REVENU_NET_EXTRA);
        assertThat(testDmOResv.getRevenuTaxeExtra()).isEqualTo(UPDATED_REVENU_TAXE_EXTRA);
        assertThat(testDmOResv.getRevenuNetExtraGlobal()).isEqualTo(UPDATED_REVENU_NET_EXTRA_GLOBAL);
        assertThat(testDmOResv.getRevenuTaxeExtraGlobal()).isEqualTo(UPDATED_REVENU_TAXE_EXTRA_GLOBAL);
        assertThat(testDmOResv.getRevenuNetTotal()).isEqualTo(UPDATED_REVENU_NET_TOTAL);
        assertThat(testDmOResv.getRevenuTaxeTotal()).isEqualTo(UPDATED_REVENU_TAXE_TOTAL);
        assertThat(testDmOResv.getRevenuNetTotalGlobal()).isEqualTo(UPDATED_REVENU_NET_TOTAL_GLOBAL);
        assertThat(testDmOResv.getRevenuTaxeTotalGlobal()).isEqualTo(UPDATED_REVENU_TAXE_TOTAL_GLOBAL);
        assertThat(testDmOResv.getProdRevenuChambre()).isEqualTo(UPDATED_PROD_REVENU_CHAMBRE);
        assertThat(testDmOResv.getProdRevenuBq()).isEqualTo(UPDATED_PROD_REVENU_BQ);
        assertThat(testDmOResv.getProdRevenuExtra()).isEqualTo(UPDATED_PROD_REVENU_EXTRA);
        assertThat(testDmOResv.getProdRevenuTotal()).isEqualTo(UPDATED_PROD_REVENU_TOTAL);
        assertThat(testDmOResv.getProdChambreNbNuitees()).isEqualTo(UPDATED_PROD_CHAMBRE_NB_NUITEES);
        assertThat(testDmOResv.getTechCreateDate()).isEqualTo(UPDATED_TECH_CREATE_DATE);
        assertThat(testDmOResv.getTechUpdateDate()).isEqualTo(UPDATED_TECH_UPDATE_DATE);
    }

    @Test
    @Transactional
    void patchNonExistingDmOResv() throws Exception {
        int databaseSizeBeforeUpdate = dmOResvRepository.findAll().size();
        dmOResv.setId(count.incrementAndGet());

        // Create the DmOResv
        DmOResvDTO dmOResvDTO = dmOResvMapper.toDto(dmOResv);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDmOResvMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, dmOResvDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(dmOResvDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DmOResv in the database
        List<DmOResv> dmOResvList = dmOResvRepository.findAll();
        assertThat(dmOResvList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchDmOResv() throws Exception {
        int databaseSizeBeforeUpdate = dmOResvRepository.findAll().size();
        dmOResv.setId(count.incrementAndGet());

        // Create the DmOResv
        DmOResvDTO dmOResvDTO = dmOResvMapper.toDto(dmOResv);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDmOResvMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(dmOResvDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DmOResv in the database
        List<DmOResv> dmOResvList = dmOResvRepository.findAll();
        assertThat(dmOResvList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamDmOResv() throws Exception {
        int databaseSizeBeforeUpdate = dmOResvRepository.findAll().size();
        dmOResv.setId(count.incrementAndGet());

        // Create the DmOResv
        DmOResvDTO dmOResvDTO = dmOResvMapper.toDto(dmOResv);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDmOResvMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(dmOResvDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the DmOResv in the database
        List<DmOResv> dmOResvList = dmOResvRepository.findAll();
        assertThat(dmOResvList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteDmOResv() throws Exception {
        // Initialize the database
        dmOResvRepository.saveAndFlush(dmOResv);

        int databaseSizeBeforeDelete = dmOResvRepository.findAll().size();

        // Delete the dmOResv
        restDmOResvMockMvc
            .perform(delete(ENTITY_API_URL_ID, dmOResv.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<DmOResv> dmOResvList = dmOResvRepository.findAll();
        assertThat(dmOResvList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
