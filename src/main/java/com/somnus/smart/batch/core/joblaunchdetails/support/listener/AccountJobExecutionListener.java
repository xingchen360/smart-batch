package com.somnus.smart.batch.core.joblaunchdetails.support.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.StepExecution;

/**
 * @Description: TODO
 * @author Somnus
 * @date 2015年7月30日 下午1:49:52 
 * @version V1.0
 */
public class AccountJobExecutionListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {

	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		
		for(StepExecution se:jobExecution.getStepExecutions()){
			if(!se.getStatus().equals(BatchStatus.COMPLETED)){
				jobExecution.setStatus(BatchStatus.FAILED);
				jobExecution.setExitStatus(ExitStatus.FAILED);
				break;
			}
		}
	}
	
}
