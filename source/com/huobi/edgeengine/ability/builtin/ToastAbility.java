package com.huobi.edgeengine.ability.builtin;

import android.widget.Toast;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.s;
import rj.b;

public class ToastAbility implements s {
    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        if (obj == null) {
            aVar.a(false, "text null!");
            return;
        }
        Toast makeText = Toast.makeText(bVar.d(), "", 0);
        makeText.setText((String) obj);
        makeText.show();
        aVar.a(true, (Object) null);
    }
}
