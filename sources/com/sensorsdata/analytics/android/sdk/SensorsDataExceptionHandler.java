package com.sensorsdata.analytics.android.sdk;

import android.os.Process;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class SensorsDataExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final int SLEEP_TIMEOUT_MS = 500;
    private static boolean isTrackCrash = false;
    private static final ArrayList<SAExceptionListener> sExceptionListeners = new ArrayList<>();
    private static SensorsDataExceptionHandler sInstance;
    private Thread.UncaughtExceptionHandler mDefaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();

    public interface SAExceptionListener {
        void uncaughtException(Thread thread, Throwable th2);
    }

    private SensorsDataExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static void addExceptionListener(SAExceptionListener sAExceptionListener) {
        if (sAExceptionListener != null) {
            ArrayList<SAExceptionListener> arrayList = sExceptionListeners;
            if (!arrayList.contains(sAExceptionListener)) {
                arrayList.add(sAExceptionListener);
            }
        }
    }

    public static void enableAppCrash() {
        isTrackCrash = true;
    }

    public static synchronized void init() {
        synchronized (SensorsDataExceptionHandler.class) {
            if (sInstance == null) {
                sInstance = new SensorsDataExceptionHandler();
            }
        }
    }

    private void killProcessAndExit() {
        try {
            Process.killProcess(Process.myPid());
            System.exit(10);
        } catch (Exception unused) {
        }
    }

    public static void removeExceptionListener(SAExceptionListener sAExceptionListener) {
        if (sAExceptionListener != null) {
            ArrayList<SAExceptionListener> arrayList = sExceptionListeners;
            if (arrayList.contains(sAExceptionListener)) {
                arrayList.remove(sAExceptionListener);
            }
        }
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        try {
            if (isTrackCrash) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        StringWriter stringWriter = new StringWriter();
                        PrintWriter printWriter = new PrintWriter(stringWriter);
                        th2.printStackTrace(printWriter);
                        for (Throwable cause = th2.getCause(); cause != null; cause = cause.getCause()) {
                            cause.printStackTrace(printWriter);
                        }
                        printWriter.close();
                        jSONObject.put("app_crashed_reason", stringWriter.toString());
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                    SensorsDataAPI.sharedInstance().trackEvent(EventType.TRACK, "AppCrashed", jSONObject, (String) null);
                } catch (Exception e12) {
                    SALog.printStackTrace(e12);
                }
            }
            Iterator<SAExceptionListener> it2 = sExceptionListeners.iterator();
            while (it2.hasNext()) {
                try {
                    it2.next().uncaughtException(thread, th2);
                } catch (Exception e13) {
                    SALog.printStackTrace(e13);
                }
            }
            SensorsDataAPI.sharedInstance().flush();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e14) {
                SALog.printStackTrace(e14);
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mDefaultExceptionHandler;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th2);
            } else {
                killProcessAndExit();
            }
        } catch (Exception unused) {
        }
    }
}
