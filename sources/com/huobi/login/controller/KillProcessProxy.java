package com.huobi.login.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Process;
import bh.j;
import br.c;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.main.ui.HuobiMainActivity;
import i6.i;
import pro.huobi.R;

public class KillProcessProxy {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f75437a = false;

    /* renamed from: b  reason: collision with root package name */
    public static Runnable f75438b = new a();

    public class a implements Runnable {
        public void run() {
            boolean unused = KillProcessProxy.f75437a = false;
            i.b().h(KillProcessProxy.f75438b);
        }
    }

    public static void c(Activity activity) {
        if (f75437a) {
            i.b().h(f75438b);
            d(activity);
        }
        f75437a = true;
        HuobiToastUtil.k(j.c(), R.string.string_tips_exit);
        i.b().g(f75438b, 3000);
    }

    public static void d(Activity activity) {
        activity.finish();
        if (activity instanceof HuobiMainActivity) {
            c.g(activity).c();
            Process.killProcess(Process.myPid());
            return;
        }
        activity.startActivity(new Intent(activity, HuobiMainActivity.class).putExtra("flag_exit", true));
    }
}
