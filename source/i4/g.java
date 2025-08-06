package i4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.business.common.R$layout;

public abstract class g extends f {
    public final AppCompatImageView B;
    public final AppCompatTextView C;
    public final AppCompatTextView D;

    public g(Object obj, View view, int i11, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i11);
        this.B = appCompatImageView;
        this.C = appCompatTextView;
        this.D = appCompatTextView2;
    }

    public static g K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static g L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (g) f.s(layoutInflater, R$layout.item_airdrop_gift, viewGroup, z11, obj);
    }
}
