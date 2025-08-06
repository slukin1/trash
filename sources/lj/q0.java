package lj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.c;
import androidx.databinding.f;
import pro.huobi.R;

public abstract class q0 extends f {
    public q0(Object obj, View view, int i11) {
        super(obj, view, i11);
    }

    public static q0 K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static q0 L(LayoutInflater layoutInflater, Object obj) {
        return (q0) f.s(layoutInflater, R.layout.item_zero_swap_open_position_footer, (ViewGroup) null, false, obj);
    }
}
