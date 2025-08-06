package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class p0 extends o0 {
    public static final f.i S = null;
    public static final SparseIntArray T;
    public final LinearLayout Q;
    public long R;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        T = sparseIntArray;
        sparseIntArray.put(R$id.vEmpty, 1);
        sparseIntArray.put(R$id.llHeader, 2);
        sparseIntArray.put(R$id.ivAvatar, 3);
        sparseIntArray.put(R$id.tvName, 4);
        sparseIntArray.put(R$id.tvChat, 5);
        sparseIntArray.put(R$id.tvFollow, 6);
        sparseIntArray.put(R$id.llInfo, 7);
        sparseIntArray.put(R$id.tvAttention, 8);
        sparseIntArray.put(R$id.tvFans, 9);
        sparseIntArray.put(R$id.tvDynamic, 10);
        sparseIntArray.put(R$id.llAction, 11);
        sparseIntArray.put(R$id.tvDisableSpeaking, 12);
        sparseIntArray.put(R$id.tvBlockUser, 13);
        sparseIntArray.put(R$id.tvKickout, 14);
        sparseIntArray.put(R$id.tvSetAdmin, 15);
    }

    public p0(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 16, S, T));
    }

    public void i() {
        synchronized (this) {
            this.R = 0;
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
            this.R = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public p0(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[3], objArr[11], objArr[2], objArr[7], objArr[8], objArr[13], objArr[5], objArr[12], objArr[10], objArr[9], objArr[6], objArr[14], objArr[4], objArr[15], objArr[1]);
        this.R = -1;
        LinearLayout linearLayout = objArr[0];
        this.Q = linearLayout;
        linearLayout.setTag((Object) null);
        G(view);
        t();
    }
}
