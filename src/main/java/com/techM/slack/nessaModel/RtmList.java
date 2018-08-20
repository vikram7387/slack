package com.techM.slack.nessaModel;

public class RtmList
{
    private RtmResult[] result;

    public RtmResult[] getResult ()
    {
        return result;
    }

    public void setResult (RtmResult[] result)
    {
        this.result = result;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [result = "+result+"]";
    }
}
