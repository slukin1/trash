package com.tencent.thumbplayer.tcmedia.adapter;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.tencent.thumbplayer.tcmedia.adapter.a.e;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaAsset;
import java.util.HashMap;
import java.util.Map;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private String f48954a;

    /* renamed from: b  reason: collision with root package name */
    private int f48955b;

    /* renamed from: c  reason: collision with root package name */
    private ParcelFileDescriptor f48956c;

    /* renamed from: d  reason: collision with root package name */
    private AssetFileDescriptor f48957d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f48958e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private ITPMediaAsset f48959f;

    /* renamed from: g  reason: collision with root package name */
    private e f48960g;

    public String a() {
        return this.f48954a;
    }

    public void a(AssetFileDescriptor assetFileDescriptor) {
        this.f48954a = null;
        this.f48955b = 4;
        this.f48958e.clear();
        this.f48956c = null;
        this.f48957d = assetFileDescriptor;
    }

    public void a(ParcelFileDescriptor parcelFileDescriptor) {
        this.f48954a = null;
        this.f48955b = 1;
        this.f48958e.clear();
        this.f48956c = parcelFileDescriptor;
        this.f48957d = null;
    }

    public void a(e eVar) {
        this.f48954a = null;
        this.f48955b = 3;
        this.f48956c = null;
        this.f48957d = null;
        this.f48960g = eVar;
    }

    public void a(ITPMediaAsset iTPMediaAsset) {
        this.f48954a = null;
        this.f48955b = 2;
        this.f48958e.clear();
        this.f48956c = null;
        this.f48957d = null;
        this.f48959f = iTPMediaAsset;
    }

    public void a(String str) {
        this.f48954a = str;
        this.f48955b = 0;
        this.f48956c = null;
        this.f48957d = null;
    }

    public void a(Map<String, String> map) {
        this.f48958e.clear();
        Map<String, String> map2 = this.f48958e;
        if (map == null) {
            map = new HashMap<>(0);
        }
        map2.putAll(map);
    }

    public Map<String, String> b() {
        return this.f48958e;
    }

    public ParcelFileDescriptor c() {
        return this.f48956c;
    }

    public AssetFileDescriptor d() {
        return this.f48957d;
    }

    public ITPMediaAsset e() {
        return this.f48959f;
    }

    public e f() {
        return this.f48960g;
    }

    public int g() {
        return this.f48955b;
    }

    public boolean h() {
        return (TextUtils.isEmpty(this.f48954a) && this.f48956c == null && this.f48957d == null && this.f48959f == null && this.f48960g == null) ? false : true;
    }
}
