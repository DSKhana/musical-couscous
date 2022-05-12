package pollResidencial;

public class PollVO {
	private long number;
	private String name;
	private int votes;
	
	public PollVO() {
		
	}

	public PollVO(long number, String name, int votes) {
		super();
		this.number = number;
		this.name = name;
		this.votes = votes;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		return "PollVO [number=" + number + ", name=" + name + ", votes=" + votes + "]";
	}
}
