package com.hys.framework.web.servlet.tags;

import com.github.pagehelper.PageInfo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;

/**
 * 翻页控件
 * @author apple
 */
public class PaginationTag extends BodyTagSupport {

    private final static String DEFAULT_TEMPLATE_PATH = "/WEB-INF/jsp/platform/tags/pagination.jsp";    
    private PageInfo page;
    
    private String templatePath;            // 模板位置
    
    private String style;

    @Override
    public int doEndTag() throws JspException {              
        pageContext.getRequest().setAttribute("page", page);
        try {
        	templatePath = DEFAULT_TEMPLATE_PATH;
            pageContext.include(templatePath, true);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        }
        return EVAL_PAGE;
    }
       

    public PageInfo getPage() {
		return page;
	}


	public void setPage(PageInfo page) {
		this.page = page;
	}


	public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
}
