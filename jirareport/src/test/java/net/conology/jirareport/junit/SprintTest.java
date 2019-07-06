package net.conology.jirareport.junit;

import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import net.conology.jirareport.model.jira.SimplifiedIssue;
import net.conology.jirareport.model.jira.Sprint;

public class SprintTest {
	
	Sprint sprint = new InitSprint().createSprint();
	
	@Test
	void testGetIssues() {
		ArrayList<SimplifiedIssue> issues = sprint.getIssues();
		assertNotNull("Shoudln't be null",issues);
		
	}

}
