package lc;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.f;
import com.hbg.lib.widgets.AutoSizeTextView;
import com.hbg.module.community.widgets.CommunityImageLayout;
import com.hbg.module.huobi.im.view.AvatarView;
import com.huobi.view.roundview.RoundConstraintLayout;
import com.huochat.community.widget.expandable.ExpandableTextView;

public abstract class e3 extends f {
    public final RoundConstraintLayout B;
    public final c3 C;
    public final g3 D;
    public final ConstraintLayout E;
    public final ImageView F;
    public final ImageView G;
    public final AvatarView H;
    public final CommunityImageLayout I;
    public final ImageView J;
    public final ImageView K;
    public final ImageView L;
    public final View M;
    public final RelativeLayout N;
    public final RelativeLayout O;
    public final RelativeLayout P;
    public final AutoSizeTextView Q;
    public final TextView R;
    public final ExpandableTextView S;
    public final TextView T;
    public final TextView U;
    public final TextView V;
    public final TextView W;
    public final AppCompatTextView X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e3(Object obj, View view, int i11, RoundConstraintLayout roundConstraintLayout, c3 c3Var, g3 g3Var, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, AvatarView avatarView, CommunityImageLayout communityImageLayout, ImageView imageView3, ImageView imageView4, ImageView imageView5, View view2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, AutoSizeTextView autoSizeTextView, TextView textView, ExpandableTextView expandableTextView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, AppCompatTextView appCompatTextView) {
        super(obj, view, i11);
        this.B = roundConstraintLayout;
        this.C = c3Var;
        this.D = g3Var;
        this.E = constraintLayout;
        this.F = imageView;
        this.G = imageView2;
        this.H = avatarView;
        this.I = communityImageLayout;
        this.J = imageView3;
        this.K = imageView4;
        this.L = imageView5;
        this.M = view2;
        this.N = relativeLayout;
        this.O = relativeLayout2;
        this.P = relativeLayout3;
        this.Q = autoSizeTextView;
        this.R = textView;
        this.S = expandableTextView;
        this.T = textView2;
        this.U = textView3;
        this.V = textView4;
        this.W = textView5;
        this.X = appCompatTextView;
    }
}
