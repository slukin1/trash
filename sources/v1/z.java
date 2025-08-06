package v1;

import android.graphics.Matrix;
import android.view.View;

public class z extends y {
    public float c(View view) {
        return view.getTransitionAlpha();
    }

    public void e(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    public void f(View view, int i11, int i12, int i13, int i14) {
        view.setLeftTopRightBottom(i11, i12, i13, i14);
    }

    public void g(View view, float f11) {
        view.setTransitionAlpha(f11);
    }

    public void h(View view, int i11) {
        view.setTransitionVisibility(i11);
    }

    public void i(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    public void j(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
