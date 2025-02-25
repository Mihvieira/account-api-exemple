package com.example.api_rest.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.api_rest.dto.FeatureDTO;
import com.example.api_rest.service.FeatureService;

@RestController
@RequestMapping("/feature")
public class FeatureController {

    private final FeatureService featureService;

    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    @GetMapping
    public ResponseEntity<List<FeatureDTO>> findAll(){
        List<FeatureDTO> list = featureService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeatureDTO> findById(@PathVariable Long id){
        var feature = featureService.findById(id);
        return ResponseEntity.ok(feature);
    }

    @PostMapping
    public ResponseEntity<FeatureDTO> create(@RequestBody FeatureDTO feature){
        var featureCreated = featureService.create(feature);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(featureCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(featureCreated);
    }

    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        featureService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<FeatureDTO> update(@RequestBody FeatureDTO featureToUpdate){
        var feature = featureService.update(featureToUpdate);
        return ResponseEntity.ok().body(feature);
    }
}
