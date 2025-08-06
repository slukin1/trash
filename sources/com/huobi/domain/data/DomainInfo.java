package com.huobi.domain.data;

import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.huobi.domain.data.source.remote.bean.SmartDomain;
import com.huobi.domain.data.source.remote.bean.config.SmartRemoteDefaultConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DomainInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f43823a;

    /* renamed from: b  reason: collision with root package name */
    public int f43824b = 1;

    /* renamed from: c  reason: collision with root package name */
    public int f43825c;

    /* renamed from: d  reason: collision with root package name */
    public String f43826d;

    /* renamed from: e  reason: collision with root package name */
    public String f43827e;

    /* renamed from: f  reason: collision with root package name */
    public String f43828f;

    /* renamed from: g  reason: collision with root package name */
    public String f43829g;

    /* renamed from: h  reason: collision with root package name */
    public SmartDomain f43830h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f43831i;

    /* renamed from: j  reason: collision with root package name */
    public List<String> f43832j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public List<String> f43833k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public List<String> f43834l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    public List<String> f43835m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    public List<String> f43836n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public List<String> f43837o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    public List<String> f43838p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    public List<String> f43839q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    public List<String> f43840r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    public SmartRemoteDefaultConfig f43841s;

    /* renamed from: t  reason: collision with root package name */
    public HashMap<String, List<String>> f43842t = new HashMap<>();

    public void A(List<String> list) {
        this.f43842t.put("globalMobile", list);
        this.f43836n = list;
    }

    public void B(List<String> list) {
        this.f43842t.put("globalWeb", list);
        this.f43837o = list;
    }

    public void C(List<String> list) {
        this.f43842t.put("index", list);
        this.f43834l = list;
    }

    public void D(List<String> list) {
        this.f43842t.put("kycWeb", list);
        this.f43838p = list;
    }

    public void E(List<String> list) {
        this.f43842t.put("otc", list);
        this.f43833k = list;
    }

    public void F(List<String> list) {
        this.f43842t.put(RankScreenBean.SCREEN_VALUE_SPOT, list);
        this.f43832j = list;
    }

    public void G(int i11) {
        this.f43824b = i11;
    }

    public void H(int i11) {
        this.f43825c = i11;
    }

    public HashMap<String, List<String>> a() {
        return this.f43842t;
    }

    public String b() {
        return this.f43826d;
    }

    public String c() {
        return this.f43827e;
    }

    public String d() {
        return this.f43828f;
    }

    public String e() {
        return this.f43829g;
    }

    public SmartRemoteDefaultConfig f() {
        return this.f43841s;
    }

    public List<String> g() {
        return this.f43835m;
    }

    public List<String> h() {
        return this.f43839q;
    }

    public SmartDomain i() {
        return this.f43830h;
    }

    public List<String> j() {
        return this.f43836n;
    }

    public List<String> k() {
        return this.f43837o;
    }

    public List<String> l() {
        return this.f43834l;
    }

    public List<String> m() {
        return this.f43838p;
    }

    public List<String> n() {
        return this.f43833k;
    }

    public List<String> o() {
        return this.f43832j;
    }

    public void p(List<String> list) {
        this.f43842t.put("institution", list);
        this.f43840r = list;
    }

    public void q(String str) {
        this.f43826d = str;
    }

    public void r(String str) {
        this.f43827e = str;
    }

    public void s(String str) {
        this.f43828f = str;
    }

    public void t(String str) {
        this.f43829g = str;
    }

    public void u(boolean z11) {
        this.f43831i = z11;
    }

    public void v(String str) {
        this.f43823a = str;
    }

    public void w(SmartRemoteDefaultConfig smartRemoteDefaultConfig) {
        this.f43841s = smartRemoteDefaultConfig;
    }

    public void x(List<String> list) {
        this.f43842t.put("contract", list);
        this.f43835m = list;
    }

    public void y(List<String> list) {
        this.f43842t.put("dmH5", list);
        this.f43839q = list;
    }

    public void z(SmartDomain smartDomain) {
        this.f43830h = smartDomain;
    }
}
