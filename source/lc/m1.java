package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.core.webview.HBWebView;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.ui.fragment.H5Fragment;

public abstract class m1 extends f {
    public final HBWebView B;
    public final LoadingLayout C;
    public final RelativeLayout D;
    public H5Fragment E;

    public m1(Object obj, View view, int i11, HBWebView hBWebView, LoadingLayout loadingLayout, RelativeLayout relativeLayout) {
        super(obj, view, i11);
        this.B = hBWebView;
        this.C = loadingLayout;
        this.D = relativeLayout;
    }

    public static m1 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static m1 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (m1) f.s(layoutInflater, R$layout.fragment_h5, viewGroup, z11, obj);
    }

    public abstract void M(H5Fragment h5Fragment);
}
