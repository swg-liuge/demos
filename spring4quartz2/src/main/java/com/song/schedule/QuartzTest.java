package com.song.schedule;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {

    public static void main(String[] args) throws SchedulerException {
        System.out.println("start.....");
        //创建scheduler工厂
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        //创建scheduler
        Scheduler scheduler = schedulerFactory.getScheduler();

        //创建job
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withDescription("This is my job")
//                .withIdentity("song1","didi")
                .build();
        //创建trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                            .withDescription("This is my trigger")
//                            .withIdentity("song-trigger1","didi-trigger")
                            .startNow()
                            .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                            .build();
        //注册任务和定时器
        scheduler.scheduleJob(jobDetail, trigger);

        //启动
        scheduler.start();

        System.out.println("end...");


        scheduler.shutdown();
    }

    static class MyJob implements Job{

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.out.println("execute job ..........");
            System.out.println(context);
            System.out.println(context.getJobRunTime());
        }
    }
}
