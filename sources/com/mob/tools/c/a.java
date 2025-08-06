package com.mob.tools.c;

import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.mob.MobSDK;
import com.mob.commons.CSCenter;
import com.mob.commons.ab;
import com.mob.commons.b;
import com.mob.commons.l;
import com.mob.tools.MobLog;
import com.mob.tools.b.c;
import com.mob.tools.b.d;
import com.mob.tools.log.NLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static ThreadLocal<Boolean> f27895a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    public static ThreadLocal<Boolean> f27896b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    public static ThreadLocal<Boolean> f27897c = new ThreadLocal<>();

    /* renamed from: d  reason: collision with root package name */
    private static final List<String> f27898d = Arrays.asList(new String[]{"bgmdl", "gmnft", "gbrd", "govsit", "govsnm", "golgu", "gocnty", "galgu", "gtmne", "gsnmd", "gpgnm", "gpnmmt", "gpvsnm", "gpvsme", "cinmnps", "ckpmsi", "gaplcn", "gpgif", "gpgiffist", "gcrtpcnm", "gscpt", "cird", "cknavbl", "ipgist", "ckua", "ubenbl", "dvenbl", "vnmt", "iwpxy", "cx", "degb", "gdtlnktpfs", "gpgiffcin", "gpgifstrg", "gtaif", "gtaifprm", "rsaciy", "gsnmdfp", "gcrie", "gcriefce", "gdvk", "gdvkfc", "godhm", "godm", "gmpfis"});

    /* renamed from: e  reason: collision with root package name */
    private static volatile String f27899e = null;

    @b
    public static Object a(String str, ArrayList<Object> arrayList) {
        try {
            return b(str, arrayList);
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    private static Object b(String str, ArrayList<Object> arrayList) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.mob.tools.b.a a11 = a(str);
        if ("gmpfis".equals(str)) {
            if (arrayList != null && arrayList.size() == 4) {
                return a11.b(((Boolean) arrayList.get(0)).booleanValue(), ((Integer) arrayList.get(1)).intValue(), (String) arrayList.get(2), ((Integer) arrayList.get(3)).intValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        } else if ("cird".equals(str)) {
            return Boolean.valueOf(a11.a());
        } else {
            if ("cx".equals(str)) {
                return Boolean.valueOf(a11.b());
            }
            if ("ckpd".equals(str)) {
                return Boolean.valueOf(a11.c());
            }
            if ("degb".equals(str)) {
                return Boolean.valueOf(a11.d());
            }
            if ("vnmt".equals(str)) {
                return Boolean.valueOf(a11.e());
            }
            if ("ckua".equals(str)) {
                return Boolean.valueOf(a11.f());
            }
            if ("dvenbl".equals(str)) {
                return Boolean.valueOf(a11.g());
            }
            if ("ubenbl".equals(str)) {
                return Boolean.valueOf(a11.h());
            }
            if ("iwpxy".equals(str)) {
                return Boolean.valueOf(a11.i());
            }
            if ("gavti".equals(str)) {
                return a11.j();
            }
            if ("gsimt".equals(str)) {
                return a11.a(false);
            }
            if ("gsimtfce".equals(str)) {
                if (arrayList != null && arrayList.size() == 1) {
                    return a11.a(((Boolean) arrayList.get(0)).booleanValue());
                }
                throw new Throwable("array illegal: " + arrayList);
            } else if ("gbsi".equals(str)) {
                return a11.b(false);
            } else {
                if ("gbsifce".equals(str)) {
                    if (arrayList != null && arrayList.size() == 1) {
                        return a11.b(((Boolean) arrayList.get(0)).booleanValue());
                    }
                    throw new Throwable("array illegal: " + arrayList);
                } else if ("gcrie".equals(str)) {
                    return a11.c(false);
                } else {
                    if ("gcriefce".equals(str)) {
                        if (arrayList != null && arrayList.size() == 1) {
                            return a11.c(((Boolean) arrayList.get(0)).booleanValue());
                        }
                        throw new Throwable("array illegal: " + arrayList);
                    } else if ("gcrnmfce".equals(str)) {
                        if (arrayList != null && arrayList.size() == 1) {
                            return a11.d(((Boolean) arrayList.get(0)).booleanValue());
                        }
                        throw new Throwable("array illegal: " + arrayList);
                    } else if ("gcrnm".equals(str)) {
                        return a11.d(false);
                    } else {
                        if ("gmivsn".equals(str)) {
                            return a11.k();
                        }
                        if ("bgmdl".equals(str)) {
                            return a11.l();
                        }
                        if ("gmnft".equals(str)) {
                            return a11.m();
                        }
                        if ("gbrd".equals(str)) {
                            return a11.n();
                        }
                        if ("gdvtp".equals(str)) {
                            return a11.o();
                        }
                        if ("gtecloc".equals(str)) {
                            return a11.p();
                        }
                        if ("gnbclin".equals(str)) {
                            return a11.q();
                        }
                        if ("wmcwi".equals(str)) {
                            return a11.e(false);
                        }
                        if ("wmcwifce".equals(str)) {
                            if (arrayList != null && arrayList.size() == 1) {
                                return a11.e(((Boolean) arrayList.get(0)).booleanValue());
                            }
                            throw new Throwable("array illegal: " + arrayList);
                        } else if ("govsit".equals(str)) {
                            return Integer.valueOf(a11.s());
                        } else {
                            if ("govsnm".equals(str)) {
                                return a11.t();
                            }
                            if ("golgu".equals(str)) {
                                return a11.u();
                            }
                            if ("gocnty".equals(str)) {
                                return a11.v();
                            }
                            if ("gcuin".equals(str)) {
                                return a11.w();
                            }
                            if ("gtydvin".equals(str)) {
                                return a11.x();
                            }
                            if ("gqmkn".equals(str)) {
                                return a11.y();
                            }
                            if ("gszin".equals(str)) {
                                return a11.z();
                            }
                            if ("gmrin".equals(str)) {
                                return a11.A();
                            }
                            if ("galgu".equals(str)) {
                                return a11.B();
                            }
                            if ("gscsz".equals(str)) {
                                return a11.C();
                            }
                            if ("gneyp".equals(str)) {
                                return a11.f(false);
                            }
                            if ("gneypnw".equals(str)) {
                                return a11.D();
                            }
                            if ("gneypfce".equals(str)) {
                                if (arrayList != null && arrayList.size() == 1) {
                                    return a11.f(((Boolean) arrayList.get(0)).booleanValue());
                                }
                                throw new Throwable("array illegal: " + arrayList);
                            } else if ("gnktpfs".equals(str)) {
                                return a11.E();
                            } else {
                                if ("gdtlnktpfs".equals(str)) {
                                    return a11.F();
                                }
                                if ("cknavbl".equals(str)) {
                                    return Boolean.valueOf(a11.G());
                                }
                                if ("gdntp".equals(str)) {
                                    return Integer.valueOf(a11.H());
                                }
                                if ("gtmne".equals(str)) {
                                    return a11.I();
                                }
                                if ("gflv".equals(str)) {
                                    return a11.J();
                                }
                                if ("gbsbd".equals(str)) {
                                    return a11.K();
                                }
                                if ("gbfspy".equals(str)) {
                                    return a11.L();
                                }
                                if ("gbplfo".equals(str)) {
                                    return a11.M();
                                }
                                if ("giads".equals(str)) {
                                    return a11.N();
                                }
                                if ("gia".equals(str)) {
                                    if (!b.a(l.a("003fii")) || ab.a().h() == 42) {
                                        return new ArrayList();
                                    }
                                    if (arrayList != null && arrayList.size() == 1) {
                                        return a11.a(((Boolean) arrayList.get(0)).booleanValue(), false);
                                    }
                                    throw new Throwable("array illegal: " + arrayList);
                                } else if ("giafce".equals(str)) {
                                    if (!b.a(l.a("003fii")) || ab.a().h() == 42) {
                                        return new ArrayList();
                                    }
                                    if (arrayList != null && arrayList.size() == 2) {
                                        return a11.a(((Boolean) arrayList.get(0)).booleanValue(), ((Boolean) arrayList.get(1)).booleanValue());
                                    }
                                    throw new Throwable("array illegal: " + arrayList);
                                } else if ("gal".equals(str)) {
                                    if (!b.a(l.a("003fii")) || ab.a().h() == 42) {
                                        return new ArrayList();
                                    }
                                    return a11.O();
                                } else if ("gsl".equals(str)) {
                                    if (!b.a(l.a("003fii")) || ab.a().h() == 42) {
                                        return new ArrayList();
                                    }
                                    return a11.P();
                                } else if ("glctn".equals(str)) {
                                    if (arrayList != null && arrayList.size() == 3) {
                                        return a11.a(((Integer) arrayList.get(0)).intValue(), ((Integer) arrayList.get(1)).intValue(), ((Boolean) arrayList.get(2)).booleanValue());
                                    }
                                    throw new Throwable("array illegal: " + arrayList);
                                } else if ("gstmpts".equals(str)) {
                                    if (arrayList != null && arrayList.size() == 1) {
                                        return a11.a((String) arrayList.get(0));
                                    }
                                    throw new Throwable("array illegal: " + arrayList);
                                } else if ("gdvk".equals(str)) {
                                    return a11.Q();
                                } else {
                                    if ("gdvkfc".equals(str)) {
                                        if (arrayList != null && arrayList.size() == 1) {
                                            return a11.g(((Boolean) arrayList.get(0)).booleanValue());
                                        }
                                        throw new Throwable("array illegal: " + arrayList);
                                    } else if ("ipgist".equals(str)) {
                                        if (arrayList != null && arrayList.size() == 1) {
                                            return Boolean.valueOf(a11.b((String) arrayList.get(0)));
                                        }
                                        throw new Throwable("array illegal: " + arrayList);
                                    } else if ("gscpt".equals(str)) {
                                        return a11.R();
                                    } else {
                                        if ("gsnmd".equals(str)) {
                                            return a11.S();
                                        }
                                        if ("gsnmdfp".equals(str)) {
                                            if (arrayList != null && arrayList.size() == 1) {
                                                return a11.c((String) arrayList.get(0));
                                            }
                                            throw new Throwable("array illegal: " + arrayList);
                                        } else if ("gpgnm".equals(str)) {
                                            return a11.T();
                                        } else {
                                            if ("gpnmmt".equals(str)) {
                                                return a11.U();
                                            }
                                            if ("gpnmfp".equals(str)) {
                                                if (arrayList != null && arrayList.size() == 1) {
                                                    return a11.d((String) arrayList.get(0));
                                                }
                                                throw new Throwable("array illegal: " + arrayList);
                                            } else if ("gpvsnm".equals(str)) {
                                                return Integer.valueOf(a11.V());
                                            } else {
                                                if ("gpvsme".equals(str)) {
                                                    return a11.W();
                                                }
                                                if ("cinmnps".equals(str)) {
                                                    return Boolean.valueOf(a11.X());
                                                }
                                                if ("gcrtpcnm".equals(str)) {
                                                    return a11.Y();
                                                }
                                                if ("ciafgd".equals(str)) {
                                                    return Boolean.valueOf(a11.Z());
                                                }
                                                if ("ckpmsi".equals(str)) {
                                                    if (arrayList != null && arrayList.size() == 1) {
                                                        return Boolean.valueOf(a11.e((String) arrayList.get(0)));
                                                    }
                                                    throw new Throwable("array illegal: " + arrayList);
                                                } else if ("gaplcn".equals(str)) {
                                                    return a11.aa();
                                                } else {
                                                    if ("qritsvc".equals(str)) {
                                                        if (arrayList != null && arrayList.size() == 2) {
                                                            return a11.a((Intent) arrayList.get(0), ((Integer) arrayList.get(1)).intValue());
                                                        }
                                                        throw new Throwable("array illegal: " + arrayList);
                                                    } else if ("rsaciy".equals(str)) {
                                                        if (arrayList != null && arrayList.size() == 2) {
                                                            return a11.b((Intent) arrayList.get(0), ((Integer) arrayList.get(1)).intValue());
                                                        }
                                                        throw new Throwable("array illegal: " + arrayList);
                                                    } else if ("gpgif".equals(str)) {
                                                        if (arrayList != null && arrayList.size() == 2) {
                                                            return a11.a(false, 0, (String) arrayList.get(0), ((Integer) arrayList.get(1)).intValue());
                                                        }
                                                        throw new Throwable("array illegal: " + arrayList);
                                                    } else if ("gpgiffcin".equals(str)) {
                                                        if (arrayList != null && arrayList.size() == 3) {
                                                            return a11.a(((Boolean) arrayList.get(0)).booleanValue(), 0, (String) arrayList.get(1), ((Integer) arrayList.get(2)).intValue());
                                                        }
                                                        throw new Throwable("array illegal: " + arrayList);
                                                    } else if ("gpgifstrg".equals(str)) {
                                                        if (arrayList != null && arrayList.size() == 3) {
                                                            return a11.a(false, ((Integer) arrayList.get(0)).intValue(), (String) arrayList.get(1), ((Integer) arrayList.get(2)).intValue());
                                                        }
                                                        throw new Throwable("array illegal: " + arrayList);
                                                    } else if ("gpgiffist".equals(str)) {
                                                        if (arrayList != null && arrayList.size() == 4) {
                                                            return a11.a(((Boolean) arrayList.get(0)).booleanValue(), ((Integer) arrayList.get(1)).intValue(), (String) arrayList.get(2), ((Integer) arrayList.get(3)).intValue());
                                                        }
                                                        throw new Throwable("array illegal: " + arrayList);
                                                    } else if ("gdvda".equals(str)) {
                                                        return a11.ab();
                                                    } else {
                                                        if ("gdvdtnas".equals(str)) {
                                                            return a11.ac();
                                                        }
                                                        if ("galtut".equals(str)) {
                                                            return Long.valueOf(a11.ad());
                                                        }
                                                        if ("gcrup".equals(str)) {
                                                            return a11.af();
                                                        }
                                                        if ("gcifm".equals(str)) {
                                                            return a11.ag();
                                                        }
                                                        if ("godm".equals(str)) {
                                                            String ah2 = a11.ah();
                                                            if (TextUtils.isEmpty(f27899e)) {
                                                                f27899e = ab.a().b("key_ched_od", (String) null);
                                                            }
                                                            if (TextUtils.isEmpty(ah2) || CSCenter.getInstance().invocationRecord().a()) {
                                                                return TextUtils.isEmpty(f27899e) ? ah2 : f27899e;
                                                            }
                                                            if (TextUtils.equals(f27899e, ah2)) {
                                                                return ah2;
                                                            }
                                                            f27899e = ah2;
                                                            ab.a().a("key_ched_od", ah2);
                                                            return ah2;
                                                        } else if ("godhm".equals(str)) {
                                                            return a11.ai();
                                                        } else {
                                                            if ("galdm".equals(str)) {
                                                                return a11.aj();
                                                            }
                                                            if ("gtaif".equals(str)) {
                                                                return a11.ak();
                                                            }
                                                            if ("gtaifok".equals(str)) {
                                                                return a11.al();
                                                            }
                                                            if ("gtaifprm".equals(str)) {
                                                                if (arrayList != null && arrayList.size() == 2) {
                                                                    return a11.a((String) arrayList.get(0), ((Integer) arrayList.get(1)).intValue());
                                                                }
                                                                throw new Throwable("array illegal: " + arrayList);
                                                            } else if ("gtaifprmfce".equals(str)) {
                                                                if (arrayList != null && arrayList.size() == 3) {
                                                                    return a11.a(((Boolean) arrayList.get(0)).booleanValue(), (String) arrayList.get(1), ((Integer) arrayList.get(2)).intValue());
                                                                }
                                                                throw new Throwable("array illegal: " + arrayList);
                                                            } else if ("gtbdt".equals(str)) {
                                                                return Long.valueOf(a11.am());
                                                            } else {
                                                                if ("gtscnin".equals(str)) {
                                                                    return Double.valueOf(a11.an());
                                                                }
                                                                if ("gtscnppi".equals(str)) {
                                                                    return Integer.valueOf(a11.ao());
                                                                }
                                                                if ("ishmos".equals(str)) {
                                                                    return Boolean.valueOf(a11.ap());
                                                                }
                                                                if ("gthmosv".equals(str)) {
                                                                    return a11.aq();
                                                                }
                                                                if ("gthmosdtlv".equals(str)) {
                                                                    return a11.ar();
                                                                }
                                                                if ("gthmpmst".equals(str)) {
                                                                    return Integer.valueOf(a11.as());
                                                                }
                                                                if ("gthmepmst".equals(str)) {
                                                                    return Integer.valueOf(a11.at());
                                                                }
                                                                if ("gtinnerlangmt".equals(str)) {
                                                                    return a11.au();
                                                                }
                                                                if ("gtgramgendt".equals(str)) {
                                                                    return Integer.valueOf(a11.av());
                                                                }
                                                                if ("ctedebbing".equals(str)) {
                                                                    return Boolean.valueOf(a11.aw());
                                                                }
                                                                if ("gtelcmefce".equals(str)) {
                                                                    if (arrayList != null && arrayList.size() == 4) {
                                                                        return a11.a(((Integer) arrayList.get(0)).intValue(), ((Integer) arrayList.get(1)).intValue(), ((Boolean) arrayList.get(2)).booleanValue(), ((Boolean) arrayList.get(3)).booleanValue());
                                                                    }
                                                                    throw new Throwable("array illegal: " + arrayList);
                                                                } else if ("gteacifo".equals(str)) {
                                                                    return a11.ax();
                                                                } else {
                                                                    if ("gtdm".equals(str)) {
                                                                        if (arrayList != null && arrayList.size() == 1) {
                                                                            return a11.h(((Boolean) arrayList.get(0)).booleanValue());
                                                                        }
                                                                        throw new Throwable("array illegal: " + arrayList);
                                                                    } else if (!"gtlstactme".equals(str)) {
                                                                        NLog instance = MobLog.getInstance();
                                                                        instance.d("Not found: " + str, new Object[0]);
                                                                        return null;
                                                                    } else if (arrayList != null && arrayList.size() == 1) {
                                                                        return Long.valueOf(a11.f((String) arrayList.get(0)));
                                                                    } else {
                                                                        throw new Throwable("array illegal: " + arrayList);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static com.mob.tools.b.a a(String str) {
        CountDownLatch d11;
        CountDownLatch d12;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            NLog instance = MobLog.getInstance();
            instance.w("WARNING: Call in main: key = " + str);
            b();
        }
        if (f27895a.get() == null ? false : f27895a.get().booleanValue()) {
            boolean booleanValue = f27896b.get() == null ? false : f27896b.get().booleanValue();
            boolean booleanValue2 = f27897c.get() == null ? false : f27897c.get().booleanValue();
            if (booleanValue) {
                MobLog.getInstance().d("isGCFThread true", new Object[0]);
            }
            if (!booleanValue && !booleanValue2 && !d.c() && (d11 = d.a(MobSDK.getContext()).d()) != null) {
                try {
                    NLog instance2 = MobLog.getInstance();
                    instance2.d("dhs_ivkr_new k: " + str + ", cdl: " + d11, new Object[0]);
                    d11.await(3500, TimeUnit.MILLISECONDS);
                } catch (Throwable th2) {
                    MobLog.getInstance().d(th2);
                }
            }
        } else if (!f27898d.contains(str) && !d.c() && (d12 = d.a(MobSDK.getContext()).d()) != null) {
            try {
                NLog instance3 = MobLog.getInstance();
                instance3.d("dhs_ivkr k: " + str + ", cdl: " + d12, new Object[0]);
                d12.await(3500, TimeUnit.MILLISECONDS);
            } catch (Throwable th3) {
                MobLog.getInstance().d(th3);
            }
        }
        return a();
    }

    private static com.mob.tools.b.a a() {
        if (d.c()) {
            return c.a(MobSDK.getContext()).e();
        }
        return c.a(MobSDK.getContext()).c();
    }

    private static void b() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null) {
                String str = "";
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement != null) {
                        str = str + stackTraceElement.getClassName() + InstructionFileId.DOT + stackTraceElement.getMethodName() + "(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")\n";
                    }
                }
                MobLog.getInstance().d(str, new Object[0]);
            }
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
        }
    }
}
