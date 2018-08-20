package com.techM.slack.nessaModel;



public class MessengerResult
{
	 private String query;

	    private String reply;
	  //  @JsonProperty("contexts")
	    private contexts[] contexts;
	  //  @JsonProperty("entities")
	    private Entities[] entities;
	    private String speech;
	    private CurrentEntity currentEntity;
	    //private String  current_entity;
	    private Intent intent;
	    
	    private Info info;
		
	    private Messages messages;
		

		// Changes by tushar
			    
	    public Info getInfo() {
			return info;
		}
		public void setInfo(Info info) {
			this.info = info;
		}


		public Messages getMessages() {
			return messages;
		}
		public void setMessages(Messages messages) {
			this.messages = messages;
		}

	   
		public CurrentEntity getCurrentEntity() {
			return currentEntity;
		}

		public void setCurrentEntity(CurrentEntity currentEntity) {
			this.currentEntity = currentEntity;
		}

		public String getSpeech() {
			return speech;
		}

		public void setSpeech(String speech) {
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

	    public contexts[] getContexts() {
			return contexts;
		}

		public void setContexts(contexts[] contexts) {
			this.contexts = contexts;
		}

		public Entities[] getEntities() {
			return entities;
		}

		public void setEntities(Entities[] entities) {
			this.entities = entities;
		}

		public Intent getIntent() {
			return intent;
		}

		public void setIntent(Intent intent) {
			this.intent = intent;
		}
		
	/*
		public String getCurrent_entity() {
			return current_entity;
		}

		public void setCurrent_entity(String current_entity) {
			this.current_entity = current_entity;
		}*/

		@Override
	    public String toString()
	    {
	        return "ClassPojo [query = "+query+", reply = "+reply+", contexts = "+contexts+", entities = "+entities+", intent = "+intent+",info = "+info+", messages="+messages+"]";
	    }
	}
	

   /* private String query;

    private String reply;
  //  @JsonProperty("contexts")
    private contexts contexts;
  //  @JsonProperty("entities")
    private entities entities;

    private Intent intent;
    private String speech;
    private CurrentEntity currentEntity;

    
    
    
    
    public CurrentEntity getCurrentEntity() {
		return currentEntity;
	}

	public void setCurrentEntity(CurrentEntity currentEntity) {
		this.currentEntity = currentEntity;
	}

	public String getSpeech() {
		return speech;
	}

	public void setSpeech(String speech) {
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


    public contexts getContexts() {
		return contexts;
	}

	public void setContexts(contexts contexts) {
		this.contexts = contexts;
	}

	public entities getEntities() {
		return entities;
	}

	public void setEntities(entities entities) {
		this.entities = entities;
	}

	

    public Intent getIntent() {
		return intent;
	}

	public void setIntent(Intent intent) {
		this.intent = intent;
	}

	@Override
    public String toString()
    {
        return "ClassPojo [query = "+query+", reply = "+reply+", contexts = "+contexts+", entities = "+entities+", intent = "+intent+"]";
    }
}*/