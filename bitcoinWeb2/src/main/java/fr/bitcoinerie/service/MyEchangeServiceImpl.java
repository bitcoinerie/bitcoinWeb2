package fr.bitcoinerie.service;

import fr.bitcoinerie.domain.Echange.MyEchange;
import fr.bitcoinerie.domain.User.MyUser;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

public class MyEchangeServiceImpl implements MyEchangeService {
    @Inject
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void saveEchange(MyEchange echange) {
        Session session = sessionFactory.getCurrentSession();

        session.save(echange);
    }

    @Override
    @Transactional
    public void deleteEchange(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from MyEchange where id = :id");
        query.setLong("id", id);

        query.executeUpdate();

    }

    @Override
    @Transactional(readOnly = true)
    public List<MyEchange> findAllEchange() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(" from MyEchange ");

        List<MyEchange> myEchanges= query.list();


        return myEchanges;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MyEchange> findByEmetteurEchange(String query) {
        Session session = sessionFactory.getCurrentSession();

        Criteria criteria = session.createCriteria(MyEchange.class);

        criteria.add(Restrictions.ilike("emetteur", query, MatchMode.ANYWHERE));

        List<MyEchange> myEchanges = criteria.list();

        return myEchanges;
    }
    @Transactional
    public MyEchange findOneEchange (String emetteur,String recepteur){
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(MyEchange.class);
        criteria.add(Restrictions.and(Restrictions.ilike("emetteur", emetteur, MatchMode.ANYWHERE),
                Restrictions.ilike("recepteur", recepteur, MatchMode.ANYWHERE)));

        List<MyEchange> myEchanges = criteria.list();
        MyEchange echange = myEchanges.get(0) ;

        return echange;
    }

    @Transactional
    @Override
    public int count() {
        // TODO
        return findAllEchange().size();
    }

    /*@Override
    @Transactional
    public void saveMyUser(MyUser user) {
        Session session = sessionFactory.getCurrentSession();
        List<MyEchange> existe= findByQueryTransaction( user);
        List<MyEchange>echanges=findAllTransaction();
        int n=echanges.size();

        for (int j=1;j<= n;j++){
            MyUser myuser=echanges.get(j).getEmetteur();

            MyEchange myEchange= new MyEchange((double) 0,user,myuser);
            saveTransaction(myEchange) ;
            MyEchange monEchange= new MyEchange((double) 0,user,user);
            saveTransaction(monEchange) ;
            MyEchange tonEchange= new MyEchange((double) 0,myuser,user);
            saveTransaction(tonEchange) ;
        }
    }    */
    @Transactional
    //@Override
    public void majEchange(double montant, MyUser emetteur, MyUser recepteur) {
        List<MyEchange>echanges=findAllEchange();

    }



}