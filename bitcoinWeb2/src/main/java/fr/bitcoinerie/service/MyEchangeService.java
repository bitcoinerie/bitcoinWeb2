package fr.bitcoinerie.service;

import fr.bitcoinerie.domain.Echange.MyEchange;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: philippe
 * Date: 20/01/14
 * Time: 12:46
 * To change this template use File | Settings | File Templates.
 */
public interface MyEchangeService {
    @Transactional
    void saveEchange(MyEchange echange);

    @Transactional
    void deleteEchange(Long id);

    @Transactional(readOnly = true)
    List<MyEchange> findAllEchange();

    @Transactional(readOnly = true)
    List<MyEchange> findByEmetteurEchange(String query);

    @Transactional(readOnly = true)
    int countEchange();
}
