import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { DATE_FORMAT } from 'app/config/input.constants';
import { IDmOResv } from '../dm-o-resv.model';
import { sampleWithRequiredData, sampleWithNewData, sampleWithPartialData, sampleWithFullData } from '../dm-o-resv.test-samples';

import { DmOResvService, RestDmOResv } from './dm-o-resv.service';

const requireRestSample: RestDmOResv = {
  ...sampleWithRequiredData,
  dateDebutResv: sampleWithRequiredData.dateDebutResv?.format(DATE_FORMAT),
  dateFinResv: sampleWithRequiredData.dateFinResv?.format(DATE_FORMAT),
  truncDateDebutResv: sampleWithRequiredData.truncDateDebutResv?.format(DATE_FORMAT),
  truncDateFinResv: sampleWithRequiredData.truncDateFinResv?.format(DATE_FORMAT),
  dateAnnResv: sampleWithRequiredData.dateAnnResv?.format(DATE_FORMAT),
  crsInsertDate: sampleWithRequiredData.crsInsertDate?.format(DATE_FORMAT),
  dateCreaResv: sampleWithRequiredData.dateCreaResv?.format(DATE_FORMAT),
  datePremier: sampleWithRequiredData.datePremier?.format(DATE_FORMAT),
  dateDernier: sampleWithRequiredData.dateDernier?.format(DATE_FORMAT),
  dateDernierPseudo: sampleWithRequiredData.dateDernierPseudo?.format(DATE_FORMAT),
  techCreateDate: sampleWithRequiredData.techCreateDate?.format(DATE_FORMAT),
  techUpdateDate: sampleWithRequiredData.techUpdateDate?.format(DATE_FORMAT),
};

describe('DmOResv Service', () => {
  let service: DmOResvService;
  let httpMock: HttpTestingController;
  let expectedResult: IDmOResv | IDmOResv[] | boolean | null;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    expectedResult = null;
    service = TestBed.inject(DmOResvService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  describe('Service methods', () => {
    it('should find an element', () => {
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.find(123).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'GET' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should create a DmOResv', () => {
      const dmOResv = { ...sampleWithNewData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.create(dmOResv).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'POST' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should update a DmOResv', () => {
      const dmOResv = { ...sampleWithRequiredData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.update(dmOResv).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PUT' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should partial update a DmOResv', () => {
      const patchObject = { ...sampleWithPartialData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.partialUpdate(patchObject).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PATCH' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should return a list of DmOResv', () => {
      const returnedFromService = { ...requireRestSample };

      const expected = { ...sampleWithRequiredData };

      service.query().subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'GET' });
      req.flush([returnedFromService]);
      httpMock.verify();
      expect(expectedResult).toMatchObject([expected]);
    });

    it('should delete a DmOResv', () => {
      const expected = true;

      service.delete(123).subscribe(resp => (expectedResult = resp.ok));

      const req = httpMock.expectOne({ method: 'DELETE' });
      req.flush({ status: 200 });
      expect(expectedResult).toBe(expected);
    });

    describe('addDmOResvToCollectionIfMissing', () => {
      it('should add a DmOResv to an empty array', () => {
        const dmOResv: IDmOResv = sampleWithRequiredData;
        expectedResult = service.addDmOResvToCollectionIfMissing([], dmOResv);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(dmOResv);
      });

      it('should not add a DmOResv to an array that contains it', () => {
        const dmOResv: IDmOResv = sampleWithRequiredData;
        const dmOResvCollection: IDmOResv[] = [
          {
            ...dmOResv,
          },
          sampleWithPartialData,
        ];
        expectedResult = service.addDmOResvToCollectionIfMissing(dmOResvCollection, dmOResv);
        expect(expectedResult).toHaveLength(2);
      });

      it("should add a DmOResv to an array that doesn't contain it", () => {
        const dmOResv: IDmOResv = sampleWithRequiredData;
        const dmOResvCollection: IDmOResv[] = [sampleWithPartialData];
        expectedResult = service.addDmOResvToCollectionIfMissing(dmOResvCollection, dmOResv);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(dmOResv);
      });

      it('should add only unique DmOResv to an array', () => {
        const dmOResvArray: IDmOResv[] = [sampleWithRequiredData, sampleWithPartialData, sampleWithFullData];
        const dmOResvCollection: IDmOResv[] = [sampleWithRequiredData];
        expectedResult = service.addDmOResvToCollectionIfMissing(dmOResvCollection, ...dmOResvArray);
        expect(expectedResult).toHaveLength(3);
      });

      it('should accept varargs', () => {
        const dmOResv: IDmOResv = sampleWithRequiredData;
        const dmOResv2: IDmOResv = sampleWithPartialData;
        expectedResult = service.addDmOResvToCollectionIfMissing([], dmOResv, dmOResv2);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(dmOResv);
        expect(expectedResult).toContain(dmOResv2);
      });

      it('should accept null and undefined values', () => {
        const dmOResv: IDmOResv = sampleWithRequiredData;
        expectedResult = service.addDmOResvToCollectionIfMissing([], null, dmOResv, undefined);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(dmOResv);
      });

      it('should return initial array if no DmOResv is added', () => {
        const dmOResvCollection: IDmOResv[] = [sampleWithRequiredData];
        expectedResult = service.addDmOResvToCollectionIfMissing(dmOResvCollection, undefined, null);
        expect(expectedResult).toEqual(dmOResvCollection);
      });
    });

    describe('compareDmOResv', () => {
      it('Should return true if both entities are null', () => {
        const entity1 = null;
        const entity2 = null;

        const compareResult = service.compareDmOResv(entity1, entity2);

        expect(compareResult).toEqual(true);
      });

      it('Should return false if one entity is null', () => {
        const entity1 = { id: 123 };
        const entity2 = null;

        const compareResult1 = service.compareDmOResv(entity1, entity2);
        const compareResult2 = service.compareDmOResv(entity2, entity1);

        expect(compareResult1).toEqual(false);
        expect(compareResult2).toEqual(false);
      });

      it('Should return false if primaryKey differs', () => {
        const entity1 = { id: 123 };
        const entity2 = { id: 456 };

        const compareResult1 = service.compareDmOResv(entity1, entity2);
        const compareResult2 = service.compareDmOResv(entity2, entity1);

        expect(compareResult1).toEqual(false);
        expect(compareResult2).toEqual(false);
      });

      it('Should return false if primaryKey matches', () => {
        const entity1 = { id: 123 };
        const entity2 = { id: 123 };

        const compareResult1 = service.compareDmOResv(entity1, entity2);
        const compareResult2 = service.compareDmOResv(entity2, entity1);

        expect(compareResult1).toEqual(true);
        expect(compareResult2).toEqual(true);
      });
    });
  });

  afterEach(() => {
    httpMock.verify();
  });
});
