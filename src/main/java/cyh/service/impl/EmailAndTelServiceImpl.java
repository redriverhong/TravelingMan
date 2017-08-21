package cyh.service.impl;

import org.springframework.stereotype.Service;

import cyh.redis.RedisDao;
import cyh.service.EmailAndTelService;
import cyh.util.EmailUtil;
import cyh.util.RandomId;
import cyh.util.telmessage.TelMessage;

@Service("emailAndTelService")
public class EmailAndTelServiceImpl implements EmailAndTelService {

	@Override
	public void sendEmail(String email) {
		String code=RandomId.getEmailCode();
		try {
			if(EmailUtil.sendEmail(email,code)){
				RedisDao.saveCode(email, code);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendMessage(String tel) {
		String code=RandomId.getTelCode();
		TelMessage.sendMsg(tel, code);
		RedisDao.saveCode(tel, code);
	}

}
