package com.mob.tools.b;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.mob.commons.a.l;
import com.mob.commons.d;
import com.mob.commons.s;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.f;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class h {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Object f27800a;

        public a(Object obj) {
            this.f27800a = obj;
        }

        public float a() {
            return ((Float) ReflectHelper.invokeInstanceMethodNoThrow(this.f27800a, s.a("011^ej$fi[fdNccOdgdj[dcOec"), Float.valueOf(0.0f), new Object[0])).floatValue();
        }

        public double b() {
            return ((Double) ReflectHelper.invokeInstanceMethodNoThrow(this.f27800a, s.a("011<ej9fiDfeYdiAdi<iSdgdc?f"), Double.valueOf(0.0d), new Object[0])).doubleValue();
        }

        public double c() {
            return ((Double) ReflectHelper.invokeInstanceMethodNoThrow(this.f27800a, s.a("012?ej!fi=fedkPeDejdiIi$dgdc^f"), Double.valueOf(0.0d), new Object[0])).doubleValue();
        }

        public long d() {
            return ((Long) ReflectHelper.invokeInstanceMethodNoThrow(this.f27800a, s.a("007PejCfiQfcdidf9f"), 0L, new Object[0])).longValue();
        }

        public String e() {
            return (String) ReflectHelper.invokeInstanceMethodNoThrow(this.f27800a, s.a("0110ejMfiCgldjdkdddidcLfHdj"), null, new Object[0]);
        }

        public double f() {
            return ((Double) ReflectHelper.invokeInstanceMethodNoThrow(this.f27800a, s.a("011YejWfiSfd'giYdi6iSdgdc[f"), Double.valueOf(0.0d), new Object[0])).doubleValue();
        }

        public float g() {
            return ((Float) ReflectHelper.invokeInstanceMethodNoThrow(this.f27800a, s.a("010Iej6fi)fjBfdHdjdi%e5ej"), Float.valueOf(0.0f), new Object[0])).floatValue();
        }

        public float h() {
            return ((Float) ReflectHelper.invokeInstanceMethodNoThrow(this.f27800a, s.a("008?ejHfi;elCjffHdc"), Float.valueOf(0.0f), new Object[0])).floatValue();
        }

        public boolean i() {
            if (Build.VERSION.SDK_INT >= 26) {
                return ((Boolean) ReflectHelper.invokeInstanceMethodNoThrow(this.f27800a, s.a("019hdEfigkEf5dj9iQdiMcdg[fd4cc)dgdjIdc9ec"), Boolean.FALSE, new Object[0])).booleanValue();
            }
            return false;
        }

        public float j() {
            if (Build.VERSION.SDK_INT >= 26) {
                return ((Float) ReflectHelper.invokeInstanceMethodNoThrow(this.f27800a, s.a("0254ej5fiRgk0f6djSi[di9cdg(fd6ccTdgdjWdc!echcLfif^djfi"), Float.valueOf(0.0f), new Object[0])).floatValue();
            }
            return 0.0f;
        }

        public float a(Object obj) {
            if (obj != null) {
                try {
                    return ((Float) ReflectHelper.invokeInstanceMethod(this.f27800a, s.a("010;dcdifi=idecf5fcdk"), new Object[]{obj}, new Class[]{Class.forName(s.a("025deIdcdjdkdidcdl!g_dkHcdi]didk8eOdlfedk2cdi-didk.e"))})).floatValue();
                } catch (Throwable th2) {
                    MobLog.getInstance().d(th2);
                }
            }
            return 0.0f;
        }
    }

    public static Object a(Context context, String str) throws Throwable {
        int i11;
        int i12;
        Object obj;
        int i13;
        Parcel parcel;
        Parcel parcel2;
        Context context2 = context;
        String str2 = str;
        Class<String> cls = String.class;
        if (!d.f()) {
            return null;
        }
        if (!f.a().a(str2) || (i11 = Build.VERSION.SDK_INT) < 23) {
            return null;
        }
        com.mob.tools.a.d a11 = com.mob.tools.a.d.a(context);
        if (i11 >= 31) {
            Object a12 = a11.a(s.a("036de1dcdjdkdidcdl6gKdkKcdi'didk+eIdlfeAdNfiNi:fedk<cdiXdidkVe^gjFf(dedg*f5fiLi") + "$" + s.a("007]fjdgdiVgOdcCf)dj"));
            if (a12 != null) {
                i12 = 0;
                i13 = 1;
                obj = a11.a(s.a("036deXdcdjdkdidcdlKgFdkQcdiYdidk3e0dlfe:dDfi0iNfedkZcdiOdidkHe[gjWfGdedg1fPfiTi") + "$" + s.a("007!fjdgdiZgLdcDfOdj"), a12, s.a("005Bffdgdi>g,dc"), (Class[]) null, (Object[]) null, null);
            } else {
                i12 = 0;
                i13 = 1;
                obj = null;
            }
        } else {
            i12 = 0;
            i13 = 1;
            obj = a11.a(s.a("032deYdcdjdkdidcdl0g<dk3cdiMdidkVeUdlfedk^cdi1didkMe^gjMfUdedgQfBfi[i"), (Object) null, s.a("028c1djVfdifWgcdjdkdfflYfj$dj!fcdif0dcgldjdkdddidc[fVdj"), new Class[]{cls, Long.TYPE, Float.TYPE, Boolean.TYPE}, new Object[]{str2, 0, 0, Boolean.TRUE}, null);
        }
        Object obj2 = obj;
        int intValue = ((Integer) a11.a(s.a("033deAdcdjdkdidcdlPgUdkYcdi$didk>e:dleefedk@cdi[didk'e<hcKdedDejQf;dj") + "$" + s.a("004Jel(iSdgff"), s.a("027;fcgjfdegelfdedfceeghegdhejZfiBfeHd9fi4i2fedk%cdiOdidk e"), (Object) null, -1)).intValue();
        String a13 = s.a("025deAdcdjdkdidcdldkfidlel9fTdjdddi$cfEhc(ded ej(f_dj");
        String a14 = s.a("010AejQfi*el8fJdjdddiYcf");
        Class[] clsArr = new Class[i13];
        clsArr[i12] = cls;
        Object[] objArr = new Object[i13];
        objArr[i12] = s.a("008gZdk$cdi7didk)e");
        IBinder iBinder = (IBinder) a11.a(a13, (Object) null, a14, clsArr, objArr, null);
        if (obj2 == null || iBinder == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(s.a("033de0dcdjdkdidcdl$gQdk1cdi>didkOe2dleefedk cdiWdidkHe$hcVdedXejOfPdj"));
            if (i11 >= 31) {
                obtain.writeString(str2);
                obtain.writeTypedObject((Parcelable) obj2, i12);
                parcel2 = obtain2;
                parcel = obtain;
            } else {
                obtain.writeInt(i13);
                Class<?> cls2 = obj2.getClass();
                String a15 = s.a("013_fgdjdiMifWfcdkglCd)dj<cfg");
                Class[] clsArr2 = new Class[2];
                clsArr2[i12] = Parcel.class;
                clsArr2[i13] = Integer.TYPE;
                Object[] objArr2 = new Object[2];
                objArr2[i12] = obtain;
                objArr2[i13] = Integer.valueOf(i12);
                com.mob.tools.a.d dVar = a11;
                parcel2 = obtain2;
                parcel = obtain;
                try {
                    dVar.a((Class) cls2, obj2, a15, clsArr2, objArr2, null);
                } catch (Throwable th2) {
                    th = th2;
                    com.mob.tools.a.d.a(context).b(context2);
                    parcel2.recycle();
                    parcel.recycle();
                    throw th;
                }
            }
            parcel.writeString(context.getPackageName());
            if (i11 >= 30) {
                parcel.writeString(context.getAttributionTag());
            }
            iBinder.transact(intValue, parcel, parcel2, i12);
            parcel2.readException();
            Object readTypedObject = parcel2.readTypedObject(a());
            com.mob.tools.a.d.a(context).b(context2);
            parcel2.recycle();
            parcel.recycle();
            return readTypedObject;
        } catch (Throwable th3) {
            th = th3;
            parcel2 = obtain2;
            parcel = obtain;
            com.mob.tools.a.d.a(context).b(context2);
            parcel2.recycle();
            parcel.recycle();
            throw th;
        }
    }

    private static Parcelable.Creator<?> a() throws Throwable {
        return (Parcelable.Creator) ReflectHelper.getStaticField(ReflectHelper.importClass(s.a("025deBdcdjdkdidcdlPg:dk2cdi=didkRe;dlfedk_cdiRdidk$e")), s.a("007;edgjgifdfcghgj"));
    }

    public static Object a(Context context, String str, long j11) throws Throwable {
        int i11;
        String str2;
        Object obj;
        int i12;
        Parcel parcel;
        Parcel parcel2;
        char c11;
        Object obj2;
        Object obj3;
        Context context2 = context;
        String str3 = str;
        Class<String> cls = String.class;
        if (!d.e()) {
            return null;
        }
        if (!f.a().a(str3) || (i11 = Build.VERSION.SDK_INT) < 23) {
            return null;
        }
        com.mob.tools.a.d a11 = com.mob.tools.a.d.a(context);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Object[] objArr = new Object[1];
        if (i11 >= 31) {
            Object a12 = a11.a(s.a("032dePdcdjdkdidcdlDgHdkScdiJdidk9e2dlfedkQcdi6didk^e8gjBfGdedg3fEfi0i") + "$" + s.a("007Tfjdgdi3gDdc8fWdj"), new Class[]{Long.TYPE}, new Object[]{0L});
            if (a12 != null) {
                i12 = 0;
                str2 = "$";
                obj = a11.a(s.a("032de=dcdjdkdidcdl;g0dkRcdiXdidk3e6dlfedk9cdi4didk9e(gj'fIdedg$f6fi@i") + "$" + s.a("007)fjdgdiKg6dcBf^dj"), a12, s.a("005Uffdgdi7g_dc"), (Class[]) null, (Object[]) null, null);
            } else {
                i12 = 0;
                str2 = "$";
                obj = null;
            }
        } else {
            i12 = 0;
            str2 = "$";
            obj = a11.a(s.a("032deVdcdjdkdidcdlKg=dkUcdiGdidkTeIdlfedk+cdi+didk[e:gjYfCdedg7f?fiFi"), (Object) null, s.a("028c;dj'fdif,gcdjdkdffl)fj+djPfcdif*dcgldjdkdddidc@fEdj"), new Class[]{cls, Long.TYPE, Float.TYPE, Boolean.TYPE}, new Object[]{str3, 0, 0, Boolean.TRUE}, null);
        }
        Object obj4 = obj;
        String a13 = s.a("025de:dcdjdkdidcdldkfidlelNf@djdddiMcf2hc?dedOejYf3dj");
        String a14 = s.a("010<ej8fiUelHf$djdddi0cf");
        Class[] clsArr = new Class[1];
        clsArr[i12] = cls;
        Object[] objArr2 = new Object[1];
        objArr2[i12] = s.a("008gQdkQcdiUdidkUe");
        IBinder iBinder = (IBinder) a11.a(a13, (Object) null, a14, clsArr, objArr2, null);
        if (obj4 == null || iBinder == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(s.a("033deUdcdjdkdidcdlJg5dk>cdiXdidkYe$dleefedkScdiTdidkWe:hc$ded1ej8fFdj"));
            if (i11 >= 31) {
                obtain.writeString(str3);
                obtain.writeTypedObject((Parcelable) obj4, i12);
                AnonymousClass1 r02 = new Consumer() {
                    public void accept(Object obj) {
                        try {
                            objArr[0] = obj;
                        } catch (Throwable th2) {
                            countDownLatch.countDown();
                            throw th2;
                        }
                        countDownLatch.countDown();
                    }
                };
                StringBuilder sb2 = new StringBuilder(s.a("032deSdcdjdkdidcdl]g-dk^cdiUdidkEeVdlfedkYcdi5didk[e1hcNdedEej5f-dj"));
                String str4 = str2;
                sb2.append(str4);
                sb2.append(s.a("027-idMfi0eddgdjdj^fei4fedk4cdiZdidk<eDfcdj9de>fiRjSdkdjKi"));
                String sb3 = sb2.toString();
                Class[] clsArr2 = new Class[3];
                clsArr2[i12] = Executor.class;
                clsArr2[1] = Consumer.class;
                clsArr2[2] = CancellationSignal.class;
                Object[] objArr3 = new Object[3];
                objArr3[i12] = Executors.newSingleThreadExecutor();
                objArr3[1] = r02;
                objArr3[2] = null;
                Object a15 = a11.a(sb3, clsArr2, objArr3);
                Class cls2 = AppOpsManager.class;
                String a16 = s.a("012i@dkgj$fcfWdiddOf)djeedc");
                Class[] clsArr3 = new Class[1];
                clsArr3[i12] = Object.class;
                Object[] objArr4 = new Object[1];
                objArr4[i12] = r02;
                String str5 = str4;
                Parcel parcel3 = obtain2;
                Object[] objArr5 = objArr4;
                Parcel parcel4 = obtain;
                try {
                    String str6 = (String) a11.a(cls2, (Object) null, a16, clsArr3, objArr5, null);
                    if (!TextUtils.isEmpty(str6)) {
                        parcel4.writeStrongInterface((IInterface) a15);
                        parcel4.writeString(context.getPackageName());
                        parcel4.writeString(context.getAttributionTag());
                        parcel4.writeString(str6);
                        parcel2 = parcel3;
                        try {
                            iBinder.transact(((Integer) a11.a(s.a("033de<dcdjdkdidcdl>g@dk<cdiXdidkXeJdleefedkXcdiYdidk7eUhcBded(ejXfSdj") + str5 + s.a("004(elWi(dgff"), s.a("0305fcgjfdegelfdedfceeghegdhej3fiPeddgdjdj<fei,fedk'cdi_didkBe"), (Object) null, -1)).intValue(), parcel4, parcel2, 0);
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        parcel2 = parcel3;
                    }
                    parcel = parcel4;
                    c11 = 0;
                } catch (Throwable th3) {
                    th = th3;
                    parcel2 = parcel3;
                    parcel = parcel4;
                    parcel2.recycle();
                    parcel.recycle();
                    com.mob.tools.a.d.a(context).b(context2);
                    throw th;
                }
            } else {
                parcel2 = obtain2;
                String str7 = str2;
                try {
                    obtain.writeInt(1);
                    Parcel parcel5 = obtain;
                    try {
                        a11.a((Class) obj4.getClass(), obj4, s.a("013UfgdjdiKif4fcdkglKd6djTcfg"), new Class[]{Parcel.class, Integer.TYPE}, new Object[]{obtain, 0}, null);
                        HashMap hashMap = new HashMap();
                        final int identityHashCode = System.identityHashCode(hashMap);
                        hashMap.put(s.a("0177dk)eQfedk7cdi0didk%eCed-hde;ej'fKdc"), new ReflectHelper.a<Object[], Object>() {
                            public Object a(Object[] objArr) {
                                if (objArr != null) {
                                    try {
                                        if (objArr.length > 0) {
                                            NLog instance = MobLog.getInstance();
                                            instance.d("[212] oncge" + objArr[0], new Object[0]);
                                            if (!(objArr[0] instanceof List) || objArr[0].size() <= 0) {
                                                objArr[0] = objArr[0];
                                            } else {
                                                List list = objArr[0];
                                                objArr[0] = list.get(list.size() - 1);
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        countDownLatch.countDown();
                                        throw th2;
                                    }
                                }
                                countDownLatch.countDown();
                                return null;
                            }
                        });
                        hashMap.put("equals", new ReflectHelper.a<Object[], Object>() {
                            public Object a(Object[] objArr) {
                                if (objArr != null) {
                                    boolean z11 = false;
                                    if (objArr[0] != null) {
                                        if (objArr[0].hashCode() == identityHashCode) {
                                            z11 = true;
                                        }
                                        return Boolean.valueOf(z11);
                                    }
                                }
                                return Boolean.FALSE;
                            }
                        });
                        hashMap.put(s.a("008hd*fiShDeddkdc?f"), new ReflectHelper.a<Object[], Object>() {
                            public Object a(Object[] objArr) {
                                return Integer.valueOf(identityHashCode);
                            }
                        });
                        obj2 = ReflectHelper.createProxy((Map<String, ReflectHelper.a<Object[], Object>>) hashMap, (Class<?>[]) new Class[]{Class.forName(s.a("033deEdcdjdkdidcdlXgEdkWcdiLdidk9e(dlfedk?cdiKdidkKeTfedifi+ifef)dj"))});
                    } catch (Throwable th4) {
                        th = th4;
                        parcel = parcel5;
                        parcel2.recycle();
                        parcel.recycle();
                        com.mob.tools.a.d.a(context).b(context2);
                        throw th;
                    }
                    if (Build.VERSION.SDK_INT >= 30) {
                        obj3 = a11.a(s.a("032deGdcdjdkdidcdl]g5dkUcdiCdidk'eIdlfedkScdiLdidk$e;hcAded<ej(f%dj") + str7 + s.a("025Nfedk3cdiHdidk6e8fedifiZifef^djfcdj%deZfiEjJdkdjOi"), new Class[]{Class.forName(s.a("032de8dcdjdkdidcdl?gIdk_cdi%didkCe dlfedkJcdi6didk2e=hcVded2ej6f)dj")), Class.forName(s.a("033de?dcdjdkdidcdl@g!dk4cdi>didk@e<dlfedk=cdi+didkTe?fedifi@ifefIdj"))}, new Object[]{DH.SyncMtd.getSystemServiceSafe(s.a("008g9dk3cdi1didkUe")), obj2});
                        a11.a((Class) obj3.getClass(), obj3, s.a("008Ydj'f<ejdifi>if!dj"), new Class[]{Executor.class}, new Object[]{Executors.newSingleThreadExecutor()}, null);
                    } else {
                        obj3 = a11.a(s.a("032de8dcdjdkdidcdl4g6dk*cdi[didk7e1dlfedk(cdi(didk6eUhc]dedRej_f+dj") + str7 + s.a("017PfedifiOifef0djfcdj$deIfi)j>dkdjFi"), new Class[]{Class.forName(s.a("032de9dcdjdkdidcdl@gOdkUcdi0didk.eIdlfedk cdiLdidkVe=hc[dedKejEfHdj")), Class.forName(s.a("033de'dcdjdkdidcdlIg'dkYcdi*didk1eAdlfedk2cdi,didkBeVfedifi_ifef]dj")), Looper.class}, new Object[]{DH.SyncMtd.getSystemServiceSafe(s.a("008g3dk]cdi)didkLe")), obj2, l.a().c()});
                    }
                    parcel = parcel5;
                    try {
                        parcel.writeStrongBinder((IBinder) obj3);
                        parcel.writeInt(0);
                        parcel.writeString(context.getPackageName());
                        c11 = 0;
                        iBinder.transact(((Integer) a11.a(s.a("033deYdcdjdkdidcdl*g?dk1cdi3didk(eJdleefedk>cdiEdidkKe0hc!dedSej*fSdj") + str7 + s.a("0045el]i@dgff"), s.a("034Afcgjfdegelfdedfceeghegdhdj1fNdedgVf2fiPi6fedkLcdi<didkTeAek+jCdcBdifDfi"), (Object) null, -1)).intValue(), parcel, parcel2, 0);
                    } catch (Throwable th5) {
                        th = th5;
                        parcel2.recycle();
                        parcel.recycle();
                        com.mob.tools.a.d.a(context).b(context2);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    parcel = obtain;
                    parcel2.recycle();
                    parcel.recycle();
                    com.mob.tools.a.d.a(context).b(context2);
                    throw th;
                }
            }
            parcel2.readException();
            countDownLatch.await(j11, TimeUnit.MILLISECONDS);
            Object obj5 = objArr[c11];
            parcel2.recycle();
            parcel.recycle();
            com.mob.tools.a.d.a(context).b(context2);
            return obj5;
        } catch (Throwable th7) {
            th = th7;
            parcel2 = obtain2;
            parcel = obtain;
            parcel2.recycle();
            parcel.recycle();
            com.mob.tools.a.d.a(context).b(context2);
            throw th;
        }
    }
}
