import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { DATE_FORMAT } from 'app/config/input.constants';
import { IFtOResv } from '../ft-o-resv.model';
import { sampleWithRequiredData, sampleWithNewData, sampleWithPartialData, sampleWithFullData } from '../ft-o-resv.test-samples';

import { FtOResvService, RestFtOResv } from './ft-o-resv.service';

const requireRestSample: RestFtOResv = {
  ...sampleWithRequiredData,
  businessDate: sampleWithRequiredData.businessDate?.format(DATE_FORMAT),
  dateDebutLigne: sampleWithRequiredData.dateDebutLigne?.format(DATE_FORMAT),
  dateFinLigne: sampleWithRequiredData.dateFinLigne?.format(DATE_FORMAT),
  dateFinOrigine: sampleWithRequiredData.dateFinOrigine?.format(DATE_FORMAT),
  dateAnn: sampleWithRequiredData.dateAnn?.format(DATE_FORMAT),
  techCreateDate: sampleWithRequiredData.techCreateDate?.format(DATE_FORMAT),
  techUpdateDate: sampleWithRequiredData.techUpdateDate?.format(DATE_FORMAT),
};

describe('FtOResv Service', () => {
  let service: FtOResvService;
  let httpMock: HttpTestingController;
  let expectedResult: IFtOResv | IFtOResv[] | boolean | null;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    expectedResult = null;
    service = TestBed.inject(FtOResvService);
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

    it('should create a FtOResv', () => {
      const ftOResv = { ...sampleWithNewData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.create(ftOResv).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'POST' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should update a FtOResv', () => {
      const ftOResv = { ...sampleWithRequiredData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.update(ftOResv).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PUT' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should partial update a FtOResv', () => {
      const patchObject = { ...sampleWithPartialData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.partialUpdate(patchObject).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PATCH' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should return a list of FtOResv', () => {
      const returnedFromService = { ...requireRestSample };

      const expected = { ...sampleWithRequiredData };

      service.query().subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'GET' });
      req.flush([returnedFromService]);
      httpMock.verify();
      expect(expectedResult).toMatchObject([expected]);
    });

    it('should delete a FtOResv', () => {
      const expected = true;

      service.delete(123).subscribe(resp => (expectedResult = resp.ok));

      const req = httpMock.expectOne({ method: 'DELETE' });
      req.flush({ status: 200 });
      expect(expectedResult).toBe(expected);
    });

    describe('addFtOResvToCollectionIfMissing', () => {
      it('should add a FtOResv to an empty array', () => {
        const ftOResv: IFtOResv = sampleWithRequiredData;
        expectedResult = service.addFtOResvToCollectionIfMissing([], ftOResv);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(ftOResv);
      });

      it('should not add a FtOResv to an array that contains it', () => {
        const ftOResv: IFtOResv = sampleWithRequiredData;
        const ftOResvCollection: IFtOResv[] = [
          {
            ...ftOResv,
          },
          sampleWithPartialData,
        ];
        expectedResult = service.addFtOResvToCollectionIfMissing(ftOResvCollection, ftOResv);
        expect(expectedResult).toHaveLength(2);
      });

      it("should add a FtOResv to an array that doesn't contain it", () => {
        const ftOResv: IFtOResv = sampleWithRequiredData;
        const ftOResvCollection: IFtOResv[] = [sampleWithPartialData];
        expectedResult = service.addFtOResvToCollectionIfMissing(ftOResvCollection, ftOResv);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(ftOResv);
      });

      it('should add only unique FtOResv to an array', () => {
        const ftOResvArray: IFtOResv[] = [sampleWithRequiredData, sampleWithPartialData, sampleWithFullData];
        const ftOResvCollection: IFtOResv[] = [sampleWithRequiredData];
        expectedResult = service.addFtOResvToCollectionIfMissing(ftOResvCollection, ...ftOResvArray);
        expect(expectedResult).toHaveLength(3);
      });

      it('should accept varargs', () => {
        const ftOResv: IFtOResv = sampleWithRequiredData;
        const ftOResv2: IFtOResv = sampleWithPartialData;
        expectedResult = service.addFtOResvToCollectionIfMissing([], ftOResv, ftOResv2);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(ftOResv);
        expect(expectedResult).toContain(ftOResv2);
      });

      it('should accept null and undefined values', () => {
        const ftOResv: IFtOResv = sampleWithRequiredData;
        expectedResult = service.addFtOResvToCollectionIfMissing([], null, ftOResv, undefined);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(ftOResv);
      });

      it('should return initial array if no FtOResv is added', () => {
        const ftOResvCollection: IFtOResv[] = [sampleWithRequiredData];
        expectedResult = service.addFtOResvToCollectionIfMissing(ftOResvCollection, undefined, null);
        expect(expectedResult).toEqual(ftOResvCollection);
      });
    });

    describe('compareFtOResv', () => {
      it('Should return true if both entities are null', () => {
        const entity1 = null;
        const entity2 = null;

        const compareResult = service.compareFtOResv(entity1, entity2);

        expect(compareResult).toEqual(true);
      });

      it('Should return false if one entity is null', () => {
        const entity1 = { id: 123 };
        const entity2 = null;

        const compareResult1 = service.compareFtOResv(entity1, entity2);
        const compareResult2 = service.compareFtOResv(entity2, entity1);

        expect(compareResult1).toEqual(false);
        expect(compareResult2).toEqual(false);
      });

      it('Should return false if primaryKey differs', () => {
        const entity1 = { id: 123 };
        const entity2 = { id: 456 };

        const compareResult1 = service.compareFtOResv(entity1, entity2);
        const compareResult2 = service.compareFtOResv(entity2, entity1);

        expect(compareResult1).toEqual(false);
        expect(compareResult2).toEqual(false);
      });

      it('Should return false if primaryKey matches', () => {
        const entity1 = { id: 123 };
        const entity2 = { id: 123 };

        const compareResult1 = service.compareFtOResv(entity1, entity2);
        const compareResult2 = service.compareFtOResv(entity2, entity1);

        expect(compareResult1).toEqual(true);
        expect(compareResult2).toEqual(true);
      });
    });
  });

  afterEach(() => {
    httpMock.verify();
  });
});
