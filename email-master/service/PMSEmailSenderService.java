package com.smartxp.api.email.service;

import com.smartxp.commons.email.EmailException;
import com.smartxp.commons.email.domain.EmailEntities;
import com.smartxp.commons.u9action.U9ActionResult;

public interface PMSEmailSenderService {
	/**
	 * 发送邮件
	 * @param object
	 * @param result
	 * @throws EmailException
	 */
	public void emailMessage(String account, EmailEntities<Object> object, U9ActionResult result) throws EmailException;
}
