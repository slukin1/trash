package zendesk.belvedere;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import zendesk.belvedere.ui.R$drawable;
import zendesk.belvedere.ui.R$id;
import zendesk.belvedere.ui.R$layout;
import zendesk.belvedere.ui.R$string;

public class BelvedereDialog extends AppCompatDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public ListView f62170b;

    /* renamed from: c  reason: collision with root package name */
    public MediaIntent f62171c;

    /* renamed from: d  reason: collision with root package name */
    public List<MediaIntent> f62172d;

    public class a implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f62173a;

        public a(Fragment fragment) {
            this.f62173a = fragment;
        }

        public void a(MediaIntent mediaIntent) {
            mediaIntent.open(this.f62173a);
        }

        public Context getContext() {
            return this.f62173a.getContext();
        }
    }

    public class b implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f62175a;

        public b(FragmentActivity fragmentActivity) {
            this.f62175a = fragmentActivity;
        }

        public void a(MediaIntent mediaIntent) {
            mediaIntent.open((Activity) this.f62175a);
        }

        public Context getContext() {
            return this.f62175a;
        }
    }

    public class c implements AdapterView.OnItemClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f62177b;

        public c(f fVar) {
            this.f62177b = fVar;
        }

        @SensorsDataInstrumented
        public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
            if (view.getTag() instanceof MediaIntent) {
                BelvedereDialog.this.uh((MediaIntent) view.getTag(), this.f62177b);
            }
            SensorsDataAutoTrackHelper.trackListView(adapterView, view, i11);
        }
    }

    public static class d extends ArrayAdapter<MediaIntent> {

        /* renamed from: b  reason: collision with root package name */
        public final Context f62179b;

        public d(Context context, int i11, List<MediaIntent> list) {
            super(context, i11, list);
            this.f62179b = context;
        }

        public View getView(int i11, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(this.f62179b).inflate(R$layout.belvedere_dialog_row, viewGroup, false);
            }
            MediaIntent mediaIntent = (MediaIntent) getItem(i11);
            e a11 = e.a(mediaIntent, this.f62179b);
            ((ImageView) view.findViewById(R$id.belvedere_dialog_row_image)).setImageDrawable(ContextCompat.getDrawable(this.f62179b, a11.b()));
            ((TextView) view.findViewById(R$id.belvedere_dialog_row_text)).setText(a11.c());
            view.setTag(mediaIntent);
            return view;
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final int f62180a;

        /* renamed from: b  reason: collision with root package name */
        public final String f62181b;

        public e(int i11, String str) {
            this.f62180a = i11;
            this.f62181b = str;
        }

        public static e a(MediaIntent mediaIntent, Context context) {
            if (mediaIntent.getTarget() == 2) {
                return new e(R$drawable.belvedere_ic_camera, context.getString(R$string.belvedere_dialog_camera));
            }
            if (mediaIntent.getTarget() == 1) {
                return new e(R$drawable.belvedere_ic_image, context.getString(R$string.belvedere_dialog_gallery));
            }
            return new e(-1, "");
        }

        public int b() {
            return this.f62180a;
        }

        public String c() {
            return this.f62181b;
        }
    }

    public interface f {
        void a(MediaIntent mediaIntent);

        Context getContext();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f62171c = (MediaIntent) bundle.getParcelable("waiting_for_permission");
        }
        setStyle(1, getTheme());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R$layout.belvedere_dialog, viewGroup, false);
        this.f62170b = (ListView) inflate.findViewById(R$id.belvedere_dialog_listview);
        return inflate;
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        MediaIntent mediaIntent;
        if (i11 != 1212 || (mediaIntent = this.f62171c) == null || TextUtils.isEmpty(mediaIntent.getPermission())) {
            super.onRequestPermissionsResult(i11, strArr, iArr);
        } else if (strArr.length > 0 && strArr[0].equals(this.f62171c.getPermission())) {
            if (iArr.length > 0 && iArr[0] == 0) {
                if (getParentFragment() != null) {
                    this.f62171c.open(getParentFragment());
                } else if (getActivity() != null) {
                    this.f62171c.open((Activity) getActivity());
                }
                dismissAllowingStateLoss();
            } else if (iArr.length > 0 && iArr[0] == -1 && !shouldShowRequestPermissionRationale(this.f62171c.getPermission())) {
                List<MediaIntent> th2 = th();
                this.f62172d = th2;
                rh(th2);
            }
            this.f62171c = null;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("waiting_for_permission", this.f62171c);
    }

    public void onStart() {
        super.onStart();
        List<MediaIntent> th2 = th();
        this.f62172d = th2;
        rh(th2);
    }

    public final void qh(MediaIntent mediaIntent) {
        this.f62171c = mediaIntent;
        requestPermissions(new String[]{mediaIntent.getPermission()}, 1212);
    }

    public final void rh(List<MediaIntent> list) {
        if (getParentFragment() != null) {
            sh(new a(getParentFragment()), list);
        } else if (getActivity() != null) {
            sh(new b(getActivity()), list);
        } else if (isAdded()) {
            dismiss();
        }
    }

    public final void sh(f fVar, List<MediaIntent> list) {
        this.f62170b.setAdapter(new d(fVar.getContext(), R$layout.belvedere_dialog_row, list));
        this.f62170b.setOnItemClickListener(new c(fVar));
        if (list.size() == 0) {
            dismissAllowingStateLoss();
        } else if (list.size() == 1) {
            uh(list.get(0), fVar);
        }
    }

    public final List<MediaIntent> th() {
        List<MediaIntent> intents = BelvedereUi.a(requireArguments()).getIntents();
        ArrayList arrayList = new ArrayList();
        for (MediaIntent next : intents) {
            if (TextUtils.isEmpty(next.getPermission()) || next.isAvailable()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public final void uh(MediaIntent mediaIntent, f fVar) {
        if (TextUtils.isEmpty(mediaIntent.getPermission())) {
            fVar.a(mediaIntent);
            dismiss();
            return;
        }
        qh(mediaIntent);
    }
}
