package com.techM.slack.nessaModel;

	public class KnowledgeServiceNow
	{
	    private String short_description;

	    private String number;
	    
	  	public String getShort_description ()
	    {
	        return short_description;
	    }

	    public void setShort_description (String short_description)
	    {
	        this.short_description = short_description;
	    }

	    public String getNumber ()
	    {
	        return number;
	    }

	    public void setNumber (String number)
	    {
	        this.number = number;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [short_description = "+short_description+", number = "+number+"]";
	    }
	}
				

