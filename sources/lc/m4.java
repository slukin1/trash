package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.GiftUser;
import com.hbg.module.content.R$layout;

public abstract class m4 extends f {
    public final ImageView B;
    public GiftUser C;

    public m4(Object obj, View view, int i11, ImageView imageView) {
        super(obj, view, i11);
        this.B = imageView;
    }

    public static m4 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static m4 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (m4) f.s(layoutInflater, R$layout.item_gift_top, viewGroup, z11, obj);
    }

    public abstract void M(GiftUser giftUser);
}
