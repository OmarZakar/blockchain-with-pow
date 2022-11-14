package blockch;
import java.util.Date;
// In this code I implemented proof of work  
public class Block {
	public String hash;
	public String previousHash;
	private String data;
	private long timeStamp;
	private int nonce;

	public Block(String data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
	}

	public String calculateHash() {
		String calculatedhash = Crypt.sha256(previousHash + Long.toString(timeStamp)+Integer.toString(nonce) + data);
		return calculatedhash;
	} 
	// minning blocks process 
	public String mineBlock(int prefix) {
		String prefixString = new String(new char[prefix]).replace('\0', '0');
		while (!hash.substring(0, prefix).equals(prefixString)) {
			nonce++;
			hash = calculateHash();
		}
		return hash;
	}

	public String toSting() {
		String s = "---------------------------\n";
		s += "hash : " + hash + "\n";
		s += "previousHash : " + previousHash + "\n";
		s += "data : " + data + "\n";
		s += "timeStamp : " + timeStamp + "\n";
		s += "proof of work : " + nonce + "\n";
		s += "---------------------------";
		return s;
	}
}
