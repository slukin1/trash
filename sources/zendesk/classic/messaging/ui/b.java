package zendesk.classic.messaging.ui;

import mz.f;
import zendesk.classic.messaging.AgentDetails;

public class b {
    public a a(AgentDetails agentDetails) {
        return new a(agentDetails.getAgentId(), f.c(agentDetails.getAgentName()) ? agentDetails.getAgentName().substring(0, 1) : "", agentDetails.getAvatarPath(), agentDetails.getAvatarDrawableRes());
    }
}
