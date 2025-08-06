package com.zendesk.belvedere;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.FragmentManager;
import com.zendesk.belvedere.a;
import iz.a;
import iz.b;
import iz.e;
import java.io.File;
import java.util.List;
import java.util.Locale;

public class Belvedere {

    /* renamed from: a  reason: collision with root package name */
    public final Context f52728a;

    /* renamed from: b  reason: collision with root package name */
    public final a f52729b;

    /* renamed from: c  reason: collision with root package name */
    public final e f52730c;

    /* renamed from: d  reason: collision with root package name */
    public final b f52731d;

    public Belvedere(Context context, a aVar) {
        this.f52728a = context;
        e eVar = new e(aVar);
        this.f52730c = eVar;
        this.f52729b = new a(aVar, eVar);
        b b11 = aVar.b();
        this.f52731d = b11;
        b11.d("Belvedere", "Belvedere initialized");
    }

    public static a.C0643a b(Context context) {
        if (context != null && context.getApplicationContext() != null) {
            return new a.C0643a(context.getApplicationContext());
        }
        throw new IllegalArgumentException("Invalid context provided");
    }

    public void a() {
        this.f52731d.d("Belvedere", "Clear Belvedere cache");
        this.f52730c.b(this.f52728a);
    }

    public List<BelvedereIntent> c() {
        return this.f52729b.c(this.f52728a);
    }

    public BelvedereResult d(String str) {
        Uri i11;
        File l11 = this.f52730c.l(this.f52728a, str);
        this.f52731d.d("Belvedere", String.format(Locale.US, "Get internal File: %s", new Object[]{l11}));
        if (l11 == null || (i11 = this.f52730c.i(this.f52728a, l11)) == null) {
            return null;
        }
        return new BelvedereResult(l11, i11);
    }

    public void e(int i11, int i12, Intent intent, BelvedereCallback<List<BelvedereResult>> belvedereCallback) {
        this.f52729b.e(this.f52728a, i11, i12, intent, belvedereCallback);
    }

    public void f(FragmentManager fragmentManager) {
        BelvedereDialog.uh(fragmentManager, c());
    }
}
