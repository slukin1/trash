package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.LivePlayingData;
import com.hbg.module.content.R$layout;

public abstract class u5 extends f {
    public LivePlayingData.FloatMsg B;

    public u5(Object obj, View view, int i11) {
        super(obj, view, i11);
    }

    public static u5 K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static u5 L(LayoutInflater layoutInflater, Object obj) {
        return (u5) f.s(layoutInflater, R$layout.item_subtitle, (ViewGroup) null, false, obj);
    }

    public abstract void M(LivePlayingData.FloatMsg floatMsg);
}
