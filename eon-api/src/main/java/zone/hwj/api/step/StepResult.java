package zone.hwj.api.step;

import zone.hwj.api.step.StepResult.End;
import zone.hwj.api.step.StepResult.Jump;
import zone.hwj.api.step.StepResult.Next;
import zone.hwj.api.step.StepResult.Wait;

public sealed interface StepResult permits End, Jump, Next, Wait {
    record Next() implements StepResult {}
    record Jump(String nodeId) implements StepResult {}
    record Wait(String eventTopic) implements StepResult {}
    record End() implements StepResult {}
}
