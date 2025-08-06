package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.viewpager2.widget.ViewPager2;
import com.business.common.airdrop.view.AirdropView;
import com.hbg.module.content.R$layout;
import com.hbg.module.libkt.custom.indicator.CoIndicator;

public abstract class g1 extends f {
    public final AirdropView B;
    public final AppCompatTextView C;
    public final ImageView D;
    public final CoIndicator E;
    public final ConstraintLayout F;
    public final LinearLayoutCompat G;
    public final ViewPager2 H;

    public g1(Object obj, View view, int i11, AirdropView airdropView, AppCompatTextView appCompatTextView, ImageView imageView, CoIndicator coIndicator, ConstraintLayout constraintLayout, LinearLayoutCompat linearLayoutCompat, ViewPager2 viewPager2) {
        super(obj, view, i11);
        this.B = airdropView;
        this.C = appCompatTextView;
        this.D = imageView;
        this.E = coIndicator;
        this.F = constraintLayout;
        this.G = linearLayoutCompat;
        this.H = viewPager2;
    }

    public static g1 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static g1 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (g1) f.s(layoutInflater, R$layout.fragment_community_kline, viewGroup, z11, obj);
    }
}
