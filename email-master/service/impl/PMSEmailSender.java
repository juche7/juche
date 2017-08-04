package com.smartxp.api.email.service.impl;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.mail.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartxp.api.email.EmailRole;
import com.smartxp.api.email.service.EmailServerService;
import com.smartxp.api.email.service.PMSEmailSenderService;
import com.smartxp.api.project.dao.EmailMapper;
import com.smartxp.api.project.domain.AccountBaseInfoVo;
import com.smartxp.api.project.domain.PrjCreate;
import com.smartxp.api.project.service.ProjectService;
import com.smartxp.commons.email.EmailException;
import com.smartxp.commons.email.domain.EmailEntities;
import com.smartxp.commons.email.domain.EmailInfo;
import com.smartxp.commons.email.domain.EmailServerInfo;
import com.smartxp.commons.email.util.PMSEmailUtils;
import com.smartxp.commons.u9action.U9ActionResult;
import com.smartxp.commons.util.MyUtils;

/**
 * @author Juche
 */
@Service
@Transactional
public class PMSEmailSender implements PMSEmailSenderService{
	// 后台日志
	private final static Logger log = LoggerFactory.getLogger(PMSEmailSender.class);
	
	@Autowired
	private EmailMapper emailMapper;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private EmailServerService emailServerService;
	
	
	@Deprecated
	private void testSendEmailTemplate() throws FileNotFoundException {
		
		// 获取配置的登陆邮件服务器的信息
		EmailServerInfo emailServerInfo = PMSEmailUtils.getConfigEmailServerInfo("");
		
		// 构建邮件 email
		EmailInfo email = new EmailInfo();
		// 邮件收件人
		String[] toes = {"xxxxxx@qq.com", "xxxxxx@qq.com"};
		email.setToAddress(toes);
		// 设置邮件主题
		email.setSubject("test 主题2");
		
		StringBuffer content = new StringBuffer();
		
		// 发送链接有的邮箱服务器可能将此邮件识别为垃圾邮件。
		content.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">")  
        .append("<html>")  
        .append("<head>")  
        .append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">")  
        .append("<title>测试邮件</title>")  
        .append("<style type=\"text/css\">")  
        .append(".test{font-family:\"Microsoft Yahei\";font-size: 18px;color: red;}")  
        .append("</style>")  
        .append("</head>")  
        .append("<body>")
        .append("<h2><font color=red>Header标题</font></h2><br/>")
        .append("<span class=\"test\">this is content!内容</span>")  
        .append("</body>")
        .append("</html>");  
		email.setContent(content.toString());
		
		// 设置上传的附件
//		email.getAttachmentFiles().add("E:\\Photos\\bob.jpeg");
//		email.getAttachmentFiles().add("E:\\heartocat.png");
//		email.getAttachmentFiles().add("E:\\Music\\Alison Krauss - When You Say Nothing At All.mp3");
		
		PMSEmailUtils.sendEmail(emailServerInfo, email);
	}
	
	@Deprecated
	private void testSendEmail() {

		// 获取配置的登陆邮件服务器的信息
		EmailServerInfo emailServerInfo = PMSEmailUtils.getConfigEmailServerInfo("");

		EmailServerService emailServerService = new EmailServerServiceImpl();

		// 如果登陆成功，则进行发送邮件
		Session sendMailSession = emailServerService.loginEmailServer(emailServerInfo, false);
		if (sendMailSession != null) {
			System.out.println(emailServerInfo.getMailServerSMTPHost() + " 登陆成功！");
			// 构建邮件 email
			EmailInfo email = new EmailInfo();
			String[] toes = {"yixx@hqtx.net"};
			email.setToAddress(toes);
			email.setSubject("和勤通信IT部PMS管理员");
			email.setContent("");
			// 添加附件
			List<String> file = new ArrayList<String>();
			file.add("C:\\Users\\Administrator\\Desktop\\美女图片.jpg");
			// 设置附件
			email.setAttachmentFiles(file);
			// 发送邮件
			if (emailServerService.sendEmail(sendMailSession, emailServerInfo, email)) {
				System.out.println("发送成功！");
			} else {
				System.out.println("发送失败！");
			}
		} else {
			System.out.println(emailServerInfo.getMailServerSMTPHost() + " 登陆失败！");
		}
	}
	
	
}
