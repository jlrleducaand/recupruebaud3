package org.iesvdm.pruebarecuud3.controlador;

import org.iesvdm.pruebarecuud3.modelo.Persona;
import org.iesvdm.pruebarecuud3.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }


    @GetMapping("/personas") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
    public String listarPersonas(Model model) {

        List<Persona> listPersonas = personaService.listAll();
        model.addAttribute("listPersonas", listPersonas);

        return "personas";

    }
    @GetMapping("/personas/crear")
    public String getCrearPersona(Model model) {



        Persona persona = new Persona();
        model.addAttribute("persona", persona);

//        List<Persona> lstIdioma = personaService.listIdioma();
//        model.addAttribute("listaIdiomas", lstIdioma);
//
//        List<Categoria> lstCat = personaService.listCategoria();
//        model.addAttribute("listaCategoria", lstCat);

        return "crear-persona";
    }

    @PostMapping("/personas/crear")
    public RedirectView postCrearPersona(@ModelAttribute("persona") Persona persona) {

//		if(bindingResult.hasErrors()){
//			model.addAttribute("persona", persona);
//			return "crear-persona";
//		}
//
//		personaService.newPersona(persona);
//		return "redirect:/personas?newPersonaID=" + persona.getId();




        personaService.create(persona);

        return new RedirectView("/personas");
    }
}





