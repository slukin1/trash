package com.tencent.thumbplayer.tcmedia.adapter;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.tcmedia.adapter.a.e;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalParam;
import com.tencent.thumbplayer.tcmedia.api.TPProgramInfo;
import com.tencent.thumbplayer.tcmedia.api.TPTrackInfo;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private Object f48882a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, d> f48883b = new HashMap(0);

    /* renamed from: c  reason: collision with root package name */
    private Map<String, a> f48884c = new HashMap(0);

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<C0615c> f48885d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private Map<Integer, TPOptionalParam> f48886e = new HashMap(0);

    /* renamed from: f  reason: collision with root package name */
    private h f48887f = new h();

    /* renamed from: g  reason: collision with root package name */
    private b f48888g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f48889h;

    /* renamed from: i  reason: collision with root package name */
    private float f48890i;

    /* renamed from: j  reason: collision with root package name */
    private String f48891j;

    /* renamed from: k  reason: collision with root package name */
    private float f48892k;

    /* renamed from: l  reason: collision with root package name */
    private Map<Integer, TPTrackInfo> f48893l = new HashMap(0);

    /* renamed from: m  reason: collision with root package name */
    private int f48894m = -1;

    /* renamed from: n  reason: collision with root package name */
    private ArrayList<TPTrackInfo> f48895n = new ArrayList<>();

    /* renamed from: o  reason: collision with root package name */
    private TPProgramInfo f48896o;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f48897a;

        /* renamed from: b  reason: collision with root package name */
        public String f48898b;

        /* renamed from: c  reason: collision with root package name */
        public List<TPOptionalParam> f48899c;

        /* renamed from: d  reason: collision with root package name */
        public Map<String, String> f48900d;
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f48901a;

        /* renamed from: b  reason: collision with root package name */
        public long f48902b;

        /* renamed from: c  reason: collision with root package name */
        public long f48903c;
    }

    /* renamed from: com.tencent.thumbplayer.tcmedia.adapter.c$c  reason: collision with other inner class name */
    public static class C0615c {

        /* renamed from: a  reason: collision with root package name */
        public int f48904a;

        /* renamed from: b  reason: collision with root package name */
        public long f48905b;

        /* renamed from: c  reason: collision with root package name */
        public TPTrackInfo f48906c;
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f48907a;

        /* renamed from: b  reason: collision with root package name */
        public String f48908b;

        /* renamed from: c  reason: collision with root package name */
        public String f48909c;

        /* renamed from: d  reason: collision with root package name */
        public Map<String, String> f48910d;
    }

    private void a(String str, String str2) {
        this.f48894m++;
        TPTrackInfo tPTrackInfo = new TPTrackInfo();
        tPTrackInfo.trackType = 2;
        tPTrackInfo.name = str2;
        tPTrackInfo.isSelected = false;
        tPTrackInfo.isExclusive = true;
        tPTrackInfo.isInternal = false;
        this.f48895n.add(tPTrackInfo);
    }

    private void a(String str, String str2, String str3) {
        this.f48894m++;
        TPTrackInfo tPTrackInfo = new TPTrackInfo();
        tPTrackInfo.trackType = 3;
        tPTrackInfo.name = str3;
        tPTrackInfo.isSelected = false;
        tPTrackInfo.isExclusive = true;
        tPTrackInfo.isInternal = false;
        this.f48895n.add(tPTrackInfo);
    }

    public TPTrackInfo a(int i11) {
        return this.f48893l.get(Integer.valueOf(i11));
    }

    public void a() {
        this.f48883b.clear();
        this.f48884c.clear();
        this.f48889h = false;
        this.f48890i = 1.0f;
        this.f48891j = "";
        this.f48892k = 1.0f;
        this.f48893l.clear();
        this.f48882a = null;
        this.f48886e.clear();
        this.f48887f = new h();
        this.f48888g = null;
        this.f48896o = null;
        this.f48894m = -1;
        this.f48895n.clear();
        this.f48885d.clear();
    }

    public void a(float f11) {
        this.f48890i = f11;
    }

    public void a(int i11, long j11, TPTrackInfo tPTrackInfo) {
        this.f48893l.put(Integer.valueOf(tPTrackInfo.getTrackType()), tPTrackInfo);
        if (i11 < 0 || i11 >= this.f48895n.size()) {
            TPLogUtil.w("TPPlaybackParams", "track Index:" + i11 + " is invalid, trackInfoList size:" + this.f48895n.size());
            return;
        }
        C0615c cVar = new C0615c();
        cVar.f48904a = i11;
        cVar.f48905b = j11;
        Iterator<TPTrackInfo> it2 = this.f48895n.iterator();
        while (it2.hasNext()) {
            TPTrackInfo next = it2.next();
            if (next.trackType == tPTrackInfo.trackType) {
                if ((!TextUtils.isEmpty(next.name) || !TextUtils.isEmpty(tPTrackInfo.name)) && !next.name.equals(tPTrackInfo.name)) {
                    next.isSelected = false;
                } else {
                    next.isSelected = true;
                    cVar.f48906c = next;
                }
            }
        }
        this.f48885d.add(cVar);
    }

    public void a(AssetFileDescriptor assetFileDescriptor) {
        this.f48887f.a(assetFileDescriptor);
    }

    public void a(ParcelFileDescriptor parcelFileDescriptor) {
        this.f48887f.a(parcelFileDescriptor);
    }

    public void a(Surface surface) {
        this.f48882a = surface;
    }

    public void a(SurfaceHolder surfaceHolder) {
        this.f48882a = surfaceHolder;
    }

    public void a(e eVar, Map<String, String> map) {
        this.f48887f.a(eVar);
        this.f48887f.a(map);
    }

    public void a(TPOptionalParam tPOptionalParam) {
        if (tPOptionalParam != null) {
            this.f48886e.put(Integer.valueOf(tPOptionalParam.getKey()), tPOptionalParam);
        }
    }

    public void a(TPProgramInfo tPProgramInfo) {
        this.f48896o = tPProgramInfo;
    }

    public void a(ITPMediaAsset iTPMediaAsset) {
        this.f48887f.a(iTPMediaAsset);
    }

    public void a(String str) {
        this.f48891j = str;
    }

    public void a(String str, Map<String, String> map) {
        this.f48887f.a(str);
        this.f48887f.a(map);
    }

    public void a(String str, Map<String, String> map, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            d dVar = new d();
            dVar.f48907a = str;
            dVar.f48910d = map;
            dVar.f48908b = str2;
            dVar.f48909c = str3;
            this.f48883b.put(str, dVar);
            a(str, str2, str3);
        }
    }

    public void a(String str, Map<String, String> map, String str2, List<TPOptionalParam> list) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            a aVar = new a();
            aVar.f48897a = str;
            aVar.f48900d = map;
            aVar.f48898b = str2;
            aVar.f48899c = list;
            this.f48884c.put(str, aVar);
            a(str, str2);
        }
    }

    public void a(boolean z11) {
        this.f48889h = z11;
    }

    public void a(boolean z11, long j11, long j12) {
        if (this.f48888g == null) {
            this.f48888g = new b();
        }
        b bVar = this.f48888g;
        bVar.f48901a = z11;
        bVar.f48902b = j11;
        bVar.f48903c = j12;
    }

    public TPOptionalParam b(int i11) {
        return this.f48886e.get(Integer.valueOf(i11));
    }

    public ArrayList<TPTrackInfo> b() {
        return this.f48895n;
    }

    public void b(float f11) {
        this.f48892k = f11;
    }

    public void b(int i11, long j11, TPTrackInfo tPTrackInfo) {
        TPTrackInfo next;
        this.f48893l.remove(Integer.valueOf(tPTrackInfo.getTrackType()));
        if (i11 < 0 || i11 >= this.f48895n.size()) {
            TPLogUtil.w("TPPlaybackParams", "track Index:" + i11 + " is invalid, trackInfoList size:" + this.f48895n.size());
            return;
        }
        Iterator<TPTrackInfo> it2 = this.f48895n.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            next = it2.next();
            if (next.trackType != tPTrackInfo.trackType || ((!TextUtils.isEmpty(next.name) || !TextUtils.isEmpty(tPTrackInfo.name)) && !next.name.equals(tPTrackInfo.name))) {
            }
        }
        next.isSelected = false;
        Iterator<C0615c> it3 = this.f48885d.iterator();
        while (it3.hasNext()) {
            C0615c next2 = it3.next();
            TPTrackInfo tPTrackInfo2 = next2.f48906c;
            if (tPTrackInfo2 != null && tPTrackInfo2.equals(tPTrackInfo)) {
                this.f48885d.remove(next2);
                return;
            }
        }
    }

    public void b(String str) {
        this.f48887f.a(str);
    }

    public void b(boolean z11) {
        if (this.f48888g == null) {
            this.f48888g = new b();
        }
        b bVar = this.f48888g;
        bVar.f48901a = z11;
        bVar.f48902b = 0;
        bVar.f48903c = -1;
    }

    public ArrayList<C0615c> c() {
        return this.f48885d;
    }

    public Object d() {
        return this.f48882a;
    }

    public h e() {
        return this.f48887f;
    }

    public boolean f() {
        h hVar = this.f48887f;
        return hVar != null && hVar.h();
    }

    public boolean g() {
        return this.f48889h;
    }

    public float h() {
        return this.f48890i;
    }

    public String i() {
        return this.f48891j;
    }

    public float j() {
        return this.f48892k;
    }

    public b k() {
        return this.f48888g;
    }

    public TPProgramInfo l() {
        return this.f48896o;
    }

    public List<d> m() {
        ArrayList arrayList = new ArrayList(this.f48883b.size());
        for (Map.Entry<String, d> value : this.f48883b.entrySet()) {
            arrayList.add(value.getValue());
        }
        return arrayList;
    }

    public List<a> n() {
        ArrayList arrayList = new ArrayList(this.f48884c.size());
        for (Map.Entry<String, a> value : this.f48884c.entrySet()) {
            arrayList.add(value.getValue());
        }
        return arrayList;
    }

    public List<TPOptionalParam> o() {
        ArrayList arrayList = new ArrayList(this.f48886e.size());
        for (Map.Entry<Integer, TPOptionalParam> value : this.f48886e.entrySet()) {
            arrayList.add(value.getValue());
        }
        return arrayList;
    }

    public boolean p() {
        return e() != null && e().g() == 2;
    }
}
