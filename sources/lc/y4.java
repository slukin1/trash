package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.module.content.R$layout;

public abstract class y4 extends f {
    public final LinearLayout B;
    public final ImageView C;
    public final TextView D;
    public final TextView E;
    public final TextView F;
    public LiveDetailBean G;

    public y4(Object obj, View view, int i11, LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i11);
        this.B = linearLayout;
        this.C = imageView;
        this.D = textView;
        this.E = textView2;
        this.F = textView3;
    }

    public static y4 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static y4 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (y4) f.s(layoutInflater, R$layout.item_live_content_playback_cell_category, viewGroup, z11, obj);
    }

    public abstract void M(LiveDetailBean liveDetailBean);
}
