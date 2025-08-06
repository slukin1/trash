package com.bbc876219.runtimestatis;

import android.os.FileObserver;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.bbc876219.lib.zlog.Log;
import com.tencent.thumbplayer.tcmedia.core.common.TPMediaCodecProfileLevel;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class IOWatchManager {

    /* renamed from: b  reason: collision with root package name */
    public static HashSet<String> f63268b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public static WatchState f63269c = WatchState.READY;

    /* renamed from: a  reason: collision with root package name */
    public List<a> f63270a;

    public enum WatchState {
        READY,
        STOP,
        WATCHING
    }

    public static class a extends FileObserver {

        /* renamed from: a  reason: collision with root package name */
        public String f63271a;

        public a(String str, int i11) {
            super(str, i11);
            Log.b("IOWatchManager", "SingleFileObserver() called with: path = [" + str + "], mask = [" + i11 + "]");
            this.f63271a = str;
        }

        public void onEvent(int i11, String str) {
            String str2 = this.f63271a + "/" + str;
            if (i11 == 1) {
                Log.f("IOWatchManager", "ACCESS: " + str2);
            } else if (i11 != 2) {
                switch (i11) {
                    case Integer.MIN_VALUE:
                        Log.f("IOWatchManager", "IN_ONESHOT: " + str2);
                        return;
                    case 4:
                        Log.f("IOWatchManager", "ATTRIB: " + str2);
                        return;
                    case 8:
                        Log.f("IOWatchManager", "CLOSE_WRITE: " + str2);
                        return;
                    case 16:
                    case 1073741840:
                        Log.f("IOWatchManager", "CLOSE_NOWRITE: " + str2);
                        return;
                    case 24:
                        Log.f("IOWatchManager", "IN_CLOSE(CLOSE_WRITE | CLOSE_NOWRITE): " + str2);
                        return;
                    case 32:
                    case 1073741856:
                        Log.f("IOWatchManager", "OPEN: " + str2);
                        return;
                    case 64:
                        Log.f("IOWatchManager", "MOVED_FROM: " + str2);
                        return;
                    case 128:
                        Log.f("IOWatchManager", "MOVED_TO: " + str2);
                        return;
                    case 192:
                        Log.f("IOWatchManager", "IN_CLOSE(MOVED_FROM | MOVED_TO): " + str2);
                        return;
                    case 256:
                        Log.f("IOWatchManager", "CREATE: " + str2);
                        return;
                    case 512:
                        Log.f("IOWatchManager", "DELETE: " + str2);
                        return;
                    case 1024:
                        Log.f("IOWatchManager", "DELETE_SELF: " + str2);
                        return;
                    case 2048:
                        Log.f("IOWatchManager", "MOVE_SELF: " + str2);
                        return;
                    case 4040:
                        Log.f("IOWatchManager", "CHANGES_ONLY: " + str2);
                        return;
                    case 4095:
                        Log.f("IOWatchManager", "ALL_EVENTS: " + str2);
                        return;
                    case 8192:
                        Log.f("IOWatchManager", "IN_UNMOUNT: " + str2);
                        return;
                    case 16384:
                        Log.f("IOWatchManager", "IN_Q_OVERFLOW: " + str2);
                        return;
                    case 32768:
                        Log.f("IOWatchManager", "IN_IGNORED: " + str2);
                        return;
                    case 16777216:
                        Log.f("IOWatchManager", "IN_ONLYDIR: " + str2);
                        return;
                    case TPMediaCodecProfileLevel.HEVCHighTierLevel62:
                        Log.f("IOWatchManager", "IN_DONT_FOLLOW: " + str2);
                        return;
                    case 536870912:
                        Log.f("IOWatchManager", "IN_MASK_ADD: " + str2);
                        return;
                    case 1073741824:
                        Log.f("IOWatchManager", "IN_ISDIR: " + str2);
                        return;
                    default:
                        Log.f("IOWatchManager", "DEFAULT(" + i11 + " : " + str2);
                        return;
                }
            } else {
                Log.f("IOWatchManager", "MODIFY: " + str2);
            }
        }
    }

    public static IOWatchManager d() {
        return new IOWatchManager();
    }

    public IOWatchManager a(File file) {
        if (!f63268b.contains(file.getAbsolutePath())) {
            Log.b("IOWatchManager", "addFile() called with: file = [" + file.getAbsolutePath() + "]");
            f63268b.add(file.getAbsolutePath());
        }
        return this;
    }

    public IOWatchManager b(String str) {
        Log.b("IOWatchManager", "addFile() called with: path = [" + str + "]");
        if (!TextUtils.isEmpty(str)) {
            a(new File(str));
        }
        return this;
    }

    public IOWatchManager c(String[] strArr) {
        for (String file : strArr) {
            a(new File(file));
        }
        return this;
    }

    public final void e() {
        if (f63269c == WatchState.WATCHING) {
            h();
            f63269c = WatchState.STOP;
        }
        Iterator<String> it2 = f63268b.iterator();
        while (it2.hasNext()) {
            if (g(new File(it2.next()).getPath(), 4095)) {
                f63269c = WatchState.STOP;
            }
        }
        f63269c = WatchState.WATCHING;
    }

    public IOWatchManager f() {
        if (f63269c != WatchState.WATCHING) {
            e();
        }
        return this;
    }

    public final boolean g(String str, int i11) {
        if (this.f63270a != null) {
            return true;
        }
        this.f63270a = new ArrayList();
        Stack stack = new Stack();
        stack.push(str);
        while (true) {
            if (stack.isEmpty()) {
                break;
            }
            String str2 = (String) stack.pop();
            this.f63270a.add(new a(str2, i11));
            File[] listFiles = new File(str2).listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file.isDirectory() && !file.getName().equals(InstructionFileId.DOT) && !file.getName().equals("..")) {
                        stack.push(file.getPath());
                    }
                }
            }
        }
        for (int i12 = 0; i12 < this.f63270a.size(); i12++) {
            this.f63270a.get(i12).startWatching();
        }
        return false;
    }

    public final void h() {
        Log.b("IOWatchManager", "stopWatching() called");
        if (this.f63270a != null) {
            for (int i11 = 0; i11 < this.f63270a.size(); i11++) {
                this.f63270a.get(i11).stopWatching();
            }
            this.f63270a.clear();
            this.f63270a = null;
        }
    }
}
