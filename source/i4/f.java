package i4;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.business.common.R$id;

public class f extends e {
    public static final f.i M = null;
    public static final SparseIntArray N;
    public final ConstraintLayout K;
    public long L;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        N = sparseIntArray;
        sparseIntArray.put(R$id.clRedPacket, 1);
        sparseIntArray.put(R$id.ivBackground, 2);
        sparseIntArray.put(R$id.guideline_wishWord, 3);
        sparseIntArray.put(R$id.guideline_user_nick, 4);
        sparseIntArray.put(R$id.guideline_open_red_packet, 5);
        sparseIntArray.put(R$id.tvWishWord, 6);
        sparseIntArray.put(R$id.tvUserNick, 7);
        sparseIntArray.put(R$id.tvOpenRedPacket, 8);
        sparseIntArray.put(R$id.ivClose, 9);
    }

    public f(b bVar, View view) {
        this(bVar, view, androidx.databinding.f.w(bVar, view, 10, M, N));
    }

    public void i() {
        synchronized (this) {
            this.L = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.L != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.L = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[1], objArr[5], objArr[4], objArr[3], objArr[2], objArr[9], objArr[8], objArr[7], objArr[6]);
        this.L = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.K = constraintLayout;
        constraintLayout.setTag((Object) null);
        G(view);
        t();
    }
}
