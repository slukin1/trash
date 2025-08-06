package com.tencent.android.tpush.a;

import android.content.pm.ProviderInfo;
import java.util.ArrayList;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f68103a;

    /* renamed from: b  reason: collision with root package name */
    private ProviderInfo f68104b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<ProviderInfo> f68105c;

    public void a(String str) {
        this.f68103a = str;
    }

    public void b(ProviderInfo providerInfo) {
        if (this.f68105c == null) {
            this.f68105c = new ArrayList<>();
        }
        this.f68105c.add(providerInfo);
    }

    public void a(ProviderInfo providerInfo) {
        this.f68104b = providerInfo;
    }

    public ArrayList<ProviderInfo> a() {
        return this.f68105c;
    }
}
