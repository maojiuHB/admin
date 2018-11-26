package cn.videon.meeting.voice.service.mapper;

import cn.videon.meeting.voice.domain.*;
import cn.videon.meeting.voice.service.dto.MeetingRoomFunctionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity MeetingRoomFunction and its DTO MeetingRoomFunctionDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MeetingRoomFunctionMapper extends EntityMapper<MeetingRoomFunctionDTO, MeetingRoomFunction> {



    default MeetingRoomFunction fromId(Long id) {
        if (id == null) {
            return null;
        }
        MeetingRoomFunction meetingRoomFunction = new MeetingRoomFunction();
        meetingRoomFunction.setId(id);
        return meetingRoomFunction;
    }
}
