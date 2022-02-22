package com.example.bancopan.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public class DomainModel<T extends DomainModel<T>> implements Serializable {
    private static final long serialVersionUID = 6325905633364486954L;
    public static final String ID = "id";
    public static final String DATE_MODEL = "dateModel";
    @Id
    @GeneratedValue
    private Long id;
    @Embedded
    private DateModel dateModel;
    @Version
    private Integer version;

    public DomainModel() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateModel getDateModel() {
        return this.dateModel;
    }

    public void setDateModel(DateModel dateModel) {
        this.dateModel = dateModel;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @PrePersist
    public void initializeDates() {
        LocalDateTime now = LocalDateTime.now();
        this.dateModel = new DateModel(now, now);
    }

    @PreUpdate
    public void updateUpdatedAt() {
        this.dateModel.setUpdatedAt(LocalDateTime.now());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            DomainModel<?> other = (DomainModel)obj;
            if (this.dateModel == null) {
                if (other.dateModel != null) {
                    return false;
                }
            } else if (!this.dateModel.equals(other.dateModel)) {
                return false;
            }

            if (this.id == null) {
                if (other.id != null) {
                    return false;
                }
            } else if (!this.id.equals(other.id)) {
                return false;
            }

            if (this.version == null) {
                if (other.version != null) {
                    return false;
                }
            } else if (!this.version.equals(other.version)) {
                return false;
            }

            return true;
        }
    }
}