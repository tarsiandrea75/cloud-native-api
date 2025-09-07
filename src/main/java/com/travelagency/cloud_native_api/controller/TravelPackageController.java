package com.travelagency.cloud_native_api.controller;

import com.travelagency.cloud_native_api.model.TravelPackage;
import com.travelagency.cloud_native_api.repository.TravelPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Dice a Spring che questa classe gestisce richieste web API (e risponde con JSON)
@RequestMapping("/api/packages") // L'indirizzo base per tutte le richieste gestite da questo controller
public class TravelPackageController {

    // Iniezione di dipendenza: Spring ci fornirà automaticamente il nostro "magazziniere"
    @Autowired
    private TravelPackageRepository travelPackageRepository;

    /**
     * Endpoint per creare un nuovo pacchetto viaggio.
     * Risponde alle richieste POST su /api/packages.
     * Il @RequestBody dice a Spring di prendere il JSON dalla richiesta e convertirlo in un oggetto TravelPackage.
     */
    @PostMapping
    public ResponseEntity<TravelPackage> createPackage(@RequestBody TravelPackage travelPackage) {
        // Usiamo il metodo save() che Spring ci ha regalato per salvare l'oggetto nel DB
        TravelPackage savedPackage = travelPackageRepository.save(travelPackage);
        return ResponseEntity.ok(savedPackage); // Restituiamo l'oggetto salvato (con il suo nuovo ID)
    }

    /**
     * Endpoint per ottenere tutti i pacchetti viaggio.
     * Risponde alle richieste GET su /api/packages.
     */
    @GetMapping
    public ResponseEntity<List<TravelPackage>> getAllPackages() {
        // Usiamo il metodo findAll() che Spring ci ha regalato per ottenere tutti i record
        List<TravelPackage> packages = travelPackageRepository.findAll();
        return ResponseEntity.ok(packages);
    }
}
