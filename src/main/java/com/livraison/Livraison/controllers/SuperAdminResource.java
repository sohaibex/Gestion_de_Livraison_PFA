package com.livraison.Livraison.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/SuperAdmin")
public class SuperAdminResource {
  /*  private final SuperAdminService superAdminService;

    public SuperAdminResource(SuperAdminService superAdminService) {
        this.superAdminService = superAdminService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SuperAdmin>> getAllSuperAdmins()
    {
        List<SuperAdmin> superAdmins = superAdminService.getAllSuperAdmin();
        return new ResponseEntity<>(superAdmins, HttpStatus.OK);
    }

    @GetMapping("/getSuperAdmin/{id}")
    public ResponseEntity<SuperAdmin> getAllSuperAdminsById(@PathVariable("id") Long id)
    {
        SuperAdmin superadmin = superAdminService.getSuperAdminById(id);
        return new ResponseEntity<>(superadmin, HttpStatus.OK);
    }

    @PostMapping("/AddSuperAdmin")
    public ResponseEntity<SuperAdmin> addSuperAdmin(@RequestBody SuperAdmin superadmin)
    {
        SuperAdmin newSuperAdmin = superAdminService.addSuperAdmin(superadmin);
        return new ResponseEntity<>(newSuperAdmin, HttpStatus.CREATED);
    }

    @PutMapping("/updateSuperAdmin")
    public ResponseEntity<SuperAdmin> updateSuperAdmin(@RequestBody SuperAdmin superadmin)
    {
        SuperAdmin updateSuperAdmin = superAdminService.updateSuperAdmin(superadmin);
        return new ResponseEntity<>(updateSuperAdmin, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteSuperAdmin(@PathVariable("id") Long id)
    {
       superAdminService.deleteSuperAdmin(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }*/
}
