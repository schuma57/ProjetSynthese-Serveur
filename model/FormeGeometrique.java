package model;

public abstract class FormeGeometrique
{
	private String nom;
	
	public String getNom()
	{
		return nom;
	}
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	abstract void afficher();
}
