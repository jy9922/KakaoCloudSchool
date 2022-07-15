package com.computer;

public abstract class Computer {
	private String name;
	private int cpu;
	private int memory;
	private int batterty;
	
	public Computer(){
		
	}
	
	public Computer(String name, int cpu, int memory, int battery) {
		this.setName(name);
		this.setCpu(cpu);
		this.setMemory(memory);
		this.setBatterty(battery);
	
	}
	public abstract void operate(int time);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCpu() {
		return cpu;
	}

	public void setCpu(int cpu) {
		this.cpu = cpu;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public int getBatterty() {
		return batterty;
	}

	public void setBatterty(int batterty) {
		this.batterty = batterty;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName() + " " + getCpu() + " " + getMemory() + " " + getBatterty();
	}
}
