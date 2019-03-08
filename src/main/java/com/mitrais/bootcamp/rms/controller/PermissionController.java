package com.mitrais.bootcamp.rms.controller;
//import io.github.jhipster.web.util.ResponseUtil;

import com.mitrais.bootcamp.rms.controller.util.HeaderUtil;
import com.mitrais.bootcamp.rms.controller.util.ResponseUtil;
import com.mitrais.bootcamp.rms.domain.Permission;
import com.mitrais.bootcamp.rms.exception.EntityNotFoundException;
import com.mitrais.bootcamp.rms.repository.PermissionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/permissions")
public class PermissionController {
    private final String ENTITY_NAME = "Permission";
    private final PermissionRepository repository;
    Logger log = LoggerFactory.getLogger(PermissionController.class);
    public PermissionController(PermissionRepository repo) {
        this.repository = repo;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Permission>> findAll(Pageable pg) throws URISyntaxException{
        final Page<Permission> page = repository.findAll(pg);
        //HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "api/users");
        return new ResponseEntity<>(page, HttpStatus.OK);

    }

    @GetMapping("all")
    public Iterable<Permission> findAll2() throws URISyntaxException{
        return repository.findAll();

    }

    @PostMapping
    public ResponseEntity<Permission> create(@RequestBody Permission permission) throws URISyntaxException {
        log.debug("REST request to save Permission {}", permission);
        if(permission.getId()!=null){
            return null;//update(user);
        }
        if(repository.findByName(permission.getName()).isPresent()){
            return ResponseEntity
                    .badRequest()
                    .headers(HeaderUtil.createFailureAlert(ENTITY_NAME,
                            "permissionExists", "Permission '"+ permission.getName()+"' already exists"))
                    .body(null);

        }else{
            Permission newPermission = repository.save(permission);
            return ResponseEntity.created(new URI("/api/setting/permissions/" + newPermission.getId()))
                    .headers(HeaderUtil.createAlert( "A Permission is created with identifier " + newPermission.getId(), String.valueOf(newPermission.getId())))
                    .body(newPermission);
        }
    }

   @PutMapping
    public ResponseEntity<Permission> update(@RequestBody Permission permission) throws URISyntaxException {
        log.debug("REST request to save Permission {}", permission);
        Optional<Permission> existingUser = repository.findByName(permission.getName());
        if (existingUser.isPresent() && (!existingUser.get().getId().equals(permission.getId()))) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "nameExists", "Username already in use")).body(null);
        }
        Optional<Permission> updatedUser = Optional.of(repository.save(permission));

        return ResponseUtil.wrapOrNotFound(updatedUser,
                HeaderUtil.createAlert("A Permission is updated with identifier " + permission.getName(),
                        permission.getName()));
    }

    @Transactional
    @GetMapping("{id}")
    public Permission findOne(@PathVariable Long id)  throws EntityNotFoundException {
        log.debug("REST request to get Permission by id : {}", id);

        Optional<Permission> result = repository.findById(id);
        if (!result.isPresent()) {
            throw new EntityNotFoundException(Permission.class, "id", String.valueOf(id));
        }
        return result.get();

    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        log.debug("REST request to delete User: {}", id);
        repository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createAlert("A User is deleted with identifier: "+id, String.valueOf(id))).build();
    }

}
