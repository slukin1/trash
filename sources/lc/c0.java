package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.content.R$layout;

public abstract class c0 extends f {
    public final AppCompatImageView B;
    public final LinearLayout C;
    public final AppCompatTextView D;
    public final AppCompatTextView E;

    public c0(Object obj, View view, int i11, AppCompatImageView appCompatImageView, LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i11);
        this.B = appCompatImageView;
        this.C = linearLayout;
        this.D = appCompatTextView;
        this.E = appCompatTextView2;
    }

    public static c0 K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static c0 L(LayoutInflater layoutInflater, Object obj) {
        return (c0) f.s(layoutInflater, R$layout.custom_coin_tag_v2, (ViewGroup) null, false, obj);
    }
}
