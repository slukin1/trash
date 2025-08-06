package na;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.h0;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.lib.widgets.R$font;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.utils.HuobiToastUtil;

public class b extends Toast {

    /* renamed from: b  reason: collision with root package name */
    public static b f76335b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f76336c = false;

    /* renamed from: d  reason: collision with root package name */
    public static int f76337d;

    /* renamed from: e  reason: collision with root package name */
    public static final Handler f76338e = new Handler(Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public static final int f76339f = R$layout.layout_safe_toast;

    /* renamed from: g  reason: collision with root package name */
    public static final int f76340g = R$id.safe_toast_tv;

    /* renamed from: h  reason: collision with root package name */
    public static b f76341h;

    /* renamed from: i  reason: collision with root package name */
    public static String f76342i;

    /* renamed from: a  reason: collision with root package name */
    public TextView f76343a;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f76344b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f76345c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f76346d;

        public a(Context context, String str, int i11) {
            this.f76344b = context;
            this.f76345c = str;
            this.f76346d = i11;
        }

        public void run() {
            b.d(this.f76344b, this.f76345c, this.f76346d);
        }
    }

    /* renamed from: na.b$b  reason: collision with other inner class name */
    public class C0815b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f76347b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f76348c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f76349d;

        public C0815b(Context context, String str, int i11) {
            this.f76347b = context;
            this.f76348c = str;
            this.f76349d = i11;
        }

        public void run() {
            b.d(this.f76347b, this.f76348c, this.f76349d);
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f76350b;

        public c(String str) {
            this.f76350b = str;
        }

        public void run() {
            if (b.f76335b != null) {
                b.f76335b.setText(this.f76350b);
            }
        }
    }

    public b(Context context) {
        super(context);
    }

    public static void d(Context context, String str, int i11) {
        if (f76341h == null) {
            g(context);
        }
        boolean Z = h0.Z(f76341h.getView());
        if (!Z) {
            f76341h.cancel();
            g(context);
        }
        f76342i = str;
        f76341h.setDuration(i11);
        f76341h.setText(f76342i);
        if (!Z) {
            f76341h.show();
        }
    }

    public static b e(Context context, String str, int i11, int i12, int i13, boolean z11) {
        if (f76335b == null || f76337d != i12 || f76336c) {
            f76336c = false;
            if (i12 != 0) {
                f76335b = new b(context.getApplicationContext(), i12, i13);
            } else {
                f76335b = new b(context.getApplicationContext());
            }
            HuobiToastUtil.c(f76335b);
            HuobiToastUtil.b(f76335b);
            f76337d = i12;
            if (z11) {
                f76335b.setGravity(17, 0, 0);
            }
        }
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            Handler handler = f76338e;
            if (handler != null) {
                handler.post(new c(str));
            }
        } else {
            f76335b.setText(str);
        }
        f76335b.setDuration(i11);
        return f76335b;
    }

    public static void f(Context context, String str, int i11) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            d(context, str, i11);
        } else if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(new a(context, str, i11));
        } else {
            new Handler(Looper.getMainLooper()).post(new C0815b(context, str, i11));
        }
    }

    public static void g(Context context) {
        b bVar = new b(context.getApplicationContext(), f76339f, f76340g);
        f76341h = bVar;
        HuobiToastUtil.c(bVar);
        HuobiToastUtil.b(f76341h);
        f76342i = "";
    }

    public View c(Context context, int i11) {
        return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i11, (ViewGroup) null);
    }

    public void setGravity(int i11, int i12, int i13) {
        super.setGravity(i11, i12, i13);
        f76336c = true;
    }

    public void setText(CharSequence charSequence) {
        TextView textView = this.f76343a;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void show() {
        if (this.f76343a.getText() != null && !TextUtils.isEmpty(this.f76343a.getText().toString())) {
            super.show();
        }
    }

    public b(Context context, int i11, int i12) {
        super(context);
        View c11 = c(context, i11);
        TextView textView = (TextView) c11.findViewById(i12);
        this.f76343a = textView;
        textView.setTypeface(ResourcesCompat.h(context, R$font.roboto_medium));
        setView(c11);
        setGravity(87, 0, context.getResources().getDimensionPixelOffset(R$dimen.dimen_50));
    }
}
