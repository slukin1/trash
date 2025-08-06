package com.mob.commons.a;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.ab;
import com.mob.commons.b;
import com.mob.commons.m;
import com.mob.tools.MobLog;
import com.mob.tools.c;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

public class k extends c {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f26959c = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public long f26960d = 0;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<HashMap<String, String>> f26961e = null;

    public k() {
        super(m.a("002hb"), 0, m.a("004hbSdgbh"), 300, c.a(m.a("002hb"), (Long) 0L));
        try {
            File dataCacheFile = ResHelper.getDataCacheFile(MobSDK.getContext(), m.f27280c, true);
            if (!dataCacheFile.getParentFile().exists()) {
                dataCacheFile.getParentFile().mkdirs();
            }
            if (!dataCacheFile.exists()) {
                dataCacheFile.createNewFile();
            }
            this.f26959c = dataCacheFile.getAbsolutePath();
            this.f26960d = ab.a().b(ab.f26988b, -1);
        } catch (Throwable unused) {
        }
    }

    private boolean m() {
        try {
            File file = new File(this.f26959c);
            file.delete();
            file.createNewFile();
            return true;
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return false;
        }
    }

    private HashMap<String, String> b(ArrayList<HashMap<String, String>> arrayList, String str) {
        Iterator<HashMap<String, String>> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            HashMap<String, String> next = it2.next();
            if (str.equals(next.get(m.a("003hKcfch")))) {
                return next;
            }
        }
        return new HashMap<>();
    }

    public void a() {
        DH.requester(MobSDK.getContext()).getIAForce(false, false).request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) throws Throwable {
                ArrayList a11 = k.this.a(dHResponse.getIAForce(new int[0]));
                if (!TextUtils.isEmpty(k.this.f26959c)) {
                    k kVar = k.this;
                    kVar.a(a11, kVar.f26959c, DH.SyncMtd.getModel());
                }
                if (System.currentTimeMillis() - k.this.f26960d >= ((Long) k.this.a(m.a("005hb3ch3bh"), 3600L)).longValue() * 1000 && k.this.b((ArrayList<HashMap<String, String>>) a11)) {
                    long unused = k.this.f26960d = ab.a().b(ab.f26988b, -1);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public ArrayList<HashMap<String, String>> a(ArrayList<HashMap<String, String>> arrayList) throws Throwable {
        ArrayList<HashMap<String, String>> a11 = !TextUtils.isEmpty(this.f26959c) ? a(this.f26959c, DH.SyncMtd.getModel()) : null;
        if (a11 == null) {
            a11 = new ArrayList<>();
        }
        if (a11.isEmpty()) {
            ab.a().a("key_rcdat", System.currentTimeMillis());
        }
        ArrayList<HashMap<String, String>> arrayList2 = this.f26961e;
        if (arrayList2 == null || arrayList2.isEmpty() || b.f27019a) {
            b.f27019a = false;
            this.f26961e = arrayList;
        }
        ArrayList<HashMap<String, String>> arrayList3 = this.f26961e;
        if (arrayList3 != null) {
            for (int i11 = 0; i11 < arrayList3.size(); i11++) {
                HashMap hashMap = arrayList3.get(i11);
                String str = hashMap != null ? (String) hashMap.get(m.a("003h%cfch")) : null;
                if (!TextUtils.isEmpty(str) && a(str)) {
                    HashMap<String, String> b11 = b(a11, str);
                    b11.put(m.a("003h>cfch"), str);
                    b11.put(m.a("004cb?bdKd"), hashMap.get(m.a("004cb?bdKd")));
                    b11.put(m.a("007Wbb]dXbhdgbgbi.c"), hashMap.get(m.a("007Wbb]dXbhdgbgbi.c")));
                    int parseInt = b11.get(m.a("008Cbhbe<cg-bgbd-dTdg")) == null ? 0 : Integer.parseInt(String.valueOf(b11.get(m.a("008Cbhbe<cg-bgbd-dTdg"))));
                    b11.put(m.a("008[bhbeZcgXbgbd)dMdg"), (((long) parseInt) + l()) + "");
                    if (!a(a11, str)) {
                        a11.add(b11);
                    }
                }
            }
        }
        return a11;
    }

    /* access modifiers changed from: private */
    public boolean b(ArrayList<HashMap<String, String>> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(m.a("008Qbh[daZbibhbaXbg"), Long.valueOf(ab.a().b("key_rcdat", -1)));
            a(0, "PRTMT", arrayList, hashMap, false);
        } catch (Throwable unused) {
        }
        ab.a().a(ab.f26988b, System.currentTimeMillis());
        return m();
    }

    private static ArrayList<HashMap<String, String>> b(String str) {
        try {
            ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            JSONArray jSONArray = new JSONArray(str);
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                arrayList.add(HashonHelper.fromJson(jSONArray.getJSONObject(i11).toString()));
            }
            return arrayList;
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return new ArrayList<>();
        }
    }

    private boolean a(final String str) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        DH.requester(MobSDK.getContext()).getMpfof(true, str, 0).request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                boolean z11 = false;
                Object mpfof = dHResponse.getMpfof(new int[0]);
                if (mpfof != null) {
                    ApplicationInfo a11 = c.a(mpfof, str);
                    if (a11 != null) {
                        int i11 = a11.flags;
                        boolean z12 = (i11 & 1) == 0 && (i11 & 128) == 0;
                        boolean z13 = (i11 & 2097152) == 0;
                        AtomicBoolean atomicBoolean = atomicBoolean;
                        if (z12 && z13) {
                            z11 = true;
                        }
                        atomicBoolean.set(z11);
                        return;
                    }
                    return;
                }
                atomicBoolean.set(false);
            }
        });
        return atomicBoolean.get();
    }

    private boolean a(ArrayList<HashMap<String, String>> arrayList, String str) {
        Iterator<HashMap<String, String>> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (str.equals(it2.next().get(m.a("003hHcfch")))) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void a(ArrayList<HashMap<String, String>> arrayList, String str, String str2) {
        ResHelper.writeToFileNoCompress(new File(str), a(str2, arrayList));
    }

    private ArrayList<HashMap<String, String>> a(String str, String str2) {
        return a(str2, ResHelper.readFromFileNoCompress(new File(str)));
    }

    private static byte[] a(String str, ArrayList<HashMap<String, String>> arrayList) {
        new HashonHelper();
        String fromObject = HashonHelper.fromObject(arrayList);
        try {
            return Data.AES128Encode(str, fromObject);
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return fromObject.getBytes();
        }
    }

    private static ArrayList<HashMap<String, String>> a(String str, byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    return b(Data.AES128PaddingDecode(str.getBytes("UTF-8"), bArr));
                }
            } catch (Throwable th2) {
                MobLog.getInstance().w(th2);
                return new ArrayList<>();
            }
        }
        return new ArrayList<>();
    }
}
