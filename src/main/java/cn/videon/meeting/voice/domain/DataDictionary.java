package cn.videon.meeting.voice.domain;

import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

import cn.videon.meeting.voice.domain.enumeration.DataType;

/**
 * 数据字典：包括楼宇，会议类型，会议桌，会议室类型
 * name：名称
 * description：描述
 * type：类型
 * status：状态
 */
@ApiModel(description = "数据字典：包括楼宇，会议类型，会议桌，会议室类型 name：名称 description：描述 type：类型 status：状态")
@Entity
@Table(name = "data_dictionary")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class DataDictionary implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "datatype")
    private DataType datatype;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public DataDictionary name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public DataDictionary description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DataType getDatatype() {
        return datatype;
    }

    public DataDictionary datatype(DataType datatype) {
        this.datatype = datatype;
        return this;
    }

    public void setDatatype(DataType datatype) {
        this.datatype = datatype;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DataDictionary dataDictionary = (DataDictionary) o;
        if (dataDictionary.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), dataDictionary.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DataDictionary{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", datatype='" + getDatatype() + "'" +
            "}";
    }
}
