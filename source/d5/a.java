package d5;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.github.mikephil.charting.components.AxisBase;
import java.text.DecimalFormat;

public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public DecimalFormat f66215a;

    /* renamed from: b  reason: collision with root package name */
    public int f66216b = 0;

    public a(int i11) {
        this.f66216b = i11;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 == 0) {
                stringBuffer.append(InstructionFileId.DOT);
            }
            stringBuffer.append("0");
        }
        this.f66215a = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    public String a(float f11, AxisBase axisBase) {
        return this.f66215a.format((double) f11);
    }

    public int b() {
        return this.f66216b;
    }
}
