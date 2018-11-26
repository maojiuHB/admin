package cn.videon.meeting.voice.repository;

import cn.videon.meeting.voice.domain.Modification;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Modification entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ModificationRepository extends JpaRepository<Modification, Long> {

    @Query("select modification from Modification modification where modification.user.login = ?#{principal.username}")
    List<Modification> findByUserIsCurrentUser();

}
