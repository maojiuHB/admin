package cn.videon.meeting.voice.service.mapper;

import cn.videon.meeting.voice.domain.*;
import cn.videon.meeting.voice.service.dto.UserLevelDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity UserLevel and its DTO UserLevelDTO.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class, LevelMapper.class})
public interface UserLevelMapper extends EntityMapper<UserLevelDTO, UserLevel> {

    @Mapping(source = "user.id", target = "userId")
    UserLevelDTO toDto(UserLevel userLevel);

    @Mapping(source = "userId", target = "user")
    UserLevel toEntity(UserLevelDTO userLevelDTO);

    default UserLevel fromId(Long id) {
        if (id == null) {
            return null;
        }
        UserLevel userLevel = new UserLevel();
        userLevel.setId(id);
        return userLevel;
    }
}
