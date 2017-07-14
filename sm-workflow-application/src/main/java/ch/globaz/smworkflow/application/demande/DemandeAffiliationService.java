package ch.globaz.smworkflow.application.demande;

import ch.globaz.smworkflow.domain.demande.api.entity.Demande;
import ch.globaz.smworkflow.domain.demande.service.DemandeService;
import ch.globaz.smworkflow.domain.repository.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sce on 13.07.2017.
 */
@Service
public class DemandeAffiliationService implements DemandeService {

    @Autowired
    DemandeRepository demandeRepository;




    @Override
    public Demande sauveDemande(Demande demande) {
        return demandeRepository.create(demande);
    }
}
