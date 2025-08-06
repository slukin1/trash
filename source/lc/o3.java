package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.community.view.FlowLayout;
import com.hbg.module.content.R$layout;

public abstract class o3 extends f {
    public final View B;
    public final LinearLayoutCompat C;
    public final TextView D;
    public final FlowLayout E;

    public o3(Object obj, View view, int i11, View view2, LinearLayoutCompat linearLayoutCompat, TextView textView, FlowLayout flowLayout) {
        super(obj, view, i11);
        this.B = view2;
        this.C = linearLayoutCompat;
        this.D = textView;
        this.E = flowLayout;
    }

    public static o3 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static o3 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (o3) f.s(layoutInflater, R$layout.item_community_interest_tag, viewGroup, z11, obj);
    }
}
