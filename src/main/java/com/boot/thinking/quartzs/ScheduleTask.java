package com.boot.thinking.quartzs;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {
    @Scheduled(cron = "0/1 * * * * ?")
    public void Test(){
        System.out.println("定时任务开始");
    }

}
