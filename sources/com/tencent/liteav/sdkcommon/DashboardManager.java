package com.tencent.liteav.sdkcommon;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.sdkcommon.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@JNINamespace("liteav::dashboard")
public class DashboardManager {
    private static final int LOG_MAX_SIZE = 15000;
    private static final String TAG = "DashboardManager";
    private final Context mAppContext;
    /* access modifiers changed from: private */
    public final Map<String, StringBuilder> mDashboardLogs = new HashMap();
    /* access modifiers changed from: private */
    public final g mDashboardManagerView;
    /* access modifiers changed from: private */
    public final Map<String, String> mDashboardStatus = new HashMap();
    /* access modifiers changed from: private */
    public final ArrayList<String> mDashboards = new ArrayList<>();
    private boolean mIsInit;
    private final g.a mSelectedDashboardChangeListener;
    /* access modifiers changed from: private */
    public String mSelectedDashboardId;
    private final Handler mUIHandler;

    public DashboardManager() {
        AnonymousClass1 r02 = new g.a() {
            public final void a(int i11) {
                if (DashboardManager.this.mDashboards.size() > i11) {
                    DashboardManager dashboardManager = DashboardManager.this;
                    String unused = dashboardManager.mSelectedDashboardId = (String) dashboardManager.mDashboards.get(i11);
                    if (DashboardManager.this.mDashboards.contains(DashboardManager.this.mSelectedDashboardId)) {
                        DashboardManager.this.mDashboardManagerView.b((String) DashboardManager.this.mDashboardStatus.get(DashboardManager.this.mSelectedDashboardId));
                        StringBuilder sb2 = (StringBuilder) DashboardManager.this.mDashboardLogs.get(DashboardManager.this.mSelectedDashboardId);
                        if (sb2 != null) {
                            DashboardManager.this.mDashboardManagerView.a(sb2.toString());
                        } else {
                            DashboardManager.this.mDashboardManagerView.a("");
                        }
                    }
                }
            }
        };
        this.mSelectedDashboardChangeListener = r02;
        LiteavLog.i(TAG, "java DashBoardManager Construct");
        this.mIsInit = false;
        Context applicationContext = ContextUtils.getApplicationContext();
        this.mAppContext = applicationContext;
        this.mDashboardManagerView = new g(applicationContext, r02);
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    /* access modifiers changed from: private */
    public void addDashboardInternal(String str) {
        if (!this.mDashboards.contains(str)) {
            this.mDashboards.add(str);
            g gVar = this.mDashboardManagerView;
            gVar.f21650e.add(str);
            if (gVar.f21657l == null) {
                gVar.f21657l = gVar.f21650e.getItem(0);
                gVar.f21660o.a(0);
            }
            gVar.a();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003e, code lost:
        r6 = r5.mDashboardManagerView;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void appendLogInternal(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.util.ArrayList<java.lang.String> r0 = r5.mDashboards
            boolean r0 = r0.contains(r6)
            if (r0 == 0) goto L_0x0080
            java.util.Map<java.lang.String, java.lang.StringBuilder> r0 = r5.mDashboardLogs
            java.lang.Object r0 = r0.get(r6)
            java.lang.StringBuilder r0 = (java.lang.StringBuilder) r0
            if (r0 != 0) goto L_0x001c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.util.Map<java.lang.String, java.lang.StringBuilder> r1 = r5.mDashboardLogs
            r1.put(r6, r0)
        L_0x001c:
            r0.append(r7)
            java.lang.String r1 = "\n"
            r0.append(r1)
            int r2 = r0.length()
            r3 = 15000(0x3a98, float:2.102E-41)
            r4 = 0
            if (r2 <= r3) goto L_0x0036
            int r2 = r0.length()
            int r2 = r2 / 2
            r0.delete(r4, r2)
        L_0x0036:
            java.lang.String r0 = r5.mSelectedDashboardId
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0080
            com.tencent.liteav.sdkcommon.g r6 = r5.mDashboardManagerView
            android.widget.TextView r0 = r6.f21654i
            if (r0 == 0) goto L_0x0080
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            r2.append(r1)
            java.lang.String r7 = r2.toString()
            r0.append(r7)
            android.widget.ScrollView r7 = r6.f21656k
            if (r7 == 0) goto L_0x0080
            int r7 = r7.getScrollY()
            android.widget.ScrollView r0 = r6.f21656k
            int r0 = r0.getHeight()
            int r7 = r7 + r0
            r0 = 100
            int r0 = r6.a((int) r0)
            int r7 = r7 + r0
            android.widget.TextView r0 = r6.f21654i
            int r0 = r0.getMeasuredHeight()
            if (r7 < r0) goto L_0x0075
            r4 = 1
        L_0x0075:
            if (r4 == 0) goto L_0x0080
            android.os.Handler r7 = r6.f21649d
            java.lang.Runnable r6 = com.tencent.liteav.sdkcommon.i.a(r6)
            r7.post(r6)
        L_0x0080:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.sdkcommon.DashboardManager.appendLogInternal(java.lang.String, java.lang.String):void");
    }

    private boolean checkPermission() {
        if (LiteavSystemInfo.getSystemOSVersionInt() <= 23 || Settings.canDrawOverlays(this.mAppContext)) {
            return true;
        }
        Toast.makeText(this.mAppContext, "no system alert window permission, please authorize", 0).show();
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean init() {
        /*
            r11 = this;
            boolean r0 = r11.mIsInit
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            com.tencent.liteav.sdkcommon.g r0 = r11.mDashboardManagerView
            android.content.Context r2 = r0.f21648c
            java.lang.String r3 = "DashboardManagerView"
            r4 = 0
            if (r2 != 0) goto L_0x0018
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.String r2 = "dashBoardManagerView context is null"
            com.tencent.liteav.base.Log.e(r3, r2, r0)
        L_0x0016:
            r0 = r4
            goto L_0x0043
        L_0x0018:
            java.lang.String r5 = "window"
            java.lang.Object r2 = r2.getSystemService(r5)
            android.view.WindowManager r2 = (android.view.WindowManager) r2
            r0.f21651f = r2
            if (r2 != 0) goto L_0x002c
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.String r2 = "get windowManager is fail"
            com.tencent.liteav.base.Log.e(r3, r2, r0)
            goto L_0x0016
        L_0x002c:
            android.view.Display r2 = r2.getDefaultDisplay()
            android.util.DisplayMetrics r3 = r0.f21646a
            r2.getMetrics(r3)
            android.util.DisplayMetrics r2 = r0.f21646a
            int r2 = r2.heightPixels
            r3 = 50
            int r3 = r0.a((int) r3)
            int r2 = r2 - r3
            r0.f21659n = r2
            r0 = r1
        L_0x0043:
            if (r0 != 0) goto L_0x0046
            return r4
        L_0x0046:
            com.tencent.liteav.sdkcommon.g r0 = r11.mDashboardManagerView
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            if (r2 < r3) goto L_0x0055
            android.view.WindowManager$LayoutParams r2 = r0.f21647b
            r3 = 2038(0x7f6, float:2.856E-42)
            r2.type = r3
            goto L_0x005b
        L_0x0055:
            android.view.WindowManager$LayoutParams r2 = r0.f21647b
            r3 = 2002(0x7d2, float:2.805E-42)
            r2.type = r3
        L_0x005b:
            android.view.WindowManager$LayoutParams r2 = r0.f21647b
            r2.format = r1
            r3 = 8388659(0x800033, float:1.1755015E-38)
            r2.gravity = r3
            android.util.DisplayMetrics r3 = r0.f21646a
            int r3 = r3.widthPixels
            r2.width = r3
            int r3 = r0.f21659n
            r2.height = r3
            r2.x = r4
            r2.y = r4
            r3 = 32
            r2.flags = r3
            android.widget.LinearLayout r2 = new android.widget.LinearLayout
            android.content.Context r3 = r0.f21648c
            r2.<init>(r3)
            android.view.ViewGroup$LayoutParams r3 = new android.view.ViewGroup$LayoutParams
            r5 = -1
            r3.<init>(r5, r5)
            r2.setLayoutParams(r3)
            r2.setOrientation(r1)
            com.tencent.liteav.sdkcommon.g$b r3 = new com.tencent.liteav.sdkcommon.g$b
            r3.<init>(r0, r4)
            r2.setOnTouchListener(r3)
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            r6 = 70
            int r6 = r0.a((int) r6)
            r7 = 40
            int r7 = r0.a((int) r7)
            r3.<init>(r6, r7)
            android.widget.Button r6 = new android.widget.Button
            android.content.Context r7 = r0.f21648c
            r6.<init>(r7)
            java.lang.String r7 = "Resize"
            r6.setText(r7)
            r6.setLayoutParams(r3)
            android.view.View$OnClickListener r7 = com.tencent.liteav.sdkcommon.j.a(r0, r6)
            r6.setOnClickListener(r7)
            android.widget.Button r7 = new android.widget.Button
            android.content.Context r8 = r0.f21648c
            r7.<init>(r8)
            java.lang.String r8 = "close"
            r7.setText(r8)
            r8 = 10
            int r9 = r0.a((int) r8)
            r3.leftMargin = r9
            r7.setLayoutParams(r3)
            android.view.View$OnClickListener r3 = com.tencent.liteav.sdkcommon.k.a(r0)
            r7.setOnClickListener(r3)
            android.widget.LinearLayout r3 = new android.widget.LinearLayout
            android.content.Context r9 = r0.f21648c
            r3.<init>(r9)
            r3.addView(r6)
            r3.addView(r7)
            android.view.ViewGroup$LayoutParams r6 = new android.view.ViewGroup$LayoutParams
            r7 = -2
            r6.<init>(r5, r7)
            r3.setLayoutParams(r6)
            r3.setOrientation(r4)
            r6 = -7829368(0xffffffffff888888, float:NaN)
            r3.setBackgroundColor(r6)
            r9 = 1056964608(0x3f000000, float:0.5)
            r3.setAlpha(r9)
            r2.addView(r3)
            android.widget.Spinner r3 = new android.widget.Spinner
            android.content.Context r10 = r0.f21648c
            r3.<init>(r10)
            r0.f21655j = r3
            android.widget.ArrayAdapter<java.lang.String> r10 = r0.f21650e
            r3.setAdapter(r10)
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            r10 = 30
            int r10 = r0.a((int) r10)
            r3.<init>(r5, r10)
            r10 = 2
            int r10 = r0.a((int) r10)
            r3.topMargin = r10
            android.widget.Spinner r10 = r0.f21655j
            r10.setLayoutParams(r3)
            android.widget.Spinner r3 = r0.f21655j
            com.tencent.liteav.sdkcommon.g$c r10 = new com.tencent.liteav.sdkcommon.g$c
            r10.<init>(r0, r4)
            r3.setOnItemSelectedListener(r10)
            android.widget.Spinner r3 = r0.f21655j
            r3.setBackgroundColor(r6)
            android.widget.Spinner r3 = r0.f21655j
            r3.setAlpha(r9)
            android.widget.Spinner r3 = r0.f21655j
            r2.addView(r3)
            android.widget.TextView r3 = new android.widget.TextView
            android.content.Context r6 = r0.f21648c
            r3.<init>(r6)
            r0.f21653h = r3
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            r6 = 160(0xa0, float:2.24E-43)
            int r6 = r0.a((int) r6)
            r3.<init>(r5, r6)
            int r6 = r0.a((int) r8)
            r3.topMargin = r6
            int r6 = r0.a((int) r8)
            r3.leftMargin = r6
            r6 = 3
            int r9 = r0.a((int) r6)
            r3.rightMargin = r9
            android.widget.TextView r9 = r0.f21653h
            r9.setLayoutParams(r3)
            android.widget.TextView r3 = r0.f21653h
            r9 = -65536(0xffffffffffff0000, float:NaN)
            r3.setTextColor(r9)
            android.widget.TextView r3 = r0.f21653h
            r2.addView(r3)
            android.widget.ScrollView r3 = new android.widget.ScrollView
            android.content.Context r10 = r0.f21648c
            r3.<init>(r10)
            r0.f21656k = r3
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            int r10 = r0.b()
            r3.<init>(r5, r10)
            int r8 = r0.a((int) r8)
            r3.leftMargin = r8
            int r6 = r0.a((int) r6)
            r3.rightMargin = r6
            android.widget.ScrollView r6 = r0.f21656k
            r6.setLayoutParams(r3)
            android.widget.ScrollView r3 = r0.f21656k
            r3.setVerticalScrollBarEnabled(r1)
            android.widget.TextView r3 = new android.widget.TextView
            android.content.Context r6 = r0.f21648c
            r3.<init>(r6)
            r0.f21654i = r3
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            r3.<init>(r5, r7)
            android.widget.TextView r5 = r0.f21654i
            r5.setLayoutParams(r3)
            android.widget.TextView r3 = r0.f21654i
            r3.setTextColor(r9)
            android.widget.ScrollView r3 = r0.f21656k
            android.widget.TextView r5 = r0.f21654i
            r3.addView(r5)
            android.widget.ScrollView r3 = r0.f21656k
            r5 = 130(0x82, float:1.82E-43)
            r3.fullScroll(r5)
            android.widget.ScrollView r3 = r0.f21656k
            r2.addView(r3)
            r0.f21652g = r2
            com.tencent.liteav.sdkcommon.g$a r0 = r0.f21660o
            r0.a(r4)
            r11.mIsInit = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.sdkcommon.DashboardManager.init():boolean");
    }

    /* access modifiers changed from: private */
    public void removeAllDashboardInternal() {
        this.mDashboards.clear();
        this.mDashboardStatus.clear();
        this.mDashboardLogs.clear();
        g gVar = this.mDashboardManagerView;
        gVar.f21650e.clear();
        gVar.f21657l = null;
        TextView textView = gVar.f21653h;
        if (textView != null) {
            textView.setText("");
        }
        TextView textView2 = gVar.f21654i;
        if (textView2 != null) {
            textView2.setText("");
        }
    }

    /* access modifiers changed from: private */
    public void removeDashboardInternal(String str) {
        if (this.mDashboards.contains(str)) {
            this.mDashboards.remove(str);
            this.mDashboardStatus.remove(str);
            this.mDashboardLogs.remove(str);
            g gVar = this.mDashboardManagerView;
            if (str.equals(gVar.f21657l)) {
                int position = gVar.f21650e.getPosition(gVar.f21657l);
                if (position != gVar.f21650e.getCount() - 1) {
                    int i11 = position + 1;
                    gVar.f21657l = gVar.f21650e.getItem(i11);
                    gVar.f21660o.a(i11 - 1);
                    Spinner spinner = gVar.f21655j;
                    if (spinner != null) {
                        spinner.setSelection(i11);
                    }
                } else if (position > 0) {
                    int i12 = position - 1;
                    gVar.f21657l = gVar.f21650e.getItem(i12);
                    gVar.f21660o.a(i12);
                    Spinner spinner2 = gVar.f21655j;
                    if (spinner2 != null) {
                        spinner2.setSelection(i12);
                    }
                }
            }
            gVar.f21650e.remove(str);
            if (gVar.f21650e.getCount() == 0) {
                gVar.f21657l = null;
            }
            gVar.a();
        }
    }

    /* access modifiers changed from: private */
    public void setStatusInternal(String str, String str2) {
        if (this.mDashboards.contains(str)) {
            this.mDashboardStatus.put(str, str2);
            if (str.equals(this.mSelectedDashboardId)) {
                this.mDashboardManagerView.b(str2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void showDashboardInternal(boolean z11) {
        if (!z11 || (checkPermission() && init())) {
            this.mDashboardManagerView.a(z11);
        } else {
            LiteavLog.i(TAG, "init or check permission is fail");
        }
    }

    public int addDashboard(String str) {
        LiteavLog.i(TAG, "addDashboard dashboardId = ".concat(String.valueOf(str)));
        this.mUIHandler.post(b.a(this, str));
        return 0;
    }

    public int appendLog(String str, String str2) {
        this.mUIHandler.post(f.a(this, str, str2));
        return 0;
    }

    public int removeAllDashboard() {
        LiteavLog.i(TAG, "removeAllDashboard ");
        this.mUIHandler.post(d.a(this));
        return 0;
    }

    public int removeDashboard(String str) {
        LiteavLog.i(TAG, "removeDashboard dashboardId = ".concat(String.valueOf(str)));
        this.mUIHandler.post(c.a(this, str));
        return 0;
    }

    public int setStatus(String str, String str2) {
        this.mUIHandler.post(e.a(this, str, str2));
        return 0;
    }

    public int showDashboard(boolean z11) {
        LiteavLog.i(TAG, "showDashBoard isShow = ".concat(String.valueOf(z11)));
        this.mUIHandler.post(a.a(this, z11));
        return 0;
    }
}
