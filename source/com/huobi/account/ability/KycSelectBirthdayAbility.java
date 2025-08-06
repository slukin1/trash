package com.huobi.account.ability;

import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.s;
import com.huobi.view.DatePickerDialog;
import java.util.Calendar;
import pro.huobi.R;
import rj.b;

public class KycSelectBirthdayAbility implements s {

    public class a implements DatePickerDialog.ResultListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbilityFunction.a f40929a;

        public a(AbilityFunction.a aVar) {
            this.f40929a = aVar;
        }

        public void onCancel() {
        }

        public void onResult(DatePickerDialog datePickerDialog, long j11) {
            this.f40929a.a(true, Long.valueOf(j11));
            datePickerDialog.dismiss();
        }
    }

    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        if (aVar != null && obj != null) {
            try {
                new DatePickerDialog.Builder().setInitDate(Calendar.getInstance().getTimeInMillis()).setTitle(R.string.n_kyc_quick_birthday).setDimAmountBehind(0.5f).setResultListener(new a(aVar)).show(bVar.d());
            } catch (Exception e11) {
                e11.printStackTrace();
                aVar.a(false, e11.getMessage());
            }
        }
    }
}
