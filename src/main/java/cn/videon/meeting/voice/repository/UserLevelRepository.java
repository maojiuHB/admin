package cn.videon.meeting.voice.repository;

import cn.videon.meeting.voice.domain.UserLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the UserLevel entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserLevelRepository extends JpaRepository<UserLevel, Long> {

    @Query(value = "select distinct user_level from UserLevel user_level left join fetch user_level.levels",
        countQuery = "select count(distinct user_level) from UserLevel user_level")
    Page<UserLevel> findAllWithEagerRelationships(Pageable pageable);

    @Query(value = "select distinct user_level from UserLevel user_level left join fetch user_level.levels")
    List<UserLevel> findAllWithEagerRelationships();

    @Query("select user_level from UserLevel user_level left join fetch user_level.levels where user_level.id =:id")
    Optional<UserLevel> findOneWithEagerRelationships(@Param("id") Long id);

}
