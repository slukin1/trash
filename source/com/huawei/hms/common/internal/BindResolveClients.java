package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.ListIterator;

public class BindResolveClients {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f37914b = new Object();

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<ResolveClientBean> f37915a;

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final BindResolveClients f37916a = new BindResolveClients();
    }

    public static BindResolveClients getInstance() {
        return b.f37916a;
    }

    public boolean isClientRegistered(ResolveClientBean resolveClientBean) {
        boolean contains;
        synchronized (f37914b) {
            contains = this.f37915a.contains(resolveClientBean);
        }
        return contains;
    }

    public void notifyClientReconnect() {
        synchronized (f37914b) {
            ListIterator<ResolveClientBean> listIterator = this.f37915a.listIterator();
            while (listIterator.hasNext()) {
                listIterator.next().clientReconnect();
            }
            this.f37915a.clear();
        }
    }

    public void register(ResolveClientBean resolveClientBean) {
        if (resolveClientBean != null) {
            synchronized (f37914b) {
                if (!this.f37915a.contains(resolveClientBean)) {
                    this.f37915a.add(resolveClientBean);
                }
            }
        }
    }

    public void unRegister(ResolveClientBean resolveClientBean) {
        if (resolveClientBean != null) {
            synchronized (f37914b) {
                if (this.f37915a.contains(resolveClientBean)) {
                    ListIterator<ResolveClientBean> listIterator = this.f37915a.listIterator();
                    while (true) {
                        if (listIterator.hasNext()) {
                            if (resolveClientBean.equals(listIterator.next())) {
                                listIterator.remove();
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    public void unRegisterAll() {
        synchronized (f37914b) {
            this.f37915a.clear();
        }
    }

    private BindResolveClients() {
        this.f37915a = new ArrayList<>();
    }
}
