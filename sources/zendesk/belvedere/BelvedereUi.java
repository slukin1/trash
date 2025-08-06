package zendesk.belvedere;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import zendesk.belvedere.i;
import zendesk.belvedere.ui.R$string;

public class BelvedereUi {

    /* renamed from: a  reason: collision with root package name */
    public static final Long f62182a = 5000L;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Context f62183a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f62184b;

        /* renamed from: c  reason: collision with root package name */
        public final List<MediaIntent> f62185c;

        /* renamed from: d  reason: collision with root package name */
        public List<MediaResult> f62186d;

        /* renamed from: e  reason: collision with root package name */
        public List<MediaResult> f62187e;

        /* renamed from: f  reason: collision with root package name */
        public List<Integer> f62188f;

        /* renamed from: g  reason: collision with root package name */
        public long f62189g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f62190h;

        public class a implements i.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ImageStream f62191a;

            /* renamed from: zendesk.belvedere.BelvedereUi$b$a$a  reason: collision with other inner class name */
            public class C0679a implements Runnable {

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ List f62193b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Activity f62194c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ ViewGroup f62195d;

                public C0679a(List list, Activity activity, ViewGroup viewGroup) {
                    this.f62193b = list;
                    this.f62194c = activity;
                    this.f62195d = viewGroup;
                }

                public void run() {
                    UiConfig uiConfig = new UiConfig(this.f62193b, b.this.f62186d, b.this.f62187e, true, b.this.f62188f, b.this.f62189g, b.this.f62190h);
                    a.this.f62191a.Ch(g.v(this.f62194c, this.f62195d, a.this.f62191a, uiConfig), uiConfig);
                }
            }

            /* renamed from: zendesk.belvedere.BelvedereUi$b$a$b  reason: collision with other inner class name */
            public class C0680b implements View.OnClickListener {

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Activity f62197b;

                public C0680b(Activity activity) {
                    this.f62197b = activity;
                }

                @SensorsDataInstrumented
                public void onClick(View view) {
                    f30.i.d(new WeakReference(this.f62197b));
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            }

            public a(ImageStream imageStream) {
                this.f62191a = imageStream;
            }

            public void a(List<MediaIntent> list) {
                FragmentActivity activity = this.f62191a.getActivity();
                if (activity != null && !activity.isChangingConfigurations()) {
                    ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                    viewGroup.post(new C0679a(list, activity, viewGroup));
                }
            }

            public void b() {
                FragmentActivity activity = this.f62191a.getActivity();
                if (activity != null) {
                    f30.i.f((ViewGroup) activity.findViewById(16908290), activity.getString(R$string.belvedere_permissions_rationale), BelvedereUi.f62182a.longValue(), activity.getString(R$string.belvedere_navigate_to_settings), new C0680b(activity));
                }
            }
        }

        public void f(AppCompatActivity appCompatActivity) {
            ImageStream c11 = BelvedereUi.c(appCompatActivity);
            c11.th(this.f62185c, new a(c11));
        }

        public b g() {
            this.f62185c.add(a.c(this.f62183a).a().a());
            return this;
        }

        public b h(String str, boolean z11) {
            this.f62185c.add(a.c(this.f62183a).b().a(z11).c(str).b());
            return this;
        }

        public b i(List<MediaResult> list) {
            this.f62187e = new ArrayList(list);
            return this;
        }

        public b j(boolean z11) {
            this.f62190h = z11;
            return this;
        }

        public b k(long j11) {
            this.f62189g = j11;
            return this;
        }

        public b l(List<MediaResult> list) {
            this.f62186d = new ArrayList(list);
            return this;
        }

        public b m(int... iArr) {
            ArrayList arrayList = new ArrayList(iArr.length);
            for (int valueOf : iArr) {
                arrayList.add(Integer.valueOf(valueOf));
            }
            this.f62188f = arrayList;
            return this;
        }

