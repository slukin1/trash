package com.dianping.logan;

public class LoganModel {

    /* renamed from: a  reason: collision with root package name */
    public Action f64840a;

    /* renamed from: b  reason: collision with root package name */
    public g f64841b;

    /* renamed from: c  reason: collision with root package name */
    public f f64842c;

    public enum Action {
        WRITE,
        SEND,
        FLUSH
    }

    public boolean a() {
        g gVar;
        f fVar;
        Action action = this.f64840a;
        if (action != null) {
            if (action == Action.SEND && (fVar = this.f64842c) != null && fVar.a()) {
                return true;
            }
            if ((this.f64840a != Action.WRITE || (gVar = this.f64841b) == null || !gVar.a()) && this.f64840a != Action.FLUSH) {
                return false;
            }
            return true;
        }
        return false;
    }
}
