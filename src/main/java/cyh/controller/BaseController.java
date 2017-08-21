package cyh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;


/**
 * @author cyh
 */
public class BaseController
{
	public Logger logger = Logger.getLogger(this.getClass());
	public HttpServletRequest request;
	public HttpServletResponse response;
	public int SUCCESS=0;
	public int FAILURE=1;
	
	@ModelAttribute
	protected void setReqAndRes(HttpServletRequest request, HttpServletResponse response)
	{
		this.request = request;
		this.response = response;
	}

	public void returnBack(Object result) throws IOException
	{
		JSONObject jsonObj=JSONObject.fromObject(result);
		logger.info("returnBack"+jsonObj.toString());
		response.setContentType("application/json;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.write(jsonObj.toString());
		writer.close();
	}
	public void returnBack(String result) throws IOException
	{
		logger.info("returnBack"+result);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.write(result);
		writer.close();
	}
	public  Map<String, Object>  getParamterMap(String [] params){
		Map<String, Object> map = new HashMap<String, Object>(); 
		for(String key :params){
			if(request.getParameter(key)!=null){
				map.put(key,request.getParameter(key));
			}
		}
		return map;
	}
	
	public Map<String,Object>  getRetMap(int retCode){
		Map<String,Object> resultMap= new HashMap<String,Object>();
		resultMap.put("retCode", retCode);
		return resultMap;
	}
}
