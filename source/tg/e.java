package tg;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.core.view.h0;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.ui.VipToastView;

public class e extends Toast {

    /* renamed from: b  reason: collision with root package name */
    public static e f47859b;

    /* renamed from: a  reason: collision with root package name */
    public VipToastView f47860a;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f47861b;

        public a(Context context) {
            this.f47861b = context;
        }

        public void run() {
            e.b(this.f47861b);
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f47862b;

        public b(Context context) {
            this.f47862b = context;
        }

        public void run() {
            e.b(this.f47862b);
        }
    }

    public e(Context context) {
        super(context);
        VipToastView vipToastView = new VipToastView(context);
        this.f47860a = vipToastView;
        setView(vipToastView);
        setGravity(55, 0, 0);
    }

    public static void b(Context context) {
        if (f47859b == null) {
            c(context);
        }
        boolean Z = h0.Z(f47859b.getView());
        if (!Z) {
            f47859b.cancel();
            c(context);
        }
        f47859b.setDuration(0);
        if (!Z) {
            f47859b.show();
        }
    }

    public static void c(Context context) {
        e eVar = new e(context.getApplicationContext());
        f47859b = eVar;
        HuobiToastUtil.c(eVar);
        HuobiToastUtil.b(f47859b);
    }

    public static void d(Context context) {
        if (context != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                b(context);
            } else if (context instanceof Activity) {
                ((Activity) context).runOnUiThread(new a(context));
            } else {
                new Handler(Looper.getMainLooper()).post(new b(context));
            }
        }
    }

    public void show() {
        if (this.f47860a.a()) {
            super.show();
        }
    }
}
