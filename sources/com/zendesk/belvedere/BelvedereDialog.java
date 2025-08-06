package com.zendesk.belvedere;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import androidx.fragment.app.FragmentManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;

public class BelvedereDialog extends AppCompatDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public ListView f52734b;

    /* renamed from: c  reason: collision with root package name */
    public BelvedereIntent f52735c;

    /* renamed from: d  reason: collision with root package name */
    public List<BelvedereIntent> f52736d;

    /* renamed from: e  reason: collision with root package name */
    public iz.d f52737e;

    public class a implements g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f52738a;

        public a(Fragment fragment) {
            this.f52738a = fragment;
        }

        public void a(BelvedereIntent belvedereIntent) {
            belvedereIntent.open(this.f52738a);
        }

        public Context getContext() {
            return this.f52738a.getContext();
        }
    }

    public class b implements g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f52740a;

        public b(FragmentActivity fragmentActivity) {
            this.f52740a = fragmentActivity;
        }

        public void a(BelvedereIntent belvedereIntent) {
            belvedereIntent.open((Activity) this.f52740a);
        }

        public Context getContext() {
            return this.f52740a;
        }
    }

    public class c implements AdapterView.OnItemClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f52742b;

        public c(g gVar) {
            this.f52742b = gVar;
        }

        @SensorsDataInstrumented
        public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
            if (view.getTag() instanceof BelvedereIntent) {
                BelvedereIntent belvedereIntent = (BelvedereIntent) view.getTag();
                if (TextUtils.isEmpty(belvedereIntent.getPermission())) {
                    this.f52742b.a((BelvedereIntent) view.getTag());
                    BelvedereDialog.this.dismiss();
                } else {
                    BelvedereDialog.this.qh(belvedereIntent);
                }
            }
            SensorsDataAutoTrackHelper.trackListView(adapterView, view, i11);
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f52744a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.zendesk.belvedere.BelvedereSource[] r0 = com.zendesk.belvedere.BelvedereSource.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f52744a = r0
                com.zendesk.belvedere.BelvedereSource r1 = com.zendesk.belvedere.BelvedereSource.Camera     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f52744a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.zendesk.belvedere.BelvedereSource r1 = com.zendesk.belvedere.BelvedereSource.Gallery     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zendesk.belvedere.BelvedereDialog.d.<clinit>():void");
        }
    }

    public class e extends ArrayAdapter<BelvedereIntent> {

        /* renamed from: b  reason: collision with root package name */
        public Context f52745b;

        public e(Context context, int i11, List<BelvedereIntent> list) {
            super(context, i11, list);
            this.f52745b = context;
        }

        public View getView(int i11, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(this.f52745b).inflate(R$layout.belvedere_dialog_row, viewGroup, false);
            }
            BelvedereIntent belvedereIntent = (BelvedereIntent) getItem(i11);
            f a11 = f.a(belvedereIntent, this.f52745b);
            ((ImageView) view.findViewById(R$id.belvedere_dialog_row_image)).setImageDrawable(ContextCompat.getDrawable(this.f52745b, a11.b()));
            ((TextView) view.findViewById(R$id.belvedere_dialog_row_text)).setText(a11.c());
            view.setTag(belvedereIntent);
            return view;
        }
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public final int f52747a;

        /* renamed from: b  reason: collision with root package name */
        public final String f52748b;

        public f(int i11, String str) {
            this.f52747a = i11;
            this.f52748b = str;
        }

        public static f a(BelvedereIntent belvedereIntent, Context context) {
            int i11 = d.f52744a[belvedereIntent.getSource().ordinal()];
            if (i11 == 1) {
                return new f(R$drawable.ic_camera, context.getString(R$string.belvedere_dialog_camera));
            }
            if (i11 != 2) {
                return new f(-1, context.getString(R$string.belvedere_dialog_unknown));
            }
            return new f(R$drawable.ic_image, context.getString(R$string.belvedere_dialog_gallery));
        }

        public int b() {
            return this.f52747a;
        }

        public String c() {
            return this.f52748b;
        }
    }

    public interface g {
        void a(BelvedereIntent belvedereIntent);

        Context getContext();
    }

    public static void uh(FragmentManager fragmentManager, List<BelvedereIntent> list) {
        if (list != null && list.size() != 0) {
            BelvedereDialog belvedereDialog = new BelvedereDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("extra_intent", new ArrayList(list));
            belvedereDialog.setArguments(bundle);
            belvedereDialog.show(fragmentManager.q(), "BelvedereDialog");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f52737e = new iz.d(getContext());
        if (bundle != null) {
            this.f52735c = (BelvedereIntent) bundle.getParcelable("waiting_for_permission");
        }
        setStyle(1, getTheme());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R$layout.belvedere_dialog, viewGroup, false);
        this.f52734b = (ListView) inflate.findViewById(R$id.belvedere_dialog_listview);
        return inflate;
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        BelvedereIntent belvedereIntent;
        if (i11 != 12 || (belvedereIntent = this.f52735c) == null || TextUtils.isEmpty(belvedereIntent.getPermission())) {
            super.onRequestPermissionsResult(i11, strArr, iArr);
        } else if (strArr.length > 0 && strArr[0].equals(this.f52735c.getPermission())) {
            if (iArr.length > 0 && iArr[0] == 0) {
                if (getParentFragment() != null) {
                    this.f52735c.open(getParentFragment());
                } else if (getActivity() != null) {
                    this.f52735c.open((Activity) getActivity());
                }
                dismissAllowingStateLoss();
            } else if (iArr.length > 0 && iArr[0] == -1 && !shouldShowRequestPermissionRationale(this.f52735c.getPermission())) {
                this.f52737e.a(this.f52735c.getPermission());
                List<BelvedereIntent> th2 = th();
                this.f52736d = th2;
                rh(th2);
            }
            this.f52735c = null;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("waiting_for_permission", this.f52735c);
    }

    public void onStart() {
        super.onStart();
        List<BelvedereIntent> th2 = th();
        this.f52736d = th2;
        rh(th2);
    }

    public final void qh(BelvedereIntent belvedereIntent) {
        this.f52735c = belvedereIntent;
        requestPermissions(new String[]{belvedereIntent.getPermission()}, 12);
    }

    public final void rh(List<BelvedereIntent> list) {
        if (getParentFragment() != null) {
            sh(new a(getParentFragment()), list);
        } else if (getActivity() != null) {
            sh(new b(getActivity()), list);
        } else {
            Log.w("BelvedereDialog", "Not able to find a valid context for starting an BelvedereIntent");
            if (getFragmentManager() != null) {
                dismiss();
            }
        }
    }

    public final void sh(g gVar, List<BelvedereIntent> list) {
        this.f52734b.setAdapter(new e(gVar.getContext(), R$layout.belvedere_dialog_row, list));
        this.f52734b.setOnItemClickListener(new c(gVar));
    }

    public final List<BelvedereIntent> th() {
        ArrayList<BelvedereIntent> parcelableArrayList = getArguments().getParcelableArrayList("extra_intent");
        if (parcelableArrayList == null || parcelableArrayList.size() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (BelvedereIntent belvedereIntent : parcelableArrayList) {
            if (TextUtils.isEmpty(belvedereIntent.getPermission()) || !this.f52737e.b(belvedereIntent.getPermission())) {
                arrayList.add(belvedereIntent);
            }
        }
        return arrayList;
    }
}
