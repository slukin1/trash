package com.tencent.android.tpush.inappmessage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.android.tpush.logging.TLogger;
import java.net.HttpURLConnection;
import java.net.URL;
import u0.d;
import u0.e;

public class f extends AsyncTask<Void, Void, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private String f69383a;

    /* renamed from: b  reason: collision with root package name */
    private View f69384b;

    /* renamed from: c  reason: collision with root package name */
    private Context f69385c;

    /* renamed from: d  reason: collision with root package name */
    private int f69386d;

    public f(String str, View view, Context context, int i11) {
        this.f69383a = str;
        this.f69384b = view;
        this.f69385c = context;
        this.f69386d = i11;
    }

    /* renamed from: a */
    public Bitmap doInBackground(Void... voidArr) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f69383a).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (Exception e11) {
            TLogger.e("ImageLoadTask", "InAppMsg ImageLoadTask doInBackground :" + e11.toString());
            return null;
        }
    }

    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        try {
            View view = this.f69384b;
            if (view == null) {
                return;
            }
            if (view instanceof ImageView) {
                if (bitmap != null) {
                    ((ImageView) view).setImageBitmap(bitmap);
                }
            } else if ((view instanceof RelativeLayout) && bitmap != null) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                float f11 = (float) width;
                Matrix matrix = new Matrix();
                matrix.postScale(f11 / f11, ((float) this.f69384b.getHeight()) / ((float) height));
                d a11 = e.a(this.f69385c.getResources(), Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true));
                a11.e(true);
                a11.f((float) this.f69386d);
                this.f69384b.setBackground(a11);
            }
        } catch (Throwable th2) {
            TLogger.e("ImageLoadTask", "InAppMsg ImageLoadTask onPostExecute :" + th2.toString());
        }
    }
}
