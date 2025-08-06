package com.huobi.account.ability;

import android.content.Context;
import android.content.Intent;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.s;
import com.huobi.kyc.ui.KycCountryAreaSelectActivity;
import com.huobi.kyc.ui.KycQuickAuthDialogActivity;
import rj.b;

public class KycSelectNationalityAbility implements s {
    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        if (aVar != null && obj != null) {
            try {
                Context d11 = bVar.d();
                ((KycQuickAuthDialogActivity) d11).startActivityForResult(new Intent(d11, KycCountryAreaSelectActivity.class), 999);
            } catch (Exception e11) {
                e11.printStackTrace();
                aVar.a(false, e11.getMessage());
            }
        }
    }
}
