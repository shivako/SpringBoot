package com.shiva.sample.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Teammate> members;

    private Team() {
        members = new ArrayList();
    }

    public Team(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teammate> getMembers() {
        return members;
    }

    public void setMembers(List<Teammate> members) {
        this.members = members;
    }

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", members="+members  + "]";
	}
    
    
}
