package cyh.core;

public class ResultCode {
	/**操作成功**/
	public static int SUCCESS=0;
	/**操作失败**/
	public static int FAILURE=-1;
	/**用户名或密码出错**/
	public static int FAILURE_2=2;
	/**用户名或密码出错**/
	public static int FAILURE_3=3;
	/**用户名或密码出错**/
	public static int FAILURE_4=4;
	/**用户名或密码出错**/
	public static int FAILURE_5=5;
	/**用户名或密码出错**/
	public static int FAILURE_10=10;
	/**验证码超时或错误**/
	public static int FAILURE_11=11;
	/****/
	public static int FAILURE_12=12;
	/**操作失败**/
	public static int FAILURE_13=13;
	/**访问失败**/
	public static int FAILURE_101=101;
	/**
	 * 获取返回信息
	 * @param rstCode
	 * @return
	 */
	public static String getRstMsg(int rstCode){
		String rstMsg="";
		if (rstCode == ResultCode.SUCCESS) {
			rstMsg = "操作成功!";
		}else if (rstCode == ResultCode.FAILURE) {
			rstMsg = "操作失败!";
		}else if (rstCode == ResultCode.FAILURE_10) {
			rstMsg = "用户名或密码出错!";
		}else if (rstCode == ResultCode.FAILURE_11) {
			rstMsg = "验证码超时或错误!";
		}else if (rstCode == ResultCode.FAILURE_12) {
			rstMsg = "xxxxxx!";
		}else if (rstCode == ResultCode.FAILURE_13) {
			rstMsg = "xxxxxx!";
		}else if (rstCode == ResultCode.FAILURE_101) {
			rstMsg = "访问失败!";
		}
		return rstMsg;
	}
}
