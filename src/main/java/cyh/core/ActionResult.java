package cyh.core;

import cyh.util.CheckUtil;

public class ActionResult {
	private int rstCode;
	private String rstId;
	private String rstMsg;
	private Object data;
	public ActionResult(int rstCode) {
		this.rstCode = rstCode;
	}
	public ActionResult(int rstCode,String rstMsg) {
		this.rstCode = rstCode;
		this.rstMsg = rstMsg;
	}
	public int getRstCode() {
		return rstCode;
	}
	public void setRstCode(int rstCode) {
		this.rstCode = rstCode;
	}
	public String getRstId() {
		return rstId;
	}
	public void setRstId(String rstId) {
		this.rstId = rstId;
	}
	public String getRstMsg() {
		return rstMsg;
	}
	public void setRstMsg(String rstMsg) {
		if(CheckUtil.isEmpty(rstMsg)){
			rstMsg=ResultCode.getRstMsg(rstCode);
		}
		this.rstMsg = rstMsg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
