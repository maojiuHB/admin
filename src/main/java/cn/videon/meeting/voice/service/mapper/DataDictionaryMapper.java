package cn.videon.meeting.voice.service.mapper;

import cn.videon.meeting.voice.domain.*;
import cn.videon.meeting.voice.service.dto.DataDictionaryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity DataDictionary and its DTO DataDictionaryDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DataDictionaryMapper extends EntityMapper<DataDictionaryDTO, DataDictionary> {



    default DataDictionary fromId(Long id) {
        if (id == null) {
            return null;
        }
        DataDictionary dataDictionary = new DataDictionary();
        dataDictionary.setId(id);
        return dataDictionary;
    }
}
