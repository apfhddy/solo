package common;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MailSendService {
	
    private JavaMailSenderImpl mailSender;
    
    
    public MailSendService(JavaMailSenderImpl mailSender) {
    	this.mailSender = mailSender;
    }
    
    public boolean isNull() {
    	return mailSender == null;
    }
    
    public String getKey(int size) {
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 0; i < size; i++) {
    		sb.append((int)(Math.random()*9)+1);
    	}
    	
    	
    	return sb.toString();
    }

    
	public void joinEmail(String key,String email,String name) {
		String setFrom = ".com"; // email-config에 설정한 자신의 이메일 주소를 입력 
		String toMail = email;
		String title = "회원 가입 인증 이메일 입니다."; // 이메일 제목 
		String content = joinForm(key,email, name);
	//				"홈페이지를 방문해주셔서 감사합니다." + 	//html 형식으로 작성 ! 
	//                "<br><br>" + 
	//			    "인증 번호는 " + a + "입니다." + 
	//			    "<br>" + 
	//			    "해당 인증번호를 인증번호 확인란에 기입하여 주세요."; //이메일 내용 삽입
		mailSend(setFrom, toMail, title, content);
			
	}
	
    //이메일 전송 메소드
	public void mailSend(String setFrom, String toMail, String title, String content) { 
		MimeMessage message = mailSender.createMimeMessage();
		// true 매개값을 전달하면 multipart 형식의 메세지 전달이 가능.문자 인코딩 설정도 가능하다.
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject("메일인증");
			// ** true 전달 > html 형식으로 전송 , 작성하지 않으면 단순 텍스트로 전달.
			helper.setText(content,true);
			mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
    
	public String joinForm(String key,String email,String name) {
		return "<table width=\"522\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n" + 
				"    <tbody>\r\n" + 
				"        <tr>\r\n" + 
				"            <td height=\"40\" align=\"left\">\r\n" + 
				"            </td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr> \r\n" + 
				"            <td style=\"color:#000001;font-size:20px;font-family:Helvetica,Arial,sans-serif\">"+name+" 고객님,<br>환영합니다!\r\n" + 
				"            </td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td align=\"left\" height=\"15\">\r\n" + 
				"            </td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td style=\"color:#000001;font-size:14px;font-family:Helvetica,Arial,sans-serif;line-height:20px\">\r\n" + 
				"                맥딜리버리 사이트에 가입해 주셔서 감사합니다. 신규 가입자 분들께 다음과 같은 혜택이 제공됩니다:<br><br>1. 신제품 소식 및 프로모션 안내 메일 발송.<br>2. 빠르고 간편한 결제.<br>3. 선호 메뉴 등록 후 빠른 재주문.<br><br>사용자명: <a href=\""+email+"\" target=\"_blank\">"+email+"</a>\r\n" + 
				"            </td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td align=\"left\" height=\"30\"></td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td height=\"25\">\r\n" + 
				"                <a href=\"http://localhost:8080/solo/join/insert?code="+key+"\" style=\"border: 1px solid; padding: 3% 6% 3% 6%; font-weight: bold; background-color: #EA4731; color: white; border-radius: 4px;\">회원가입 완료하기</a>\r\n" + 
				"            </td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td align=\"left\" height=\"20\">\r\n" + 
				"            </td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td style=\"color:#000001;font-size:14px;font-family:Helvetica,Arial,sans-serif;line-height:20px\">감사합니다,<br>맥딜리버리 팀.\r\n" + 
				"            </td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td align=\"left\" height=\"25\">\r\n" + 
				"            </td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr style=\"vertical-align:top\">\r\n" + 
				"            <td style=\"padding:25px 0 0 0;border-top:1px dashed #a2a1a1\">\r\n" + 
				"                \r\n" + 
				"            </td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td align=\"left\" height=\"10\"></td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:10px;color:#000001;font-family:Helvetica,Arial,sans-serif\">본 메일은 발신 전용 메일이므로 회신이 불가능합니다.</td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td align=\"left\" height=\"10\">\r\n" + 
				"\r\n" + 
				"            </td>\r\n" + 
				"        </tr>\r\n" + 
				"    </tbody>\r\n" + 
				"</table>";
	}
	
	
    
}