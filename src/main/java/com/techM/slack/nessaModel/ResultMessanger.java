package com.techM.slack.nessaModel;

/*public class ResultMessanger {

}
*/
public class ResultMessanger
{
    private CurrentEntity currentEntity;

    private String speech;

    private String query;

    private String reply;

    private contexts[] contexts;

    private Entities[] entities;

    private Intent intent;

    public contexts[] getContexts() {
		return contexts;
	}

	public void setContexts(contexts[] contexts) {
		this.contexts = contexts;
	}

	public CurrentEntity getCurrentEntity ()
    {
        return currentEntity;
    }

    public void setCurrentEntity (CurrentEntity currentEntity)
    {
        this.currentEntity = currentEntity;
    }

    public String getSpeech ()
    {
        return speech;
    }

    public void setSpeech (String speech)
    {
        this.speech = speech;
    }

    public String getQuery ()
    {
        return query;
    }

    public void setQuery (String query)
    {
        this.query = query;
    }

    public String getReply ()
    {
        return reply;
    }

    public void setReply (String reply)
    {
        this.reply = reply;
    }


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
        return "ClassPojo [currentEntity = "+currentEntity+", speech = "+speech+", query = "+query+", reply = "+reply+", contexts = "+contexts+", entities = "+entities+", intent = "+intent+"]";
    }
}