package bq;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class a extends BroadcastReceiver {
    public static void a(Context context) {
        context.sendBroadcast(new Intent("com.huobi.permission.bridge"));
    }
}
