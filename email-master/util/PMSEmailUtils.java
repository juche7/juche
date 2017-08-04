package com.smartxp.commons.email.util;

import java.util.List;

import javax.mail.Session;

import com.smartxp.api.email.service.EmailServerService;
import com.smartxp.api.email.service.impl.EmailServerServiceImpl;
import com.smartxp.commons.email.domain.EmailInfo;
import com.smartxp.commons.email.domain.EmailServerInfo;

/**
 * @author Juche
 */
public final class PMSEmailUtils {

	private final static EmailServerService emailServerService = new EmailServerServiceImpl();
	
	/**
	 * 获取邮件内容配置的信息
	 */
	public static String getConfigEmailContentInfo(String contentProperties) {
		return emailServerService.getConfigEmailContentInfo(contentProperties);
	}
	
	/**
	 * 获取配置的邮箱服务器的信息
	 */
	public static EmailServerInfo getConfigEmailServerInfo(String properties) {
		return emailServerService.getConfigEmailServerInfo(properties);
	}
	
	/**
	 * 转发第 msgnum 份邮件, 并补充正文和附件
	 */
	public static boolean forwardEmail(EmailServerInfo emailServerInfo,	int msgnum, 
			String content, String[] attachmentFiles, String[] forwardAddress) {
		return emailServerService.forwardEmail(emailServerInfo, msgnum, content, attachmentFiles, forwardAddress);
	}
	
	/**
	 * 回复第 msgnum 份邮件
	 */
	public static boolean replyEmail(EmailServerInfo emailServerInfo, int msgnum, 
									String content, String[] attachmentFiles) {
		return emailServerService.replyEmail(emailServerInfo, msgnum, content, attachmentFiles);
	}
	
	
	/**
	 * 发送邮件的模板方法
	 */
	public static boolean sendEmail(EmailServerInfo emailServerInfo, EmailInfo email) {
		// 如果登陆成功，则进行发送邮件
		
		Session sendMailSession = emailServerService.loginEmailServer(emailServerInfo, false);
		if (sendMailSession != null) {
			System.out.println(emailServerInfo.getMailServerSMTPHost() + " 登陆成功！");
			System.out.println("正在发送邮件...");
			boolean result = emailServerService.sendEmail(sendMailSession, emailServerInfo, email);
			if (result) {
				System.out.println("发送成功！");
			} else {
				System.out.println("发送失败！");
			}
			return result;
		} else {
			System.out.println(emailServerInfo.getMailServerSMTPHost() + " 登陆失败！");
			return false;
		}
	}
	
	/**
	 * 获取所有邮件
	 */
	public static List<EmailInfo> getAllEmailInfos(EmailServerInfo emailServerInfo) {
		// 如果登陆成功，则进行发送邮件
		Session sendMailSession = emailServerService.loginEmailServer(emailServerInfo, true);
		if (sendMailSession != null) {
			System.out.println(emailServerInfo.getMailServerPOP3Host() + " 登陆成功！");
			System.out.println("正在读取邮件...");
			List<EmailInfo> emailInfos = emailServerService.readAllEmailInfos(sendMailSession, emailServerInfo);
			return emailInfos;
		} else {
			System.out.println(emailServerInfo.getMailServerPOP3Host() + " 登陆失败！");
			return null;
		}
	}
	
	/**
	 * 获取最近的一份邮件，并保存附件
	 */
	public static EmailInfo getLatestOneEmailInfo(EmailServerInfo emailServerInfo) {
		// 如果登陆成功，则进行发送邮件
		Session sendMailSession = emailServerService.loginEmailServer(emailServerInfo, true);
		if (sendMailSession != null) {
			System.out.println(emailServerInfo.getMailServerPOP3Host() + " 登陆成功！");
			System.out.println("正在读取邮件...");
			EmailInfo emailInfo = emailServerService.getLatestOneEmailFromStore(sendMailSession, emailServerInfo);
			return emailInfo;
		} else {
			System.out.println(emailServerInfo.getMailServerPOP3Host() + " 登陆失败！");
			return null;
		}
	}
	
	/**
	 * 删除收件箱中第 msgnum 份邮件，本地数据库中需要保存读取邮件的 msgnum 序号！
	 */
	public static boolean deleteEmailByMsgNum(EmailServerInfo emailServerInfo, int msgnum) {
		return emailServerService.deleteEmailByMsgNum(emailServerInfo, msgnum);
	}
}
