package com.techM.slack.nessaModel;

public class Assignment_group {
	private String link;

    private String value;
    
    public Assignment_group() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    public Assignment_group(String str)
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
