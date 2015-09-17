package br.com.cast.turmaformacao.taskmanager.model.services;

import java.util.List;

import br.com.cast.turmaformacao.taskmanager.model.entities.Label;
import br.com.cast.turmaformacao.taskmanager.model.persistence.LabelRepository;


/**
 * Created by Administrador on 17/09/2015.
 */
public class LabelBusinessService {

    private LabelBusinessService() {
        super();
    }

    public static List<Label> findAll(){
        return LabelRepository.getAll();
    }
    public static void save(Label label){
        LabelRepository.save(label);

    }
    public static void delete(Label selectedLabel) {
        LabelRepository.delete(selectedLabel.getId());
    }
}
