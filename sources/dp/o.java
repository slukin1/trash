package dp;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Action1;

public class o extends k {

    /* renamed from: d  reason: collision with root package name */
    public d f83919d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f83920e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f83921f;

    /* renamed from: g  reason: collision with root package name */
    public View f83922g;

    public class a implements Action1<Void> {
        public a() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            o.this.dismiss();
        }
    }

    public class b implements Action1<Void> {
        public b() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            o.this.dismiss();
            o.this.n(true);
            OtcModuleConfig.a().b("6182", (Map<String, Object>) null);
        }
    }

    public class c implements Action1<Void> {
        public c() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            o.this.dismiss();
            o.this.n(false);
        }
    }

    public interface d {
        void N6(boolean z11);
    }

    public o(Activity activity) {
        super(activity);
    }

    public void j() {
        Observable<Void> a11 = dw.a.a(this.f83922g);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new a());
        dw.a.a(this.f83920e).throttleFirst(300, timeUnit).subscribe(new b());
        dw.a.a(this.f83921f).throttleFirst(300, timeUnit).subscribe(new c());
    }

    public int k() {
        return R$layout.dialog_faq_close_layout;
    }

    public void l() {
        this.f83922g = findViewById(R$id.view_top);
        this.f83920e = (TextView) findViewById(R$id.tv_close);
        this.f83921f = (TextView) findViewById(R$id.tv_un_close);
    }

    public final void n(boolean z11) {
        d dVar = this.f83919d;
        if (dVar != null) {
            dVar.N6(z11);
        }
    }

    public void o(d dVar) {
        this.f83919d = dVar;
    }
}
