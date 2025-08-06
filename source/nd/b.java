package nd;

import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.R$style;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f23002a;

    /* renamed from: b  reason: collision with root package name */
    public Dialog f23003b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f23004c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f23005d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f23006e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f23007f;

    /* renamed from: g  reason: collision with root package name */
    public Button f23008g;

    /* renamed from: h  reason: collision with root package name */
    public Button f23009h;

    /* renamed from: i  reason: collision with root package name */
    public View f23010i;

    /* renamed from: j  reason: collision with root package name */
    public Display f23011j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f23012k = false;

    /* renamed from: l  reason: collision with root package name */
    public boolean f23013l = false;

    /* renamed from: m  reason: collision with root package name */
    public boolean f23014m = false;

    /* renamed from: n  reason: collision with root package name */
    public boolean f23015n = false;

    /* renamed from: o  reason: collision with root package name */
    public float f23016o = 0.7f;

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f23017b;

        public a(View.OnClickListener onClickListener) {
            this.f23017b = onClickListener;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f23017b.onClick(view);
            b.this.f23003b.dismiss();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: nd.b$b  reason: collision with other inner class name */
    public class C0203b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f23019b;

        public C0203b(View.OnClickListener onClickListener) {
            this.f23019b = onClickListener;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f23019b.onClick(view);
            b.this.f23003b.dismiss();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b.this.f23003b.dismiss();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public b(Context context) {
        this.f23002a = context;
        this.f23011j = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    public b a() {
        View inflate = LayoutInflater.from(this.f23002a).inflate(R$layout.im_view_dialog, (ViewGroup) null);
        this.f23004c = (LinearLayout) inflate.findViewById(R$id.ll_background);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.ll_alert);
        this.f23005d = linearLayout;
        linearLayout.setVerticalGravity(8);
        TextView textView = (TextView) inflate.findViewById(R$id.tv_title);
        this.f23006e = textView;
        textView.setVisibility(8);
        TextView textView2 = (TextView) inflate.findViewById(R$id.tv_content);
        this.f23007f = textView2;
        textView2.setVisibility(8);
        Button button = (Button) inflate.findViewById(R$id.btn_neg);
        this.f23008g = button;
        button.setVisibility(8);
        Button button2 = (Button) inflate.findViewById(R$id.btn_pos);
        this.f23009h = button2;
        button2.setVisibility(8);
        View findViewById = inflate.findViewById(R$id.img_line);
        this.f23010i = findViewById;
        findViewById.setVisibility(8);
        Dialog dialog = new Dialog(this.f23002a, R$style.TUIKit_AlertDialogStyle);
        this.f23003b = dialog;
        dialog.setContentView(inflate);
        this.f23004c.setLayoutParams(new FrameLayout.LayoutParams((int) (((float) this.f23011j.getWidth()) * this.f23016o), -2));
        return this;
    }

    public b b(boolean z11) {
        this.f23003b.setCanceledOnTouchOutside(z11);
        return this;
    }

    public b c(boolean z11) {
        this.f23003b.setCancelable(z11);
        return this;
    }

    public b d(String str) {
        this.f23013l = true;
        this.f23007f.setText(str);
        return this;
    }

    public b e(float f11) {
        LinearLayout linearLayout = this.f23004c;
        if (linearLayout != null) {
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams((int) (((float) this.f23011j.getWidth()) * f11), -2));
        }
        this.f23016o = f11;
        return this;
    }

    public final void f() {
        if (this.f23012k) {
            this.f23006e.setVisibility(0);
        } else {
            this.f23006e.setVisibility(8);
        }
        if (this.f23013l) {
            this.f23007f.setVisibility(0);
        } else {
            this.f23007f.setVisibility(8);
        }
        if (!this.f23014m && !this.f23015n) {
            this.f23009h.setVisibility(8);
            this.f23009h.setOnClickListener(new c());
        }
        if (this.f23014m && this.f23015n) {
            this.f23009h.setVisibility(0);
            this.f23008g.setVisibility(0);
            this.f23010i.setVisibility(0);
        }
        if (this.f23014m && !this.f23015n) {
            this.f23009h.setVisibility(0);
        }
        if (!this.f23014m && this.f23015n) {
            this.f23008g.setVisibility(0);
        }
    }

    public b g(String str, View.OnClickListener onClickListener) {
        this.f23015n = true;
        this.f23008g.setText(str);
        this.f23008g.setOnClickListener(new C0203b(onClickListener));
        return this;
    }

    public b h(String str, View.OnClickListener onClickListener) {
        this.f23014m = true;
        this.f23009h.setText(str);
        this.f23009h.setOnClickListener(new a(onClickListener));
        return this;
    }

    public b i(String str) {
        this.f23012k = true;
        this.f23006e.setText(str);
        return this;
    }

    public b j(float f11) {
        this.f23006e.setTextSize(2, f11);
        return this;
    }

    public void k() {
        f();
        this.f23003b.show();
    }
}
