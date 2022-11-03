package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.samples.petclinic.model.NamedEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recovery_room")

public class RecoveryRoom extends NamedEntity{
	@PositiveOrZero
    double size;
    boolean secure;
    @Transient
    RecoveryRoomType roomType;
}
