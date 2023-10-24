import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { IDmClientMdmAddrCntry, NewDmClientMdmAddrCntry } from '../dm-client-mdm-addr-cntry.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts IDmClientMdmAddrCntry for edit and NewDmClientMdmAddrCntryFormGroupInput for create.
 */
type DmClientMdmAddrCntryFormGroupInput = IDmClientMdmAddrCntry | PartialWithRequiredKeyOf<NewDmClientMdmAddrCntry>;

type DmClientMdmAddrCntryFormDefaults = Pick<NewDmClientMdmAddrCntry, 'id'>;

type DmClientMdmAddrCntryFormGroupContent = {
  id: FormControl<IDmClientMdmAddrCntry['id'] | NewDmClientMdmAddrCntry['id']>;
  prtyFk: FormControl<IDmClientMdmAddrCntry['prtyFk']>;
  frstCntryFrmt: FormControl<IDmClientMdmAddrCntry['frstCntryFrmt']>;
  frstContinent: FormControl<IDmClientMdmAddrCntry['frstContinent']>;
  scndCntryFrmt: FormControl<IDmClientMdmAddrCntry['scndCntryFrmt']>;
  scndContinent: FormControl<IDmClientMdmAddrCntry['scndContinent']>;
  thrdCntryFrmt: FormControl<IDmClientMdmAddrCntry['thrdCntryFrmt']>;
  thrdContinent: FormControl<IDmClientMdmAddrCntry['thrdContinent']>;
  frthCntryFrmt: FormControl<IDmClientMdmAddrCntry['frthCntryFrmt']>;
  frthContinent: FormControl<IDmClientMdmAddrCntry['frthContinent']>;
  techLineage: FormControl<IDmClientMdmAddrCntry['techLineage']>;
  techCreatedDate: FormControl<IDmClientMdmAddrCntry['techCreatedDate']>;
  techUpdatedDate: FormControl<IDmClientMdmAddrCntry['techUpdatedDate']>;
  techMapping: FormControl<IDmClientMdmAddrCntry['techMapping']>;
  techComment: FormControl<IDmClientMdmAddrCntry['techComment']>;
};

export type DmClientMdmAddrCntryFormGroup = FormGroup<DmClientMdmAddrCntryFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class DmClientMdmAddrCntryFormService {
  createDmClientMdmAddrCntryFormGroup(
    dmClientMdmAddrCntry: DmClientMdmAddrCntryFormGroupInput = { id: null },
  ): DmClientMdmAddrCntryFormGroup {
    const dmClientMdmAddrCntryRawValue = {
      ...this.getFormDefaults(),
      ...dmClientMdmAddrCntry,
    };
    return new FormGroup<DmClientMdmAddrCntryFormGroupContent>({
      id: new FormControl(
        { value: dmClientMdmAddrCntryRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        },
      ),
      prtyFk: new FormControl(dmClientMdmAddrCntryRawValue.prtyFk, {
        validators: [Validators.required],
      }),
      frstCntryFrmt: new FormControl(dmClientMdmAddrCntryRawValue.frstCntryFrmt),
      frstContinent: new FormControl(dmClientMdmAddrCntryRawValue.frstContinent),
      scndCntryFrmt: new FormControl(dmClientMdmAddrCntryRawValue.scndCntryFrmt),
      scndContinent: new FormControl(dmClientMdmAddrCntryRawValue.scndContinent),
      thrdCntryFrmt: new FormControl(dmClientMdmAddrCntryRawValue.thrdCntryFrmt),
      thrdContinent: new FormControl(dmClientMdmAddrCntryRawValue.thrdContinent),
      frthCntryFrmt: new FormControl(dmClientMdmAddrCntryRawValue.frthCntryFrmt),
      frthContinent: new FormControl(dmClientMdmAddrCntryRawValue.frthContinent),
      techLineage: new FormControl(dmClientMdmAddrCntryRawValue.techLineage),
      techCreatedDate: new FormControl(dmClientMdmAddrCntryRawValue.techCreatedDate),
      techUpdatedDate: new FormControl(dmClientMdmAddrCntryRawValue.techUpdatedDate),
      techMapping: new FormControl(dmClientMdmAddrCntryRawValue.techMapping),
      techComment: new FormControl(dmClientMdmAddrCntryRawValue.techComment),
    });
  }

  getDmClientMdmAddrCntry(form: DmClientMdmAddrCntryFormGroup): IDmClientMdmAddrCntry | NewDmClientMdmAddrCntry {
    return form.getRawValue() as IDmClientMdmAddrCntry | NewDmClientMdmAddrCntry;
  }

  resetForm(form: DmClientMdmAddrCntryFormGroup, dmClientMdmAddrCntry: DmClientMdmAddrCntryFormGroupInput): void {
    const dmClientMdmAddrCntryRawValue = { ...this.getFormDefaults(), ...dmClientMdmAddrCntry };
    form.reset(
      {
        ...dmClientMdmAddrCntryRawValue,
        id: { value: dmClientMdmAddrCntryRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */,
    );
  }

  private getFormDefaults(): DmClientMdmAddrCntryFormDefaults {
    return {
      id: null,
    };
  }
}
