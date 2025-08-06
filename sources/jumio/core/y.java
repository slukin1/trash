package jumio.core;

import com.jumio.commons.log.Log;
import com.jumio.core.Controller;
import com.jumio.core.enums.ErrorCase;
import com.jumio.core.error.Error;
import com.jumio.core.models.InitiateModel;
import com.jumio.core.models.SettingsModel;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;
import org.json.JSONObject;

@d(c = "com.jumio.core.Controller$onSettingsCallResult$2", f = "Controller.kt", l = {}, m = "invokeSuspend")
public final class y extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f56346a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Controller f56347b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(Controller controller, Object obj, c cVar) {
        super(2, cVar);
        this.f56346a = obj;
        this.f56347b = controller;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new y(this.f56347b, this.f56346a, cVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((y) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        k.b(obj);
        try {
            JSONObject jSONObject = (JSONObject) this.f56346a;
            JSONObject optJSONObject = jSONObject.optJSONObject("configurations");
            SettingsModel fromJson = SettingsModel.Companion.fromJson(jSONObject);
            this.f56347b.getDataManager().put(SettingsModel.class, fromJson);
            Controller.access$setupDataDog(this.f56347b, optJSONObject, fromJson.getServerTimestamp());
            Controller.access$setupTimeouts(this.f56347b, optJSONObject);
            Controller.access$setupLivenessSettings(this.f56347b, optJSONObject);
            Controller.access$setupDocfinderSettings(this.f56347b, optJSONObject);
            Controller.access$setupCDNFeatures(this.f56347b, optJSONObject);
            Controller.access$setupDocuments(this.f56347b, jSONObject);
            Controller.access$setupCountryDocuments(this.f56347b, jSONObject);
            Controller.access$setupConsent(this.f56347b, jSONObject);
            Controller.access$setupDeviceRisk(this.f56347b, jSONObject);
            Controller.access$setupIproov(this.f56347b, jSONObject);
            Controller.access$setupCredentials(this.f56347b, jSONObject);
            InitiateModel unused2 = this.f56347b.a(jSONObject);
            this.f56347b.a();
        } catch (Exception e11) {
            Log.printStackTrace(e11);
            Controller.onError$default(this.f56347b, new Error(ErrorCase.PROCESS_CANT_BE_COMPLETED, 1, 0), (Class) null, 2, (Object) null);
        }
        return Unit.f56620a;
    }
}
