package com.hbg.lib.common.dynamic.manager;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.blankj.utilcode.util.l;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.dynamic.downloader.DyanmicConfig;
import com.hbg.lib.common.dynamic.downloader.Util;
import com.hbg.lib.common.dynamic.downloader.a;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import i6.k;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public abstract class HBDynamicBaseManager {

    /* renamed from: h  reason: collision with root package name */
    public static final List<a> f67443h = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f67444a = false;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f67445b = false;

    /* renamed from: c  reason: collision with root package name */
    public d6.a f67446c;

    /* renamed from: d  reason: collision with root package name */
    public int f67447d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67448e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67449f = false;

    /* renamed from: g  reason: collision with root package name */
    public SharedPreferences f67450g = null;

    public static void a(a aVar) {
        if (aVar != null) {
            f67443h.add(aVar);
        }
    }

    public static void c() {
        f67443h.clear();
    }

    public void b(String str) {
        String g11 = g();
        k.i(g11, "clearDynameVersion() called with: dynamicVersion = [" + str + "]", false);
        if (this.f67450g == null) {
            this.f67450g = BaseApplication.b().getSharedPreferences("huobipro_dynamic_app", 0);
        }
        SharedPreferences sharedPreferences = this.f67450g;
        File file = new File(sharedPreferences.getString(str + "_FolderMd5", ""));
        if (file.exists()) {
            l.c(file);
        }
        SharedPreferences.Editor edit = this.f67450g.edit();
        edit.putString(h() + BaseApplication.e() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + "Dynamic_Version", "");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("_FolderMd5");
        edit.putString(sb2.toString(), "");
        edit.putString(str + "_FolderPath", "");
        edit.putString(str + "_FolderUnZipName", "");
        edit.putLong(str + "_Time", 0);
        edit.apply();
    }

    public final String d(File file) {
        StringBuilder sb2 = new StringBuilder();
        List<File> k11 = l.k(file, true, (Comparator<File>) null);
        int size = k11.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (k11.get(i11).isFile()) {
                if (!this.f67449f) {
                    sb2.append(k11.get(i11).getName());
                    sb2.append(k11.get(i11).length());
                } else {
                    sb2.append(Util.c(k11.get(i11)));
                }
            }
        }
        return sb2.toString();
    }

    public abstract File e(String str);

    public String f() {
        if (this.f67450g == null) {
            this.f67450g = BaseApplication.b().getSharedPreferences("huobipro_dynamic_app", 0);
        }
        if (this.f67448e) {
            SharedPreferences sharedPreferences = this.f67450g;
            return sharedPreferences.getString(h() + BaseApplication.e() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + "Dynamic_Version_Old", "");
        }
        SharedPreferences sharedPreferences2 = this.f67450g;
        return sharedPreferences2.getString(h() + BaseApplication.e() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + "Dynamic_Version", "");
    }

    public String g() {
        return "DynamicBaseManager";
    }

    public abstract String h();

    public String i() {
        if (this.f67450g == null) {
            this.f67450g = BaseApplication.b().getSharedPreferences("huobipro_dynamic_app", 0);
        }
        SharedPreferences sharedPreferences = this.f67450g;
        return sharedPreferences.getString(f() + "_FolderUnZipName", "");
    }

    public void j() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!l()) {
            String f11 = f();
            if (TextUtils.isEmpty(f())) {
                this.f67447d = 2;
            } else if (!m(f11)) {
                this.f67447d = 0;
            } else {
                this.f67447d = 1;
                k();
                List<a> list = f67443h;
                if (!list.isEmpty()) {
                    for (a next : list) {
                        if (next.b().equals(h())) {
                            next.a(f11);
                        }
                    }
                }
            }
            if (Util.a()) {
                String g11 = g();
                Log.d(g11, "init() called  cost:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public abstract void k();

    public boolean l() {
        return this.f67447d == 1;
    }

    public boolean m(String str) {
        return !TextUtils.isEmpty(str);
    }

    public boolean n(DyanmicConfig.DynamicBaseBean dynamicBaseBean) {
        if (this.f67450g == null) {
            this.f67450g = BaseApplication.b().getSharedPreferences("huobipro_dynamic_app", 0);
        }
        SharedPreferences sharedPreferences = this.f67450g;
        String string = sharedPreferences.getString(h() + BaseApplication.e() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + "Dynamic_Version", "");
        if (!dynamicBaseBean.isEnable()) {
            b(string);
            k.i(g(), "isNeedUpdate(补丁不可用,清除本地补丁数据) called with: return = [false]", false);
            return false;
        } else if (TextUtils.isEmpty(string)) {
            k.i(g(), "isNeedUpdate(本地没有补丁时,直接就可认下载新的了) called with: return = [true]", false);
            return true;
        } else if (!string.equals(dynamicBaseBean.md5)) {
            k.i(g(), "isNeedUpdate(本地的补丁版本和新的补丁本版不一样,就需要更新) called with: return = [true]", false);
            return true;
        } else if (m(string)) {
            return false;
        } else {
            b(string);
            k.i(g(), "isNeedUpdate(本地的补丁版本和新的补丁本版一样,并且检查一下,本地补丁是不合法的) called with: return = [true]", false);
            return true;
        }
    }

    public void o(String str, File file, String str2, HashSet<String> hashSet) throws IOException {
        if (this.f67450g == null) {
            this.f67450g = BaseApplication.b().getSharedPreferences("huobipro_dynamic_app", 0);
        }
        if (!TextUtils.isEmpty(str) && file.exists()) {
            try {
                String d11 = Util.d(d(file).getBytes(StandardCharsets.UTF_8));
                String f11 = f();
                SharedPreferences.Editor edit = this.f67450g.edit();
                edit.putString(h() + BaseApplication.e() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + "Dynamic_Version", str);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("_FolderMd5");
                edit.putString(sb2.toString(), d11);
                edit.putString(str + "_FolderPath", file.getPath());
                edit.putString(str + "_FolderUnZipName", str2);
                edit.putStringSet(str + "_DEPENDENTS", hashSet);
                edit.putLong(str + "_Time", System.currentTimeMillis());
                edit.putString(h() + BaseApplication.e() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + "Dynamic_Version_Old", f11);
                edit.commit();
                this.f67448e = true;
            } catch (Exception e11) {
                k.h(g(), "setDynameVersion: Exception", e11, false);
                throw new IOException("补丁解压后的文件有问题,md5校验过程中有错误:" + e11.getMessage());
            }
        }
    }

    public void p(d6.a aVar) {
        this.f67446c = aVar;
    }
}
