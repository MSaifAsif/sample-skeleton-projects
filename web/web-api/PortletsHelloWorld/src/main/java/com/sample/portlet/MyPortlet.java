package com.sample.portlet;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import java.io.IOException;

public class MyPortlet extends GenericPortlet {

    private static final String NORMAL_VIEW = "/normal.jsp";
    private static final String MAXIMIZED_VIEW = "/maximized.jsp";
    private static final String HELP_VIEW = "/help.jsp";

    private PortletRequestDispatcher normalView;
    private PortletRequestDispatcher maximizedView;
    private PortletRequestDispatcher helpView;

    public void doView(RenderRequest request, RenderResponse response)
            throws PortletException, IOException {

        if (WindowState.MINIMIZED.equals(request.getWindowState())) {
            return;
        }

        if (WindowState.NORMAL.equals(request.getWindowState())) {
            normalView.include(request, response);
        } else {
            maximizedView.include(request, response);
        }
    }

    protected void doHelp(RenderRequest request, RenderResponse response)
            throws PortletException, IOException {

        helpView.include(request, response);

    }

    public void init(PortletConfig config) throws PortletException {
        super.init(config);
        normalView = config.getPortletContext().getRequestDispatcher(NORMAL_VIEW);
        maximizedView = config.getPortletContext().getRequestDispatcher(MAXIMIZED_VIEW);
        helpView = config.getPortletContext().getRequestDispatcher(HELP_VIEW);
    }

    public void destroy() {
        normalView = null;
        maximizedView = null;
        helpView = null;
        super.destroy();
    }

}
