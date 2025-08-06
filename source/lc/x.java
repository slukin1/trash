package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;
import com.hbg.module.livesquare.ui.RecommendSpeakerActivity;
import mc.a;

public class x extends w implements a.C0130a {
    public static final f.i Q = null;
    public static final SparseIntArray R;
    public final ConstraintLayout M;
    public final ImageView N;
    public final View.OnClickListener O;
    public long P;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        R = sparseIntArray;
        sparseIntArray.put(R$id.llLoading, 2);
        sparseIntArray.put(R$id.rlRefresh, 3);
        sparseIntArray.put(R$id.mAppBarLayout, 4);
        sparseIntArray.put(R$id.topLay, 5);
        sparseIntArray.put(R$id.tvBigTitle, 6);
        sparseIntArray.put(R$id.rvContent, 7);
        sparseIntArray.put(R$id.vTopBar, 8);
        sparseIntArray.put(R$id.rlBar, 9);
        sparseIntArray.put(R$id.vBarBg, 10);
        sparseIntArray.put(R$id.tvTitle, 11);
    }

    public x(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 12, Q, R));
    }

    public void M(RecommendSpeakerActivity recommendSpeakerActivity) {
        this.L = recommendSpeakerActivity;
        synchronized (this) {
            this.P |= 1;
        }
        notifyPropertyChanged(BR.f17732i);
        super.B();
    }

    public final void a(int i11, View view) {
        RecommendSpeakerActivity recommendSpeakerActivity = this.L;
        if (recommendSpeakerActivity != null) {
            recommendSpeakerActivity.finish();
        }
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.P;
            this.P = 0;
        }
        if ((j11 & 2) != 0) {
            this.N.setOnClickListener(this.O);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.P != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.P = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[2], objArr[4], objArr[9], objArr[3], objArr[7], objArr[5], objArr[6], objArr[11], objArr[10], objArr[8]);
        this.P = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.M = constraintLayout;
        constraintLayout.setTag((Object) null);
        ImageView imageView = objArr[1];
        this.N = imageView;
        imageView.setTag((Object) null);
        G(view);
        this.O = new a(this, 1);
        t();
    }
}
