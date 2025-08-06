package zendesk.belvedere;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import zendesk.belvedere.BelvedereUi;
import zendesk.belvedere.i;
import zendesk.belvedere.ui.R$string;

public class ImageStream extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<KeyboardHelper> f62225b = new WeakReference<>((Object) null);

    /* renamed from: c  reason: collision with root package name */
    public List<WeakReference<b>> f62226c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<WeakReference<d>> f62227d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<WeakReference<c>> f62228e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public g f62229f = null;

    /* renamed from: g  reason: collision with root package name */
    public BelvedereUi.UiConfig f62230g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f62231h = false;

    /* renamed from: i  reason: collision with root package name */
    public i f62232i;

    /* renamed from: j  reason: collision with root package name */
    public Callback<List<MediaResult>> f62233j;

    public class a extends Callback<List<MediaResult>> {
        public a() {
        }

        public void success(List<MediaResult> list) {
            ArrayList arrayList = new ArrayList(list.size());
            for (MediaResult next : list) {
                if (next.getSize() <= ImageStream.this.f62230g.getMaxFileSize() || ImageStream.this.f62230g.getMaxFileSize() == -1) {
                    arrayList.add(next);
                }
            }
            if (arrayList.size() != list.size()) {
                Toast.makeText(ImageStream.this.getContext(), R$string.belvedere_image_stream_file_too_large, 0).show();
            }
            ImageStream.this.xh(arrayList);
        }
    }

    public interface b {
        void onDismissed();

        void onMediaDeselected(List<MediaResult> list);

        void onMediaSelected(List<MediaResult> list);

        void onVisible();
    }

    public interface c {
        void onScroll(int i11, int i12, float f11);
    }

    public interface d {
        void a(List<MediaResult> list);
    }

    public void Ah() {
        for (WeakReference<b> weakReference : this.f62226c) {
            b bVar = (b) weakReference.get();
            if (bVar != null) {
                bVar.onVisible();
            }
        }
    }

    public void Bh(List<String> list, i.c cVar) {
        this.f62232i.d(this, list, cVar);
    }

    public void Ch(g gVar, BelvedereUi.UiConfig uiConfig) {
        this.f62229f = gVar;
        if (uiConfig != null) {
            this.f62230g = uiConfig;
        }
    }

    public void Dh(KeyboardHelper keyboardHelper) {
        this.f62225b = new WeakReference<>(keyboardHelper);
    }

    public boolean Eh() {
        return this.f62231h;
    }

    public void dismiss() {
        if (uh()) {
            this.f62229f.dismiss();
        }
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        this.f62233j = new a();
        a.c(requireContext()).e(i11, i12, intent, this.f62233j, false);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f62232i = new i();
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        g gVar = this.f62229f;
        if (gVar != null) {
            gVar.dismiss();
            this.f62231h = true;
        } else {
            this.f62231h = false;
        }
        FragmentTrackHelper.trackFragmentPause(this);
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        if (!this.f62232i.j(i11, strArr, iArr)) {
            super.onRequestPermissionsResult(i11, strArr, iArr);
        }
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void qh(b bVar) {
        this.f62226c.add(new WeakReference(bVar));
    }

    public void rh(c cVar) {
        this.f62228e.add(new WeakReference(cVar));
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public KeyboardHelper sh() {
        return (KeyboardHelper) this.f62225b.get();
    }

    public void th(List<MediaIntent> list, i.d dVar) {
        this.f62232i.i(this, list, dVar);
    }

    public boolean uh() {
        return this.f62229f != null;
    }

    public void vh() {
        this.f62233j = null;
        for (WeakReference<b> weakReference : this.f62226c) {
            b bVar = (b) weakReference.get();
            if (bVar != null) {
                bVar.onDismissed();
            }
        }
    }

    public void wh(List<MediaResult> list) {
        for (WeakReference<b> weakReference : this.f62226c) {
            b bVar = (b) weakReference.get();
            if (bVar != null) {
                bVar.onMediaDeselected(list);
            }
        }
    }

    public void xh(List<MediaResult> list) {
        for (WeakReference<b> weakReference : this.f62226c) {
            b bVar = (b) weakReference.get();
            if (bVar != null) {
                bVar.onMediaSelected(list);
            }
        }
    }

    public void yh(List<MediaResult> list) {
        for (WeakReference<d> weakReference : this.f62227d) {
            d dVar = (d) weakReference.get();
            if (dVar != null) {
                dVar.a(list);
            }
        }
    }

    public void zh(int i11, int i12, float f11) {
        for (WeakReference<c> weakReference : this.f62228e) {
            c cVar = (c) weakReference.get();
            if (cVar != null) {
                cVar.onScroll(i11, i12, f11);
            }
        }
    }
}
