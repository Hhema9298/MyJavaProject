package dao;

import java.util.List;
import model.Job;

public interface IJobDao {
	
	List<Job> getAllJobs();
	void addJob(Job j);
	void getJobById(Job j);
	void updateJob(Job j);
	void deactivateJob(Job id);
	void deleteJob(Job id);
	void activateJob(Job id);
	
}
