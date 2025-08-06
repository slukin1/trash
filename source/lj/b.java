package lj;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.f;
import com.huobi.tradingbot.ui.BotCompleteActivity;
import jl.a;
import pro.huobi.R;

public class b extends a implements a.C0808a {
    public static final f.i J = null;
    public static final SparseIntArray K;
    public final ImageView G;
    public final View.OnClickListener H;
    public long I;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        K = sparseIntArray;
        sparseIntArray.put(R.id.vTopBar, 2);
        sparseIntArray.put(R.id.tvTitle, 3);
        sparseIntArray.put(R.id.llBotContent, 4);
    }

    public b(androidx.databinding.b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 5, J, K));
    }

    public void M(BotCompleteActivity botCompleteActivity) {
        this.F = botCompleteActivity;
        synchronized (this) {
            this.I |= 1;
        }
        notifyPropertyChanged(11);
        super.B();
    }

    public final void a(int i11, View view) {
        BotCompleteActivity botCompleteActivity = this.F;
        if (botCompleteActivity != null) {
            botCompleteActivity.finish();
        }
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.I;
            this.I = 0;
        }
        if ((j11 & 2) != 0) {
            this.G.setOnClickListener(this.H);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.I != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.I = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public b(androidx.databinding.b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[4], objArr[0], objArr[3], objArr[2]);
        this.I = -1;
        this.C.setTag((Object) null);
        ImageView imageView = objArr[1];
        this.G = imageView;
        imageView.setTag((Object) null);
        G(view);
        this.H = new a(this, 1);
        t();
    }
}
