package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.AmazonS3;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import java.util.ArrayList;

public class TransferNetworkLossHandler extends BroadcastReceiver {

    /* renamed from: d  reason: collision with root package name */
    public static final Log f14971d = LogFactory.b(TransferNetworkLossHandler.class);

    /* renamed from: e  reason: collision with root package name */
    public static TransferNetworkLossHandler f14972e;

    /* renamed from: a  reason: collision with root package name */
    public final ConnectivityManager f14973a;

    /* renamed from: b  reason: collision with root package name */
    public TransferDBUtil f14974b;

    /* renamed from: c  reason: collision with root package name */
    public TransferStatusUpdater f14975c;

    public TransferNetworkLossHandler(Context context) {
        this.f14973a = (ConnectivityManager) context.getSystemService("connectivity");
        this.f14974b = new TransferDBUtil(context);
        this.f14975c = TransferStatusUpdater.c(context);
    }

    public static synchronized TransferNetworkLossHandler c() throws TransferUtilityException {
        TransferNetworkLossHandler transferNetworkLossHandler;
        synchronized (TransferNetworkLossHandler.class) {
            transferNetworkLossHandler = f14972e;
            if (transferNetworkLossHandler == null) {
                f14971d.c("TransferNetworkLossHandler is not created. Please call `TransferNetworkLossHandler.getInstance(Context)` to instantiate it before retrieving");
                throw new TransferUtilityException("TransferNetworkLossHandler is not created. Please call `TransferNetworkLossHandler.getInstance(Context)` to instantiate it before retrieving");
            }
        }
        return transferNetworkLossHandler;
    }

    public static synchronized TransferNetworkLossHandler d(Context context) {
        TransferNetworkLossHandler transferNetworkLossHandler;
        synchronized (TransferNetworkLossHandler.class) {
            if (f14972e == null) {
                f14972e = new TransferNetworkLossHandler(context);
            }
            transferNetworkLossHandler = f14972e;
        }
        return transferNetworkLossHandler;
    }

    public boolean e() {
        NetworkInfo activeNetworkInfo = this.f14973a.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final synchronized void f() {
        for (TransferRecord next : this.f14975c.e().values()) {
            AmazonS3 a11 = S3ClientReference.a(Integer.valueOf(next.f14977a));
            if (a11 != null && next.e(a11, this.f14975c, this.f14973a)) {
                this.f14975c.j(next.f14977a, TransferState.WAITING_FOR_NETWORK);
            }
        }
    }

    public final synchronized void g() {
        TransferRecord d11;
        int i11 = 0;
        TransferState[] transferStateArr = {TransferState.WAITING_FOR_NETWORK};
        f14971d.h("Loading transfers from database...");
        Cursor cursor = null;
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            Cursor j11 = this.f14974b.j(TransferType.ANY, transferStateArr);
            while (j11.moveToNext()) {
                int i12 = j11.getInt(j11.getColumnIndexOrThrow("_id"));
                if (this.f14975c.d(i12) == null) {
                    TransferRecord transferRecord = new TransferRecord(i12);
                    transferRecord.g(j11);
                    this.f14975c.b(transferRecord);
                    i11++;
                }
                arrayList.add(Integer.valueOf(i12));
            }
            f14971d.h("Closing the cursor for resumeAllTransfers");
            j11.close();
            for (Integer num : arrayList) {
                AmazonS3 a11 = S3ClientReference.a(num);
                if (!(a11 == null || (d11 = this.f14975c.d(num.intValue())) == null || d11.d())) {
                    d11.f(a11, this.f14974b, this.f14975c, this.f14973a);
                }
            }
        } catch (Exception e11) {
            Log log = f14971d;
            log.c("Error in resuming the transfers." + e11.getMessage());
        } catch (Throwable th2) {
            if (cursor != null) {
                f14971d.h("Closing the cursor for resumeAllTransfers");
                cursor.close();
            }
            throw th2;
        }
        Log log2 = f14971d;
        log2.h(i11 + " transfers are loaded from database.");
    }

    public void onReceive(Context context, Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            Log log = f14971d;
            log.j("Network connectivity changed detected.");
            boolean e11 = e();
            log.j("Network connected: " + e11);
            new Thread(new Runnable() {
                public void run() {
                    if (TransferNetworkLossHandler.this.e()) {
                        TransferNetworkLossHandler.this.g();
                    } else {
                        TransferNetworkLossHandler.this.f();
                    }
                }
            }).start();
        }
    }
}
