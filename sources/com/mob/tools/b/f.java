package com.mob.tools.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.location.Location;
import com.mob.commons.cc.a;
import com.mob.tools.MobLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class f implements a {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, Object> f27792a;

    public f(HashMap<String, Object> hashMap) {
        this.f27792a = hashMap;
    }

    private Object a(String str, Object... objArr) {
        LinkedList<Object> a11;
        try {
            HashMap<String, Object> hashMap = this.f27792a;
            if (hashMap == null || !hashMap.containsKey(str) || (a11 = a.a(this.f27792a.get(str), objArr)) == null || a11.isEmpty()) {
                return null;
            }
            return a11.get(0);
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public HashMap<String, Long> A() {
        return (HashMap) a(HashMap.class, a("gmrin", (Object[]) null));
    }

    public String B() {
        return (String) a(String.class, a("galgu", (Object[]) null));
    }

    public String C() {
        return (String) a(String.class, a("gscsz", (Object[]) null));
    }

    public String D() {
        return (String) a(String.class, a("gneypnw", new Object[0]));
    }

    public String E() {
        return (String) a(String.class, a("gnktpfs", (Object[]) null));
    }

    public String F() {
        return (String) a(String.class, a("gdtlnktpfs", (Object[]) null));
    }

    public boolean G() {
        return ((Boolean) a(Boolean.TYPE, a("cknavbl", (Object[]) null))).booleanValue();
    }

    public int H() {
        return ((Integer) a(Integer.TYPE, a("gdntp", (Object[]) null))).intValue();
    }

    public String I() {
        return (String) a(String.class, a("gtmne", (Object[]) null));
    }

    public String J() {
        return (String) a(String.class, a("gflv", (Object[]) null));
    }

    public String K() {
        return (String) a(String.class, a("gbsbd", (Object[]) null));
    }

    public String L() {
        return (String) a(String.class, a("gbfspy", (Object[]) null));
    }

    public String M() {
        return (String) a(String.class, a("gbplfo", (Object[]) null));
    }

    public String N() {
        return (String) a(String.class, a("giads", (Object[]) null));
    }

    public ArrayList<HashMap<String, String>> O() {
        return (ArrayList) a(ArrayList.class, a("gal", (Object[]) null));
    }

    public ArrayList<HashMap<String, String>> P() {
        return (ArrayList) a(ArrayList.class, a("gsl", (Object[]) null));
    }

    public String Q() {
        return (String) a(String.class, a("gdvk", (Object[]) null));
    }

    public String R() {
        return (String) a(String.class, a("gscpt", (Object[]) null));
    }

    public String S() {
        return (String) a(String.class, a("gsnmd", (Object[]) null));
    }

    public String T() {
        return (String) a(String.class, a("gpgnm", (Object[]) null));
    }

    public String U() {
        return (String) a(String.class, a("gpnmmt", (Object[]) null));
    }

    public int V() {
        return ((Integer) a(Integer.TYPE, a("gpvsnm", (Object[]) null))).intValue();
    }

    public String W() {
        return (String) a(String.class, a("gpvsme", (Object[]) null));
    }

    public boolean X() {
        return ((Boolean) a(Boolean.TYPE, a("cinmnps", (Object[]) null))).booleanValue();
    }

    public String Y() {
        return (String) a(String.class, a("gcrtpcnm", (Object[]) null));
    }

    public boolean Z() {
        return ((Boolean) a(Boolean.TYPE, a("ciafgd", (Object[]) null))).booleanValue();
    }

    public Context aa() {
        return (Context) a(Context.class, a("gaplcn", (Object[]) null));
    }

    public String ab() {
        return (String) a(String.class, a("gdvda", (Object[]) null));
    }

    public String ac() {
        return (String) a(String.class, a("gdvdtnas", (Object[]) null));
    }

    public long ad() {
        return ((Long) a(Long.TYPE, a("galtut", (Object[]) null))).longValue();
    }

    public String ae() {
        return (String) a(String.class, a("gdvme", (Object[]) null));
    }

    public String af() {
        return (String) a(String.class, a("gcrup", (Object[]) null));
    }

    public String ag() {
        return (String) a(String.class, a("gcifm", (Object[]) null));
    }

    public String ah() {
        return (String) a(String.class, a("godm", (Object[]) null));
    }

    public String ai() {
        return (String) a(String.class, a("godhm", (Object[]) null));
    }

    public HashMap<String, Object> aj() {
        return (HashMap) a(HashMap.class, a("galdm", (Object[]) null));
    }

    public ApplicationInfo ak() {
        return (ApplicationInfo) a(ApplicationInfo.class, a("gtaif", (Object[]) null));
    }

    public ArrayList<HashMap<String, Object>> al() {
        return (ArrayList) a(ArrayList.class, a("gtaifok", (Object[]) null));
    }

    public long am() {
        return ((Long) a(Long.TYPE, a("gtbdt", (Object[]) null))).longValue();
    }

    public double an() {
        return ((Double) a(Double.TYPE, a("gtscnin", (Object[]) null))).doubleValue();
    }

    public int ao() {
        return ((Integer) a(Integer.TYPE, a("gtscnppi", (Object[]) null))).intValue();
    }

    public boolean ap() {
        return ((Boolean) a(Boolean.TYPE, a("ishmos", (Object[]) null))).booleanValue();
    }

    public String aq() {
        return (String) a(String.class, a("gthmosv", (Object[]) null));
    }

    public String ar() {
        return (String) a(String.class, a("gthmosdtlv", (Object[]) null));
    }

    public int as() {
        return ((Integer) a(Integer.TYPE, a("gthmpmst", (Object[]) null))).intValue();
    }

    public int at() {
        return ((Integer) a(Integer.TYPE, a("gthmepmst", (Object[]) null))).intValue();
    }

    public String au() {
        return (String) a(String.class, a("gtinnerlangmt", (Object[]) null));
    }

    public int av() {
        return ((Integer) a(Integer.TYPE, a("gtgramgendt", (Object[]) null))).intValue();
    }

    public boolean aw() {
        return ((Boolean) a(Boolean.TYPE, a("ctedebbing", (Object[]) null))).booleanValue();
    }

    public ArrayList<HashMap<String, Object>> ax() {
        return (ArrayList) a(ArrayList.class, a("gteacifo", (Object[]) null));
    }

    public boolean b() {
        return ((Boolean) a(Boolean.TYPE, a("cx", (Object[]) null))).booleanValue();
    }

    public boolean c() {
        return ((Boolean) a(Boolean.TYPE, a("ckpd", (Object[]) null))).booleanValue();
    }

    public boolean d() {
        return ((Boolean) a(Boolean.TYPE, a("degb", (Object[]) null))).booleanValue();
    }

    public boolean e() {
        return ((Boolean) a(Boolean.TYPE, a("vnmt", (Object[]) null))).booleanValue();
    }

    public boolean f() {
        return ((Boolean) a(Boolean.TYPE, a("ckua", (Object[]) null))).booleanValue();
    }

    public boolean g() {
        return ((Boolean) a(Boolean.TYPE, a("dvenbl", (Object[]) null))).booleanValue();
    }

    public boolean h() {
        return ((Boolean) a(Boolean.TYPE, a("ubenbl", (Object[]) null))).booleanValue();
    }

    public boolean i() {
        return ((Boolean) a(Boolean.TYPE, a("iwpxy", (Object[]) null))).booleanValue();
    }

    public String j() {
        return (String) a(String.class, a("gavti", (Object[]) null));
    }

    public String k() {
        return (String) a(String.class, a("gmivsn", (Object[]) null));
    }

    public String l() {
        return (String) a(String.class, a("bgmdl", (Object[]) null));
    }

    public String m() {
        return (String) a(String.class, a("gmnft", (Object[]) null));
    }

    public String n() {
        return (String) a(String.class, a("gbrd", (Object[]) null));
    }

    public String o() {
        return (String) a(String.class, a("gdvtp", (Object[]) null));
    }

    public Object p() {
        return a(Object.class, a("gtecloc", (Object[]) null));
    }

    public ArrayList<HashMap<String, Object>> q() {
        return (ArrayList) a(ArrayList.class, a("gnbclin", (Object[]) null));
    }

    public HashMap<String, Object> r() {
        return e(false);
    }

    public int s() {
        return ((Integer) a(Integer.TYPE, a("govsit", (Object[]) null))).intValue();
    }

    public String t() {
        return (String) a(String.class, a("govsnm", (Object[]) null));
    }

    public String u() {
        return (String) a(String.class, a("golgu", (Object[]) null));
    }

    public String v() {
        return (String) a(String.class, a("gocnty", (Object[]) null));
    }

    public HashMap<String, Object> w() {
        return (HashMap) a(HashMap.class, a("gcuin", (Object[]) null));
    }

    public ArrayList<ArrayList<String>> x() {
        return (ArrayList) a(ArrayList.class, a("gtydvin", (Object[]) null));
    }

    public String y() {
        return (String) a(String.class, a("gqmkn", (Object[]) null));
    }

    public HashMap<String, HashMap<String, Long>> z() {
        return (HashMap) a(HashMap.class, a("gszin", (Object[]) null));
    }

    public String b(boolean z11) {
        return (String) a(String.class, a("gbsifce", Boolean.valueOf(z11)));
    }

    public String c(boolean z11) {
        return (String) a(String.class, a("gcriefce", Boolean.valueOf(z11)));
    }

    public String d(boolean z11) {
        return (String) a(String.class, a("gcrnmfce", Boolean.valueOf(z11)));
    }

    public HashMap<String, Object> e(boolean z11) {
        return (HashMap) a(HashMap.class, a("wmcwifce", Boolean.valueOf(z11)));
    }

    public String f(boolean z11) {
        return (String) a(String.class, a("gneypfce", Boolean.valueOf(z11)));
    }

    public String g(boolean z11) {
        return (String) a(String.class, a("gdvkfc", Boolean.valueOf(z11)));
    }

    public String h(boolean z11) {
        return (String) a(String.class, a("gtdm", Boolean.valueOf(z11)));
    }

    public boolean b(String str) {
        return ((Boolean) a(Boolean.TYPE, a("ipgist", str))).booleanValue();
    }

    public String c(String str) {
        return (String) a(String.class, a("gsnmdfp", str));
    }

    public String d(String str) {
        return (String) a(String.class, a("gpnmfp", str));
    }

    public boolean e(String str) {
        return ((Boolean) a(Boolean.TYPE, a("ckpmsi", str))).booleanValue();
    }

    public long f(String str) {
        return ((Long) a(Long.TYPE, a("gtlstactme", str))).longValue();
    }

    public ResolveInfo b(Intent intent, int i11) {
        return (ResolveInfo) a(ResolveInfo.class, a("rsaciy", intent, Integer.valueOf(i11)));
    }

    public Object b(boolean z11, int i11, String str, int i12) {
        return a(Object.class, a("gpgiffist", Boolean.valueOf(z11), Integer.valueOf(i11), str, Integer.valueOf(i12)));
    }

    private <T> T a(Class<T> cls, Object obj) {
        T cast;
        T t11 = null;
        if (!(cls == null || obj == null || cls == Void.class)) {
            try {
                if (cls == Boolean.TYPE) {
                    cast = Boolean.class.cast(obj);
                } else if (cls == Integer.TYPE) {
                    cast = Integer.class.cast(obj);
                } else if (cls == Byte.TYPE) {
                    cast = Byte.class.cast(obj);
                } else if (cls == Character.TYPE) {
                    cast = Character.class.cast(obj);
                } else if (cls == Short.TYPE) {
                    cast = Short.class.cast(obj);
                } else if (cls == Long.TYPE) {
                    cast = Long.class.cast(obj);
                } else if (cls == Float.TYPE) {
                    cast = Float.class.cast(obj);
                } else if (cls == Double.TYPE) {
                    cast = Double.class.cast(obj);
                } else {
                    cast = cls.cast(obj);
                }
                t11 = cast;
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
        if (t11 != null) {
            return t11;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (cls == Integer.TYPE) {
            return -1;
        }
        if (cls == Byte.TYPE) {
            return (byte) 0;
        }
        if (cls == Character.TYPE) {
            return 0;
        }
        if (cls == Short.TYPE) {
            return (short) 0;
        }
        if (cls == Long.TYPE) {
            return 0L;
        }
        if (cls == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        return cls == Double.TYPE ? Double.valueOf(0.0d) : t11;
    }

    public boolean a() {
        return ((Boolean) a(Boolean.TYPE, a("cird", (Object[]) null))).booleanValue();
    }

    public String a(boolean z11) {
        return (String) a(String.class, a("gsimtfce", Boolean.valueOf(z11)));
    }

    public ArrayList<HashMap<String, String>> a(boolean z11, boolean z12) {
        return (ArrayList) a(ArrayList.class, a("giafce", Boolean.valueOf(z11), Boolean.valueOf(z12)));
    }

    public Location a(int i11, int i12, boolean z11) {
        return (Location) a(Location.class, a("glctn", Integer.valueOf(i11), Integer.valueOf(i12), Boolean.valueOf(z11)));
    }

    public String a(String str) {
        return (String) a(String.class, a("gstmpts", str));
    }

    public List<ResolveInfo> a(Intent intent, int i11) {
        return (List) a(List.class, a("qritsvc", intent, Integer.valueOf(i11)));
    }

    public PackageInfo a(boolean z11, int i11, String str, int i12) {
        return (PackageInfo) a(PackageInfo.class, a("gpgiffist", Boolean.valueOf(z11), Integer.valueOf(i11), str, Integer.valueOf(i12)));
    }

    public ApplicationInfo a(String str, int i11) {
        return (ApplicationInfo) a(ApplicationInfo.class, a("gtaifprm", str, Integer.valueOf(i11)));
    }

    public ApplicationInfo a(boolean z11, String str, int i11) {
        return (ApplicationInfo) a(ApplicationInfo.class, a("gtaifprmfce", Boolean.valueOf(z11), str, Integer.valueOf(i11)));
    }

    public List a(int i11, int i12, boolean z11, boolean z12) {
        return (List) a(List.class, a("gtelcmefce", Integer.valueOf(i11), Integer.valueOf(i12), Boolean.valueOf(z11), Boolean.valueOf(z12)));
    }
}
