package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType>{

	private RecoveryRoomService rs;
	
	@Autowired
	public RecoveryRoomTypeFormatter(RecoveryRoomService rs) {
		this.rs = rs;
	}
	
    @Override
    public String print(RecoveryRoomType rt, Locale locale) {
        return rt.getName();
    }

    @Override
    public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
    	RecoveryRoomType res = this.rs.getRecoveryRoomType(text);
		if (res != null) {
			return res;
		}
		throw new ParseException("type not found: " + text, 0);
    }
    
}
