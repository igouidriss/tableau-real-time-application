import dayjs from 'dayjs/esm';

export interface IDmClientMdmNtnltyCntry {
  id: number;
  prtyFk?: string | null;
  frstNtnltFrmt?: string | null;
  frstContinent?: string | null;
  scndNtnltFrmt?: string | null;
  scndContinent?: string | null;
  thrdNtnltFrmt?: string | null;
  thrdContinent?: string | null;
  frthNtnltFrmt?: string | null;
  frthContinent?: string | null;
  techLineage?: string | null;
  techCreatedDate?: dayjs.Dayjs | null;
  techUpdatedDate?: dayjs.Dayjs | null;
  techMapping?: string | null;
  techComment?: string | null;
}

export type NewDmClientMdmNtnltyCntry = Omit<IDmClientMdmNtnltyCntry, 'id'> & { id: null };
