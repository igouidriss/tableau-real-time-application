import dayjs from 'dayjs/esm';

import { IDmClientMdmAddrCntry, NewDmClientMdmAddrCntry } from './dm-client-mdm-addr-cntry.model';

export const sampleWithRequiredData: IDmClientMdmAddrCntry = {
  id: 31767,
  prtyFk: 'supposing decant brr',
};

export const sampleWithPartialData: IDmClientMdmAddrCntry = {
  id: 31671,
  prtyFk: 'zero through',
  frstCntryFrmt: 'round',
  frstContinent: 'release impoverish fulminate',
  scndCntryFrmt: 'soupy',
  thrdCntryFrmt: 'monthly so instead',
  thrdContinent: 'tremendous',
  frthCntryFrmt: 'marketplace famously mindless',
  frthContinent: 'stalk yesterday crate',
  techMapping: 'qua transport',
  techComment: 'midst disappoint blissfully',
};

export const sampleWithFullData: IDmClientMdmAddrCntry = {
  id: 20069,
  prtyFk: 'yum accord',
  frstCntryFrmt: 'if brightly',
  frstContinent: 'fulfil',
  scndCntryFrmt: 'especially',
  scndContinent: 'oof',
  thrdCntryFrmt: 'patiently',
  thrdContinent: 'trick geez',
  frthCntryFrmt: 'overtax bossy',
  frthContinent: 'past',
  techLineage: 'because artifact quizzical',
  techCreatedDate: dayjs('2023-10-24'),
  techUpdatedDate: dayjs('2023-10-24'),
  techMapping: 'wavy',
  techComment: 'wholesale aboard',
};

export const sampleWithNewData: NewDmClientMdmAddrCntry = {
  prtyFk: 'recipe dreamily ducks',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
