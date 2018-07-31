package com.subgraph.orchid.dashboard;

import java.io.IOException;
import java.io.PrintWriter;

public interface DashboardRenderable {
	
	static int ALRMXBOARD_CONNECTIONS           = 1 << 0;
	static int ALRMXBOARD_CONNECTIONS_VERBOSE   = 1 << 1;
	static int ALRMXBOARD_PREDICTED_PORTS       = 1 << 2;
	static int ALRMXBOARD_CIRCUITS              = 1 << 3;
	static int ALRMXBOARD_STREAMS               = 1 << 4;
	
	void dashboardRender(DashboardRenderer renderer, PrintWriter writer, int flags) throws IOException;
}
