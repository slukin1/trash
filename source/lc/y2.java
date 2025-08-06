package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.module.content.R$layout;
import com.hbg.module.huobi.im.view.AvatarView;
import com.huobi.view.roundview.RoundLinearLayout;
import com.huochat.community.widget.expandable.ExpandableTextView;

public abstract class y2 extends f {
    public final FrameLayout B;
    public final AppCompatTextView C;
    public final ConstraintLayout D;
    public final FrameLayout E;
    public final FrameLayout F;
    public final ImageView G;
    public final ImageView H;
    public final AvatarView I;
    public final ImageView J;
    public final ImageView K;
    public final AppCompatImageView L;
    public final ImageView M;
    public final View N;
    public final RoundLinearLayout O;
    public final LinearLayout P;
    public final LinearLayout Q;
    public final RelativeLayout R;
    public final RelativeLayout S;
    public final LinearLayout T;
    public final RelativeLayout U;
    public final Space V;
    public final SafeLottieView W;
    public final TextView X;
    public final ExpandableTextView Y;
    public final TextView Z;

    /* renamed from: a0  reason: collision with root package name */
    public final TextView f19330a0;

    /* renamed from: b0  reason: collision with root package name */
    public final TextView f19331b0;

    /* renamed from: c0  reason: collision with root package name */
    public final TextView f19332c0;

    /* renamed from: d0  reason: collision with root package name */
    public final TextView f19333d0;

    /* renamed from: e0  reason: collision with root package name */
    public final TextView f19334e0;

    /* renamed from: f0  reason: collision with root package name */
    public final AppCompatTextView f19335f0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y2(Object obj, View view, int i11, FrameLayout frameLayout, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, ImageView imageView, ImageView imageView2, AvatarView avatarView, ImageView imageView3, ImageView imageView4, AppCompatImageView appCompatImageView, ImageView imageView5, View view2, RoundLinearLayout roundLinearLayout, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, LinearLayout linearLayout3, RelativeLayout relativeLayout3, Space space, SafeLottieView safeLottieView, TextView textView, ExpandableTextView expandableTextView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, AppCompatTextView appCompatTextView2) {
        super(obj, view, i11);
        this.B = frameLayout;
        this.C = appCompatTextView;
        this.D = constraintLayout;
        this.E = frameLayout2;
        this.F = frameLayout3;
        this.G = imageView;
        this.H = imageView2;
        this.I = avatarView;
        this.J = imageView3;
        this.K = imageView4;
        this.L = appCompatImageView;
        this.M = imageView5;
        this.N = view2;
        this.O = roundLinearLayout;
        this.P = linearLayout;
        this.Q = linearLayout2;
        this.R = relativeLayout;
        this.S = relativeLayout2;
        this.T = linearLayout3;
        this.U = relativeLayout3;
        this.V = space;
        this.W = safeLottieView;
        this.X = textView;
        this.Y = expandableTextView;
        this.Z = textView2;
        this.f19330a0 = textView3;
        this.f19331b0 = textView4;
        this.f19332c0 = textView5;
        this.f19333d0 = textView6;
        this.f19334e0 = textView7;
        this.f19335f0 = appCompatTextView2;
    }

    public static y2 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static y2 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (y2) f.s(layoutInflater, R$layout.item_community_base, viewGroup, z11, obj);
    }
}
