package zendesk.belvedere;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import zendesk.belvedere.BelvedereUi;
import zendesk.belvedere.b;
import zendesk.belvedere.c;
import zendesk.belvedere.i;
import zendesk.belvedere.ui.R$string;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public final f30.b f62297a;

    /* renamed from: b  reason: collision with root package name */
    public final e f62298b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageStream f62299c;

    /* renamed from: d  reason: collision with root package name */
    public final b.C0682b f62300d = new e();

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            f.this.f62298b.i(f.this.f62297a.g(), f.this.f62299c);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (Build.VERSION.SDK_INT >= 33) {
                f.this.m();
            } else {
                f.this.f62298b.i(f.this.f62297a.l(), f.this.f62299c);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements i.c {
        public c() {
        }

        public void a(Map<String, Boolean> map) {
            for (Map.Entry next : map.entrySet()) {
                if (!Objects.equals(next.getKey(), PermissionConfig.READ_MEDIA_AUDIO) || !((Boolean) next.getValue()).booleanValue()) {
                    f.this.h();
                } else {
                    f.this.f62298b.i(f.this.f62297a.l(), f.this.f62299c);
                }
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            f30.i.d(new WeakReference(f.this.f62299c.getActivity()));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class e implements b.C0682b {
        public e() {
        }

        public boolean a(c.b bVar) {
            MediaResult d11 = bVar.d();
            long h11 = f.this.f62297a.h();
            if ((d11 == null || d11.getSize() > h11) && h11 != -1) {
                f.this.f62298b.g(R$string.belvedere_image_stream_file_too_large);
                return false;
            }
            bVar.f(!bVar.e());
            List f11 = f.this.p(d11, bVar.e());
            f.this.f62298b.e(f11.size());
            f.this.f62298b.f(f11.size());
            ArrayList arrayList = new ArrayList();
            arrayList.add(d11);
            if (bVar.e()) {
                f.this.f62299c.xh(arrayList);
                return true;
            }
            f.this.f62299c.wh(arrayList);
            return true;
        }

        public void b() {
            if (f.this.f62297a.b()) {
                f.this.f62298b.i(f.this.f62297a.j(), f.this.f62299c);
            }
        }
    }

    public f(f30.b bVar, e eVar, ImageStream imageStream) {
        this.f62297a = bVar;
        this.f62298b = eVar;
        this.f62299c = imageStream;
    }

    public void g() {
        this.f62299c.Ch((g) null, (BelvedereUi.UiConfig) null);
        this.f62299c.zh(0, 0, 0.0f);
        this.f62299c.vh();
    }

    public final void h() {
        f30.i.f((ViewGroup) this.f62299c.getActivity().findViewById(16908290), this.f62299c.getString(R$string.belvedere_permissions_rationale), BelvedereUi.f62182a.longValue(), this.f62299c.getString(R$string.belvedere_navigate_to_settings), new d());
    }

    public void i() {
        n();
        j();
        this.f62298b.e(this.f62297a.i().size());
        this.f62298b.f(this.f62297a.i().size());
    }

    public final void j() {
        if (this.f62297a.e()) {
            this.f62298b.c(new a());
        }
        if (this.f62297a.a()) {
            l();
        }
    }

    public void k(int i11, int i12, float f11) {
        if (f11 >= 0.0f) {
            this.f62299c.zh(i11, i12, f11);
        }
    }

    public final void l() {
        this.f62298b.b(new b());
    }

    public final void m() {
        this.f62299c.Bh(Arrays.asList(new String[]{PermissionConfig.READ_MEDIA_AUDIO}), new c());
    }

    public final void n() {
        boolean z11 = this.f62297a.d() || this.f62298b.h();
        this.f62298b.d(z11);
        this.f62298b.a(this.f62297a.f(), this.f62297a.i(), z11, this.f62297a.b(), this.f62300d);
        this.f62299c.Ah();
    }

    public void o() {
        this.f62299c.yh(this.f62297a.i());
    }

    public final List<MediaResult> p(MediaResult mediaResult, boolean z11) {
        if (z11) {
            return this.f62297a.k(mediaResult);
        }
        return this.f62297a.c(mediaResult);
    }
}
