package com.tencent.liteav.txcvodplayer.c;

import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.network.pro.core.util.Period;
import com.tencent.liteav.base.storage.PersistStorage;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcvodplayer.b.c;
import com.tencent.liteav.txcvodplayer.hlsencoder.TXCHLSEncoder;
import java.io.File;

public class a {

    /* renamed from: c  reason: collision with root package name */
    private static a f21962c;

    /* renamed from: a  reason: collision with root package name */
    public final PersistStorage f21963a;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f21964b;

    /* renamed from: d  reason: collision with root package name */
    private final PersistStorage f21965d;

    private a() {
        long j11;
        PersistStorage persistStorage = new PersistStorage("v4_cache");
        this.f21965d = persistStorage;
        Long l11 = persistStorage.getLong("clean_time");
        if (l11 == null) {
            j11 = 0;
        } else {
            j11 = l11.longValue();
        }
        this.f21964b = j11;
        this.f21963a = new PersistStorage("v4_download");
    }

    public static a a() {
        synchronized (a.class) {
            if (f21962c == null) {
                f21962c = new a();
            }
        }
        return f21962c;
    }

    public static String b(int i11, String str) {
        return i11 + "_" + str;
    }

    public static /* synthetic */ void a(a aVar, int i11, String str, String str2, c.b bVar) {
        String b11 = b(i11, str);
        String d11 = com.tencent.liteav.txcplayer.a.a.d(str2);
        String a11 = TXCHLSEncoder.a(i11, "default", str, 0);
        String a12 = TXCHLSEncoder.a(a11, bVar.f21916a);
        String a13 = TXCHLSEncoder.a(a11, bVar.f21917b);
        StringBuilder sb2 = new StringBuilder(a12);
        sb2.append("_");
        sb2.append(a13);
        sb2.append("_");
        sb2.append(d11);
        sb2.append("_");
        sb2.append(System.currentTimeMillis() / Period.MIN60_MILLS);
        sb2.append("_");
        sb2.append(bVar.f21918c);
        sb2.append("_");
        sb2.append(bVar.f21919d);
        aVar.f21965d.put(b11, sb2.toString());
        aVar.f21965d.commit();
        LiteavLog.i("PlayInfoProtocolV4Storage", "put cache key: " + b11 + " value:" + sb2.toString());
    }

    public final void a(int i11, String str, c.b bVar) {
        if (TextUtils.isEmpty(str) || bVar == null || TextUtils.isEmpty(bVar.f21916a) || TextUtils.isEmpty(bVar.f21917b) || TextUtils.isEmpty(bVar.f21918c) || TextUtils.isEmpty(bVar.f21919d)) {
            LiteavLog.w("PlayInfoProtocolV4Storage", "put params empty fileId: ".concat(String.valueOf(str)));
        } else {
            com.tencent.liteav.txcplayer.common.a.a().execute(c.a(this, i11, str, bVar));
        }
    }

    public static /* synthetic */ void a(a aVar, int i11, String str, c.b bVar) {
        String b11 = b(i11, str);
        String a11 = TXCHLSEncoder.a(i11, "default", str, 0);
        String a12 = TXCHLSEncoder.a(a11, bVar.f21916a);
        String a13 = TXCHLSEncoder.a(a11, bVar.f21917b);
        StringBuilder sb2 = new StringBuilder(a12);
        sb2.append("_");
        sb2.append(a13);
        sb2.append("_");
        sb2.append(bVar.f21918c);
        sb2.append("_");
        sb2.append(bVar.f21919d);
        aVar.f21963a.put(b11, sb2.toString());
        aVar.f21963a.commit();
        LiteavLog.i("PlayInfoProtocolV4Storage", "put download key: " + b11 + " value:" + sb2.toString());
    }

    public final c.b a(int i11, String str) {
        boolean z11;
        String[] split;
        c.b bVar = null;
        if (TextUtils.isEmpty(str)) {
            LiteavLog.w("PlayInfoProtocolV4Storage", "get fileId is empty");
            return null;
        }
        String b11 = b(i11, str);
        String string = this.f21963a.getString(b11);
        if (TextUtils.isEmpty(string)) {
            string = this.f21965d.getString(b11);
            z11 = false;
        } else {
            z11 = true;
        }
        if (!TextUtils.isEmpty(string) && (split = string.split("_")) != null && split.length >= 2) {
            bVar = new c.b();
            String a11 = TXCHLSEncoder.a(i11, "default", str, 0);
            bVar.f21916a = TXCHLSEncoder.b(a11, split[0]);
            bVar.f21917b = TXCHLSEncoder.b(a11, split[1]);
            if (z11) {
                if (split.length >= 4) {
                    bVar.f21918c = split[2];
                    bVar.f21919d = split[3];
                }
            } else if (split.length >= 6) {
                bVar.f21918c = split[4];
                bVar.f21919d = split[5];
            }
            LiteavLog.i("PlayInfoProtocolV4Storage", "get key: " + bVar.f21916a + " iv: " + bVar.f21917b);
        }
        return bVar;
    }

    public static /* synthetic */ void a(a aVar, String str, long j11) {
        String[] split;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        for (String str2 : aVar.f21965d.getAllKeys()) {
            String string = aVar.f21965d.getString(str2);
            if (string != null && (split = string.split("_")) != null && split.length >= 4 && j11 - Long.valueOf(split[3]).longValue() >= 24) {
                if (j11 - Long.valueOf(split[3]).longValue() < 72) {
                    if (!new File(str + split[2]).exists()) {
                        if (new File(str + InstructionFileId.DOT + split[2] + ".m3u8").exists()) {
                        }
                    }
                }
                aVar.f21965d.clear(str2);
                aVar.f21965d.commit();
                LiteavLog.i("PlayInfoProtocolV4Storage", "clean key: " + str2 + " value: " + string);
            }
        }
        aVar.f21965d.put("clean_time", aVar.f21964b);
        aVar.f21965d.commit();
    }
}
