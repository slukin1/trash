package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.adapter.CommentListAdapter;
import com.hbg.module.huobi.im.view.AvatarView;

public abstract class s2 extends f {
    public final AppCompatImageView B;
    public final AppCompatTextView C;
    public final AvatarView D;
    public final FrameLayout E;
    public final ImageView F;
    public final ImageView G;
    public final ImageView H;
    public final LinearLayout I;
    public final LinearLayout J;
    public final RelativeLayout K;
    public final TextView L;
    public final TextView M;
    public final TextView N;
    public final TextView O;
    public final TextView P;
    public final TextView Q;
    public final TextView R;
    public final TextView S;
    public CommentListAdapter T;
    public CommentInfo U;
    public Boolean V;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s2(Object obj, View view, int i11, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AvatarView avatarView, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        super(obj, view, i11);
        this.B = appCompatImageView;
        this.C = appCompatTextView;
        this.D = avatarView;
        this.E = frameLayout;
        this.F = imageView;
        this.G = imageView2;
        this.H = imageView3;
        this.I = linearLayout;
        this.J = linearLayout2;
        this.K = relativeLayout;
        this.L = textView;
        this.M = textView2;
        this.N = textView3;
        this.O = textView4;
        this.P = textView5;
        this.Q = textView6;
        this.R = textView7;
        this.S = textView8;
    }

    public static s2 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static s2 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (s2) f.s(layoutInflater, R$layout.item_comment, viewGroup, z11, obj);
    }

    public abstract void M(CommentListAdapter commentListAdapter);

    public abstract void N(CommentInfo commentInfo);

    public abstract void O(Boolean bool);
}
