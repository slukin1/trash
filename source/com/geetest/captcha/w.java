package com.geetest.captcha;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u001e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u000bJ\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000bJ\u0010\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0019\u001a\u00020\u0007J\u0010\u0010\u001a\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/geetest/captcha/observer/WebViewObservable;", "", "()V", "mObservers", "Ljava/util/ArrayList;", "Lcom/geetest/captcha/observer/WebViewObserver;", "onCallReady", "", "onClose", "onError", "errorCode", "", "errorMsg", "errorDesc", "Lorg/json/JSONObject;", "onResult", "status", "", "result", "onWebError", "error", "onWebFailure", "fail", "registerObserver", "observer", "unregisterAll", "unregisterObserver", "captcha_release"}, k = 1, mv = {1, 1, 16})
public final class w {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<x> f65280a = new ArrayList<>();

    public final void a(x xVar) {
        if (xVar != null) {
            synchronized (this.f65280a) {
                if (!this.f65280a.contains(xVar)) {
                    this.f65280a.add(xVar);
                } else {
                    throw new IllegalStateException(("Observer " + xVar + " is already registered.").toString());
                }
            }
            return;
        }
        throw new IllegalArgumentException("The observer is null.".toString());
    }

    public final void b() {
        Iterator<x> it2 = this.f65280a.iterator();
        while (it2.hasNext()) {
            it2.next().b();
        }
    }

    public final void a() {
        Iterator<x> it2 = this.f65280a.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    public final void a(String str) {
        Iterator<x> it2 = this.f65280a.iterator();
        while (it2.hasNext()) {
            it2.next().a(str);
        }
    }

    public final void a(String str, String str2, JSONObject jSONObject) {
        Iterator<x> it2 = this.f65280a.iterator();
        while (it2.hasNext()) {
            it2.next().a(str, str2, jSONObject);
        }
    }

    public final void a(boolean z11, String str) {
        Iterator<x> it2 = this.f65280a.iterator();
        while (it2.hasNext()) {
            it2.next().a(z11, str);
        }
    }
}
