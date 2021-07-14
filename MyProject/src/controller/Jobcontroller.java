package controller;

import java.sql.SQLException;
import java.util.List;

import daoimpl.JobDao;
import model.Job;

public class Jobcontroller {
	
	JobDao jdao =null;
	
	public Jobcontroller() throws ClassNotFoundException, SQLException {
		jdao = new JobDao();
	}

	public void addJob(String s1,String s2,String s3, String s4, String s5,String s6) {
		Job j =  new Job();
		
		j.setJobTitle(s1);
		j.setJobDescription(s2);
		j.setCompanyName(s3);
		j.setLocation(s4);
		j.setKeySkill(s5);
		j.setSalary(s6);
		
		jdao.addJob(j);	
	}


public void getAllJobs() {
	List<Job> allJobList = jdao.getAllJobs();
	for(Job j : allJobList) {
		System.out.println(j);
	}
}

public Job getJobById(int id) {
	Job j = new Job();
	j.setJobId(id);
	jdao.getJobById(j);
	return j;
}

public Job activateJob(int EID) {
	Job j = new Job();
	j.setJobId(EID);
	jdao.activateJob(j);
	 return j;
}

public Job deactivateJob(int EID) {
	Job j = new Job();
	j.setJobId(EID);
	jdao.deactivateJob(j);
	 return j;
}

public Job deleteJob(int JID) {
	Job j = new Job();
	j.setJobId(JID);
	jdao.deleteJob(j);
	return j;
}

}