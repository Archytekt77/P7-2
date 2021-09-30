package com.loicmaria.webapp.web.controller;

public class UserController {
/*

    @Autowired
    UserServiceImpl userService;
    @Autowired
    RoleServiceImpl roleService;

    /**
     * Afficher les détails de l'utilisateur connecté.
     * @param model Contient les données à afficher.
     * @return La page de détails.

    @GetMapping("/details")
    public String getUserById(Model model){
        model.addAttribute("user", userService.getLoggedUser());
        return "user/detailsUser";
    }

    /**
     * Afficher le formulaire pour créer un utilisateur.
     * @param model Contient les données à afficher.
     * @return La page de création d'un utilisateur.
     *
    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("user", new User());
        return "user/createUser";
    }

    /**
     * Créer un nouvel utilisateur.
     * @param user Les informations à intégrer à son compte.
     * @return La page de connexion.
     *
    @PostMapping("/create")
    public String addUser(@ModelAttribute User user){
        userService.add(user);
        return "login";
    }

    /**
     * Afficher la page pour modifier l'utilisateur connecté.
     * @param id L'ID du compte utilisateur à modifier.
     * @param model Contient les données à afficher.
     * @return La page avec le formulaire permettant la modification.
     *
    @GetMapping("/edition")
    public String editionUser(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("user", userService.get(id));
        model.addAttribute("id", id);
        return "user/editionUser";
    }

    /**
     *  Modifier l'utilisateur connecté.
     * @param id L'ID du compte utilisateur à modifier.
     * @param model Contient les données à afficher.
     * @param user Les informations à intégrer au compte utilisateur.
     * @return La page détail de l'utilisateur connecté.
     *
    @PostMapping("/edition/{id}")
    public String updateUser(@PathVariable(value = "id") int id, Model model, User user){
        userService.update(user);
        model.addAttribute("user", userService.get(id));
        return "user/detailsUser";
    }

    /**
     * Supprimer le compte d'un utilisateur connecté.
     * @param id L'ID du compte à supprimer.
     * @param model Contient les données à afficher.
     * @return La page confirmant la suppression du compte.
     *
    @GetMapping("/delete")
    public String deleteUser(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("user", userService.get(id));
        userService.delete(id);
        return "user/deleteUser";
    }



    //  Topo, Climbing Site and route

    /**
     * Afficher les Topo créés par l'utilisateur connecté.
     * @param model Contient les données à afficher.
     * @return La page avec la liste des Topos de l'utilisateur connecté.
     *
    /*@GetMapping("/topo")
    public String getToposByUser(Model model){
        model.addAttribute("toposList", topoService.findByUser_Id(userService.getLoggedUser().getId()));
        return "topo/getTopo";
    }
*
    /**
     * Afficher les sites créés par l'utilisateur connecté.
     * @param model Contient les données à afficher.
     * @return La page avec la liste des sites de l'utilisateur connecté.
     */
    /*@GetMapping("/climbing-site")
    public String getClimbingSiteByUser(Model model){
        model.addAttribute("searchClimbingSite",new ClimbingSite());
        model.addAttribute("climbingSitesList", climbingSiteService.findByUser_Id(userService.getLoggedUser().getId()));
        return "climbingSite/getClimbingSite";
    }
*
    /**
     * Afficher les voies créées par l'utilisateur connecté.
     * @param model Contient les données à afficher.
     * @return La page avec la liste des voies de l'utilisateur connecté.
     *
    /*@GetMapping("/route")
    public String getRouteByUser(Model model){
        model.addAttribute("routesList", routeService.findByUser_Id(userService.getLoggedUser().getId()));
        return "route/getRoute";
    }
*/
}
