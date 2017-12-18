package com.navinski.student.logic;

public class Group {
	
	// variable group ID
	private int groupId;
    // variable Group Name
    private String nameGroup;
    // variable Curator
    private String curator;
    // variable Specialty
    private String speciality;
	
    // set or get Group ID
    public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	// get or set Group Name
	public String getNameGroup() {
		return nameGroup;
	}
	public void setNameGroup(String nameGroup) {
		this.nameGroup = nameGroup;
	}
	
	// get or set Curator Name
	public String getCurator() {
		return curator;
	}
	public void setCurator(String curator) {
		this.curator = curator;
	}
	
	// get or set Specialty
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", nameGroup=" + nameGroup + ", curator=" + curator + ", speciality="
				+ speciality + "]";
	}
    
    
}
