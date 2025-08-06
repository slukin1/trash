package yf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.ShareGroupList;
import com.hbg.module.share.R$layout;

public abstract class e extends f {
    public final CheckBox B;
    public final ImageView C;
    public ShareGroupList.ShareGroup D;

    public e(Object obj, View view, int i11, CheckBox checkBox, ImageView imageView) {
        super(obj, view, i11);
        this.B = checkBox;
        this.C = imageView;
    }

    public static e K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static e L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (e) f.s(layoutInflater, R$layout.item_share_group, viewGroup, z11, obj);
    }

    public abstract void M(ShareGroupList.ShareGroup shareGroup);
}
