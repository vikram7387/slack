package com.techM.slack.nessaModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Action
{
    private Entities[] entities;

    private Intent intent;

    public Entities[] getEntities ()
    {
        return entities;
    }

    public void setEntities (Entities[] entities)
    {
        this.entities = entities;
    }

    public Intent getIntent ()
    {
        return intent;
    }

    public void setIntent (Intent intent)
    {
        this.intent = intent;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [entities = "+entities+", intent = "+intent+"]";
    }
}