package net.conology.jirareport.junit;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import net.conology.jirareport.model.jira.SimplifiedIssue;

public class SimplifiedIssueTest {

	
	@Test
	void testSetIssueAsignee() {
		
		SimplifiedIssue issue = new SimplifiedIssue();
		String name = "Willm";
		issue.setAssignee(name);
		assertEquals(issue.getAssignee(), name);
	}
	
}
