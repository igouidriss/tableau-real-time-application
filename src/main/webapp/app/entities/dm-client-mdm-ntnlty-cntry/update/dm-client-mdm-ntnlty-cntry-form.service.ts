import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { IDmClientMdmNtnltyCntry, NewDmClientMdmNtnltyCntry } from '../dm-client-mdm-ntnlty-cntry.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts IDmClientMdmNtnltyCntry for edit and NewDmClientMdmNtnltyCntryFormGroupInput for create.
 */
type DmClientMdmNtnltyCntryFormGroupInput = IDmClientMdmNtnltyCntry | PartialWithRequiredKeyOf<NewDmClientMdmNtnltyCntry>;

type DmClientMdmNtnltyCntryFormDefaults = Pick<NewDmClientMdmNtnltyCntry, 'id'>;

type DmClientMdmNtnltyCntryFormGroupContent = {
  id: FormControl<IDmClientMdmNtnltyCntry['id'] | NewDmClientMdmNtnltyCntry['id']>;
  prtyFk: FormControl<IDmClientMdmNtnltyCntry['prtyFk']>;
  frstNtnltFrmt: FormControl<IDmClientMdmNtnltyCntry['frstNtnltFrmt']>;
  frstContinent: FormControl<IDmClientMdmNtnltyCntry['frstContinent']>;
  scndNtnltFrmt: FormControl<IDmClientMdmNtnltyCntry['scndNtnltFrmt']>;
  scndContinent: FormControl<IDmClientMdmNtnltyCntry['scndContinent']>;
  thrdNtnltFrmt: FormControl<IDmClientMdmNtnltyCntry['thrdNtnltFrmt']>;
  thrdContinent: FormControl<IDmClientMdmNtnltyCntry['thrdContinent']>;
  frthNtnltFrmt: FormControl<IDmClientMdmNtnltyCntry['frthNtnltFrmt']>;
  frthContinent: FormControl<IDmClientMdmNtnltyCntry['frthContinent']>;
  techLineage: FormControl<IDmClientMdmNtnltyCntry['techLineage']>;
  techCreatedDate: FormControl<IDmClientMdmNtnltyCntry['techCreatedDate']>;
  techUpdatedDate: FormControl<IDmClientMdmNtnltyCntry['techUpdatedDate']>;
  techMapping: FormControl<IDmClientMdmNtnltyCntry['techMapping']>;
  techComment: FormControl<IDmClientMdmNtnltyCntry['techComment']>;
};

export type DmClientMdmNtnltyCntryFormGroup = FormGroup<DmClientMdmNtnltyCntryFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class DmClientMdmNtnltyCntryFormService {
  createDmClientMdmNtnltyCntryFormGroup(
    dmClientMdmNtnltyCntry: DmClientMdmNtnltyCntryFormGroupInput = { id: null },
  ): DmClientMdmNtnltyCntryFormGroup {
    const dmClientMdmNtnltyCntryRawValue = {
      ...this.getFormDefaults(),
      ...dmClientMdmNtnltyCntry,
    };
    return new FormGroup<DmClientMdmNtnltyCntryFormGroupContent>({
      id: new FormControl(
        { value: dmClientMdmNtnltyCntryRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        },
      ),
      prtyFk: new FormControl(dmClientMdmNtnltyCntryRawValue.prtyFk, {
        validators: [Validators.required],
      }),
      frstNtnltFrmt: new FormControl(dmClientMdmNtnltyCntryRawValue.frstNtnltFrmt),
      frstContinent: new FormControl(dmClientMdmNtnltyCntryRawValue.frstContinent),
      scndNtnltFrmt: new FormControl(dmClientMdmNtnltyCntryRawValue.scndNtnltFrmt),
      scndContinent: new FormControl(dmClientMdmNtnltyCntryRawValue.scndContinent),
      thrdNtnltFrmt: new FormControl(dmClientMdmNtnltyCntryRawValue.thrdNtnltFrmt),
      thrdContinent: new FormControl(dmClientMdmNtnltyCntryRawValue.thrdContinent),
      frthNtnltFrmt: new FormControl(dmClientMdmNtnltyCntryRawValue.frthNtnltFrmt),
      frthContinent: new FormControl(dmClientMdmNtnltyCntryRawValue.frthContinent),
      techLineage: new FormControl(dmClientMdmNtnltyCntryRawValue.techLineage),
      techCreatedDate: new FormControl(dmClientMdmNtnltyCntryRawValue.techCreatedDate),
      techUpdatedDate: new FormControl(dmClientMdmNtnltyCntryRawValue.techUpdatedDate),
      techMapping: new FormControl(dmClientMdmNtnltyCntryRawValue.techMapping),
      techComment: new FormControl(dmClientMdmNtnltyCntryRawValue.techComment),
    });
  }

  getDmClientMdmNtnltyCntry(form: DmClientMdmNtnltyCntryFormGroup): IDmClientMdmNtnltyCntry | NewDmClientMdmNtnltyCntry {
    return form.getRawValue() as IDmClientMdmNtnltyCntry | NewDmClientMdmNtnltyCntry;
  }

  resetForm(form: DmClientMdmNtnltyCntryFormGroup, dmClientMdmNtnltyCntry: DmClientMdmNtnltyCntryFormGroupInput): void {
    const dmClientMdmNtnltyCntryRawValue = { ...this.getFormDefaults(), ...dmClientMdmNtnltyCntry };
    form.reset(
      {
        ...dmClientMdmNtnltyCntryRawValue,
        id: { value: dmClientMdmNtnltyCntryRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */,
    );
  }

  private getFormDefaults(): DmClientMdmNtnltyCntryFormDefaults {
    return {
      id: null,
    };
  }
}
