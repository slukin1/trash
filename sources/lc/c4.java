package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.WatchFansBean;
import com.hbg.module.community.widgets.FollowView;
import com.hbg.module.content.R$layout;
import com.hbg.module.huobi.im.view.AvatarView;

public abstract class c4 extends f {
    public final FollowView B;
    public final AvatarView C;
    public final LinearLayout D;
    public WatchFansBean E;

    public c4(Object obj, View view, int i11, FollowView followView, AvatarView avatarView, LinearLayout linearLayout) {
        super(obj, view, i11);
        this.B = followView;
        this.C = avatarView;
        this.D = linearLayout;
    }

    public static c4 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static c4 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (c4) f.s(layoutInflater, R$layout.item_fans, viewGroup, z11, obj);
    }

    public abstract void M(WatchFansBean watchFansBean);
}
