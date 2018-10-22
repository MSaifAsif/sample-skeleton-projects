package com.sample.one;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A sample action that simply forwars to the mapping file that is associated with it. In this case,
 * only the JSP will be displayed
 *
 * @author saifasif
 */
public class HelloWorldAction extends Action {

    private static final Logger log = Logger.getLogger(HelloWorldAction.class);

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("Loading action ... ");
        return mapping.findForward("success");
    }

}
