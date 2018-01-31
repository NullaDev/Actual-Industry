package cn.nulladev.actualindustry.task;

import java.util.ArrayList;
import java.util.List;

public class MIDITaskList {
	
	public static final MIDITaskList INSTANCE = new MIDITaskList();
	
	final List<Task> tasks = new ArrayList<Task>();
	
	public void add(Task t) {
		tasks.add(t);
	}
	
	public void clear() {
		tasks.clear();
	}

}
