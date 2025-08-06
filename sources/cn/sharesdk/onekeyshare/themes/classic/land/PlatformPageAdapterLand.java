package cn.sharesdk.onekeyshare.themes.classic.land;

import android.content.Context;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPage;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlatformPageAdapterLand extends PlatformPageAdapter {
    private static final int DESIGN_CELL_WIDTH_L = 160;
    private static final int DESIGN_LOGO_HEIGHT = 76;
    private static final int DESIGN_PADDING_TOP = 20;
    private static final int DESIGN_SCREEN_WIDTH_L = 1280;
    private static final int DESIGN_SEP_LINE_WIDTH = 1;

    public PlatformPageAdapterLand(PlatformPage platformPage, ArrayList<Object> arrayList) {
        super(platformPage, arrayList);
    }

    public void calculateSize(Context context, ArrayList<Object> arrayList) {
        int screenWidth = ResHelper.getScreenWidth(context);
        float f11 = ((float) screenWidth) / 1280.0f;
        int i11 = screenWidth / ((int) (160.0f * f11));
        this.lineSize = i11;
        int i12 = (int) (1.0f * f11);
        this.sepLineWidth = i12;
        if (i12 < 1) {
            i12 = 1;
        }
        this.sepLineWidth = i12;
        this.logoHeight = (int) (76.0f * f11);
        this.paddingTop = (int) (20.0f * f11);
        this.bottomHeight = (int) (f11 * 52.0f);
        int i13 = (screenWidth - (i12 * 3)) / (i11 - 1);
        this.cellHeight = i13;
        this.panelHeight = i13 + i12;
    }

    public void collectCells(ArrayList<Object> arrayList) {
        Class<Object> cls = Object.class;
        int size = arrayList.size();
        int i11 = this.lineSize;
        if (size < i11) {
            int i12 = size / i11;
            if (size % i11 != 0) {
                i12++;
            }
            int i13 = i12 * i11;
            int[] iArr = new int[2];
            iArr[1] = i13;
            iArr[0] = 1;
            this.cells = (Object[][]) Array.newInstance(cls, iArr);
        } else {
            int i14 = size / i11;
            if (size % i11 != 0) {
                i14++;
            }
            int[] iArr2 = new int[2];
            iArr2[1] = i11;
            iArr2[0] = i14;
            this.cells = (Object[][]) Array.newInstance(cls, iArr2);
        }
        for (int i15 = 0; i15 < size; i15++) {
            int i16 = this.lineSize;
            int i17 = i15 / i16;
            this.cells[i17][i15 - (i16 * i17)] = arrayList.get(i15);
        }
    }
}
