package com.loicmaria.webapp.web.controller;

import com.loicmaria.webapp.form.UserForm;
import com.loicmaria.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @ModelAttribute
    public void addAttributes(Model model){
    }

    /**
     * Afficher les détails de l'utilisateur connecté.
     * @return La page de détails.
     */

    @GetMapping("/id")
    public String getUserById(){
        return "user/detailsUser";
    }

    /**
     * Afficher le formulaire pour créer un utilisateur.
     * @param model Contient les données à afficher.
     * @return La page de création d'un utilisateur.
     */

    @GetMapping("/create")
    public String userForm(Model model){
        model.addAttribute("user", new UserForm());
        return "user/createUser";
    }

    /**
     * Créer un nouvel utilisateur.
     * @param userForm Les informations à intégrer à son compte.
     * @return La page de connexion.
     */

    @PostMapping("/create")
    public String createUser(@ModelAttribute UserForm userForm){
        userService.createUser(userForm);
        return "login";
    }

    /**
     * Afficher la page pour modifier l'utilisateur connecté.
     * @param id L'ID du compte utilisateur à modifier.
     * @param model Contient les données à afficher.
     * @return La page avec le formulaire permettant la modification.
     */

    @GetMapping("/edition")
    public String userEditForm(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("user", userService.getUser(id));
        model.addAttribute("id", id);
        return "user/editionUser";
    }

    /**
     *  Modifier l'utilisateur connecté.
     * @param id L'ID du compte utilisateur à modifier.
     * @param model Contient les données à afficher.
     * @param userForm Les informations à intégrer au compte utilisateur.
     * @return La page détail de l'utilisateur connecté.
     */

    @PutMapping("/edition/{id}")
    public String updateUser(@PathVariable(value = "id") int id, Model model, UserForm userForm){
        userService.updateUser(id, userForm);
        model.addAttribute("user", userService.getUser(id));
        System.out.println("Édition user");
        return "user/detailsUser";
    }

    /**
     * Supprimer le compte d'un utilisateur connecté.
     * @param id L'ID du compte à supprimer.
     * @param model Contient les données à afficher.
     * @return La page confirmant la suppression du compte.
     */

    @GetMapping("/delete")
    public String deleteUser(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("user", userService.getUser(id));
        userService.deleteUser(id);
        return "user/deleteUser";
    }

}
