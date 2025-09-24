# MCP Spring AI Example

This repository contains an example of building a **Model Context Protocol (MCP) server** using **Java** and **Spring AI**.  
The example demonstrates how to expose tools via MCP so that agents can communicate with them using the MCP protocol.

You can read the full article that explains this step-by-step here:  
[Building an MCP Server with Spring AI](https://dan.iftodi.com/2025/09/building-an-mcp-server-with-spring-ai/)

---

## Overview
This example uses Spring AI to simplify MCP server creation, allowing you to focus on defining your tools and business logic instead of protocol details.

Here’s an example structure for `mcp.json`:

```
{
  "mcpServers": {
    "spring-ai": {
      "command": "java -jar  <ABSOLUTE_PATH>/spring-mcp-0.0.1-SNAPSHOT.jar",
      "transport": "stdio"
    }
  }
}
```
