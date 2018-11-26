package cn.videon.meeting.voice.service.dto;

import java.io.Serializable;
import java.util.Objects;
import cn.videon.meeting.voice.domain.enumeration.DataType;

/**
 * A DTO for the DataDictionary entity.
 */
public class DataDictionaryDTO implements Serializable {

    private Long id;

    private String name;

    private String description;

    private DataType datatype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DataType getDatatype() {
        return datatype;
    }

    public void setDatatype(DataType datatype) {
        this.datatype = datatype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DataDictionaryDTO dataDictionaryDTO = (DataDictionaryDTO) o;
        if (dataDictionaryDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), dataDictionaryDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DataDictionaryDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", datatype='" + getDatatype() + "'" +
            "}";
    }
}
