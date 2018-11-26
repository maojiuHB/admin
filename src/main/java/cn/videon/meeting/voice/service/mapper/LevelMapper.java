package cn.videon.meeting.voice.service.mapper;

import cn.videon.meeting.voice.domain.*;
import cn.videon.meeting.voice.service.dto.LevelDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Level and its DTO LevelDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface LevelMapper extends EntityMapper<LevelDTO, Level> {



    default Level fromId(Long id) {
        if (id == null) {
            return null;
        }
        Level level = new Level();
        level.setId(id);
        return level;
    }
}
