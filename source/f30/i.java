package f30;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Handler;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.huobi.view.roundimg.RoundedDrawable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.squareup.picasso.x;
import java.lang.ref.WeakReference;
import java.util.Locale;
import zendesk.belvedere.ui.R$id;
import zendesk.belvedere.ui.R$layout;

public class i {

    public static class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BottomSheetDialog f60264b;

        public a(BottomSheetDialog bottomSheetDialog) {
            this.f60264b = bottomSheetDialog;
        }

        public void run() {
            this.f60264b.cancel();
        }
    }

    public static class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f60265b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f60266c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ BottomSheetDialog f60267d;

        public b(View.OnClickListener onClickListener, View view, BottomSheetDialog bottomSheetDialog) {
            this.f60265b = onClickListener;
            this.f60266c = view;
            this.f60267d = bottomSheetDialog;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f60265b.onClick(this.f60266c);
            this.f60267d.cancel();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static class c implements DialogInterface.OnCancelListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Handler f60268b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Runnable f60269c;

        public c(Handler handler, Runnable runnable) {
            this.f60268b = handler;
            this.f60269c = runnable;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f60268b.removeCallbacks(this.f60269c);
        }
    }

    public static class d implements DialogInterface.OnDismissListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Handler f60270b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Runnable f60271c;

        public d(Handler handler, Runnable runnable) {
            this.f60270b = handler;
            this.f60271c = runnable;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f60270b.removeCallbacks(this.f60271c);
        }
    }

    public static class e implements x {

        /* renamed from: a  reason: collision with root package name */
        public final int f60272a;

        /* renamed from: b  reason: collision with root package name */
        public final int f60273b;

        public e(int i11, int i12) {
            this.f60272a = i11;
            this.f60273b = i12;
        }

        public String key() {
            return String.format(Locale.US, "rounded-%s-%s", new Object[]{Integer.valueOf(this.f60272a), Integer.valueOf(this.f60273b)});
        }

        public Bitmap transform(Bitmap bitmap) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            int i11 = this.f60273b;
            RectF rectF = new RectF((float) i11, (float) i11, (float) (bitmap.getWidth() - this.f60273b), (float) (bitmap.getHeight() - this.f60273b));
            int i12 = this.f60272a;
            canvas.drawRoundRect(rectF, (float) i12, (float) i12, paint);
            if (bitmap != createBitmap) {
                bitmap.recycle();
            }
            return createBitmap;
        }
    }

    public static int a(Context context, int i11) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i11, typedValue, true)) {
            return RoundedDrawable.DEFAULT_BORDER_COLOR;
        }
        int i12 = typedValue.resourceId;
        if (i12 == 0) {
            return typedValue.data;
        }
        return ContextCompat.getColor(context, i12);
    }

    public static void b(ImageView imageView, int i11) {
        if (imageView != null && imageView.getDrawable() != null) {
            u0.a.n(u0.a.r(imageView.getDrawable()).mutate(), i11);
            imageView.invalidate();
        }
    }

    public static boolean c(String str, Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 128).enabled;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void d(WeakReference<Activity> weakReference) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", ((Activity) weakReference.get()).getPackageName(), (String) null));
        ((Activity) weakReference.get()).startActivity(intent);
    }

    public static x e(Context context, int i11) {
        return new e(context.getResources().getDimensionPixelOffset(i11), 0);
    }

    public static void f(View view, String str, long j11, CharSequence charSequence, View.OnClickListener onClickListener) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(view.getContext());
        Handler handler = new Handler();
        a aVar = new a(bottomSheetDialog);
        bottomSheetDialog.setContentView(R$layout.belvedere_bottom_sheet);
        TextView textView = (TextView) bottomSheetDialog.findViewById(R$id.belvedere_bottom_sheet_message_text);
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = (TextView) bottomSheetDialog.findViewById(R$id.belvedere_bottom_sheet_actions_text);
        if (textView2 != null) {
            textView2.setText(charSequence);
            textView2.setOnClickListener(new b(onClickListener, view, bottomSheetDialog));
        }
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setOnCancelListener(new c(handler, aVar));
        bottomSheetDialog.setOnDismissListener(new d(handler, aVar));
        bottomSheetDialog.show();
        handler.postDelayed(aVar, j11);
    }

    public static void g(View view, boolean z11) {
        int i11 = 0;
        view.findViewById(R$id.image_stream_toolbar).setVisibility(z11 ? 0 : 8);
        View findViewById = view.findViewById(R$id.image_stream_toolbar_container);
        if (findViewById != null) {
            if (!z11) {
                i11 = 8;
            }
            findViewById.setVisibility(i11);
        }
    }
}
