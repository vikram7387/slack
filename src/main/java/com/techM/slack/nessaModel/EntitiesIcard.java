package com.techM.slack.nessaModel;

/*public class EntitiesIcard {

}*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class EntitiesIcard
{
    private String isActive;

    private String id;

    private String isVisible;

    private String name;

    private String value;

    private String label;

    private String type;

    private String entityType;

    public String getIsActive ()
    {
        return isActive;
    }

    public void setIsActive (String isActive)
    {
        this.isActive = isActive;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getIsVisible ()
    {
        return isVisible;
    }

    public void setIsVisible (String isVisible)
    {
        this.isVisible = isVisible;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    public String getLabel ()
    {
        return label;
    }

    public void setLabel (String label)
    {
        this.label = label;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getEntityType ()
    {
        return entityType;
    }

    public void setEntityType (String entityType)
    {
        this.entityType = entityType;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [isActive = "+isActive+", id = "+id+", isVisible = "+isVisible+", name = "+name+", value = "+value+", label = "+label+", type = "+type+", entityType = "+entityType+"]";
    }
}
			
	