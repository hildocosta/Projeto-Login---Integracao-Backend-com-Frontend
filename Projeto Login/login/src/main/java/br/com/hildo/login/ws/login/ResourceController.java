package br.com.hildo.login.ws.login;


import br.com.hildo.login.model.request.ResourceRequest;

import br.com.hildo.login.model.response.ResourceResponse;
import br.com.hildo.login.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resources")
@CrossOrigin(origins = "http://localhost:3000")
public class ResourceController {


    @Autowired
    private ResourceService resourceService;

    @PostMapping
    public ResponseEntity<ResourceResponse> createResource(@RequestBody ResourceRequest resourceRequest) {
        ResourceResponse resourceResponse = resourceService.create(resourceRequest);
        return ResponseEntity.ok(resourceResponse);
    }

    @GetMapping
    public ResponseEntity<List<ResourceResponse>> getAllResources() {
        List<ResourceResponse> resources = resourceService.getAll();
        return ResponseEntity.ok(resources);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResourceResponse> getResourceById(@PathVariable Long id) {
        Optional<ResourceResponse> resourceResponse = resourceService.get(id);
        return resourceResponse.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResourceResponse> updateResource(@PathVariable Long id, @RequestBody ResourceRequest resourceRequest) {
        Optional<ResourceResponse> resourceResponse = resourceService.update(id, resourceRequest);
        return resourceResponse.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResource(@PathVariable Long id) {
        if (resourceService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
