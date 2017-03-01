/*
 *  Copyright 2017 SarahBoka
 */

package com.sarah.debatewebapp.controller;

import com.sarah.debatewebapp.dao.DebateDao;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * @author Sarah
 */
@Controller
public class DisplayPages {
    
    private DebateDao dao;
    
    @Inject
    public DisplayPages(DebateDao dao){
        this.dao = dao;
    }

    @RequestMapping(value={"/","/home"}, method = RequestMethod.GET)
    public String displayHome(){
        return "home";
    }
    
    @RequestMapping(value="/dashboard", method = RequestMethod.GET)
    public String displayDash(Model model){
        
        List<String> categories = dao.getAllCategories();
        model.addAttribute("categories", categories);
        return "dashboard";
    }
    
    
}
