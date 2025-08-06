package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.GiftUser;
import com.hbg.module.content.R$layout;

public abstract class k4 extends f {
    public final LinearLayout B;
    public Integer C;
    public GiftUser D;

    public k4(Object obj, View view, int i11, LinearLayout linearLayout) {
        super(obj, view, i11);
        this.B = linearLayout;
    }

    public static k4 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static k4 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (k4) f.s(layoutInflater, R$layout.item_gift_rank, viewGroup, z11, obj);
    }

    public abstract void M(GiftUser giftUser);

    public abstract void N(Integer num);
}
