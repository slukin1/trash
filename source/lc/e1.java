package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.content.R$layout;
import com.hbg.module.livesquare.custom.CustomRecyclerView;

public abstract class e1 extends f {
    public final LoadingLayout B;
    public final CustomRecyclerView C;

    public e1(Object obj, View view, int i11, LoadingLayout loadingLayout, CustomRecyclerView customRecyclerView) {
        super(obj, view, i11);
        this.B = loadingLayout;
        this.C = customRecyclerView;
    }

    public static e1 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static e1 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (e1) f.s(layoutInflater, R$layout.fragment_community_child, viewGroup, z11, obj);
    }
}
