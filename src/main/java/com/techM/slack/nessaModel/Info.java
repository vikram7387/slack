package com.techM.slack.nessaModel;
import java.util.List;


public class Info {
	
	private String image;
	private String video;
	private String audio;
	private String text;
	private String catalogValue;
	private String file;
	private String documents;
	private List<RequestDto> requestList;
	private List<IncidentDetails> incidentDetailsList;
	private List<IncidentDetailsTechM> incidentdetailstechM;
	private List<IncidentDetailsTechM> Top_five_incidentdetailstechM;
	private List<IncidentDetailsTechM> incidentdetailstechMTopFive;
	private List<TechMIncidnetDetailbyId> techMIncidnetDetailbyId;
	private String multipleView;
    private List<IncidentDetailsTechM> bothIncidentdetailsTechM ;	
	private List<IncidentDetailsTechM> bothtechMTopFive;
	
	private List<KnowledgeServiceNow> KnowledgeServiceNow;
	private List<RITMDetailsList> ritmDetailsList;
	private List<RtmResult> topfive;
	private List<IncidentDetailsTechM> requestDetailsTechM;
	private List<ListRITMDetailsAll> allRitmList;
	
	private List<IncidentDetailsTechM> showAllIncident;
    
	public List<IncidentDetailsTechM> getShowAllIncident() {
		return showAllIncident;
	}
	public void setShowAllIncident(List<IncidentDetailsTechM> showAllIncident) {
		this.showAllIncident = showAllIncident;
	}
	public List<ListRITMDetailsAll> getAllRitmList() {
		return allRitmList;
	}
	public void setAllRitmList(List<ListRITMDetailsAll> allRitmList) {
		this.allRitmList = allRitmList;
	}
	
	public List<RtmResult> getTopfive() {
		return topfive;
	}
	
	public void setTopfive(List<RtmResult> topfive) {
		this.topfive = topfive;
	}

	public List<RITMDetailsList> getRitmDetailsList() {
		return ritmDetailsList;

	}

	public void setRitmDetailsList(List<RITMDetailsList> ritmDetailsList) {
		this.ritmDetailsList = ritmDetailsList;

	}
	
	public List<KnowledgeServiceNow> getKnowledgeServiceNow() {
		return KnowledgeServiceNow;
	}
	public void setKnowledgeServiceNow(List<KnowledgeServiceNow> knowledgeServiceNow) {
		KnowledgeServiceNow = knowledgeServiceNow;
	}
	
	public List<IncidentDetailsTechM> getRequestDetailsTechM() {
		return requestDetailsTechM;
	}
	public void setRequestDetailsTechM(List<IncidentDetailsTechM> requestDetailsTechM) {
		this.requestDetailsTechM = requestDetailsTechM;
	}
	
	public String getCatalogValue() {
		return catalogValue;
	}
	public void setCatalogValue(String catalogValue) {
		this.catalogValue = catalogValue;
	}
	public List<IncidentDetailsTechM> getBothIncidentdetailsTechM() {
		return bothIncidentdetailsTechM;
	}
	public void setBothIncidentdetailsTechM(List<IncidentDetailsTechM> bothIncidentdetailsTechM) {
		this.bothIncidentdetailsTechM = bothIncidentdetailsTechM;
	}
	public List<IncidentDetailsTechM> getBothtechMTopFive() {
		return bothtechMTopFive;
	}
	public void setBothtechMTopFive(List<IncidentDetailsTechM> bothtechMTopFive) {
		this.bothtechMTopFive = bothtechMTopFive;
	}
	public List<IncidentDetailsTechM> getTop_five_incidentdetailstechM() {
		return Top_five_incidentdetailstechM;
	}
	public void setTop_five_incidentdetailstechM(List<IncidentDetailsTechM> top_five_incidentdetailstechM) {
		Top_five_incidentdetailstechM = top_five_incidentdetailstechM;
	}
	public List<IncidentDetailsTechM> getIncidentdetailstechMTopFive() {
		return incidentdetailstechMTopFive;
	}
	public void setIncidentdetailstechMTopFive(List<IncidentDetailsTechM> incidentdetailstechMTopFive) {
		this.incidentdetailstechMTopFive = incidentdetailstechMTopFive;
	}
	public List<TechMIncidnetDetailbyId> getTechMIncidnetDetailbyId() {
		return techMIncidnetDetailbyId;
	}
	public void setTechMIncidnetDetailbyId(List<TechMIncidnetDetailbyId> techMIncidnetDetailbyId) {
		this.techMIncidnetDetailbyId = techMIncidnetDetailbyId;
	}
	public List<IncidentDetailsTechM> getIncidentdetailstechM() {
		return incidentdetailstechM;
	}
	public void setIncidentdetailstechM(List<IncidentDetailsTechM> incidentdetailstechM) {
		this.incidentdetailstechM = incidentdetailstechM;
	}
	public List<RequestDto> getRequestList() {
		return requestList;
	}
	public void setRequestList(List<RequestDto> requestList) {
		this.requestList = requestList;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getAudio() {
		return audio;
	}
	public void setAudio(String audio) {
		this.audio = audio;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getDocuments() {
		return documents;
	}
	public void setDocuments(String documents) {
		this.documents = documents;
	}
	public List<IncidentDetails> getIncidentDetailsList() {
		return incidentDetailsList;
	}
	public void setIncidentDetailsList(List<IncidentDetails> incidentDetailsList) {
		this.incidentDetailsList = incidentDetailsList;
	}
	public String getMultipleView() {
		return multipleView;
	}
	public void setMultipleView(String multipleView) {
		this.multipleView = multipleView;
	}
	

}
