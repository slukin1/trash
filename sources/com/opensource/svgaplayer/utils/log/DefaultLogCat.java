package com.opensource.svgaplayer.utils.log;

import android.util.Log;
import ay.a;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000e"}, d2 = {"Lcom/opensource/svgaplayer/utils/log/DefaultLogCat;", "Lay/a;", "", "tag", "msg", "", "info", "debug", "b", "", "error", "a", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class DefaultLogCat implements a {
    public void a(String str, String str2, Throwable th2) {
        Log.e(str, str2, th2);
    }

    public void b(String str, String str2) {
        Log.w(str, str2);
    }

    public void debug(String str, String str2) {
        Log.d(str, str2);
    }

    public void info(String str, String str2) {
        Log.i(str, str2);
    }
}
