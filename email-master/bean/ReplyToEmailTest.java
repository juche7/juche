package com.smartxp.commons.email.bean;

import java.io.FileNotFoundException;

import org.junit.Test;

import com.smartxp.commons.email.domain.EmailServerInfo;
import com.smartxp.commons.email.util.PMSEmailUtils;

/**
 * @author Juche
 */
public class ReplyToEmailTest {

//	/**
//	 * 回复邮件
//	 */
//	@Test
//	public void testReplyToEmail() throws FileNotFoundException {
//		
//		// 获取配置的登陆邮件服务器的信息
//		EmailServerInfo emailServerInfo = PMSEmailUtils.getConfigEmailServerInfo();
//		
//		String content = "这是回复内容";
//		// 添加回复邮件的附件
//		String[] attachmentFiles = {"E:\\Photos\\bob.jpeg"};
//		// 回复第几份邮件
//		if (PMSEmailUtils.replyEmail(emailServerInfo, 2, content, attachmentFiles)) {
//			System.out.println("回复成功！");
//		} else {
//			System.out.println("回复失败！");
//		}
//	}
}
