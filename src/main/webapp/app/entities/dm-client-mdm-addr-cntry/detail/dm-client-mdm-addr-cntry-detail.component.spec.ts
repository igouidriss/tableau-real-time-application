import { TestBed } from '@angular/core/testing';
import { provideRouter, withComponentInputBinding } from '@angular/router';
import { RouterTestingHarness, RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';

import { DmClientMdmAddrCntryDetailComponent } from './dm-client-mdm-addr-cntry-detail.component';

describe('DmClientMdmAddrCntry Management Detail Component', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DmClientMdmAddrCntryDetailComponent, RouterTestingModule.withRoutes([], { bindToComponentInputs: true })],
      providers: [
        provideRouter(
          [
            {
              path: '**',
              component: DmClientMdmAddrCntryDetailComponent,
              resolve: { dmClientMdmAddrCntry: () => of({ id: 123 }) },
            },
          ],
          withComponentInputBinding(),
        ),
      ],
    })
      .overrideTemplate(DmClientMdmAddrCntryDetailComponent, '')
      .compileComponents();
  });

  describe('OnInit', () => {
    it('Should load dmClientMdmAddrCntry on init', async () => {
      const harness = await RouterTestingHarness.create();
      const instance = await harness.navigateByUrl('/', DmClientMdmAddrCntryDetailComponent);

      // THEN
      expect(instance.dmClientMdmAddrCntry).toEqual(expect.objectContaining({ id: 123 }));
    });
  });
});
