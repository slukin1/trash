package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.content.R$layout;

public abstract class c2 extends f {
    public final FrameLayout B;

    public c2(Object obj, View view, int i11, FrameLayout frameLayout) {
        super(obj, view, i11);
        this.B = frameLayout;
    }

    public static c2 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static c2 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (c2) f.s(layoutInflater, R$layout.fragment_new_content_child, viewGroup, z11, obj);
    }
}
