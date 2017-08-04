package com.smartxp.commons.email.bean;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

import com.smartxp.commons.email.domain.EmailInfo;
import com.smartxp.commons.email.domain.EmailServerInfo;
import com.smartxp.commons.email.util.PMSEmailUtils;

public class ReadEmailTest {

//	/**
//	 * 读取所有邮件
//	 */
//	@Test
//	public void testReadAllEmails() throws FileNotFoundException {
//		
//		// 获取配置的登陆邮件服务器的信息
//		EmailServerInfo emailServerInfo = PMSEmailUtils.getConfigEmailServerInfo();
//		
//		List<EmailInfo> emailInfos = PMSEmailUtils.getAllEmailInfos(emailServerInfo);
//		System.out.println("邮件数目：" + emailInfos.size());
//		for (EmailInfo emailInfo : emailInfos) {
//			System.out.println(emailInfo.toString());
//		}
//	}
//	
//	/**
//	 * 获取最新的一份邮件
//	 */
//	@Test
//	public void testReadEmailTemplate() throws FileNotFoundException {
//		
//		// 获取配置的登陆邮件服务器的信息
//		EmailServerInfo emailServerInfo = PMSEmailUtils.getConfigEmailServerInfo();
//		// 获取最新的邮件
//		EmailInfo emailInfo = PMSEmailUtils.getLatestOneEmailInfo(emailServerInfo);
//		// 打印出来
//		System.out.println(emailInfo.toString());
//	}
}
