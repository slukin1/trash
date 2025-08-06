package com.facebook.internal.instrument.crashreport;

import android.os.Process;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONArray;
import org.json.JSONException;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final int MAX_CRASH_REPORT_NUM = 5;
    private static final String TAG = CrashHandler.class.getCanonicalName();
    private static CrashHandler instance;
    private boolean mEndApplication = false;
    private final Thread.UncaughtExceptionHandler mPreviousHandler;

    private CrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.mPreviousHandler = uncaughtExceptionHandler;
    }

    public static synchronized void enable() {
        synchronized (CrashHandler.class) {
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                sendCrashReports();
            }
            if (instance != null) {
                Log.w(TAG, "Already enabled!");
                return;
            }
            CrashHandler crashHandler = new CrashHandler(Thread.getDefaultUncaughtExceptionHandler());
            instance = crashHandler;
            Thread.setDefaultUncaughtExceptionHandler(crashHandler);
        }
    }

    private static void killProcess() {
        try {
            Process.killProcess(Process.myPid());
            System.exit(10);
        } catch (Throwable unused) {
        }
    }

    private static void sendCrashReports() {
        File[] listCrashReportFiles = InstrumentUtility.listCrashReportFiles();
        final ArrayList arrayList = new ArrayList();
        int i11 = 0;
        for (File instrumentData : listCrashReportFiles) {
            InstrumentData instrumentData2 = new InstrumentData(instrumentData);
            if (instrumentData2.isValid()) {
                arrayList.add(instrumentData2);
            }
        }
        Collections.sort(arrayList, new Comparator<InstrumentData>() {
            public int compare(InstrumentData instrumentData, InstrumentData instrumentData2) {
                return instrumentData.compareTo(instrumentData2);
            }
        });
        JSONArray jSONArray = new JSONArray();
        while (i11 < arrayList.size() && i11 < 5) {
            jSONArray.put(arrayList.get(i11));
            i11++;
        }
        InstrumentUtility.sendReports("crash_reports", jSONArray, new GraphRequest.Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                try {
                    if (graphResponse.getError() == null && graphResponse.getJSONObject().getBoolean("success")) {
                        for (int i11 = 0; arrayList.size() > i11; i11++) {
                            ((InstrumentData) arrayList.get(i11)).clear();
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        });
    }

    public void endApplication() {
        this.mEndApplication = true;
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        if (InstrumentUtility.isSDKRelatedException(th2)) {
            new InstrumentData(th2, InstrumentData.Type.CrashReport).save();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mPreviousHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th2);
        }
        if (this.mEndApplication) {
            killProcess();
        }
    }
}
