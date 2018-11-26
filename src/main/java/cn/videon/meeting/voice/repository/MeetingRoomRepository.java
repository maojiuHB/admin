package cn.videon.meeting.voice.repository;

import cn.videon.meeting.voice.domain.MeetingRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the MeetingRoom entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Long> {

    @Query(value = "select distinct meeting_room from MeetingRoom meeting_room left join fetch meeting_room.meetingRoomFunctions",
        countQuery = "select count(distinct meeting_room) from MeetingRoom meeting_room")
    Page<MeetingRoom> findAllWithEagerRelationships(Pageable pageable);

    @Query(value = "select distinct meeting_room from MeetingRoom meeting_room left join fetch meeting_room.meetingRoomFunctions")
    List<MeetingRoom> findAllWithEagerRelationships();

    @Query("select meeting_room from MeetingRoom meeting_room left join fetch meeting_room.meetingRoomFunctions where meeting_room.id =:id")
    Optional<MeetingRoom> findOneWithEagerRelationships(@Param("id") Long id);

}
