package com.techM.slack.nessaModel;


public class Assigned_to{
	    
	private String link;
	    private String value;

	   
	    public Assigned_to() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Assigned_to(String str)
	    {
	    	if(str ==null || str.equals(""))
	    	{
	    		link=null;
	    		value=null;
	    	}
	    	
	    }
	    public String getLink ()
	    {
	        return link;
	    }

	    public void setLink (String link)
	    {
	        this.link = link;
	    }

	    public String getValue ()
	    {
	        return value;
	    }

	    public void setValue (String value)
	    {
	        this.value = value;
	    }

}
