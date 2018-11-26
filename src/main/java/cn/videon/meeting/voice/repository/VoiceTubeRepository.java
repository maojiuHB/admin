package cn.videon.meeting.voice.repository;

import cn.videon.meeting.voice.domain.VoiceTube;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the VoiceTube entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VoiceTubeRepository extends JpaRepository<VoiceTube, Long> {

}
