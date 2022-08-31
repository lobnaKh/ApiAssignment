package com.assignment.api.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class BaseEntity implements Serializable, PreInsertEventListener, PreUpdateEventListener {

	private static final long serialVersionUID = 1L;

	@Column(name = "CREATION_DATE", nullable = false)
	@JsonIgnore
	@XmlTransient
	private Date creationDate;

	@Column(name = "LAST_MODIFIED_DATE")
	@JsonIgnore
	@XmlTransient
	private Date lastModifiedDate;

	@Override
	public boolean onPreInsert(PreInsertEvent event) {
		if (event.getEntity() instanceof BaseEntity) {
			BaseEntity timestampEntity = (BaseEntity) event.getEntity();
			timestampEntity.creationDate = Date.from(Instant.now());
			setPropertyState(event.getState(), event.getPersister().getPropertyNames(), "creationDate",
					Date.from(Instant.now()));

		}
		return false;
	}

	@Override
	public boolean onPreUpdate(PreUpdateEvent event) {
		if (event.getEntity() instanceof BaseEntity) {
            BaseEntity timestampEntity = (BaseEntity) event.getEntity();
            timestampEntity.lastModifiedDate = Date.from(Instant.now());
            setPropertyState(event.getState(), event.getPersister().getPropertyNames(), "lastModifiedDate", Date.from(Instant.now()));
        }
        return false;
	}

	private void setPropertyState(Object[] propertyStates, String[] propertyNames, String propertyName,
			Object propertyState) {
		for (int i = 0; i < propertyNames.length; i++) {
			if (propertyName.equals(propertyNames[i])) {
				propertyStates[i] = propertyState;
				return;
			}
		}
	}

}
