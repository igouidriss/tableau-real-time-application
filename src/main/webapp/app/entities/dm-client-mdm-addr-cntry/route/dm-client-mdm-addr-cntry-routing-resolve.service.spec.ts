import { TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ActivatedRouteSnapshot, ActivatedRoute, Router, convertToParamMap } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';

import { IDmClientMdmAddrCntry } from '../dm-client-mdm-addr-cntry.model';
import { DmClientMdmAddrCntryService } from '../service/dm-client-mdm-addr-cntry.service';

import dmClientMdmAddrCntryResolve from './dm-client-mdm-addr-cntry-routing-resolve.service';

describe('DmClientMdmAddrCntry routing resolve service', () => {
  let mockRouter: Router;
  let mockActivatedRouteSnapshot: ActivatedRouteSnapshot;
  let service: DmClientMdmAddrCntryService;
  let resultDmClientMdmAddrCntry: IDmClientMdmAddrCntry | null | undefined;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule.withRoutes([])],
      providers: [
        {
          provide: ActivatedRoute,
          useValue: {
            snapshot: {
              paramMap: convertToParamMap({}),
            },
          },
        },
      ],
    });
    mockRouter = TestBed.inject(Router);
    jest.spyOn(mockRouter, 'navigate').mockImplementation(() => Promise.resolve(true));
    mockActivatedRouteSnapshot = TestBed.inject(ActivatedRoute).snapshot;
    service = TestBed.inject(DmClientMdmAddrCntryService);
    resultDmClientMdmAddrCntry = undefined;
  });

  describe('resolve', () => {
    it('should return IDmClientMdmAddrCntry returned by find', () => {
      // GIVEN
      service.find = jest.fn(id => of(new HttpResponse({ body: { id } })));
      mockActivatedRouteSnapshot.params = { id: 123 };

      // WHEN
      TestBed.runInInjectionContext(() => {
        dmClientMdmAddrCntryResolve(mockActivatedRouteSnapshot).subscribe({
          next(result) {
            resultDmClientMdmAddrCntry = result;
          },
        });
      });

      // THEN
      expect(service.find).toBeCalledWith(123);
      expect(resultDmClientMdmAddrCntry).toEqual({ id: 123 });
    });

    it('should return null if id is not provided', () => {
      // GIVEN
      service.find = jest.fn();
      mockActivatedRouteSnapshot.params = {};

      // WHEN
      TestBed.runInInjectionContext(() => {
        dmClientMdmAddrCntryResolve(mockActivatedRouteSnapshot).subscribe({
          next(result) {
            resultDmClientMdmAddrCntry = result;
          },
        });
      });

      // THEN
      expect(service.find).not.toBeCalled();
      expect(resultDmClientMdmAddrCntry).toEqual(null);
    });

    it('should route to 404 page if data not found in server', () => {
      // GIVEN
      jest.spyOn(service, 'find').mockReturnValue(of(new HttpResponse<IDmClientMdmAddrCntry>({ body: null })));
      mockActivatedRouteSnapshot.params = { id: 123 };

      // WHEN
      TestBed.runInInjectionContext(() => {
        dmClientMdmAddrCntryResolve(mockActivatedRouteSnapshot).subscribe({
          next(result) {
            resultDmClientMdmAddrCntry = result;
          },
        });
      });

      // THEN
      expect(service.find).toBeCalledWith(123);
      expect(resultDmClientMdmAddrCntry).toEqual(undefined);
      expect(mockRouter.navigate).toHaveBeenCalledWith(['404']);
    });
  });
});
