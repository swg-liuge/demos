package com.song.schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ComplexScheduledJob extends QuartzJobBean {

    @Autowired
    private ComplexJob complexJob;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("执行quartzjobbean");
        System.out.println(complexJob);
        complexJob.hello();
    }


}
