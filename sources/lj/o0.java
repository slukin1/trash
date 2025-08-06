package lj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.huobi.view.roundview.RoundTextView;
import com.huobi.zeroswap.engine.view.KLineEdgeItemView;
import pro.huobi.R;

public abstract class o0 extends f {
    public final AppCompatImageView B;
    public final AppCompatImageView C;
    public final KLineEdgeItemView D;
    public final LinearLayout E;
    public final LinearLayout F;
    public final LinearLayout G;
    public final TextView H;
    public final RoundTextView I;
    public final RoundTextView J;
    public final TextView K;
    public final RoundTextView L;
    public final RoundTextView M;
    public final TextView N;
    public final TextView O;
    public final TextView P;
    public final TextView Q;
    public final TextView R;
    public final TextView S;
    public final RoundTextView T;
    public final RoundTextView U;
    public final RoundTextView V;
    public final TextView W;
    public final TextView X;
    public final TextView Y;
    public final TextView Z;

    /* renamed from: a0  reason: collision with root package name */
    public final TextView f47613a0;

    /* renamed from: b0  reason: collision with root package name */
    public final TextView f47614b0;

    /* renamed from: c0  reason: collision with root package name */
    public final RoundTextView f47615c0;

    /* renamed from: d0  reason: collision with root package name */
    public final TextView f47616d0;

    /* renamed from: e0  reason: collision with root package name */
    public final RoundTextView f47617e0;

    /* renamed from: f0  reason: collision with root package name */
    public final TextView f47618f0;

    /* renamed from: g0  reason: collision with root package name */
    public final TextView f47619g0;

    /* renamed from: h0  reason: collision with root package name */
    public final TextView f47620h0;

    /* renamed from: i0  reason: collision with root package name */
    public final TextView f47621i0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o0(Object obj, View view, int i11, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, KLineEdgeItemView kLineEdgeItemView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, RoundTextView roundTextView, RoundTextView roundTextView2, TextView textView2, RoundTextView roundTextView3, RoundTextView roundTextView4, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, RoundTextView roundTextView5, RoundTextView roundTextView6, RoundTextView roundTextView7, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, RoundTextView roundTextView8, TextView textView15, RoundTextView roundTextView9, TextView textView16, TextView textView17, TextView textView18, TextView textView19) {
        super(obj, view, i11);
        this.B = appCompatImageView;
        this.C = appCompatImageView2;
        this.D = kLineEdgeItemView;
        this.E = linearLayout;
        this.F = linearLayout2;
        this.G = linearLayout3;
        this.H = textView;
        this.I = roundTextView;
        this.J = roundTextView2;
        this.K = textView2;
        this.L = roundTextView3;
        this.M = roundTextView4;
        this.N = textView3;
        this.O = textView4;
        this.P = textView5;
        this.Q = textView6;
        this.R = textView7;
        this.S = textView8;
        this.T = roundTextView5;
        this.U = roundTextView6;
        this.V = roundTextView7;
        this.W = textView9;
        this.X = textView10;
        this.Y = textView11;
        this.Z = textView12;
        this.f47613a0 = textView13;
        this.f47614b0 = textView14;
        this.f47615c0 = roundTextView8;
        this.f47616d0 = textView15;
        this.f47617e0 = roundTextView9;
        this.f47618f0 = textView16;
        this.f47619g0 = textView17;
        this.f47620h0 = textView18;
        this.f47621i0 = textView19;
    }

    public static o0 K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static o0 L(LayoutInflater layoutInflater, Object obj) {
        return (o0) f.s(layoutInflater, R.layout.item_zero_swap_open_position, (ViewGroup) null, false, obj);
    }
}
