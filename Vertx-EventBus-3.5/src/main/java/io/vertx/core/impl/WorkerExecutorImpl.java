package io.vertx.core.impl;

import java.util.logging.Level;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.BaseClass)
class WorkerExecutorImpl {
	
	@Trace
	public  <T> void executeBlocking(Handler<Future<T>> blockingCodeHandler, boolean ordered, Handler<AsyncResult<T>> asyncResultHandler) {
		Exception e = new Exception("in WorkerExecutorImpl.executeBlocking");
		NewRelic.getAgent().getLogger().log(Level.FINE, e, "call to executeBlocking({0},{1},{2}", blockingCodeHandler,ordered,asyncResultHandler);
		Weaver.callOriginal();
	}
}
