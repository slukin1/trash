package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.widgets.AutoSizeTextView;
import com.hbg.module.community.widgets.CommunityChildLayout;
import com.hbg.module.community.widgets.CommunityImageLayout;
import com.hbg.module.content.R$layout;
import com.huobi.view.roundimg.RoundedImageView;
import com.huobi.view.roundview.RoundConstraintLayout;
import com.huochat.community.widget.expandable.ExpandableTextView;

public abstract class a3 extends f {
    public final RoundConstraintLayout B;
    public final CommunityChildLayout C;
    public final ConstraintLayout D;
    public final ImageView E;
    public final ImageView F;
    public final RoundedImageView G;
    public final CommunityImageLayout H;
    public final ImageView I;
    public final ImageView J;
    public final ImageView K;
    public final View L;
    public final RelativeLayout M;
    public final RelativeLayout N;
    public final RelativeLayout O;
    public final AutoSizeTextView P;
    public final TextView Q;
    public final ExpandableTextView R;
    public final TextView S;
    public final TextView T;
    public final TextView U;
    public final TextView V;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a3(Object obj, View view, int i11, RoundConstraintLayout roundConstraintLayout, CommunityChildLayout communityChildLayout, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, RoundedImageView roundedImageView, CommunityImageLayout communityImageLayout, ImageView imageView3, ImageView imageView4, ImageView imageView5, View view2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, AutoSizeTextView autoSizeTextView, TextView textView, ExpandableTextView expandableTextView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i11);
        this.B = roundConstraintLayout;
        this.C = communityChildLayout;
        this.D = constraintLayout;
        this.E = imageView;
        this.F = imageView2;
        this.G = roundedImageView;
        this.H = communityImageLayout;
        this.I = imageView3;
        this.J = imageView4;
        this.K = imageView5;
        this.L = view2;
        this.M = relativeLayout;
        this.N = relativeLayout2;
        this.O = relativeLayout3;
        this.P = autoSizeTextView;
        this.Q = textView;
        this.R = expandableTextView;
        this.S = textView2;
        this.T = textView3;
        this.U = textView4;
        this.V = textView5;
    }

    public static a3 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static a3 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (a3) f.s(layoutInflater, R$layout.item_community_feed, viewGroup, z11, obj);
    }
}
