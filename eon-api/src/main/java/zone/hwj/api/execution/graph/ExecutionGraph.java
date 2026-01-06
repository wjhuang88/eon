package zone.hwj.api.execution.graph;

public interface ExecutionGraph {
    Node start();
    Node next(Node current, ExecutionContext context);
}
