package com.mob.tools.utils;

import android.text.TextUtils;
import com.mob.commons.s;
import com.mob.tools.utils.DH;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f28194a;

    /* renamed from: com.mob.tools.utils.g$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28195a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mob.tools.utils.g$a[] r0 = com.mob.tools.utils.g.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f28195a = r0
                com.mob.tools.utils.g$a r1 = com.mob.tools.utils.g.a.MIUI     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f28195a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mob.tools.utils.g$a r1 = com.mob.tools.utils.g.a.EMUI     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f28195a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mob.tools.utils.g$a r1 = com.mob.tools.utils.g.a.AMIGO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f28195a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mob.tools.utils.g$a r1 = com.mob.tools.utils.g.a.FLYME     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f28195a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mob.tools.utils.g$a r1 = com.mob.tools.utils.g.a.LENOVO     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f28195a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.mob.tools.utils.g$a r1 = com.mob.tools.utils.g.a.ONEUI     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f28195a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.mob.tools.utils.g$a r1 = com.mob.tools.utils.g.a.COLOR_OS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f28195a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.mob.tools.utils.g$a r1 = com.mob.tools.utils.g.a.FUNTOUCH_OS     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f28195a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.mob.tools.utils.g$a r1 = com.mob.tools.utils.g.a.EUI     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f28195a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.mob.tools.utils.g$a r1 = com.mob.tools.utils.g.a.SENSE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f28195a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.mob.tools.utils.g$a r1 = com.mob.tools.utils.g.a.GOOGLE     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f28195a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.mob.tools.utils.g$a r1 = com.mob.tools.utils.g.a.SMARTISAN     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f28195a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.mob.tools.utils.g$a r1 = com.mob.tools.utils.g.a.ONEPLUS     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f28195a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.mob.tools.utils.g$a r1 = com.mob.tools.utils.g.a.YUNOS     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f28195a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.mob.tools.utils.g$a r1 = com.mob.tools.utils.g.a.QIHOO     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f28195a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.mob.tools.utils.g$a r1 = com.mob.tools.utils.g.a.NUBIA     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f28195a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.mob.tools.utils.g$a r1 = com.mob.tools.utils.g.a.LGE     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.g.AnonymousClass1.<clinit>():void");
        }
    }

    public enum a {
        MIUI(s.a("006Feidi8dKdkdfdi")),
        EMUI(s.a("006hCdgPd5fg!f di")),
        FLYME(s.a("005]dfWfYdigddg")),
        ONEUI(s.a("007.fi9d4dffidgSe'ej")),
        COLOR_OS(s.a("004Mdk3jj8dk")),
        FUNTOUCH_OS(s.a("004Ydddidddk")),
        EUI(s.a("004gfi!dd")),
        SENSE(s.a("003hic")),
        GOOGLE(s.a("006;ejdkdkej+gf")),
        LENOVO(s.a("006gfe*dkdddk")),
        SMARTISAN(s.a("006ch;dgdigddi")),
        ONEPLUS(s.a("007^dk7efjg2dgfi")),
        YUNOS(s.a("0058ecdg:eEdkfi")),
        QIHOO(s.a("005Cdedi>h4dkdk")),
        NUBIA(s.a("005eDdgffdi)d")),
        LGE(s.a("002g-ej")),
        AMIGO(s.a("005@hgdi.eg5di")),
        OTHER("");
        

        /* renamed from: s  reason: collision with root package name */
        private String f28215s;

        private a(String str) {
            this.f28215s = str;
        }

        public String a() {
            return this.f28215s;
        }
    }

    private g() {
    }

    public static g a() {
        if (f28194a == null) {
            synchronized (g.class) {
                if (f28194a == null) {
                    f28194a = new g();
                }
            }
        }
        return f28194a;
    }

    private a c() {
        if (!TextUtils.isEmpty(a("ro.miui.ui.version.code")) || !TextUtils.isEmpty(a(s.a("0239djdkdldfdidgdidldgdidldd+fMdjfididk_eRdl!edUdfWf"))) || !TextUtils.isEmpty(a("ro.miui.internal.storage"))) {
            return a.MIUI;
        }
        if (!TextUtils.isEmpty(a(s.a("021VdjdkdlffdgdiHgVdcdlddTfHdjfididkFe.dl(fNdfdgdi"))) || !TextUtils.isEmpty(a("ro.build.hw_emui_api_level")) || !TextUtils.isEmpty(a("ro.confg.hw_systemversion"))) {
            return a.EMUI;
        }
        if (!TextUtils.isEmpty(a(s.a("026jfUdjfidifiViGdlfiecfidldgfi]f;dlef[g<ecdfVf$dldiYc6dk3e"))) || !TextUtils.isEmpty(a(s.a("0261djdkdldfTfCdigddgdlfi$fiQdg8jVfgdigdNdBdjdcdlef8g!ecdfDf"))) || !TextUtils.isEmpty(a(s.a("018'djdkdlef9gVecdf^fUdl8jGdgffZg0difiHhfSdc")))) {
            return a.FLYME;
        }
        if (!TextUtils.isEmpty(a(s.a("024cMdkdfdlfiMdZdffidgIe6ejdlfi4jf;ejdldcdifi6dWffZgf"))) || !TextUtils.isEmpty(a("init.svc.health-hal-2-1-samsung"))) {
            return a.ONEUI;
        }
        if (!TextUtils.isEmpty(a(s.a("024Vdjdkdlffdgdi_g(dcdlddOf_djfididk.eTdldk_jj;dkdjdkdf")))) {
            return a.COLOR_OS;
        }
        if (!TextUtils.isEmpty(a(s.a("027Pdjdkdldddidddkdldkfidlffdgdi4gOdcdldcdifi6jgd2ecdldidc"))) || !TextUtils.isEmpty(a(s.a("018-djdkdldddidddkdldkfidldd(fZdjfididkTe")))) {
            return a.FUNTOUCH_OS;
        }
        if (!TextUtils.isEmpty(a(s.a("023)djdkdlJgfiBdddldj?fgfd?fi4fXdldd_f_djfididkMe")))) {
            return a.EUI;
        }
        if (!TextUtils.isEmpty(a(s.a("022NdjdkdlffdgdiTg[dcdlfi]fe4fiIf+dlddUf]djfididk(e")))) {
            return a.SENSE;
        }
        if (s.a("014de[dcdjdkdidchkejdkdkej;gf").equals(a(s.a("026'djdkdl<cLdkdfdlejdkdkej9gfQdlHcgAdiDfeiGdidcff@dBfi;f")))) {
            return a.GOOGLE;
        }
        if (!TextUtils.isEmpty(a(s.a("020HdjdkdlfidfHdYdj.i*difiKde*dldd!fBdjfididk+e")))) {
            return a.SMARTISAN;
        }
        if (!TextUtils.isEmpty(a(s.a("014 djdkdldjdkdfdldd(f)djfididk=e")))) {
            return a.ONEPLUS;
        }
        if (!TextUtils.isEmpty(a(s.a("020RdjdkdlIcid0dlecdgGe)dkfidldd2f$djfididkTe")))) {
            return a.YUNOS;
        }
        if (!TextUtils.isEmpty(a(s.a("018%djdkdlffdgdi)g>dcdldgdidd fPdjfididkMe")))) {
            return a.QIHOO;
        }
        if (!TextUtils.isEmpty(a(s.a("023KdjdkdlffdgdiAg[dcdl]e)dgffdi?dRdldjdkdfdlMcBdkdcDf"))) || !TextUtils.isEmpty(a(s.a("015^djdkdlffdgdiUgMdcdldjdkdfdldidc")))) {
            return a.NUBIA;
        }
        if (!TextUtils.isEmpty(a(s.a("021$fiecfidlMg4ejVf?dl?gLejdfdcdfdhdd)f djfididk]e")))) {
            return a.LGE;
        }
        if (!TextUtils.isEmpty(a(s.a("019Jdjdkdlffdgdi(gUdcdldcdifiXjgd=ecdldidc"))) && a(s.a("019PdjdkdlffdgdiOgGdcdldcdifiTjgdRecdldidc")).matches("amigo([\\d.]+)[a-zA-Z]*")) {
            return a.AMIGO;
        }
        for (a aVar : a.values()) {
            if (aVar.a().equalsIgnoreCase(DH.SyncMtd.getManufacturer())) {
                return aVar;
            }
        }
        return a.OTHER;
    }

    public String b() {
        String str;
        switch (AnonymousClass1.f28195a[c().ordinal()]) {
            case 1:
                str = a(s.a("023Wdjdkdldfdidgdidldgdidldd.f?djfididk@e2dl*edKdf9f"));
                break;
            case 2:
                str = a(s.a("021Gdjdkdlffdgdi0g9dcdldd9f5djfididkLeUdl5fGdfdgdi"));
                break;
            case 3:
            case 4:
                str = a(s.a("019PdjdkdlffdgdiIg3dcdldcdifi.jgd7ecdldidc"));
                break;
            case 5:
            case 6:
                str = a(s.a("028NdjdkdlffdgdiAgRdcdlddGf3djfididkZe+dldiNecOdjUfLdf%feidg"));
                break;
            case 7:
                str = a(s.a("024+djdkdlffdgdiGg=dcdldd:fDdjfididk?eMdldk?jjXdkdjdkdf"));
                break;
            case 8:
                str = a(s.a("027Gdjdkdldddidddkdldkfidlffdgdi_gRdcdldcdifiDjgd>ecdldidc"));
                if (TextUtils.isEmpty(str)) {
                    str = a(s.a("018AdjdkdldddidddkdldkfidlddSf(djfididk.e"));
                    break;
                }
                break;
            case 9:
                str = a(s.a("023;djdkdlZgfiJdddldj5fgfd8fi,f[dldd)fPdjfididkZe"));
                break;
            case 10:
                str = a(s.a("022Ddjdkdlffdgdi0g]dcdlfi5fe@fi*fRdldd5f)djfididkJe"));
                break;
            case 11:
                str = a(s.a("024%djdkdlffdgdiDg1dcdldd>fBdjfididkTeMdldj;fgfdCfi$f"));
                break;
            case 12:
                str = a(s.a("020;djdkdlfidf,d-dj[iTdifi2de1dldd]fRdjfididk:e"));
                break;
            case 13:
                str = a(s.a("0145djdkdldjdkdfdldd f0djfididk]e"));
                break;
            case 14:
                str = a(s.a("020?djdkdlMcid$dlecdgCe.dkfidldd:f?djfididk@e"));
                break;
            case 15:
                str = a(s.a("018=djdkdlffdgdi<gRdcdldgdidd,fMdjfididkGe"));
                break;
            case 16:
                str = a(s.a("023Ddjdkdlffdgdi_gRdcdl e9dgffdiFdCdldjdkdfdlYcSdkdcLf"));
                if (TextUtils.isEmpty(str)) {
                    str = a(s.a("015)djdkdlffdgdi;g>dcdldjdkdfdldidc"));
                    break;
                }
                break;
            case 17:
                str = a(s.a("021,fiecfidl0gAej2fAdlZgYejdfdcdfdhddDf[djfididk3e"));
                break;
            default:
                str = a(s.a("019(djdkdlffdgdiZg=dcdldcdifi1jgdFecdldidc"));
                break;
        }
        return TextUtils.isEmpty(str) ? a(s.a("019,djdkdlffdgdiZg$dcdldcdifi3jgd^ecdldidc")) : str;
    }

    private String a(String str) {
        return DH.SyncMtd.getSystemProperties(str);
    }
}
