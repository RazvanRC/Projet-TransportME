package fr.transportME.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public abstract class DAO<T>
{
	public abstract T find(int id);
	public abstract List<T> findAll();
	public abstract T save(T object);
	public abstract T auth(String login, String mdp);
}