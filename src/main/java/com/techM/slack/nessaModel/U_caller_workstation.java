package com.techM.slack.nessaModel;

public class U_caller_workstation {

	 private String link;

	    private String value;

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

	    public U_caller_workstation (String str)
	    {
	    	if(str ==null || str.equals(""))
	    	{
	    		link=null;
	    		value=null;
	    	}  	
	    }
	    @Override
	    public String toString()
	    {
	        return "ClassPojo [link = "+link+", value = "+value+"]";
	    }
	}
			