        public b(Context context) {
            this.f62184b = true;
            this.f62185c = new ArrayList();
            this.f62186d = new ArrayList();
            this.f62187e = new ArrayList();
            this.f62188f = new ArrayList();
            this.f62189g = -1;
            this.f62190h = false;
            this.f62183a = context;
        }
    }

    public static UiConfig a(Bundle bundle) {
        UiConfig uiConfig = (UiConfig) bundle.getParcelable("extra_intent");
        return uiConfig == null ? new UiConfig() : uiConfig;
    }

    public static b b(Context context) {
        return new b(context);
    }

    public static ImageStream c(AppCompatActivity appCompatActivity) {
        ImageStream imageStream;
        FragmentManager supportFragmentManager = appCompatActivity.getSupportFragmentManager();
        Fragment m02 = supportFragmentManager.m0("belvedere_image_stream");
        if (m02 instanceof ImageStream) {
            imageStream = (ImageStream) m02;
        } else {
            imageStream = new ImageStream();
            supportFragmentManager.q().e(imageStream, "belvedere_image_stream").l();
        }
        imageStream.Dh(KeyboardHelper.l(appCompatActivity));
        return imageStream;
    }

    public static class UiConfig implements Parcelable {
        public static final Parcelable.Creator<UiConfig> CREATOR = new a();
        private final List<MediaResult> extraItems;
        private final boolean fullScreenOnly;
        private final List<MediaIntent> intents;
        private final long maxFileSize;
        private final boolean resolveMedia;
        private final List<MediaResult> selectedItems;
        private final List<Integer> touchableElements;

        public static class a implements Parcelable.Creator<UiConfig> {
            /* renamed from: a */
            public UiConfig createFromParcel(Parcel parcel) {
                return new UiConfig(parcel);
            }

            /* renamed from: b */
            public UiConfig[] newArray(int i11) {
                return new UiConfig[i11];
            }
        }

        public UiConfig() {
            this.intents = new ArrayList();
            this.selectedItems = new ArrayList();
            this.extraItems = new ArrayList();
            this.touchableElements = new ArrayList();
            this.resolveMedia = true;
            this.maxFileSize = -1;
            this.fullScreenOnly = false;
        }

        public int describeContents() {
            return 0;
        }

        public List<MediaResult> getExtraItems() {
            return this.extraItems;
        }

        public List<MediaIntent> getIntents() {
            return this.intents;
        }

        public long getMaxFileSize() {
            return this.maxFileSize;
        }

        public List<MediaResult> getSelectedItems() {
            return this.selectedItems;
        }

        public List<Integer> getTouchableElements() {
            return this.touchableElements;
        }

        public boolean showFullScreenOnly() {
            return this.fullScreenOnly;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeTypedList(this.intents);
            parcel.writeTypedList(this.selectedItems);
            parcel.writeTypedList(this.extraItems);
            parcel.writeList(this.touchableElements);
            parcel.writeInt(this.resolveMedia ? 1 : 0);
            parcel.writeLong(this.maxFileSize);
            parcel.writeInt(this.fullScreenOnly ? 1 : 0);
        }

        public UiConfig(List<MediaIntent> list, List<MediaResult> list2, List<MediaResult> list3, boolean z11, List<Integer> list4, long j11, boolean z12) {
            this.intents = list;
            this.selectedItems = list2;
            this.extraItems = list3;
            this.resolveMedia = z11;
            this.touchableElements = list4;
            this.maxFileSize = j11;
            this.fullScreenOnly = z12;
        }

        public UiConfig(Parcel parcel) {
            this.intents = parcel.createTypedArrayList(MediaIntent.CREATOR);
            Parcelable.Creator<MediaResult> creator = MediaResult.CREATOR;
            this.selectedItems = parcel.createTypedArrayList(creator);
            this.extraItems = parcel.createTypedArrayList(creator);
            ArrayList arrayList = new ArrayList();
            this.touchableElements = arrayList;
            parcel.readList(arrayList, Integer.class.getClassLoader());
            boolean z11 = false;
            this.resolveMedia = parcel.readInt() == 1;
            this.maxFileSize = parcel.readLong();
            this.fullScreenOnly = parcel.readInt() == 1 ? true : z11;
        }
    }
}
