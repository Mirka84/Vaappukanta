package fi.harjoitustyo.syksy2021.vaappukanta.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fi.harjoitustyo.syksy2021.vaappukanta.domain.Malli;
import fi.harjoitustyo.syksy2021.vaappukanta.domain.MalliRepository;
import fi.harjoitustyo.syksy2021.vaappukanta.domain.Vaappu;
import fi.harjoitustyo.syksy2021.vaappukanta.domain.VaappuRepository;


@Controller
public class VaappuController {
	
	@Autowired
	private VaappuRepository repository; 
	
	@Autowired
	private MalliRepository mrepository; 
	
/*nayta vaaput*/
	
	@RequestMapping(value="/vaappulista", method = RequestMethod.GET)
	public String vaappuList(Model model) {
		model.addAttribute("vaaput", repository.findAll()); 
		return "vaappulista"; 
		
	}
	
 /* Vaaput-jsonina*/
	
	@RequestMapping(value="/vaaput", method = RequestMethod.GET)
    public @ResponseBody List<Vaappu> vaappuListRest() {	
        return (List<Vaappu>) repository.findAll();
    }  
	
//* mallit jsonina *//
	
	@RequestMapping(value="/mallit", method = RequestMethod.GET)
    public @ResponseBody List<Malli> malliListRest() {	
        return (List<Malli>) mrepository.findAll();
    }  

//lisaa uusi vaappu
	@RequestMapping(value="/lisaavaappu", method=RequestMethod.GET)
	public String addVaappu(Model model) {
		model.addAttribute("vaappu", new Vaappu()); 
		model.addAttribute("malli", mrepository.findAll()); 
		return "lisaavaappu"; 
}

 @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid Vaappu vaappu, BindingResult bindingResult, Model model){
	 	if(bindingResult.hasErrors()) { 
			model.addAttribute("malli", mrepository.findAll()); 
	 		return "redirect:lisaavaappu"; 
	 	}
        repository.save(vaappu); 
        return "redirect:/vaappulista"; 
    } 
 
 @PreAuthorize("hasAuthority('ADMIN')")
 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
 public String deleteVaappu(@PathVariable("id") Long vaappuId, Model model) {
	 repository.deleteById(vaappuId); 
	 return "redirect:../vaappulista"; 
 }
 
 @PreAuthorize("hasAuthority('ADMIN')")
 @RequestMapping(value ="/edit/{id}")
 public String addVaappu(@PathVariable("id") Long vaappuId, Model model) {
	 model.addAttribute("vaappu", repository.findById(vaappuId));  
	 model.addAttribute("malli", mrepository.findAll()); 
	 return "paivitavaappu"; 
 }


}
