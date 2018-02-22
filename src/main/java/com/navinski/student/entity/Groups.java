package com.navinski.student.entity;

// some new text for a new commit #78-1

// some text
// additional info
// 

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
@NamedQueries({
	@NamedQuery (name = "Groups.findByGroupId",
			query = "SELECT g FROM Groups g WHERE g.groupId = :groupId"),
	@NamedQuery (name = "Groups.findByGroupName",
			query = "SELECT g FROM Groups g WHERE g.groupName = :groupName"),
	@NamedQuery (name = "Groups.findByCurator",
			query = "SELECT g FROM Groups g WHERE g.curator = :curator"),
	@NamedQuery (name = "Groups.findBySpeciality",
			query = "SELECT g FROM Groups g WHERE g.cpeciality = :cpeciality"),
})

public class Groups implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name = "group_id", nullable = false)
	private Integer groupId;
    @Column (name = "groupName", nullable = false)
    private String groupName;
    @Column (name = "curator", nullable = false)
    private String curator;
    @Column (name = "specialty", nullable = false)
    private String speciality;
    
    public Groups() {
    }
    
    public Groups(Integer groupId) {
    	this.groupId = groupId;
    }
    
    public Groups(Integer groupId, String groupName, String curator, String Speciality) {
    	this.groupId = groupId;
    	this.groupName = groupName;
    	this.curator = curator;
    	this.speciality = speciality;
    }

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getCurator() {
		return curator;
	}

	public void setCurator(String curator) {
		this.curator = curator;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Groups other = (Groups) obj;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupName=" + groupName + "]";
	}
	
    
    
}
