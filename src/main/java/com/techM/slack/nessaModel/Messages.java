package com.techM.slack.nessaModel;

public class Messages{
	
	private Data data;

	    private String chat;
	    private String flag;

	    public Data getData ()
	    {
	        return data;
	    }

	    public void setData (Data data)
	    {
	        this.data = data;
	    }

	    public String getChat ()
	    {
	        return chat;
	    }

	    public void setChat (String chat)
	    {
	        this.chat = chat;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [data = "+data+", chat = "+chat+"]";
	    }

		public String getFlag() {
			return flag;
		}

		public void setFlag(String flag) {
			this.flag = flag;
		}
	}
				
