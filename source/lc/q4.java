package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.content.R$layout;
import com.youth.banner.Banner;

public abstract class q4 extends f {
    public final Banner B;

    public q4(Object obj, View view, int i11, Banner banner) {
        super(obj, view, i11);
        this.B = banner;
    }

    public static q4 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static q4 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (q4) f.s(layoutInflater, R$layout.item_live_banner, viewGroup, z11, obj);
    }
}
