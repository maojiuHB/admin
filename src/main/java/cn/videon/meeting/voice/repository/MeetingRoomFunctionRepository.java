package cn.videon.meeting.voice.repository;

import cn.videon.meeting.voice.domain.MeetingRoomFunction;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the MeetingRoomFunction entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MeetingRoomFunctionRepository extends JpaRepository<MeetingRoomFunction, Long> {

}
