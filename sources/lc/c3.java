package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.module.content.R$layout;
import com.hbg.module.huobi.im.view.AvatarView;
import com.hbg.module.libkt.custom.DynamicPicCardView;
import com.huobi.view.roundview.RoundConstraintLayout;
import com.huochat.community.widget.expandable.ExpandableTextView;

public abstract class c3 extends f {
    public final FrameLayout B;
    public final RoundConstraintLayout C;
    public final DynamicPicCardView D;
    public final AvatarView E;
    public final ImageView F;
    public final LinearLayoutCompat G;
    public final LinearLayout H;
    public final SafeLottieView I;
    public final ExpandableTextView J;
    public final TextView K;
    public final AppCompatTextView L;
    public final AppCompatTextView M;

    public c3(Object obj, View view, int i11, FrameLayout frameLayout, RoundConstraintLayout roundConstraintLayout, DynamicPicCardView dynamicPicCardView, AvatarView avatarView, ImageView imageView, LinearLayoutCompat linearLayoutCompat, LinearLayout linearLayout, SafeLottieView safeLottieView, ExpandableTextView expandableTextView, TextView textView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i11);
        this.B = frameLayout;
        this.C = roundConstraintLayout;
        this.D = dynamicPicCardView;
        this.E = avatarView;
        this.F = imageView;
        this.G = linearLayoutCompat;
        this.H = linearLayout;
        this.I = safeLottieView;
        this.J = expandableTextView;
        this.K = textView;
        this.L = appCompatTextView;
        this.M = appCompatTextView2;
    }

    public static c3 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static c3 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (c3) f.s(layoutInflater, R$layout.item_community_feed_comment, viewGroup, z11, obj);
    }
}
