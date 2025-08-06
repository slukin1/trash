package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.util.List;

public class OtcChatUnread implements Serializable {
    private List<ListBean> list;
    private long orderId;
    private int unread;

    public static class ListBean {

        /* renamed from: a  reason: collision with root package name */
        public String f70579a;

        /* renamed from: b  reason: collision with root package name */
        public int f70580b;

        /* renamed from: c  reason: collision with root package name */
        public int f70581c;

        /* renamed from: d  reason: collision with root package name */
        public String f70582d;

        /* renamed from: e  reason: collision with root package name */
        public long f70583e;

        /* renamed from: f  reason: collision with root package name */
        public long f70584f;

        /* renamed from: g  reason: collision with root package name */
        public int f70585g;

        /* renamed from: h  reason: collision with root package name */
        public int f70586h;

        /* renamed from: i  reason: collision with root package name */
        public String f70587i;

        public boolean a(Object obj) {
            return obj instanceof ListBean;
        }

        public String b() {
            return this.f70579a;
        }

        public int c() {
            return this.f70580b;
        }

        public int d() {
            return this.f70581c;
        }

        public String e() {
            return this.f70582d;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ListBean)) {
                return false;
            }
            ListBean listBean = (ListBean) obj;
            if (!listBean.a(this)) {
                return false;
            }
            String b11 = b();
            String b12 = listBean.b();
            if (b11 != null ? !b11.equals(b12) : b12 != null) {
                return false;
            }
            if (c() != listBean.c() || d() != listBean.d()) {
                return false;
            }
            String e11 = e();
            String e12 = listBean.e();
            if (e11 != null ? !e11.equals(e12) : e12 != null) {
                return false;
            }
            if (f() != listBean.f() || g() != listBean.g() || h() != listBean.h() || i() != listBean.i()) {
                return false;
            }
            String j11 = j();
            String j12 = listBean.j();
            return j11 != null ? j11.equals(j12) : j12 == null;
        }

        public long f() {
            return this.f70583e;
        }

        public long g() {
            return this.f70584f;
        }

        public int h() {
            return this.f70585g;
        }

        public int hashCode() {
            String b11 = b();
            int i11 = 43;
            int hashCode = (((((b11 == null ? 43 : b11.hashCode()) + 59) * 59) + c()) * 59) + d();
            String e11 = e();
            int hashCode2 = (hashCode * 59) + (e11 == null ? 43 : e11.hashCode());
            long f11 = f();
            int i12 = (hashCode2 * 59) + ((int) (f11 ^ (f11 >>> 32)));
            long g11 = g();
            int h11 = (((((i12 * 59) + ((int) (g11 ^ (g11 >>> 32)))) * 59) + h()) * 59) + i();
            String j11 = j();
            int i13 = h11 * 59;
            if (j11 != null) {
                i11 = j11.hashCode();
            }
            return i13 + i11;
        }

        public int i() {
            return this.f70586h;
        }

        public String j() {
            return this.f70587i;
        }

        public String toString() {
            return "OtcChatUnread.ListBean(chatContent=" + b() + ", chatContentType=" + c() + ", chatType=" + d() + ", gmtCreate=" + e() + ", id=" + f() + ", orderId=" + g() + ", receiveUserId=" + h() + ", uid=" + i() + ", userName=" + j() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OtcChatUnread;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcChatUnread)) {
            return false;
        }
        OtcChatUnread otcChatUnread = (OtcChatUnread) obj;
        if (!otcChatUnread.canEqual(this) || getOrderId() != otcChatUnread.getOrderId() || getUnread() != otcChatUnread.getUnread()) {
            return false;
        }
        List<ListBean> list2 = getList();
        List<ListBean> list3 = otcChatUnread.getList();
        return list2 != null ? list2.equals(list3) : list3 == null;
    }

    public List<ListBean> getList() {
        return this.list;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public int getUnread() {
        return this.unread;
    }

    public int hashCode() {
        long orderId2 = getOrderId();
        int unread2 = ((((int) (orderId2 ^ (orderId2 >>> 32))) + 59) * 59) + getUnread();
        List<ListBean> list2 = getList();
        return (unread2 * 59) + (list2 == null ? 43 : list2.hashCode());
    }

    public void setList(List<ListBean> list2) {
        this.list = list2;
    }

    public void setOrderId(long j11) {
        this.orderId = j11;
    }

    public void setUnread(int i11) {
        this.unread = i11;
    }

    public String toString() {
        return "OtcChatUnread(orderId=" + getOrderId() + ", unread=" + getUnread() + ", list=" + getList() + ")";
    }
}
