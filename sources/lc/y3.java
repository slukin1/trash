package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.content.R$layout;
import com.hbg.module.libkt.common.PkCommonView;

public abstract class y3 extends f {
    public final PkCommonView B;

    public y3(Object obj, View view, int i11, PkCommonView pkCommonView) {
        super(obj, view, i11);
        this.B = pkCommonView;
    }

    public static y3 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static y3 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (y3) f.s(layoutInflater, R$layout.item_community_vote, viewGroup, z11, obj);
    }
}
