package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.hbg.lib.network.hbg.core.bean.TopicDetailInfo;
import com.hbg.module.content.R$layout;

public abstract class y extends f {
    public final AppCompatImageView B;
    public final AppCompatImageView C;
    public final AppCompatImageView D;
    public final AppBarLayout E;
    public final AppCompatTextView F;
    public final AppCompatTextView G;
    public final AppCompatTextView H;
    public final AppCompatTextView I;
    public final AppCompatTextView J;
    public final AppCompatTextView K;
    public final AppCompatTextView L;
    public final View M;
    public final ImageView N;
    public final ConstraintLayout O;
    public final ConstraintLayout P;
    public final CoordinatorLayout Q;
    public final ImageView R;
    public final LinearLayout S;
    public final LinearLayoutCompat T;
    public final RelativeLayout U;
    public final RecyclerView V;
    public final RecyclerView W;
    public final TabLayout X;
    public final Toolbar Y;
    public final View Z;

    /* renamed from: a0  reason: collision with root package name */
    public final ViewPager f19327a0;

    /* renamed from: b0  reason: collision with root package name */
    public final CollapsingToolbarLayout f19328b0;

    /* renamed from: c0  reason: collision with root package name */
    public TopicDetailInfo f19329c0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(Object obj, View view, int i11, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppBarLayout appBarLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, View view2, ImageView imageView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, CoordinatorLayout coordinatorLayout, ImageView imageView2, LinearLayout linearLayout, LinearLayoutCompat linearLayoutCompat, RelativeLayout relativeLayout, RecyclerView recyclerView, RecyclerView recyclerView2, TabLayout tabLayout, Toolbar toolbar, View view3, ViewPager viewPager, CollapsingToolbarLayout collapsingToolbarLayout) {
        super(obj, view, i11);
        this.B = appCompatImageView;
        this.C = appCompatImageView2;
        this.D = appCompatImageView3;
        this.E = appBarLayout;
        this.F = appCompatTextView;
        this.G = appCompatTextView2;
        this.H = appCompatTextView3;
        this.I = appCompatTextView4;
        this.J = appCompatTextView5;
        this.K = appCompatTextView6;
        this.L = appCompatTextView7;
        this.M = view2;
        this.N = imageView;
        this.O = constraintLayout;
        this.P = constraintLayout2;
        this.Q = coordinatorLayout;
        this.R = imageView2;
        this.S = linearLayout;
        this.T = linearLayoutCompat;
        this.U = relativeLayout;
        this.V = recyclerView;
        this.W = recyclerView2;
        this.X = tabLayout;
        this.Y = toolbar;
        this.Z = view3;
        this.f19327a0 = viewPager;
        this.f19328b0 = collapsingToolbarLayout;
    }

    public static y K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static y L(LayoutInflater layoutInflater, Object obj) {
        return (y) f.s(layoutInflater, R$layout.activity_topic_detail, (ViewGroup) null, false, obj);
    }

    public abstract void M(TopicDetailInfo topicDetailInfo);
}
