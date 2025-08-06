package com.mob.commons.cc;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import com.mob.commons.a.l;

public class c implements t<Context> {
    public boolean a(Context context, Class<Context> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if (l.a("016=fk=gj0fmfdgjMjg.egfmHgNekeeej6dg").equals(str) && objArr.length == 1 && (objArr[0] instanceof String)) {
            try {
                objArr2[0] = context.getSystemService(objArr[0]);
            } catch (Throwable th2) {
                objArr2[0] = null;
                thArr[0] = th2;
            }
            return true;
        } else if ("getApplicationInfo".equals(str) && objArr.length == 0) {
            objArr2[0] = context.getApplicationInfo();
            return true;
        } else if (l.a("018%fkNgj:feelYfjgfj-hk[gKgjel]h>eeRg0ek").equals(str) && objArr.length == 0) {
            objArr2[0] = context.getContentResolver();
            return true;
        } else if (l.a("014*fk+gj[hm[ed=fiJeCfkHgRfh5eTeg=g").equals(str) && objArr.length == 0) {
            objArr2[0] = context.getPackageName();
            return true;
        } else if (l.a("0170fk8gj;hmUedSfi4eKfkCg:idTefeFfk[gFek").equals(str) && objArr.length == 0) {
            objArr2[0] = context.getPackageManager();
            return true;
        } else if (l.a("013QgjOje+ekIj[geRdjSejeeejIj)fd").equals(str) && objArr.length == 1 && (objArr[0] instanceof Intent)) {
            context.startActivity(objArr[0]);
            return true;
        } else if (l.a("0115fk)gj3hdej0hgCgjgmejek").equals(str)) {
            objArr2[0] = context.getFilesDir();
            return true;
        } else if (l.a("009Sfk1gjQgegjgjUgjKgj").equals(str)) {
            objArr2[0] = context.getAssets();
            return true;
        } else if (l.a("019digd4fifmUghZfghm%g:ekegejgjgjejel4f").equals(str) && objArr.length == 1 && (objArr[0] instanceof String)) {
            if (Build.VERSION.SDK_INT >= 23) {
                objArr2[0] = Integer.valueOf(context.checkSelfPermission(objArr[0]));
            } else {
                objArr2[0] = Integer.valueOf(context.getPackageManager().checkPermission(objArr[0], context.getPackageName()));
            }
            return true;
        } else if (l.a("011Hggej)f=edfmCg5ekeeej-dg").equals(str) && objArr.length == 3) {
            objArr2[0] = Boolean.valueOf(context.bindService(objArr[0], objArr[1], objArr[2].intValue()));
            return true;
        } else if (!l.a("013)ehEfIggej!f=edfm[gDekeeej+dg").equals(str) || objArr.length != 1 || !(objArr[0] instanceof ServiceConnection)) {
            return false;
        } else {
            context.unbindService(objArr[0]);
            return true;
        }
    }
}
