package br.com.hildo.login.ws.login;


import br.com.hildo.login.model.request.ResourceRequest;
import br.com.hildo.login.model.request.WeaponRequest;
import br.com.hildo.login.model.response.ResourceResponse;
import br.com.hildo.login.model.response.WeaponResponse;
import br.com.hildo.login.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/weapons")
@CrossOrigin(origins = "http://localhost:3000")
public class WeaponController {

    @Autowired
    private WeaponService weaponService;

    @PostMapping
    public ResponseEntity<WeaponResponse> createWeapon(@RequestBody WeaponRequest weaponRequest) {
        WeaponResponse weaponResponse = weaponService.create(weaponRequest);
        return ResponseEntity.ok(weaponResponse);
    }

    @GetMapping
    public ResponseEntity<List<WeaponResponse>> getAllWeapons() {
        List<WeaponResponse> weapons = weaponService.getAll();
        return ResponseEntity.ok(weapons);
    }


    @GetMapping("/{id}")
    public ResponseEntity<WeaponResponse> getWeaponById(@PathVariable Long id) {
        Optional<WeaponResponse> weaponResponse = weaponService.get(id);
        return weaponResponse.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<WeaponResponse> updateWeapon(@PathVariable Long id, @RequestBody WeaponRequest weaponRequest) {
        Optional<WeaponResponse> weaponResponse = weaponService.update(id, weaponRequest);
        return weaponResponse.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWeapon(@PathVariable Long id) {
        if (weaponService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
