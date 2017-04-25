package com.mashen.privilege.tag;

import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mashen.common.domain.CurrentUser;
import com.mashen.common.util.SpringUtil;
import com.mashen.permission.domain.PermissionVOExt;

public class PageElPermission extends TagSupport{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 
	 */
	private static final long serialVersionUID = -7023541746884943511L;
	private String privilege;
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	@Override
	public int doStartTag() throws JspException {
		logger.debug("PageElPermission privilege:"+privilege);
		CurrentUser user=SpringUtil.getBean(CurrentUser.class);
		Set<PermissionVOExt> pmses=user.getButtonPrivileges();
		if(pmses!=null){
			for(PermissionVOExt pms: pmses){
				if(pms.getClasspath().equals(privilege)){
					logger.debug("有按钮权限:"+privilege);
					return EVAL_BODY_INCLUDE;
				}
			}
		}
		return SKIP_BODY;
		
	}


}
