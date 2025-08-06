package com.tencent.a.a.a.a;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

final class b extends f {
    public b(Context context) {
        super(context);
    }

    public final boolean a() {
        return h.a(this.f40459e, PermissionConfig.WRITE_EXTERNAL_STORAGE) && Environment.getExternalStorageState().equals("mounted");
    }

    public final String b() {
        String str;
        synchronized (this) {
            Log.i("MID", "read mid from InternalStorage");
            try {
                Iterator<String> it2 = a.a(new File(Environment.getExternalStorageDirectory(), h.f("6X8Y4XdM2Vhvn0KfzcEatGnWaNU="))).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    String[] split = it2.next().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split.length == 2 && split[0].equals(h.f("4kU71lN96TJUomD1vOU9lgj9Tw=="))) {
                        Log.i("MID", "read mid from InternalStorage:" + split[1]);
                        str = split[1];
                        break;
                    }
                }
            } catch (IOException e11) {
                Log.w("MID", e11);
            }
            str = null;
        }
        return str;
    }

    public final void b(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to InternalStorage");
            a.a(Environment.getExternalStorageDirectory() + "/" + h.f("6X8Y4XdM2Vhvn0I="));
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Environment.getExternalStorageDirectory(), h.f("6X8Y4XdM2Vhvn0KfzcEatGnWaNU="))));
                bufferedWriter.write(h.f("4kU71lN96TJUomD1vOU9lgj9Tw==") + Constants.ACCEPT_TIME_SEPARATOR_SP + str);
                bufferedWriter.write("\n");
                bufferedWriter.close();
            } catch (Exception e11) {
                Log.w("MID", e11);
            }
        }
    }
}
