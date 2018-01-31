package cn.nulladev.actualindustry.task;

public class Task {
	
	int ticks;
	int rest_ticks;
	Runnable task;
	
	public Task(int _ticks, Runnable _task) {
		this.ticks = _ticks;
		this.rest_ticks = this.ticks;
		this.task = _task;
	}
	
	public void execute() {
		System.out.println("execute");
		this.task.run();
	}

}
