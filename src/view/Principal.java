package view;

import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class Principal {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
	}

}
