package dp;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import f6.c;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Action1;

public class n extends k {

    /* renamed from: d  reason: collision with root package name */
    public ImageView f83913d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f83914e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f83915f;

    /* renamed from: g  reason: collision with root package name */
    public String f83916g;

    public class a implements Action1<Void> {
        public a() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            n.this.dismiss();
        }
    }

    public class b implements Action1<Void> {
        public b() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            if (n.this.f83915f != null) {
                n.this.f83915f.onClick(n.this.f83914e);
            }
        }
    }

    public n(Activity activity) {
        super(activity);
    }

    public void j() {
        Observable<Void> a11 = dw.a.a(this.f83913d);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new a());
        dw.a.a(this.f83914e).throttleFirst(300, timeUnit).subscribe(new b());
    }

    public int k() {
        return R$layout.dialog_otc_deposit_operate;
    }

    public void l() {
        this.f83914e = (ImageView) findViewById(R$id.iv_center);
        this.f83913d = (ImageView) findViewById(R$id.iv_close);
        if (this.f83915f != null && !TextUtils.isEmpty(this.f83916g)) {
            o(this.f83915f, this.f83916g);
        }
    }

    public void o(View.OnClickListener onClickListener, String str) {
        this.f83915f = onClickListener;
        this.f83916g = str;
        if (this.f83914e != null && !TextUtils.isEmpty(str)) {
            if (str.endsWith("svg")) {
                c.a().l(getContext(), str, this.f83914e, R$drawable.coin_default_icon);
            } else {
                c.a().f(this.f83914e, str, R$drawable.coin_default_icon);
            }
        }
    }
}
