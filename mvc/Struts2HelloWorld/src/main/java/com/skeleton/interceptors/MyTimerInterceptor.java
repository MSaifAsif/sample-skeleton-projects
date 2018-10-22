package com.skeleton.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.log4j.Logger;

/**
 * A timer interceptro whose responsibility is to log the name of the action that was
 * called and calculate how much time it took to execute that action
 * and compute the result from the action class
 *
 * @author saifasif
 */
public class MyTimerInterceptor implements Interceptor {

    private static final Logger log = Logger.getLogger(MyTimerInterceptor.class);
    private static final long serialVersionUID = 2909616447046418440L;

    @Override
    public void destroy() {
        log.info("Destroying interceptor .... ");
    }

    @Override
    public void init() {
        log.info("Init interceptor .... ");
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        String actionName = invocation.getInvocationContext().getName();
        long preTime = System.currentTimeMillis();
        String actionResult = invocation.invoke();
        long endTime = System.currentTimeMillis();
        log.info("Action: " + actionName + "\tTime Taken:" + (endTime - preTime) + "ms");
        return actionResult;
    }

}
