package androidx.constraintlayout.core.motion;

import com.huobi.webview2.action.JsCommonActionHelper;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f6723a;

    /* renamed from: b  reason: collision with root package name */
    public int f6724b;

    /* renamed from: c  reason: collision with root package name */
    public int f6725c;

    /* renamed from: d  reason: collision with root package name */
    public float f6726d;

    /* renamed from: e  reason: collision with root package name */
    public String f6727e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6728f;

    public static String a(int i11) {
        String str = JsCommonActionHelper.ACTION_BASE_INFO + Integer.toHexString(i11);
        return "#" + str.substring(str.length() - 8);
    }

    public boolean b() {
        int i11 = this.f6724b;
        return (i11 == 903 || i11 == 904 || i11 == 906) ? false : true;
    }

    public String toString() {
        String str = this.f6723a + ':';
        switch (this.f6724b) {
            case 900:
                return str + this.f6725c;
            case 901:
                return str + this.f6726d;
            case 902:
                return str + a(this.f6725c);
            case 903:
                return str + this.f6727e;
            case 904:
                return str + Boolean.valueOf(this.f6728f);
            case 905:
                return str + this.f6726d;
            default:
                return str + "????";
        }
    }
}
