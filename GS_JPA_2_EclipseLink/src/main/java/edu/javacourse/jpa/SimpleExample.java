package edu.javacourse.jpa;

import edu.javacourse.jpa.entity.City;
import edu.javacourse.jpa.entity.Region;
import edu.javacourse.jpa.manager.RegionManager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SimpleExample {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence
				.createEntityManagerFactory("unitEclipseLink");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		RegionManager rm = new RegionManager();
		rm.init();

		Region r = new Region();

		City c = new City();
		List<City> listcity = new ArrayList<City>();

		r.setCityList(listcity);
		r.setRegionId(15);
		r.setRegionName("sarvesh");

		c.setCityId(15);
		c.setCityName("sarvesh");
		c.setRegionId(r);

		entitymanager.persist(c);
		entitymanager.persist(r);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();

		firstSelect(rm);
		secondSelect(rm);
	}

	private static void firstSelect(RegionManager rm) {
		System.out.println("First Select ===>");
		List<Region> result = rm.getRegionList();
		for (Region r : result) {
			System.out.println(r);
		}
	}

	private static void secondSelect(RegionManager rm) {
		System.out.println("Second Select ===>");
		List<Region> result = rm.getRegionList2();
		for (Region r : result) {
			System.out.println(r);
		}
	}
}
