package com.techM.slack.nessaModel;

public class RtmResult
{
	  private String rtmnumber;

	    private String short_description;

	    private String requestNo;

	    private String state;
	    
	    private String ritmApproval;
	    
	    private String sys_created_on;
	    
	    private String requestApproval;    

		private String name;
	    
		private String requestApproverName;
	    
		private String sys_id;
		
	    public String getSys_id() {
			return sys_id;
		}

		public void setSys_id(String sys_id) {
			this.sys_id = sys_id;
		}

	    public String getRequestApproverName() {
			return requestApproverName;
		}

		public void setRequestApproverName(String requestApproverName) {
			this.requestApproverName = requestApproverName;
		}

		
	    public String getRitmApproval() {
			return ritmApproval;
		}

		public void setRitmApproval(String ritmApproval) {
			this.ritmApproval = ritmApproval;
		}

		public String getSys_created_on() {
			return sys_created_on;
		}

		public void setSys_created_on(String sys_created_on) {
			this.sys_created_on = sys_created_on;
		}

		public String getRequestApproval() {
			return requestApproval;
		}

		public void setRequestApproval(String requestApproval) {
			this.requestApproval = requestApproval;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	    public String getRtmnumber ()
	    {
	        return rtmnumber;
	    }

	    public void setRtmnumber (String rtmnumber)
	    {
	        this.rtmnumber = rtmnumber;
	    }

	    public String getShort_description ()
	    {
	        return short_description;
	    }

	    public void setShort_description (String short_description)
	    {
	        this.short_description = short_description;
	    }

	    public String getRequestNo ()
	    {
	        return requestNo;
	    }

	    public void setRequestNo (String requestNo)
	    {
	        this.requestNo = requestNo;
	    }

	    public String getState ()
	    {
	        return state;
	    }

	    public void setState (String state)
	    {
	        this.state = state;
	    }

		@Override
		public String toString() {
			return "RtmResult [rtmnumber=" + rtmnumber + ", short_description=" + short_description + ", requestNo="
					+ requestNo + ", state=" + state + ", ritmApproval=" + ritmApproval + ", sys_created_on="
					+ sys_created_on + ", requestApproval=" + requestApproval + ", name=" + name + "]";
		}

}