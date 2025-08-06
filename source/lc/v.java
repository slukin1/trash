package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.community.ui.PostDynamicActivity;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;
import mc.a;

public class v extends u implements a.C0130a {
    public static final f.i S = null;
    public static final SparseIntArray T;
    public final LinearLayout M;
    public final TextView N;
    public final ConstraintLayout O;
    public final View.OnClickListener P;
    public final View.OnClickListener Q;
    public long R;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        T = sparseIntArray;
        sparseIntArray.put(R$id.vTopBar, 3);
        sparseIntArray.put(R$id.rlActionBar, 4);
        sparseIntArray.put(R$id.tvPost, 5);
        sparseIntArray.put(R$id.etTitle, 6);
        sparseIntArray.put(R$id.vLine, 7);
        sparseIntArray.put(R$id.richEditor, 8);
        sparseIntArray.put(R$id.tvTopicTag, 9);
        sparseIntArray.put(R$id.imageBack, 10);
        sparseIntArray.put(R$id.tvTopicNumTag, 11);
        sparseIntArray.put(R$id.llInsertPic, 12);
    }

    public v(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 13, S, T));
    }

    public void M(PostDynamicActivity postDynamicActivity) {
        this.L = postDynamicActivity;
        synchronized (this) {
            this.R |= 1;
        }
        notifyPropertyChanged(BR.f17732i);
        super.B();
    }

    public final void a(int i11, View view) {
        boolean z11 = false;
        if (i11 == 1) {
            PostDynamicActivity postDynamicActivity = this.L;
            if (postDynamicActivity != null) {
                z11 = true;
            }
            if (z11) {
                postDynamicActivity.Nh();
            }
        } else if (i11 == 2) {
            PostDynamicActivity postDynamicActivity2 = this.L;
            if (postDynamicActivity2 != null) {
                z11 = true;
            }
            if (z11) {
                postDynamicActivity2.Uh();
            }
        }
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.R;
            this.R = 0;
        }
        if ((j11 & 2) != 0) {
            this.N.setOnClickListener(this.Q);
            this.O.setOnClickListener(this.P);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.R != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.R = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[6], objArr[10], objArr[12], objArr[8], objArr[4], objArr[5], objArr[11], objArr[9], objArr[7], objArr[3]);
        this.R = -1;
        LinearLayout linearLayout = objArr[0];
        this.M = linearLayout;
        linearLayout.setTag((Object) null);
        TextView textView = objArr[1];
        this.N = textView;
        textView.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[2];
        this.O = constraintLayout;
        constraintLayout.setTag((Object) null);
        G(view);
        this.P = new a(this, 2);
        this.Q = new a(this, 1);
        t();
    }
}
