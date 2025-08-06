package lc;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.databinding.b;
import androidx.databinding.f;
import c.a;
import com.hbg.lib.network.hbg.core.bean.RecommendSpeakerList;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$string;

public class t5 extends s5 {
    public static final f.i L = null;
    public static final SparseIntArray M;
    public long K;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        M = sparseIntArray;
        sparseIntArray.put(R$id.tvRank, 6);
        sparseIntArray.put(R$id.avatar, 7);
    }

    public t5(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 8, L, M));
    }

    public void M(RecommendSpeakerList.RecommendSpeakerBean recommendSpeakerBean) {
        this.J = recommendSpeakerBean;
        synchronized (this) {
            this.K |= 1;
        }
        notifyPropertyChanged(BR.f17725b);
        super.B();
    }

    public void i() {
        long j11;
        String str;
        Drawable drawable;
        int i11;
        String str2;
        int i12;
        int i13;
        int i14;
        TextView textView;
        long j12;
        long j13;
        synchronized (this) {
            j11 = this.K;
            this.K = 0;
        }
        RecommendSpeakerList.RecommendSpeakerBean recommendSpeakerBean = this.J;
        int i15 = ((j11 & 3) > 0 ? 1 : ((j11 & 3) == 0 ? 0 : -1));
        Drawable drawable2 = null;
        if (i15 != 0) {
            if (recommendSpeakerBean != null) {
                i12 = recommendSpeakerBean.getFansNum();
                str = recommendSpeakerBean.getNickname();
                i13 = recommendSpeakerBean.getFocusStatus();
            } else {
                str = null;
                i13 = 0;
                i12 = 0;
            }
            String str3 = i12 + "";
            boolean z11 = i13 == 1;
            if (i15 != 0) {
                if (z11) {
                    j13 = j11 | 8 | 32;
                    j12 = 128;
                } else {
                    j13 = j11 | 4 | 16;
                    j12 = 64;
                }
                j11 = j13 | j12;
            }
            String string = this.G.getResources().getString(R$string.n_content_live_anchor_fans_number, new Object[]{str3});
            Drawable b11 = a.b(this.C.getContext(), z11 ? R$drawable.icon_attention_already : R$drawable.icon_attention_add);
            drawable = a.b(this.D.getContext(), z11 ? R$drawable.bg_speaker_attentioned : R$drawable.bg_speaker_attention);
            if (z11) {
                textView = this.F;
                i14 = R$color.baseColorPrimaryText;
            } else {
                textView = this.F;
                i14 = R$color.baseColorMajorTheme100;
            }
            Drawable drawable3 = b11;
            i11 = f.p(textView, i14);
            str2 = string;
            drawable2 = drawable3;
        } else {
            str2 = null;
            str = null;
            i11 = 0;
            drawable = null;
        }
        if ((j11 & 3) != 0) {
            ImageViewBindingAdapter.a(this.C, drawable2);
            ViewBindingAdapter.a(this.D, drawable);
            this.F.setTextColor(i11);
            TextViewBindingAdapter.c(this.G, str2);
            TextViewBindingAdapter.c(this.H, str);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.K != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.K = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t5(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[7], objArr[4], objArr[3], objArr[0], objArr[5], objArr[2], objArr[1], objArr[6]);
        this.K = -1;
        this.C.setTag((Object) null);
        this.D.setTag((Object) null);
        this.E.setTag((Object) null);
        this.F.setTag((Object) null);
        this.G.setTag((Object) null);
        this.H.setTag((Object) null);
        View view2 = view;
        G(view);
        t();
    }
}
