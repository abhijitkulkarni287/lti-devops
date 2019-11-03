package model;
//MODEL CLASS
public class ChiefMinister 
{
	//Variables
	private int cid;
	private String cname;
	private String qualification;
	private String state;
	private String endDate;
	private String party;
	
	//Constructor
	public ChiefMinister(int cid,String cname,String qualification,String state,String endDate,String party) 
	{
		this.cid=cid;
		this.cname=cname;
		this.qualification=qualification;
		this.state=state;
		this.endDate=endDate;
		this.party=party;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}
	
	
}
