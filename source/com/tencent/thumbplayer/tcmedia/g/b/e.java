package com.tencent.thumbplayer.tcmedia.g.b;

import android.media.MediaFormat;
import android.os.Build;
import com.tencent.thumbplayer.tcmedia.g.h.b;
import com.tencent.thumbplayer.tcmedia.g.h.c;
import com.tencent.ugc.beauty.decoder.MediaUtils;
import java.util.ArrayList;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<byte[]> f49231a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public int f49232b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f49233c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f49234d;

    /* renamed from: e  reason: collision with root package name */
    public int f49235e;

    /* renamed from: f  reason: collision with root package name */
    public int f49236f;

    /* renamed from: g  reason: collision with root package name */
    public int f49237g = -1;

    /* renamed from: h  reason: collision with root package name */
    public int f49238h = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f49239i = -1;

    /* renamed from: j  reason: collision with root package name */
    public final String f49240j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f49241k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f49242l;

    public e(String str) {
        this.f49240j = str;
    }

    public static int a(MediaFormat mediaFormat, String str) {
        return a(mediaFormat, str, -1);
    }

    public static int a(MediaFormat mediaFormat, String str, int i11) {
        return mediaFormat.containsKey(str) ? mediaFormat.getInteger(str) : i11;
    }

    public static e a(MediaFormat mediaFormat) {
        e eVar = new e(mediaFormat.getString("mime"));
        try {
            eVar.f49236f = a(mediaFormat, "sample-rate");
            eVar.f49239i = a(mediaFormat, "max-input-size");
            eVar.f49231a = c.a(mediaFormat);
            if (eVar.a()) {
                eVar.f49234d = a(mediaFormat, MediaUtils.KEY_ROTATION);
                eVar.f49232b = a(mediaFormat, "width");
                eVar.f49233c = a(mediaFormat, "height");
                if (Build.VERSION.SDK_INT >= 19) {
                    eVar.f49237g = a(mediaFormat, "max-width");
                    eVar.f49238h = a(mediaFormat, "max-height");
                }
            } else {
                eVar.f49235e = a(mediaFormat, "channel-count");
            }
        } catch (Throwable th2) {
            b.b("FormatWrapper", "create format error", th2);
        }
        return eVar;
    }

    private static String a(String str, byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(", length:");
        sb2.append(bArr.length);
        sb2.append("  [");
        for (int i11 = 0; i11 < Math.min(bArr.length, 20); i11++) {
            if (i11 != 0) {
                sb2.append(" ,");
            }
            sb2.append(bArr[i11]);
        }
        sb2.append("]");
        return sb2.toString();
    }

    public static void a(ArrayList<byte[]> arrayList) {
        if (arrayList != null && b.a()) {
            StringBuilder sb2 = new StringBuilder();
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                sb2.append(a(c.f49343a[i11], arrayList.get(i11)));
                sb2.append("\n");
            }
            b.b("FormatWrapper", "csdData size:" + arrayList.size() + "    " + sb2.toString());
        }
    }

    public final boolean a() {
        if (!this.f49241k) {
            this.f49241k = true;
            this.f49242l = c.a(this.f49240j);
        }
        return this.f49242l;
    }

    public final boolean a(e eVar) {
        if (this.f49231a.size() != eVar.f49231a.size()) {
            return false;
        }
        for (int i11 = 0; i11 < this.f49231a.size(); i11++) {
            if (!this.f49231a.get(i11).equals(eVar.f49231a.get(i11))) {
                return false;
            }
        }
        return true;
    }
}
