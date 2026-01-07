package zone.hwj.api.tool;

public interface AgentTool {
    String name();
    ToolSchema schema();
    ToolResult execute(ToolContext context);
}
