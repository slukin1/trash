package jumio.core;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.RelativeLayout;
import com.jumio.commons.log.Log;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.scanpart.JumioScanPart;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jumio.core.s;

public abstract class r<I extends s> {

    /* renamed from: a  reason: collision with root package name */
    public I f56308a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedHashMap f56309b = new LinkedHashMap();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f56310c = new ArrayList();

    public final void addBitmap$jumio_core_release(JumioCredentialPart jumioCredentialPart, Bitmap bitmap) {
        this.f56309b.put(jumioCredentialPart, bitmap);
    }

    public final void attach(JumioScanPart jumioScanPart) {
        try {
            I i11 = (s) jumioScanPart.getScanPart$jumio_core_release();
            this.f56308a = i11;
            if (i11 != null) {
                i11.setCheckHandler(this);
            }
        } catch (Exception e11) {
            Log.printStackTrace(e11);
        }
    }

    public final void clear$jumio_core_release() {
        Iterator it2 = this.f56310c.iterator();
        while (it2.hasNext()) {
            ((t) it2.next()).detach$jumio_core_release();
        }
        for (Map.Entry value : this.f56309b.entrySet()) {
            ((Bitmap) value.getValue()).recycle();
        }
        this.f56309b.clear();
    }

    public final void detach$jumio_core_release() {
        clear$jumio_core_release();
        this.f56308a = null;
    }

    public final I getCheckInterface() {
        return this.f56308a;
    }

    public final List<JumioCredentialPart> getParts() {
        return CollectionsKt___CollectionsKt.I0(this.f56309b.keySet());
    }

    public final boolean hasPart(JumioCredentialPart jumioCredentialPart) {
        return this.f56309b.containsKey(jumioCredentialPart);
    }

    public abstract boolean isValidForScanStep$jumio_core_release(JumioScanStep jumioScanStep);

    public final void renderPart(JumioCredentialPart jumioCredentialPart, t<?> tVar) {
        if (this.f56309b.containsKey(jumioCredentialPart)) {
            n2 n2Var = new n2(tVar.getContext());
            n2Var.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            Bitmap bitmap = (Bitmap) this.f56309b.get(jumioCredentialPart);
            n2Var.f56283a = bitmap.getWidth();
            n2Var.f56284b = bitmap.getHeight();
            n2Var.f56288f = (float) tVar.getCornerRadius();
            n2Var.f56286d = new Matrix();
            n2Var.f56287e = new RectF(0.0f, 0.0f, (float) n2Var.f56283a, (float) n2Var.f56284b);
            n2Var.f56286d.setRectToRect(n2Var.f56287e, new RectF(0.0f, 0.0f, (float) n2Var.getWidth(), (float) n2Var.getHeight()), Matrix.ScaleToFit.CENTER);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            n2Var.f56285c.setShader(new BitmapShader(bitmap, tileMode, tileMode));
            n2Var.requestLayout();
            n2Var.invalidate();
            tVar.addView(n2Var);
            this.f56310c.add(tVar);
        }
    }

    public final void setCheckInterface(I i11) {
        this.f56308a = i11;
    }
}
