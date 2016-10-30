package com.shiva.sample.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiva.sample.domain.Team;
import com.shiva.sample.domain.TeamRepository;
import com.shiva.sample.domain.Teammate;
import com.shiva.sample.domain.TeammateRepository;
@RestController
public class FirstController {

@Autowired Environment env;
	
@Autowired
TeamRepository teamRepository;

@Autowired
TeammateRepository teammateRepository;

	@RequestMapping("/")
    String home() {
		
		Team team = new Team("First Team");
		Teammate teammate = new Teammate("first", "last");
		teammate.setTeam(team);
		
/*		teammateRepository.save(teammate);
		Iterable<Teammate> teamsmates =  teammateRepository.findAll();
		for (Iterator iterator = teamsmates.iterator(); iterator.hasNext();) {
			Teammate teamm = (Teammate) iterator.next();
			System.out.println("teammate2:"+teamm);
		}*/
		
		
		List<Teammate> mates = new ArrayList<Teammate>();
		mates.add(teammate);
		team.setMembers(mates);
		teamRepository.save(team);

		Iterable<Team> teams =  teamRepository.findAll();
		for (Iterator iterator = teams.iterator(); iterator.hasNext();) {
			Team team2 = (Team) iterator.next();
			//System.out.println(team2.getMembers());
			System.out.println("teammate2:"+team2);
		}
		System.out.println("TeamsL" +teams);
		System.out.println("spring.jmx.enabled "+env.getProperty("spring.jmx.enabled"));
        return "Hello World!"+env.getProperty("app.name");
    }
}
