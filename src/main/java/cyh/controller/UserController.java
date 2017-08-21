package cyh.controller;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cyh.core.ActionResult;
import cyh.core.ResultCode;
import cyh.service.EmailAndTelService;
import cyh.service.UserService;
import cyh.util.CheckUtil;
import cyh.vo.user;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Autowired(required = false)
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired(required = false)
	@Qualifier("emailAndTelService")
	private EmailAndTelService emailAndTelService;
	
	@RequestMapping("/showUser")
	public String showUser(){
		String id=request.getParameter("id");
		System.out.println("eeeeeeeeee"+id);
		user u=userService.getUserById(id);
		request.setAttribute("user", u);
		return "showUser";
	}
	@RequestMapping("/userLogin")
	public void userLogin() throws Exception{
		ActionResult result = null;
		try {
			String username=request.getParameter("name");
			String password=request.getParameter("password");
			if(userService.checkUser(username,password)){
				result = new ActionResult(ResultCode.SUCCESS,ResultCode.getRstMsg(ResultCode.SUCCESS));
				user user=userService.getUserByUserName(username);
				result.setData(user);
				user.setLastlogintime(CheckUtil.getStringDate(new Date()));
				userService.updateUser(user);
			}else{
				result = new ActionResult(ResultCode.FAILURE_10,ResultCode.getRstMsg(ResultCode.FAILURE_10));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result = new ActionResult(ResultCode.FAILURE,e.getMessage());
		}finally{
			returnBack(result);
		}
	}
	@RequestMapping("/checkUser")
	public void checkUser() throws Exception{
		ActionResult result=null;
		String username=request.getParameter("name");
		try {
			if(!CheckUtil.CheckName(username)){
				result=new ActionResult(ResultCode.FAILURE,ResultCode.getRstMsg(ResultCode.FAILURE));
			}else{
				if(!userService.getUserByName(username)){
					result = new ActionResult(ResultCode.SUCCESS,ResultCode.getRstMsg(ResultCode.SUCCESS));
				}else{
					result=new ActionResult(ResultCode.FAILURE,ResultCode.getRstMsg(ResultCode.FAILURE));
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result = new ActionResult(ResultCode.FAILURE,e.getMessage());
		}finally{
			returnBack(result);
		}
		
	}
	@RequestMapping("/sendEmailOrMsg")
	public void sendEmailOrMsg() throws Exception{
		ActionResult result = null;
		String emailOrTel=request.getParameter("emailOrTel");
		try {
			if(CheckUtil.CheckEmail(emailOrTel)){
				if(!userService.checkByEmail(emailOrTel)){
					emailAndTelService.sendEmail(emailOrTel);
					result=new ActionResult(ResultCode.SUCCESS,ResultCode.getRstMsg(ResultCode.SUCCESS));
				}else{
					result=new ActionResult(ResultCode.FAILURE,ResultCode.getRstMsg(ResultCode.FAILURE));
				}
			}else if(CheckUtil.CheckTel(emailOrTel)){
				if(!userService.checkByTel(emailOrTel)){
					emailAndTelService.sendMessage(emailOrTel);
					result=new ActionResult(ResultCode.SUCCESS,ResultCode.getRstMsg(ResultCode.SUCCESS));
				}else{
					result=new ActionResult(ResultCode.FAILURE,ResultCode.getRstMsg(ResultCode.FAILURE));
				}
			}else{
				result=new ActionResult(ResultCode.FAILURE,ResultCode.getRstMsg(ResultCode.FAILURE));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result = new ActionResult(ResultCode.FAILURE,e.getMessage());
		}finally{
			returnBack(result);
		}
	}

	@RequestMapping("/checkCode")
	public void checkCode() throws Exception{
		String emailOrTel=request.getParameter("emailOrTel");
		String code=request.getParameter("code");
		ActionResult result = null;
		try {
			if(userService.checkEmailOrTelCode(emailOrTel, code)){
				result=new ActionResult(ResultCode.SUCCESS,ResultCode.getRstMsg(ResultCode.SUCCESS));
			}else{
				result=new ActionResult(ResultCode.FAILURE,ResultCode.getRstMsg(ResultCode.FAILURE));
			}
			returnBack(result);
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
			result = new ActionResult(ResultCode.FAILURE,e.getMessage());
		}finally{
			returnBack(result);
		}
	}
	
	@RequestMapping("/register")
	public void register() throws Exception{
		ActionResult result = null;
		String username=request.getParameter("name");
		String password=request.getParameter("password");
		String emailOrTel=request.getParameter("emailOrTel");
		System.out.println(username);
		if(!CheckUtil.CheckPwd(password)){
			result=new ActionResult(ResultCode.FAILURE,ResultCode.getRstMsg(ResultCode.FAILURE));
		}else{
			userService.insertUser(username,password,emailOrTel);
			result=new ActionResult(ResultCode.SUCCESS,ResultCode.getRstMsg(ResultCode.SUCCESS));
		}
		returnBack(result);
	}
			
	
}
