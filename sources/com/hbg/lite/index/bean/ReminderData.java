package com.hbg.lite.index.bean;

import android.app.Activity;
import android.content.res.Resources;
import com.hbg.lite.R$string;
import java.util.Locale;

public class ReminderData {

    /* renamed from: a  reason: collision with root package name */
    public long f77076a;

    /* renamed from: b  reason: collision with root package name */
    public long f77077b;

    /* renamed from: c  reason: collision with root package name */
    public int f77078c;

    /* renamed from: d  reason: collision with root package name */
    public int f77079d;

    /* renamed from: e  reason: collision with root package name */
    public String f77080e;

    /* renamed from: f  reason: collision with root package name */
    public int f77081f;

    /* renamed from: g  reason: collision with root package name */
    public String f77082g;

    public boolean a(Object obj) {
        return obj instanceof ReminderData;
    }

    public String b() {
        return this.f77082g;
    }

    public String c() {
        return this.f77080e;
    }

    public String d(Activity activity) {
        String str;
        Resources resources = activity.getResources();
        if (this.f77078c == 1) {
            str = resources.getString(R$string.otc_reminder_sell);
        } else {
            str = resources.getString(R$string.otc_reminder_buy);
        }
        return str + " " + this.f77080e;
    }

    public long e() {
        return this.f77077b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReminderData)) {
            return false;
        }
        ReminderData reminderData = (ReminderData) obj;
        if (!reminderData.a(this) || k() != reminderData.k() || e() != reminderData.e() || j() != reminderData.j() || f() != reminderData.f()) {
            return false;
        }
        String c11 = c();
        String c12 = reminderData.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        if (h() != reminderData.h()) {
            return false;
        }
        String b11 = b();
        String b12 = reminderData.b();
        return b11 != null ? b11.equals(b12) : b12 == null;
    }

    public int f() {
        return this.f77079d;
    }

    public String g() {
        int i11 = this.f77079d;
        if (i11 < 0) {
            return "";
        }
        return String.format(Locale.US, "%02d:%02d", new Object[]{Integer.valueOf(i11 / 60), Integer.valueOf(this.f77079d % 60)});
    }

    public int h() {
        return this.f77081f;
    }

    public int hashCode() {
        long k11 = k();
        long e11 = e();
        int j11 = ((((((((int) (k11 ^ (k11 >>> 32))) + 59) * 59) + ((int) ((e11 >>> 32) ^ e11))) * 59) + j()) * 59) + f();
        String c11 = c();
        int i11 = 43;
        int hashCode = (((j11 * 59) + (c11 == null ? 43 : c11.hashCode())) * 59) + h();
        String b11 = b();
        int i12 = hashCode * 59;
        if (b11 != null) {
            i11 = b11.hashCode();
        }
        return i12 + i11;
    }

    public String i(Activity activity) {
        Resources resources = activity.getResources();
        if (this.f77078c == 1) {
            return resources.getString(R$string.otc_reminder_title_sell);
        }
        return resources.getString(R$string.n_otc_trade_order_status_not_pay_buy_show);
    }

    public int j() {
        return this.f77078c;
    }

    public long k() {
        return this.f77076a;
    }

    public void l(String str) {
        this.f77082g = str;
    }

    public void m(String str) {
        this.f77080e = str;
    }

    public void n(long j11) {
        this.f77077b = j11;
    }

    public void o(int i11) {
        this.f77079d = i11;
    }

    public void p(int i11) {
        this.f77081f = i11;
    }

    public void q(int i11) {
        this.f77078c = i11;
    }

    public void r(long j11) {
        this.f77076a = j11;
    }

    public String toString() {
        return "ReminderData(userId=" + k() + ", orderId=" + e() + ", tradeType=" + j() + ", remindTime=" + f() + ", coinName=" + c() + ", status=" + h() + ", coinIcon=" + b() + ")";
    }
}
