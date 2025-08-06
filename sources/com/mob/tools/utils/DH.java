package com.mob.tools.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.mob.MobSDK;
import com.mob.commons.s;
import com.mob.commons.v;
import com.mob.commons.z;
import com.mob.tools.MobLog;
import com.mob.tools.b.c;
import com.mob.tools.log.NLog;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DH {
    public static final int GPI_STRATEGY_VALIDITY_3_MINUTE = 180000;
    public static final int GPI_STRATEGY_VALIDITY_ALL = 0;

    public interface DHResponder {
        void onResponse(DHResponse dHResponse) throws Throwable;
    }

    public static class DHResponse {
        private String A;
        private LinkedList<Location> B = new LinkedList<>();
        private Object C;
        private ArrayList<HashMap<String, Object>> D;
        private String E;
        private HashMap<String, Object> F;
        private LinkedList<Boolean> G = new LinkedList<>();
        private HashMap<String, Object> H;
        private ArrayList<ArrayList<String>> I;
        private String J;
        private HashMap<String, HashMap<String, Long>> K;
        private HashMap<String, Long> L;
        private String M;
        private boolean N;
        private boolean O;
        private boolean P;
        private boolean Q;
        private boolean R;
        private boolean S;
        private boolean T;
        private boolean U;
        private String V;
        private String W;
        private String X;
        private String Y;
        private int Z;

        /* renamed from: a  reason: collision with root package name */
        private boolean f27979a;
        private String aA;
        private int aB;
        private int aC;
        private String aD;
        private int aE;
        private LinkedList<List> aF = new LinkedList<>();
        private HashMap<String, Object> aG;
        private LinkedList<HashMap<String, Object>> aH = new LinkedList<>();
        private ArrayList<HashMap<String, Object>> aI;
        private String aJ;
        private LinkedList<String> aK = new LinkedList<>();
        private String aL;
        private LinkedList<String> aM = new LinkedList<>();
        private boolean aN;
        private ArrayList<HashMap<String, Object>> aO;
        private LinkedList<Object> aP = new LinkedList<>();
        private LinkedList<Object> aQ = new LinkedList<>();
        private LinkedList<Object> aR = new LinkedList<>();
        private boolean aS;
        private ArrayList<HashMap<String, Object>> aT;
        private String aU;
        private LinkedList<Long> aV = new LinkedList<>();

        /* renamed from: aa  reason: collision with root package name */
        private LinkedList<List<ResolveInfo>> f27980aa = new LinkedList<>();

        /* renamed from: ab  reason: collision with root package name */
        private LinkedList<ResolveInfo> f27981ab = new LinkedList<>();

        /* renamed from: ac  reason: collision with root package name */
        private LinkedList<PackageInfo> f27982ac = new LinkedList<>();

        /* renamed from: ad  reason: collision with root package name */
        private LinkedList<PackageInfo> f27983ad = new LinkedList<>();

        /* renamed from: ae  reason: collision with root package name */
        private LinkedList<PackageInfo> f27984ae = new LinkedList<>();

        /* renamed from: af  reason: collision with root package name */
        private String f27985af;

        /* renamed from: ag  reason: collision with root package name */
        private String f27986ag;

        /* renamed from: ah  reason: collision with root package name */
        private String f27987ah;

        /* renamed from: ai  reason: collision with root package name */
        private long f27988ai;

        /* renamed from: aj  reason: collision with root package name */
        private String f27989aj;

        /* renamed from: ak  reason: collision with root package name */
        private String f27990ak;

        /* renamed from: al  reason: collision with root package name */
        private String f27991al;

        /* renamed from: am  reason: collision with root package name */
        private String f27992am;

        /* renamed from: an  reason: collision with root package name */
        private String f27993an;

        /* renamed from: ao  reason: collision with root package name */
        private HashMap<String, Object> f27994ao;

        /* renamed from: ap  reason: collision with root package name */
        private ApplicationInfo f27995ap;

        /* renamed from: aq  reason: collision with root package name */
        private LinkedList<ApplicationInfo> f27996aq = new LinkedList<>();

        /* renamed from: ar  reason: collision with root package name */
        private LinkedList<ApplicationInfo> f27997ar = new LinkedList<>();

        /* renamed from: as  reason: collision with root package name */
        private String f27998as;

        /* renamed from: at  reason: collision with root package name */
        private String f27999at;

        /* renamed from: au  reason: collision with root package name */
        private String f28000au;

        /* renamed from: av  reason: collision with root package name */
        private long f28001av;

        /* renamed from: aw  reason: collision with root package name */
        private double f28002aw;

        /* renamed from: ax  reason: collision with root package name */
        private int f28003ax;

        /* renamed from: ay  reason: collision with root package name */
        private boolean f28004ay;

        /* renamed from: az  reason: collision with root package name */
        private String f28005az;

        /* renamed from: b  reason: collision with root package name */
        private String f28006b;

        /* renamed from: c  reason: collision with root package name */
        private LinkedList<String> f28007c = new LinkedList<>();

        /* renamed from: d  reason: collision with root package name */
        private String f28008d;

        /* renamed from: e  reason: collision with root package name */
        private LinkedList<String> f28009e = new LinkedList<>();

        /* renamed from: f  reason: collision with root package name */
        private LinkedList<String> f28010f = new LinkedList<>();

        /* renamed from: g  reason: collision with root package name */
        private String f28011g;

        /* renamed from: h  reason: collision with root package name */
        private String f28012h;

        /* renamed from: i  reason: collision with root package name */
        private LinkedList<String> f28013i = new LinkedList<>();

        /* renamed from: j  reason: collision with root package name */
        private String f28014j;

        /* renamed from: k  reason: collision with root package name */
        private LinkedList<String> f28015k = new LinkedList<>();

        /* renamed from: l  reason: collision with root package name */
        private String f28016l;

        /* renamed from: m  reason: collision with root package name */
        private LinkedList<String> f28017m = new LinkedList<>();

        /* renamed from: n  reason: collision with root package name */
        private String f28018n;

        /* renamed from: o  reason: collision with root package name */
        private String f28019o;

        /* renamed from: p  reason: collision with root package name */
        private LinkedList<String> f28020p = new LinkedList<>();

        /* renamed from: q  reason: collision with root package name */
        private boolean f28021q;

        /* renamed from: r  reason: collision with root package name */
        private String f28022r;

        /* renamed from: s  reason: collision with root package name */
        private String f28023s;

        /* renamed from: t  reason: collision with root package name */
        private String f28024t;

        /* renamed from: u  reason: collision with root package name */
        private LinkedList<String> f28025u = new LinkedList<>();

        /* renamed from: v  reason: collision with root package name */
        private String f28026v;

        /* renamed from: w  reason: collision with root package name */
        private LinkedList<String> f28027w = new LinkedList<>();

        /* renamed from: x  reason: collision with root package name */
        private LinkedList<ArrayList<HashMap<String, String>>> f28028x = new LinkedList<>();

        /* renamed from: y  reason: collision with root package name */
        private LinkedList<ArrayList<HashMap<String, String>>> f28029y = new LinkedList<>();

        /* renamed from: z  reason: collision with root package name */
        private ArrayList<HashMap<String, String>> f28030z;

        public void a(String str, Object obj) throws Throwable {
            a(str, obj, false);
        }

        public boolean checkDebbing() {
            return this.aS;
        }

        public boolean checkNetworkAvailable() {
            return this.f28021q;
        }

        public boolean checkPad() {
            return this.O;
        }

        public boolean checkUA() {
            return this.R;
        }

        public boolean cx() {
            return this.N;
        }

        public boolean debugable() {
            return this.T;
        }

        public boolean devEnable() {
            return this.Q;
        }

        public ArrayList<HashMap<String, Object>> getACIfo() {
            return this.aT;
        }

        public ApplicationInfo getAInfo() {
            return this.f27995ap;
        }

        public ApplicationInfo getAInfoForPkg(int... iArr) {
            return (ApplicationInfo) a(this.f27996aq, (Object) null, iArr);
        }

        public ApplicationInfo getAInfoForPkgForce(int... iArr) {
            return (ApplicationInfo) a(this.f27997ar, (Object) null, iArr);
        }

        public HashMap<String, Object> getALLD() {
            return this.f27994ao;
        }

        public String getAdvertisingID() {
            return this.A;
        }

        public long getAppLastUpdateTime() {
            return this.f27988ai;
        }

        public String getAppName() {
            return this.f28026v;
        }

        public String getAppNameForPkg(int... iArr) {
            return (String) a(this.f28027w, (Object) null, iArr);
        }

        public String getBaseband() {
            return this.W;
        }

        public long getBdT() {
            return this.f28001av;
        }

        public String getBoardFromSysProperty() {
            return this.X;
        }

        public String getBoardPlatform() {
            return this.Y;
        }

        public String getBssid() {
            return this.f28008d;
        }

        public String getBssidForce(int... iArr) {
            return (String) a(this.f28009e, (Object) null, iArr);
        }

        public String getBtM() {
            return this.f27999at;
        }

        public String getCInfo() {
            return this.f27991al;
        }

        public Object getCLoc() {
            return this.C;
        }

        public HashMap<String, Object> getCPUInfo() {
            return this.H;
        }

        public String getCarrier() {
            return this.f28012h;
        }

        public String getCarrierForce(int... iArr) {
            return (String) a(this.f28013i, "-1", iArr);
        }

        public String getCarrierName() {
            return this.f28014j;
        }

        public String getCarrierNameForce(int... iArr) {
            return (String) a(this.f28015k, (Object) null, iArr);
        }

        public String getCgroup() {
            return this.f27990ak;
        }

        public HashMap<String, Object> getCurrentWifiInfo() {
            return this.F;
        }

        public String getDM() {
            return this.aU;
        }

        public int getDataNtType() {
            return this.Z;
        }

        public String getDetailNetworkTypeForStatic() {
            return this.f28023s;
        }

        public String getDeviceData() {
            return this.f27986ag;
        }

        public String getDeviceDataNotAES() {
            return this.f27987ah;
        }

        public String getDeviceId() {
            return null;
        }

        public String getDeviceKey() {
            return this.f28024t;
        }

        public String getDeviceKeyFromCache(int... iArr) {
            return (String) a(this.f28025u, (Object) null, iArr);
        }

        public String getDeviceName() {
            return this.f27989aj;
        }

        public String getDeviceType() {
            return this.E;
        }

        public String getDrID() {
            return this.f27998as;
        }

        public String getFlavor() {
            return this.V;
        }

        public int getGrammaticalGender() {
            return this.aE;
        }

        public int getHmEPMState() {
            return this.aC;
        }

        public String getHmOsDetailedVer() {
            return this.aA;
        }

        public String getHmOsVer() {
            return this.f28005az;
        }

        public int getHmPMState() {
            return this.aB;
        }

        public ArrayList<HashMap<String, String>> getIA(int... iArr) {
            return (ArrayList) a(this.f28028x, new ArrayList(), iArr);
        }

        public ArrayList<HashMap<String, String>> getIAForce(int... iArr) {
            return (ArrayList) a(this.f28029y, new ArrayList(), iArr);
        }

        public String getIMEI() {
            return null;
        }

        public String getIMSI() {
            return null;
        }

        public String getIPAddress() {
            return this.f27985af;
        }

        public String getInnerAppLanguage() {
            return this.aD;
        }

        public long getLATime(int... iArr) {
            return ((Long) a(this.aV, -1L, iArr)).longValue();
        }

        public Location getLocation(int... iArr) {
            return (Location) a(this.B, (Object) null, iArr);
        }

        public String getMIUIVersion() {
            return this.M;
        }

        public String getMbcdi() {
            return this.aL;
        }

        public String getMbcdiForce(int... iArr) {
            return (String) a(this.aM, (Object) null, iArr);
        }

        public String getMcdi() {
            return this.aJ;
        }

        public String getMcdiForce(int... iArr) {
            return (String) a(this.aK, (Object) null, iArr);
        }

        public HashMap<String, Long> getMemoryInfo() {
            return this.L;
        }

        public ArrayList<HashMap<String, Object>> getMnbclfo() {
            return this.aO;
        }

        public Object getMpfo(int... iArr) {
            return a(this.aP, (Object) null, iArr);
        }

        public Object getMpfof(int... iArr) {
            return a(this.aQ, (Object) null, iArr);
        }

        public Object getMpfos(int... iArr) {
            return a(this.aR, (Object) null, iArr);
        }

        public HashMap<String, Object> getMwfo() {
            return this.aG;
        }

        public HashMap<String, Object> getMwfoForce(int... iArr) {
            return (HashMap) a(this.aH, (Object) null, iArr);
        }

        public ArrayList<HashMap<String, Object>> getMwlfo() {
            return this.aI;
        }

        public ArrayList<HashMap<String, Object>> getNeighboringCellInfo() {
            return this.D;
        }

        public String getNetworkType() {
            return this.f28018n;
        }

        public String getNetworkTypeForStatic() {
            return this.f28022r;
        }

        public String getNetworkTypeForce(int... iArr) {
            return (String) a(this.f28020p, s.a("004eAdk>ef"), iArr);
        }

        public String getNetworkTypeNew() {
            return this.f28019o;
        }

        public String getOD() {
            return this.f27992am;
        }

        public String getODH() {
            return this.f27993an;
        }

        public PackageInfo getPInfo(int... iArr) {
            return (PackageInfo) a(this.f27982ac, (Object) null, iArr);
        }

        public PackageInfo getPInfoForce(int... iArr) {
            return (PackageInfo) a(this.f27983ad, (Object) null, iArr);
        }

        public PackageInfo getPInfoStrategy(int... iArr) {
            return (PackageInfo) a(this.f27984ae, (Object) null, iArr);
        }

        public List getPosCommForce(int... iArr) {
            return (List) a(this.aF, (Object) null, iArr);
        }

        public String getQemuKernel() {
            return this.J;
        }

        public ArrayList<HashMap<String, String>> getSA() {
            return this.f28030z;
        }

        public String getSSID() {
            return this.f28006b;
        }

        public String getSSIDForce(int... iArr) {
            return (String) a(this.f28007c, (Object) null, iArr);
        }

        public double getScreenInch() {
            return this.f28002aw;
        }

        public int getScreenPpi() {
            return this.f28003ax;
        }

        public String getScreenSize() {
            return this.f28011g;
        }

        public boolean getSdcardState() {
            return false;
        }

        public String getSerialno() {
            return null;
        }

        public String getSignMD5() {
            return this.f28016l;
        }

        public String getSignMD5ForPkg(int... iArr) {
            return (String) a(this.f28017m, (Object) null, iArr);
        }

        public String getSimSerialNumber() {
            return null;
        }

        public HashMap<String, HashMap<String, Long>> getSizeInfo() {
            return this.K;
        }

        public String getSystemProperties(int... iArr) {
            return (String) a(this.f28010f, (Object) null, iArr);
        }

        public ArrayList<ArrayList<String>> getTTYDriversInfo() {
            return this.I;
        }

        public Activity getTopActivity() {
            return null;
        }

        public String getUpM() {
            return this.f28000au;
        }

        public boolean isHmOs() {
            return this.f28004ay;
        }

        public boolean isMwpy() {
            return this.aN;
        }

        public boolean isPackageInstalled(int... iArr) {
            return ((Boolean) a(this.G, Boolean.FALSE, iArr)).booleanValue();
        }

        public boolean isRooted() {
            return this.f27979a;
        }

        public boolean isWifiProxy() {
            return this.U;
        }

        public String[] queryIMEI() {
            return null;
        }

        public String[] queryIMSI() {
            return null;
        }

        public List<ResolveInfo> queryIntentServices(int... iArr) {
            return (List) a(this.f27980aa, (Object) null, iArr);
        }

        public ResolveInfo resolveActivity(int... iArr) {
            return (ResolveInfo) a(this.f27981ab, (Object) null, iArr);
        }

        public boolean usbEnable() {
            return this.P;
        }

        public boolean vpn() {
            return this.S;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: int} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v35, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v38, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v41, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: int} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v44, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v47, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v50, resolved type: android.content.pm.ApplicationInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v56, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v59, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v62, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v65, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v68, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v71, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v74, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v77, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v80, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v83, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v86, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v89, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v92, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: int} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v95, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v98, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v101, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v104, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v25, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v107, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v116, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v29, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v128, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v134, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v137, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v143, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v146, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v149, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v152, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v155, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v158, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v161, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v164, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v31, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v167, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v170, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v173, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v176, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v179, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v182, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v185, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v188, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v191, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v194, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v197, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v200, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v203, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v206, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v209, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v33, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v35, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v36, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v37, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v38, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v39, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v40, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v41, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v42, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v43, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v44, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v45, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v46, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v47, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v48, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v49, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v50, resolved type: boolean} */
        /* JADX WARNING: type inference failed for: r1v0 */
        /* JADX WARNING: type inference failed for: r1v5, types: [java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>>] */
        /* JADX WARNING: type inference failed for: r1v8, types: [java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>>] */
        /* JADX WARNING: type inference failed for: r1v23, types: [java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>>] */
        /* JADX WARNING: type inference failed for: r1v29, types: [java.util.HashMap<java.lang.String, java.lang.Object>] */
        /* JADX WARNING: type inference failed for: r1v53, types: [java.util.HashMap<java.lang.String, java.lang.Object>] */
        /* JADX WARNING: type inference failed for: r1v110, types: [java.util.HashMap<java.lang.String, java.lang.Long>] */
        /* JADX WARNING: type inference failed for: r1v113, types: [java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.Long>>] */
        /* JADX WARNING: type inference failed for: r1v119, types: [java.util.ArrayList<java.util.ArrayList<java.lang.String>>] */
        /* JADX WARNING: type inference failed for: r1v122, types: [java.util.HashMap<java.lang.String, java.lang.Object>] */
        /* JADX WARNING: type inference failed for: r1v125, types: [java.util.HashMap<java.lang.String, java.lang.Object>] */
        /* JADX WARNING: type inference failed for: r1v131, types: [java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>>] */
        /* JADX WARNING: type inference failed for: r1v140, types: [java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>>] */
        /* JADX WARNING: type inference failed for: r1v212 */
        /* JADX WARNING: type inference failed for: r1v213 */
        /* JADX WARNING: type inference failed for: r1v214 */
        /* JADX WARNING: type inference failed for: r1v215 */
        /* JADX WARNING: type inference failed for: r1v216 */
        /* JADX WARNING: type inference failed for: r1v217 */
        /* JADX WARNING: type inference failed for: r1v218 */
        /* JADX WARNING: type inference failed for: r1v219 */
        /* JADX WARNING: type inference failed for: r1v220 */
        /* JADX WARNING: type inference failed for: r1v221 */
        /* JADX WARNING: type inference failed for: r1v222 */
        /* JADX WARNING: type inference failed for: r1v223 */
        /* JADX WARNING: type inference failed for: r1v224 */
        /* JADX WARNING: type inference failed for: r1v225 */
        /* JADX WARNING: type inference failed for: r1v226 */
        /* JADX WARNING: type inference failed for: r1v227 */
        /* JADX WARNING: type inference failed for: r1v228 */
        /* JADX WARNING: type inference failed for: r1v229 */
        /* JADX WARNING: type inference failed for: r1v230 */
        /* JADX WARNING: type inference failed for: r1v231 */
        /* JADX WARNING: type inference failed for: r1v232 */
        /* JADX WARNING: type inference failed for: r1v233 */
        /* JADX WARNING: type inference failed for: r1v234 */
        /* JADX WARNING: type inference failed for: r1v235 */
        /* JADX WARNING: type inference failed for: r1v236 */
        /* JADX WARNING: type inference failed for: r1v237 */
        /* JADX WARNING: type inference failed for: r1v238 */
        /* JADX WARNING: type inference failed for: r1v239 */
        /* JADX WARNING: type inference failed for: r1v240 */
        /* JADX WARNING: type inference failed for: r1v241 */
        /* JADX WARNING: type inference failed for: r1v242 */
        /* JADX WARNING: type inference failed for: r1v243 */
        /* JADX WARNING: type inference failed for: r1v244 */
        /* JADX WARNING: type inference failed for: r1v245 */
        /* JADX WARNING: type inference failed for: r1v246 */
        /* JADX WARNING: type inference failed for: r1v247 */
        /* JADX WARNING: type inference failed for: r1v248 */
        /* JADX WARNING: type inference failed for: r1v249 */
        /* JADX WARNING: type inference failed for: r1v250 */
        /* JADX WARNING: type inference failed for: r1v251 */
        /* JADX WARNING: type inference failed for: r1v252 */
        /* JADX WARNING: type inference failed for: r1v253 */
        /* JADX WARNING: type inference failed for: r1v254 */
        /* JADX WARNING: type inference failed for: r1v255 */
        /* JADX WARNING: type inference failed for: r1v256 */
        /* JADX WARNING: type inference failed for: r1v257 */
        /* JADX WARNING: type inference failed for: r1v258 */
        /* JADX WARNING: type inference failed for: r1v259 */
        /* JADX WARNING: type inference failed for: r1v260 */
        /* JADX WARNING: type inference failed for: r1v261 */
        /* JADX WARNING: type inference failed for: r1v262 */
        /* JADX WARNING: type inference failed for: r1v263 */
        /* JADX WARNING: type inference failed for: r1v264 */
        /* JADX WARNING: type inference failed for: r1v265 */
        /* JADX WARNING: type inference failed for: r1v266 */
        /* JADX WARNING: type inference failed for: r1v267 */
        /* JADX WARNING: type inference failed for: r1v268 */
        /* JADX WARNING: type inference failed for: r1v269 */
        /* JADX WARNING: type inference failed for: r1v270 */
        /* JADX WARNING: type inference failed for: r1v271 */
        /* JADX WARNING: type inference failed for: r1v272 */
        /* JADX WARNING: type inference failed for: r1v273 */
        /* JADX WARNING: type inference failed for: r1v274 */
        /* JADX WARNING: type inference failed for: r1v275 */
        /* JADX WARNING: type inference failed for: r1v276 */
        /* JADX WARNING: type inference failed for: r1v277 */
        /* JADX WARNING: type inference failed for: r1v278 */
        /* JADX WARNING: type inference failed for: r1v279 */
        /* JADX WARNING: type inference failed for: r1v280 */
        /* JADX WARNING: type inference failed for: r1v281 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(java.lang.String r6, java.lang.Object r7, boolean r8) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.String r0 = "gmpfo"
                boolean r0 = r0.equals(r6)
                r1 = 0
                if (r0 == 0) goto L_0x0013
                java.util.LinkedList<java.lang.Object> r6 = r5.aP
                if (r8 == 0) goto L_0x000e
                r7 = r1
            L_0x000e:
                r6.add(r7)
                goto L_0x076c
            L_0x0013:
                java.lang.String r0 = "gmpfofce"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0025
                java.util.LinkedList<java.lang.Object> r6 = r5.aQ
                if (r8 == 0) goto L_0x0020
                r7 = r1
            L_0x0020:
                r6.add(r7)
                goto L_0x076c
            L_0x0025:
                java.lang.String r0 = "getMpfos"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0037
                java.util.LinkedList<java.lang.Object> r6 = r5.aR
                if (r8 == 0) goto L_0x0032
                r7 = r1
            L_0x0032:
                r6.add(r7)
                goto L_0x076c
            L_0x0037:
                java.lang.String r0 = "cird"
                boolean r0 = r0.equals(r6)
                r2 = 0
                if (r0 == 0) goto L_0x004d
                if (r8 == 0) goto L_0x0043
                goto L_0x0049
            L_0x0043:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r2 = r7.booleanValue()
            L_0x0049:
                r5.f27979a = r2
                goto L_0x076c
            L_0x004d:
                java.lang.String r0 = "gsimt"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x005f
                if (r8 == 0) goto L_0x0058
                goto L_0x005b
            L_0x0058:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x005b:
                r5.f28006b = r1
                goto L_0x076c
            L_0x005f:
                java.lang.String r0 = "gsimtfce"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0074
                java.util.LinkedList<java.lang.String> r6 = r5.f28007c
                if (r8 == 0) goto L_0x006c
                goto L_0x006f
            L_0x006c:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x006f:
                r6.add(r1)
                goto L_0x076c
            L_0x0074:
                java.lang.String r0 = "gbsi"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0086
                if (r8 == 0) goto L_0x007f
                goto L_0x0082
            L_0x007f:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x0082:
                r5.f28008d = r1
                goto L_0x076c
            L_0x0086:
                java.lang.String r0 = "gbsifce"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x009b
                java.util.LinkedList<java.lang.String> r6 = r5.f28009e
                if (r8 == 0) goto L_0x0093
                goto L_0x0096
            L_0x0093:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x0096:
                r6.add(r1)
                goto L_0x076c
            L_0x009b:
                java.lang.String r0 = "gstmpts"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x00b0
                java.util.LinkedList<java.lang.String> r6 = r5.f28010f
                if (r8 == 0) goto L_0x00a8
                goto L_0x00ab
            L_0x00a8:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x00ab:
                r6.add(r1)
                goto L_0x076c
            L_0x00b0:
                java.lang.String r0 = "gscsz"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x00c2
                if (r8 == 0) goto L_0x00bb
                goto L_0x00be
            L_0x00bb:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x00be:
                r5.f28011g = r1
                goto L_0x076c
            L_0x00c2:
                java.lang.String r0 = "gcrie"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x00d4
                if (r8 == 0) goto L_0x00cd
                goto L_0x00d0
            L_0x00cd:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x00d0:
                r5.f28012h = r1
                goto L_0x076c
            L_0x00d4:
                java.lang.String r0 = "gcriefce"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x00e9
                java.util.LinkedList<java.lang.String> r6 = r5.f28013i
                if (r8 == 0) goto L_0x00e1
                goto L_0x00e4
            L_0x00e1:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x00e4:
                r6.add(r1)
                goto L_0x076c
            L_0x00e9:
                java.lang.String r0 = "gcrnm"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x00fb
                if (r8 == 0) goto L_0x00f4
                goto L_0x00f7
            L_0x00f4:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x00f7:
                r5.f28014j = r1
                goto L_0x076c
            L_0x00fb:
                java.lang.String r0 = "gcrnmfce"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0110
                java.util.LinkedList<java.lang.String> r6 = r5.f28015k
                if (r8 == 0) goto L_0x0108
                goto L_0x010b
            L_0x0108:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x010b:
                r6.add(r1)
                goto L_0x076c
            L_0x0110:
                java.lang.String r0 = "gsnmd"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0122
                if (r8 == 0) goto L_0x011b
                goto L_0x011e
            L_0x011b:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x011e:
                r5.f28016l = r1
                goto L_0x076c
            L_0x0122:
                java.lang.String r0 = "gsnmdfp"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0137
                java.util.LinkedList<java.lang.String> r6 = r5.f28017m
                if (r8 == 0) goto L_0x012f
                goto L_0x0132
            L_0x012f:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x0132:
                r6.add(r1)
                goto L_0x076c
            L_0x0137:
                java.lang.String r0 = "gneyp"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0149
                if (r8 == 0) goto L_0x0142
                goto L_0x0145
            L_0x0142:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x0145:
                r5.f28018n = r1
                goto L_0x076c
            L_0x0149:
                java.lang.String r0 = "gneypnw"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x015b
                if (r8 == 0) goto L_0x0154
                goto L_0x0157
            L_0x0154:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x0157:
                r5.f28019o = r1
                goto L_0x076c
            L_0x015b:
                java.lang.String r0 = "gneypfce"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0170
                java.util.LinkedList<java.lang.String> r6 = r5.f28020p
                if (r8 == 0) goto L_0x0168
                goto L_0x016b
            L_0x0168:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x016b:
                r6.add(r1)
                goto L_0x076c
            L_0x0170:
                java.lang.String r0 = "cknavbl"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0185
                if (r8 == 0) goto L_0x017b
                goto L_0x0181
            L_0x017b:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r2 = r7.booleanValue()
            L_0x0181:
                r5.f28021q = r2
                goto L_0x076c
            L_0x0185:
                java.lang.String r0 = "gnktpfs"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0197
                if (r8 == 0) goto L_0x0190
                goto L_0x0193
            L_0x0190:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x0193:
                r5.f28022r = r1
                goto L_0x076c
            L_0x0197:
                java.lang.String r0 = "gdtlnktpfs"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x01a9
                if (r8 == 0) goto L_0x01a2
                goto L_0x01a5
            L_0x01a2:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x01a5:
                r5.f28023s = r1
                goto L_0x076c
            L_0x01a9:
                java.lang.String r0 = "gdvk"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x01bb
                if (r8 == 0) goto L_0x01b4
                goto L_0x01b7
            L_0x01b4:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x01b7:
                r5.f28024t = r1
                goto L_0x076c
            L_0x01bb:
                java.lang.String r0 = "gdvkfc"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x01d0
                java.util.LinkedList<java.lang.String> r6 = r5.f28025u
                if (r8 == 0) goto L_0x01c8
                goto L_0x01cb
            L_0x01c8:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x01cb:
                r6.add(r1)
                goto L_0x076c
            L_0x01d0:
                java.lang.String r0 = "gpnmmt"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x01e2
                if (r8 == 0) goto L_0x01db
                goto L_0x01de
            L_0x01db:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x01de:
                r5.f28026v = r1
                goto L_0x076c
            L_0x01e2:
                java.lang.String r0 = "gpnmfp"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x01f7
                java.util.LinkedList<java.lang.String> r6 = r5.f28027w
                if (r8 == 0) goto L_0x01ef
                goto L_0x01f2
            L_0x01ef:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x01f2:
                r6.add(r1)
                goto L_0x076c
            L_0x01f7:
                java.lang.String r0 = "gia"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x020c
                java.util.LinkedList<java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>>> r6 = r5.f28028x
                if (r8 == 0) goto L_0x0204
                goto L_0x0207
            L_0x0204:
                r1 = r7
                java.util.ArrayList r1 = (java.util.ArrayList) r1
            L_0x0207:
                r6.add(r1)
                goto L_0x076c
            L_0x020c:
                java.lang.String r0 = "giafce"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0221
                java.util.LinkedList<java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>>> r6 = r5.f28029y
                if (r8 == 0) goto L_0x0219
                goto L_0x021c
            L_0x0219:
                r1 = r7
                java.util.ArrayList r1 = (java.util.ArrayList) r1
            L_0x021c:
                r6.add(r1)
                goto L_0x076c
            L_0x0221:
                java.lang.String r0 = "gsl"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0233
                if (r8 == 0) goto L_0x022c
                goto L_0x022f
            L_0x022c:
                r1 = r7
                java.util.ArrayList r1 = (java.util.ArrayList) r1
            L_0x022f:
                r5.f28030z = r1
                goto L_0x076c
            L_0x0233:
                java.lang.String r0 = "gavti"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0245
                if (r8 == 0) goto L_0x023e
                goto L_0x0241
            L_0x023e:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x0241:
                r5.A = r1
                goto L_0x076c
            L_0x0245:
                java.lang.String r0 = "glctn"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x025a
                java.util.LinkedList<android.location.Location> r6 = r5.B
                if (r8 == 0) goto L_0x0252
                goto L_0x0255
            L_0x0252:
                r1 = r7
                android.location.Location r1 = (android.location.Location) r1
            L_0x0255:
                r6.add(r1)
                goto L_0x076c
            L_0x025a:
                java.lang.String r0 = "gtecloc"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0269
                if (r8 == 0) goto L_0x0265
                r7 = r1
            L_0x0265:
                r5.C = r7
                goto L_0x076c
            L_0x0269:
                java.lang.String r0 = "gnbclin"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x027b
                if (r8 == 0) goto L_0x0274
                goto L_0x0277
            L_0x0274:
                r1 = r7
                java.util.ArrayList r1 = (java.util.ArrayList) r1
            L_0x0277:
                r5.D = r1
                goto L_0x076c
            L_0x027b:
                java.lang.String r0 = "gdvtp"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x028d
                if (r8 == 0) goto L_0x0286
                goto L_0x0289
            L_0x0286:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x0289:
                r5.E = r1
                goto L_0x076c
            L_0x028d:
                java.lang.String r0 = "wmcwi"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x029f
                if (r8 == 0) goto L_0x0298
                goto L_0x029b
            L_0x0298:
                r1 = r7
                java.util.HashMap r1 = (java.util.HashMap) r1
            L_0x029b:
                r5.F = r1
                goto L_0x076c
            L_0x029f:
                java.lang.String r0 = "ipgist"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x02bb
                java.util.LinkedList<java.lang.Boolean> r6 = r5.G
                if (r8 == 0) goto L_0x02ac
                goto L_0x02b2
            L_0x02ac:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r2 = r7.booleanValue()
            L_0x02b2:
                java.lang.Boolean r7 = java.lang.Boolean.valueOf(r2)
                r6.add(r7)
                goto L_0x076c
            L_0x02bb:
                java.lang.String r0 = "gcuin"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x02cd
                if (r8 == 0) goto L_0x02c6
                goto L_0x02c9
            L_0x02c6:
                r1 = r7
                java.util.HashMap r1 = (java.util.HashMap) r1
            L_0x02c9:
                r5.H = r1
                goto L_0x076c
            L_0x02cd:
                java.lang.String r0 = "gtydvin"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x02df
                if (r8 == 0) goto L_0x02d8
                goto L_0x02db
            L_0x02d8:
                r1 = r7
                java.util.ArrayList r1 = (java.util.ArrayList) r1
            L_0x02db:
                r5.I = r1
                goto L_0x076c
            L_0x02df:
                java.lang.String r0 = "gqmkn"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x02f1
                if (r8 == 0) goto L_0x02ea
                goto L_0x02ed
            L_0x02ea:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x02ed:
                r5.J = r1
                goto L_0x076c
            L_0x02f1:
                java.lang.String r0 = "gszin"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0303
                if (r8 == 0) goto L_0x02fc
                goto L_0x02ff
            L_0x02fc:
                r1 = r7
                java.util.HashMap r1 = (java.util.HashMap) r1
            L_0x02ff:
                r5.K = r1
                goto L_0x076c
            L_0x0303:
                java.lang.String r0 = "gmrin"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0315
                if (r8 == 0) goto L_0x030e
                goto L_0x0311
            L_0x030e:
                r1 = r7
                java.util.HashMap r1 = (java.util.HashMap) r1
            L_0x0311:
                r5.L = r1
                goto L_0x076c
            L_0x0315:
                java.lang.String r0 = "gmivsn"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0327
                if (r8 == 0) goto L_0x0320
                goto L_0x0323
            L_0x0320:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x0323:
                r5.M = r1
                goto L_0x076c
            L_0x0327:
                java.lang.String r0 = "cx"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x033c
                if (r8 == 0) goto L_0x0332
                goto L_0x0338
            L_0x0332:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r2 = r7.booleanValue()
            L_0x0338:
                r5.N = r2
                goto L_0x076c
            L_0x033c:
                java.lang.String r0 = "ckpd"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0351
                if (r8 == 0) goto L_0x0347
                goto L_0x034d
            L_0x0347:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r2 = r7.booleanValue()
            L_0x034d:
                r5.O = r2
                goto L_0x076c
            L_0x0351:
                java.lang.String r0 = "ubenbl"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0366
                if (r8 == 0) goto L_0x035c
                goto L_0x0362
            L_0x035c:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r2 = r7.booleanValue()
            L_0x0362:
                r5.P = r2
                goto L_0x076c
            L_0x0366:
                java.lang.String r0 = "dvenbl"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x037b
                if (r8 == 0) goto L_0x0371
                goto L_0x0377
            L_0x0371:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r2 = r7.booleanValue()
            L_0x0377:
                r5.Q = r2
                goto L_0x076c
            L_0x037b:
                java.lang.String r0 = "ckua"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0390
                if (r8 == 0) goto L_0x0386
                goto L_0x038c
            L_0x0386:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r2 = r7.booleanValue()
            L_0x038c:
                r5.R = r2
                goto L_0x076c
            L_0x0390:
                java.lang.String r0 = "vnmt"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x03a5
                if (r8 == 0) goto L_0x039b
                goto L_0x03a1
            L_0x039b:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r2 = r7.booleanValue()
            L_0x03a1:
                r5.S = r2
                goto L_0x076c
            L_0x03a5:
                java.lang.String r0 = "degb"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x03ba
                if (r8 == 0) goto L_0x03b0
                goto L_0x03b6
            L_0x03b0:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r2 = r7.booleanValue()
            L_0x03b6:
                r5.T = r2
                goto L_0x076c
            L_0x03ba:
                java.lang.String r0 = "iwpxy"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x03cf
                if (r8 == 0) goto L_0x03c5
                goto L_0x03cb
            L_0x03c5:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r2 = r7.booleanValue()
            L_0x03cb:
                r5.U = r2
                goto L_0x076c
            L_0x03cf:
                java.lang.String r0 = "gflv"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x03e1
                if (r8 == 0) goto L_0x03da
                goto L_0x03dd
            L_0x03da:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x03dd:
                r5.V = r1
                goto L_0x076c
            L_0x03e1:
                java.lang.String r0 = "gbsbd"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x03f3
                if (r8 == 0) goto L_0x03ec
                goto L_0x03ef
            L_0x03ec:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x03ef:
                r5.W = r1
                goto L_0x076c
            L_0x03f3:
                java.lang.String r0 = "gbfspy"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0405
                if (r8 == 0) goto L_0x03fe
                goto L_0x0401
            L_0x03fe:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x0401:
                r5.X = r1
                goto L_0x076c
            L_0x0405:
                java.lang.String r0 = "gbplfo"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0417
                if (r8 == 0) goto L_0x0410
                goto L_0x0413
            L_0x0410:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x0413:
                r5.Y = r1
                goto L_0x076c
            L_0x0417:
                java.lang.String r0 = "gdntp"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x042c
                if (r8 == 0) goto L_0x0422
                goto L_0x0428
            L_0x0422:
                java.lang.Integer r7 = (java.lang.Integer) r7
                int r2 = r7.intValue()
            L_0x0428:
                r5.Z = r2
                goto L_0x076c
            L_0x042c:
                java.lang.String r0 = "qritsvc"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0441
                java.util.LinkedList<java.util.List<android.content.pm.ResolveInfo>> r6 = r5.f27980aa
                if (r8 == 0) goto L_0x0439
                goto L_0x043c
            L_0x0439:
                r1 = r7
                java.util.List r1 = (java.util.List) r1
            L_0x043c:
                r6.add(r1)
                goto L_0x076c
            L_0x0441:
                java.lang.String r0 = "rsaciy"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0456
                java.util.LinkedList<android.content.pm.ResolveInfo> r6 = r5.f27981ab
                if (r8 == 0) goto L_0x044e
                goto L_0x0451
            L_0x044e:
                r1 = r7
                android.content.pm.ResolveInfo r1 = (android.content.pm.ResolveInfo) r1
            L_0x0451:
                r6.add(r1)
                goto L_0x076c
            L_0x0456:
                java.lang.String r0 = "gpgif"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x046b
                java.util.LinkedList<android.content.pm.PackageInfo> r6 = r5.f27982ac
                if (r8 == 0) goto L_0x0463
                goto L_0x0466
            L_0x0463:
                r1 = r7
                android.content.pm.PackageInfo r1 = (android.content.pm.PackageInfo) r1
            L_0x0466:
                r6.add(r1)
                goto L_0x076c
            L_0x046b:
                java.lang.String r0 = "gpgiffcin"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0480
                java.util.LinkedList<android.content.pm.PackageInfo> r6 = r5.f27983ad
                if (r8 == 0) goto L_0x0478
                goto L_0x047b
            L_0x0478:
                r1 = r7
                android.content.pm.PackageInfo r1 = (android.content.pm.PackageInfo) r1
            L_0x047b:
                r6.add(r1)
                goto L_0x076c
            L_0x0480:
                java.lang.String r0 = "gpgifstrg"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0495
                java.util.LinkedList<android.content.pm.PackageInfo> r6 = r5.f27984ae
                if (r8 == 0) goto L_0x048d
                goto L_0x0490
            L_0x048d:
                r1 = r7
                android.content.pm.PackageInfo r1 = (android.content.pm.PackageInfo) r1
            L_0x0490:
                r6.add(r1)
                goto L_0x076c
            L_0x0495:
                java.lang.String r0 = "giads"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x04a7
                if (r8 == 0) goto L_0x04a0
                goto L_0x04a3
            L_0x04a0:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x04a3:
                r5.f27985af = r1
                goto L_0x076c
            L_0x04a7:
                java.lang.String r0 = "gdvda"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x04b9
                if (r8 == 0) goto L_0x04b2
                goto L_0x04b5
            L_0x04b2:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x04b5:
                r5.f27986ag = r1
                goto L_0x076c
            L_0x04b9:
                java.lang.String r0 = "gdvdtnas"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x04cb
                if (r8 == 0) goto L_0x04c4
                goto L_0x04c7
            L_0x04c4:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x04c7:
                r5.f27987ah = r1
                goto L_0x076c
            L_0x04cb:
                java.lang.String r0 = "galtut"
                boolean r0 = r0.equals(r6)
                r3 = 0
                if (r0 == 0) goto L_0x04e2
                if (r8 == 0) goto L_0x04d8
                goto L_0x04de
            L_0x04d8:
                java.lang.Long r7 = (java.lang.Long) r7
                long r3 = r7.longValue()
            L_0x04de:
                r5.f27988ai = r3
                goto L_0x076c
            L_0x04e2:
                java.lang.String r0 = "gdvme"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x04f4
                if (r8 == 0) goto L_0x04ed
                goto L_0x04f0
            L_0x04ed:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x04f0:
                r5.f27989aj = r1
                goto L_0x076c
            L_0x04f4:
                java.lang.String r0 = "gcrup"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0506
                if (r8 == 0) goto L_0x04ff
                goto L_0x0502
            L_0x04ff:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x0502:
                r5.f27990ak = r1
                goto L_0x076c
            L_0x0506:
                java.lang.String r0 = "gcifm"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0518
                if (r8 == 0) goto L_0x0511
                goto L_0x0514
            L_0x0511:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x0514:
                r5.f27991al = r1
                goto L_0x076c
            L_0x0518:
                java.lang.String r0 = "godm"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x052a
                if (r8 == 0) goto L_0x0523
                goto L_0x0526
            L_0x0523:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x0526:
                r5.f27992am = r1
                goto L_0x076c
            L_0x052a:
                java.lang.String r0 = "godhm"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x053c
                if (r8 == 0) goto L_0x0535
                goto L_0x0538
            L_0x0535:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x0538:
                r5.f27993an = r1
                goto L_0x076c
            L_0x053c:
                java.lang.String r0 = "galdm"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x054e
                if (r8 == 0) goto L_0x0547
                goto L_0x054a
            L_0x0547:
                r1 = r7
                java.util.HashMap r1 = (java.util.HashMap) r1
            L_0x054a:
                r5.f27994ao = r1
                goto L_0x076c
            L_0x054e:
                java.lang.String r0 = "gtaif"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0560
                if (r8 == 0) goto L_0x0559
                goto L_0x055c
            L_0x0559:
                r1 = r7
                android.content.pm.ApplicationInfo r1 = (android.content.pm.ApplicationInfo) r1
            L_0x055c:
                r5.f27995ap = r1
                goto L_0x076c
            L_0x0560:
                java.lang.String r0 = "gtaifprm"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0575
                java.util.LinkedList<android.content.pm.ApplicationInfo> r6 = r5.f27996aq
                if (r8 == 0) goto L_0x056d
                goto L_0x0570
            L_0x056d:
                r1 = r7
                android.content.pm.ApplicationInfo r1 = (android.content.pm.ApplicationInfo) r1
            L_0x0570:
                r6.add(r1)
                goto L_0x076c
            L_0x0575:
                java.lang.String r0 = "gtaifprmfce"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x058a
                java.util.LinkedList<android.content.pm.ApplicationInfo> r6 = r5.f27997ar
                if (r8 == 0) goto L_0x0582
                goto L_0x0585
            L_0x0582:
                r1 = r7
                android.content.pm.ApplicationInfo r1 = (android.content.pm.ApplicationInfo) r1
            L_0x0585:
                r6.add(r1)
                goto L_0x076c
            L_0x058a:
                java.lang.String r0 = "gtbdt"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x059f
                if (r8 == 0) goto L_0x0595
                goto L_0x059b
            L_0x0595:
                java.lang.Long r7 = (java.lang.Long) r7
                long r3 = r7.longValue()
            L_0x059b:
                r5.f28001av = r3
                goto L_0x076c
            L_0x059f:
                java.lang.String r0 = "gtscnin"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x05b6
                if (r8 == 0) goto L_0x05ac
                r6 = 0
                goto L_0x05b2
            L_0x05ac:
                java.lang.Double r7 = (java.lang.Double) r7
                double r6 = r7.doubleValue()
            L_0x05b2:
                r5.f28002aw = r6
                goto L_0x076c
            L_0x05b6:
                java.lang.String r0 = "gtscnppi"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x05cb
                if (r8 == 0) goto L_0x05c1
                goto L_0x05c7
            L_0x05c1:
                java.lang.Integer r7 = (java.lang.Integer) r7
                int r2 = r7.intValue()
            L_0x05c7:
                r5.f28003ax = r2
                goto L_0x076c
            L_0x05cb:
                java.lang.String r0 = "ishmos"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x05e0
                if (r8 == 0) goto L_0x05d6
                goto L_0x05dc
            L_0x05d6:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r2 = r7.booleanValue()
            L_0x05dc:
                r5.f28004ay = r2
                goto L_0x076c
            L_0x05e0:
                java.lang.String r0 = "gthmosv"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x05f2
                if (r8 == 0) goto L_0x05eb
                goto L_0x05ee
            L_0x05eb:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x05ee:
                r5.f28005az = r1
                goto L_0x076c
            L_0x05f2:
                java.lang.String r0 = "gthmosdtlv"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0604
                if (r8 == 0) goto L_0x05fd
                goto L_0x0600
            L_0x05fd:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x0600:
                r5.aA = r1
                goto L_0x076c
            L_0x0604:
                java.lang.String r0 = "gthmpmst"
                boolean r0 = r0.equals(r6)
                r3 = -1
                if (r0 == 0) goto L_0x061a
                if (r8 == 0) goto L_0x0610
                goto L_0x0616
            L_0x0610:
                java.lang.Integer r7 = (java.lang.Integer) r7
                int r3 = r7.intValue()
            L_0x0616:
                r5.aB = r3
                goto L_0x076c
            L_0x061a:
                java.lang.String r0 = "gthmepmst"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x062f
                if (r8 == 0) goto L_0x0625
                goto L_0x062b
            L_0x0625:
                java.lang.Integer r7 = (java.lang.Integer) r7
                int r3 = r7.intValue()
            L_0x062b:
                r5.aC = r3
                goto L_0x076c
            L_0x062f:
                java.lang.String r0 = "gtinnerlangmt"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0641
                if (r8 == 0) goto L_0x063a
                goto L_0x063d
            L_0x063a:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x063d:
                r5.aD = r1
                goto L_0x076c
            L_0x0641:
                java.lang.String r0 = "gtgramgendt"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0656
                if (r8 == 0) goto L_0x064c
                goto L_0x0652
            L_0x064c:
                java.lang.Integer r7 = (java.lang.Integer) r7
                int r2 = r7.intValue()
            L_0x0652:
                r5.aE = r2
                goto L_0x076c
            L_0x0656:
                java.lang.String r0 = "gtelcmefce"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x066b
                java.util.LinkedList<java.util.List> r6 = r5.aF
                if (r8 == 0) goto L_0x0663
                goto L_0x0666
            L_0x0663:
                r1 = r7
                java.util.List r1 = (java.util.List) r1
            L_0x0666:
                r6.add(r1)
                goto L_0x076c
            L_0x066b:
                java.lang.String r0 = "gtmwfo"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x067d
                if (r8 == 0) goto L_0x0676
                goto L_0x0679
            L_0x0676:
                r1 = r7
                java.util.HashMap r1 = (java.util.HashMap) r1
            L_0x0679:
                r5.aG = r1
                goto L_0x076c
            L_0x067d:
                java.lang.String r0 = "wmcwifce"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0692
                java.util.LinkedList<java.util.HashMap<java.lang.String, java.lang.Object>> r6 = r5.aH
                if (r8 == 0) goto L_0x068a
                goto L_0x068d
            L_0x068a:
                r1 = r7
                java.util.HashMap r1 = (java.util.HashMap) r1
            L_0x068d:
                r6.add(r1)
                goto L_0x076c
            L_0x0692:
                java.lang.String r0 = "gtaifok"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x06a4
                if (r8 == 0) goto L_0x069d
                goto L_0x06a0
            L_0x069d:
                r1 = r7
                java.util.ArrayList r1 = (java.util.ArrayList) r1
            L_0x06a0:
                r5.aI = r1
                goto L_0x076c
            L_0x06a4:
                java.lang.String r0 = "gtmcdi"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x06b6
                if (r8 == 0) goto L_0x06af
                goto L_0x06b2
            L_0x06af:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x06b2:
                r5.aJ = r1
                goto L_0x076c
            L_0x06b6:
                java.lang.String r0 = "gtmcdifce"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x06cb
                java.util.LinkedList<java.lang.String> r6 = r5.aK
                if (r8 == 0) goto L_0x06c3
                goto L_0x06c6
            L_0x06c3:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x06c6:
                r6.add(r1)
                goto L_0x076c
            L_0x06cb:
                java.lang.String r0 = "gtmbcdi"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x06dd
                if (r8 == 0) goto L_0x06d6
                goto L_0x06d9
            L_0x06d6:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x06d9:
                r5.aL = r1
                goto L_0x076c
            L_0x06dd:
                java.lang.String r0 = "gtmbcdifce"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x06f2
                java.util.LinkedList<java.lang.String> r6 = r5.aM
                if (r8 == 0) goto L_0x06ea
                goto L_0x06ed
            L_0x06ea:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x06ed:
                r6.add(r1)
                goto L_0x076c
            L_0x06f2:
                java.lang.String r0 = "miwpy"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0707
                if (r8 == 0) goto L_0x06fd
                goto L_0x0703
            L_0x06fd:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r2 = r7.booleanValue()
            L_0x0703:
                r5.aN = r2
                goto L_0x076c
            L_0x0707:
                java.lang.String r0 = "gtmnbclfo"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0718
                if (r8 == 0) goto L_0x0712
                goto L_0x0715
            L_0x0712:
                r1 = r7
                java.util.ArrayList r1 = (java.util.ArrayList) r1
            L_0x0715:
                r5.aO = r1
                goto L_0x076c
            L_0x0718:
                java.lang.String r0 = "ctedebbing"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x072e
                if (r8 != 0) goto L_0x072b
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r6 = r7.booleanValue()
                if (r6 == 0) goto L_0x072b
                r2 = 1
            L_0x072b:
                r5.aS = r2
                goto L_0x076c
            L_0x072e:
                java.lang.String r0 = "gteacifo"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x073f
                if (r8 == 0) goto L_0x0739
                goto L_0x073c
            L_0x0739:
                r1 = r7
                java.util.ArrayList r1 = (java.util.ArrayList) r1
            L_0x073c:
                r5.aT = r1
                goto L_0x076c
            L_0x073f:
                java.lang.String r0 = "gtdm"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x0750
                if (r8 == 0) goto L_0x074a
                goto L_0x074d
            L_0x074a:
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
            L_0x074d:
                r5.aU = r1
                goto L_0x076c
            L_0x0750:
                java.lang.String r0 = "gtlstactme"
                boolean r0 = r0.equals(r6)
                if (r0 == 0) goto L_0x076d
                java.util.LinkedList<java.lang.Long> r6 = r5.aV
                if (r8 == 0) goto L_0x075f
                r7 = -1
                goto L_0x0765
            L_0x075f:
                java.lang.Long r7 = (java.lang.Long) r7
                long r7 = r7.longValue()
            L_0x0765:
                java.lang.Long r7 = java.lang.Long.valueOf(r7)
                r6.add(r7)
            L_0x076c:
                return
            L_0x076d:
                java.lang.Throwable r8 = new java.lang.Throwable
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Unknown name to set: "
                r0.append(r1)
                r0.append(r6)
                java.lang.String r6 = ", value: "
                r0.append(r6)
                r0.append(r7)
                java.lang.String r6 = r0.toString()
                r8.<init>(r6)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.DH.DHResponse.a(java.lang.String, java.lang.Object, boolean):void");
        }

        private static <T> T a(LinkedList<T> linkedList, T t11, int... iArr) {
            if (linkedList != null) {
                try {
                    if (iArr.length == 0) {
                        return linkedList.get(0);
                    }
                    if (iArr[0] < linkedList.size()) {
                        return linkedList.get(iArr[0]);
                    }
                    NLog instance = MobLog.getInstance();
                    instance.w("WARNING: " + iArr[0] + " out of bound, size: " + linkedList.size());
                } catch (Throwable th2) {
                    MobLog.getInstance().d(th2);
                }
            }
            return t11;
        }
    }

    public static class RequestBuilder {

        /* renamed from: a  reason: collision with root package name */
        private final Context f28031a;

        /* renamed from: b  reason: collision with root package name */
        private final LinkedList<a> f28032b;

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public final String f28040a;

            /* renamed from: b  reason: collision with root package name */
            public final Object[] f28041b;

            private a(String str, Object... objArr) {
                this.f28040a = str;
                this.f28041b = objArr;
            }
        }

        public RequestBuilder checkDebbing() {
            this.f28032b.add(new a("ctedebbing", new Object[0]));
            return this;
        }

        public RequestBuilder checkNetworkAvailable() {
            this.f28032b.add(new a("cknavbl", new Object[0]));
            return this;
        }

        public RequestBuilder checkPad() {
            this.f28032b.add(new a("ckpd", new Object[0]));
            return this;
        }

        public RequestBuilder checkUA() {
            this.f28032b.add(new a("ckua", new Object[0]));
            return this;
        }

        public RequestBuilder cx() {
            this.f28032b.add(new a("cx", new Object[0]));
            return this;
        }

        public RequestBuilder debugable() {
            this.f28032b.add(new a("degb", new Object[0]));
            return this;
        }

        public RequestBuilder devEnable() {
            this.f28032b.add(new a("dvenbl", new Object[0]));
            return this;
        }

        public RequestBuilder getACIfo() {
            this.f28032b.add(new a("gteacifo", new Object[0]));
            return this;
        }

        public RequestBuilder getAInfo() {
            this.f28032b.add(new a("gtaif", new Object[0]));
            return this;
        }

        public RequestBuilder getAInfoForPkg(String str, int i11) {
            this.f28032b.add(new a("gtaifprm", new Object[]{str, Integer.valueOf(i11)}));
            return this;
        }

        public RequestBuilder getAInfoForPkgForce(boolean z11, String str, int i11) {
            this.f28032b.add(new a("gtaifprmfce", new Object[]{Boolean.valueOf(z11), str, Integer.valueOf(i11)}));
            return this;
        }

        public RequestBuilder getALLD() {
            this.f28032b.add(new a("galdm", new Object[0]));
            return this;
        }

        public RequestBuilder getAdvertisingID() {
            this.f28032b.add(new a("gavti", new Object[0]));
            return this;
        }

        public RequestBuilder getAppLastUpdateTime() {
            this.f28032b.add(new a("galtut", new Object[0]));
            return this;
        }

        public RequestBuilder getAppName() {
            this.f28032b.add(new a("gpnmmt", new Object[0]));
            return this;
        }

        public RequestBuilder getAppNameForPkg(String str) {
            this.f28032b.add(new a("gpnmfp", new Object[]{str}));
            return this;
        }

        public RequestBuilder getBaseband() {
            this.f28032b.add(new a("gbsbd", new Object[0]));
            return this;
        }

        public RequestBuilder getBdT() {
            this.f28032b.add(new a("gtbdt", new Object[0]));
            return this;
        }

        public RequestBuilder getBoardFromSysProperty() {
            this.f28032b.add(new a("gbfspy", new Object[0]));
            return this;
        }

        public RequestBuilder getBoardPlatform() {
            this.f28032b.add(new a("gbplfo", new Object[0]));
            return this;
        }

        public RequestBuilder getBssid() {
            this.f28032b.add(new a("gbsi", new Object[0]));
            return this;
        }

        public RequestBuilder getBssidForce(boolean z11) {
            this.f28032b.add(new a("gbsifce", new Object[]{Boolean.valueOf(z11)}));
            return this;
        }

        public RequestBuilder getBtM() {
            return this;
        }

        public RequestBuilder getCInfo() {
            this.f28032b.add(new a("gcifm", new Object[0]));
            return this;
        }

        public RequestBuilder getCLoc() {
            this.f28032b.add(new a("gtecloc", new Object[0]));
            return this;
        }

        public RequestBuilder getCPUInfo() {
            this.f28032b.add(new a("gcuin", new Object[0]));
            return this;
        }

        public RequestBuilder getCarrier() {
            this.f28032b.add(new a("gcrie", new Object[0]));
            return this;
        }

        public RequestBuilder getCarrierForce(boolean z11) {
            this.f28032b.add(new a("gcriefce", new Object[]{Boolean.valueOf(z11)}));
            return this;
        }

        public RequestBuilder getCarrierName() {
            this.f28032b.add(new a("gcrnm", new Object[0]));
            return this;
        }

        public RequestBuilder getCarrierNameForce(boolean z11) {
            this.f28032b.add(new a("gcrnmfce", new Object[]{Boolean.valueOf(z11)}));
            return this;
        }

        public RequestBuilder getCgroup() {
            this.f28032b.add(new a("gcrup", new Object[0]));
            return this;
        }

        public RequestBuilder getCurrentWifiInfo() {
            this.f28032b.add(new a("wmcwi", new Object[0]));
            return this;
        }

        public RequestBuilder getDM(boolean z11) {
            this.f28032b.add(new a("gtdm", new Object[]{Boolean.valueOf(z11)}));
            return this;
        }

        public RequestBuilder getDataNtType() {
            this.f28032b.add(new a("gdntp", new Object[0]));
            return this;
        }

        public RequestBuilder getDetailNetworkTypeForStatic() {
            this.f28032b.add(new a("gdtlnktpfs", new Object[0]));
            return this;
        }

        public RequestBuilder getDeviceData() {
            this.f28032b.add(new a("gdvda", new Object[0]));
            return this;
        }

        public RequestBuilder getDeviceDataNotAES() {
            this.f28032b.add(new a("gdvdtnas", new Object[0]));
            return this;
        }

        public RequestBuilder getDeviceId() {
            return this;
        }

        public RequestBuilder getDeviceKey() {
            this.f28032b.add(new a("gdvk", new Object[0]));
            return this;
        }

        public RequestBuilder getDeviceKeyFromCache(boolean z11) {
            this.f28032b.add(new a("gdvkfc", new Object[]{Boolean.valueOf(z11)}));
            return this;
        }

        public RequestBuilder getDeviceName() {
            this.f28032b.add(new a("gdvme", new Object[0]));
            return this;
        }

        public RequestBuilder getDeviceType() {
            this.f28032b.add(new a("gdvtp", new Object[0]));
            return this;
        }

        public RequestBuilder getDrID() {
            return this;
        }

        public RequestBuilder getFlavor() {
            this.f28032b.add(new a("gflv", new Object[0]));
            return this;
        }

        public RequestBuilder getGrammaticalGender() {
            this.f28032b.add(new a("gtgramgendt", new Object[0]));
            return this;
        }

        public RequestBuilder getHmEPMState() {
            this.f28032b.add(new a("gthmepmst", new Object[0]));
            return this;
        }

        public RequestBuilder getHmOsDetailedVer() {
            this.f28032b.add(new a("gthmosdtlv", new Object[0]));
            return this;
        }

        public RequestBuilder getHmOsVer() {
            this.f28032b.add(new a("gthmosv", new Object[0]));
            return this;
        }

        public RequestBuilder getHmPMState() {
            this.f28032b.add(new a("gthmpmst", new Object[0]));
            return this;
        }

        public RequestBuilder getIA(boolean z11) {
            this.f28032b.add(new a("gia", new Object[]{Boolean.valueOf(z11)}));
            return this;
        }

        public RequestBuilder getIAForce(boolean z11, boolean z12) {
            this.f28032b.add(new a("giafce", new Object[]{Boolean.valueOf(z11), Boolean.valueOf(z12)}));
            return this;
        }

        public RequestBuilder getIMEI() {
            return this;
        }

        public RequestBuilder getIMSI() {
            return this;
        }

        public RequestBuilder getIPAddress() {
            this.f28032b.add(new a("giads", new Object[0]));
            return this;
        }

        public RequestBuilder getInnerAppLanguage() {
            this.f28032b.add(new a("gtinnerlangmt", new Object[0]));
            return this;
        }

        public RequestBuilder getLATime(String str) {
            this.f28032b.add(new a("gtlstactme", new Object[]{str}));
            return this;
        }

        public RequestBuilder getLocation(int i11, int i12, boolean z11) {
            this.f28032b.add(new a("glctn", new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Boolean.valueOf(z11)}));
            return this;
        }

        public RequestBuilder getMIUIVersion() {
            this.f28032b.add(new a("gmivsn", new Object[0]));
            return this;
        }

        public RequestBuilder getMbcdi() {
            this.f28032b.add(new a("gtmbcdi", new Object[0]));
            return this;
        }

        public RequestBuilder getMbcdiForce(boolean z11) {
            this.f28032b.add(new a("gtmbcdifce", new Object[]{Boolean.valueOf(z11)}));
            return this;
        }

        public RequestBuilder getMcdi() {
            this.f28032b.add(new a("gtmcdi", new Object[0]));
            return this;
        }

        public RequestBuilder getMcdiForce(boolean z11) {
            this.f28032b.add(new a("gtmcdifce", new Object[]{Boolean.valueOf(z11)}));
            return this;
        }

        public RequestBuilder getMemoryInfo() {
            this.f28032b.add(new a("gmrin", new Object[0]));
            return this;
        }

        public RequestBuilder getMnbclfo() {
            this.f28032b.add(new a("gtmnbclfo", new Object[0]));
            return this;
        }

        public RequestBuilder getMpfo(String str, int i11) {
            this.f28032b.add(new a("gmpfo", new Object[]{str, Integer.valueOf(i11)}));
            return this;
        }

        public RequestBuilder getMpfof(boolean z11, String str, int i11) {
            this.f28032b.add(new a("gmpfofce", new Object[]{Boolean.valueOf(z11), str, Integer.valueOf(i11)}));
            return this;
        }

        public RequestBuilder getMpfos(int i11, String str, int i12) {
            this.f28032b.add(new a("getMpfos", new Object[]{Integer.valueOf(i11), str, Integer.valueOf(i12)}));
            return this;
        }

        public RequestBuilder getMwfo() {
            this.f28032b.add(new a("gtmwfo", new Object[0]));
            return this;
        }

        public RequestBuilder getMwfoForce(boolean z11) {
            this.f28032b.add(new a("wmcwifce", new Object[]{Boolean.valueOf(z11)}));
            return this;
        }

        public RequestBuilder getMwlfo() {
            this.f28032b.add(new a("gtaifok", new Object[0]));
            return this;
        }

        public RequestBuilder getNeighboringCellInfo() {
            this.f28032b.add(new a("gnbclin", new Object[0]));
            return this;
        }

        @Deprecated
        public RequestBuilder getNetworkType() {
            this.f28032b.add(new a("gneyp", new Object[0]));
            return this;
        }

        public RequestBuilder getNetworkTypeForStatic() {
            this.f28032b.add(new a("gnktpfs", new Object[0]));
            return this;
        }

        public RequestBuilder getNetworkTypeForce(boolean z11) {
            this.f28032b.add(new a("gneypfce", new Object[]{Boolean.valueOf(z11)}));
            return this;
        }

        public RequestBuilder getNetworkTypeNew() {
            this.f28032b.add(new a("gneypnw", new Object[0]));
            return this;
        }

        public RequestBuilder getOD() {
            this.f28032b.add(new a("godm", new Object[0]));
            return this;
        }

        public RequestBuilder getODH() {
            this.f28032b.add(new a("godhm", new Object[0]));
            return this;
        }

        public RequestBuilder getPInfo(String str, int i11) {
            this.f28032b.add(new a("gpgif", new Object[]{str, Integer.valueOf(i11)}));
            return this;
        }

        public RequestBuilder getPInfoForce(boolean z11, String str, int i11) {
            this.f28032b.add(new a("gpgiffcin", new Object[]{Boolean.valueOf(z11), str, Integer.valueOf(i11)}));
            return this;
        }

        public RequestBuilder getPInfoStrategy(int i11, String str, int i12) {
            this.f28032b.add(new a("gpgifstrg", new Object[]{Integer.valueOf(i11), str, Integer.valueOf(i12)}));
            return this;
        }

        public RequestBuilder getPosCommForce(int i11, int i12, boolean z11, boolean z12) {
            this.f28032b.add(new a("gtelcmefce", new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Boolean.valueOf(z11), Boolean.valueOf(z12)}));
            return this;
        }

        public RequestBuilder getQemuKernel() {
            this.f28032b.add(new a("gqmkn", new Object[0]));
            return this;
        }

        public RequestBuilder getSA() {
            this.f28032b.add(new a("gsl", new Object[0]));
            return this;
        }

        public RequestBuilder getSSID() {
            this.f28032b.add(new a("gsimt", new Object[0]));
            return this;
        }

        public RequestBuilder getSSIDForce(boolean z11) {
            this.f28032b.add(new a("gsimtfce", new Object[]{Boolean.valueOf(z11)}));
            return this;
        }

        public RequestBuilder getScreenInch() {
            this.f28032b.add(new a("gtscnin", new Object[0]));
            return this;
        }

        public RequestBuilder getScreenPpi() {
            this.f28032b.add(new a("gtscnppi", new Object[0]));
            return this;
        }

        public RequestBuilder getScreenSize() {
            this.f28032b.add(new a("gscsz", new Object[0]));
            return this;
        }

        public RequestBuilder getSdcardState() {
            return this;
        }

        public RequestBuilder getSerialno() {
            return this;
        }

        public RequestBuilder getSignMD5() {
            this.f28032b.add(new a("gsnmd", new Object[0]));
            return this;
        }

        public RequestBuilder getSignMD5ForPkg(String str) {
            this.f28032b.add(new a("gsnmdfp", new Object[]{str}));
            return this;
        }

        public RequestBuilder getSimSerialNumber() {
            return this;
        }

        public RequestBuilder getSizeInfo() {
            this.f28032b.add(new a("gszin", new Object[0]));
            return this;
        }

        public RequestBuilder getSystemProperties(String str) {
            this.f28032b.add(new a("gstmpts", new Object[]{str}));
            return this;
        }

        public RequestBuilder getTTYDriversInfo() {
            this.f28032b.add(new a("gtydvin", new Object[0]));
            return this;
        }

        public RequestBuilder getTopActivity() {
            return this;
        }

        public RequestBuilder getUpM() {
            return this;
        }

        public RequestBuilder isHmOs() {
            this.f28032b.add(new a("ishmos", new Object[0]));
            return this;
        }

        public RequestBuilder isMwpy() {
            this.f28032b.add(new a("miwpy", new Object[0]));
            return this;
        }

        public RequestBuilder isPackageInstalled(String str) {
            this.f28032b.add(new a("ipgist", new Object[]{str}));
            return this;
        }

        public RequestBuilder isRooted() {
            this.f28032b.add(new a("cird", new Object[0]));
            return this;
        }

        public RequestBuilder isWifiProxy() {
            this.f28032b.add(new a("iwpxy", new Object[0]));
            return this;
        }

        public RequestBuilder queryIMEI() {
            return this;
        }

        public RequestBuilder queryIMSI() {
            return this;
        }

        public RequestBuilder queryIntentServices(Intent intent, int i11) {
            this.f28032b.add(new a("qritsvc", new Object[]{intent, Integer.valueOf(i11)}));
            return this;
        }

        public void request(DHResponder dHResponder) {
            try {
                boolean z11 = Looper.getMainLooper() == Looper.myLooper();
                final Boolean bool = com.mob.tools.c.a.f27896b.get();
                final Boolean bool2 = com.mob.tools.c.a.f27897c.get();
                final DHResponder dHResponder2 = dHResponder;
                final boolean z12 = z11;
                AnonymousClass1 r12 = new Runnable() {
                    public void run() {
                        try {
                            com.mob.tools.c.a.f27895a.set(Boolean.TRUE);
                            com.mob.tools.c.a.f27896b.set(bool);
                            com.mob.tools.c.a.f27897c.set(bool2);
                            final DHResponse a11 = RequestBuilder.this.a();
                            DHResponder dHResponder = dHResponder2;
                            if (dHResponder != null) {
                                if (z12) {
                                    UIHandler.sendEmptyMessage(0, new Handler.Callback() {
                                        public boolean handleMessage(Message message) {
                                            try {
                                                dHResponder2.onResponse(a11);
                                            } catch (Throwable th2) {
                                                MobLog.getInstance().d(th2, "Error from caller", new Object[0]);
                                            }
                                            return false;
                                        }
                                    });
                                } else {
                                    dHResponder.onResponse(a11);
                                }
                            }
                        } catch (Throwable th2) {
                            MobLog.getInstance().d(th2);
                            RequestBuilder.this.a(dHResponder2);
                            return;
                        }
                        ThreadLocal<Boolean> threadLocal = com.mob.tools.c.a.f27895a;
                        Boolean bool = Boolean.FALSE;
                        threadLocal.set(bool);
                        com.mob.tools.c.a.f27896b.set(bool);
                        com.mob.tools.c.a.f27897c.set(bool);
                    }
                };
                if (z11) {
                    z.f27388g.execute(r12);
                } else {
                    r12.run();
                }
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
                if (dHResponder != null) {
                    a(dHResponder);
                }
            }
        }

        public RequestBuilder resolveActivity(Intent intent, int i11) {
            this.f28032b.add(new a("rsaciy", new Object[]{intent, Integer.valueOf(i11)}));
            return this;
        }

        public RequestBuilder usbEnable() {
            this.f28032b.add(new a("ubenbl", new Object[0]));
            return this;
        }

        public RequestBuilder vpn() {
            this.f28032b.add(new a("vnmt", new Object[0]));
            return this;
        }

        private RequestBuilder(Context context) {
            this.f28032b = new LinkedList<>();
            this.f28031a = context;
        }

        /* access modifiers changed from: private */
        public void a(DHResponder dHResponder) {
            if (dHResponder != null) {
                try {
                    dHResponder.onResponse(new DHResponse());
                } catch (Throwable th2) {
                    MobLog.getInstance().d(th2, "Error from caller", new Object[0]);
                }
            }
        }

        /* access modifiers changed from: private */
        public DHResponse a() {
            DHResponse dHResponse = new DHResponse();
            for (int i11 = 0; i11 < this.f28032b.size(); i11++) {
                a aVar = this.f28032b.get(i11);
                try {
                    String str = aVar.f28040a;
                    dHResponse.a(str, a(str, aVar.f28041b));
                } catch (Throwable th2) {
                    MobLog.getInstance().d(th2);
                }
            }
            return dHResponse;
        }

        private Object a(String str, Object[] objArr) throws Throwable {
            if ("gmpfo".equals(str)) {
                if (objArr == null || objArr.length != 2) {
                    throw new Throwable("params illegal: " + objArr);
                }
                int intValue = objArr[1].intValue();
                return c.a(this.f28031a).d().b(false, 0, objArr[0], intValue);
            } else if ("gmpfofce".equals(str)) {
                if (objArr == null || objArr.length != 3) {
                    throw new Throwable("params illegal: " + objArr);
                }
                int intValue2 = objArr[2].intValue();
                return c.a(this.f28031a).d().b(objArr[0].booleanValue(), 0, objArr[1], intValue2);
            } else if ("getMpfos".equals(str)) {
                if (objArr == null || objArr.length != 3) {
                    throw new Throwable("params illegal: " + objArr);
                }
                int intValue3 = objArr[2].intValue();
                return c.a(this.f28031a).d().b(false, objArr[0].intValue(), objArr[1], intValue3);
            } else if ("cird".equals(str)) {
                return Boolean.valueOf(c.a(this.f28031a).d().a());
            } else {
                if ("gsimt".equals(str)) {
                    return c.a(this.f28031a).d().a(false);
                }
                if ("gsimtfce".equals(str)) {
                    if (objArr == null || objArr.length != 1) {
                        throw new Throwable("params illegal: " + objArr);
                    }
                    return c.a(this.f28031a).d().a(objArr[0].booleanValue());
                } else if ("gbsi".equals(str)) {
                    return c.a(this.f28031a).d().b(false);
                } else {
                    if ("gbsifce".equals(str)) {
                        if (objArr == null || objArr.length != 1) {
                            throw new Throwable("params illegal: " + objArr);
                        }
                        return c.a(this.f28031a).d().b(objArr[0].booleanValue());
                    } else if ("gstmpts".equals(str)) {
                        if (objArr == null || objArr.length != 1) {
                            throw new Throwable("params illegal: " + objArr);
                        }
                        return c.a(this.f28031a).d().a(objArr[0]);
                    } else if ("gscsz".equals(str)) {
                        return c.a(this.f28031a).d().C();
                    } else {
                        if ("gcrie".equals(str)) {
                            return c.a(this.f28031a).d().c(false);
                        }
                        if ("gcriefce".equals(str)) {
                            if (objArr == null || objArr.length != 1) {
                                throw new Throwable("params illegal: " + objArr);
                            }
                            return c.a(this.f28031a).d().c(objArr[0].booleanValue());
                        } else if ("gcrnm".equals(str)) {
                            return c.a(this.f28031a).d().d(false);
                        } else {
                            if ("gcrnmfce".equals(str)) {
                                if (objArr == null || objArr.length != 1) {
                                    throw new Throwable("params illegal: " + objArr);
                                }
                                return c.a(this.f28031a).d().d(objArr[0].booleanValue());
                            } else if ("gsnmd".equals(str)) {
                                return c.a(this.f28031a).d().S();
                            } else {
                                if ("gsnmdfp".equals(str)) {
                                    if (objArr == null || objArr.length != 1) {
                                        throw new Throwable("params illegal: " + objArr);
                                    }
                                    return c.a(this.f28031a).d().c(objArr[0]);
                                } else if ("gneyp".equals(str)) {
                                    return c.a(this.f28031a).d().f(false);
                                } else {
                                    if ("gneypnw".equals(str)) {
                                        return c.a(this.f28031a).d().D();
                                    }
                                    if ("gneypfce".equals(str)) {
                                        if (objArr == null || objArr.length != 1) {
                                            throw new Throwable("params illegal: " + objArr);
                                        }
                                        return c.a(this.f28031a).d().f(objArr[0].booleanValue());
                                    } else if ("cknavbl".equals(str)) {
                                        return Boolean.valueOf(c.a(this.f28031a).d().G());
                                    } else {
                                        if ("gnktpfs".equals(str)) {
                                            return c.a(this.f28031a).d().E();
                                        }
                                        if ("gdtlnktpfs".equals(str)) {
                                            return c.a(this.f28031a).d().F();
                                        }
                                        if ("gdvk".equals(str)) {
                                            return c.a(this.f28031a).d().Q();
                                        }
                                        if ("gdvkfc".equals(str)) {
                                            if (objArr == null || objArr.length != 1) {
                                                throw new Throwable("params illegal: " + objArr);
                                            }
                                            return c.a(this.f28031a).d().g(objArr[0].booleanValue());
                                        } else if ("gpnmmt".equals(str)) {
                                            return c.a(this.f28031a).d().U();
                                        } else {
                                            if ("gpnmfp".equals(str)) {
                                                if (objArr == null || objArr.length != 1) {
                                                    throw new Throwable("params illegal: " + objArr);
                                                }
                                                return c.a(this.f28031a).d().d(objArr[0]);
                                            } else if ("gia".equals(str)) {
                                                if (objArr == null || objArr.length != 1) {
                                                    throw new Throwable("params illegal: " + objArr);
                                                }
                                                return c.a(this.f28031a).d().a(objArr[0].booleanValue(), false);
                                            } else if ("giafce".equals(str)) {
                                                if (objArr == null || objArr.length != 2) {
                                                    throw new Throwable("params illegal: " + objArr);
                                                }
                                                return c.a(this.f28031a).d().a(objArr[0].booleanValue(), objArr[1].booleanValue());
                                            } else if ("gsl".equals(str)) {
                                                return c.a(this.f28031a).d().P();
                                            } else {
                                                if ("gscpt".equals(str)) {
                                                    return c.a(this.f28031a).d().R();
                                                }
                                                if ("gavti".equals(str)) {
                                                    return c.a(this.f28031a).d().j();
                                                }
                                                if ("glctn".equals(str)) {
                                                    if (objArr == null || objArr.length != 3) {
                                                        throw new Throwable("params illegal: " + objArr);
                                                    }
                                                    return c.a(this.f28031a).d().a(objArr[0].intValue(), objArr[1].intValue(), objArr[2].booleanValue());
                                                } else if ("gtecloc".equals(str)) {
                                                    return c.a(this.f28031a).d().p();
                                                } else {
                                                    if ("gnbclin".equals(str)) {
                                                        return c.a(this.f28031a).d().q();
                                                    }
                                                    if ("gdvtp".equals(str)) {
                                                        return c.a(this.f28031a).d().o();
                                                    }
                                                    if ("wmcwi".equals(str)) {
                                                        return c.a(this.f28031a).d().r();
                                                    }
                                                    if ("ipgist".equals(str)) {
                                                        if (objArr == null || objArr.length != 1) {
                                                            throw new Throwable("params illegal: " + objArr);
                                                        }
                                                        return Boolean.valueOf(c.a(this.f28031a).d().b(objArr[0]));
                                                    } else if ("gcuin".equals(str)) {
                                                        return c.a(this.f28031a).d().w();
                                                    } else {
                                                        if ("gtydvin".equals(str)) {
                                                            return c.a(this.f28031a).d().x();
                                                        }
                                                        if ("gqmkn".equals(str)) {
                                                            return c.a(this.f28031a).d().y();
                                                        }
                                                        if ("gszin".equals(str)) {
                                                            return c.a(this.f28031a).d().z();
                                                        }
                                                        if ("gmrin".equals(str)) {
                                                            return c.a(this.f28031a).d().A();
                                                        }
                                                        if ("gmivsn".equals(str)) {
                                                            return c.a(this.f28031a).d().k();
                                                        }
                                                        if ("cx".equals(str)) {
                                                            return Boolean.valueOf(c.a(this.f28031a).d().b());
                                                        }
                                                        if ("ckpd".equals(str)) {
                                                            return Boolean.valueOf(c.a(this.f28031a).d().c());
                                                        }
                                                        if ("ubenbl".equals(str)) {
                                                            return Boolean.valueOf(c.a(this.f28031a).d().h());
                                                        }
                                                        if ("dvenbl".equals(str)) {
                                                            return Boolean.valueOf(c.a(this.f28031a).d().g());
                                                        }
                                                        if ("ckua".equals(str)) {
                                                            return Boolean.valueOf(c.a(this.f28031a).d().f());
                                                        }
                                                        if ("vnmt".equals(str)) {
                                                            return Boolean.valueOf(c.a(this.f28031a).d().e());
                                                        }
                                                        if ("degb".equals(str)) {
                                                            return Boolean.valueOf(c.a(this.f28031a).d().d());
                                                        }
                                                        if ("iwpxy".equals(str)) {
                                                            return Boolean.valueOf(c.a(this.f28031a).d().i());
                                                        }
                                                        if ("gflv".equals(str)) {
                                                            return c.a(this.f28031a).d().J();
                                                        }
                                                        if ("gbsbd".equals(str)) {
                                                            return c.a(this.f28031a).d().K();
                                                        }
                                                        if ("gbfspy".equals(str)) {
                                                            return c.a(this.f28031a).d().L();
                                                        }
                                                        if ("gbplfo".equals(str)) {
                                                            return c.a(this.f28031a).d().M();
                                                        }
                                                        if ("gdntp".equals(str)) {
                                                            return Integer.valueOf(c.a(this.f28031a).d().H());
                                                        }
                                                        if ("qritsvc".equals(str)) {
                                                            if (objArr == null || objArr.length != 2) {
                                                                throw new Throwable("params illegal: " + objArr);
                                                            }
                                                            int intValue4 = objArr[1].intValue();
                                                            return c.a(this.f28031a).d().a(objArr[0], intValue4);
                                                        } else if ("rsaciy".equals(str)) {
                                                            if (objArr == null || objArr.length != 2) {
                                                                throw new Throwable("params illegal: " + objArr);
                                                            }
                                                            int intValue5 = objArr[1].intValue();
                                                            return c.a(this.f28031a).d().b(objArr[0], intValue5);
                                                        } else if ("gpgif".equals(str)) {
                                                            if (objArr == null || objArr.length != 2) {
                                                                throw new Throwable("params illegal: " + objArr);
                                                            }
                                                            int intValue6 = objArr[1].intValue();
                                                            return c.a(this.f28031a).d().a(false, 0, objArr[0], intValue6);
                                                        } else if ("gpgiffcin".equals(str)) {
                                                            if (objArr == null || objArr.length != 3) {
                                                                throw new Throwable("params illegal: " + objArr);
                                                            }
                                                            int intValue7 = objArr[2].intValue();
                                                            return c.a(this.f28031a).d().a(objArr[0].booleanValue(), 0, objArr[1], intValue7);
                                                        } else if ("gpgifstrg".equals(str)) {
                                                            if (objArr == null || objArr.length != 3) {
                                                                throw new Throwable("params illegal: " + objArr);
                                                            }
                                                            int intValue8 = objArr[2].intValue();
                                                            return c.a(this.f28031a).d().a(false, objArr[0].intValue(), objArr[1], intValue8);
                                                        } else if ("giads".equals(str)) {
                                                            return c.a(this.f28031a).d().N();
                                                        } else {
                                                            if ("gdvda".equals(str)) {
                                                                return c.a(this.f28031a).d().ab();
                                                            }
                                                            if ("gdvdtnas".equals(str)) {
                                                                return c.a(this.f28031a).d().ac();
                                                            }
                                                            if ("galtut".equals(str)) {
                                                                return Long.valueOf(c.a(this.f28031a).d().ad());
                                                            }
                                                            if ("gdvme".equals(str)) {
                                                                return c.a(this.f28031a).d().ae();
                                                            }
                                                            if ("gcrup".equals(str)) {
                                                                return c.a(this.f28031a).d().af();
                                                            }
                                                            if ("gcifm".equals(str)) {
                                                                return c.a(this.f28031a).d().ag();
                                                            }
                                                            if ("godm".equals(str)) {
                                                                return c.a(this.f28031a).d().ah();
                                                            }
                                                            if ("godhm".equals(str)) {
                                                                return c.a(this.f28031a).d().ai();
                                                            }
                                                            if ("galdm".equals(str)) {
                                                                return c.a(this.f28031a).d().aj();
                                                            }
                                                            if ("gtaif".equals(str)) {
                                                                return c.a(this.f28031a).d().ak();
                                                            }
                                                            if ("gtaifprm".equals(str)) {
                                                                if (objArr == null || objArr.length != 2) {
                                                                    throw new Throwable("params illegal: " + objArr);
                                                                }
                                                                int intValue9 = objArr[1].intValue();
                                                                return c.a(this.f28031a).d().a(objArr[0], intValue9);
                                                            } else if ("gtaifprmfce".equals(str)) {
                                                                if (objArr == null || objArr.length != 3) {
                                                                    throw new Throwable("params illegal: " + objArr);
                                                                }
                                                                int intValue10 = objArr[2].intValue();
                                                                return c.a(this.f28031a).d().a(objArr[0].booleanValue(), objArr[1], intValue10);
                                                            } else if ("gtbdt".equals(str)) {
                                                                return Long.valueOf(c.a(this.f28031a).d().am());
                                                            } else {
                                                                if ("gtscnin".equals(str)) {
                                                                    return Double.valueOf(c.a(this.f28031a).d().an());
                                                                }
                                                                if ("gtscnppi".equals(str)) {
                                                                    return Integer.valueOf(c.a(this.f28031a).d().ao());
                                                                }
                                                                if ("ishmos".equals(str)) {
                                                                    return Boolean.valueOf(c.a(this.f28031a).d().ap());
                                                                }
                                                                if ("gthmosv".equals(str)) {
                                                                    return c.a(this.f28031a).d().aq();
                                                                }
                                                                if ("gthmosdtlv".equals(str)) {
                                                                    return c.a(this.f28031a).d().ar();
                                                                }
                                                                if ("gthmpmst".equals(str)) {
                                                                    return Integer.valueOf(c.a(this.f28031a).d().as());
                                                                }
                                                                if ("gthmepmst".equals(str)) {
                                                                    return Integer.valueOf(c.a(this.f28031a).d().at());
                                                                }
                                                                if ("gtinnerlangmt".equals(str)) {
                                                                    return c.a(this.f28031a).d().au();
                                                                }
                                                                if ("gtgramgendt".equals(str)) {
                                                                    return Integer.valueOf(c.a(this.f28031a).d().av());
                                                                }
                                                                if ("gtelcmefce".equals(str)) {
                                                                    return c.a(this.f28031a).d().a(objArr[0].intValue(), objArr[1].intValue(), objArr[2].booleanValue(), objArr[3].booleanValue());
                                                                } else if ("gtmwfo".equals(str)) {
                                                                    return c.a(this.f28031a).d().e(false);
                                                                } else {
                                                                    if ("wmcwifce".equals(str)) {
                                                                        if (objArr == null || objArr.length != 1) {
                                                                            throw new Throwable("params illegal: " + objArr);
                                                                        }
                                                                        return c.a(this.f28031a).d().e(objArr[0].booleanValue());
                                                                    } else if ("gtaifok".equals(str)) {
                                                                        return c.a(this.f28031a).d().al();
                                                                    } else {
                                                                        if ("gtmcdi".equals(str)) {
                                                                            return c.a(this.f28031a).d().a(false);
                                                                        }
                                                                        if ("gtmcdifce".equals(str)) {
                                                                            if (objArr == null || objArr.length != 1) {
                                                                                throw new Throwable("params illegal: " + objArr);
                                                                            }
                                                                            return c.a(this.f28031a).d().a(objArr[0].booleanValue());
                                                                        } else if ("gtmbcdi".equals(str)) {
                                                                            return c.a(this.f28031a).d().b(false);
                                                                        } else {
                                                                            if ("gtmbcdifce".equals(str)) {
                                                                                if (objArr == null || objArr.length != 1) {
                                                                                    throw new Throwable("params illegal: " + objArr);
                                                                                }
                                                                                return c.a(this.f28031a).d().b(objArr[0].booleanValue());
                                                                            } else if ("miwpy".equals(str)) {
                                                                                return Boolean.valueOf(c.a(this.f28031a).d().i());
                                                                            } else {
                                                                                if ("gtmnbclfo".equals(str)) {
                                                                                    return c.a(this.f28031a).d().q();
                                                                                }
                                                                                if ("ctedebbing".equals(str)) {
                                                                                    return Boolean.valueOf(c.a(this.f28031a).d().aw());
                                                                                }
                                                                                if ("gteacifo".equals(str)) {
                                                                                    return c.a(this.f28031a).d().ax();
                                                                                }
                                                                                if ("gtdm".equals(str)) {
                                                                                    if (objArr == null || objArr.length != 1) {
                                                                                        throw new Throwable("params illegal: " + objArr);
                                                                                    }
                                                                                    return c.a(this.f28031a).d().h(objArr[0].booleanValue());
                                                                                } else if (!"gtlstactme".equals(str)) {
                                                                                    return null;
                                                                                } else {
                                                                                    if (objArr == null || objArr.length != 1) {
                                                                                        throw new Throwable("params illegal: " + objArr);
                                                                                    }
                                                                                    return Long.valueOf(c.a(this.f28031a).d().f(objArr[0]));
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
            }
        }
    }

    public static final class SyncMtd {
        public static String Base64AES(String str, String str2) {
            return Data.Base64AES(str, str2);
        }

        public static boolean checkPermission(String str) {
            return c.a(MobSDK.getContext()).d().e(str);
        }

        public static Object currentActivityThread() {
            return v.b();
        }

        public static String getAppLanguage() {
            return c.a(MobSDK.getContext()).d().B();
        }

        public static int getAppVersion() {
            return c.a(MobSDK.getContext()).d().V();
        }

        public static String getAppVersionName() {
            return c.a(MobSDK.getContext()).d().W();
        }

        public static Context getApplication() {
            return c.a(MobSDK.getContext()).d().aa();
        }

        public static String getBrand() {
            return c.a(MobSDK.getContext()).d().n();
        }

        public static String getCurrentProcessName() {
            return c.a(MobSDK.getContext()).d().Y();
        }

        public static String getManufacturer() {
            return c.a(MobSDK.getContext()).d().m();
        }

        public static String getModel() {
            return c.a(MobSDK.getContext()).d().l();
        }

        public static String getOSCountry() {
            return c.a(MobSDK.getContext()).d().v();
        }

        public static String getOSLanguage() {
            return c.a(MobSDK.getContext()).d().u();
        }

        public static int getOSVersionInt() {
            return c.a(MobSDK.getContext()).d().s();
        }

        public static String getOSVersionName() {
            return c.a(MobSDK.getContext()).d().t();
        }

        public static String getPackageName() {
            return c.a(MobSDK.getContext()).d().T();
        }

        public static int getPlatformCode() {
            return 1;
        }

        public static String getSandboxPath() {
            return c.a(MobSDK.getContext()).d().R();
        }

        public static String getSystemProperties(String str) {
            return c.a(MobSDK.getContext()).d().a(str);
        }

        public static Object getSystemServiceSafe(String str) {
            return v.d(str);
        }

        public static String getTimezone() {
            return c.a(MobSDK.getContext()).d().I();
        }

        public static void hideSoftInput(View view) {
            v.a(view);
        }

        public static <T> T invokeInstanceMethod(Object obj, String str, Object... objArr) {
            return ReflectHelper.invokeInstanceMethodNoThrow(obj, str, null, objArr);
        }

        public static boolean isInMainProcess() {
            return c.a(MobSDK.getContext()).d().X();
        }

        public static void showSoftInput(View view) {
            v.b(view);
        }

        public static <T> T invokeInstanceMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
            try {
                return ReflectHelper.invokeInstanceMethod(obj, str, objArr, clsArr);
            } catch (Throwable th2) {
                if (th2 instanceof InvocationTargetException) {
                    String name = th2.getClass().getName();
                    String message = th2.getMessage();
                    Throwable cause = th2.getCause();
                    if (cause != null) {
                        name = cause.getClass().getName();
                        message = cause.getMessage();
                    }
                    NLog instance = MobLog.getInstance();
                    instance.d("Exception: " + name + l.f34627b + message, new Object[0]);
                    return null;
                } else if (th2 instanceof PackageManager.NameNotFoundException) {
                    NLog instance2 = MobLog.getInstance();
                    instance2.d("Exception: " + th2.getClass().getName() + l.f34627b + th2.getMessage(), new Object[0]);
                    return null;
                } else {
                    MobLog.getInstance().d(th2);
                    return null;
                }
            }
        }
    }

    public static RequestBuilder requester(Context context) {
        return new RequestBuilder(context);
    }
}
