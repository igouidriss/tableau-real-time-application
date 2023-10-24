import { TestBed } from '@angular/core/testing';
import { provideRouter, withComponentInputBinding } from '@angular/router';
import { RouterTestingHarness, RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';

import { FtOResvDetailComponent } from './ft-o-resv-detail.component';

describe('FtOResv Management Detail Component', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FtOResvDetailComponent, RouterTestingModule.withRoutes([], { bindToComponentInputs: true })],
      providers: [
        provideRouter(
          [
            {
              path: '**',
              component: FtOResvDetailComponent,
              resolve: { ftOResv: () => of({ id: 123 }) },
            },
          ],
          withComponentInputBinding(),
        ),
      ],
    })
      .overrideTemplate(FtOResvDetailComponent, '')
      .compileComponents();
  });

  describe('OnInit', () => {
    it('Should load ftOResv on init', async () => {
      const harness = await RouterTestingHarness.create();
      const instance = await harness.navigateByUrl('/', FtOResvDetailComponent);

      // THEN
      expect(instance.ftOResv).toEqual(expect.objectContaining({ id: 123 }));
    });
  });
});
