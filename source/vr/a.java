package vr;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import pro.huobi.R;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f85013a;

    /* renamed from: b  reason: collision with root package name */
    public Context f85014b;

    /* renamed from: c  reason: collision with root package name */
    public Fragment f85015c;

    public a(Context context) {
        this.f85014b = context;
    }

    public void a() {
    }

    public void b(int i11, int i12, Intent intent) {
    }

    public abstract void c(String str, String str2, String str3);

    public void d(String str) {
    }

    public abstract void e(String str, String str2, String str3);

    public void f(String str, String str2, String str3, String str4) {
    }

    public final void g(String str, String str2, String str3) {
        if (this.f85013a) {
            a();
            try {
                c(str, str2, str3);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } else {
            HuobiToastUtil.g(R.string.invite_share_client_not_work_tips);
        }
    }

    public final void h(String str) {
        if (this.f85013a) {
            a();
            d(str);
            return;
        }
        HuobiToastUtil.g(R.string.invite_share_client_not_work_tips);
    }

    public final void i(String str, String str2, String str3) {
        if (this.f85013a) {
            a();
            e(str, str2, str3);
            return;
        }
        HuobiToastUtil.g(R.string.invite_share_client_not_work_tips);
    }

    public final void j(String str, String str2, String str3, String str4) {
        if (this.f85013a) {
            a();
            f(str, str2, str3, str4);
            return;
        }
        HuobiToastUtil.g(R.string.invite_share_client_not_work_tips);
    }
}
