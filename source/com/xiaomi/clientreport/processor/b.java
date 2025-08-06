package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.data.a;
import com.xiaomi.push.bm;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public class b implements IPerfProcessor {

    /* renamed from: a  reason: collision with root package name */
    public Context f51274a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, HashMap<String, a>> f2425a;

    public b(Context context) {
        this.f51274a = context;
    }

    private String c(a aVar) {
        String b11 = b(aVar);
        if (TextUtils.isEmpty(b11)) {
            return null;
        }
        for (int i11 = 0; i11 < 20; i11++) {
            String str = b11 + i11;
            if (bm.a(this.f51274a, str)) {
                return str;
            }
        }
        return null;
    }

    public void a() {
        bm.a(this.f51274a, "perf", "perfUploading");
        File[] a11 = bm.a(this.f51274a, "perfUploading");
        if (a11 != null && a11.length > 0) {
            for (File file : a11) {
                if (file != null) {
                    List<String> a12 = e.a(this.f51274a, file.getAbsolutePath());
                    file.delete();
                    a(a12);
                }
            }
        }
    }

    public void b() {
        HashMap<String, HashMap<String, a>> hashMap = this.f2425a;
        if (hashMap != null) {
            if (hashMap.size() > 0) {
                for (String str : this.f2425a.keySet()) {
                    HashMap hashMap2 = this.f2425a.get(str);
                    if (hashMap2 != null && hashMap2.size() > 0) {
                        a[] aVarArr = new a[hashMap2.size()];
                        hashMap2.values().toArray(aVarArr);
                        a(aVarArr);
                    }
                }
            }
            this.f2425a.clear();
        }
    }

    public void setPerfMap(HashMap<String, HashMap<String, a>> hashMap) {
        this.f2425a = hashMap;
    }

    public void a(List<String> list) {
        bm.a(this.f51274a, list);
    }

    public void a(a[] aVarArr) {
        String c11 = c(aVarArr[0]);
        if (!TextUtils.isEmpty(c11)) {
            e.a(c11, aVarArr);
        }
    }

    private String b(a aVar) {
        String str;
        int i11 = aVar.production;
        String str2 = aVar.clientInterfaceId;
        if (i11 <= 0 || TextUtils.isEmpty(str2)) {
            str = "";
        } else {
            str = String.valueOf(i11) + "#" + str2;
        }
        File file = new File(this.f51274a.getFilesDir(), "perf");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str).getAbsolutePath();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2323a(a aVar) {
        if ((aVar instanceof PerfClientReport) && this.f2425a != null) {
            PerfClientReport perfClientReport = (PerfClientReport) aVar;
            String a11 = a((a) perfClientReport);
            String a12 = e.a(perfClientReport);
            HashMap hashMap = this.f2425a.get(a11);
            if (hashMap == null) {
                hashMap = new HashMap();
            }
            PerfClientReport perfClientReport2 = (PerfClientReport) hashMap.get(a12);
            if (perfClientReport2 != null) {
                perfClientReport.perfCounts += perfClientReport2.perfCounts;
                perfClientReport.perfLatencies += perfClientReport2.perfLatencies;
            }
            hashMap.put(a12, perfClientReport);
            this.f2425a.put(a11, hashMap);
        }
    }

    public static String a(a aVar) {
        return String.valueOf(aVar.production) + "#" + aVar.clientInterfaceId;
    }
}
