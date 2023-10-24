import { TestBed } from '@angular/core/testing';
import { provideRouter, withComponentInputBinding } from '@angular/router';
import { RouterTestingHarness, RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';

import { DmClientMdmNtnltyCntryDetailComponent } from './dm-client-mdm-ntnlty-cntry-detail.component';

describe('DmClientMdmNtnltyCntry Management Detail Component', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DmClientMdmNtnltyCntryDetailComponent, RouterTestingModule.withRoutes([], { bindToComponentInputs: true })],
      providers: [
        provideRouter(
          [
            {
              path: '**',
              component: DmClientMdmNtnltyCntryDetailComponent,
              resolve: { dmClientMdmNtnltyCntry: () => of({ id: 123 }) },
            },
          ],
          withComponentInputBinding(),
        ),
      ],
    })
      .overrideTemplate(DmClientMdmNtnltyCntryDetailComponent, '')
      .compileComponents();
  });

  describe('OnInit', () => {
    it('Should load dmClientMdmNtnltyCntry on init', async () => {
      const harness = await RouterTestingHarness.create();
      const instance = await harness.navigateByUrl('/', DmClientMdmNtnltyCntryDetailComponent);

      // THEN
      expect(instance.dmClientMdmNtnltyCntry).toEqual(expect.objectContaining({ id: 123 }));
    });
  });
});
