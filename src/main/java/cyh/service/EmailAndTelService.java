package cyh.service;

public interface EmailAndTelService {
	/**
	 * 发送邮件
	 * @param email
	 */
	public void sendEmail(String email);
	/**
	 * 发送短信
	 * @param tel
	 */
	public void sendMessage(String tel);
}
