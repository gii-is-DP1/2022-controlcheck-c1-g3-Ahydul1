package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
    
    private RecoveryRoomService s;
    
    @Autowired
    public RecoveryRoomController(RecoveryRoomService s){
        this.s = s;
    }

    @GetMapping("/create")
    public ModelAndView get(){
        ModelAndView res = new ModelAndView("recoveryroom/createOrUpdateRecoveryRoomForm");
        res.addObject("recoveryRoom", new RecoveryRoom());
        res.addObject("types", s.getAllRecoveryRoomTypes());
        return res;
    }

    @PostMapping("/create")
	public ModelAndView processCreationForm(@Valid RecoveryRoom rm, BindingResult result) {		
		if (result.hasErrors()) {
            ModelAndView res = new ModelAndView("recoveryroom/createOrUpdateRecoveryRoomForm");
            res.addObject("recoveryRoom", rm);
            res.addObject("types", s.getAllRecoveryRoomTypes());
			return res;
		}
		else {
            try {
                s.save(rm);
            } catch (Exception e) {
                ModelAndView res = new ModelAndView("recoveryroom/createOrUpdateRecoveryRoomForm");
                res.addObject("recoveryRoom", rm);
                res.addObject("types", s.getAllRecoveryRoomTypes());

                return res;    
            }
            ModelAndView res = new ModelAndView("welcome");
            return res;
		}
    }



}
