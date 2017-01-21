package com.gxhdx.support;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.HashMap;

public class AuthTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	private String res;

	public int doStartTag() throws JspException {
		@SuppressWarnings("unchecked")
		HashMap<String, String> map = (HashMap<String, String>) pageContext
				.getSession().getAttribute("auth");
		if (map != null && map.containsKey(res)) {
			return Tag.EVAL_BODY_INCLUDE;
		} else {
			return Tag.SKIP_BODY;
		}

	}

	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}

}
