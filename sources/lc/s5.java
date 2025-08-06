package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.RecommendSpeakerList;
import com.hbg.module.content.R$layout;
import com.hbg.module.huobi.im.view.AvatarView;

public abstract class s5 extends f {
    public final AvatarView B;
    public final ImageView C;
    public final LinearLayout D;
    public final LinearLayout E;
    public final TextView F;
    public final TextView G;
    public final TextView H;
    public final TextView I;
    public RecommendSpeakerList.RecommendSpeakerBean J;

    public s5(Object obj, View view, int i11, AvatarView avatarView, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i11);
        this.B = avatarView;
        this.C = imageView;
        this.D = linearLayout;
        this.E = linearLayout2;
        this.F = textView;
        this.G = textView2;
        this.H = textView3;
        this.I = textView4;
    }

    public static s5 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static s5 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (s5) f.s(layoutInflater, R$layout.item_speaker, viewGroup, z11, obj);
    }

    public abstract void M(RecommendSpeakerList.RecommendSpeakerBean recommendSpeakerBean);
}
