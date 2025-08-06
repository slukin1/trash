package com.bbc876219.runtimestatis;

import androidx.annotation.Keep;
import com.bbc876219.lib.zlog.ZLog;

@Keep
public interface IRunTimeStatisHandler {
    public static final IRunTimeStatisHandler DEFAULT = new a();

    public static class a implements IRunTimeStatisHandler {

        /* renamed from: a  reason: collision with root package name */
        public boolean f63272a = false;

        public void clear() {
        }

        public String dump() {
            return "";
        }

        public boolean isStatisticSubThread() {
            return this.f63272a;
        }

        public void setStatisticSubThread(boolean z11) {
            this.f63272a = z11;
        }

        public void statisticMethod(String str, int i11) {
            if (i11 >= threshold()) {
                ZLog.g("Default-IBlockHandler", str + " costed " + i11);
            }
        }

        public int threshold() {
            return 100;
        }
    }

    void clear();

    String dump();

    boolean isStatisticSubThread();

    void setStatisticSubThread(boolean z11);

    void statisticMethod(String str, int i11);

    int threshold();
}
