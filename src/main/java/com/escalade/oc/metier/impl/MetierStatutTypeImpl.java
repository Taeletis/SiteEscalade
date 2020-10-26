package com.escalade.oc.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.escalade.oc.beans.StatutType;
import com.escalade.oc.dao.DaoStatutType;
import com.escalade.oc.metier.MetierStatutType;

public class MetierStatutTypeImpl implements MetierStatutType{
	@Autowired
	private DaoStatutType daoStatutType;

	@Override
	public StatutType ajouterMetierStatutType(String statut) {
		StatutType s =new StatutType(statut);
		try {
			s=daoStatutType.save(s);
		}catch(Exception e) {
			
		}
		return s;
		
	}

	@Override
	public StatutType modifierMetierStatutType(String statut, StatutType s) {
		s.setStatut(statut);
		try {
			s=daoStatutType.save(s);
		}catch(Exception e) {
			
		}
		return s;
	}

	@Override
	public void supprimerMetierStatutType(StatutType s) {
		try {
			daoStatutType.delete(s);
		}catch(Exception e) {
			
		}

	}

	@Override
	public StatutType trouverMetierStatutType(Long id) {
		StatutType s =null;
		try {
			s=daoStatutType.getOne(id);
		}catch(Exception e) {
			
		}
		return s;
	}

	@Override
	public List<StatutType> listeTousMetierStatutType() {
		List<StatutType> list=null;

		try {
			list = daoStatutType.findAll();
					
			
		} catch (Exception e) {

		}
		return list;
	}

}
