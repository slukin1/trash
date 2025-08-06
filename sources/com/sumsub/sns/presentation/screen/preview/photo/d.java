package com.sumsub.sns.presentation.screen.preview.photo;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.sumsub.sns.R;
import com.sumsub.sns.core.widget.SNSRotationZoomableImageView;
import d10.p;
import kotlin.Unit;

public final class d extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public p<? super Integer, ? super b, Unit> f39962a;

    public d(View view) {
        super(view);
    }

    public final p<Integer, b, Unit> a() {
        return this.f39962a;
    }

    public final SNSRotationZoomableImageView b() {
        return (SNSRotationZoomableImageView) this.itemView.findViewById(R.id.sns_photo);
    }

    public final void a(p<? super Integer, ? super b, Unit> pVar) {
        this.f39962a = pVar;
    }

    public final void a(int i11, b bVar) {
        SNSRotationZoomableImageView b11 = b();
        if (b11 != null) {
            b11.setImageBitmapWithRotation(bVar.e(), bVar.f());
        }
        SNSRotationZoomableImageView b12 = b();
        if (b12 != null) {
            b12.setOnClickListener(new g(this, i11, bVar));
        }
    }

    public static final void a(d dVar, int i11, b bVar, View view) {
        p<? super Integer, ? super b, Unit> pVar = dVar.f39962a;
        if (pVar != null) {
            pVar.invoke(Integer.valueOf(i11), bVar);
        }
    }
}
