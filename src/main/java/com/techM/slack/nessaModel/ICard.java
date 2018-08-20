package com.techM.slack.nessaModel;

import java.util.Arrays;

public class ICard
{
	private String type;
   
    private Task[] tasks;
    
/*
    private EntitiesIcard[] entities;*/

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

/*    public EntitiesIcard[] getEntities ()
    {
        return entities;
    }

    public void setEntities (EntitiesIcard[] entities)
    {
        this.entities = entities;
    }*/

    /*@Override
    public String toString()
    {
        return "ClassPojo [type = "+type+", entities = "+entities+"]";
    }*/

	public Task[] getTasks() {
		return tasks;
	}

	@Override
	public String toString() {
		return "ICard [type=" + type + ", tasks=" + Arrays.toString(tasks) + "]";
	}

	public void setTasks(Task[] tasks) {
		this.tasks = tasks;
	}
}