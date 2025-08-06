package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.content.R$layout;
import com.huobi.view.roundview.RoundTextView;

public abstract class o4 extends f {
    public final ImageView B;
    public final TextView C;
    public final RoundTextView D;

    public o4(Object obj, View view, int i11, ImageView imageView, TextView textView, RoundTextView roundTextView) {
        super(obj, view, i11);
        this.B = imageView;
        this.C = textView;
        this.D = roundTextView;
    }

    public static o4 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static o4 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (o4) f.s(layoutInflater, R$layout.item_live_award_cell, viewGroup, z11, obj);
    }
}
