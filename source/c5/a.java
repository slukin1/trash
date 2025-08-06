package c5;

import android.graphics.Color;
import com.github.mikephil.charting.data.BarEntry;
import com.huobi.view.roundimg.RoundedDrawable;
import com.tencent.thumbplayer.tcmedia.core.player.TPNativePlayerInitConfig;
import java.util.List;

public class a extends b<BarEntry> implements g5.a {
    public int A = 120;
    public int B = 0;
    public String[] C = {"Stack"};

    /* renamed from: w  reason: collision with root package name */
    public int f63170w = 1;

    /* renamed from: x  reason: collision with root package name */
    public int f63171x = Color.rgb(TPNativePlayerInitConfig.BOOL_VIDEO_KEEP_MEDIA_CODEC_PTS, TPNativePlayerInitConfig.BOOL_VIDEO_KEEP_MEDIA_CODEC_PTS, TPNativePlayerInitConfig.BOOL_VIDEO_KEEP_MEDIA_CODEC_PTS);

    /* renamed from: y  reason: collision with root package name */
    public float f63172y = 0.0f;

    /* renamed from: z  reason: collision with root package name */
    public int f63173z = RoundedDrawable.DEFAULT_BORDER_COLOR;

    public a(List<BarEntry> list, String str) {
        super(list, str);
        this.f63174v = Color.rgb(0, 0, 0);
        p0(list);
        n0(list);
    }

    public int D() {
        return this.f63173z;
    }

    public int V() {
        return this.f63171x;
    }

    public int Y() {
        return this.A;
    }

    public int h() {
        return this.f63170w;
    }

    public final void n0(List<BarEntry> list) {
        this.B = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            float[] yVals = list.get(i11).getYVals();
            if (yVals == null) {
                this.B++;
            } else {
                this.B += yVals.length;
            }
        }
    }

    /* renamed from: o0 */
    public void h0(BarEntry barEntry) {
        if (barEntry != null && !Float.isNaN(barEntry.getY())) {
            if (barEntry.getYVals() == null) {
                if (barEntry.getY() < this.f65490s) {
                    this.f65490s = barEntry.getY();
                }
                if (barEntry.getY() > this.f65489r) {
                    this.f65489r = barEntry.getY();
                }
            } else {
                if ((-barEntry.getNegativeSum()) < this.f65490s) {
                    this.f65490s = -barEntry.getNegativeSum();
                }
                if (barEntry.getPositiveSum() > this.f65489r) {
                    this.f65489r = barEntry.getPositiveSum();
                }
            }
            i0(barEntry);
        }
    }

    public final void p0(List<BarEntry> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            float[] yVals = list.get(i11).getYVals();
            if (yVals != null && yVals.length > this.f63170w) {
                this.f63170w = yVals.length;
            }
        }
    }

    public float q() {
        return this.f63172y;
    }

    public boolean u() {
        return this.f63170w > 1;
    }

    public String[] v() {
        return this.C;
    }
}
