package com.smartxp.commons.email;

import java.io.FileNotFoundException;

import org.junit.Test;

import com.smartxp.commons.email.domain.EmailServerInfo;
import com.smartxp.commons.email.util.PMSEmailUtils;

/**
 * 
 * 
 * @auther SunnyMarkLiu
 * @time Apr 14, 2016 10:34:01 AM
 */
public class ForwardEmailTest {

//	/**
//	 * 转发邮件测试
//	 */
//	@Test
//	public void testForwardEmail() throws FileNotFoundException {
//		
//		// 获取配置的登陆邮件服务器的信息
//		EmailServerInfo emailServerInfo = PMSEmailUtils.getConfigEmailServerInfo();
//		
//		String content = "这是转发的附加内容";
//		String[] attachmentFiles = {"E:\\Photos\\bob.jpeg"};  // 设置附件
//		// 设置转发的地址
//		String[] forwardAddress = {"xxxxxx@qq.com", "xxxxxx@qq.com"};
//		
//		if (PMSEmailUtils.forwardEmail(emailServerInfo, 61, content, attachmentFiles, forwardAddress)) {
//			System.out.println("转发成功！");
//		} else {
//			System.out.println("转发失败！");
//		}
//	}
}
