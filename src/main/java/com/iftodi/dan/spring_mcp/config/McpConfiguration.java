package com.iftodi.dan.spring_mcp.config;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.iftodi.dan.spring_mcp.controller.UserMcpController;

@Configuration
public class McpConfiguration {

    @Bean
    public ToolCallbackProvider methodToolCallbackProvider(UserMcpController mcpController) {
        return MethodToolCallbackProvider
            .builder()
            .toolObjects(mcpController)
            .build();
    }
}
