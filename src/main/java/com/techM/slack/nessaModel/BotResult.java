package com.techM.slack.nessaModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown=true)
public class BotResult
{
	
    private Messages message;

    private ResultMessanger result;

    private String source;

    private String timeStamp;

    /*@JsonProperty("icard")
    private ICard icard;
    
    @JsonProperty("ICard")
    private ICard ICard;
    */
    @JsonProperty("iCard")
    private ICard iCard;

    private Action action;

    private String language;

    private String user;

    public Messages getMessage ()
    {
        return message;
    }

    public void setMessage (Messages message)
    {
        this.message = message;
    }

    public ResultMessanger getResult ()
    {
        return result;
    }

    public void setResult (ResultMessanger result)
    {
        this.result = result;
    }

    public String getSource ()
    {
        return source;
    }

    public void setSource (String source)
    {
        this.source = source;
    }

    public String getTimeStamp ()
    {
        return timeStamp;
    }

    public void setTimeStamp (String timeStamp)
    {
        this.timeStamp = timeStamp;
    }

    public ICard getICard ()
    {
        return iCard;
    }

    public void setICard (ICard iCard)
    {
        this.iCard = iCard;
    }

    public Action getAction ()
    {
        return action;
    }

    public void setAction (Action action)
    {
        this.action = action;
    }

    public String getLanguage ()
    {
        return language;
    }

    public void setLanguage (String language)
    {
        this.language = language;
    }

    public String getUser ()
    {
        return user;
    }

    public void setUser (String user)
    {
        this.user = user;
    }

	@Override
	public String toString() {
		return "BotResult [message=" + message + ", result=" + result + ", source=" + source + ", timeStamp="
				+ timeStamp + ", iCard=" + iCard + ", action=" + action + ", language=" + language + ", user=" + user
				+ "]";
	}

    
}
/*public class BotResult {
	private String source;
	private Action action;
	private String user;
	private String timestamp;
	private MessengerResult result;
	private Info info;
	private Recipient recipient;
	private Messages message;

	// Changes by tushar

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public Messages getMessages() {
		return message;
	}

	public void setMessages(Messages messages) {
		this.message = messages;
	}

	public Recipient getRecipient() {
		return recipient;
	}

	public void setRecipient(Recipient recipient) {
		this.recipient = recipient;
	}

	public MessengerResult getResult() {
		return result;
	}

	public void setResult(MessengerResult result) {
		this.result = result;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ClassPojo [timestamp = " + timestamp + ", result = " + result + ", source = " + source + ", action = "
				+ action + ", user = " + user + " , messages = " + message + ", info = " + info + " , recipient ="
				+ recipient + "]";
	}
}*/