package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.samples.petclinic.pet.Visit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recovery_room")

public class RecoveryRoom extends NamedEntity{
	@PositiveOrZero
    private double size;
    private boolean secure;
    @Transient
    private RecoveryRoomType roomType;

}
