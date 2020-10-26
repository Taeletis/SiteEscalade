package com.escalade.oc;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.dao.DaoGrimpeur;

class TestJPAv2 {

	@Autowired
	DaoGrimpeur dao;
	@Test
	void test() {
		
		Grimpeur g = new Grimpeur("toto","2","test","mdp");
		
			g = dao.save(g);
			assertTrue(true);
	
	}

}
