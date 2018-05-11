package Question11_2;

import java.util.ArrayList;

public class Person {
	private ArrayList<Integer> friends;
	private int ID;
	private int machineID;
	private String info;
	private Server server = new Server();
	
	public String getInfo() { return info; }
	public void setInfo(String info) {
		this.info = info;
	}

	public int[] getFriends() {
		int[] temp = new int[friends.size()];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = friends.get(i);
		}
		return temp;
	}
	public int getID() { return ID; }
	public int getMachineID() { return machineID; }
	public void addFriend(int id) { friends.add(id); }
	
	// Look up a person given their ID and Machine ID
	public Person lookUpFriend(int machineID, int ID) {
		for (Machine m : server.machines) {
			if (m.machineID == machineID) {
				for (Person p : m.persons) {
					if (p.ID == ID){
						return p;						
					}
				}
			}
		}
		return null;
	}
	
	// Look up a machine given the machine ID
	public Machine lookUpMachine(int machineID) {
		for (Machine m : server.machines) {
			if (m.machineID == machineID)
				return m;
		}
		return null;
	}
	
	public Person(int iD, int machineID) {
		ID = iD;
		this.machineID = machineID;
	}
}
