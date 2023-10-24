import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { DATE_FORMAT } from 'app/config/input.constants';
import { IDmClientMdmNtnltyCntry } from '../dm-client-mdm-ntnlty-cntry.model';
import {
  sampleWithRequiredData,
  sampleWithNewData,
  sampleWithPartialData,
  sampleWithFullData,
} from '../dm-client-mdm-ntnlty-cntry.test-samples';

import { DmClientMdmNtnltyCntryService, RestDmClientMdmNtnltyCntry } from './dm-client-mdm-ntnlty-cntry.service';

const requireRestSample: RestDmClientMdmNtnltyCntry = {
  ...sampleWithRequiredData,
  techCreatedDate: sampleWithRequiredData.techCreatedDate?.format(DATE_FORMAT),
  techUpdatedDate: sampleWithRequiredData.techUpdatedDate?.format(DATE_FORMAT),
};

describe('DmClientMdmNtnltyCntry Service', () => {
  let service: DmClientMdmNtnltyCntryService;
  let httpMock: HttpTestingController;
  let expectedResult: IDmClientMdmNtnltyCntry | IDmClientMdmNtnltyCntry[] | boolean | null;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    expectedResult = null;
    service = TestBed.inject(DmClientMdmNtnltyCntryService);
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

    it('should create a DmClientMdmNtnltyCntry', () => {
      const dmClientMdmNtnltyCntry = { ...sampleWithNewData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.create(dmClientMdmNtnltyCntry).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'POST' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should update a DmClientMdmNtnltyCntry', () => {
      const dmClientMdmNtnltyCntry = { ...sampleWithRequiredData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.update(dmClientMdmNtnltyCntry).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PUT' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should partial update a DmClientMdmNtnltyCntry', () => {
      const patchObject = { ...sampleWithPartialData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.partialUpdate(patchObject).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PATCH' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should return a list of DmClientMdmNtnltyCntry', () => {
      const returnedFromService = { ...requireRestSample };

      const expected = { ...sampleWithRequiredData };

      service.query().subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'GET' });
      req.flush([returnedFromService]);
      httpMock.verify();
      expect(expectedResult).toMatchObject([expected]);
    });

    it('should delete a DmClientMdmNtnltyCntry', () => {
      const expected = true;

      service.delete(123).subscribe(resp => (expectedResult = resp.ok));

      const req = httpMock.expectOne({ method: 'DELETE' });
      req.flush({ status: 200 });
      expect(expectedResult).toBe(expected);
    });

    describe('addDmClientMdmNtnltyCntryToCollectionIfMissing', () => {
      it('should add a DmClientMdmNtnltyCntry to an empty array', () => {
        const dmClientMdmNtnltyCntry: IDmClientMdmNtnltyCntry = sampleWithRequiredData;
        expectedResult = service.addDmClientMdmNtnltyCntryToCollectionIfMissing([], dmClientMdmNtnltyCntry);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(dmClientMdmNtnltyCntry);
      });

      it('should not add a DmClientMdmNtnltyCntry to an array that contains it', () => {
        const dmClientMdmNtnltyCntry: IDmClientMdmNtnltyCntry = sampleWithRequiredData;
        const dmClientMdmNtnltyCntryCollection: IDmClientMdmNtnltyCntry[] = [
          {
            ...dmClientMdmNtnltyCntry,
          },
          sampleWithPartialData,
        ];
        expectedResult = service.addDmClientMdmNtnltyCntryToCollectionIfMissing(dmClientMdmNtnltyCntryCollection, dmClientMdmNtnltyCntry);
        expect(expectedResult).toHaveLength(2);
      });

      it("should add a DmClientMdmNtnltyCntry to an array that doesn't contain it", () => {
        const dmClientMdmNtnltyCntry: IDmClientMdmNtnltyCntry = sampleWithRequiredData;
        const dmClientMdmNtnltyCntryCollection: IDmClientMdmNtnltyCntry[] = [sampleWithPartialData];
        expectedResult = service.addDmClientMdmNtnltyCntryToCollectionIfMissing(dmClientMdmNtnltyCntryCollection, dmClientMdmNtnltyCntry);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(dmClientMdmNtnltyCntry);
      });

      it('should add only unique DmClientMdmNtnltyCntry to an array', () => {
        const dmClientMdmNtnltyCntryArray: IDmClientMdmNtnltyCntry[] = [sampleWithRequiredData, sampleWithPartialData, sampleWithFullData];
        const dmClientMdmNtnltyCntryCollection: IDmClientMdmNtnltyCntry[] = [sampleWithRequiredData];
        expectedResult = service.addDmClientMdmNtnltyCntryToCollectionIfMissing(
          dmClientMdmNtnltyCntryCollection,
          ...dmClientMdmNtnltyCntryArray,
        );
        expect(expectedResult).toHaveLength(3);
      });

      it('should accept varargs', () => {
        const dmClientMdmNtnltyCntry: IDmClientMdmNtnltyCntry = sampleWithRequiredData;
        const dmClientMdmNtnltyCntry2: IDmClientMdmNtnltyCntry = sampleWithPartialData;
        expectedResult = service.addDmClientMdmNtnltyCntryToCollectionIfMissing([], dmClientMdmNtnltyCntry, dmClientMdmNtnltyCntry2);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(dmClientMdmNtnltyCntry);
        expect(expectedResult).toContain(dmClientMdmNtnltyCntry2);
      });

      it('should accept null and undefined values', () => {
        const dmClientMdmNtnltyCntry: IDmClientMdmNtnltyCntry = sampleWithRequiredData;
        expectedResult = service.addDmClientMdmNtnltyCntryToCollectionIfMissing([], null, dmClientMdmNtnltyCntry, undefined);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(dmClientMdmNtnltyCntry);
      });

      it('should return initial array if no DmClientMdmNtnltyCntry is added', () => {
        const dmClientMdmNtnltyCntryCollection: IDmClientMdmNtnltyCntry[] = [sampleWithRequiredData];
        expectedResult = service.addDmClientMdmNtnltyCntryToCollectionIfMissing(dmClientMdmNtnltyCntryCollection, undefined, null);
        expect(expectedResult).toEqual(dmClientMdmNtnltyCntryCollection);
      });
    });

    describe('compareDmClientMdmNtnltyCntry', () => {
      it('Should return true if both entities are null', () => {
        const entity1 = null;
        const entity2 = null;

        const compareResult = service.compareDmClientMdmNtnltyCntry(entity1, entity2);

        expect(compareResult).toEqual(true);
      });

      it('Should return false if one entity is null', () => {
        const entity1 = { id: 123 };
        const entity2 = null;

        const compareResult1 = service.compareDmClientMdmNtnltyCntry(entity1, entity2);
        const compareResult2 = service.compareDmClientMdmNtnltyCntry(entity2, entity1);

        expect(compareResult1).toEqual(false);
        expect(compareResult2).toEqual(false);
      });

      it('Should return false if primaryKey differs', () => {
        const entity1 = { id: 123 };
        const entity2 = { id: 456 };

        const compareResult1 = service.compareDmClientMdmNtnltyCntry(entity1, entity2);
        const compareResult2 = service.compareDmClientMdmNtnltyCntry(entity2, entity1);

        expect(compareResult1).toEqual(false);
        expect(compareResult2).toEqual(false);
      });

      it('Should return false if primaryKey matches', () => {
        const entity1 = { id: 123 };
        const entity2 = { id: 123 };

        const compareResult1 = service.compareDmClientMdmNtnltyCntry(entity1, entity2);
        const compareResult2 = service.compareDmClientMdmNtnltyCntry(entity2, entity1);

        expect(compareResult1).toEqual(true);
        expect(compareResult2).toEqual(true);
      });
    });
  });

  afterEach(() => {
    httpMock.verify();
  });
});
