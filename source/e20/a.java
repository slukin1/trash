package e20;

import java.util.Calendar;

public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f54265b = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f54266c = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

    /* renamed from: a  reason: collision with root package name */
    public Calendar f54267a;

    public a(Calendar calendar) {
        this.f54267a = calendar;
    }

    public static final String c(int i11) {
        int i12 = i11 + 0;
        return (i12 < 0 || i12 >= 12) ? "" : f54265b[i12];
    }

    public static final String d(int i11) {
        String str = "";
        if (i11 < 10) {
            str = str + "0";
        }
        return String.valueOf(str) + Integer.toString(i11);
    }

    public static final String e(int i11) {
        int i12 = i11 - 1;
        return (i12 < 0 || i12 >= 7) ? "" : f54266c[i12];
    }

    public Calendar a() {
        return this.f54267a;
    }

    public String b() {
        Calendar a11 = a();
        return String.valueOf(e(a11.get(7))) + ", " + d(a11.get(5)) + " " + c(a11.get(2)) + " " + Integer.toString(a11.get(1)) + " " + d(a11.get(11)) + ":" + d(a11.get(12)) + ":" + d(a11.get(13)) + " GMT";
    }
}
