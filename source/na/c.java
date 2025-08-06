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
import com.hbg.lib.widgets.R$font;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.utils.HuobiToastUtil;

public class c extends Toast {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f76351b = false;

    /* renamed from: c  reason: collision with root package name */
    public static final Handler f76352c = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    public static final int f76353d = R$layout.layout_success_toast;

    /* renamed from: e  reason: collision with root package name */
    public static final int f76354e = R$id.success_toast_tv;

    /* renamed from: f  reason: collision with root package name */
    public static c f76355f;

    /* renamed from: g  reason: collision with root package name */
    public static String f76356g;

    /* renamed from: a  reason: collision with root package name */
    public TextView f76357a;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f76358b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f76359c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f76360d;

        public a(Context context, String str, int i11) {
            this.f76358b = context;
            this.f76359c = str;
            this.f76360d = i11;
        }

        public void run() {
            c.c(this.f76358b, this.f76359c, this.f76360d);
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f76361b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f76362c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f76363d;

        public b(Context context, String str, int i11) {
            this.f76361b = context;
            this.f76362c = str;
            this.f76363d = i11;
        }

        public void run() {
            c.c(this.f76361b, this.f76362c, this.f76363d);
        }
    }

    public c(Context context, int i11, int i12) {
        super(context);
        View b11 = b(context, i11);
        TextView textView = (TextView) b11.findViewById(i12);
        this.f76357a = textView;
        textView.setTypeface(ResourcesCompat.h(context, R$font.roboto_medium));
        setView(b11);
        setGravity(55, 0, 0);
    }

    public static void c(Context context, String str, int i11) {
        if (f76355f == null) {
            e(context);
        }
        boolean Z = h0.Z(f76355f.getView());
        if (!Z) {
            f76355f.cancel();
            e(context);
        }
        f76356g = str;
        f76355f.setDuration(i11);
        f76355f.setText(f76356g);
        if (!Z) {
            f76355f.show();
        }
    }

    public static void d(Context context, String str, int i11) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c(context, str, i11);
        } else if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(new a(context, str, i11));
        } else {
            new Handler(Looper.getMainLooper()).post(new b(context, str, i11));
        }
    }

    public static void e(Context context) {
        c cVar = new c(context.getApplicationContext(), f76353d, f76354e);
        f76355f = cVar;
        HuobiToastUtil.c(cVar);
        HuobiToastUtil.b(f76355f);
        f76356g = "";
    }

    public View b(Context context, int i11) {
        return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i11, (ViewGroup) null);
    }

    public void setGravity(int i11, int i12, int i13) {
        super.setGravity(i11, i12, i13);
        f76351b = true;
    }

    public void setText(CharSequence charSequence) {
        TextView textView = this.f76357a;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void show() {
        if (this.f76357a.getText() != null && !TextUtils.isEmpty(this.f76357a.getText().toString())) {
            super.show();
        }
    }
}
