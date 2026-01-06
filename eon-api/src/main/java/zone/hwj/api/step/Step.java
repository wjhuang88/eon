package zone.hwj.api.step;

import zone.hwj.api.execution.graph.ExecutionContext;

public interface Step {
    StepResult execute(ExecutionContext context);
}
