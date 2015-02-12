package testbdd1.model;

public class Client extends Personne {

	private static final long serialVersionUID = 5011412684825868011L;

	private String reference;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Client() {
	}

	public Client(String string) {
		super.id = string;
	}

	@Override
	public String toString() {
		return super.toString() + " Client [reference=" + reference + "]";
	}

}
