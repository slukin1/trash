package lc;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Space;
import androidx.databinding.f;

public abstract class m6 extends f {
    public final RadioButton B;
    public final RadioButton C;
    public final RadioButton D;
    public final RadioGroup E;
    public final Space F;
    public final Space G;

    public m6(Object obj, View view, int i11, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioGroup radioGroup, Space space, Space space2) {
        super(obj, view, i11);
        this.B = radioButton;
        this.C = radioButton2;
        this.D = radioButton3;
        this.E = radioGroup;
        this.F = space;
        this.G = space2;
    }
}
