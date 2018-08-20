package com.techM.slack.nessaModel;

public class Sys_domain {
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

    public Sys_domain (String str)
    {
    	if(str ==null || str.equals(""))
    	{
    		link=null;
    		value=null;
    	}  	
    }
  
}
