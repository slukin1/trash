package com.mob.commons.eventrecoder;

import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.o;
import com.mob.commons.p;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.FileLocker;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public final class EventRecorder implements PublicMemberKeeper {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static File f27208a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static FileOutputStream f27209b;

    public static final synchronized void addBegin(String str, String str2) {
        synchronized (EventRecorder.class) {
            a(str + " " + str2 + " 0\n");
        }
    }

    public static final synchronized void addEnd(String str, String str2) {
        synchronized (EventRecorder.class) {
            a(str + " " + str2 + " 1\n");
        }
    }

    public static final synchronized String checkRecord(final String str) {
        synchronized (EventRecorder.class) {
            final LinkedList linkedList = new LinkedList();
            a((o) new o() {
                public boolean a(FileLocker fileLocker) {
                    int indexOf;
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(EventRecorder.f27208a), "utf-8"));
                        for (String readLine = bufferedReader.readLine(); !TextUtils.isEmpty(readLine); readLine = bufferedReader.readLine()) {
                            String[] split = readLine.split(" ");
                            if (str.equals(split[0])) {
                                if ("0".equals(split[2])) {
                                    linkedList.add(split[1]);
                                } else if ("1".equals(split[2]) && (indexOf = linkedList.indexOf(split[1])) != -1) {
                                    linkedList.remove(indexOf);
                                }
                            }
                        }
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        MobLog.getInstance().d(th2);
                    }
                    return false;
                }
            });
            if (linkedList.size() <= 0) {
                return null;
            }
            String str2 = (String) linkedList.get(0);
            return str2;
        }
    }

    public static final synchronized void clear() {
        synchronized (EventRecorder.class) {
            a((o) new o() {
                public boolean a(FileLocker fileLocker) {
                    try {
                        EventRecorder.f27209b.close();
                        EventRecorder.f27208a.delete();
                        File unused = EventRecorder.f27208a = new File(MobSDK.getContext().getFilesDir(), ".mrecord");
                        EventRecorder.f27208a.createNewFile();
                        FileOutputStream unused2 = EventRecorder.f27209b = new FileOutputStream(EventRecorder.f27208a, true);
                        return false;
                    } catch (Throwable th2) {
                        MobLog.getInstance().w(th2);
                        return false;
                    }
                }
            });
        }
    }

    public static final synchronized void prepare() {
        synchronized (EventRecorder.class) {
            a((o) new o() {
                public boolean a(FileLocker fileLocker) {
                    try {
                        File unused = EventRecorder.f27208a = new File(MobSDK.getContext().getFilesDir(), ".mrecord");
                        if (!EventRecorder.f27208a.exists()) {
                            EventRecorder.f27208a.createNewFile();
                        }
                        FileOutputStream unused2 = EventRecorder.f27209b = new FileOutputStream(EventRecorder.f27208a, true);
                        return false;
                    } catch (Throwable th2) {
                        MobLog.getInstance().w(th2);
                        return false;
                    }
                }
            });
        }
    }

    private static final void a(o oVar) {
        p.a(new File(MobSDK.getContext().getFilesDir(), p.f27288a), oVar);
    }

    private static final void a(final String str) {
        a((o) new o() {
            public boolean a(FileLocker fileLocker) {
                try {
                    EventRecorder.f27209b.write(str.getBytes("utf-8"));
                    EventRecorder.f27209b.flush();
                    return false;
                } catch (Throwable th2) {
                    MobLog.getInstance().w(th2);
                    return false;
                }
            }
        });
    }
}
