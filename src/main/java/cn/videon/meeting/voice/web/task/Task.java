package cn.videon.meeting.voice.web.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static javax.management.timer.Timer.ONE_HOUR;

@Service
@EnableScheduling
public class Task {

    private static final Logger log = LoggerFactory.getLogger(Task.class);


    @Scheduled(fixedRate = ONE_HOUR, initialDelay = 1000)
    private void task(){

    }

}
