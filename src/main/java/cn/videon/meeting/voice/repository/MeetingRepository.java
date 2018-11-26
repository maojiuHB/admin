package cn.videon.meeting.voice.repository;

import cn.videon.meeting.voice.domain.Meeting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the Meeting entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {

    @Query(value = "select distinct meeting from Meeting meeting left join fetch meeting.meetingRoomFunctions",
        countQuery = "select count(distinct meeting) from Meeting meeting")
    Page<Meeting> findAllWithEagerRelationships(Pageable pageable);

    @Query(value = "select distinct meeting from Meeting meeting left join fetch meeting.meetingRoomFunctions")
    List<Meeting> findAllWithEagerRelationships();

    @Query("select meeting from Meeting meeting left join fetch meeting.meetingRoomFunctions where meeting.id =:id")
    Optional<Meeting> findOneWithEagerRelationships(@Param("id") Long id);

}
