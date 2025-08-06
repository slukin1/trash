package na;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.h0;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.R$font;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.h2;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import i6.k;

public class a extends Toast {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f76320b = false;

    /* renamed from: c  reason: collision with root package name */
    public static final Handler f76321c = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    public static final int f76322d = R$layout.layout_error_toast;

    /* renamed from: e  reason: collision with root package name */
    public static final int f76323e = R$id.error_toast_tv;

    /* renamed from: f  reason: collision with root package name */
    public static a f76324f;

    /* renamed from: g  reason: collision with root package name */
    public static String f76325g;

    /* renamed from: a  reason: collision with root package name */
    public TextView f76326a;

    /* renamed from: na.a$a  reason: collision with other inner class name */
    public class C0814a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f76327b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f76328c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f76329d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f76330e;

        public C0814a(Context context, int i11, String str, int i12) {
            this.f76327b = context;
            this.f76328c = i11;
            this.f76329d = str;
            this.f76330e = i12;
        }

        public void run() {
            a.b(this.f76327b, this.f76328c, this.f76329d, this.f76330e);
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f76331b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f76332c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f76333d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f76334e;

        public b(Context context, int i11, String str, int i12) {
            this.f76331b = context;
            this.f76332c = i11;
            this.f76333d = str;
            this.f76334e = i12;
        }

        public void run() {
            a.b(this.f76331b, this.f76332c, this.f76333d, this.f76334e);
        }
    }

    public a(Context context, int i11, int i12) {
        super(context);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i11, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(i12);
        this.f76326a = textView;
        textView.setTypeface(ResourcesCompat.h(context, R$font.roboto_medium));
        setView(inflate);
        setGravity(17, 0, 0);
    }

    public static void b(Context context, int i11, String str, int i12) {
        if (f76324f == null) {
            e(context);
        }
        boolean Z = h0.Z(f76324f.getView());
        if (!Z) {
            f76324f.cancel();
            e(context);
        }
        f76325g = str;
        f76324f.setDuration(i12);
        f76324f.setText(f76325g);
        f76324f.f(i11);
        if (!Z) {
            f76324f.show();
        }
    }

    public static void c(Context context, int i11, String str, int i12) {
        if (str != null) {
            try {
                if (str.contains("匿名")) {
                    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                    StringBuilder sb2 = new StringBuilder();
                    for (StackTraceElement append : stackTrace) {
                        sb2.append("\n");
                        sb2.append(append);
                    }
                    String str2 = "request_unknow_name-->" + str + "-->" + sb2.toString();
                    if (h2.a() != null) {
                        RuntimeException runtimeException = new RuntimeException(str2);
                        k.k(runtimeException);
                        h2.a().e(runtimeException);
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(context, i11, str, i12);
        } else if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(new C0814a(context, i11, str, i12));
        } else {
            new Handler(Looper.getMainLooper()).post(new b(context, i11, str, i12));
        }
    }

    public static void d(Context context, String str, int i11) {
        c(context, 0, str, i11);
    }

    public static void e(Context context) {
        a aVar = new a(context.getApplicationContext(), f76322d, f76323e);
        f76324f = aVar;
        HuobiToastUtil.c(aVar);
        HuobiToastUtil.b(f76324f);
        f76325g = "";
    }

    public void f(int i11) {
        TextView textView = this.f76326a;
        if (textView == null) {
            return;
        }
        if (i11 > 0) {
            try {
                Drawable drawable = ContextCompat.getDrawable(BaseApplication.b(), i11);
                drawable.setBounds(0, 0, PixelUtils.a(24.0f), PixelUtils.a(24.0f));
                this.f76326a.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } else {
            textView.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public void setGravity(int i11, int i12, int i13) {
        super.setGravity(i11, i12, i13);
        f76320b = true;
    }

    public void setText(CharSequence charSequence) {
        TextView textView = this.f76326a;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void show() {
        if (this.f76326a.getText() != null && !TextUtils.isEmpty(this.f76326a.getText().toString())) {
            super.show();
        }
    }
}
