package com.huawei.secure.android.common.ssl.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import java.io.InputStream;
import lg.a;

public class c extends AsyncTask<Context, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38656a = c.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f38657b = false;

    @SuppressLint({"NewApi"})
    public static void b() {
        if (e()) {
            e.e(f38656a, "checkUpgradeBks, execute check task");
            new c().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Context[]{ContextUtil.a()});
        }
    }

    public static boolean e() {
        if (f38657b) {
            return false;
        }
        Context a11 = ContextUtil.a();
        if (a11 == null) {
            e.f(f38656a, "checkUpgradeBks, context is null");
            return false;
        }
        f38657b = true;
        long a12 = g.a("lastCheckTime", 0, a11);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - a12 > 432000000) {
            g.d("lastCheckTime", currentTimeMillis, a11);
            return true;
        }
        e.e(f38656a, "checkUpgradeBks, ignore");
        return false;
    }

    /* renamed from: a */
    public Boolean doInBackground(Context... contextArr) {
        InputStream inputStream;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            inputStream = a.m(contextArr[0]);
        } catch (Exception e11) {
            String str = f38656a;
            e.d(str, "doInBackground: exception : " + e11.getMessage());
            inputStream = null;
        }
        String str2 = f38656a;
        e.b(str2, "doInBackground: get bks from hms tss cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        if (inputStream == null) {
            return Boolean.FALSE;
        }
        d.b(inputStream);
        return Boolean.TRUE;
    }

    /* renamed from: c */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            e.e(f38656a, "onPostExecute: upate done");
        } else {
            e.d(f38656a, "onPostExecute: upate failed");
        }
    }

    /* renamed from: d */
    public void onProgressUpdate(Integer... numArr) {
        e.e(f38656a, "onProgressUpdate");
    }

    public void onPreExecute() {
        e.b(f38656a, "onPreExecute");
    }
}
