package thermodynamic;

public class Force
{
	public String name;
	
	@SuppressWarnings(value = {"unused"})
	private float force, vector;
	
	public Force(String name) {
		this.name = name;
		this.force = 0;
		this.vector = 0;
	}
	
	public Force(String name, float newtons,float vector) {
		this(name);
		this.force = newtons;
		this.vector = vector;
	}
	
	public void setName(String par1) {this.name = par1;}
	public void setForce(float par1) {this.force = par1;}
	public void setVector(float par1) {this.vector = par1;}
	public float getForce() { return this.force;}
	public float getVector() { return this.vector;}
}
