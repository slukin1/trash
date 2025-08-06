package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.core.webview.HBWebView;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.content.R$layout;

public abstract class e0 extends f {
    public final HBWebView B;
    public final ImageView C;
    public final LinearLayout D;
    public final LoadingLayout E;

    public e0(Object obj, View view, int i11, HBWebView hBWebView, ImageView imageView, LinearLayout linearLayout, LoadingLayout loadingLayout) {
        super(obj, view, i11);
        this.B = hBWebView;
        this.C = imageView;
        this.D = linearLayout;
        this.E = loadingLayout;
    }

    public static e0 K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static e0 L(LayoutInflater layoutInflater, Object obj) {
        return (e0) f.s(layoutInflater, R$layout.dialog_h5_fragment, (ViewGroup) null, false, obj);
    }
}
