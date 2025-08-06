package zendesk.belvedere;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import zendesk.belvedere.FixedWidthImageView;
import zendesk.belvedere.SelectableView;
import zendesk.belvedere.b;
import zendesk.belvedere.ui.R$drawable;
import zendesk.belvedere.ui.R$id;
import zendesk.belvedere.ui.R$layout;
import zendesk.belvedere.ui.R$string;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f62273a = R$drawable.belvedere_ic_camera_black;

    /* renamed from: b  reason: collision with root package name */
    public static final int f62274b = R$layout.belvedere_stream_list_item_square_static;

    public static class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.C0682b f62275b;

        public a(b.C0682b bVar) {
            this.f62275b = bVar;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f62275b.b();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f62276a;

        /* renamed from: b  reason: collision with root package name */
        public final long f62277b = ((long) UUID.randomUUID().hashCode());

        /* renamed from: c  reason: collision with root package name */
        public final MediaResult f62278c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f62279d = false;

        public b(int i11, MediaResult mediaResult) {
            this.f62276a = i11;
            this.f62278c = mediaResult;
        }

        public abstract void a(View view);

        public long b() {
            return this.f62277b;
        }

        public int c() {
            return this.f62276a;
        }

        public MediaResult d() {
            return this.f62278c;
        }

        public boolean e() {
            return this.f62279d;
        }

        public void f(boolean z11) {
            this.f62279d = z11;
        }
    }

    /* renamed from: zendesk.belvedere.c$c  reason: collision with other inner class name */
    public static class C0683c extends b {

        /* renamed from: e  reason: collision with root package name */
        public final int f62280e;

        /* renamed from: f  reason: collision with root package name */
        public final View.OnClickListener f62281f;

        public /* synthetic */ C0683c(int i11, int i12, View.OnClickListener onClickListener, a aVar) {
            this(i11, i12, onClickListener);
        }

        public void a(View view) {
            ((ImageView) view.findViewById(R$id.list_item_static_image)).setImageResource(this.f62280e);
            view.findViewById(R$id.list_item_static_click_area).setOnClickListener(this.f62281f);
        }

        public C0683c(int i11, int i12, View.OnClickListener onClickListener) {
            super(i11, (MediaResult) null);
            this.f62280e = i12;
            this.f62281f = onClickListener;
        }
    }

    public static class d extends b {

        /* renamed from: e  reason: collision with root package name */
        public final MediaResult f62282e;

        /* renamed from: f  reason: collision with root package name */
        public final ResolveInfo f62283f;

        /* renamed from: g  reason: collision with root package name */
        public final b.C0682b f62284g;

        public class a implements SelectableView.c {
            public a() {
            }

            public boolean a(boolean z11) {
                return d.this.f62284g.a(d.this);
            }
        }

        public d(b.C0682b bVar, MediaResult mediaResult, Context context) {
            super(R$layout.belvedere_stream_list_item_genric_file, mediaResult);
            this.f62282e = mediaResult;
            this.f62283f = h(mediaResult.getName(), context);
            this.f62284g = bVar;
        }

        public void a(View view) {
            Context context = view.getContext();
            ImageView imageView = (ImageView) view.findViewById(R$id.list_item_file_icon);
            TextView textView = (TextView) view.findViewById(R$id.list_item_file_label);
            SelectableView selectableView = (SelectableView) view.findViewById(R$id.list_item_file_holder);
            selectableView.h(context.getString(R$string.belvedere_stream_item_unselect_file_desc, new Object[]{this.f62282e.getName()}), context.getString(R$string.belvedere_stream_item_select_file_desc, new Object[]{this.f62282e.getName()}));
            ((TextView) view.findViewById(R$id.list_item_file_title)).setText(this.f62282e.getName());
            if (this.f62283f != null) {
                PackageManager packageManager = context.getPackageManager();
                textView.setText(this.f62283f.loadLabel(packageManager));
                imageView.setImageDrawable(this.f62283f.loadIcon(packageManager));
            } else {
                textView.setText(R$string.belvedere_image_stream_unknown_app);
                imageView.setImageResource(17301651);
            }
            selectableView.setSelected(e());
            selectableView.setSelectionListener(new a());
        }

        public final ResolveInfo h(String str, Context context) {
            PackageManager packageManager = context.getPackageManager();
            MediaResult d11 = a.c(context).d("tmp", str);
            if (d11 == null) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(d11.getUri());
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                return null;
            }
            return queryIntentActivities.get(0);
        }
    }

    public static class e extends b {

        /* renamed from: e  reason: collision with root package name */
        public final MediaResult f62286e;

        /* renamed from: f  reason: collision with root package name */
        public final b.C0682b f62287f;

        /* renamed from: g  reason: collision with root package name */
        public FixedWidthImageView.b f62288g;

        public class a implements FixedWidthImageView.c {
            public a() {
            }

            public void a(FixedWidthImageView.b bVar) {
                FixedWidthImageView.b unused = e.this.f62288g = bVar;
            }
        }

        public class b implements SelectableView.c {
            public b() {
            }

            public boolean a(boolean z11) {
                return e.this.f62287f.a(e.this);
            }
        }

        public e(b.C0682b bVar, MediaResult mediaResult) {
            super(R$layout.belvedere_stream_list_item, mediaResult);
            this.f62287f = bVar;
            this.f62286e = mediaResult;
        }

        public void a(View view) {
            Context context = view.getContext();
            FixedWidthImageView fixedWidthImageView = (FixedWidthImageView) view.findViewById(R$id.list_item_image);
            SelectableView selectableView = (SelectableView) view.findViewById(R$id.list_item_selectable);
            selectableView.h(context.getString(R$string.belvedere_stream_item_unselect_image_desc, new Object[]{this.f62286e.getName()}), context.getString(R$string.belvedere_stream_item_select_image_desc, new Object[]{this.f62286e.getName()}));
            if (this.f62288g != null) {
                fixedWidthImageView.f(Picasso.h(), this.f62286e.getOriginalUri(), this.f62288g);
            } else {
                fixedWidthImageView.e(Picasso.h(), this.f62286e.getOriginalUri(), this.f62286e.getWidth(), this.f62286e.getHeight(), new a());
            }
            selectableView.setSelected(e());
            selectableView.setSelectionListener(new b());
        }
    }

    public static C0683c a(b.C0682b bVar) {
        return new C0683c(f62274b, f62273a, new a(bVar), (a) null);
    }

    public static List<b> b(List<MediaResult> list, b.C0682b bVar, Context context) {
        ArrayList arrayList = new ArrayList(list.size());
        for (MediaResult next : list) {
            if (next.getMimeType() == null || !next.getMimeType().startsWith("image")) {
                arrayList.add(new d(bVar, next, context));
            } else {
                arrayList.add(new e(bVar, next));
            }
        }
        return arrayList;
    }
}
