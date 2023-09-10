package stepDefinition;

import java.util.Map;

import pageObjects.AssignmentPage;
import pageObjects.BasePage;
import pageObjects.ProgramPage;

public class Commonclass {
	String baseUrl = "https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms";

	BasePage basePage = new BasePage();
	AssignmentPage assignmentPage = new AssignmentPage();
	ProgramPage programPage = new ProgramPage();
	static long startTime;
	static long endTime;
	static long totalTime;
	static String textname;
	Map<String, String> excelDataMap;

}
