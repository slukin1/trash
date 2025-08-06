package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.content.R$layout;

public abstract class c5 extends f {
    public final ImageView B;
    public final TextView C;

    public c5(Object obj, View view, int i11, ImageView imageView, TextView textView) {
        super(obj, view, i11);
        this.B = imageView;
        this.C = textView;
    }

    public static c5 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static c5 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (c5) f.s(layoutInflater, R$layout.item_live_desc, viewGroup, z11, obj);
    }
}
