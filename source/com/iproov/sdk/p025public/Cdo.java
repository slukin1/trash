package com.iproov.sdk.p025public;

import android.os.Build;
import com.iproov.sdk.cameray.Cbreak;
import com.iproov.sdk.cameray.Cconst;
import com.iproov.sdk.p005class.Celse;
import com.iproov.sdk.p025public.Cif;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.iproov.sdk.public.do  reason: invalid class name and invalid package */
public class Cdo {

    /* renamed from: if  reason: not valid java name */
    private static Cdo f1124if;

    /* renamed from: do  reason: not valid java name */
    private final List<Cif> f1125do;

    private Cdo() {
        ArrayList arrayList = new ArrayList();
        this.f1125do = arrayList;
        Cif.Cdo doVar = new Cif.Cdo("asus", "Nexus 7", "grouper");
        Cbreak breakR = Cbreak.BACK;
        arrayList.add(doVar.m1303do(breakR).m1306do());
        arrayList.add(new Cif.Cdo("android", "Amazon Tate", "bowser").m1303do(breakR).m1306do());
        arrayList.add(new Cif.Cdo("Xiaomi", "Mi MIX 2", "qcom").m1304do(Cconst.CAMERA2).m1306do());
        arrayList.add(new Cif.Cdo("LGE", "LG-M700", "mh").m1304do(Cconst.CAMERA1).m1306do());
        arrayList.add(new Cif.Cdo("Huawei", "EML-L09", "kirin970").m1305do(Celse.AVC).m1306do());
    }

    /* renamed from: do  reason: not valid java name */
    public static Cdo m1286do() {
        if (f1124if == null) {
            f1124if = new Cdo();
        }
        return f1124if;
    }

    /* renamed from: if  reason: not valid java name */
    public Cif m1288if() {
        return m1287do(Build.MANUFACTURER, Build.MODEL, Build.HARDWARE);
    }

    /* renamed from: do  reason: not valid java name */
    private Cif m1287do(String str, String str2, String str3) {
        String str4 = Build.MANUFACTURER;
        String str5 = Build.MODEL;
        String str6 = Build.HARDWARE;
        for (Cif next : this.f1125do) {
            if ((next.m1295case() == null || next.m1295case().equalsIgnoreCase(str)) && ((next.m1297else() == null || next.m1297else().equalsIgnoreCase(str2)) && (next.m1302try() == null || next.m1302try().equalsIgnoreCase(str3)))) {
                next.m1295case();
                next.m1297else();
                next.m1302try();
                return next;
            }
        }
        return new Cif(str, str2, str3, (Cbreak) null, (Cconst) null, (Double) null, (Celse) null);
    }
}
