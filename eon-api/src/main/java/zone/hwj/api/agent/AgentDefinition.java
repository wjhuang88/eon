package zone.hwj.api.agent;

import zone.hwj.api.execution.graph.ExecutionGraph;

public interface AgentDefinition {
    ExecutionGraph graph();
    AgentPolicy policy();
    AgentMemorySpec memorySpec();
}
