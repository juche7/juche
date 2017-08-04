package com.smartxp.api.email.service;

import java.util.List;

import javax.mail.Session;

import com.smartxp.commons.email.domain.EmailInfo;
import com.smartxp.commons.email.domain.EmailServerInfo;

public interface EmailServerService {
	/**
	 * 邮箱一系列功能
	 */
	// 获取邮键内容配置
	public String getConfigEmailContentInfo(String contentProperties);
	
	// 获取邮箱配置信息
	public EmailServerInfo getConfigEmailServerInfo(String properties);
	
	// 根据 EmailServerInfo 信息登陆邮件服务器，返回mail回话对象
	public Session loginEmailServer(EmailServerInfo emailServerInfo, boolean useReadProtocol);
	
	// 转发收件箱中从上至下的 第几个number邮件, 并补充正文和附件
	public boolean forwardEmail(EmailServerInfo emailServerInfo, int msgnum, String content, String[] attachmentFiles, String[] forwardAddress);

	// 回复收件箱中从上至下的 第几个number邮件邮件
	public boolean replyEmail(EmailServerInfo emailServerInfo, int msgnum, String content, String[] attachmentFiles);

	// 按照收件箱邮件的顺序删除第 msgnum 号邮件
	public boolean deleteEmailByMsgNum(EmailServerInfo emailServerInfo, int msgnum);

	// 发送邮件
	public boolean sendEmail(Session sendMailSession, EmailServerInfo emailServerInfo, EmailInfo email);

	// 获取最近的一份邮件，并保存附件
	public EmailInfo getLatestOneEmailFromStore(Session sendMailSession, EmailServerInfo emailServerInfo);

	// 读取所有邮件
	public List<EmailInfo> readAllEmailInfos(Session sendMailSession, EmailServerInfo emailServerInfo);
}
