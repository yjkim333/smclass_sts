package com.java.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.java.dao.MemberMapper;
import com.java.dto.MemberDto;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMessage.RecipientType;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired MemberMapper memberMapper;
	// 이메일 전송 객체 - text만 보낼 수 있음.
	@Autowired JavaMailSender javaMailSender;

	// 로그인체크
	@Override
	public MemberDto login(MemberDto mdto) {
		MemberDto memberDto = memberMapper.selectLogin(mdto);
		return memberDto;
	}

	
	// pw code 생성
	public String getCreateKey() {
		String pwcode = "";
		char[] charSet = {
				'0','1','2','3','4','5','6','7','8','9',
				'A','B','C','D','E','F','G','H','I','J',
				'K','L','M','N','O','P','Q','R','S','T',
				'U','V','W','X','Y','Z'};
		// 10자리 비밀번호 생성
		int idx = 0;
		for (int i=0;i<10;i++) {
			idx = (int)(Math.random()*36);
			pwcode += ""+charSet[idx];
		}
		System.out.println("인증 코드 생성 : "+ pwcode);
		return pwcode;
	}

	
	// 인증이메일 발송
	//@Async // 비동기방식으로 변경 - 메일 발송에 10초가 걸린다고 하면 기다리지 않고 다음거 실행
	@Override
	public String sendEmail(String email) {
		// 인증키 생성
		String pwcode = getCreateKey();
		// 네이버 이메일 전송
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email); // 메일 받는 사람
		message.setFrom("dydwns4671@naver.com"); //보내는 사람
		message.setSubject("[회원가입] 회원가입을 위한 이메일 인증 코드 발송"); // 제목
		message.setText("안녕하세요. \n회원가입을 위한 이메일 인증 코드를 보내드렸습니다. \n 인증 코드는 \n["+pwcode+"] 입니다.\n인증코드를 입력하세요.");
		javaMailSender.send(message);
		System.out.println("이메일 전송 완료!!");
		return pwcode;
	}

	
	// 인증이메일 발송
	//@Async // 비동기방식으로 변경 - 메일 발송에 10초가 걸린다고 하면 기다리지 않고 다음거 실행
	@Override
	public String sendEmail2(String email) {
		// 인증키 생성
		String pwcode = getCreateKey();
		// 네이버 이메일 전송 - html
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			message.setSubject("[회원가입] 회원가입을 위한 이메일 인증 코드 발송");// 제목
			String hdata = "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>\r\n"
					+ "<html xmlns='http://www.w3.org/1999/xhtml' lang='ko' xml:lang='ko'>\r\n"
					+ "<head>\r\n"
					+ "<meta http-equiv='Content-Type' content='application/xhtml+xml; charset=utf-8' />\r\n"
					+ "<meta http-equiv='X-UA-Compatible' content='IE=edge' />\r\n"
					+ "<title> 비밀번호 발송 </title>\r\n"
					+ "</head>\r\n"
					+ "<body bgcolor='#FFFFFF' leftmargin='0' topmargin='0' marginwidth='0' marginheight='0' style='margin:0; padding:0; font:normal 12px/1.5 돋움;'>\r\n"
					+ "<table width='700' cellpadding='0' cellspacing='0' align='center'>\r\n"
					+ "<tr>\r\n"
					+ "	<td style='width:700px;height:175px;padding:0;margin:0;vertical-align:top;font-size:0;line-height:0;'>\r\n"
					+ "		<img src='../images/email/img_email_top.jpg' alt='JARDIN' />					\r\n"
					+ "	</td>\r\n"
					+ "</tr>\r\n"
					+ "<tr>\r\n"
					+ "	<td style='width:700px;height:78px;padding:0;margin:0;vertical-align:top;'>\r\n"
					+ "		<p style='width:620px;margin:50px 0 40px 38px;text-align:center;font-size:0;line-height:0;'><img src='../images/email/img_txt_password01.jpg' alt='원두커피의 名家, JARDIN 이메일 인증코드가 발급되었습니다.' /></p>\r\n"
					+ "	</td>\r\n"
					+ "</tr>\r\n"
					+ "<tr>\r\n"
					+ "	<td style='width:700px;height:196px;padding:0;margin:0;vertical-align:top;'>\r\n"
					+ "		<table width='618' height='194' cellpadding='0' cellspacing='0' align='center' style='margin:0 0 0 40px;border:1px #d9d9d9 solid;'>\r\n"
					+ "		<tr>\r\n"
					+ "			<td style='width:618px;height:194px;padding:0;margin:0;vertical-align:top;font-size:0;line-height:0;background:#f9f9f9;'>\r\n"
					+ "				<p style='width:620px;margin:30px 0 0 0;padding:0;text-align:center;'><img src='../images/email/img_txt_password02.jpg' alt='JARDIN에서 인증코드를 요청하셨습니다.' /></p>\r\n"
					+ "				<p style='width:620px;margin:10px 0 0 0;padding:0;text-align:center;color:#888888;font-size:12px;line-height:1;'>아래의 인증코드를 입력하여 나머지 단계를 진행하여 주십시오.</p>\r\n"
					+ "				<p style='width:620px;margin:28px 0 0 0;padding:0;text-align:center;color:#666666;font-size:12px;line-height:1;'><strong>인증코드 : <span style='color:#f7703c;line-height:1;'>"+pwcode+"</span></strong></p>\r\n"
					+ "				<p style='width:620px;margin:30px 0 0 0;padding:0;text-align:center;color:#888888;font-size:12px;line-height:1.4;'>쟈뎅샵에서는 고객님께 보다 나은 서비스를 제공하기 위해 항상 노력하고 있습니다.<br/>앞으로 많은 관심 부탁드립니다.</p>\r\n"
					+ "			</td>\r\n"
					+ "		</tr>\r\n"
					+ "		</table>	\r\n"
					+ "	</td>\r\n"
					+ "</tr>\r\n"
					+ "<tr>\r\n"
					+ "	<td style='width:700px;height:120px;padding:0;margin:0;vertical-align:top;'>\r\n"
					+ "		<p style='width:700px;margin:30px 0 50px 0;text-align:center;'><a href='#'><img src='../images/email/btn_jardin.jpg' alt='JARDIN 바로가기' /></a></p>\r\n"
					+ "	</td>\r\n"
					+ "</tr>\r\n"
					+ "<tr>\r\n"
					+ "	<td style='width:700px;height:50px;padding:0;vertical-align:top;font-size:0;line-height:0;text-align:center;'>\r\n"
					+ "		<img src='../images/email/img_email_bottom.jpg' alt='' />\r\n"
					+ "	</td>\r\n"
					+ "</tr>\r\n"
					+ "<tr>\r\n"
					+ "	<td style='width:700px;height:140px;padding:0;margin:0;vertical-align:top;background-color:#5a524c;'>\r\n"
					+ "		<p style='width:620px;margin:20px 0 0 40px;padding:0;text-align:center;line-height:1.5;color:#b2aeac;'>메일수신을 원치 않으시는 분은 로그인 후. <span style='color:#ffffff'>메일 수신 여부</span>를 변경해주시기 바랍니다.<br/>IF YOU DO NOT WISH TO RECEIVE EMAILS FROM US, PLEASE LOG-IN AND UPDATE<br/> YOUR MEMBERSHIP INFORMATION.</p>\r\n"
					+ "\r\n"
					+ "		<p style='width:620px;margin:15px 0 0 40px;padding:0;text-align:center;line-height:1.5;color:#b2aeac;'><span style='color:#ffffff'>본 메일에 관한 문의사항은 사이트 내 고객센터를 이용해주시기 바랍니다.</span><br/>COPYRIGHT ©  2014 JARDIN ALL RIGHTS RESERVED.</p>\r\n"
					+ "	</td>\r\n"
					+ "</tr>\r\n"
					+ "</table>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "</div>\r\n"
					+ "</body>\r\n"
					+ "</html>"
					+""
					+""
					+""
					+"";
			message.setText(hdata,"utf-8","html");//
			message.setFrom(new InternetAddress("dydwns4671@naver.com")); // 보내는 사람
			message.addRecipient(RecipientType.TO, new InternetAddress(email)); // 받는 사람
			javaMailSender.send(message);
			
		} catch (Exception e) {e.printStackTrace();}
		
		System.out.println("이메일 전송 완료!!");
		return pwcode;
	}
	
	
	
	
	
	
	
}
