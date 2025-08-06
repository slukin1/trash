package wn;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.bean.TitleDialogMenuItemBean;
import com.huobi.account.ui.SecurityStrategyBottomMenuFragment;
import com.huobi.account.ui.SecurityStrategyBottomMenuFragmentV2;
import com.huobi.account.ui.SecurityStrategyControllerAdapter;
import com.huobi.account.ui.SecurityStrategyControllerAdapterV2;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import i6.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pro.huobi.R;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final i f76690a;

    /* renamed from: b  reason: collision with root package name */
    public LoginInfoData.Login2FAOption f76691b;

    /* renamed from: c  reason: collision with root package name */
    public SecurityStrategyControllerAdapter f76692c;

    /* renamed from: d  reason: collision with root package name */
    public SecurityStrategyControllerAdapter f76693d;

    /* renamed from: e  reason: collision with root package name */
    public SecurityStrategyControllerAdapter f76694e;

    /* renamed from: f  reason: collision with root package name */
    public String f76695f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f76696g;

    /* renamed from: h  reason: collision with root package name */
    public List<SecurityStrategyControllerAdapter> f76697h;

    /* renamed from: i  reason: collision with root package name */
    public final List<LoginInfoData.Login2FAOption> f76698i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public final SecurityStrategyBottomMenuFragment f76699j = new SecurityStrategyBottomMenuFragment();

    /* renamed from: k  reason: collision with root package name */
    public final SecurityStrategyBottomMenuFragmentV2 f76700k = new SecurityStrategyBottomMenuFragmentV2();

    /* renamed from: l  reason: collision with root package name */
    public TitleDialogMenuItemBean.a<LoginInfoData.Login2FAOption> f76701l;

    public class a implements BaseDialogFragment.c {
        public a() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            f.this.f76690a.onDialogFragmentPause();
        }

        public void onDialogFragmentResume() {
        }
    }

    public class b extends SecurityStrategyControllerAdapter {

        /* renamed from: g  reason: collision with root package name */
        public boolean f76703g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f76704h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f76705i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f76706j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f76707k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ Map f76708l;

        public b(int i11, String str, String str2, String str3, Map map) {
            this.f76704h = i11;
            this.f76705i = str;
            this.f76706j = str2;
            this.f76707k = str3;
            this.f76708l = map;
        }

        public boolean A() {
            return !f.this.f76690a.I0();
        }

        public boolean B() {
            return f.this.f76690a.e() == null && C();
        }

        public boolean C() {
            return this.f76704h == 2;
        }

        public boolean G() {
            return true;
        }

        public void P() {
        }

        public void Q() {
            super.Q();
        }

        public void i(String str, String str2, String str3, String str4) {
            HashMap hashMap;
            super.i(str, str2, str3, str4);
            f.this.f76699j.Ji();
            if (this.f76708l != null) {
                hashMap = new HashMap(this.f76708l);
            } else {
                hashMap = new HashMap();
            }
            if (str == null || str.isEmpty()) {
                str = str2;
            }
            hashMap.put(SaveAccountLinkingTokenRequest.TOKEN_TYPE_AUTH_CODE, str);
            f.this.f76690a.d(str3, hashMap, this.f76707k);
        }

        public void j(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar) {
            if (!this.f76703g || f.this.f76690a.e() == null) {
                this.f76703g = true;
                super.j(securityStrategyBottomMenuFragment, gVar);
                return;
            }
            f.this.f76690a.c();
            securityStrategyBottomMenuFragment.dismiss();
        }

        public void k(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar, boolean z11) {
            if (!this.f76703g || f.this.f76690a.e() == null) {
                this.f76703g = true;
                super.k(securityStrategyBottomMenuFragment, gVar, z11);
                return;
            }
            f.this.f76690a.a();
            securityStrategyBottomMenuFragment.dismiss();
        }

        public String n() {
            return this.f76706j;
        }

        public String o() {
            return this.f76705i;
        }

        public Map<String, Object> p() {
            HashMap hashMap = new HashMap();
            hashMap.put("email", this.f76706j);
            if (f.this.f76690a.e() == null) {
                hashMap.put("use_type", "LOGIN");
            } else {
                hashMap.put("use_type", "THIRD_BIND");
            }
            Map map = this.f76708l;
            if (map != null) {
                Object obj = map.get("captcha_param");
                if (obj != null) {
                    hashMap.put("captcha_param", obj);
                }
                String str = (String) this.f76708l.get("captcha_key");
                if (str != null) {
                    hashMap.put("captcha_key", str);
                }
                String str2 = (String) this.f76708l.get("captcha_code");
                if (str2 != null) {
                    hashMap.put("captcha_code", str2);
                }
                Map map2 = (Map) this.f76708l.get("afs");
                if (map2 != null) {
                    hashMap.put("afs", map2);
                }
            }
            hashMap.put("token", this.f76707k);
            return hashMap;
        }

        public Map<String, Object> s() {
            HashMap hashMap = new HashMap();
            hashMap.put(PlaceFields.PHONE, this.f76705i);
            if (f.this.f76690a.e() == null) {
                hashMap.put("use_type", "LOGIN");
            } else {
                hashMap.put("use_type", "THIRD_BIND");
            }
            hashMap.put("token", this.f76707k);
            Map map = this.f76708l;
            if (map != null) {
                Object obj = map.get("captcha_param");
                if (obj != null) {
                    hashMap.put("captcha_param", obj);
                }
                String str = (String) this.f76708l.get("captcha_key");
                if (str != null) {
                    hashMap.put("captcha_key", str);
                }
                String str2 = (String) this.f76708l.get("captcha_code");
                if (str2 != null) {
                    hashMap.put("captcha_code", str2);
                }
                Map map2 = (Map) this.f76708l.get("afs");
                if (map2 != null) {
                    hashMap.put("afs", map2);
                }
            }
            hashMap.put("voice", Boolean.FALSE);
            return hashMap;
        }

        public boolean v() {
            return this.f76704h == 1;
        }

        public boolean w() {
            return f.this.f76690a.e() == null && x();
        }

        public boolean x() {
            return this.f76704h == 3;
        }

        public boolean y() {
            return this.f76704h == 1;
        }
    }

    public class c extends SecurityStrategyControllerAdapterV2 {

        /* renamed from: g  reason: collision with root package name */
        public boolean f76710g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f76711h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f76712i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f76713j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f76714k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ Map f76715l;

        public c(int i11, String str, String str2, String str3, Map map) {
            this.f76711h = i11;
            this.f76712i = str;
            this.f76713j = str2;
            this.f76714k = str3;
            this.f76715l = map;
        }

        public void E() {
        }

        public void F() {
            super.F();
        }

        public void f(String str, String str2, String str3, String str4) {
            HashMap hashMap;
            super.f(str, str2, str3, str4);
            f.this.f76699j.Ji();
            if (this.f76715l != null) {
                hashMap = new HashMap(this.f76715l);
            } else {
                hashMap = new HashMap();
            }
            if (str == null || str.isEmpty()) {
                str = str2;
            }
            hashMap.put(SaveAccountLinkingTokenRequest.TOKEN_TYPE_AUTH_CODE, str);
            f.this.f76690a.d(str3, hashMap, this.f76714k);
        }

        public void g(SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2, u6.g gVar) {
            if (!this.f76710g || f.this.f76690a.e() == null) {
                this.f76710g = true;
                super.g(securityStrategyBottomMenuFragmentV2, gVar);
                return;
            }
            f.this.f76690a.c();
            securityStrategyBottomMenuFragmentV2.dismiss();
        }

        public void h(SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2, u6.g gVar, boolean z11) {
            if (!this.f76710g || f.this.f76690a.e() == null) {
                this.f76710g = true;
                super.h(securityStrategyBottomMenuFragmentV2, gVar, z11);
                return;
            }
            f.this.f76690a.a();
            securityStrategyBottomMenuFragmentV2.dismiss();
        }

        public String k() {
            return this.f76713j;
        }

        public String l() {
            return this.f76712i;
        }

        public Map<String, Object> m() {
            HashMap hashMap = new HashMap();
            hashMap.put("email", this.f76713j);
            if (f.this.f76690a.e() == null) {
                hashMap.put("use_type", "LOGIN");
            } else {
                hashMap.put("use_type", "THIRD_BIND");
            }
            Map map = this.f76715l;
            if (map != null) {
                Object obj = map.get("captcha_param");
                if (obj != null) {
                    hashMap.put("captcha_param", obj);
                }
                String str = (String) this.f76715l.get("captcha_key");
                if (str != null) {
                    hashMap.put("captcha_key", str);
                }
                String str2 = (String) this.f76715l.get("captcha_code");
                if (str2 != null) {
                    hashMap.put("captcha_code", str2);
                }
                Map map2 = (Map) this.f76715l.get("afs");
                if (map2 != null) {
                    hashMap.put("afs", map2);
                }
            }
            hashMap.put("token", this.f76714k);
            return hashMap;
        }

        public Map<String, Object> o() {
            HashMap hashMap = new HashMap();
            hashMap.put(PlaceFields.PHONE, this.f76712i);
            if (f.this.f76690a.e() == null) {
                hashMap.put("use_type", "LOGIN");
            } else {
                hashMap.put("use_type", "THIRD_BIND");
            }
            hashMap.put("token", this.f76714k);
            Map map = this.f76715l;
            if (map != null) {
                Object obj = map.get("captcha_param");
                if (obj != null) {
                    hashMap.put("captcha_param", obj);
                }
                String str = (String) this.f76715l.get("captcha_key");
                if (str != null) {
                    hashMap.put("captcha_key", str);
                }
                String str2 = (String) this.f76715l.get("captcha_code");
                if (str2 != null) {
                    hashMap.put("captcha_code", str2);
                }
                Map map2 = (Map) this.f76715l.get("afs");
                if (map2 != null) {
                    hashMap.put("afs", map2);
                }
            }
            hashMap.put("voice", Boolean.FALSE);
            return hashMap;
        }

        public boolean p() {
            return this.f76711h == 1;
        }

        public boolean q() {
            return f.this.f76690a.e() == null && r();
        }

        public boolean r() {
            return this.f76711h == 3;
        }

        public boolean s() {
            return this.f76711h == 1;
        }

        public boolean u() {
            return !f.this.f76690a.I0();
        }

        public boolean v() {
            return f.this.f76690a.e() == null && w();
        }

        public boolean w() {
            return this.f76711h == 2;
        }

        public boolean y() {
            return true;
        }
    }

    public class d extends SecurityStrategyControllerAdapter {

        /* renamed from: g  reason: collision with root package name */
        public boolean f76717g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f76718h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f76719i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f76720j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ boolean f76721k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ String f76722l;

        /* renamed from: m  reason: collision with root package name */
        public final /* synthetic */ Map f76723m;

        public d(boolean z11, String str, String str2, boolean z12, String str3, Map map) {
            this.f76718h = z11;
            this.f76719i = str;
            this.f76720j = str2;
            this.f76721k = z12;
            this.f76722l = str3;
            this.f76723m = map;
        }

        public boolean A() {
            return !f.this.f76690a.I0();
        }

        public boolean C() {
            return !TextUtils.isEmpty(this.f76719i);
        }

        public boolean G() {
            return true;
        }

        public void P() {
        }

        public void Q() {
            super.Q();
        }

        public String Y() {
            return this.f76722l;
        }

        public void i(String str, String str2, String str3, String str4) {
            HashMap hashMap;
            super.i(str, str2, str3, str4);
            f.this.f76699j.Ji();
            if (this.f76723m != null) {
                hashMap = new HashMap(this.f76723m);
            } else {
                hashMap = new HashMap();
            }
            if (y()) {
                hashMap.put("ga_code", str3);
            }
            if (C()) {
                hashMap.put("sms_code", str2);
            }
            if (x()) {
                hashMap.put("email_code", str);
            }
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put(MTCoreConstants.Register.KEY_PASSWORD, MD5Utils.c(str4));
            }
            hashMap.put("login_version", 4);
            f.this.f76690a.b(hashMap, this.f76722l);
        }

        public void j(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar) {
            if (!this.f76717g || f.this.f76690a.e() == null) {
                this.f76717g = true;
                super.j(securityStrategyBottomMenuFragment, gVar);
                return;
            }
            f.this.f76690a.c();
            securityStrategyBottomMenuFragment.dismiss();
        }

        public void k(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar, boolean z11) {
            if (!this.f76717g || f.this.f76690a.e() == null) {
                this.f76717g = true;
                super.k(securityStrategyBottomMenuFragment, gVar, z11);
                return;
            }
            f.this.f76690a.a();
            securityStrategyBottomMenuFragment.dismiss();
        }

        public String n() {
            return this.f76720j;
        }

        public String o() {
            return this.f76719i;
        }

        public Map<String, Object> p() {
            HashMap hashMap = new HashMap();
            hashMap.put("email", this.f76720j);
            hashMap.put("use_type", "LOGIN");
            Map map = this.f76723m;
            if (map != null) {
                Object obj = map.get("captcha_param");
                if (obj != null) {
                    hashMap.put("captcha_param", obj);
                }
                String str = (String) this.f76723m.get("captcha_key");
                if (str != null) {
                    hashMap.put("captcha_key", str);
                }
                String str2 = (String) this.f76723m.get("captcha_code");
                if (str2 != null) {
                    hashMap.put("captcha_code", str2);
                }
                Map map2 = (Map) this.f76723m.get("afs");
                if (map2 != null) {
                    hashMap.put("afs", map2);
                }
            }
            hashMap.put("token", this.f76722l);
            return hashMap;
        }

        public Map<String, Object> s() {
            HashMap hashMap = new HashMap();
            hashMap.put(PlaceFields.PHONE, this.f76719i);
            hashMap.put("use_type", "LOGIN");
            hashMap.put("token", this.f76722l);
            Map map = this.f76723m;
            if (map != null) {
                Object obj = map.get("captcha_param");
                if (obj != null) {
                    hashMap.put("captcha_param", obj);
                }
                String str = (String) this.f76723m.get("captcha_key");
                if (str != null) {
                    hashMap.put("captcha_key", str);
                }
                String str2 = (String) this.f76723m.get("captcha_code");
                if (str2 != null) {
                    hashMap.put("captcha_code", str2);
                }
                Map map2 = (Map) this.f76723m.get("afs");
                if (map2 != null) {
                    hashMap.put("afs", map2);
                }
            }
            hashMap.put("voice", Boolean.FALSE);
            return hashMap;
        }

        public boolean v() {
            return this.f76718h;
        }

        public boolean x() {
            return !TextUtils.isEmpty(this.f76720j);
        }

        public boolean y() {
            return this.f76718h;
        }

        public boolean z() {
            return this.f76721k;
        }
    }

    public class e extends SecurityStrategyControllerAdapterV2 {

        /* renamed from: g  reason: collision with root package name */
        public boolean f76725g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f76726h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f76727i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f76728j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ boolean f76729k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ String f76730l;

        /* renamed from: m  reason: collision with root package name */
        public final /* synthetic */ Map f76731m;

        /* renamed from: n  reason: collision with root package name */
        public final /* synthetic */ String f76732n;

        public e(boolean z11, String str, String str2, boolean z12, String str3, Map map, String str4) {
            this.f76726h = z11;
            this.f76727i = str;
            this.f76728j = str2;
            this.f76729k = z12;
            this.f76730l = str3;
            this.f76731m = map;
            this.f76732n = str4;
        }

        public void E() {
            HashMap hashMap = new HashMap(3);
            hashMap.put("verification_way", this.f76732n);
            hashMap.put("pagetype", "2FA");
            hashMap.put("button_name", "ChangeVerification");
            gs.g.i("appClick_verification", hashMap);
        }

        public void F() {
            super.F();
        }

        public String J() {
            return this.f76730l;
        }

        public void f(String str, String str2, String str3, String str4) {
            HashMap hashMap;
            super.f(str, str2, str3, str4);
            f.this.f76699j.Ji();
            if (this.f76731m != null) {
                hashMap = new HashMap(this.f76731m);
            } else {
                hashMap = new HashMap();
            }
            if (s()) {
                hashMap.put("ga_code", str3);
            }
            if (w()) {
                hashMap.put("sms_code", str2);
            }
            if (r()) {
                hashMap.put("email_code", str);
            }
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put(MTCoreConstants.Register.KEY_PASSWORD, MD5Utils.c(str4));
            }
            hashMap.put("login_version", 4);
            f.this.f76690a.b(hashMap, this.f76730l);
        }

        public void g(SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2, u6.g gVar) {
            if (!this.f76725g || f.this.f76690a.e() == null) {
                this.f76725g = true;
                super.g(securityStrategyBottomMenuFragmentV2, gVar);
                return;
            }
            f.this.f76690a.c();
            securityStrategyBottomMenuFragmentV2.dismiss();
        }

        public void h(SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2, u6.g gVar, boolean z11) {
            if (!this.f76725g || f.this.f76690a.e() == null) {
                this.f76725g = true;
                super.h(securityStrategyBottomMenuFragmentV2, gVar, z11);
                return;
            }
            f.this.f76690a.a();
            securityStrategyBottomMenuFragmentV2.dismiss();
        }

        public String k() {
            return this.f76728j;
        }

        public String l() {
            return this.f76727i;
        }

        public Map<String, Object> m() {
            HashMap hashMap = new HashMap();
            hashMap.put("email", this.f76728j);
            hashMap.put("use_type", "LOGIN");
            Map map = this.f76731m;
            if (map != null) {
                Object obj = map.get("captcha_param");
                if (obj != null) {
                    hashMap.put("captcha_param", obj);
                }
                String str = (String) this.f76731m.get("captcha_key");
                if (str != null) {
                    hashMap.put("captcha_key", str);
                }
                String str2 = (String) this.f76731m.get("captcha_code");
                if (str2 != null) {
                    hashMap.put("captcha_code", str2);
                }
                Map map2 = (Map) this.f76731m.get("afs");
                if (map2 != null) {
                    hashMap.put("afs", map2);
                }
            }
            hashMap.put("token", this.f76730l);
            return hashMap;
        }

        public Map<String, Object> o() {
            HashMap hashMap = new HashMap();
            hashMap.put(PlaceFields.PHONE, this.f76727i);
            hashMap.put("use_type", "LOGIN");
            hashMap.put("token", this.f76730l);
            Map map = this.f76731m;
            if (map != null) {
                Object obj = map.get("captcha_param");
                if (obj != null) {
                    hashMap.put("captcha_param", obj);
                }
                String str = (String) this.f76731m.get("captcha_key");
                if (str != null) {
                    hashMap.put("captcha_key", str);
                }
                String str2 = (String) this.f76731m.get("captcha_code");
                if (str2 != null) {
                    hashMap.put("captcha_code", str2);
                }
                Map map2 = (Map) this.f76731m.get("afs");
                if (map2 != null) {
                    hashMap.put("afs", map2);
                }
            }
            hashMap.put("voice", Boolean.FALSE);
            return hashMap;
        }

        public boolean p() {
            return this.f76726h;
        }

        public boolean r() {
            return !TextUtils.isEmpty(this.f76728j);
        }

        public boolean s() {
            return this.f76726h;
        }

        public boolean t() {
            return this.f76729k;
        }

        public boolean u() {
            return !f.this.f76690a.I0();
        }

        public boolean w() {
            return !TextUtils.isEmpty(this.f76727i);
        }

        public boolean y() {
            return true;
        }
    }

    /* renamed from: wn.f$f  reason: collision with other inner class name */
    public class C0824f extends SecurityStrategyControllerAdapter {

        /* renamed from: g  reason: collision with root package name */
        public boolean f76734g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f76735h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f76736i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ SecurityStrategyBottomMenuFragment.h f76737j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ Map f76738k;

        public C0824f(String str, String str2, SecurityStrategyBottomMenuFragment.h hVar, Map map) {
            this.f76735h = str;
            this.f76736i = str2;
            this.f76737j = hVar;
            this.f76738k = map;
        }

        public boolean A() {
            return !f.this.f76690a.I0();
        }

        public boolean C() {
            return true;
        }

        public boolean D() {
            return true;
        }

        public boolean G() {
            return true;
        }

        public void Q() {
            super.Q();
        }

        public String Y() {
            return this.f76735h;
        }

        public void i(String str, String str2, String str3, String str4) {
            HashMap hashMap;
            super.i(str, str2, str3, str4);
            f.this.f76699j.Ji();
            if (this.f76738k != null) {
                hashMap = new HashMap(this.f76738k);
            } else {
                hashMap = new HashMap();
            }
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("sms_code", str2);
            }
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put(MTCoreConstants.Register.KEY_PASSWORD, MD5Utils.c(str4));
            }
            hashMap.put("login_version", 3);
            f.this.f76690a.d(str3, hashMap, f.this.f76695f);
        }

        public void k(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar, boolean z11) {
            if (!this.f76734g || f.this.f76690a.e() == null) {
                this.f76734g = true;
                super.k(securityStrategyBottomMenuFragment, gVar, z11);
                return;
            }
            f.this.f76690a.a();
            securityStrategyBottomMenuFragment.dismiss();
        }

        public String o() {
            return this.f76736i;
        }

        public Map<String, Object> s() {
            HashMap hashMap = new HashMap();
            hashMap.put(PlaceFields.PHONE, this.f76736i);
            if (f.this.f76690a.e() == null) {
                hashMap.put("use_type", "LOGIN");
            } else {
                hashMap.put("use_type", "THIRD_BIND");
            }
            hashMap.put("token", f.this.f76695f);
            Map map = this.f76738k;
            if (map != null) {
                String str = (String) map.get("captcha_key");
                if (str != null) {
                    hashMap.put("captcha_key", str);
                }
                String str2 = (String) this.f76738k.get("captcha_code");
                if (str2 != null) {
                    hashMap.put("captcha_code", str2);
                }
                Map map2 = (Map) this.f76738k.get("afs");
                if (map2 != null) {
                    hashMap.put("afs", map2);
                }
            }
            hashMap.put("voice", Boolean.FALSE);
            return hashMap;
        }

        public SecurityStrategyBottomMenuFragment.h t() {
            return this.f76737j;
        }

        public List<String> u() {
            return f.this.f76696g;
        }
    }

    public class g extends SecurityStrategyControllerAdapter {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f76740g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SecurityStrategyBottomMenuFragment.h f76741h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f76742i;

        public g(String str, SecurityStrategyBottomMenuFragment.h hVar, Map map) {
            this.f76740g = str;
            this.f76741h = hVar;
            this.f76742i = map;
        }

        public boolean A() {
            return !f.this.f76690a.I0();
        }

        public boolean D() {
            return true;
        }

        public boolean G() {
            return true;
        }

        public String Y() {
            return this.f76740g;
        }

        public void i(String str, String str2, String str3, String str4) {
            HashMap hashMap;
            super.i(str, str2, str3, str4);
            f.this.f76699j.Ji();
            if (this.f76742i != null) {
                hashMap = new HashMap(this.f76742i);
            } else {
                hashMap = new HashMap();
            }
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("ga_code", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put(MTCoreConstants.Register.KEY_PASSWORD, MD5Utils.c(str4));
            }
            hashMap.put("login_version", 3);
            f.this.f76690a.d(str3, hashMap, f.this.f76695f);
        }

        public SecurityStrategyBottomMenuFragment.h t() {
            return this.f76741h;
        }

        public List<String> u() {
            return f.this.f76696g;
        }

        public boolean v() {
            return true;
        }

        public boolean y() {
            return true;
        }
    }

    public class h extends SecurityStrategyControllerAdapter {

        /* renamed from: g  reason: collision with root package name */
        public boolean f76744g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f76745h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f76746i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ SecurityStrategyBottomMenuFragment.h f76747j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ Map f76748k;

        public h(String str, String str2, SecurityStrategyBottomMenuFragment.h hVar, Map map) {
            this.f76745h = str;
            this.f76746i = str2;
            this.f76747j = hVar;
            this.f76748k = map;
        }

        public boolean A() {
            return !f.this.f76690a.I0();
        }

        public boolean D() {
            return true;
        }

        public boolean G() {
            return true;
        }

        public void Q() {
            super.Q();
        }

        public String Y() {
            return this.f76745h;
        }

        public void i(String str, String str2, String str3, String str4) {
            HashMap hashMap;
            super.i(str, str2, str3, str4);
            f.this.f76699j.Ji();
            if (this.f76748k != null) {
                hashMap = new HashMap(this.f76748k);
            } else {
                hashMap = new HashMap();
            }
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("email_code", str);
            }
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put(MTCoreConstants.Register.KEY_PASSWORD, MD5Utils.c(str4));
            }
            hashMap.put("login_version", 3);
            f.this.f76690a.d(str3, hashMap, f.this.f76695f);
        }

        public void j(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar) {
            if (!this.f76744g || f.this.f76690a.e() == null) {
                this.f76744g = true;
                super.j(securityStrategyBottomMenuFragment, gVar);
                return;
            }
            f.this.f76690a.c();
            securityStrategyBottomMenuFragment.dismiss();
        }

        public String n() {
            return this.f76746i;
        }

        public Map<String, Object> p() {
            HashMap hashMap = new HashMap();
            hashMap.put("email", this.f76746i);
            if (f.this.f76690a.e() == null) {
                hashMap.put("use_type", "LOGIN");
            } else {
                hashMap.put("use_type", "THIRD_BIND");
            }
            Map map = this.f76748k;
            if (map != null) {
                String str = (String) map.get("captcha_key");
                if (str != null) {
                    hashMap.put("captcha_key", str);
                }
                String str2 = (String) this.f76748k.get("captcha_code");
                if (str2 != null) {
                    hashMap.put("captcha_code", str2);
                }
                Map map2 = (Map) this.f76748k.get("afs");
                if (map2 != null) {
                    hashMap.put("afs", map2);
                }
            }
            hashMap.put("token", f.this.f76695f);
            return hashMap;
        }

        public SecurityStrategyBottomMenuFragment.h t() {
            return this.f76747j;
        }

        public List<String> u() {
            return f.this.f76696g;
        }

        public boolean x() {
            return true;
        }
    }

    public interface i {
        boolean I0();

        void a();

        void b(HashMap<String, Object> hashMap, String str);

        void c();

        void d(String str, HashMap<String, Object> hashMap, String str2);

        String e();

        BaseActivity getActivity();

        String i();

        void onDialogFragmentPause();
    }

    public f(i iVar) {
        this.f76690a = iVar;
        n();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(View view, TitleDialogMenuItemBean titleDialogMenuItemBean, int i11) {
        LoginInfoData.Login2FAOption login2FAOption = (LoginInfoData.Login2FAOption) titleDialogMenuItemBean.getData();
        if (login2FAOption == null) {
            this.f76690a.getActivity().startActivity(sn.f.e0(this.f76690a.getActivity(), this.f76695f));
            return;
        }
        B(this.f76698i, this.f76695f, (Map<String, Object>) null, login2FAOption);
        this.f76691b = login2FAOption;
        this.f76699j.bi();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r(int i11) {
        this.f76699j.Ci(this.f76697h.get(i11));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(int i11) {
        this.f76699j.Ci(this.f76697h.get(i11));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(int i11) {
        this.f76699j.Ci(this.f76697h.get(i11));
    }

    public void A(List<LoginInfoData.Login2FAOption> list, String str, Map<String, Object> map) {
        w(map);
        B(list, str, map, (LoginInfoData.Login2FAOption) null);
    }

    public void B(List<LoginInfoData.Login2FAOption> list, String str, Map<String, Object> map, LoginInfoData.Login2FAOption login2FAOption) {
        this.f76695f = str;
        if ((!this.f76699j.isAdded() || login2FAOption != null) && !mz.a.g(list)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList<LoginInfoData.Login2FAOption> arrayList3 = new ArrayList<>();
            arrayList3.addAll(list);
            boolean z11 = login2FAOption != null;
            if (login2FAOption == null) {
                this.f76698i.clear();
                this.f76698i.addAll(arrayList3);
                login2FAOption = this.f76691b;
                if (login2FAOption == null) {
                    login2FAOption = (LoginInfoData.Login2FAOption) arrayList3.get(0);
                }
            }
            arrayList.add(login2FAOption);
            Collections.sort(arrayList3, e.f61436b);
            for (LoginInfoData.Login2FAOption login2FAOption2 : arrayList3) {
                if (login2FAOption2.getType() != login2FAOption.getType()) {
                    arrayList2.add(login2FAOption2);
                }
            }
            boolean z12 = false;
            boolean z13 = false;
            for (LoginInfoData.Login2FAOption next : list) {
                if (next.getType() == 2) {
                    z13 = true;
                } else if (next.getType() == 3) {
                    z12 = true;
                }
            }
            this.f76699j.yi(!z12 || !z13);
            o(arrayList2);
            this.f76696g = new ArrayList();
            this.f76697h = new ArrayList();
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                LoginInfoData.Login2FAOption login2FAOption3 = (LoginInfoData.Login2FAOption) arrayList.get(i11);
                int type = login2FAOption3.getType();
                if (type == 1) {
                    this.f76696g.add(m(R.string.n_new_user_login_verify_ga));
                    this.f76697h.add(k(map, str, new c(this)));
                } else if (type == 2) {
                    String tag = login2FAOption3.getTag();
                    this.f76696g.add(m(R.string.n_new_user_login_verify_phone));
                    this.f76697h.add(l(str, tag, map, new b(this)));
                } else if (type == 3) {
                    String tag2 = login2FAOption3.getTag();
                    this.f76696g.add(m(R.string.n_new_user_login_verify_email));
                    this.f76697h.add(j(str, tag2, map, new d(this)));
                }
            }
            this.f76699j.Ci(this.f76697h.get(0));
            if (!z11) {
                this.f76699j.xi(this.f76690a.i());
                FragmentTransaction q11 = this.f76690a.getActivity().getSupportFragmentManager().q();
                q11.e(this.f76699j, "BottomMenuFragment");
                q11.k();
            }
        }
    }

    public void C(boolean z11, String str, String str2, boolean z12, String str3, Map<String, Object> map, String str4) {
        w(map);
        if (!this.f76700k.isAdded()) {
            this.f76700k.li(false);
            this.f76700k.ni(new e(z11, str, str2, z12, str3, map, str4));
            this.f76700k.ki(this.f76690a.i());
            FragmentTransaction q11 = this.f76690a.getActivity().getSupportFragmentManager().q();
            q11.e(this.f76700k, "BottomMenuFragment");
            q11.k();
        }
    }

    public final SecurityStrategyControllerAdapter j(String str, String str2, Map<String, Object> map, SecurityStrategyBottomMenuFragment.h hVar) {
        if (this.f76692c == null) {
            this.f76692c = new h(str, str2, hVar, map);
        }
        return this.f76692c;
    }

    public final SecurityStrategyControllerAdapter k(Map<String, Object> map, String str, SecurityStrategyBottomMenuFragment.h hVar) {
        if (this.f76693d == null) {
            this.f76693d = new g(str, hVar, map);
        }
        return this.f76693d;
    }

    public final SecurityStrategyControllerAdapter l(String str, String str2, Map<String, Object> map, SecurityStrategyBottomMenuFragment.h hVar) {
        if (this.f76694e == null) {
            this.f76694e = new C0824f(str, str2, hVar, map);
        }
        return this.f76694e;
    }

    public final String m(int i11) {
        return this.f76690a.getActivity().getString(i11);
    }

    public final void n() {
        this.f76701l = new a(this);
        this.f76699j.setDialogFragmentListener(new a());
    }

    public final void o(List<LoginInfoData.Login2FAOption> list) {
        String str;
        ArrayList arrayList = new ArrayList();
        for (LoginInfoData.Login2FAOption next : list) {
            int type = next.getType();
            if (type == 2) {
                str = m(R.string.n_switch_to_the_sms_verification_code);
            } else if (type != 3) {
                str = m(R.string.n_switch_to_the_google_captcha);
            } else {
                str = m(R.string.n_switch_to_the_email_verification_code);
            }
            arrayList.add(new TitleDialogMenuItemBean(str, TitleDialogMenuItemBean.MenuItemStyle.COMMON, next, this.f76701l));
        }
        arrayList.add(new TitleDialogMenuItemBean(m(R.string.n_security_reset), TitleDialogMenuItemBean.MenuItemStyle.COMMON, null, this.f76701l));
        this.f76699j.Ai(arrayList);
    }

    public void u() {
        this.f76699j.dismiss();
        SoftInputUtils.f(this.f76690a.getActivity());
    }

    public void v() {
        this.f76699j.G0();
    }

    public final void w(Map<String, Object> map) {
        Object obj;
        boolean z11;
        String str;
        if (map != null && (obj = map.get("isKnowDevice")) != null) {
            try {
                z11 = ((Boolean) obj).booleanValue();
            } catch (Exception e11) {
                k.f("isKnowDevice to knowDevice", e11.toString());
                z11 = false;
            }
            if (z11) {
                str = m(R.string.security_google_verification);
            } else {
                str = m(R.string.n_verify_new_device_login);
            }
            this.f76699j.Gi(str);
        }
    }

    public void x(int i11, String str, String str2, String str3, Map<String, Object> map) {
        if (!this.f76699j.isAdded()) {
            this.f76699j.Ci(new b(i11, str, str2, str3, map));
            this.f76699j.xi(this.f76690a.i());
            FragmentTransaction q11 = this.f76690a.getActivity().getSupportFragmentManager().q();
            q11.e(this.f76699j, "BottomMenuFragment");
            q11.k();
        }
    }

    public void y(int i11, String str, String str2, String str3, Map<String, Object> map) {
        if (!this.f76700k.isAdded()) {
            this.f76700k.ni(new c(i11, str, str2, str3, map));
            this.f76700k.ki(this.f76690a.i());
            FragmentTransaction q11 = this.f76690a.getActivity().getSupportFragmentManager().q();
            q11.e(this.f76700k, "BottomMenuFragment");
            q11.k();
        }
    }

    public void z(boolean z11, String str, String str2, boolean z12, String str3, Map<String, Object> map) {
        w(map);
        if (!this.f76699j.isAdded()) {
            this.f76699j.yi(false);
            this.f76699j.Ci(new d(z11, str, str2, z12, str3, map));
            this.f76699j.xi(this.f76690a.i());
            FragmentTransaction q11 = this.f76690a.getActivity().getSupportFragmentManager().q();
            q11.e(this.f76699j, "BottomMenuFragment");
            q11.k();
        }
    }
}
