package com.mob.tools.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.location.Location;
import com.mob.tools.MobLog;
import com.mob.tools.c.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class g implements a {

    /* renamed from: a  reason: collision with root package name */
    private Context f27793a;

    public g(Context context) {
        this.f27793a = context;
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

    public HashMap<String, Long> A() {
        return (HashMap) a(HashMap.class, a.a("gmrin", (ArrayList<Object>) null));
    }

    public String B() {
        return (String) a(String.class, a.a("galgu", (ArrayList<Object>) null));
    }

    public String C() {
        return (String) a(String.class, a.a("gscsz", (ArrayList<Object>) null));
    }

    public String D() {
        return (String) a(String.class, a.a("gneypnw", (ArrayList<Object>) null));
    }

    public String E() {
        return (String) a(String.class, a.a("gnktpfs", (ArrayList<Object>) null));
    }

    public String F() {
        return (String) a(String.class, a.a("gdtlnktpfs", (ArrayList<Object>) null));
    }

    public boolean G() {
        return ((Boolean) a(Boolean.TYPE, a.a("cknavbl", (ArrayList<Object>) null))).booleanValue();
    }

    public int H() {
        return ((Integer) a(Integer.TYPE, a.a("gdntp", (ArrayList<Object>) null))).intValue();
    }

    public String I() {
        return (String) a(String.class, a.a("gtmne", (ArrayList<Object>) null));
    }

    public String J() {
        return (String) a(String.class, a.a("gflv", (ArrayList<Object>) null));
    }

    public String K() {
        return (String) a(String.class, a.a("gbsbd", (ArrayList<Object>) null));
    }

    public String L() {
        return (String) a(String.class, a.a("gbfspy", (ArrayList<Object>) null));
    }

    public String M() {
        return (String) a(String.class, a.a("gbplfo", (ArrayList<Object>) null));
    }

    public String N() {
        return (String) a(String.class, a.a("giads", (ArrayList<Object>) null));
    }

    public ArrayList<HashMap<String, String>> O() {
        return (ArrayList) a(ArrayList.class, a.a("gal", (ArrayList<Object>) null));
    }

    public ArrayList<HashMap<String, String>> P() {
        return (ArrayList) a(ArrayList.class, a.a("gsl", (ArrayList<Object>) null));
    }

    public String Q() {
        return (String) a(String.class, a.a("gdvk", (ArrayList<Object>) null));
    }

    public String R() {
        return (String) a(String.class, a.a("gscpt", (ArrayList<Object>) null));
    }

    public String S() {
        return (String) a(String.class, a.a("gsnmd", (ArrayList<Object>) null));
    }

    public String T() {
        return (String) a(String.class, a.a("gpgnm", (ArrayList<Object>) null));
    }

    public String U() {
        return (String) a(String.class, a.a("gpnmmt", (ArrayList<Object>) null));
    }

    public int V() {
        return ((Integer) a(Integer.TYPE, a.a("gpvsnm", (ArrayList<Object>) null))).intValue();
    }

    public String W() {
        return (String) a(String.class, a.a("gpvsme", (ArrayList<Object>) null));
    }

    public boolean X() {
        return ((Boolean) a(Boolean.TYPE, a.a("cinmnps", (ArrayList<Object>) null))).booleanValue();
    }

    public String Y() {
        return (String) a(String.class, a.a("gcrtpcnm", (ArrayList<Object>) null));
    }

    public boolean Z() {
        return ((Boolean) a(Boolean.TYPE, a.a("ciafgd", (ArrayList<Object>) null))).booleanValue();
    }

    public Context aa() {
        return (Context) a(Context.class, a.a("gaplcn", (ArrayList<Object>) null));
    }

    public String ab() {
        return (String) a(String.class, a.a("gdvda", (ArrayList<Object>) null));
    }

    public String ac() {
        return (String) a(String.class, a.a("gdvdtnas", (ArrayList<Object>) null));
    }

    public long ad() {
        return ((Long) a(Long.TYPE, a.a("galtut", (ArrayList<Object>) null))).longValue();
    }

    public String ae() {
        return (String) a(String.class, a.a("gdvme", (ArrayList<Object>) null));
    }

    public String af() {
        return (String) a(String.class, a.a("gcrup", (ArrayList<Object>) null));
    }

    public String ag() {
        return (String) a(String.class, a.a("gcifm", (ArrayList<Object>) null));
    }

    public String ah() {
        return (String) a(String.class, a.a("godm", (ArrayList<Object>) null));
    }

    public String ai() {
        return (String) a(String.class, a.a("godhm", (ArrayList<Object>) null));
    }

    public HashMap<String, Object> aj() {
        return (HashMap) a(HashMap.class, a.a("galdm", (ArrayList<Object>) null));
    }

    public ApplicationInfo ak() {
        return (ApplicationInfo) a(ApplicationInfo.class, a.a("gtaif", (ArrayList<Object>) null));
    }

    public ArrayList<HashMap<String, Object>> al() {
        return (ArrayList) a(ArrayList.class, a.a("gtaifok", (ArrayList<Object>) null));
    }

    public long am() {
        return ((Long) a(Long.TYPE, a.a("gtbdt", (ArrayList<Object>) null))).longValue();
    }

    public double an() {
        return ((Double) a(Double.TYPE, a.a("gtscnin", (ArrayList<Object>) null))).doubleValue();
    }

    public int ao() {
        return ((Integer) a(Integer.TYPE, a.a("gtscnppi", (ArrayList<Object>) null))).intValue();
    }

    public boolean ap() {
        return ((Boolean) a(Boolean.TYPE, a.a("ishmos", (ArrayList<Object>) null))).booleanValue();
    }

    public String aq() {
        return (String) a(String.class, a.a("gthmosv", (ArrayList<Object>) null));
    }

    public String ar() {
        return (String) a(String.class, a.a("gthmosdtlv", (ArrayList<Object>) null));
    }

    public int as() {
        return ((Integer) a(Integer.TYPE, a.a("gthmpmst", (ArrayList<Object>) null))).intValue();
    }

    public int at() {
        return ((Integer) a(Integer.TYPE, a.a("gthmepmst", (ArrayList<Object>) null))).intValue();
    }

    public String au() {
        return (String) a(String.class, a.a("gtinnerlangmt", (ArrayList<Object>) null));
    }

    public int av() {
        return ((Integer) a(Integer.TYPE, a.a("gtgramgendt", (ArrayList<Object>) null))).intValue();
    }

    public boolean aw() {
        return ((Boolean) a(Boolean.TYPE, a.a("ctedebbing", (ArrayList<Object>) null))).booleanValue();
    }

    public ArrayList<HashMap<String, Object>> ax() {
        return (ArrayList) a(ArrayList.class, a.a("gteacifo", (ArrayList<Object>) null));
    }

    public boolean b() {
        return ((Boolean) a(Boolean.TYPE, a.a("cx", (ArrayList<Object>) null))).booleanValue();
    }

    public boolean c() {
        return ((Boolean) a(Boolean.TYPE, a.a("ckpd", (ArrayList<Object>) null))).booleanValue();
    }

    public boolean d() {
        return ((Boolean) a(Boolean.TYPE, a.a("degb", (ArrayList<Object>) null))).booleanValue();
    }

    public boolean e() {
        return ((Boolean) a(Boolean.TYPE, a.a("vnmt", (ArrayList<Object>) null))).booleanValue();
    }

    public boolean f() {
        return ((Boolean) a(Boolean.TYPE, a.a("ckua", (ArrayList<Object>) null))).booleanValue();
    }

    public boolean g() {
        return ((Boolean) a(Boolean.TYPE, a.a("dvenbl", (ArrayList<Object>) null))).booleanValue();
    }

    public boolean h() {
        return ((Boolean) a(Boolean.TYPE, a.a("ubenbl", (ArrayList<Object>) null))).booleanValue();
    }

    public boolean i() {
        return ((Boolean) a(Boolean.TYPE, a.a("iwpxy", (ArrayList<Object>) null))).booleanValue();
    }

    public String j() {
        return (String) a(String.class, a.a("gavti", (ArrayList<Object>) null));
    }

    public String k() {
        return (String) a(String.class, a.a("gmivsn", (ArrayList<Object>) null));
    }

    public String l() {
        return (String) a(String.class, a.a("bgmdl", (ArrayList<Object>) null));
    }

    public String m() {
        return (String) a(String.class, a.a("gmnft", (ArrayList<Object>) null));
    }

    public String n() {
        return (String) a(String.class, a.a("gbrd", (ArrayList<Object>) null));
    }

    public String o() {
        return (String) a(String.class, a.a("gdvtp", (ArrayList<Object>) null));
    }

    public Object p() {
        return a(Object.class, a.a("gtecloc", (ArrayList<Object>) null));
    }

    public ArrayList<HashMap<String, Object>> q() {
        return (ArrayList) a(ArrayList.class, a.a("gnbclin", (ArrayList<Object>) null));
    }

    public HashMap<String, Object> r() {
        return e(false);
    }

    public int s() {
        return ((Integer) a(Integer.TYPE, a.a("govsit", (ArrayList<Object>) null))).intValue();
    }

    public String t() {
        return (String) a(String.class, a.a("govsnm", (ArrayList<Object>) null));
    }

    public String u() {
        return (String) a(String.class, a.a("golgu", (ArrayList<Object>) null));
    }

    public String v() {
        return (String) a(String.class, a.a("gocnty", (ArrayList<Object>) null));
    }

    public HashMap<String, Object> w() {
        return (HashMap) a(HashMap.class, a.a("gcuin", (ArrayList<Object>) null));
    }

    public ArrayList<ArrayList<String>> x() {
        return (ArrayList) a(ArrayList.class, a.a("gtydvin", (ArrayList<Object>) null));
    }

    public String y() {
        return (String) a(String.class, a.a("gqmkn", (ArrayList<Object>) null));
    }

    public HashMap<String, HashMap<String, Long>> z() {
        return (HashMap) a(HashMap.class, a.a("gszin", (ArrayList<Object>) null));
    }

    public String b(boolean z11) {
        return (String) a(String.class, a.a("gbsifce", new ArrayList(Arrays.asList(new Boolean[]{Boolean.valueOf(z11)}))));
    }

    public String c(boolean z11) {
        return (String) a(String.class, a.a("gcriefce", new ArrayList(Arrays.asList(new Boolean[]{Boolean.valueOf(z11)}))));
    }

    public String d(boolean z11) {
        return (String) a(String.class, a.a("gcrnmfce", new ArrayList(Arrays.asList(new Boolean[]{Boolean.valueOf(z11)}))));
    }

    public HashMap<String, Object> e(boolean z11) {
        return (HashMap) a(HashMap.class, a.a("wmcwifce", new ArrayList(Arrays.asList(new Boolean[]{Boolean.valueOf(z11)}))));
    }

    public String f(boolean z11) {
        return (String) a(String.class, a.a("gneypfce", new ArrayList(Arrays.asList(new Boolean[]{Boolean.valueOf(z11)}))));
    }

    public String g(boolean z11) {
        return (String) a(String.class, a.a("gdvkfc", new ArrayList(Arrays.asList(new Boolean[]{Boolean.valueOf(z11)}))));
    }

    public String h(boolean z11) {
        return (String) a(String.class, a.a("gtdm", new ArrayList(Arrays.asList(new Boolean[]{Boolean.valueOf(z11)}))));
    }

    public boolean b(String str) {
        return ((Boolean) a(Boolean.TYPE, a.a("ipgist", new ArrayList(Arrays.asList(new String[]{str}))))).booleanValue();
    }

    public String c(String str) {
        return (String) a(String.class, a.a("gsnmdfp", new ArrayList(Arrays.asList(new String[]{str}))));
    }

    public String d(String str) {
        return (String) a(String.class, a.a("gpnmfp", new ArrayList(Arrays.asList(new String[]{str}))));
    }

    public boolean e(String str) {
        return ((Boolean) a(Boolean.TYPE, a.a("ckpmsi", new ArrayList(Arrays.asList(new String[]{str}))))).booleanValue();
    }

    public long f(String str) {
        return ((Long) a(Long.TYPE, a.a("gtlstactme", new ArrayList(Arrays.asList(new String[]{str}))))).longValue();
    }

    public ResolveInfo b(Intent intent, int i11) {
        return (ResolveInfo) a(ResolveInfo.class, a.a("rsaciy", new ArrayList(Arrays.asList(new Object[]{intent, Integer.valueOf(i11)}))));
    }

    public Object b(boolean z11, int i11, String str, int i12) {
        return a(PackageInfo.class, a.a("gmpfis", new ArrayList(Arrays.asList(new Serializable[]{Boolean.valueOf(z11), Integer.valueOf(i11), str, Integer.valueOf(i12)}))));
    }

    public boolean a() {
        return ((Boolean) a(Boolean.TYPE, a.a("cird", (ArrayList<Object>) null))).booleanValue();
    }

    public String a(boolean z11) {
        return (String) a(String.class, a.a("gsimtfce", new ArrayList(Arrays.asList(new Boolean[]{Boolean.valueOf(z11)}))));
    }

    public ArrayList<HashMap<String, String>> a(boolean z11, boolean z12) {
        return (ArrayList) a(ArrayList.class, a.a("giafce", new ArrayList(Arrays.asList(new Boolean[]{Boolean.valueOf(z11), Boolean.valueOf(z12)}))));
    }

    public Location a(int i11, int i12, boolean z11) {
        return (Location) a(Location.class, a.a("glctn", new ArrayList(Arrays.asList(new Serializable[]{Integer.valueOf(i11), Integer.valueOf(i12), Boolean.valueOf(z11)}))));
    }

    public String a(String str) {
        return (String) a(String.class, a.a("gstmpts", new ArrayList(Arrays.asList(new String[]{str}))));
    }

    public List<ResolveInfo> a(Intent intent, int i11) {
        return (List) a(List.class, a.a("qritsvc", new ArrayList(Arrays.asList(new Object[]{intent, Integer.valueOf(i11)}))));
    }

    public PackageInfo a(boolean z11, int i11, String str, int i12) {
        return (PackageInfo) a(PackageInfo.class, a.a("gpgiffist", new ArrayList(Arrays.asList(new Serializable[]{Boolean.valueOf(z11), Integer.valueOf(i11), str, Integer.valueOf(i12)}))));
    }

    public ApplicationInfo a(String str, int i11) {
        return (ApplicationInfo) a(ApplicationInfo.class, a.a("gtaifprm", new ArrayList(Arrays.asList(new Serializable[]{str, Integer.valueOf(i11)}))));
    }

    public ApplicationInfo a(boolean z11, String str, int i11) {
        return (ApplicationInfo) a(ApplicationInfo.class, a.a("gtaifprmfce", new ArrayList(Arrays.asList(new Serializable[]{Boolean.valueOf(z11), str, Integer.valueOf(i11)}))));
    }

    public List a(int i11, int i12, boolean z11, boolean z12) {
        return (List) a(List.class, a.a("gtelcmefce", new ArrayList(Arrays.asList(new Serializable[]{Integer.valueOf(i11), Integer.valueOf(i12), Boolean.valueOf(z11), Boolean.valueOf(z12)}))));
    }
}
