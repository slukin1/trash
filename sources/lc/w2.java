package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.widgets.AutoSizeTextView;
import com.hbg.module.content.R$layout;
import com.hbg.module.huobi.im.view.AvatarView;
import com.huobi.view.roundview.RoundConstraintLayout;

public abstract class w2 extends f {
    public final AppCompatTextView B;
    public final AppCompatTextView C;
    public final RoundConstraintLayout D;
    public final ImageView E;
    public final AvatarView F;
    public final AutoSizeTextView G;
    public final AppCompatTextView H;

    public w2(Object obj, View view, int i11, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, RoundConstraintLayout roundConstraintLayout, ImageView imageView, AvatarView avatarView, AutoSizeTextView autoSizeTextView, AppCompatTextView appCompatTextView3) {
        super(obj, view, i11);
        this.B = appCompatTextView;
        this.C = appCompatTextView2;
        this.D = roundConstraintLayout;
        this.E = imageView;
        this.F = avatarView;
        this.G = autoSizeTextView;
        this.H = appCompatTextView3;
    }

    public static w2 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static w2 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (w2) f.s(layoutInflater, R$layout.item_community_attention_recommend_cell, viewGroup, z11, obj);
    }
}
