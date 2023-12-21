package com.cinchhs.batchprocessdemo;

import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBatchTest
@SpringBootTest
class BatchProcessDemoApplicationTests {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job upperCaseNamesOfExpertsJob;

    @Bean
    public JobLauncherTestUtils jobLauncherTestUtils() {
        return new JobLauncherTestUtils() {
            @Override
            public Job getJob() {
                return upperCaseNamesOfExpertsJob;
            }
        };
    }

    @Test
    public void givenAJob_whenJobExecuted_thenSuccess() throws Exception {
        // when
        JobExecution jobExecution = jobLauncherTestUtils.launchJob(new JobParameters());

        // Then Assert Job Execution Status
        assertEquals(org.springframework.batch.core.BatchStatus.COMPLETED, jobExecution.getStatus());

        // Assert Job Name
        assertEquals("upperCaseNamesOfExpertsJob", jobExecution.getJobInstance().getJobName());
    }

}
