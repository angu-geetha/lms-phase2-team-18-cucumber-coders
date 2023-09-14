package stepDefinition;

import java.util.ArrayList;
import java.util.Map;

import pageObjects.AssignmentPage;
import pageObjects.BasePage;
import pageObjects.ProgramPage;
import pageObjects.UserPage;

public class Commonclass {
	String baseUrl = "https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms";

	BasePage basePage = new BasePage();
	AssignmentPage assignmentPage = new AssignmentPage();
	ProgramPage programPage = new ProgramPage();
	UserPage userPage = new UserPage();
	
	
	ArrayList<String> newAssignmentInputFeilds = new ArrayList<>();
	ArrayList<String> rowData = new ArrayList<>();
	
	public ArrayList<String>  getNewAssignmentInputFeilds() {
		
		newAssignmentInputFeilds.add("Program name");
		newAssignmentInputFeilds.add("batch number");
		newAssignmentInputFeilds.add("Assignment Name");
		newAssignmentInputFeilds.add("Assignment Description");
		newAssignmentInputFeilds.add("grade by");
		newAssignmentInputFeilds.add("Assignment due date");
		newAssignmentInputFeilds.add("Assignment File1");
		newAssignmentInputFeilds.add("Assignment File2");
		newAssignmentInputFeilds.add("Assignment File3");
		newAssignmentInputFeilds.add("Assignment File4");
		newAssignmentInputFeilds.add("Assignment File5");
		return newAssignmentInputFeilds ;
	}
	
	public ArrayList<String>  getNewProgramInputFields() {
		
		newAssignmentInputFeilds.add("Name");
		newAssignmentInputFeilds.add("Description");
		newAssignmentInputFeilds.add("Active");
		newAssignmentInputFeilds.add("InActive");
		
		return newAssignmentInputFeilds ;
	}
	
	static long startTime;
	static long endTime;
	static long totalTime;
	static String textname;
	Map<String, String> excelDataMap;

}
