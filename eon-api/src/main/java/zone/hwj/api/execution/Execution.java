package zone.hwj.api.execution;

import zone.hwj.api.agent.Agent;
import zone.hwj.api.execution.graph.ExecutionContext;
import zone.hwj.api.execution.graph.ExecutionGraph;

public interface Execution {
    String id();
    Agent agent();
    ExecutionGraph graph();
    ExecutionContext context();
}
