package vo;

public class GoodsInfo {

	
	 private String gID;
	 private String gNAME;
	 private int gNUM;
	 private String gMEMO;
	 
	 
	public void prt() {
		System.out.println("���̵�:" + gID);
		System.out.println("��ǰ�̸�:" + gNAME);
		System.out.println("��ǰ����:" + gNUM);
		System.out.println(gMEMO);
		System.out.println("--------------");
	}
	
	public String getgID() {
		return gID;
	}
	public void setgID(String gID) {
		this.gID = gID;
	}
	public String getgNAME() {
		return gNAME;
	}
	public void setgNAME(String gNAME) {
		this.gNAME = gNAME;
	}
	public int getgNUM() {
		return gNUM;
	}
	public void setgNUM(int gNUM) {
		this.gNUM = gNUM;
	}
	public String getgMEMO() {
		return gMEMO;
	}

	public void setgMEMO(String gMEMO) {
		this.gMEMO = gMEMO;
	}
	
	
}
