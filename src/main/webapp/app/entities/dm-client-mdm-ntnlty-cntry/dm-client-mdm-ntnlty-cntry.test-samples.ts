import dayjs from 'dayjs/esm';

import { IDmClientMdmNtnltyCntry, NewDmClientMdmNtnltyCntry } from './dm-client-mdm-ntnlty-cntry.model';

export const sampleWithRequiredData: IDmClientMdmNtnltyCntry = {
  id: 8139,
  prtyFk: 'unless',
};

export const sampleWithPartialData: IDmClientMdmNtnltyCntry = {
  id: 13734,
  prtyFk: 'rigidly provided lest',
  frstContinent: 'for since spite',
  scndNtnltFrmt: 'whoa which',
  thrdContinent: 'at',
  frthContinent: 'hm mechanically psst',
  techLineage: 'wildly concentrate plus',
  techCreatedDate: dayjs('2023-10-24'),
};

export const sampleWithFullData: IDmClientMdmNtnltyCntry = {
  id: 6243,
  prtyFk: 'anniversary',
  frstNtnltFrmt: 'brr',
  frstContinent: 'ouch woot',
  scndNtnltFrmt: 'nut cascade',
  scndContinent: 'decoy nicety physically',
  thrdNtnltFrmt: 'yum approve stucco',
  thrdContinent: 'within',
  frthNtnltFrmt: 'beautifully hearken influence',
  frthContinent: 'ballet',
  techLineage: 'dally upward regular',
  techCreatedDate: dayjs('2023-10-24'),
  techUpdatedDate: dayjs('2023-10-23'),
  techMapping: 'shovel',
  techComment: 'dangerous woot er',
};

export const sampleWithNewData: NewDmClientMdmNtnltyCntry = {
  prtyFk: 'suction quietly inwardly',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
