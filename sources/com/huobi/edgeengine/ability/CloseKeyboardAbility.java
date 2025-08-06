package com.huobi.edgeengine.ability;

import android.os.IBinder;
import android.view.inputmethod.InputMethodManager;
import com.huobi.edgeengine.ability.AbilityFunction;
import oa.a;
import rj.b;

public class CloseKeyboardAbility extends AbstractAbility {
    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        ((InputMethodManager) a.g().b().getSystemService("input_method")).hideSoftInputFromWindow((IBinder) null, 0);
    }

    public boolean b() {
        return false;
    }
}
