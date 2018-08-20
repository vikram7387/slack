package com.techM.slack.nessaModel;

public class Approver
{
    private String link;

    private String value;
    
    
    public Approver() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Approver(String str)
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

    @Override
    public String toString()
    {
        return "ClassPojo [link = "+link+", value = "+value+"]";
    }
}
