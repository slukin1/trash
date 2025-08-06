package cn.sharesdk.onekeyshare.themes.classic.port;

import android.content.Context;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPage;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlatformPageAdapterPort extends PlatformPageAdapter {
    private static final int DESIGN_LOGO_HEIGHT = 76;
    private static final int DESIGN_PADDING_TOP = 20;
    private static final int DESIGN_SCREEN_WIDTH_P = 720;
    private static final int DESIGN_SEP_LINE_WIDTH = 1;
    private static final int LINE_SIZE_P = 4;
    private static final int PAGE_SIZE_P = 12;

    public PlatformPageAdapterPort(PlatformPage platformPage, ArrayList<Object> arrayList) {
        super(platformPage, arrayList);
    }

    public void calculateSize(Context context, ArrayList<Object> arrayList) {
        int screenWidth = ResHelper.getScreenWidth(context);
        this.lineSize = 4;
        float f11 = ((float) screenWidth) / 720.0f;
        int i11 = (int) (1.0f * f11);
        this.sepLineWidth = i11;
        if (i11 < 1) {
            i11 = 1;
        }
        this.sepLineWidth = i11;
        this.logoHeight = (int) (76.0f * f11);
        this.paddingTop = (int) (20.0f * f11);
        this.bottomHeight = (int) (f11 * 52.0f);
        this.cellHeight = (screenWidth - (i11 * 3)) / 4;
        if (arrayList.size() <= this.lineSize) {
            this.panelHeight = this.cellHeight + this.sepLineWidth;
        } else if (arrayList.size() <= 12 - this.lineSize) {
            this.panelHeight = (this.cellHeight + this.sepLineWidth) * 2;
        } else {
            this.panelHeight = (this.cellHeight + this.sepLineWidth) * 3;
        }
    }

    public void collectCells(ArrayList<Object> arrayList) {
        Class<Object> cls = Object.class;
        int size = arrayList.size();
        if (size < 12) {
            int i11 = this.lineSize;
            int i12 = size / i11;
            if (size % i11 != 0) {
                i12++;
            }
            int[] iArr = new int[2];
            iArr[1] = i12 * i11;
            iArr[0] = 1;
            this.cells = (Object[][]) Array.newInstance(cls, iArr);
        } else {
            int i13 = size / 12;
            if (size % 12 != 0) {
                i13++;
            }
            int[] iArr2 = new int[2];
            iArr2[1] = 12;
            iArr2[0] = i13;
            this.cells = (Object[][]) Array.newInstance(cls, iArr2);
        }
        for (int i14 = 0; i14 < size; i14++) {
            int i15 = i14 / 12;
            this.cells[i15][i14 - (i15 * 12)] = arrayList.get(i14);
        }
    }
}
