package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.RecommendSpeakerList;
import com.hbg.module.content.R$layout;
import com.hbg.module.huobi.im.view.AvatarView;

public abstract class m5 extends f {
    public final AvatarView B;
    public final TextView C;
    public RecommendSpeakerList.RecommendSpeakerBean D;

    public m5(Object obj, View view, int i11, AvatarView avatarView, TextView textView) {
        super(obj, view, i11);
        this.B = avatarView;
        this.C = textView;
    }

    public static m5 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static m5 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (m5) f.s(layoutInflater, R$layout.item_recommend_speaker, viewGroup, z11, obj);
    }

    public abstract void M(RecommendSpeakerList.RecommendSpeakerBean recommendSpeakerBean);
}
