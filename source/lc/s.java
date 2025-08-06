package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import com.hbg.lib.widgets.AutoSizeTextView;
import com.hbg.module.community.coordinatorTabLayout.WrapCollapsingToolbarLayout;
import com.hbg.module.content.R$layout;
import com.hbg.module.huobi.im.view.AvatarView;
import com.huobi.view.roundview.RoundTextView;
import com.huochat.community.widget.expandable.ExpandableTextView;

public abstract class s extends f {
    public final AppBarLayout B;
    public final AppCompatTextView C;
    public final LinearLayout D;
    public final ImageView E;
    public final ConstraintLayout F;
    public final CoordinatorLayout G;
    public final AppCompatTextView H;
    public final AppCompatTextView I;
    public final RoundTextView J;
    public final ImageView K;
    public final ImageView L;
    public final ImageView M;
    public final LinearLayoutCompat N;
    public final LinearLayoutCompat O;
    public final LinearLayoutCompat P;
    public final LinearLayoutCompat Q;
    public final LinearLayout R;
    public final ConstraintLayout S;
    public final TabLayout T;
    public final Toolbar U;
    public final AutoSizeTextView V;
    public final TextView W;
    public final AvatarView X;
    public final AppCompatTextView Y;
    public final ExpandableTextView Z;

    /* renamed from: a0  reason: collision with root package name */
    public final View f19317a0;

    /* renamed from: b0  reason: collision with root package name */
    public final ViewPager f19318b0;

    /* renamed from: c0  reason: collision with root package name */
    public final WrapCollapsingToolbarLayout f19319c0;

    /* renamed from: d0  reason: collision with root package name */
    public PersonalCenterInfo f19320d0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(Object obj, View view, int i11, AppBarLayout appBarLayout, AppCompatTextView appCompatTextView, LinearLayout linearLayout, ImageView imageView, ConstraintLayout constraintLayout, CoordinatorLayout coordinatorLayout, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, RoundTextView roundTextView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayoutCompat linearLayoutCompat, LinearLayoutCompat linearLayoutCompat2, LinearLayoutCompat linearLayoutCompat3, LinearLayoutCompat linearLayoutCompat4, LinearLayout linearLayout2, ConstraintLayout constraintLayout2, TabLayout tabLayout, Toolbar toolbar, AutoSizeTextView autoSizeTextView, TextView textView, AvatarView avatarView, AppCompatTextView appCompatTextView4, ExpandableTextView expandableTextView, View view2, ViewPager viewPager, WrapCollapsingToolbarLayout wrapCollapsingToolbarLayout) {
        super(obj, view, i11);
        this.B = appBarLayout;
        this.C = appCompatTextView;
        this.D = linearLayout;
        this.E = imageView;
        this.F = constraintLayout;
        this.G = coordinatorLayout;
        this.H = appCompatTextView2;
        this.I = appCompatTextView3;
        this.J = roundTextView;
        this.K = imageView2;
        this.L = imageView3;
        this.M = imageView4;
        this.N = linearLayoutCompat;
        this.O = linearLayoutCompat2;
        this.P = linearLayoutCompat3;
        this.Q = linearLayoutCompat4;
        this.R = linearLayout2;
        this.S = constraintLayout2;
        this.T = tabLayout;
        this.U = toolbar;
        this.V = autoSizeTextView;
        this.W = textView;
        this.X = avatarView;
        this.Y = appCompatTextView4;
        this.Z = expandableTextView;
        this.f19317a0 = view2;
        this.f19318b0 = viewPager;
        this.f19319c0 = wrapCollapsingToolbarLayout;
    }

    public static s K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static s L(LayoutInflater layoutInflater, Object obj) {
        return (s) f.s(layoutInflater, R$layout.activity_personal_center, (ViewGroup) null, false, obj);
    }

    public abstract void M(PersonalCenterInfo personalCenterInfo);
}
