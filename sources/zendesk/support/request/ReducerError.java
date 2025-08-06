package zendesk.support.request;

import zendesk.support.suas.Reducer;

class ReducerError extends Reducer<StateError> {
    public StateError getInitialState() {
        return new StateError();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0096, code lost:
        if (r4.getState() != zendesk.support.request.StateError.ErrorType.InitialGetComments) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009d, code lost:
        return new zendesk.support.request.StateError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a0, code lost:
        if ((r5 instanceof zendesk.support.request.ActionFactory.ErrorAction) == false) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b3, code lost:
        return new zendesk.support.request.StateError(zendesk.support.request.StateError.ErrorType.InputFormSubmission, ((zendesk.support.request.ActionFactory.ErrorAction) r5).getErrorResponse().getReason());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ba, code lost:
        if (r4.getState() != zendesk.support.request.StateError.ErrorType.InputFormSubmission) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c1, code lost:
        return new zendesk.support.request.StateError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zendesk.support.request.StateError reduce(zendesk.support.request.StateError r4, zendesk.support.suas.Action<?> r5) {
        /*
            r3 = this;
            boolean r0 = r5 instanceof zendesk.support.request.ActionFactory.ErrorAction
            if (r0 == 0) goto L_0x0025
            r0 = r5
            zendesk.support.request.ActionFactory$ErrorAction r0 = (zendesk.support.request.ActionFactory.ErrorAction) r0
            lz.a r0 = r0.getErrorResponse()
            boolean r1 = r0.a()
            if (r1 == 0) goto L_0x0025
            int r1 = r0.getStatus()
            r2 = 401(0x191, float:5.62E-43)
            if (r1 != r2) goto L_0x0025
            zendesk.support.request.StateError r4 = new zendesk.support.request.StateError
            zendesk.support.request.StateError$ErrorType r5 = zendesk.support.request.StateError.ErrorType.NoAccess
            java.lang.String r0 = r0.getReason()
            r4.<init>(r5, r0)
            return r4
        L_0x0025:
            java.lang.String r0 = r5.getActionType()
            r0.hashCode()
            r1 = -1
            int r2 = r0.hashCode()
            switch(r2) {
                case -1193398337: goto L_0x006c;
                case -1063298693: goto L_0x0061;
                case -292168757: goto L_0x0056;
                case -16010570: goto L_0x004b;
                case 1532422677: goto L_0x0040;
                case 1921186300: goto L_0x0035;
                default: goto L_0x0034;
            }
        L_0x0034:
            goto L_0x0076
        L_0x0035:
            java.lang.String r2 = "CREATE_COMMENT"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x003e
            goto L_0x0076
        L_0x003e:
            r1 = 5
            goto L_0x0076
        L_0x0040:
            java.lang.String r2 = "CREATE_REQUEST_ERROR"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0049
            goto L_0x0076
        L_0x0049:
            r1 = 4
            goto L_0x0076
        L_0x004b:
            java.lang.String r2 = "LOAD_COMMENTS_INITIAL_SUCCESS"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0054
            goto L_0x0076
        L_0x0054:
            r1 = 3
            goto L_0x0076
        L_0x0056:
            java.lang.String r2 = "LOAD_COMMENT_INITIAL"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x005f
            goto L_0x0076
        L_0x005f:
            r1 = 2
            goto L_0x0076
        L_0x0061:
            java.lang.String r2 = "LOAD_COMMENTS_INITIAL_ERROR"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x006a
            goto L_0x0076
        L_0x006a:
            r1 = 1
            goto L_0x0076
        L_0x006c:
            java.lang.String r2 = "LOAD_COMMENTS_UPDATE_SUCCESS"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0075
            goto L_0x0076
        L_0x0075:
            r1 = 0
        L_0x0076:
            switch(r1) {
                case 0: goto L_0x0090;
                case 1: goto L_0x007a;
                case 2: goto L_0x0090;
                case 3: goto L_0x0090;
                case 4: goto L_0x009e;
                case 5: goto L_0x00b4;
                default: goto L_0x0079;
            }
        L_0x0079:
            goto L_0x00c2
        L_0x007a:
            boolean r0 = r5 instanceof zendesk.support.request.ActionFactory.ErrorAction
            if (r0 == 0) goto L_0x0090
            zendesk.support.request.ActionFactory$ErrorAction r5 = (zendesk.support.request.ActionFactory.ErrorAction) r5
            lz.a r4 = r5.getErrorResponse()
            zendesk.support.request.StateError r5 = new zendesk.support.request.StateError
            zendesk.support.request.StateError$ErrorType r0 = zendesk.support.request.StateError.ErrorType.InitialGetComments
            java.lang.String r4 = r4.getReason()
            r5.<init>(r0, r4)
            return r5
        L_0x0090:
            zendesk.support.request.StateError$ErrorType r0 = r4.getState()
            zendesk.support.request.StateError$ErrorType r1 = zendesk.support.request.StateError.ErrorType.InitialGetComments
            if (r0 != r1) goto L_0x009e
            zendesk.support.request.StateError r4 = new zendesk.support.request.StateError
            r4.<init>()
            return r4
        L_0x009e:
            boolean r0 = r5 instanceof zendesk.support.request.ActionFactory.ErrorAction
            if (r0 == 0) goto L_0x00b4
            zendesk.support.request.ActionFactory$ErrorAction r5 = (zendesk.support.request.ActionFactory.ErrorAction) r5
            lz.a r4 = r5.getErrorResponse()
            zendesk.support.request.StateError r5 = new zendesk.support.request.StateError
            zendesk.support.request.StateError$ErrorType r0 = zendesk.support.request.StateError.ErrorType.InputFormSubmission
            java.lang.String r4 = r4.getReason()
            r5.<init>(r0, r4)
            return r5
        L_0x00b4:
            zendesk.support.request.StateError$ErrorType r4 = r4.getState()
            zendesk.support.request.StateError$ErrorType r5 = zendesk.support.request.StateError.ErrorType.InputFormSubmission
            if (r4 != r5) goto L_0x00c2
            zendesk.support.request.StateError r4 = new zendesk.support.request.StateError
            r4.<init>()
            return r4
        L_0x00c2:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.support.request.ReducerError.reduce(zendesk.support.request.StateError, zendesk.support.suas.Action):zendesk.support.request.StateError");
    }
}
