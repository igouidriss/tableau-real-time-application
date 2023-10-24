import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { DATE_FORMAT } from 'app/config/input.constants';
import { IDmClientMdmAddrCntry } from '../dm-client-mdm-addr-cntry.model';
import {
  sampleWithRequiredData,
  sampleWithNewData,
  sampleWithPartialData,
  sampleWithFullData,
} from '../dm-client-mdm-addr-cntry.test-samples';

import { DmClientMdmAddrCntryService, RestDmClientMdmAddrCntry } from './dm-client-mdm-addr-cntry.service';

const requireRestSample: RestDmClientMdmAddrCntry = {
  ...sampleWithRequiredData,
  techCreatedDate: sampleWithRequiredData.techCreatedDate?.format(DATE_FORMAT),
  techUpdatedDate: sampleWithRequiredData.techUpdatedDate?.format(DATE_FORMAT),
};

describe('DmClientMdmAddrCntry Service', () => {
  let service: DmClientMdmAddrCntryService;
  let httpMock: HttpTestingController;
  let expectedResult: IDmClientMdmAddrCntry | IDmClientMdmAddrCntry[] | boolean | null;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    expectedResult = null;
    service = TestBed.inject(DmClientMdmAddrCntryService);
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

    it('should create a DmClientMdmAddrCntry', () => {
      const dmClientMdmAddrCntry = { ...sampleWithNewData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.create(dmClientMdmAddrCntry).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'POST' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should update a DmClientMdmAddrCntry', () => {
      const dmClientMdmAddrCntry = { ...sampleWithRequiredData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.update(dmClientMdmAddrCntry).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PUT' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should partial update a DmClientMdmAddrCntry', () => {
      const patchObject = { ...sampleWithPartialData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.partialUpdate(patchObject).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PATCH' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should return a list of DmClientMdmAddrCntry', () => {
      const returnedFromService = { ...requireRestSample };

      const expected = { ...sampleWithRequiredData };

      service.query().subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'GET' });
      req.flush([returnedFromService]);
      httpMock.verify();
      expect(expectedResult).toMatchObject([expected]);
    });

    it('should delete a DmClientMdmAddrCntry', () => {
      const expected = true;

      service.delete(123).subscribe(resp => (expectedResult = resp.ok));

      const req = httpMock.expectOne({ method: 'DELETE' });
      req.flush({ status: 200 });
      expect(expectedResult).toBe(expected);
    });

    describe('addDmClientMdmAddrCntryToCollectionIfMissing', () => {
      it('should add a DmClientMdmAddrCntry to an empty array', () => {
        const dmClientMdmAddrCntry: IDmClientMdmAddrCntry = sampleWithRequiredData;
        expectedResult = service.addDmClientMdmAddrCntryToCollectionIfMissing([], dmClientMdmAddrCntry);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(dmClientMdmAddrCntry);
      });

      it('should not add a DmClientMdmAddrCntry to an array that contains it', () => {
        const dmClientMdmAddrCntry: IDmClientMdmAddrCntry = sampleWithRequiredData;
        const dmClientMdmAddrCntryCollection: IDmClientMdmAddrCntry[] = [
          {
            ...dmClientMdmAddrCntry,
          },
          sampleWithPartialData,
        ];
        expectedResult = service.addDmClientMdmAddrCntryToCollectionIfMissing(dmClientMdmAddrCntryCollection, dmClientMdmAddrCntry);
        expect(expectedResult).toHaveLength(2);
      });

      it("should add a DmClientMdmAddrCntry to an array that doesn't contain it", () => {
        const dmClientMdmAddrCntry: IDmClientMdmAddrCntry = sampleWithRequiredData;
        const dmClientMdmAddrCntryCollection: IDmClientMdmAddrCntry[] = [sampleWithPartialData];
        expectedResult = service.addDmClientMdmAddrCntryToCollectionIfMissing(dmClientMdmAddrCntryCollection, dmClientMdmAddrCntry);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(dmClientMdmAddrCntry);
      });

      it('should add only unique DmClientMdmAddrCntry to an array', () => {
        const dmClientMdmAddrCntryArray: IDmClientMdmAddrCntry[] = [sampleWithRequiredData, sampleWithPartialData, sampleWithFullData];
        const dmClientMdmAddrCntryCollection: IDmClientMdmAddrCntry[] = [sampleWithRequiredData];
        expectedResult = service.addDmClientMdmAddrCntryToCollectionIfMissing(dmClientMdmAddrCntryCollection, ...dmClientMdmAddrCntryArray);
        expect(expectedResult).toHaveLength(3);
      });

      it('should accept varargs', () => {
        const dmClientMdmAddrCntry: IDmClientMdmAddrCntry = sampleWithRequiredData;
        const dmClientMdmAddrCntry2: IDmClientMdmAddrCntry = sampleWithPartialData;
        expectedResult = service.addDmClientMdmAddrCntryToCollectionIfMissing([], dmClientMdmAddrCntry, dmClientMdmAddrCntry2);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(dmClientMdmAddrCntry);
        expect(expectedResult).toContain(dmClientMdmAddrCntry2);
      });

      it('should accept null and undefined values', () => {
        const dmClientMdmAddrCntry: IDmClientMdmAddrCntry = sampleWithRequiredData;
        expectedResult = service.addDmClientMdmAddrCntryToCollectionIfMissing([], null, dmClientMdmAddrCntry, undefined);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(dmClientMdmAddrCntry);
      });

      it('should return initial array if no DmClientMdmAddrCntry is added', () => {
        const dmClientMdmAddrCntryCollection: IDmClientMdmAddrCntry[] = [sampleWithRequiredData];
        expectedResult = service.addDmClientMdmAddrCntryToCollectionIfMissing(dmClientMdmAddrCntryCollection, undefined, null);
        expect(expectedResult).toEqual(dmClientMdmAddrCntryCollection);
      });
    });

    describe('compareDmClientMdmAddrCntry', () => {
      it('Should return true if both entities are null', () => {
        const entity1 = null;
        const entity2 = null;

        const compareResult = service.compareDmClientMdmAddrCntry(entity1, entity2);

        expect(compareResult).toEqual(true);
      });

      it('Should return false if one entity is null', () => {
        const entity1 = { id: 123 };
        const entity2 = null;

        const compareResult1 = service.compareDmClientMdmAddrCntry(entity1, entity2);
        const compareResult2 = service.compareDmClientMdmAddrCntry(entity2, entity1);

        expect(compareResult1).toEqual(false);
        expect(compareResult2).toEqual(false);
      });

      it('Should return false if primaryKey differs', () => {
        const entity1 = { id: 123 };
        const entity2 = { id: 456 };

        const compareResult1 = service.compareDmClientMdmAddrCntry(entity1, entity2);
        const compareResult2 = service.compareDmClientMdmAddrCntry(entity2, entity1);

        expect(compareResult1).toEqual(false);
        expect(compareResult2).toEqual(false);
      });

      it('Should return false if primaryKey matches', () => {
        const entity1 = { id: 123 };
        const entity2 = { id: 123 };

        const compareResult1 = service.compareDmClientMdmAddrCntry(entity1, entity2);
        const compareResult2 = service.compareDmClientMdmAddrCntry(entity2, entity1);

        expect(compareResult1).toEqual(true);
        expect(compareResult2).toEqual(true);
      });
    });
  });

  afterEach(() => {
    httpMock.verify();
  });
});
