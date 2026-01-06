package zone.hwj.api.execution.graph;

import zone.hwj.api.step.Step;

public interface Node {
    String id();
    Step step();
}
