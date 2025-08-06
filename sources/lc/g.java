package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.community.ui.FollowListActivity;
import com.hbg.module.content.R$layout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class g extends f {
    public final LoadingLayout B;
    public final SmartRefreshLayout C;
    public final RecyclerView D;
    public final TextView E;
    public final View F;
    public FollowListActivity G;

    public g(Object obj, View view, int i11, LoadingLayout loadingLayout, SmartRefreshLayout smartRefreshLayout, RecyclerView recyclerView, TextView textView, View view2) {
        super(obj, view, i11);
        this.B = loadingLayout;
        this.C = smartRefreshLayout;
        this.D = recyclerView;
        this.E = textView;
        this.F = view2;
    }

    public static g K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static g L(LayoutInflater layoutInflater, Object obj) {
        return (g) f.s(layoutInflater, R$layout.activity_follow_list, (ViewGroup) null, false, obj);
    }

    public abstract void M(FollowListActivity followListActivity);
}
