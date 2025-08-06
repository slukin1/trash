package vr;

import android.content.Context;
import bh.j;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huochat.community.util.ClipManager;
import pro.huobi.R;

public class d extends a {
    public d(Context context) {
        super(context);
        this.f85013a = true;
    }

    public void a() {
        super.a();
        HuobiToastUtil.r(j.c().getResources().getString(R.string.n_replicated));
    }

    public void c(String str, String str2, String str3) {
    }

    public void d(String str) {
        ClipManager.copy(str);
    }

    public void e(String str, String str2, String str3) {
        ClipManager.copy(str2);
    }
}
