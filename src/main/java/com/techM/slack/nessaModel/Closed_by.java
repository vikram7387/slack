package com.techM.slack.nessaModel;

public class Closed_by {
	private String link;
    private String value;
    
    public Closed_by() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Closed_by(String str)
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
