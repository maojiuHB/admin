package cn.videon.meeting.voice.repository;

import cn.videon.meeting.voice.domain.DataDictionary;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the DataDictionary entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DataDictionaryRepository extends JpaRepository<DataDictionary, Long> {

}
