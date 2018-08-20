package com.techM.slack.nessaModel;

public class U_resolved_by_group {

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

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [link = "+link+", value = "+value+"]";
	    }
	}
