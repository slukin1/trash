package com.huobi.account.bean;

import android.text.TextUtils;
import com.hbg.lib.network.hbg.core.bean.RewardInfo;
import com.huobi.account.handler.KnapsackHandler;
import java.util.ArrayList;
import java.util.List;
import s9.a;

public class KnapsackItem {

    /* renamed from: a  reason: collision with root package name */
    public RewardInfo f40962a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<BagItem> f40963b = new ArrayList<>();

    public static class BagItem implements a {

        /* renamed from: b  reason: collision with root package name */
        public String f40964b;

        /* renamed from: c  reason: collision with root package name */
        public String f40965c;

        /* renamed from: d  reason: collision with root package name */
        public String f40966d;

        /* renamed from: e  reason: collision with root package name */
        public String f40967e;

        /* renamed from: f  reason: collision with root package name */
        public String f40968f;

        /* renamed from: g  reason: collision with root package name */
        public int f40969g;

        /* renamed from: h  reason: collision with root package name */
        public String f40970h;

        public String a() {
            if (!TextUtils.isEmpty(this.f40965c)) {
                return this.f40965c;
            }
            return this.f40964b;
        }

        public String c() {
            return this.f40968f;
        }

        public String d() {
            return this.f40970h;
        }

        public String e() {
            return this.f40964b;
        }

        public String f() {
            return this.f40967e;
        }

        public void g(String str) {
            this.f40968f = str;
        }

        public String getViewHandlerName() {
            return KnapsackHandler.class.getName();
        }

        public void h(String str) {
            this.f40966d = str;
        }

        public void i(String str) {
            this.f40970h = str;
        }

        public void j(String str) {
            this.f40964b = str;
        }

        public void k(int i11) {
            this.f40969g = i11;
        }

        public void l(String str) {
            this.f40967e = str;
        }
    }

    public List<BagItem> a() {
        return this.f40963b;
    }

    public boolean b() {
        return this.f40962a.getHasUpdate();
    }

    public String c() {
        return this.f40962a.getTitle();
    }

    public String d() {
        return this.f40962a.getUri();
    }

    public void e(RewardInfo rewardInfo) {
        this.f40962a = rewardInfo;
        if (!(rewardInfo == null || rewardInfo.getBagItems() == null)) {
            for (RewardInfo.BagItemsBean next : rewardInfo.getBagItems()) {
                BagItem bagItem = new BagItem();
                bagItem.j(next.getTitle());
                bagItem.h(next.getIcon());
                bagItem.l(next.getUri());
                bagItem.g(next.getCount());
                bagItem.k(next.getType());
                bagItem.i(next.getIncrementalValue());
                this.f40963b.add(bagItem);
            }
        }
        if (this.f40963b.size() % 4 != 0) {
            for (int i11 = 0; i11 < this.f40963b.size() % 4; i11++) {
                this.f40963b.add(new BagItem());
            }
        }
    }
}
