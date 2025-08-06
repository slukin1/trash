package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.RecommendSpeakerList;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;

public class n5 extends m5 {
    public static final f.i G = null;
    public static final SparseIntArray H;
    public final LinearLayout E;
    public long F;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        H = sparseIntArray;
        sparseIntArray.put(R$id.avatar, 2);
    }

    public n5(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 3, G, H));
    }

    public void M(RecommendSpeakerList.RecommendSpeakerBean recommendSpeakerBean) {
        this.D = recommendSpeakerBean;
        synchronized (this) {
            this.F |= 1;
        }
        notifyPropertyChanged(BR.f17725b);
        super.B();
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.F;
            this.F = 0;
        }
        String str = null;
        RecommendSpeakerList.RecommendSpeakerBean recommendSpeakerBean = this.D;
        int i11 = ((j11 & 3) > 0 ? 1 : ((j11 & 3) == 0 ? 0 : -1));
        if (!(i11 == 0 || recommendSpeakerBean == null)) {
            str = recommendSpeakerBean.getNickname();
        }
        if (i11 != 0) {
            TextViewBindingAdapter.c(this.C, str);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.F != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.F = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public n5(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[2], objArr[1]);
        this.F = -1;
        LinearLayout linearLayout = objArr[0];
        this.E = linearLayout;
        linearLayout.setTag((Object) null);
        this.C.setTag((Object) null);
        G(view);
        t();
    }
}
