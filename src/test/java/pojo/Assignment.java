package pojo;

import java.util.ArrayList;

public class Assignment {
	String programName;
	String batchNumber;
	String assignmentName;
	String assignmentDescription;
	String gradeBy;
	String assignmentDueDate;
	String assignmentFile1;
	String assignmentFile2;
	String assignmentFile3;
	String assignmentFile4;
	String assignmentFile5;
	ArrayList<String> assignmentRow;
	
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	public String getAssignmentName() {
		return assignmentName;
	}
	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}
	public String getAssignmentDescription() {
		return assignmentDescription;
	}
	public void setAssignmentDescription(String assignmentDescription) {
		this.assignmentDescription = assignmentDescription;
	}
	public String getGradeBy() {
		return gradeBy;
	}
	public void setGradeBy(String gradeBy) {
		this.gradeBy = gradeBy;
	}
	public String getAssignmentDueDate() {
		return assignmentDueDate;
	}
	public void setAssignmentDueDate(String assignmentDueDate) {
		this.assignmentDueDate = assignmentDueDate;
	}
	public String getAssignmentFile1() {
		return assignmentFile1;
	}
	public void setAssignmentFile1(String assignmentFile1) {
		this.assignmentFile1 = assignmentFile1;
	}
	public String getAssignmentFile2() {
		return assignmentFile2;
	}
	public void setAssignmentFile2(String assignmentFile2) {
		this.assignmentFile2 = assignmentFile2;
	}
	public String getAssignmentFile3() {
		return assignmentFile3;
	}
	public void setAssignmentFile3(String assignmentFile3) {
		this.assignmentFile3 = assignmentFile3;
	}
	public String getAssignmentFile4() {
		return assignmentFile4;
	}
	public void setAssignmentFile4(String assignmentFile4) {
		this.assignmentFile4 = assignmentFile4;
	}
	public String getAssignmentFile5() {
		return assignmentFile5;
	}
	public void setAssignmentFile5(String assignmentFile5) {
		this.assignmentFile5 = assignmentFile5;
	}
	
	public ArrayList<String> getAssignmentRow() {
		if(this.assignmentRow == null) {
			assignmentRow = new ArrayList<String>();
		}
		if(!programName.isEmpty())
			assignmentRow.add(programName);
		if(!batchNumber.isEmpty())
			assignmentRow.add(batchNumber);
		if(!assignmentName.isEmpty())
			assignmentRow.add(assignmentName);
		
		if(!assignmentDescription.isEmpty())
			assignmentRow.add(assignmentDescription);
		if(!gradeBy.isEmpty())
			assignmentRow.add(gradeBy);
		if(!assignmentDueDate.isEmpty())
			assignmentRow.add(assignmentDueDate);
		if(!assignmentFile1.isEmpty())
			assignmentRow.add(assignmentFile1);
		if(!assignmentFile2.isEmpty())
			assignmentRow.add(assignmentFile2);
		if(!assignmentFile3.isEmpty())
			assignmentRow.add(assignmentFile3);
		if(!assignmentFile4.isEmpty())
			assignmentRow.add(assignmentFile4);
		if(!assignmentFile5.isEmpty())
			assignmentRow.add(assignmentFile5);
		
		return assignmentRow;
	}

	

}
