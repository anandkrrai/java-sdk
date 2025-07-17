package io.modelcontextprotocol;

import java.time.Duration;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.HttpClientSseClientTransport;
import io.modelcontextprotocol.client.transport.HttpClientStreamableHttpTransport;
import io.modelcontextprotocol.spec.McpSchema;

public class testtss {

	@org.junit.jupiter.api.Test
	public void test() {

		// HttpClientSseClientTransport httpClientSseClientTransport =
		// HttpClientSseClientTransport.builder("https://docs.mcp.cloudflare.com/sse").build();
		// McpSyncClient mcpSyncClient =
		// McpClient.sync(httpClientSseClientTransport).build();
		// mcpSyncClient.initialize();
		// mcpSyncClient.listTools();

		System.out.println("********************");

		// HttpClientSseClientTransport httpClientSseClientTransport =
		// HttpClientSseClientTransport.builder("https://mcp.atlassian.com/v1/sse").build();
		HttpClientStreamableHttpTransport streamableHttpTransport = HttpClientStreamableHttpTransport
			.builder("https://qbiz-mcp.abhjaw.people.aws.dev")
			.build();
		HttpClientSseClientTransport sseHttpTransport = HttpClientSseClientTransport
			.builder("https://qbiz-mcp.abhjaw.people.aws.dev")
			.build();
		// HttpClientStreamableHttpTransport streamableHttpTransport =
		// HttpClientStreamableHttpTransport.builder("https://mcp.atlassian.com/v1/sse").build();
		//
//		McpSyncClient client = McpClient.sync(streamableHttpTransport).build();
//		client.initialize();
		// Create a sync client with custom configuration


		McpSyncClient client = McpClient.sync(streamableHttpTransport)
			.requestTimeout(Duration.ofSeconds(10))
			.capabilities(McpSchema.ClientCapabilities.builder()
				.roots(true)      // Enable roots capability
				.sampling()       // Enable sampling capability
				.build())
			.build();

		// Initialize connection
		client.initialize();

		// List available tools
		McpSchema.ListToolsResult tools = client.listTools();

	}

}