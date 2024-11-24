package com.pms.service;

import com.pms.model.Drug;
import com.pms.repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugService {

    @Autowired
    private DrugRepository drugRepository;

    public List<Drug> getAllDrugs() {
        return drugRepository.findAll();
    }

    public Drug getDrugById(Long id) {
        return drugRepository.findById(id).orElse(null);
    }

    public Drug saveDrug(Drug drug) {
        return drugRepository.save(drug);
    }

    public Drug updateDrug(Drug drug) {
        Drug existingDrug = drugRepository.findById(drug.getId()).orElse(null);
        if (existingDrug != null) {
            existingDrug.setName(drug.getName());
            existingDrug.setDescription(drug.getDescription());
            existingDrug.setPrice(drug.getPrice());
            existingDrug.setExpiryDate(drug.getExpiryDate());
            existingDrug.setSupplierName(drug.getSupplierName());
            existingDrug.setTotalQuantity(drug.getTotalQuantity());
            existingDrug.setBanned(drug.isBanned());
            existingDrug.setBannedReason(drug.getBannedReason());
            return drugRepository.save(existingDrug);
        }
        return null;
    }

    public void deactivateDrug(Long id) {
        Drug drug = drugRepository.findById(id).orElse(null);
        if (drug != null) {
            drug.setActive(false);
            drugRepository.save(drug);
        }
    }
    public void deleteDrug(Long id) {
        drugRepository.deleteById(id);
    }
}