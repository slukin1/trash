package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.content.R$layout;

public abstract class m2 extends f {
    public final ImageView B;
    public final TextView C;

    public m2(Object obj, View view, int i11, ImageView imageView, TextView textView) {
        super(obj, view, i11);
        this.B = imageView;
        this.C = textView;
    }

    public static m2 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static m2 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (m2) f.s(layoutInflater, R$layout.item_achievement, viewGroup, z11, obj);
    }
}
