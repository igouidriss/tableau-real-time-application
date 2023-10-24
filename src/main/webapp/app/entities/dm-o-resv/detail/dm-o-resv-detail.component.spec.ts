import { TestBed } from '@angular/core/testing';
import { provideRouter, withComponentInputBinding } from '@angular/router';
import { RouterTestingHarness, RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';

import { DmOResvDetailComponent } from './dm-o-resv-detail.component';

describe('DmOResv Management Detail Component', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DmOResvDetailComponent, RouterTestingModule.withRoutes([], { bindToComponentInputs: true })],
      providers: [
        provideRouter(
          [
            {
              path: '**',
              component: DmOResvDetailComponent,
              resolve: { dmOResv: () => of({ id: 123 }) },
            },
          ],
          withComponentInputBinding(),
        ),
      ],
    })
      .overrideTemplate(DmOResvDetailComponent, '')
      .compileComponents();
  });

  describe('OnInit', () => {
    it('Should load dmOResv on init', async () => {
      const harness = await RouterTestingHarness.create();
      const instance = await harness.navigateByUrl('/', DmOResvDetailComponent);

      // THEN
      expect(instance.dmOResv).toEqual(expect.objectContaining({ id: 123 }));
    });
  });
});
