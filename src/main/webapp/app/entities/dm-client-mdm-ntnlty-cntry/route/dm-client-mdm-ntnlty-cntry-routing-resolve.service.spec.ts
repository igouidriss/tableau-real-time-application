import { TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ActivatedRouteSnapshot, ActivatedRoute, Router, convertToParamMap } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';

import { IDmClientMdmNtnltyCntry } from '../dm-client-mdm-ntnlty-cntry.model';
import { DmClientMdmNtnltyCntryService } from '../service/dm-client-mdm-ntnlty-cntry.service';

import dmClientMdmNtnltyCntryResolve from './dm-client-mdm-ntnlty-cntry-routing-resolve.service';

describe('DmClientMdmNtnltyCntry routing resolve service', () => {
  let mockRouter: Router;
  let mockActivatedRouteSnapshot: ActivatedRouteSnapshot;
  let service: DmClientMdmNtnltyCntryService;
  let resultDmClientMdmNtnltyCntry: IDmClientMdmNtnltyCntry | null | undefined;

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
    service = TestBed.inject(DmClientMdmNtnltyCntryService);
    resultDmClientMdmNtnltyCntry = undefined;
  });

  describe('resolve', () => {
    it('should return IDmClientMdmNtnltyCntry returned by find', () => {
      // GIVEN
      service.find = jest.fn(id => of(new HttpResponse({ body: { id } })));
      mockActivatedRouteSnapshot.params = { id: 123 };

      // WHEN
      TestBed.runInInjectionContext(() => {
        dmClientMdmNtnltyCntryResolve(mockActivatedRouteSnapshot).subscribe({
          next(result) {
            resultDmClientMdmNtnltyCntry = result;
          },
        });
      });

      // THEN
      expect(service.find).toBeCalledWith(123);
      expect(resultDmClientMdmNtnltyCntry).toEqual({ id: 123 });
    });

    it('should return null if id is not provided', () => {
      // GIVEN
      service.find = jest.fn();
      mockActivatedRouteSnapshot.params = {};

      // WHEN
      TestBed.runInInjectionContext(() => {
        dmClientMdmNtnltyCntryResolve(mockActivatedRouteSnapshot).subscribe({
          next(result) {
            resultDmClientMdmNtnltyCntry = result;
          },
        });
      });

      // THEN
      expect(service.find).not.toBeCalled();
      expect(resultDmClientMdmNtnltyCntry).toEqual(null);
    });

    it('should route to 404 page if data not found in server', () => {
      // GIVEN
      jest.spyOn(service, 'find').mockReturnValue(of(new HttpResponse<IDmClientMdmNtnltyCntry>({ body: null })));
      mockActivatedRouteSnapshot.params = { id: 123 };

      // WHEN
      TestBed.runInInjectionContext(() => {
        dmClientMdmNtnltyCntryResolve(mockActivatedRouteSnapshot).subscribe({
          next(result) {
            resultDmClientMdmNtnltyCntry = result;
          },
        });
      });

      // THEN
      expect(service.find).toBeCalledWith(123);
      expect(resultDmClientMdmNtnltyCntry).toEqual(undefined);
      expect(mockRouter.navigate).toHaveBeenCalledWith(['404']);
    });
  });
});
